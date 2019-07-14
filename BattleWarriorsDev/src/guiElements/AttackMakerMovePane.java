package guiElements;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AttackMakerMovePane {
	
	VBox container = new VBox(3);
	
	HBox nameLine = new HBox();
	Label nameLabel = new Label("Name : ");
	TextField nameEntry = new TextField();
	HBox descriptionLine = new HBox();
	Label descriptionLabel = new Label("Description : ");
	TextField descriptionEntry = new TextField();
	HBox customTextLine = new HBox();
	Label customTextLabel = new Label("Custom Text : ");
	TextField customTextEntry = new TextField();
	HBox keywordsLine = new HBox();
	Label keywordsLabel = new Label("Keywords : ");
	TextField keywordsEntry = new TextField();
	HBox energyCostLine = new HBox();
	Label energyCostLabel = new Label("Energy Cost : ");
	TextField energyCostEntry = new TextField();
	HBox usesLine = new HBox();
	Label usesLabel = new Label("Uses : ");
	TextField usesEntry = new TextField();
	HBox comboPointGainLine = new HBox();
	Label comboPointGainLabel = new Label("Combo Point Gain : ");
	TextField comboPointGainEntry = new TextField();
	HBox comboPointRequirementLine = new HBox();
	Label comboPointRequirementLabel = new Label("comboPointRequirement : ");
	TextField comboPointRequirementEntry = new TextField();
	HBox timeLine = new HBox();
	Label timeLabel = new Label("time : ");
	TextField timeEntry = new TextField();
	HBox cooldownLine = new HBox();
	Label cooldownLabel = new Label("cooldown : ");
	TextField cooldownEntry = new TextField();
	

}
