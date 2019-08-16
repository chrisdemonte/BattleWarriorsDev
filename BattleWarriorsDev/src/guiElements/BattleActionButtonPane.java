package guiElements;

import BattleAnimation.BattleSlidingAnimation;
import BattleSystem.Battle;
import javafx.geometry.Insets;
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
	
	BattleScene scene;
	Player player;
	
	public BattleActionButtonPane ( BattleScene scene, Player player) {
		this.scene = scene;
		this.player = player;
		this.generateLayout(scene);
	}

	private void generateLayout(BattleScene scene2) {
		attackButton.setOnAction(e->{
			if (!attackTabsOpen) {
				scene.attackPane.getChildren().clear();
				scene.selectionPane = new BattleSelectionPane(scene, player);
				scene.attackPane.getChildren().add(scene.getSelectionPane().getContainer());
				attackTabsOpen = true;
			}
		});
		this.attackButton.setMinSize(140, 40);	

		skipTurnButton.setOnAction(e->{
			if (previousSelection == 1) {
				Battle battle = scene.getBattle();
				battle.getPlayerChoice().clear();
				battle.getPlayerPriorityChoice().clear();
				scene.getSelectionPane().resetActions();
				attackTabsOpen = false;
				scene.getSelectionPane().getContainer().getChildren().clear();
				player.getBattleStats().setCurrentEnergy(player.getBattleStats().getCurrentEnergy() + (player.getBattleStats().getMaxEnergy()/ 5));
				battle.doTurn();
			}
			previousSelection = 1;
		});
		this.runButton.setOnAction(e->{
			BattleSlidingAnimation animationTest = new BattleSlidingAnimation(player.getAttacks().getMoveList().get(0));
			animationTest.doBattleAnimation(this.scene, this.scene.getBattle(), player, this.scene.getBattle().getEnemy(), player.getAttacks().getMoveList().get(0));
		});
		this.itemButton.setOnAction(e->{
			BattleSlidingAnimation animationTest2 = new BattleSlidingAnimation(player.getAttacks().getMoveList().get(2));
			animationTest2.doBattleAnimation(this.scene, this.scene.getBattle(), this.scene.getBattle().getEnemy(), player, player.getAttacks().getMoveList().get(2));
		});
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

}
