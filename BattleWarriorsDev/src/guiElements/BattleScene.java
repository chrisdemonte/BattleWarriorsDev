package guiElements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import BattleSystem.Battle;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
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

public class BattleScene {
	
	Pane container = new Pane();
	Image frame;
	ImageView frameView = new ImageView();	
	Image border;
	
	HBox playerSpriteContainer = new HBox();
	Image playerSprite;
	HBox enemySpriteContainer = new HBox();
	Image enemySprite;
	
	HBox healthBarLine = new HBox();
		VBox playerBuffContainer = new VBox(1);
		VBox playerHealthBarContainer = new VBox(1);
		VBox healthBarCenter = new VBox(1);
		VBox enemyHealthContainer = new VBox(1);
		VBox enemyBuffContainer = new VBox(1);
	
		HealthBar playerBar;
		HealthBar enemyBar;
		
		EnergyBar playerEnergy;
		EnergyBar enemyEnergy;
	
	BattleLog battleLog = new BattleLog();
	BattleSelectionPane selectionPane;
	BattleActionButtonPane actionButtons;
	BattleActionTimeDisplay actionTime;
	BattleActionTimeDisplay actionTime2;
	BattleLogPane battleLogPane;
	
	Pane battleWindow = new Pane();
	Pane actionPane = new Pane();
	Pane attackPane = new Pane();
	Pane logPane = new Pane();
	Pane timeDisplayPane = new Pane();
	Pane enemyTimeDisplayPane = new Pane();
	
	Battle battle;
	
	Label output = new Label("Battle");
	BattleSelectionPaneTwoPlayer playerTwoSelectionPane;
	BattleSelectionPaneTwoPlayer playerOneSelectionPane;
	
	boolean buttonsDisabled = false;
	int width = 1200;
	int height = 800;
	Pane root;
	
	public BattleScene() {
		
	}

	public void refreshBars() {
		
	}
	public Pane getContainer() {
		return container;
	}

	public void setContainer(Pane container) {
		this.container = container;
	}

	public Image getFrame() {
		return frame;
	}

	public void setFrame(Image frame) {
		this.frame = frame;
	}

	public ImageView getFrameView() {
		return frameView;
	}

	public void setFrameView(ImageView frameView) {
		this.frameView = frameView;
	}

	public Image getBorder() {
		return border;
	}

	public void setBorder(Image border) {
		this.border = border;
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

	public BattleLog getBattleLog() {
		return battleLog;
	}

	public void setBattleLog(BattleLog battleLog) {
		this.battleLog = battleLog;
	}

	public BattleSelectionPane getSelectionPane() {
		return selectionPane;
	}

	public void setSelectionPane(BattleSelectionPane selectionPane) {
		this.selectionPane = selectionPane;
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

	public BattleLogPane getBattleLogPane() {
		return battleLogPane;
	}

	public void setBattleLogPane(BattleLogPane battleLogPane) {
		this.battleLogPane = battleLogPane;
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

	public Pane getTimeDisplayPane() {
		return timeDisplayPane;
	}

	public void setTimeDisplayPane(Pane timeDisplayPane) {
		this.timeDisplayPane = timeDisplayPane;
	}

	public Pane getEnemyTimeDisplayPane() {
		return enemyTimeDisplayPane;
	}

	public void setEnemyTimeDisplayPane(Pane enemyTimeDisplayPane) {
		this.enemyTimeDisplayPane = enemyTimeDisplayPane;
	}

	public Battle getBattle() {
		return battle;
	}

	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	public boolean isButtonsDisabled() {
		return buttonsDisabled;
	}

	public void setButtonsDisabled(boolean buttonsDisabled) {
		this.buttonsDisabled = buttonsDisabled;
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

	public Pane getRoot() {
		return root;
	}

	public void setRoot(Pane root) {
		this.root = root;
	}

	public BattleActionTimeDisplay getActionTime2() {
		return actionTime2;
	}

	public void setActionTime2(BattleActionTimeDisplay actionTime2) {
		this.actionTime2 = actionTime2;
	}

	public Label getOutput() {
		return output;
	}

	public void setOutput(Label output) {
		this.output = output;
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
	
	
}