package guiElements;

import java.util.ArrayList;

import BattleSystem.Battle;
import attacks.FullAttack;
import attacks.Move;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Player;
import utilities.FileManager;

public class BattleSelectionPane {
	
	ArrayList<Move> priorityAttacks = new ArrayList<Move>();
	ArrayList<Move> attacks = new ArrayList<Move>();
	
	ArrayList<Move> attackList = new ArrayList<Move>();
	ArrayList<Move> unusableAttacks = new ArrayList<Move>();
	
	ArrayList<BattleSelectionTab> choices = new ArrayList<BattleSelectionTab>();
	
	int timeCounter;
	int maxTime;
	
	VBox container = new VBox(5);
	ScrollPane scrollPane = new ScrollPane();
	VBox attackRows = new VBox(5);
	HBox[] rows;
	HBox rowOne = new HBox(5);
	Label timeLeft = new Label();
	Button clearButton = new Button("Clear"); 
	Button submitButton = new Button ("Attack!");
	
	BattleScene arena = null;
	Player player = null;
	
	public BattleSelectionPane (){
		FileManager manager = new FileManager();
		attackList.add(manager.loadMove("Punch"));
		attackList.add(manager.loadMove("Kick"));
		attackList.add(manager.loadMove("Spit"));
		
		this.rows = new HBox[(this.attackList.size()/3) + 1];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new HBox(5);
		}
		player = new Player("Sample", "A Man");
		player.getBattleStats().setBattleStats(player);
		this.maxTime = 2000;
		this.timeCounter = 0;
		this.resetList();
		this.setLayout();
	}
	public BattleSelectionPane (BattleScene arena, Player player) {
		this.arena = arena;
		this.player = player;
		//this.attackList = player.getAttacks().getMoveList();
		FileManager manager = new FileManager();
		attackList.add(manager.loadMove("Punch"));
		attackList.add(manager.loadMove("Kick"));
		attackList.add(manager.loadMove("Spit"));
		//*****************************************************
		this.rows = new HBox[(this.attackList.size()/3) + 1];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new HBox(3);
		}
		this.maxTime = player.getBattleStats().getActionTime();
		this.timeCounter = 0;
		this.resetList();
		this.setLayout();
	}
	private void setLayout() {
		for (int i = 0; i < rows.length; i++) {
			attackRows.getChildren().add(rows[i]);
		}
		scrollPane.setContent(attackRows);
		scrollPane.setMinSize(350, 184);
		scrollPane.setMaxSize(350, 184);
		this.setButtons();
		timeLeft.setText("Time: " + timeCounter + "/" + player.getBattleStats().getActionTime() + "\t Energy: " + player.getBattleStats().getCurrentEnergy());
		timeLeft.setStyle("-fx-text-fill: WHITE;");
		
		rowOne.getChildren().addAll(submitButton, clearButton);
		container.getChildren().addAll(rowOne, timeLeft, scrollPane);
		
	}
	public void resetList () {
		int counter = 0;
		choices.clear();
		for (int i = 0; i < rows.length; i++) {
			rows[i].getChildren().clear();
		}
		while (counter < attackList.size()) {
			Move attack = this.attackList.get(counter);
			if (this.isAttackUsable(attack)) {
				BattleSelectionTab theTab = new BattleSelectionTab(attack, arena, counter);
				choices.add(theTab);
				theTab.getContainer().setOnMouseClicked(e->{
					if (attack.isPriority()) {
						this.priorityAttacks.add(attack);
						BattleSimpleTab tab = new BattleSimpleTab(this.attackList.get(theTab.getIndex()), this.player);
						this.arena.getActionTime().getPriorityTabs().getChildren().add(tab.getContainer());
						this.applyUse(attack);		
					}
					else {
						this.attacks.add(attack);
						BattleSimpleTab tab = new BattleSimpleTab(this.attackList.get(theTab.getIndex()), this.player);
						this.arena.getActionTime().getNormalTabs().getChildren().add(tab.getContainer());
						this.applyUse(attack);
					}
					timeLeft.setText("Time: " + timeCounter + "\t Energy: " + player.getBattleStats().getCurrentEnergy());
					this.resetList();
				});
				rows[counter/3].getChildren().add(choices.get(counter).getContainer());
			}
			counter++;
		}
		
	}
	public boolean isAttackUsable (Move attack) {
		boolean usable = false;
		int energyCost = attack.getEnergyCost();
		if (this.player.getBattleStats().isFreecasting()) {
			energyCost = 0;
		}
		if (this.player.getBattleStats().isExhausted()) {
			energyCost *= 2;
		}
		if (attack.getCooldownCounter() == 0 && 
				(this.player.getBattleStats().getCurrentComboPoints() >= attack.getComboPointRequirement()) &&
				(this.player.getBattleStats().getCurrentEnergy() >= energyCost) &&
				attack.getUses() > 0 &&
				(this.timeCounter + attack.getTime() - this.player.getBattleStats().getHaste()) < this.maxTime) {
			usable = true;
		}
		
		return usable;
	}
	
	public void applyUse (Move attack) {
		attack.setCooldownCounter(attack.getCooldown());
		attack.setCurrentUses(attack.getCurrentUses() - 1);
		int energyCost = attack.getEnergyCost();
		if (this.player.getBattleStats().isFreecasting()) {
			energyCost = 0;
		}
		if (this.player.getBattleStats().isExhausted()) {
			energyCost *= 2;
		}
		player.getBattleStats().setCurrentEnergy(player.getBattleStats().getCurrentEnergy() - energyCost);
		player.getBattleStats().setCurrentComboPoints(player.getBattleStats().getCurrentComboPoints() + attack.getComboPointGain());
		this.timeCounter += (attack.getTime() - this.player.getBattleStats().getHaste());
	}
	public void undoUse (Move attack) {
		attack.setCooldownCounter(0);
		attack.setCurrentUses(attack.getCurrentUses() + 1);
		int energyCost = attack.getEnergyCost();
		if (this.player.getBattleStats().isFreecasting()) {
			energyCost = 0;
		}
		if (this.player.getBattleStats().isExhausted()) {
			energyCost *= 2;
		}
		player.getBattleStats().setCurrentEnergy(player.getBattleStats().getCurrentEnergy() + energyCost);
		player.getBattleStats().setCurrentComboPoints(player.getBattleStats().getCurrentComboPoints() - attack.getComboPointGain());
		this.timeCounter -= attack.getTime() - this.player.getBattleStats().getHaste();
	}
	public void resetActions() {
		for (int i = 0; i < this.priorityAttacks.size(); i++) {
			this.undoUse(this.priorityAttacks.get(i));
		}
		this.priorityAttacks.clear();
		for (int i = 0; i < this.attacks.size(); i++) {
			this.undoUse(attacks.get(i));
		}
		this.arena.getActionTime().clearTabs();
		this.attacks.clear();
		
	}
	public void submitAction() {
		Battle battle = this.arena.getBattle();
		for (int i = 0; i < this.priorityAttacks.size(); i++) {
			this.undoUse(this.priorityAttacks.get(i));
		}
		for (int i = 0; i < this.attacks.size(); i++) {
			this.undoUse(attacks.get(i));
		}
		battle.setPlayerPriorityChoice(this.priorityAttacks);
		battle.setPlayerChoice(this.attacks);
		this.priorityAttacks.clear();
		this.attacks.clear();
		battle.doTurn();
		
	}
	public void setButtons () {
		this.submitButton.setOnAction(e->{
			this.submitAction();
			timeLeft.setText("Time: " + timeCounter + "/" + player.getBattleStats().getActionTime() + "\t Energy: " + player.getBattleStats().getCurrentEnergy());
			this.resetList();
		});
		this.clearButton.setOnAction(e->{
			this.resetActions();
			timeLeft.setText("Time: " + timeCounter + "\t Energy: " + player.getBattleStats().getCurrentEnergy());
			this.resetList();
		});
	}
	public VBox getContainer() {
		return container;
	}
	public void setContainer(VBox container) {
		this.container = container;
	}
	
}
