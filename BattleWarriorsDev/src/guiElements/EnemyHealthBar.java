package guiElements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import models.Player;

public class EnemyHealthBar {
	Pane container = new Pane();
	Pane emptyBar = new Pane();
	Image empty;
	Pane fullBar = new Pane();
	Image full;
	Label text = new Label();
	
	int width; 
	
	Player player;

	public EnemyHealthBar(Player player, int width ) {
		super();
		this.player = player;
		this.width = width;
		this.generateLayout();
	}
	private void generateLayout() {
		this.setBackground();
		this.text.setText("Health : " + player.getBattleStats().getCurrentHealth() + "/" + player.getBattleStats().getMaxHealth());
		emptyBar.setMinSize(width, 20);
		emptyBar.setMaxSize(width, 20);
		text.setMinSize(width, 20);
		text.setMaxSize(width, 20);
		text.setStyle("-fx-text-fill: WHITE; -fx-font-size: 14;");
		text.setAlignment(Pos.BASELINE_CENTER);
		int temp = (player.getBattleStats().getCurrentHealth()  * this.width)/ player.getBattleStats().getMaxHealth();
		fullBar.setMaxSize(temp, 20);
		fullBar.setMinSize(temp, 20);
		this.text.setText("Health : " + player.getBattleStats().getCurrentHealth() + "/" + player.getBattleStats().getMaxHealth());
		container.getChildren().addAll(emptyBar, fullBar, text);
		
		
	}
	public void changeHealthBar () {
		container.getChildren().clear();
		fullBar = new Pane();
		text = new Label();
		this.setBackground();
		emptyBar.setMinSize(width, 20);
		emptyBar.setMaxSize(width, 20);
		text.setMinSize(width, 20);
		text.setMaxSize(width, 20);
		text.setStyle("-fx-text-fill: WHITE; -fx-font-size: 14;");
		text.setAlignment(Pos.BASELINE_CENTER);
		int temp = (player.getBattleStats().getCurrentHealth()  * this.width)/ player.getBattleStats().getMaxHealth();
		if (temp < 0) {
			temp = 0;
		}
		fullBar.setMaxSize(temp, 20);
		fullBar.setMinSize(temp, 20);
		this.text.setText("Health : " + player.getBattleStats().getCurrentHealth() + "/" + player.getBattleStats().getMaxHealth());
		container.getChildren().addAll(emptyBar, fullBar, text);
		
	}
	public void setBackground() {
		try {
			File fullFile = new File("resources/images/green_pixel_pattern.PNG");
			File emptyFile = new File("resources/images/black_pixel_pattern.PNG");
			empty = new Image(new FileInputStream(emptyFile));	
			full = new Image(new FileInputStream(fullFile));	
			emptyBar.setBackground(new Background(new BackgroundImage(empty,
			        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT)));
			fullBar.setBackground(new Background(new BackgroundImage(full,
			        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT)));
			
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public Pane getContainer() {
		return container;
	}
	public void setContainer(Pane container) {
		this.container = container;
	}
	


}
