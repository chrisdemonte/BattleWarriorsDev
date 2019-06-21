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
		
		Button staminaMinus= new Button(" - ");
		Button strengthMinus= new Button(" - ");
		Button defenseMinus= new Button(" - ");
		Button magicMinus= new Button(" - ");
		Button resistanceMinus= new Button(" - ");
		Button cunningMinus= new Button(" - ");
		Button intelligenceMinus= new Button(" - ");
		Button speedMinus= new Button(" - ");
		Button skillMinus= new Button(" - ");
		
		Button staminaPlus= new Button(" + ");
		Button strengthPlus= new Button(" + ");
		Button defensePlus= new Button(" + ");
		Button magicPlus= new Button(" + ");
		Button resistancePlus= new Button(" + ");
		Button cunningPlus= new Button(" + ");
		Button intelligencePlus= new Button(" + ");
		Button speedPlus= new Button(" + ");
		Button skillPlus= new Button(" + ");
		
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
	

}
