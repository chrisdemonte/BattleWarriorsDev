package guiElements;

import java.util.ArrayList;

import BattleSystem.Battle;
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

public class BattleSelectionPaneTwoPlayer {
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
	Button skipTurnButton = new Button ("Skip Turn");
	
	BattleTwoPlayerScene arena = null;
	Player player = null;
	boolean isEnemy;
	boolean choicesSet = false;
	int skipCounter = 0;
	
	int width = 0;
	int height = 0;

	public BattleSelectionPaneTwoPlayer (BattleTwoPlayerScene arena, Player player, boolean isEnemy) {
		this.isEnemy = isEnemy;
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
		this.submitButton.setMinSize(width * .1, 30);
		this.clearButton.setMinSize(width * .1, 30);
		this.skipTurnButton.setMinSize(width * .1, 30);
		this.rowOne.setPadding(new Insets(10, 0,0,10));
		scrollPane.setContent(attackRows);
		scrollPane.setMinSize(width*.35, height*.215);
		scrollPane.setMaxSize(width*.35, height*.215);
		this.setButtons();
		timeLeft.setText("Time: " + timeCounter + "/" + player.getBattleStats().getActionTime() + "\t Energy: " + player.getBattleStats().getCurrentEnergy());
		timeLeft.setStyle("-fx-text-fill: WHITE;");
		timeLeft.setMinSize(width *.35, height * .0375);
		timeLeft.setAlignment(Pos.BASELINE_CENTER);
		timeLeft.setPadding(new Insets(0,0,13,0));
		
		rowOne.getChildren().addAll(submitButton, clearButton, skipTurnButton);
		container.getChildren().addAll(rowOne, timeLeft, scrollPane);
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
						if (this.isEnemy) {
							this.priorityAttacks.add(attack);
							BattleSimpleTab tab = new BattleSimpleTab(this.arena, this.attackList.get(theTab.getIndex()), this.player);
							this.arena.getActionTime2().getPriorityTabs().getChildren().add(tab.getContainer());
							this.applyUse(attack);	
						}
						else {
							this.priorityAttacks.add(attack);
							BattleSimpleTab tab = new BattleSimpleTab(this.arena, this.attackList.get(theTab.getIndex()), this.player);
							this.arena.getActionTime().getPriorityTabs().getChildren().add(tab.getContainer());
							this.applyUse(attack);	
						}
							
					}
					else {
						if (this.isEnemy) {
							this.attacks.add(attack);
							BattleSimpleTab tab = new BattleSimpleTab(this.arena, this.attackList.get(theTab.getIndex()), this.player);
							this.arena.getActionTime2().getNormalTabs().getChildren().add(tab.getContainer());
							this.applyUse(attack);
						}
						else {
							
							this.attacks.add(attack);
							BattleSimpleTab tab = new BattleSimpleTab(this.arena, this.attackList.get(theTab.getIndex()), this.player);
							this.arena.getActionTime().getNormalTabs().getChildren().add(tab.getContainer());
							this.applyUse(attack);
						}
						
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
				attack.getCurrentUses() > 0 &&
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
		this.choicesSet = true;
		if (this.isEnemy) {
			battle.setEnemyPriorityChoice(this.priorityAttacks);
			battle.setEnemyChoice(this.attacks);
			this.arena.getPlayerTwoSelectionPane().getContainer().setVisible(false);
			this.arena.getEnemyTimeDisplayPane().setVisible(false);
		}
		else {
			battle.setPlayerPriorityChoice(this.priorityAttacks);
			battle.setPlayerChoice(this.attacks);
			this.arena.getPlayerOneSelectionPane().getContainer().setVisible(false);
			this.arena.getTimeDisplayPane().setVisible(false);
		}
		
		this.resetActions();
		if (arena.getPlayerOneSelectionPane().isChoicesSet() && arena.getPlayerTwoSelectionPane().isChoicesSet()) {
			battle.doTurn();
		}
	}
	
	public void setButtons () {
		this.submitButton.setOnAction(e->{
			if (this.attacks.size() > 0 || this.priorityAttacks.size() > 0) {
				this.submitAction();
			}
		});
		this.clearButton.setOnAction(e->{
			this.resetActions();
			this.resetAttackChoices();
			timeLeft.setText("Time: " + timeCounter + "/" + player.getBattleStats().getActionTime() + "\t Energy: " + player.getBattleStats().getCurrentEnergy());
			this.resetList();
		});
		this.skipTurnButton.setOnAction(e->{
			skipCounter++;
			skipTurnButton.setText("Press Again");
			if (skipCounter > 1) {
				this.choicesSet = true;
				this.resetActions();
				this.resetAttackChoices();
					
				Battle battle = this.arena.getBattle();
				this.choicesSet = true;
				if (this.isEnemy) {
					ArrayList<Move> temp = new ArrayList<Move>();
					temp.add(battle.getSkipturn());
					battle.setEnemyChoice(temp);
					this.arena.getPlayerTwoSelectionPane().getContainer().setVisible(false);
					this.arena.getEnemyTimeDisplayPane().setVisible(false);
					this.player.getBattleStats().setCurrentEnergy(player.getBattleStats().getCurrentEnergy() + player.getBaseStats().getLevel() + player.getBaseStats().getStamina() + player.getBaseStats().getMagic() +
							player.getBaseStats().getResistance() + player.getBaseStats().getIntelligence() + player.getBaseStats().getSpeed());
				}
				else {
					ArrayList<Move> temp = new ArrayList<Move>();
					temp.add(battle.getSkipturn());
					battle.setPlayerChoice(temp);
					this.arena.getPlayerOneSelectionPane().getContainer().setVisible(false);
					this.arena.getTimeDisplayPane().setVisible(false);
					this.player.getBattleStats().setCurrentEnergy(player.getBattleStats().getCurrentEnergy() + player.getBaseStats().getLevel() + player.getBaseStats().getStamina() + player.getBaseStats().getMagic() +
							player.getBaseStats().getResistance() + player.getBaseStats().getIntelligence() + player.getBaseStats().getSpeed());
				}
				
				if (arena.getPlayerOneSelectionPane().isChoicesSet() && arena.getPlayerTwoSelectionPane().isChoicesSet()) {
					battle.doTurn();
				}
				
			}
			
		});
	}
	public void resetAttackChoices() {
		this.priorityAttacks.clear();
		this.attacks.clear();
		if (this.isEnemy) {
			this.arena.getActionTime2().clearTabs();
		}
		else {
			this.arena.getActionTime().clearTabs();
		}
		
		
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
	public boolean isChoicesSet() {
		return choicesSet;
	}
	public void setChoicesSet(boolean choicesSet) {
		this.choicesSet = choicesSet;
	}
	
}
