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

public class EnergyBar {
	Pane container = new Pane();
	Pane emptyBar = new Pane();
	Image empty;
	Pane fullBar = new Pane();
	Image full;
	Label text = new Label();
	
	int width; 
	
	Player player;
	BattleScene arena;

	public EnergyBar(Player player, int width, BattleScene arena ) {
		super();
		this.player = player;
		this.width = width;
		this.arena = arena;
		this.generateLayout();
	}
	private void generateLayout() {
		this.setBackground();
		this.text.setText("Energy : " + player.getBattleStats().getCurrentEnergy() + "/" + player.getBattleStats().getMaxEnergy());
		emptyBar.setMinSize(width, 20);
		emptyBar.setMaxSize(width, 20);
		text.setMinSize(width, 20);
		text.setMaxSize(width, 20);
		text.setAlignment(Pos.BASELINE_CENTER);
		text.setFont(arena.getRoot().getSettings().getSmallFont());
		text.setStyle("-fx-text-fill: WHITE;");
		this.changeEnergyBar();
		
	}
	public void changeEnergyBar () {
		container.getChildren().clear();
		int temp = (player.getBattleStats().getCurrentEnergy()  * this.width)/ player.getBattleStats().getMaxEnergy();
		fullBar.setMaxSize(temp, 20);
		fullBar.setMinSize(temp, 20);
		this.text.setText("Energy : " + player.getBattleStats().getCurrentEnergy() + "/" + player.getBattleStats().getMaxEnergy());
		container.getChildren().addAll(emptyBar, fullBar, text);
	}
	public void setBackground() {
		try {
			File fullFile = new File("resources/images/yellow_pixel_pattern.PNG");
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
