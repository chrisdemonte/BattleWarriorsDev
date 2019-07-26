package guiElements;

import java.util.ArrayList;

import attacks.FullAttack;
import attacks.Move;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Player;

public class BattleSelectionPane {
	
	ArrayList<Move> priorityAttacks = new ArrayList<Move>();
	ArrayList<Move> attacks = new ArrayList<Move>();
	
	ArrayList<Move> attackList = new ArrayList<Move>();
	ArrayList<Move> unusableAttacks = new ArrayList<Move>();
	
	ArrayList<BattleSelectionTab> choices = new ArrayList<BattleSelectionTab>();
	
	int timeCounter;
	int maxTime;
	
	VBox container = new VBox(3);
	ScrollPane scrollPane = new ScrollPane();
	VBox attackRows = new VBox(3);
	HBox[] rows;
	HBox rowOne = new HBox(3);
	Button clearButton; 
	Button submitButton;
	
	BattleScene arena = null;
	Player player = null;
	
	public BattleSelectionPane (){
		attackList.add(new FullAttack());
		attackList.add(new FullAttack());
		attackList.add(new FullAttack());
		attackList.add(new FullAttack());
		attackList.add(new FullAttack());
		this.rows = new HBox[(this.attackList.size()/3) + 1];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new HBox(3);
		}
		player = new Player("Sample", "A Man");
		this.maxTime = 2000;
		this.timeCounter = 0;
		this.resetList();
		this.setLayout();
	}
	public BattleSelectionPane (BattleScene arena, Player player) {
		this.arena = arena;
		this.player = player;
		this.attackList = player.getAttacks().getMoveList();
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
		container.getChildren().add(scrollPane);
		
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
				BattleSelectionTab theTab = new BattleSelectionTab(attack, arena);
				choices.add(theTab);
				theTab.getContainer().setOnMouseClicked(e->{
					if (attack.isPriority()) {
						this.priorityAttacks.add(attack);
						this.applyUse(attack);
						this.timeCounter += attack.getTime();
						this.resetList();
						
					}
					else {
						this.attacks.add(attack);
						this.applyUse(attack);
						this.timeCounter += attack.getTime();
						this.resetList();
					}
				});
				rows[counter/3].getChildren().add(choices.get(counter).getContainer());
			}
			counter++;
		}
		for (int i = 0; i < rows.length; i++) {
			attackRows.getChildren().add(rows[i]);
		}
		scrollPane.setContent(attackRows);
		scrollPane.setMinSize(1400 / 4, 900 - 550);
		scrollPane.setMaxSize(1400 / 4, 900 - 550);
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
		this.timeCounter -= attack.getTime() + this.player.getBattleStats().getHaste();
	}
	public VBox getContainer() {
		return container;
	}
	public void setContainer(VBox container) {
		this.container = container;
	}

}
