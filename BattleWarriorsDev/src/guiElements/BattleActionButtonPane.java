package guiElements;

import BattleAnimation.BattleSlidingAnimation;
import BattleSystem.Battle;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import models.Player;

public class BattleActionButtonPane {
	
	VBox container = new VBox(10);
	
	Button attackButton = new Button("Attack");
	Button itemButton = new Button("Items");
	Button skipTurnButton = new Button("Skip Turn");
	Button runButton = new Button ("Run");
	
	int previousSelection = 0;
	boolean attackTabsOpen = false;
	
	Scene mainScene;
	BattleSinglePlayerScene scene;
	Battle battle;
	Player player;
	
	public BattleActionButtonPane ( BattleSinglePlayerScene scene, Player player, Battle battle, Scene mainScene) {
		this.scene = scene;
		this.mainScene = mainScene;
		this.player = player;
		this.battle = battle;
		this.generateLayout(scene);
	}

	private void generateLayout(BattleScene scene2) {
		attackButton.setOnAction(e->{
			if (!attackTabsOpen && !scene.isButtonsDisabled()) {
				scene.attackPane.getChildren().clear();
				scene.selectionPane = new BattleSelectionPane(scene, player);
				scene.attackPane.getChildren().add(scene.getSelectionPane().getContainer());
				scene.getTimeDisplayPane().setVisible(true);
				attackTabsOpen = true;
			}
		});
		attackButton.setFont(scene.getRoot().getSettings().getLargeFont());
		this.attackButton.setMinSize(140, 40);	

		skipTurnButton.setOnAction(e->{
			if (previousSelection == 1 && !scene.isButtonsDisabled()) {
				Battle battle = scene.getBattle();
				battle.getPlayerChoice().clear();
				battle.getPlayerChoice().add(battle.getSkipturn());
				battle.getPlayerPriorityChoice().clear();
				scene.getSelectionPane().resetActions();
				attackTabsOpen = false;
				scene.getSelectionPane().getContainer().getChildren().clear();
				player.getBattleStats().setCurrentEnergy(player.getBattleStats().getCurrentEnergy() + (player.getBattleStats().getMaxEnergy()/ 5));
				battle.doTurn();
			}
			previousSelection = 1;
		});
		skipTurnButton.setFont(scene.getRoot().getSettings().getLargeFont());
		this.runButton.setOnAction(e->{
			StartMenu menu = new StartMenu(this.scene.getWidth(), this.scene.getHeight(), this.scene.getRoot(), this.mainScene);
			this.scene.getRoot().getContainer().getChildren().clear();
			this.scene.getRoot().getContainer().getChildren().add(menu.getContainer());
		});
		runButton.setFont(scene.getRoot().getSettings().getLargeFont());
		this.itemButton.setOnAction(e->{
			
		});
		itemButton.setFont(scene.getRoot().getSettings().getLargeFont());
		this.skipTurnButton.setMinSize(140, 40);	
		this.itemButton.setMinSize(140, 40);	
		this.runButton.setMinSize(140, 40);	
		container.getChildren().addAll(attackButton, itemButton, skipTurnButton, runButton);
		this.container.setPadding(new Insets(10, 0,0,10));
		
	}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}

	public int getPreviousSelection() {
		return previousSelection;
	}

	public void setPreviousSelection(int previousSelection) {
		this.previousSelection = previousSelection;
	}

	public boolean isAttackTabsOpen() {
		return attackTabsOpen;
	}

	public void setAttackTabsOpen(boolean attackTabsOpen) {
		this.attackTabsOpen = attackTabsOpen;
	}

	public Button getAttackButton() {
		return attackButton;
	}

	public void setAttackButton(Button attackButton) {
		this.attackButton = attackButton;
	}

	public Button getItemButton() {
		return itemButton;
	}

	public void setItemButton(Button itemButton) {
		this.itemButton = itemButton;
	}

	public Button getSkipTurnButton() {
		return skipTurnButton;
	}

	public void setSkipTurnButton(Button skipTurnButton) {
		this.skipTurnButton = skipTurnButton;
	}

	public Button getRunButton() {
		return runButton;
	}

	public void setRunButton(Button runButton) {
		this.runButton = runButton;
	}

	public BattleScene getScene() {
		return scene;
	}

	public void setScene(BattleSinglePlayerScene scene) {
		this.scene = scene;
	}

	public Battle getBattle() {
		return battle;
	}

	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
