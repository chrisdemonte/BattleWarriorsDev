package guiElements;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.BaseStats;

public class BaseStatEditor {
	
	BaseStats stats;
	int points;
	
	VBox container = new VBox(3);
	HBox levelLine = new HBox(3);
	HBox pointsLine= new HBox(3);
	HBox staminaLine= new HBox(3);
	HBox strengthLine= new HBox(3);
	HBox defenseLine= new HBox(3);
	HBox magicLine= new HBox(3);
	HBox resistanceLine= new HBox(3);
	HBox cunningLine= new HBox(3);
	HBox intelligenceLine= new HBox(3);
	HBox speedLine= new HBox(3);
	HBox skillLine= new HBox(3);
	HBox submitLine= new HBox(3);
	
	Label levelLabel;
	Label pointsLabel;
	Label staminaLabel;
	Label strengthLabel;
	Label defenseLabel;
	Label magicLabel;
	Label resistanceLabel;
	Label cunningLabel;
	Label intelligenceLabel;
	Label speedLabel;
	Label skillLabel;
	
	Button submit;
	
	Button staminaMinus;
	Button strengthMinus;
	Button defenseMinus;
	Button magicMinus;
	Button resistanceMinus;
	Button cunningMinus;
	Button intelligenceMinus;
	Button speedMinus;
	Button skillMinus;
	
	Button staminaPlus;
	Button strengthPlus;
	Button defensePlus;
	Button magicPlus;
	Button resistancePlus;
	Button cunningPlus;
	Button intelligencePlus;
	Button speedPlus;
	Button skillPlus;

	public BaseStatEditor (BaseStats stats, int points){
		this.stats = stats;
		this.points = points;
		
		this.generateLayout();
	}

	private void generateLayout() {
		levelLabel= new Label("Level : " + this.stats.getLevel());
		pointsLabel= new Label("Points : " + this.points);
		staminaLabel= new Label("Stamina : " + this.stats.getStamina());
		strengthLabel= new Label("Strength : " + this.stats.getStrength());
		defenseLabel= new Label("Defense : " + this.stats.getDefense());
		magicLabel= new Label("Magic : " + this.stats.getMagic());
		resistanceLabel= new Label("Resistance : " + this.stats.getResistance());
		cunningLabel= new Label("Cunning : " + this.stats.getCunning());
		intelligenceLabel= new Label("Intelligence : " + this.stats.getIntelligence());
		speedLabel= new Label("Speed : " + this.stats.getSpeed());
		skillLabel= new Label("Skill : " + this.stats.getSkill());
		
		staminaMinus= new Button(" - ");
		strengthMinus= new Button(" - ");
		defenseMinus= new Button(" - ");
		magicMinus= new Button(" - ");
		resistanceMinus= new Button(" - ");
		cunningMinus= new Button(" - ");
		intelligenceMinus= new Button(" - ");
		speedMinus= new Button(" - ");
		skillMinus= new Button(" - ");
		
		staminaPlus= new Button(" + ");
		strengthPlus= new Button(" + ");
		defensePlus= new Button(" + ");
		magicPlus= new Button(" + ");
		resistancePlus= new Button(" + ");
		cunningPlus= new Button(" + ");
		intelligencePlus= new Button(" + ");
		speedPlus= new Button(" + ");
		skillPlus= new Button(" + ");
		
		submit = new Button("Submit");
		
		levelLine .getChildren().addAll(levelLabel);
		pointsLine.getChildren().addAll(pointsLabel);
		staminaLine.getChildren().addAll(staminaMinus, staminaLabel, staminaPlus);
		strengthLine.getChildren().addAll(strengthMinus, strengthLabel, strengthPlus);
		defenseLine.getChildren().addAll(defenseMinus, defenseLabel, defensePlus);
		magicLine.getChildren().addAll(magicMinus, magicLabel, magicPlus);
		resistanceLine.getChildren().addAll(resistanceMinus, resistanceLabel, resistancePlus);
		cunningLine.getChildren().addAll(cunningMinus, cunningLabel, cunningPlus);
		intelligenceLine.getChildren().addAll(intelligenceMinus, intelligenceLabel, intelligencePlus);
		speedLine.getChildren().addAll(speedMinus, speedLabel, speedPlus);
		skillLine.getChildren().addAll(skillMinus, skillLabel, skillPlus);
		submitLine.getChildren().addAll(submit);
		
		container.getChildren().addAll(levelLine,pointsLine,staminaLine,strengthLine,defenseLine,
				magicLine,resistanceLine,cunningLine,intelligenceLine,speedLine,skillLine,submitLine);
		
		
		}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}
	

}
