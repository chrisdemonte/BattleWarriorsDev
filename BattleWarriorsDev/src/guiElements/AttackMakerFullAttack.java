package guiElements;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AttackMakerFullAttack extends AttackMakerMoveNode{

	
	HBox nameLine = new HBox();
	Label nameLabel = new Label("name : ");
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
	
	HBox physicalPowerLine = new HBox();
	Label physicalPowerLabel = new Label("Physical Power : ");
	TextField physicalPowerEntry = new TextField();
	HBox magicalPowerLine = new HBox();
	Label magicalPowerLabel = new Label("magicalPower : ");
	TextField magicalPowerEntry = new TextField();
	HBox bonusDamageLine = new HBox();
	Label bonusDamageLabel = new Label("bonusDamage : ");
	TextField bonusDamageEntry = new TextField();
	HBox accuracyLine = new HBox();
	Label accuracyLabel = new Label("accuracy : ");
	TextField accuracyEntry = new TextField();
	HBox avoidabilityLine = new HBox();
	Label avoidabilityLabel = new Label("avoidability : ");
	TextField avoidabilityEntry = new TextField();
	HBox critLine = new HBox();
	Label critLabel = new Label("crit : ");
	TextField critEntry = new TextField();
	HBox penetrationLine = new HBox();
	Label penetrationLabel = new Label("penetration : ");
	TextField penetrationEntry = new TextField();
	HBox rangedAttackLine = new HBox();
	Label rangedAttackLabel = new Label("rangedAttack : ");
	CheckBox rangedAttackEntry = new CheckBox();
	HBox priorityLine = new HBox();
	Label priorityLabel = new Label("priority : ");
	CheckBox priorityEntry = new CheckBox();
	
	public AttackMakerFullAttack () {
		this.generateLayout();
	}

	private void generateLayout() {
		this.nameLine.getChildren().addAll(this.nameLabel, this.nameEntry);
		this.descriptionLine.getChildren().addAll(this.descriptionLabel, this.descriptionEntry);
		this.customTextLine.getChildren().addAll(this.customTextLabel, this.customTextEntry);
		this.keywordsLine.getChildren().addAll(this.keywordsLabel, this.keywordsEntry);
		this.energyCostLine.getChildren().addAll(this.energyCostLabel, this.energyCostEntry);
		this.usesLine.getChildren().addAll(this.usesLabel, this.usesEntry);
		this.comboPointGainLine.getChildren().addAll(this.comboPointGainLabel, this.comboPointGainEntry);
		this.comboPointRequirementLine.getChildren().addAll(this.comboPointRequirementLabel, this.comboPointRequirementEntry);
		this.timeLine.getChildren().addAll(this.timeLabel, this.timeEntry);
		this.cooldownLine.getChildren().addAll(this.cooldownLabel, this.cooldownEntry);
		this.physicalPowerLine.getChildren().addAll(this.physicalPowerLabel, this.physicalPowerEntry);
		this.magicalPowerLine.getChildren().addAll(this.magicalPowerLabel, this.magicalPowerEntry);
		this.bonusDamageLine.getChildren().addAll(this.bonusDamageLabel, this.bonusDamageEntry);
		this.accuracyLine.getChildren().addAll(this.accuracyLabel, this.accuracyEntry);
		this.avoidabilityLine.getChildren().addAll(this.avoidabilityLabel, this.avoidabilityEntry);
		this.critLine.getChildren().addAll(this.critLabel, this.critEntry);
		this.penetrationLine.getChildren().addAll(this.penetrationLabel, this.penetrationEntry);
		this.rangedAttackLine.getChildren().addAll(this.rangedAttackLabel, this.rangedAttackEntry);
		this.priorityLine.getChildren().addAll(this.priorityLabel, this.priorityEntry);
		
		this.container.getChildren().addAll(nameLine, descriptionLine, customTextLine, keywordsLine, energyCostLine,
				usesLine, comboPointGainLine, comboPointRequirementLine, timeLine, cooldownLine, 
				physicalPowerLine, magicalPowerLine, bonusDamageLine, accuracyLine,
				avoidabilityLine, critLine, penetrationLine, rangedAttackLine, priorityLine, this.submitButton);
	}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}
	
}
