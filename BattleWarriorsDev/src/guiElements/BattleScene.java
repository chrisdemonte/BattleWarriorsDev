package guiElements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class BattleScene {
	
	Pane root = new Pane();
	Image frame;
	ImageView frameView = new ImageView();
	
	HBox healthBarLine = new HBox();
	VBox playerBuffContainer = new VBox(1);
	VBox playerHealthBarContainer = new VBox(1);
	VBox healthBarCenter = new VBox(1);
	VBox enemyHealthContainer = new VBox(1);
	VBox enemyBuffContainer = new VBox(1);
	
	HealthBar playerBar;
	HealthBar enemyBar;
	
	public BattleScene(int width, int height){
		
		this.generateLayout(width, height);
	}

	private void generateLayout(int width, int height) {
		root.setMaxSize(width, height);
		root.setMinSize(width, height);
		
		playerBar = new HealthBar(100,100,400);
		
		try {
			File file = new File ("C:\\Users\\chris\\git\\BattleWarriorsDev\\BattleWarriorsDev\\resources\\images\\battle_pane.PNG");
			frame = new  Image(new FileInputStream(file));
			frameView.setImage(frame);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		root.getChildren().addAll(frameView, playerBar.getContainer());
		
		playerBar.getContainer().setTranslateX(100);
		playerBar.getContainer().setTranslateY(100);
		
	}

	public Pane getRoot() {
		return root;
	}

	public void setRoot(Pane root) {
		this.root = root;
	}
	
	

}
