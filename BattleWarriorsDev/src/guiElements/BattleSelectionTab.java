package guiElements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import attacks.Move;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BattleSelectionTab {
	
	Pane container = new Pane();
	
	Image image;
// Font font;
	
	HBox row1 = new HBox(3);
	Label nameLabel = new Label();
	HBox row2 = new HBox(3);
	Label infoLabel = new Label();
	Tooltip toolTip = new Tooltip();
	
	Move attack = null;
	
	public BattleSelectionTab() {
		container.setMinSize(120, 40);
		nameLabel.setText("Name");
		nameLabel.setTooltip(toolTip);
		nameLabel.setMinSize(120, 40);
		nameLabel.setAlignment(Pos.TOP_LEFT);
		nameLabel.setStyle("-fx-text-fill: BLACK;");
		infoLabel.setText("Info\tInfo");
		infoLabel.setTooltip(toolTip);
		infoLabel.setMinSize(120, 40);
		infoLabel.setAlignment(Pos.BOTTOM_RIGHT);
		infoLabel.setStyle("-fx-text-fill: BLACK;");
		toolTip.setText("Description");
		row1.getChildren().addAll(nameLabel);
		row2.getChildren().addAll(infoLabel);
		this.setBackground();
		container.getChildren().addAll(row1, row2);
	}
	public BattleSelectionTab(Move attack, BattleScene arena) {
		container.setMinSize(110, 40);
		this.attack = attack;
		nameLabel.setText(attack.getName());
		nameLabel.setStyle("-fx-text-fill: BLACK;");
		nameLabel.setTooltip(toolTip);
		nameLabel.setMinSize(110, 40);
		nameLabel.setAlignment(Pos.TOP_LEFT);
		if (attack.getCooldownCounter() > 0) {
			infoLabel.setText("Cooldown:\t" + attack.getCooldownCounter() + " turns\tUses\t" + attack.getCurrentUses() + "/" + attack.getUses());
		}
		else {
			infoLabel.setText("Uses:\t" + attack.getCurrentUses() + "/" + attack.getUses());
		}
		infoLabel.setTooltip(toolTip);
		infoLabel.setMinSize(110, 40);
		infoLabel.setAlignment(Pos.BOTTOM_RIGHT);
		infoLabel.setStyle("-fx-text-fill: BLACK;");
		row1.getChildren().addAll(nameLabel);
		row2.getChildren().addAll(infoLabel);
		toolTip.setText(attack.getDescription());
		this.setBackground();
		container.getChildren().addAll(row1, row2);
	}
	
	public void setBackground() {
		try {
			File file = new File("resources/images/red_pixel_pattern.PNG");
			image = new Image(new FileInputStream(file));		
			container.setBackground(new Background(new BackgroundImage(image,
			        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT)));
			
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
/**
	public void setFont () {
		  try {
			  File file = new File("resources/fonts/mini_pixel-7.fon");
		      InputStream is = new InputStream(file);
		      font = Font.createFont(Font.TRUETYPE_FONT, is);
		    } 
		  catch (Exception ex) {
		      ex.printStackTrace();
		      System.err.println(fName + " not loaded.  Using serif font.");
		      font = new Font("serif", Font.PLAIN, 24);
		    }
		try {
			
			FileInputStream fis = new FileInputStream(file);
			this.font = (Font)fis.read();	
			container.setBackground(new Background(new BackgroundImage(image,
			        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT)));
			
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
**/
	public Pane getContainer() {
		return container;
	}

	public void setContainer(Pane container) {
		this.container = container;
	}

	public Label getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(Label nameLabel) {
		this.nameLabel = nameLabel;
	}
	public Move getAttack() {
		return attack;
	}
	public void setAttack(Move attack) {
		this.attack = attack;
	}
	
	
	
}