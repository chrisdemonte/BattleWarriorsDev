package guiElements;

import java.io.FileInputStream;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class HealthBar {
	
	Pane container = new Pane();
	Label emptyBar = new Label();
	ImageView empty;
	Label fullBar = new Label();
	ImageView full;
	
	int currentHealth;
	int maxHealth;
	int width;

	
	public HealthBar(int currentHealth, int maxHealth, int width ) {
		super();
		this.currentHealth = currentHealth;
		this.maxHealth = maxHealth;
		this.width = width;
		this.generateLayout();
	}
	private void generateLayout() {
		container.getChildren().addAll(emptyBar, fullBar);
		try {
			empty = new ImageView(new Image(new FileInputStream("C:\\Users\\chris\\git\\BattleWarriorsDev\\BattleWarriorsDev\\resources\\images\\grey_pattern.PNG")));
			empty.setFitHeight(20);
			empty.setFitWidth(width);
			emptyBar.setGraphic(empty);
			full = new ImageView(new Image(new FileInputStream("C:\\Users\\chris\\git\\BattleWarriorsDev\\BattleWarriorsDev\\resources\\images\\green_pattern.PNG")));
			full.setFitHeight(20);
			full.setFitWidth(width/2);
			fullBar.setGraphic(full);
			emptyBar.setMinSize(width, 20);
			emptyBar.setMaxSize(width, 20);
			fullBar.setMaxSize(width/2, 20);
			fullBar.setMinSize(width/2, 20);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	public void changeHealthBar (int currentHealth) {
		int temp = (currentHealth * this.width)/ this.maxHealth;
		fullBar.setMaxSize(temp, 20);
		fullBar.setMinSize(temp, 20);
		full.setFitWidth(temp);
	}
	
	public Pane getContainer() {
		return container;
	}
	public void setContainer(Pane container) {
		this.container = container;
	}
	



}
