package guiElements;

import javafx.geometry.Pos;
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
		levelLabel.setMinWidth(100.0);
		levelLabel.setAlignment(Pos.CENTER);
		pointsLabel= new Label("Points : " + this.points);
		pointsLabel.setMinWidth(100.0);
		pointsLabel.setAlignment(Pos.CENTER);
		staminaLabel= new Label("Stamina : " + this.stats.getStamina());
		staminaLabel.setMinWidth(100.0);
		staminaLabel.setAlignment(Pos.CENTER);
		strengthLabel= new Label("Strength : " + this.stats.getStrength());
		strengthLabel.setMinWidth(100.0);
		strengthLabel.setAlignment(Pos.CENTER);
		defenseLabel= new Label("Defense : " + this.stats.getDefense());
		defenseLabel.setMinWidth(100.0);
		defenseLabel.setAlignment(Pos.CENTER);
		magicLabel= new Label("Magic : " + this.stats.getMagic());
		magicLabel.setMinWidth(100.0);
		magicLabel.setAlignment(Pos.CENTER);
		resistanceLabel= new Label("Resistance : " + this.stats.getResistance());
		resistanceLabel.setMinWidth(100.0);
		resistanceLabel.setAlignment(Pos.CENTER);
		cunningLabel= new Label("Cunning : " + this.stats.getCunning());
		cunningLabel.setMinWidth(100.0);
		cunningLabel.setAlignment(Pos.CENTER);
		intelligenceLabel= new Label("Intelligence : " + this.stats.getIntelligence());
		intelligenceLabel.setMinWidth(100.0);
		intelligenceLabel.setAlignment(Pos.CENTER);
		speedLabel= new Label("Speed : " + this.stats.getSpeed());
		speedLabel.setMinWidth(100.0);
		speedLabel.setAlignment(Pos.CENTER);
		skillLabel= new Label("Skill : " + this.stats.getSkill());
		skillLabel.setMinWidth(100.0);
		skillLabel.setAlignment(Pos.CENTER);
		
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
		
		levelLine.getChildren().addAll(levelLabel);
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
		
		double width = this.staminaLine.getWidth();
		levelLine.setMinWidth(width);
		levelLine.setAlignment(Pos.CENTER);
		pointsLine.setMinWidth(width);
		pointsLine.setAlignment(Pos.CENTER);
		submitLine.setMinWidth(width);
		submitLine.setAlignment(Pos.CENTER);
		
		this.setButtons();
		
		container.getChildren().addAll(levelLine,pointsLine,staminaLine,strengthLine,defenseLine,
				magicLine,resistanceLine,cunningLine,intelligenceLine,speedLine,skillLine,submitLine);
		}
	
	public void setButtons() {
		staminaMinus.setDisable(true);
		staminaMinus.setOnAction(e->{
			if (this.stats.getStamina() > 1) {
				this.stats.setStamina(this.stats.getStamina() - 1);
				points++;
				staminaPlus.setDisable(false);
			}
			if (this.stats.getStamina() == 1) {
				staminaMinus.setDisable(true);
			}
			this.refreshElements();
		});
		strengthMinus.setDisable(true);
		strengthMinus.setOnAction(e->{
			if (this.stats.getStrength() > 1) {
				this.stats.setStrength(this.stats.getStrength() - 1);
				points++;
				strengthPlus.setDisable(false);
			}
			if (this.stats.getStrength() == 1) {
				strengthMinus.setDisable(true);
			}
			this.refreshElements();
		});
		defenseMinus.setDisable(true);
		defenseMinus.setOnAction(e->{
			if (this.stats.getDefense() > 1) {
				this.stats.setDefense(this.stats.getDefense() - 1);
				points++;
				defensePlus.setDisable(false);
			}
			if (this.stats.getDefense() == 1) {
				defenseMinus.setDisable(true);
			}
			this.refreshElements();
		});
		magicMinus.setDisable(true);
		magicMinus.setOnAction(e->{
			if (this.stats.getMagic() > 1) {
				this.stats.setMagic(this.stats.getMagic() - 1);
				points++;
				magicPlus.setDisable(false);
			}
			if (this.stats.getMagic() == 1) {
				magicMinus.setDisable(true);
			}
			this.refreshElements();
		});
		resistanceMinus.setDisable(true);
		resistanceMinus.setOnAction(e->{
			if (this.stats.getResistance() > 1) {
				this.stats.setResistance(this.stats.getResistance() - 1);
				points++;
				resistancePlus.setDisable(false);
			}
			if (this.stats.getResistance() == 1) {
				resistanceMinus.setDisable(true);
			}
			this.refreshElements();
		});
		cunningMinus.setDisable(true);
		cunningMinus.setOnAction(e->{
			if (this.stats.getCunning() > 1) {
				this.stats.setCunning(this.stats.getCunning() - 1);
				points++;
				cunningPlus.setDisable(false);
			}
			if (this.stats.getCunning() == 1) {
				cunningMinus.setDisable(true);
			}
			this.refreshElements();
		});
		intelligenceMinus.setDisable(true);
		intelligenceMinus.setOnAction(e->{
			if (this.stats.getIntelligence() > 1) {
				this.stats.setIntelligence(this.stats.getIntelligence() - 1);
				points++;
				intelligencePlus.setDisable(false);
			}
			if (this.stats.getIntelligence() == 1) {
				intelligenceMinus.setDisable(true);
			}
			this.refreshElements();
		});
		speedMinus.setDisable(true);
		speedMinus.setOnAction(e->{
			if (this.stats.getSpeed() > 1) {
				this.stats.setSpeed(this.stats.getSpeed() - 1);
				points++;
				speedPlus.setDisable(false);
			}
			if (this.stats.getSpeed() == 1) {
				speedMinus.setDisable(true);
			}
			this.refreshElements();
		});
		skillMinus.setDisable(true);
		skillMinus.setOnAction(e->{
			if (this.stats.getSkill() > 1) {
				this.stats.setSkill(this.stats.getSkill() - 1);
				points++;
				skillPlus.setDisable(false);
			}
			if (this.stats.getSkill() == 1) {
				skillMinus.setDisable(true);
			}
			this.refreshElements();
			
		});
		
		staminaPlus.setOnAction(e->{
			if (points > 0 && this.stats.getStamina() < 5) {
				this.stats.setStamina(this.stats.getStamina() + 1);
				points--;
				staminaMinus.setDisable(false);
			}
			if (points == 0 || this.stats.getStamina() >= 5) {
				staminaPlus.setDisable(true);
			}
			this.refreshElements();
		});
		strengthPlus.setOnAction(e->{
			if (points > 0 && this.stats.getStrength() < 5) {
				this.stats.setStrength(this.stats.getStrength() + 1);
				points--;
				strengthMinus.setDisable(false);
			}
			if (points == 0 || this.stats.getStrength() >= 5) {
				strengthPlus.setDisable(true);
			}
			this.refreshElements();
		});
		defensePlus.setOnAction(e->{
			if (points > 0 && this.stats.getDefense() < 5) {
				this.stats.setDefense(this.stats.getDefense() + 1);
				points--;
				defenseMinus.setDisable(false);
			}
			if (points == 0 || this.stats.getDefense() >= 5) {
				defensePlus.setDisable(true);
			}
			this.refreshElements();
		});
		magicPlus.setOnAction(e->{
			if (points > 0 && this.stats.getMagic() < 5) {
				this.stats.setMagic(this.stats.getMagic() + 1);
				points--;
				magicMinus.setDisable(false);
			}
			if (points == 0 || this.stats.getMagic() >= 5) {
				magicPlus.setDisable(true);
			}
			this.refreshElements();
		});
		resistancePlus.setOnAction(e->{
			if (points > 0 && this.stats.getResistance() < 5) {
				this.stats.setResistance(this.stats.getResistance() + 1);
				points--;
				resistanceMinus.setDisable(false);
			}
			if (points == 0 || this.stats.getResistance() >= 5) {
				resistancePlus.setDisable(true);
			}
			this.refreshElements();
		});
		cunningPlus.setOnAction(e->{
			if (points > 0 && this.stats.getCunning() < 5) {
				this.stats.setCunning(this.stats.getCunning() + 1);
				points--;
				cunningMinus.setDisable(false);
			}
			if (points == 0 || this.stats.getCunning() >= 5) {
				cunningPlus.setDisable(true);
			}
			this.refreshElements();
		});
		intelligencePlus.setOnAction(e->{
			if (points > 0 && this.stats.getIntelligence() < 5) {
				this.stats.setIntelligence(this.stats.getIntelligence() + 1);
				points--;
				intelligenceMinus.setDisable(false);
			}
			if (points == 0 || this.stats.getIntelligence() >= 5) {
				intelligencePlus.setDisable(true);
			}
			this.refreshElements();
		});
		speedPlus.setOnAction(e->{
			if (points > 0 && this.stats.getSpeed() < 5) {
				this.stats.setSpeed(this.stats.getSpeed() + 1);
				points--;
				speedMinus.setDisable(false);
			}
			if (points == 0 || this.stats.getSpeed() >= 5) {
				speedPlus.setDisable(true);
			}
			this.refreshElements();
		});
		skillPlus.setOnAction(e->{
			if (points > 0 && this.stats.getSkill() < 5) {
				this.stats.setSkill(this.stats.getSkill() + 1);
				points--;
				skillMinus.setDisable(false);
			}
			if (points == 0 || this.stats.getSkill() >= 5) {
				skillPlus.setDisable(true);
			}
			this.refreshElements();
		});
		
	}
	public void refreshElements() {
		
		int temp = 1 + stats.getStamina() + stats.getStrength() + stats.getDefense() + stats.getMagic() +
				stats.getResistance() + stats.getCunning() + stats.getIntelligence() + stats.getSpeed() + stats.getSkill();
		temp /= 10;
		stats.setLevel(temp);
		levelLabel.setText("Level : " + this.stats.getLevel());
		pointsLabel.setText("Points : " + this.points);
		staminaLabel.setText("Stamina : " + this.stats.getStamina());
		strengthLabel.setText("Strength : " + this.stats.getStrength());
		defenseLabel.setText("Defense : " + this.stats.getDefense());
		magicLabel.setText("Magic : " + this.stats.getMagic());
		resistanceLabel.setText("Resistance : " + this.stats.getResistance());
		cunningLabel.setText("Cunning : " + this.stats.getCunning());
		intelligenceLabel.setText("Intelligence : " + this.stats.getIntelligence());
		speedLabel.setText("Speed : " + this.stats.getSpeed());
		skillLabel.setText("Skill : " + this.stats.getSkill());
		
		if (this.points == 0) {
			staminaPlus.setDisable(true);;
			strengthPlus.setDisable(true);
			defensePlus.setDisable(true);
			magicPlus.setDisable(true);
			resistancePlus.setDisable(true);
			cunningPlus.setDisable(true);
			intelligencePlus.setDisable(true);
			speedPlus.setDisable(true);
			skillPlus.setDisable(true);
		}
		if (this.points > 0) {
			if (this.stats.getStamina() < 5) {
				staminaPlus.setDisable(false);
			}
			if (this.stats.getStrength() < 5) {
				strengthPlus.setDisable(false);
			}
			if (this.stats.getDefense() < 5) {
				defensePlus.setDisable(false);
			}
			if (this.stats.getMagic() < 5) {
				magicPlus.setDisable(false);
			}
			if (this.stats.getResistance() < 5) {
				resistancePlus.setDisable(false);
			}
			if (this.stats.getCunning() < 5) {
				cunningPlus.setDisable(false);
			}
			if (this.stats.getIntelligence() < 5) {
				intelligencePlus.setDisable(false);
			}
			if (this.stats.getSpeed() < 5) {
				speedPlus.setDisable(false);
			}
			if (this.stats.getSkill() < 5) {
				skillPlus.setDisable(false);
			}
		}
	}
	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}
	

}
