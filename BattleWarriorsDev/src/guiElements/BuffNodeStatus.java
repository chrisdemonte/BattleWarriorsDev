package guiElements;

import attacks.BuffEffect;
import attacks.BuffSelfHarm;
import attacks.BuffStatus;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeStatus extends BuffEffectNode{
	VBox container = new VBox(3);
	Button deleteButton = new Button("-");

	HBox buttonLine = new HBox(3);
	
	HBox statusLine = new HBox(3);
	TextField statusChanceEntry = new TextField();
	Label statusLabel = new Label("status Chance : ");
	
	HBox levelLine = new HBox(1);
	TextField levelEntry = new TextField();
	Label levelLabel = new Label("Level : ");
	HBox staminaLine = new HBox(1);
	TextField staminaEntry = new TextField();
	Label staminaLabel = new Label("Stamina : ");
	HBox staminaModLine = new HBox(1);
	TextField staminaModEntry = new TextField();
	Label staminaModLabel = new Label("Stamina Mod : ");
	HBox strengthLine = new HBox(1);
	TextField strengthEntry = new TextField();
	Label strengthLabel = new Label("Strength : ");
	HBox strengthModLine = new HBox(1);
	TextField strengthModEntry = new TextField();
	Label strengthModLabel = new Label("Strength Mod : ");
	HBox defenseLine = new HBox(1);
	TextField defenseEntry = new TextField();
	Label defenseLabel = new Label("Defense : ");
	HBox defenseModLine = new HBox(1);
	TextField defenseModEntry = new TextField();
	Label defenseModLabel = new Label("Defense Mod : ");
	HBox magicLine = new HBox(1);
	TextField magicEntry = new TextField();
	Label magicLabel = new Label("Magic : ");
	HBox magicModLine = new HBox(1);
	TextField magicModEntry = new TextField();
	Label magicModLabel = new Label("Magic Mod : ");
	HBox resistanceLine = new HBox(1);
	TextField resistanceEntry = new TextField();
	Label resistanceLabel = new Label("Resistance : ");
	HBox resistanceModLine = new HBox(1);
	TextField resistanceModEntry = new TextField();
	Label resistanceModLabel = new Label("Resistance Mod : ");
	HBox cunningLine = new HBox(1);
	TextField cunningEntry = new TextField();
	Label cunningLabel = new Label("Cunning : ");
	HBox cunningModLine = new HBox(1);
	TextField cunningModEntry = new TextField();
	Label cunningModLabel = new Label("Cunning Mod : ");
	HBox intelligenceLine = new HBox(1);
	TextField intelligenceEntry = new TextField();
	Label intelligenceLabel = new Label("Intelligence : ");
	HBox intelligenceModLine = new HBox(1);
	TextField intelligenceModEntry = new TextField();
	Label intelligenceModLabel = new Label("Intelligence Mod : ");
	HBox speedLine = new HBox(1);
	TextField speedEntry = new TextField();
	Label speedLabel = new Label("Speed : ");
	HBox speedModLine = new HBox(1);
	TextField speedModEntry = new TextField();
	Label speedModLabel = new Label("Speed Mod : ");
	HBox skillLine = new HBox(1);
	TextField skillEntry = new TextField();
	Label skillLabel = new Label("Skill : ");
	HBox skillModLine = new HBox(1);
	TextField skillModEntry = new TextField();
	Label skillModLabel = new Label("Skill Mod : ");
	
	BuffNodeStatus(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		statusLine.getChildren().addAll(statusLabel, statusChanceEntry);
		levelLine.getChildren().addAll(levelLabel, levelEntry);
		staminaLine.getChildren().addAll(staminaLabel, staminaEntry);
		staminaModLine.getChildren().addAll(staminaModLabel, staminaModEntry);
		strengthLine.getChildren().addAll(strengthLabel, strengthEntry);
		strengthModLine.getChildren().addAll(strengthModLabel, strengthModEntry);
		defenseLine.getChildren().addAll(defenseLabel, defenseEntry);
		defenseModLine.getChildren().addAll(defenseModLabel, defenseModEntry);
		magicLine.getChildren().addAll(magicLabel, magicEntry);
		magicModLine.getChildren().addAll(magicModLabel, magicModEntry);
		resistanceLine.getChildren().addAll(resistanceLabel, resistanceEntry);
		resistanceModLine.getChildren().addAll(resistanceModLabel, resistanceModEntry);
		cunningLine.getChildren().addAll(cunningLabel, cunningEntry);
		cunningModLine.getChildren().addAll(cunningModLabel, cunningModEntry);
		intelligenceLine.getChildren().addAll(intelligenceLabel, intelligenceEntry);
		intelligenceModLine.getChildren().addAll(intelligenceModLabel, intelligenceModEntry);
		speedLine.getChildren().addAll(speedLabel, speedEntry);
		speedModLine.getChildren().addAll(speedModLabel, speedModEntry);
		skillLine.getChildren().addAll(skillLabel, skillEntry);
		skillModLine.getChildren().addAll(skillModLabel, skillModEntry);
		
		
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, statusLine, levelLine, staminaLine, staminaModLine, strengthLine,
				strengthModLine, defenseLine, defenseModLine, magicLine, magicModLine, resistanceLine,
				resistanceModLine, cunningLine, cunningModLine, intelligenceLine, intelligenceModLine,
				speedLine, speedModLine, skillLine, skillModLine);
		
	}

	private void setDeleteButton(BuffEffectListMaker maker) {
		this.deleteButton.setOnAction(e->{
			int temp = this.id;
			if (maker.getList().size() == 1) {
				maker.getList().remove(0);
				maker.getContainer().getChildren().remove(2);
				maker.idCounter--;
				return;
			}
			else if (temp < maker.idCounter - 1) {
				for (int i = temp; i < maker.idCounter; i++) {
					maker.getBuffNodes().get(i).setId(i-1);
				}
			
			}
			maker.getList().remove(temp);
			maker.getContainer().getChildren().remove(temp + 2);
			maker.idCounter--;
			
		});
		
	}

	@Override
	public BuffEffect createBuffEffect() {
		BuffEffect effect;
		try{
			effect = new BuffStatus(
					Integer.parseInt(this.statusChanceEntry.getText()),
					Double.parseDouble(this.levelEntry.getText()),
					Double.parseDouble(this.staminaEntry.getText()),
					Double.parseDouble(this.staminaModEntry.getText()),
					Double.parseDouble(this.strengthEntry.getText()),
					Double.parseDouble(this.strengthModEntry.getText()),
					Double.parseDouble(this.defenseEntry.getText()),
					Double.parseDouble(this.defenseModEntry.getText()),
					Double.parseDouble(this.magicEntry.getText()),
					Double.parseDouble(this.magicModEntry.getText()),
					Double.parseDouble(this.resistanceEntry.getText()),
					Double.parseDouble(this.resistanceModEntry.getText()),
					Double.parseDouble(this.cunningEntry.getText()),
					Double.parseDouble(this.cunningModEntry.getText()),
					Double.parseDouble(this.intelligenceEntry.getText()),
					Double.parseDouble(this.intelligenceModEntry.getText()),
					Double.parseDouble(this.speedEntry.getText()),
					Double.parseDouble(this.speedModEntry.getText()),
					Double.parseDouble(this.skillEntry.getText()),
					Double.parseDouble(this.skillModEntry.getText())
					);
					
		
		}
		catch (Exception ex) {
			effect = null;
		}
		return effect;
	}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}
}