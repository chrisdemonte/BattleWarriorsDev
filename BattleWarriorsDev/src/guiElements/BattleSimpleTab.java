package guiElements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import attacks.Move;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import models.Player;

public class BattleSimpleTab {

	HBox container = new HBox();
	HBox nameContainer = new HBox();
	Label name = new Label();
	HBox infoContainer = new HBox();
	Label info = new Label();
	int height = 0;
	int width = 0;
	Image image;
	
	public BattleSimpleTab (String name, String info, int height, int width){
		this.name.setText(name);
		this.info.setText(info);
		this.height = height;
		this.width = width;
		this.generateLayout();
	}
	public BattleSimpleTab (Move move, Player player) {
		int time = player.getBattleStats().getActionTime();
		int attackTime = move.getTime() - player.getBattleStats().getHaste();
		this.width = (300 * attackTime)/time;
		this.height = 25;
		this.name.setText(move.getName());
		this.info.setText("" + attackTime);
		this.container.setMinSize(this.width, this.height);
		this.container.setMaxSize(this.width, this.height);
		this.generateLayout();
		
		
	}
	public void generateLayout() {
		this.nameContainer.getChildren().addAll(name);
		this.nameContainer.setMinWidth(this.width/2);
		this.nameContainer.setMaxWidth(this.width/2);
		this.nameContainer.setAlignment(Pos.BASELINE_LEFT);
		this.infoContainer.getChildren().addAll(info);
		this.infoContainer.setMinWidth(this.width/2);
		this.infoContainer.setMaxWidth(this.width/2);
		this.infoContainer.setAlignment(Pos.BASELINE_RIGHT);
		this.setBackground();
		this.container.getChildren().addAll(nameContainer, infoContainer);
	}
	public void setBackground() {
		try {
			File file = new File("resources/images/yellow_pixel_pattern.PNG");
			image = new Image(new FileInputStream(file));		
			container.setBackground(new Background(new BackgroundImage(image,
			        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT)));
			
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	public HBox getContainer() {
		return container;
	}
	public void setContainer(HBox container) {
		this.container = container;
	}
	public Label getName() {
		return name;
	}
	public void setName(Label name) {
		this.name = name;
	}
	public Label getInfo() {
		return info;
	}
	public void setInfo(Label info) {
		this.info = info;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
}
