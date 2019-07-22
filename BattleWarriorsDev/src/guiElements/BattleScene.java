package guiElements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import BattleSystem.Battle;
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

public class BattleScene {
	
	Pane root = new Pane();
	Image frame;
	ImageView frameView = new ImageView();	
	Image border;
	
	HBox healthBarLine = new HBox();
	VBox playerBuffContainer = new VBox(1);
	VBox playerHealthBarContainer = new VBox(1);
	VBox healthBarCenter = new VBox(1);
	VBox enemyHealthContainer = new VBox(1);
	VBox enemyBuffContainer = new VBox(1);
	
	HealthBar playerBar;
	HealthBar enemyBar;
	
	BattleLog battleLog = new BattleLog();
	
	Pane battleWindow = new Pane();
	Pane actionPane = new Pane();
	Pane attackPane = new Pane();
	Pane logPane = new Pane();
	
	Battle battle;
	
	public BattleScene(int width, int height){
		
		this.generateLayout(width, height);
	}
	public BattleScene(Player self, Player enemy) {
		this.generateLayout(1400, 900);
		//this.battle = new Battle(self, enemy);
	}

	private void generateLayout(int width, int height) {
		root.setMaxSize(width, height);
		root.setMinSize(width, height);
		
		battleWindow.setMaxSize(width - 100, height - 300);
		battleWindow.setMinSize(width - 100, height - 300);
		battleWindow.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE,CornerRadii.EMPTY, Insets.EMPTY)));
		battleWindow.setTranslateX(50);
		battleWindow.setTranslateY(50);
		
		actionPane.setMaxSize((width / 4) - 40, height - 550);
		actionPane.setMinSize((width / 4) - 40, height - 550);
		actionPane.setTranslateX((width / 3) + 70);
		actionPane.setTranslateY(height - 200);
		
		attackPane.setMaxSize((width / 3) - 50, height - 550);
		attackPane.setMinSize((width / 3) - 50, height - 550);
		attackPane.setTranslateX(50);
		attackPane.setTranslateY(height - 200);
		
		logPane.setMaxSize((width / 3) - 50, height - 550);
		logPane.setMinSize((width / 3) - 50, height - 550);
		logPane.setTranslateX((width / 3) + (width/4) + 100);
		logPane.setTranslateY(height - 200);
		
		playerBar = new HealthBar(100,100,400);
		playerBar.getContainer().setTranslateX(100);
		playerBar.getContainer().setTranslateY(100);
		
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
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		battleWindow.setBorder(new Border(new BorderImage(border, new BorderWidths(10.0), new Insets(0.0), new BorderWidths(10.0),
				false, BorderRepeat.REPEAT, BorderRepeat.REPEAT)));
		
		root.getChildren().addAll(frameView, battleWindow, playerBar.getContainer(), attackPane, actionPane, logPane);
		
		
		
	}

	public Pane getRoot() {
		return root;
	}

	public void setRoot(Pane root) {
		this.root = root;
	}
	public BattleLog getBattleLog() {
		return battleLog;
	}
	public void setBattleLog(BattleLog battleLog) {
		this.battleLog = battleLog;
	}
	
	

}
