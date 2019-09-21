package guiElements;

import java.util.ArrayList;

import BattleSystem.Battle;
import attacks.FullAttack;
import attacks.Move;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
	VBox attackRows = new VBox(10);
	HBox[] rows;
	HBox rowOne = new HBox(20);
	Label timeLeft = new Label();
	Button clearButton = new Button("Clear"); 
	Button submitButton = new Button ("Attack!");
	BattleActionTimeDisplay timeDisplay;
	
	BattleSinglePlayerScene arena = null;
	Player player = null;
	
	int width = 0;
	int height = 0;
	//Default 
	public BattleSelectionPane (){
		FileManager manager = new FileManager();
		attackList.add(manager.loadMove("Punch"));
		attackList.add(manager.loadMove("Kick"));
		attackList.add(manager.loadMove("Spit"));
		attackList.add(manager.loadMove("Jab"));
		attackList.add(manager.loadMove("Cross Punch"));
		attackList.add(manager.loadMove("Double Tiger Strike"));
		
		this.rows = new HBox[(this.attackList.size()/3) + 1];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new HBox(10);
			rows[i].setPadding(new Insets(0,0,0,10));
		}
		player = new Player("Sample", "A Man");
		player.getBattleStats().setBattleStats(player);
		this.maxTime = 2000;
		this.timeCounter = 0;
		this.resetList();
		this.setLayout();
	}
	//Constructor utilized by BattleSystem
	public BattleSelectionPane (BattleSinglePlayerScene arena, Player player) {
		this.arena = arena;
		this.player = player;
		this.width = arena.getWidth();
		this.height = arena.getHeight();
		this.attackList = player.getAttacks().getMoveList();
		this.rows = new HBox[(this.attackList.size()/3) + 1];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new HBox(10);
			rows[i].setPadding(new Insets(0,0,0,5));
		}
		this.maxTime = player.getBattleStats().getActionTime() - player.getBattleStats().getDaze();
		this.timeCounter = 0;
		this.resetList();
		this.setLayout();
	}
	private void setLayout() {
		for (int i = 0; i < rows.length; i++) {
			attackRows.getChildren().add(rows[i]);
		}
		this.timeDisplay = new BattleActionTimeDisplay(this.arena);
		this.submitButton.setMinSize(width * .166, 30);
		this.submitButton.setFont(arena.getRoot().getSettings().getSmallFont());
		this.clearButton.setMinSize(width * .166, 30);
		this.clearButton.setFont(arena.getRoot().getSettings().getSmallFont());
		this.rowOne.setPadding(new Insets(10, 0,0, 0));
		scrollPane.setContent(attackRows);
		scrollPane.setMinSize(width*.35, height*.215);
		scrollPane.setMaxSize(width*.35, height*.215);
		this.setButtons();
		timeLeft.setFont(arena.getRoot().getSettings().getTinyFont());
		timeLeft.setText("Time: " + timeCounter + "/" + player.getBattleStats().getActionTime() + "\t Energy: " + player.getBattleStats().getCurrentEnergy());
		timeLeft.setStyle("-fx-text-fill: WHITE;");
		timeLeft.setMinSize(width *.35, 10);
		timeLeft.setAlignment(Pos.BASELINE_CENTER);
		timeLeft.setPadding(new Insets(0,0,0,0));
		
		rowOne.getChildren().addAll(submitButton, clearButton);
		container.getChildren().addAll(rowOne, timeLeft, timeDisplay.getContainer(),scrollPane);
		container.setPadding(new Insets(0,0,0,10));
		
	}
	public void resetList () {
		int counter = 0;
		choices.clear();
		unusableAttacks.clear();
		for (int i = 0; i < rows.length; i++) {
			rows[i].getChildren().clear();
		}
		while (counter < attackList.size()) {
			Move attack = this.attackList.get(counter);
			if (this.isAttackUsable(attack)) {
				BattleSelectionTab theTab = new BattleSelectionTab(attack, arena, player, counter, true);
				choices.add(theTab);
				theTab.getContainer().setOnMouseClicked(e->{
					if (attack.isPriority()) {
						this.priorityAttacks.add(attack);
						BattleSimpleTab tab = new BattleSimpleTab(this.arena, this.attackList.get(theTab.getIndex()), this.player);
						this.timeDisplay.getPriorityTabs().getChildren().add(tab.getContainer());
						
						this.applyUse(attack);		
					}
					else {
						this.attacks.add(attack);
						BattleSimpleTab tab = new BattleSimpleTab(this.arena,this.attackList.get(theTab.getIndex()), this.player);
						this.timeDisplay.getNormalTabs().getChildren().add(tab.getContainer());
						this.applyUse(attack);
					}
					timeLeft.setText("Time: " + timeCounter + "/" + player.getBattleStats().getActionTime() + "\t Energy: " + player.getBattleStats().getCurrentEnergy());
					this.resetList();
				});
			}
			else {
					unusableAttacks.add(attack);
				
			}
			counter++;
		}
		for (int i = 0; i < unusableAttacks.size(); i++) {
			BattleSelectionTab theTab = new BattleSelectionTab(unusableAttacks.get(i), arena, player, counter, false);
			choices.add(theTab);
		}
		counter = 0;
		while ((counter/3) < rows.length && counter < choices.size()) {
			rows[counter/3].getChildren().add(choices.get(counter).getContainer());
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
		
		
	}
	public void submitAction() {
		Battle battle = this.arena.getBattle();
		battle.setPlayerPriorityChoice(this.priorityAttacks);
		battle.setPlayerChoice(this.attacks);
		arena.getActionButtons().setAttackTabsOpen(false);
		this.resetActions();
		this.arena.getSelectionPane().getContainer().setVisible(false);
		this.arena.getTimeDisplayPane().setVisible(false);
		battle.doTurn();
		
	}
	
	public void setButtons () {
		this.submitButton.setOnAction(e->{
			if (this.attacks.size() >  0 || this.priorityAttacks.size() > 0) {
				this.submitAction();
			}
		});
		this.clearButton.setOnAction(e->{
			this.resetActions();
			this.resetAttackChoices();
			timeLeft.setText("Time: " + timeCounter + "/" + player.getBattleStats().getActionTime() + "\t Energy: " + player.getBattleStats().getCurrentEnergy());
			this.resetList();
		});
	}
	public void resetAttackChoices() {
		this.priorityAttacks.clear();
		this.attacks.clear();
		this.timeDisplay.clearTabs();
	}
	public VBox getContainer() {
		return container;
	}
	public void setContainer(VBox container) {
		this.container = container;
	}
	public ArrayList<Move> getUnusableAttacks() {
		return unusableAttacks;
	}
	public void setUnusableAttacks(ArrayList<Move> unusableAttacks) {
		this.unusableAttacks = unusableAttacks;
	}
	public int getTimeCounter() {
		return timeCounter;
	}
	public void setTimeCounter(int timeCounter) {
		this.timeCounter = timeCounter;
	}
	public ScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(ScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	public VBox getAttackRows() {
		return attackRows;
	}
	public void setAttackRows(VBox attackRows) {
		this.attackRows = attackRows;
	}
	public HBox[] getRows() {
		return rows;
	}
	public void setRows(HBox[] rows) {
		this.rows = rows;
	}
	public HBox getRowOne() {
		return rowOne;
	}
	public void setRowOne(HBox rowOne) {
		this.rowOne = rowOne;
	}
	public Label getTimeLeft() {
		return timeLeft;
	}
	public void setTimeLeft(Label timeLeft) {
		this.timeLeft = timeLeft;
	}
	public Button getSubmitButton() {
		return submitButton;
	}
	public void setSubmitButton(Button submitButton) {
		this.submitButton = submitButton;
	}
	
}
