package guiElements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import BattleSystem.Battle;
import BattleSystem.TwoPlayerBattle;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderImage;
import javafx.scene.layout.BorderRepeat;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import models.Player;
import utilities.BattleLog;

public class BattleTwoPlayerScene extends BattleScene{
	

	BattleActionButtonPaneTwoPlayer centerButtons;


	public BattleTwoPlayerScene(Player self, Player enemy, int width, int height, Pane root) {
		super();
		this.battle = new TwoPlayerBattle(self, enemy, this);
		this.generateLayout(width, height, self, enemy);
		this.width = width;
		this.height = height;
		this.root = root;
		
		
	}


	private void generateLayout(int width, int height, Player self, Player enemy) {
		this.width = width;
		this.height = height;
		container.setMaxSize(width, height);
		container.setMinSize(width, height);
		
		this.playerOneSelectionPane = new BattleSelectionPaneTwoPlayer(this, self, false);
		this.playerTwoSelectionPane = new BattleSelectionPaneTwoPlayer(this, enemy, true);
		
		this.actionTime = new BattleActionTimeDisplay();
		this.actionTime2 = new BattleActionTimeDisplay();
		this.battleLogPane = new BattleLogPane(width, height);
		battleWindow.setMaxSize(width - 100, height - 300);
		battleWindow.setMinSize(width - 100, height - 300);
		battleWindow.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY, Insets.EMPTY)));
		battleWindow.setTranslateX(50);
		battleWindow.setTranslateY(50);
		
		actionPane.setMaxSize((width / 4) - 140, height - 550);
		actionPane.setMinSize((width / 4) - 140, height - 550);
		actionPane.setTranslateX((width / 3) + 120);
		actionPane.setTranslateY(height - 200);
		centerButtons = new BattleActionButtonPaneTwoPlayer(this, width, height);
		actionPane.getChildren().add(centerButtons.getContainer());
		
		attackPane.setMaxSize((width / 3) + 20, height - 550);
		attackPane.setMinSize((width / 3) + 20, height - 550);
		attackPane.setTranslateX(50);
		attackPane.setTranslateY(height - 200);
		attackPane.getChildren().add(playerOneSelectionPane.getContainer());
		
		
		actionTime.getContainer().setTranslateX(100);
		actionTime.getContainer().setTranslateY(475);
		
		actionTime2.getContainer().setTranslateX(800);
		actionTime2.getContainer().setTranslateY(475);
		
		logPane.setMaxSize((width / 3) + 20, height - 550);
		logPane.setMinSize((width / 3) + 20, height - 550);
		logPane.setTranslateX((width / 3) + (width/4) + 30);
		logPane.setTranslateY(height - 200);
		logPane.getChildren().add(playerTwoSelectionPane.getContainer());
		
		enemyTimeDisplayPane.setTranslateX(800);
		enemyTimeDisplayPane.setTranslateY(475);
		enemyTimeDisplayPane.getChildren().addAll(this.actionTime.getContainer());
		
		playerBar = new HealthBar(self, 400);
		playerBar.getContainer().setTranslateX(100);
		playerBar.getContainer().setTranslateY(100);
		
		playerEnergy = new EnergyBar(self, 400);
		playerEnergy.getContainer().setTranslateX(100);
		playerEnergy.getContainer().setTranslateY(130);
		
		enemyBar = new HealthBar(enemy, 400);
		enemyBar.getContainer().setTranslateX(700);
		enemyBar.getContainer().setTranslateY(100);
		
		enemyEnergy = new EnergyBar(enemy, 400);
		enemyEnergy.getContainer().setTranslateX(700);
		enemyEnergy.getContainer().setTranslateY(130);
		
		playerSpriteContainer.setMinSize(200, 200);
		playerSpriteContainer.setTranslateX((width/3) - 140);
		playerSpriteContainer.setTranslateY((height/2) - 180);
		enemySpriteContainer.setMinSize(200,200);
		enemySpriteContainer.setTranslateX(((width * 2)/3) - 60);
		enemySpriteContainer.setTranslateY((height/2) - 180);
		
		output.setStyle("-fx-text-fill: WHITE; -fx-font-size: 16;");
		try {
			//File file = new File ("C:\\Users\\chris\\git\\BattleWarriorsDev\\BattleWarriorsDev\\resources\\images\\battle_pane.PNG");
			File file = new File("resources/images/red_pixel_background.PNG");
			frame = new  Image(new FileInputStream(file));
			frameView.setImage(frame);

			File borderFile = new File("resources/images/black_pixel_pattern.PNG");
			border = new Image(new FileInputStream(borderFile));
			actionPane.setBackground(new Background(new BackgroundImage(border,
			        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT)));
			attackPane.setBackground(new Background(new BackgroundImage(border,
			        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT)));
			logPane.setBackground(new Background(new BackgroundImage(border,
			        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT)));
			File playerFile = new File("resources/images/playerModels/man.PNG");
			this.playerSprite = new Image(new FileInputStream(playerFile));
			playerSpriteContainer.setBackground(new Background(new BackgroundImage(playerSprite,
			        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT)));
			File enemyFile = new File("resources/images/playerModels/man_red.PNG");
			this.enemySprite = new Image(new FileInputStream(enemyFile));
			enemySpriteContainer.setBackground(new Background(new BackgroundImage(enemySprite,
			        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT)));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		battleWindow.setBorder(new Border(new BorderImage(border, new BorderWidths(10.0), new Insets(0.0), new BorderWidths(10.0),
				false, BorderRepeat.REPEAT, BorderRepeat.REPEAT)));
		
		container.getChildren().addAll(frameView, battleWindow, playerBar.getContainer(), playerEnergy.getContainer(), enemyBar.getContainer(), enemyEnergy.getContainer(), attackPane, actionTime.getContainer(), actionTime2.getContainer(), actionPane, logPane,
				playerSpriteContainer, enemySpriteContainer);
		
		this.battleLog.addToLog( "!!! " + enemy.getName() + " challenges you to a fight !!!\n" + enemy.getDescription());
		this.battleLogPane.updateLog(this.battleLog);
		
		
	}

	public void refreshBars () {
		this.playerBar.changeHealthBar();
		this.playerEnergy.changeEnergyBar();
		this.enemyBar.changeHealthBar();
		this.enemyEnergy.changeEnergyBar();
	}
	public Pane getContainer() {
		return container;
	}

	public void setContainer(Pane container) {
		this.container = container;
	}
	public BattleLog getBattleLog() {
		return battleLog;
	}
	public void setBattleLog(BattleLog battleLog) {
		this.battleLog = battleLog;
	}
	public Battle getBattle() {
		return battle;
	}
	public void setBattle(Battle battle) {
		this.battle = battle;
	}
	public HBox getHealthBarLine() {
		return healthBarLine;
	}
	public void setHealthBarLine(HBox healthBarLine) {
		this.healthBarLine = healthBarLine;
	}
	public VBox getPlayerBuffContainer() {
		return playerBuffContainer;
	}
	public void setPlayerBuffContainer(VBox playerBuffContainer) {
		this.playerBuffContainer = playerBuffContainer;
	}
	public VBox getPlayerHealthBarContainer() {
		return playerHealthBarContainer;
	}
	public void setPlayerHealthBarContainer(VBox playerHealthBarContainer) {
		this.playerHealthBarContainer = playerHealthBarContainer;
	}
	public VBox getHealthBarCenter() {
		return healthBarCenter;
	}
	public void setHealthBarCenter(VBox healthBarCenter) {
		this.healthBarCenter = healthBarCenter;
	}
	public VBox getEnemyHealthContainer() {
		return enemyHealthContainer;
	}
	public void setEnemyHealthContainer(VBox enemyHealthContainer) {
		this.enemyHealthContainer = enemyHealthContainer;
	}
	public VBox getEnemyBuffContainer() {
		return enemyBuffContainer;
	}
	public void setEnemyBuffContainer(VBox enemyBuffContainer) {
		this.enemyBuffContainer = enemyBuffContainer;
	}
	public HealthBar getPlayerBar() {
		return playerBar;
	}
	public void setPlayerBar(HealthBar playerBar) {
		this.playerBar = playerBar;
	}
	public HealthBar getEnemyBar() {
		return enemyBar;
	}
	public void setEnemyBar(HealthBar enemyBar) {
		this.enemyBar = enemyBar;
	}
	public BattleSelectionPane getSelectionPane() {
		return selectionPane;
	}
	public void setSelectionPane(BattleSelectionPane selectionPane) {
		this.selectionPane = selectionPane;
	}
	public Pane getBattleWindow() {
		return battleWindow;
	}
	public void setBattleWindow(Pane battleWindow) {
		this.battleWindow = battleWindow;
	}
	public Pane getActionPane() {
		return actionPane;
	}
	public void setActionPane(Pane actionPane) {
		this.actionPane = actionPane;
	}
	public Pane getAttackPane() {
		return attackPane;
	}
	public void setAttackPane(Pane attackPane) {
		this.attackPane = attackPane;
	}
	public Pane getLogPane() {
		return logPane;
	}
	public void setLogPane(Pane logPane) {
		this.logPane = logPane;
	}
	public BattleActionButtonPane getActionButtons() {
		return actionButtons;
	}
	public void setActionButtons(BattleActionButtonPane actionButtons) {
		this.actionButtons = actionButtons;
	}
	public BattleActionTimeDisplay getActionTime() {
		return actionTime;
	}
	public void setActionTime(BattleActionTimeDisplay actionTime) {
		this.actionTime = actionTime;
	}

	public EnergyBar getPlayerEnergy() {
		return playerEnergy;
	}

	public void setPlayerEnergy(EnergyBar playerEnergy) {
		this.playerEnergy = playerEnergy;
	}

	public EnergyBar getEnemyEnergy() {
		return enemyEnergy;
	}

	public void setEnemyEnergy(EnergyBar enemyEnergy) {
		this.enemyEnergy = enemyEnergy;
	}

	public Pane getTimeDisplayPane() {
		return timeDisplayPane;
	}

	public void setTimeDisplayPane(Pane timeDisplayPane) {
		this.timeDisplayPane = timeDisplayPane;
	}

	public HBox getPlayerSpriteContainer() {
		return playerSpriteContainer;
	}

	public void setPlayerSpriteContainer(HBox playerSpriteContainer) {
		this.playerSpriteContainer = playerSpriteContainer;
	}

	public Image getPlayerSprite() {
		return playerSprite;
	}

	public void setPlayerSprite(Image playerSprite) {
		this.playerSprite = playerSprite;
	}

	public HBox getEnemySpriteContainer() {
		return enemySpriteContainer;
	}

	public void setEnemySpriteContainer(HBox enemySpriteContainer) {
		this.enemySpriteContainer = enemySpriteContainer;
	}

	public Image getEnemySprite() {
		return enemySprite;
	}

	public void setEnemySprite(Image enemySprite) {
		this.enemySprite = enemySprite;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isButtonsDisabled() {
		return buttonsDisabled;
	}

	public void setButtonsDisabled(boolean buttonsDisabled) {
		this.buttonsDisabled = buttonsDisabled;
	}

	public Pane getRoot() {
		return root;
	}

	public void setRoot(Pane root) {
		this.root = root;
	}

	public BattleLogPane getBattleLogPane() {
		return battleLogPane;
	}

	public void setBattleLogPane(BattleLogPane battleLogPane) {
		this.battleLogPane = battleLogPane;
	}


	public BattleSelectionPaneTwoPlayer getPlayerTwoSelectionPane() {
		return playerTwoSelectionPane;
	}


	public void setPlayerTwoSelectionPane(BattleSelectionPaneTwoPlayer playerTwoSelectionPane) {
		this.playerTwoSelectionPane = playerTwoSelectionPane;
	}


	public BattleSelectionPaneTwoPlayer getPlayerOneSelectionPane() {
		return playerOneSelectionPane;
	}


	public void setPlayerOneSelectionPane(BattleSelectionPaneTwoPlayer playerOneSelectionPane) {
		this.playerOneSelectionPane = playerOneSelectionPane;
	}


	public BattleActionButtonPaneTwoPlayer getCenterButtons() {
		return centerButtons;
	}


	public void setCenterButtons(BattleActionButtonPaneTwoPlayer centerButtons) {
		this.centerButtons = centerButtons;
	}


	
}
