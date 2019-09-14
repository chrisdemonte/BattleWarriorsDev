package guiElements;

import java.util.ArrayList;

import attacks.Move;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.BaseStats;
import utilities.FileManager;

public class BaseStatDoubleEditor  {
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
	
	boolean forEnemy;
	int width;
	int height;
	CharacterCreatorTwoPlayer creator;

	public BaseStatDoubleEditor (int points, int width, int height, CharacterCreatorTwoPlayer creator, boolean forEnemy){
		
		this.stats = new BaseStats();
		this.points = points;
		this.width = width;
		this.height = height;
		this.generateLayout();
		this.creator = creator;
		this.forEnemy = forEnemy;
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
		levelLine.setMinWidth(this.width/4);
		levelLine.setAlignment(Pos.CENTER);
		pointsLine.getChildren().addAll(pointsLabel);
		pointsLine.setMinWidth(this.width/4);
		pointsLine.setAlignment(Pos.CENTER);
		staminaLine.getChildren().addAll(staminaMinus, staminaLabel, staminaPlus);
		staminaLine.setMinWidth(this.width/4);
		staminaLine.setAlignment(Pos.CENTER);
		strengthLine.getChildren().addAll(strengthMinus, strengthLabel, strengthPlus);
		strengthLine.setMinWidth(this.width/4);
		strengthLine.setAlignment(Pos.CENTER);
		defenseLine.getChildren().addAll(defenseMinus, defenseLabel, defensePlus);
		defenseLine.setMinWidth(this.width/4);
		defenseLine.setAlignment(Pos.CENTER);
		magicLine.getChildren().addAll(magicMinus, magicLabel, magicPlus);
		magicLine.setMinWidth(this.width/4);
		magicLine.setAlignment(Pos.CENTER);
		resistanceLine.getChildren().addAll(resistanceMinus, resistanceLabel, resistancePlus);
		resistanceLine.setMinWidth(this.width/4);
		resistanceLine.setAlignment(Pos.CENTER);
		cunningLine.getChildren().addAll(cunningMinus, cunningLabel, cunningPlus);
		cunningLine.setMinWidth(this.width/4);
		cunningLine.setAlignment(Pos.CENTER);
		intelligenceLine.getChildren().addAll(intelligenceMinus, intelligenceLabel, intelligencePlus);
		intelligenceLine.setMinWidth(this.width/4);
		intelligenceLine.setAlignment(Pos.CENTER);
		speedLine.getChildren().addAll(speedMinus, speedLabel, speedPlus);
		speedLine.setMinWidth(this.width/4);
		speedLine.setAlignment(Pos.CENTER);
		skillLine.getChildren().addAll(skillMinus, skillLabel, skillPlus);
		skillLine.setMinWidth(this.width/4);
		skillLine.setAlignment(Pos.CENTER);
		submitLine.getChildren().addAll(submit);
		
		submitLine.setMinWidth(this.width/4);
		submitLine.setAlignment(Pos.CENTER);
		
		this.setButtons();
		container.setAlignment(Pos.BASELINE_CENTER);
		container.setMinSize(this.width/3, this.height/2);
		container.getChildren().addAll(levelLine,pointsLine,staminaLine,strengthLine,defenseLine,
				magicLine,resistanceLine,cunningLine,intelligenceLine,speedLine,skillLine);
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
		creator.generateAttackViewColumn();
	}
	public BaseStats getBaseStats() {
		return this.stats;
	}
	public ArrayList<Move> getStarterAttacks () {
		ArrayList<Move> tempList = new ArrayList<Move>();
		FileManager manager = new FileManager();
		tempList.add(manager.loadMove("Punch"));
		tempList.add(manager.loadMove("Kick"));
		if (stats.getStamina() > 1) {
			tempList.add(manager.loadMove("Bandage"));
		}
		if (stats.getStamina() > 3) {
			tempList.add(manager.loadMove("Bolster Defenses"));
		}
		if (stats.getStrength() > 1) {
			tempList.add(manager.loadMove("Gather Strength"));
		}
		if (stats.getStrength() > 3) {
			tempList.add(manager.loadMove("Wild Attack"));
		}
		if (stats.getDefense() > 1) {
			tempList.add(manager.loadMove("Raise Defense"));
		}
		if (stats.getDefense() > 3) {
			tempList.add(manager.loadMove("Raise Shield"));
		}
		if (stats.getMagic() > 1) {
			tempList.add(manager.loadMove("Fireball"));
		}
		if (stats.getMagic() > 3) {
			tempList.add(manager.loadMove("Lightning"));
		}
		if (stats.getResistance() > 1) {
			tempList.add(manager.loadMove("Magic Strength"));
		}
		if (stats.getResistance() > 3) {
			tempList.add(manager.loadMove("Magic Power"));
		}
		if (stats.getCunning() > 1) {
			tempList.add(manager.loadMove("Scratch"));
		}
		if (stats.getCunning() > 3) {
			tempList.add(manager.loadMove("Reveal Opening"));
		}
		if (stats.getIntelligence() > 1) {
			tempList.add(manager.loadMove("Channel"));
		}
		if (stats.getIntelligence() > 3) {
			tempList.add(manager.loadMove("Magic Shell"));
		}
		if (stats.getSpeed() > 1) {
			tempList.add(manager.loadMove("Wild Attack"));
		}
		if (stats.getSpeed() > 3) {
			tempList.add(manager.loadMove("Rev Up Punch"));
		}
		if (stats.getSkill() > 1) {
			tempList.add(manager.loadMove("Jab"));
		}
		if (stats.getSkill() > 3) {
			tempList.add(manager.loadMove("Cross Punch"));
			tempList.add(manager.loadMove("Double Tiger Strike"));
		}
	
		return tempList;
	}
	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}
	
}
