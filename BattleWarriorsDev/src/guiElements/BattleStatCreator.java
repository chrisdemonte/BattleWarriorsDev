package guiElements;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.BattleStats;

public class BattleStatCreator {
	
	BattleStats stats;
	
	VBox container = new VBox(3);
	
	HBox levelLine = new HBox(3);
	HBox staminaLine = new HBox(3);
	HBox staminaModLine = new HBox(3);
	HBox strengthLine = new HBox(3);
	HBox strengthModLine = new HBox(3);
	HBox defenseLine = new HBox(3);
	HBox defenseModLine = new HBox(3);
	HBox magicLine = new HBox(3);
	HBox magicModLine = new HBox(3);
	HBox resistanceLine = new HBox(3);
	HBox resistanceModLine = new HBox(3);
	HBox cunningLine = new HBox(3);
	HBox cunningModLine = new HBox(3);
	HBox intelligenceLine = new HBox(3);
	HBox intelligenceModLine = new HBox(3);
	HBox speedLine = new HBox(3);
	HBox speedModLine = new HBox(3);
	HBox skillLine = new HBox(3);
	HBox skillModLine = new HBox(3);
	HBox maxHealthLine = new HBox(3);
	HBox currentHealthLine = new HBox(3);
	HBox maxEnergyLine = new HBox(3);
	HBox currentEnergyLine = new HBox(3);
	HBox maxComboPointsLine = new HBox(3);
	HBox currentComboPointsLine = new HBox(3);
	HBox actionTimeLine = new HBox(3);
	HBox dazeLine = new HBox(3);
	HBox hasteLine = new HBox(3);
	HBox damageSpikeLine = new HBox(3);
	HBox critLine = new HBox(3);
	HBox critModLine = new HBox(3);
	HBox accuracyLine = new HBox(3);
	HBox accuracyModLine = new HBox(3);
	HBox avoidanceLine = new HBox(3);
	HBox avoidanceModLine = new HBox(3);
	HBox blockingLine = new HBox(3);
	HBox blockingModLine = new HBox(3);
	HBox penetrationLine = new HBox(3);
	HBox penetrationModLine = new HBox(3);
	HBox barrierLine = new HBox(3);
	HBox barrierCounterLine = new HBox(3);
	HBox physicalShieldLine = new HBox(3);
	HBox physicalShieldCounterLine = new HBox(3);
	HBox magicShieldLine = new HBox(3);
	HBox magicShieldCounterLine = new HBox(3);
	HBox fearLine = new HBox(3);
	HBox intimidationLine = new HBox(3);
	HBox canAttackLine = new HBox(3);
	HBox canAttackCounterLine = new HBox(3);
	HBox canUseItemsLine = new HBox(3);
	HBox canUseItemsCounterLine = new HBox(3);
	HBox canSkipTurnLine = new HBox(3);
	HBox canSkipTurnCounterLine = new HBox(3);
	HBox canRunLine = new HBox(3);
	HBox canRunCounterLine = new HBox(3);
	HBox protectionLine = new HBox(3);
	HBox protectionCounterLine = new HBox(3);
	HBox counteringLine = new HBox(3);
	HBox counteringCounterLine = new HBox(3);
	HBox immunityLine = new HBox(3);
	HBox immunityCounterLine = new HBox(3);
	HBox reflectingLine = new HBox(3);
	HBox reflectingCounterLine = new HBox(3);
	HBox freecastingLine = new HBox(3);
	HBox freecastingCounterLine = new HBox(3);
	HBox exhaustedLine = new HBox(3);
	HBox exhaustedCounterLine = new HBox(3);
	HBox lockedLine = new HBox(3);
	HBox lockedCounterLine = new HBox(3);
	HBox enragedLine = new HBox(3);
	HBox enragedCounterLine = new HBox(3);
	HBox outOfReachLine = new HBox(3);
	HBox outOfReachCounterLine = new HBox(3);
	HBox reachLine = new HBox(3);
	HBox reachCounterLine = new HBox(3);
	HBox selfHarmLine = new HBox(3);
	HBox selfHarmCounterLine = new HBox(3);
	
	Label levelLabel = new Label ("Level :");
	Label staminaLabel = new Label("Stamina :");
	Label staminaModLabel = new Label ("Stamina Modifier:");
	Label strengthLabel = new Label ("Strength :");
	Label strengthModLabel = new Label ("Strength Modifier :");
	Label defenseLabel = new Label ("Defense :");
	Label defenseModLabel = new Label ("Defense Modifier :");
	Label magicLabel = new Label ("Magic :");
	Label magicModLabel = new Label ("Magic Modifier :");
	Label resistanceLabel = new Label ("Resistance :");
	Label resistanceModLabel = new Label ("Resistance Modifier :");
	Label cunningLabel = new Label ("Cunning :");
	Label cunningModLabel = new Label ("Cunning Modifier :");
	Label intelligenceLabel = new Label ("Intelligence :");
	Label intelligenceModLabel = new Label ("Intelligence Modifier :");
	Label speedLabel = new Label ("Speed :");
	Label speedModLabel = new Label ("Speed Modifier :");
	Label skillLabel = new Label ("Skill :");
	Label skillModLabel = new Label ("Skill Modifier:");
	Label maxHealthLabel = new Label ("Max Health :");
	Label currentHealthLabel = new Label ("Current Health :");
	Label maxEnergyLabel = new Label ("Max Energy");
	Label currentEnergyLabel = new Label ("Current Energy :");
	Label maxComboPointsLabel = new Label ("Max Combo Points: ");
	Label currentComboPointsLabel = new Label ("Current Combo Points :");
	Label actionTimeLabel = new Label ("Action Time :");
	Label dazeLabel = new Label ("Daze :");
	Label hasteLabel = new Label ("Haste :");
	Label damageSpikeLabel = new Label ("Damage Spike");
	Label critLabel = new Label ("Critial Hit :");
	Label critModLabel = new Label ("Critical Hit Modifier :");
	Label accuracyLabel = new Label ("Accuracy :");
	Label accuracyModLabel = new Label ("Accuracy Modifier :");
	Label avoidanceLabel = new Label ("Avoidance :");
	Label avoidanceModLabel = new Label ("Avoidance Modifier :");
	Label blockingLabel = new Label ("Blocking :");
	Label blockingModLabel = new Label ("Blocking Modifier :");
	Label penetrationLabel = new Label ("Penetration :");
	Label penetrationModLabel = new Label ("Penetration Modifier :");
	Label barrierLabel = new Label ("Barrier :");
	Label barrierCounterLabel = new Label ("Barrier Counter :");
	Label physicalShieldLabel = new Label ("Physical Shield :");
	Label physicalShieldCounterLabel = new Label ("Physical Shield Counter :");
	Label magicShieldLabel = new Label ("Magic Shield :");
	Label magicShieldCounterLabel = new Label ("Magic Shield Counter :");
	Label fearLabel = new Label ("Fear :");
	Label intimidationLabel = new Label ("Intimidation :");
	Label canAttackLabel = new Label ("Can Attack :");
	Label canAttackCounterLabel = new Label ("Can Attack Counter :");
	Label canUseItemsLabel = new Label ("Can Use Items :");
	Label canUseItemsCounterLabel = new Label ("Can Use Items Counter :");
	Label canSkipTurnLabel = new Label ("Can Skip Turn :");
	Label canSkipTurnCounterLabel = new Label ("Can Skip Turn Counter :");
	Label canRunLabel = new Label ("Can Run :");
	Label canRunCounterLabel = new Label ("Can Run Counter :");
	Label protectionLabel = new Label ("Protection :");
	Label protectionCounterLabel = new Label ("Protection Counter :");
	Label counteringLabel = new Label ("Countering :");
	Label counteringCounterLabel = new Label ("Countering Counter :");
	Label immunityLabel = new Label ("Immunity :");
	Label immunityCounterLabel = new Label ("Immunity Counter :");
	Label reflectingLabel = new Label ("Reflecting :");
	Label reflectingCounterLabel = new Label ("Reflecting  Counter :");
	Label freecastingLabel = new Label ("Freecasting :");
	Label freecastingCounterLabel = new Label ("Freecasting Counter :");
	Label exhaustedLabel = new Label ("Exhausted :");
	Label exhaustedCounterLabel = new Label ("Exhausted Counter :");
	Label lockedLabel = new Label ("Locked :");
	Label lockedCounterLabel = new Label ("Locked Counter :");
	Label enragedLabel = new Label ("Enraged :");
	Label enragedCounterLabel = new Label ("Enraged Counter :");
	Label outOfReachLabel = new Label ("Out Of Reach :");
	Label outOfReachCounterLabel = new Label ("Out Of Reach Counter :");
	Label reachLabel = new Label ("Reach :");
	Label reachCounterLabel = new Label ("Reach Counter :");
	Label selfHarmLabel = new Label("Self Harm :");
	Label selfHarmCounterLabel= new Label("Self Harm Counter :");
	
	TextField levelTextField = new TextField ("0");
	TextField staminaTextField = new TextField("0");
	TextField staminaModTextField = new TextField ("0");
	TextField strengthTextField = new TextField ("0");
	TextField strengthModTextField = new TextField ("0");
	TextField defenseTextField = new TextField ("0");
	TextField defenseModTextField = new TextField ("0");
	TextField magicTextField = new TextField ("0");
	TextField magicModTextField = new TextField ("0");
	TextField resistanceTextField = new TextField ("0");
	TextField resistanceModTextField = new TextField ("0");
	TextField cunningTextField = new TextField ("0");
	TextField cunningModTextField = new TextField ("0");
	TextField intelligenceTextField = new TextField ("0");
	TextField intelligenceModTextField = new TextField ("0");
	TextField speedTextField = new TextField ("0");
	TextField speedModTextField = new TextField ("0");
	TextField skillTextField = new TextField ("0");
	TextField skillModTextField = new TextField ("0");
	TextField maxHealthTextField = new TextField ("0");
	TextField currentHealthTextField = new TextField ("0");
	TextField maxEnergyTextField = new TextField ("0");
	TextField currentEnergyTextField = new TextField ("0");
	TextField maxComboPointsTextField = new TextField ("0");
	TextField currentComboPointsTextField = new TextField ("0");
	TextField actionTimeTextField = new TextField ("0");
	TextField dazeTextField = new TextField ("0");
	TextField hasteTextField = new TextField ("0");
	TextField damageSpikeTextField = new TextField ("0");
	TextField critTextField = new TextField ("0");
	TextField critModTextField = new TextField ("0");
	TextField accuracyTextField = new TextField ("0");
	TextField accuracyModTextField = new TextField ("0");
	TextField avoidanceTextField = new TextField ("0");
	TextField avoidanceModTextField = new TextField ("0");
	TextField blockingTextField = new TextField ("0");
	TextField blockingModTextField = new TextField ("0");
	TextField penetrationTextField = new TextField ("0");
	TextField penetrationModTextField = new TextField ("0");
	TextField barrierTextField = new TextField ("0");
	TextField barrierCounterTextField = new TextField ("0");
	TextField physicalShieldTextField = new TextField ("0");
	TextField physicalShieldCounterTextField = new TextField ("0");
	TextField magicShieldTextField = new TextField ("0");
	TextField magicShieldCounterTextField = new TextField ("0");
	TextField fearTextField = new TextField ("0");
	TextField intimidationTextField = new TextField ("0");
	CheckBox canAttackCheckBox = new CheckBox ();
	TextField canAttackCounterTextField = new TextField ("0");
	CheckBox canUseItemsCheckBox = new CheckBox ();
	TextField canUseItemsCounterTextField = new TextField ("0");
	CheckBox canSkipTurnCheckBox = new CheckBox ();
	TextField canSkipTurnCounterTextField = new TextField ("0");
	CheckBox canRunCheckBox = new CheckBox();
	TextField canRunCounterTextField = new TextField ("0");
	TextField protectionTextField = new TextField ("0");
	TextField protectionCounterTextField = new TextField ("0");
	TextField counteringTextField = new TextField ("0");
	TextField counteringCounterTextField = new TextField ("0");
	TextField immunityTextField = new TextField ("0");
	TextField immunityCounterTextField = new TextField ("0");
	TextField reflectingTextField = new TextField ("0");
	TextField reflectingCounterTextField = new TextField ("0");
	CheckBox freecastingCheckBox = new CheckBox ();
	TextField freecastingCounterTextField = new TextField ("0");
	CheckBox exhaustedCheckBox = new CheckBox ();
	TextField exhaustedCounterTextField = new TextField ("0");
	CheckBox lockedCheckBox = new CheckBox ();
	TextField lockedCounterTextField = new TextField ("0");
	CheckBox enragedCheckBox = new CheckBox ();
	TextField enragedCounterTextField = new TextField ("0");
	CheckBox outOfReachCheckBox = new CheckBox ();
	TextField outOfReachCounterTextField = new TextField ("0");
	CheckBox reachCheckBox = new CheckBox ();
	TextField reachCounterTextField = new TextField ("0");
	CheckBox selfHarmCheckBox = new CheckBox();
	TextField selfHarmCounterTextField = new TextField("0");
	
	public BattleStatCreator () {
		this.stats = new BattleStats();
		this.generateLayout();
	}
	public void generateLayout() {
		
		levelLine .getChildren().addAll(levelLabel, levelTextField);
		staminaLine.getChildren().addAll(staminaLabel, staminaTextField);
		staminaModLine .getChildren().addAll(staminaModLabel, staminaModTextField);
		strengthLine .getChildren().addAll(strengthLabel, strengthTextField);
		strengthModLine .getChildren().addAll(strengthModLabel, strengthModTextField);
		defenseLine .getChildren().addAll(defenseLabel, defenseTextField);
		defenseModLine .getChildren().addAll(defenseModLabel, defenseModTextField);
		magicLine .getChildren().addAll(magicLabel, magicTextField);
		magicModLine .getChildren().addAll(magicModLabel, magicModTextField);
		resistanceLine .getChildren().addAll(resistanceLabel, resistanceTextField);
		resistanceModLine .getChildren().addAll(resistanceModLabel, resistanceModTextField);
		cunningLine .getChildren().addAll(cunningLabel, cunningTextField);
		cunningModLine .getChildren().addAll(cunningModLabel, cunningModTextField);
		intelligenceLine .getChildren().addAll(intelligenceLabel, intelligenceTextField);
		intelligenceModLine .getChildren().addAll(intelligenceModLabel, intelligenceModTextField);
		speedLine .getChildren().addAll(speedLabel, speedTextField);
		speedModLine .getChildren().addAll(speedModLabel, speedModTextField);
		skillLine .getChildren().addAll(skillLabel, skillTextField);
		skillModLine .getChildren().addAll(skillModLabel, skillModTextField);
		maxHealthLine .getChildren().addAll(maxHealthLabel, maxHealthTextField);
		currentHealthLine .getChildren().addAll(currentHealthLabel, currentHealthTextField);
		maxEnergyLine .getChildren().addAll(maxEnergyLabel, maxEnergyTextField);
		currentEnergyLine .getChildren().addAll(currentEnergyLabel, currentEnergyTextField);
		maxComboPointsLine .getChildren().addAll(maxComboPointsLabel, maxComboPointsTextField);
		currentComboPointsLine .getChildren().addAll(currentComboPointsLabel, currentComboPointsTextField);
		actionTimeLine .getChildren().addAll(actionTimeLabel, actionTimeTextField);
		dazeLine .getChildren().addAll(dazeLabel, dazeTextField);
		hasteLine .getChildren().addAll(hasteLabel, hasteTextField);
		damageSpikeLine .getChildren().addAll(damageSpikeLabel, damageSpikeTextField);
		critLine .getChildren().addAll(critLabel, critTextField);
		critModLine .getChildren().addAll(critModLabel, critModTextField);
		accuracyLine .getChildren().addAll(accuracyLabel, accuracyTextField);
		accuracyModLine .getChildren().addAll(accuracyModLabel, accuracyModTextField);
		avoidanceLine .getChildren().addAll(avoidanceLabel, avoidanceTextField);
		avoidanceModLine .getChildren().addAll(avoidanceModLabel, avoidanceModTextField);
		blockingLine .getChildren().addAll(blockingLabel, blockingTextField);
		blockingModLine .getChildren().addAll(blockingModLabel, blockingModTextField);
		penetrationLine .getChildren().addAll(penetrationLabel, penetrationTextField);
		penetrationModLine .getChildren().addAll(penetrationModLabel, penetrationModTextField);
		barrierLine .getChildren().addAll(barrierLabel, barrierTextField);
		barrierCounterLine .getChildren().addAll(barrierCounterLabel, barrierCounterTextField);
		physicalShieldLine .getChildren().addAll(physicalShieldLabel, physicalShieldTextField);
		physicalShieldCounterLine .getChildren().addAll(physicalShieldCounterLabel, physicalShieldCounterTextField);
		magicShieldLine .getChildren().addAll(magicShieldLabel, magicShieldTextField);
		magicShieldCounterLine .getChildren().addAll(magicShieldCounterLabel, magicShieldCounterTextField);
		fearLine .getChildren().addAll(fearLabel, fearTextField);
		intimidationLine .getChildren().addAll(intimidationLabel, intimidationTextField);
		canAttackLine .getChildren().addAll(canAttackLabel, canAttackCheckBox);
		canAttackCounterLine .getChildren().addAll(canAttackCounterLabel, canAttackCounterTextField);
		canUseItemsLine .getChildren().addAll(canUseItemsLabel, canUseItemsCheckBox);
		canUseItemsCounterLine .getChildren().addAll(canUseItemsCounterLabel, canUseItemsCounterTextField);
		canSkipTurnLine .getChildren().addAll(canSkipTurnLabel, canSkipTurnCheckBox);
		canSkipTurnCounterLine .getChildren().addAll(canSkipTurnCounterLabel, canSkipTurnCounterTextField);
		canRunLine .getChildren().addAll(canRunLabel, canRunCheckBox);
		canRunCounterLine .getChildren().addAll(canRunCounterLabel, canRunCounterTextField);
		protectionLine .getChildren().addAll(protectionLabel, protectionTextField);
		protectionCounterLine .getChildren().addAll(protectionCounterLabel, protectionCounterTextField);
		counteringLine .getChildren().addAll(counteringLabel, counteringTextField);
		counteringCounterLine .getChildren().addAll(counteringCounterLabel, counteringCounterTextField);
		immunityLine .getChildren().addAll(immunityLabel, immunityTextField);
		immunityCounterLine .getChildren().addAll(immunityCounterLabel, immunityCounterTextField);
		reflectingLine .getChildren().addAll(reflectingLabel, reflectingTextField);
		reflectingCounterLine .getChildren().addAll(reflectingCounterLabel, reflectingCounterTextField);
		freecastingLine .getChildren().addAll(freecastingLabel, freecastingCheckBox);
		freecastingCounterLine .getChildren().addAll(freecastingCounterLabel, freecastingCounterTextField);
		exhaustedLine .getChildren().addAll(exhaustedLabel, exhaustedCheckBox);
		exhaustedCounterLine .getChildren().addAll(exhaustedCounterLabel, exhaustedCounterTextField);
		lockedLine .getChildren().addAll(lockedLabel, lockedCheckBox);
		lockedCounterLine .getChildren().addAll(lockedCounterLabel, lockedCounterTextField);
		enragedLine .getChildren().addAll(enragedLabel, enragedCheckBox);
		enragedCounterLine .getChildren().addAll(enragedCounterLabel, enragedCounterTextField);
		outOfReachLine .getChildren().addAll(outOfReachLabel, outOfReachCheckBox);
		outOfReachCounterLine .getChildren().addAll(outOfReachCounterLabel, outOfReachCounterTextField);
		reachLine .getChildren().addAll(reachLabel, reachCheckBox);
		reachCounterLine .getChildren().addAll(reachCounterLabel, reachCounterTextField);
		selfHarmLine.getChildren().addAll(selfHarmLabel, selfHarmCheckBox);
		selfHarmCounterLine.getChildren().addAll(selfHarmCounterLabel, selfHarmCounterTextField);
		
		levelLabel.setMinSize(140, 20);
		staminaLabel.setMinSize(140, 20);
		staminaModLabel.setMinSize(140, 20);
		strengthLabel.setMinSize(140, 20);
		strengthModLabel.setMinSize(140, 20);
		defenseLabel.setMinSize(140, 20);
		defenseModLabel.setMinSize(140, 20);
		magicLabel.setMinSize(140, 20);
		magicModLabel.setMinSize(140, 20);
		resistanceLabel.setMinSize(140, 20);
		resistanceModLabel.setMinSize(140, 20);
		cunningLabel.setMinSize(140, 20);
		cunningModLabel.setMinSize(140, 20);
		intelligenceLabel.setMinSize(140, 20);
		intelligenceModLabel.setMinSize(140, 20);
		speedLabel.setMinSize(140, 20);
		speedModLabel.setMinSize(140, 20);
		skillLabel.setMinSize(140, 20);
		skillModLabel.setMinSize(140, 20);
		maxHealthLabel.setMinSize(140, 20);
		currentHealthLabel.setMinSize(140, 20);
		maxEnergyLabel.setMinSize(140, 20);
		currentEnergyLabel.setMinSize(140, 20);
		maxComboPointsLabel.setMinSize(140, 20);
		currentComboPointsLabel.setMinSize(140, 20);
		actionTimeLabel.setMinSize(140, 20);
		dazeLabel.setMinSize(140, 20);
		hasteLabel.setMinSize(140, 20);
		damageSpikeLabel.setMinSize(140, 20);
		critLabel.setMinSize(140, 20);
		critModLabel.setMinSize(140, 20);
		accuracyLabel.setMinSize(140, 20);
		accuracyModLabel.setMinSize(140, 20);
		avoidanceLabel.setMinSize(140, 20);
		avoidanceModLabel.setMinSize(140, 20);
		blockingLabel.setMinSize(140, 20);
		blockingModLabel.setMinSize(140, 20);
		penetrationLabel.setMinSize(140, 20);
		penetrationModLabel.setMinSize(140, 20);
		barrierLabel.setMinSize(140, 20);
		barrierCounterLabel.setMinSize(140, 20);
		physicalShieldLabel.setMinSize(140, 20);
		physicalShieldCounterLabel.setMinSize(140, 20);
		magicShieldLabel.setMinSize(140, 20);
		magicShieldCounterLabel.setMinSize(140, 20);
		fearLabel.setMinSize(140, 20);
		intimidationLabel.setMinSize(140, 20);
		canAttackLabel.setMinSize(140, 20);
		canAttackCounterLabel.setMinSize(140, 20);
		canUseItemsLabel.setMinSize(140, 20);
		canUseItemsCounterLabel.setMinSize(140, 20);
		canSkipTurnLabel.setMinSize(140, 20);
		canSkipTurnCounterLabel.setMinSize(140, 20);
		canRunLabel.setMinSize(140, 20);
		canRunCounterLabel.setMinSize(140, 20);
		protectionLabel.setMinSize(140, 20);
		protectionCounterLabel.setMinSize(140, 20);
		counteringLabel.setMinSize(140, 20);
		counteringCounterLabel.setMinSize(140, 20);
		immunityLabel.setMinSize(140, 20);
		immunityCounterLabel.setMinSize(140, 20);
		reflectingLabel.setMinSize(140, 20);
		reflectingCounterLabel.setMinSize(140, 20);
		freecastingLabel.setMinSize(140, 20);
		freecastingCounterLabel.setMinSize(140, 20);
		exhaustedLabel.setMinSize(140, 20);
		exhaustedCounterLabel.setMinSize(140, 20);
		lockedLabel.setMinSize(140, 20);
		lockedCounterLabel.setMinSize(140, 20);
		enragedLabel.setMinSize(140, 20);
		enragedCounterLabel.setMinSize(140, 20);
		outOfReachLabel.setMinSize(140, 20);
		outOfReachCounterLabel.setMinSize(140, 20);
		reachLabel.setMinSize(140, 20);
		reachCounterLabel.setMinSize(140, 20);
		selfHarmLabel.setMinSize(140, 20);
		selfHarmCounterLabel.setMinSize(140, 20);
		
		levelLabel.setAlignment(Pos.BASELINE_RIGHT);
		staminaLabel.setAlignment(Pos.BASELINE_RIGHT);
		staminaModLabel.setAlignment(Pos.BASELINE_RIGHT);
		strengthLabel.setAlignment(Pos.BASELINE_RIGHT);
		strengthModLabel.setAlignment(Pos.BASELINE_RIGHT);
		defenseLabel.setAlignment(Pos.BASELINE_RIGHT);
		defenseModLabel.setAlignment(Pos.BASELINE_RIGHT);
		magicLabel.setAlignment(Pos.BASELINE_RIGHT);
		magicModLabel.setAlignment(Pos.BASELINE_RIGHT);
		resistanceLabel.setAlignment(Pos.BASELINE_RIGHT);
		resistanceModLabel.setAlignment(Pos.BASELINE_RIGHT);
		cunningLabel.setAlignment(Pos.BASELINE_RIGHT);
		cunningModLabel.setAlignment(Pos.BASELINE_RIGHT);
		intelligenceLabel.setAlignment(Pos.BASELINE_RIGHT);
		intelligenceModLabel.setAlignment(Pos.BASELINE_RIGHT);
		speedLabel.setAlignment(Pos.BASELINE_RIGHT);
		speedModLabel.setAlignment(Pos.BASELINE_RIGHT);
		skillLabel.setAlignment(Pos.BASELINE_RIGHT);
		skillModLabel.setAlignment(Pos.BASELINE_RIGHT);
		maxHealthLabel.setAlignment(Pos.BASELINE_RIGHT);
		currentHealthLabel.setAlignment(Pos.BASELINE_RIGHT);
		maxEnergyLabel.setAlignment(Pos.BASELINE_RIGHT);
		currentEnergyLabel.setAlignment(Pos.BASELINE_RIGHT);
		maxComboPointsLabel.setAlignment(Pos.BASELINE_RIGHT);
		currentComboPointsLabel.setAlignment(Pos.BASELINE_RIGHT);
		actionTimeLabel.setAlignment(Pos.BASELINE_RIGHT);
		dazeLabel.setAlignment(Pos.BASELINE_RIGHT);
		hasteLabel.setAlignment(Pos.BASELINE_RIGHT);
		damageSpikeLabel.setAlignment(Pos.BASELINE_RIGHT);
		critLabel.setAlignment(Pos.BASELINE_RIGHT);
		critModLabel.setAlignment(Pos.BASELINE_RIGHT);
		accuracyLabel.setAlignment(Pos.BASELINE_RIGHT);
		accuracyModLabel.setAlignment(Pos.BASELINE_RIGHT);
		avoidanceLabel.setAlignment(Pos.BASELINE_RIGHT);
		avoidanceModLabel.setAlignment(Pos.BASELINE_RIGHT);
		blockingLabel.setAlignment(Pos.BASELINE_RIGHT);
		blockingModLabel.setAlignment(Pos.BASELINE_RIGHT);
		penetrationLabel.setAlignment(Pos.BASELINE_RIGHT);
		penetrationModLabel.setAlignment(Pos.BASELINE_RIGHT);
		barrierLabel.setAlignment(Pos.BASELINE_RIGHT);
		barrierCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		physicalShieldLabel.setAlignment(Pos.BASELINE_RIGHT);
		physicalShieldCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		magicShieldLabel.setAlignment(Pos.BASELINE_RIGHT);
		magicShieldCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		fearLabel.setAlignment(Pos.BASELINE_RIGHT);
		intimidationLabel.setAlignment(Pos.BASELINE_RIGHT);
		canAttackLabel.setAlignment(Pos.BASELINE_RIGHT);
		canAttackCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		canUseItemsLabel.setAlignment(Pos.BASELINE_RIGHT);
		canUseItemsCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		canSkipTurnLabel.setAlignment(Pos.BASELINE_RIGHT);
		canSkipTurnCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		canRunLabel.setAlignment(Pos.BASELINE_RIGHT);
		canRunCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		protectionLabel.setAlignment(Pos.BASELINE_RIGHT);
		protectionCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		counteringLabel.setAlignment(Pos.BASELINE_RIGHT);
		counteringCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		immunityLabel.setAlignment(Pos.BASELINE_RIGHT);
		immunityCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		reflectingLabel.setAlignment(Pos.BASELINE_RIGHT);
		reflectingCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		freecastingLabel.setAlignment(Pos.BASELINE_RIGHT);
		freecastingCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		exhaustedLabel.setAlignment(Pos.BASELINE_RIGHT);
		exhaustedCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		lockedLabel.setAlignment(Pos.BASELINE_RIGHT);
		lockedCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		enragedLabel.setAlignment(Pos.BASELINE_RIGHT);
		enragedCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		outOfReachLabel.setAlignment(Pos.BASELINE_RIGHT);
		outOfReachCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		reachLabel.setAlignment(Pos.BASELINE_RIGHT);
		reachCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		selfHarmLabel.setAlignment(Pos.BASELINE_RIGHT);
		selfHarmCounterLabel.setAlignment(Pos.BASELINE_RIGHT);
		
		container.getChildren().addAll(levelLine,staminaLine,staminaModLine,strengthLine,
		strengthModLine, defenseLine, defenseModLine, magicLine, magicModLine,resistanceLine, resistanceModLine,
		cunningLine,cunningModLine,intelligenceLine,intelligenceModLine,speedLine,speedModLine,	skillLine,
		skillModLine,maxHealthLine,	currentHealthLine,maxEnergyLine,currentEnergyLine,	maxComboPointsLine,
		currentComboPointsLine,	actionTimeLine,	dazeLine,hasteLine,damageSpikeLine,	critLine,critModLine,accuracyLine,
		accuracyModLine,avoidanceLine,	avoidanceModLine,blockingLine,blockingModLine,penetrationLine,penetrationModLine,
		barrierLine,barrierCounterLine,	physicalShieldLine,physicalShieldCounterLine,magicShieldLine,magicShieldCounterLine,
		fearLine,intimidationLine,canAttackLine,canAttackCounterLine,canUseItemsLine,canUseItemsCounterLine,canSkipTurnLine,
		canSkipTurnCounterLine,canRunLine,canRunCounterLine,protectionLine,	protectionCounterLine,counteringLine,counteringCounterLine,
		immunityLine,immunityCounterLine,reflectingLine,reflectingCounterLine,freecastingLine,freecastingCounterLine,exhaustedLine,
		exhaustedCounterLine,lockedLine,lockedCounterLine ,enragedLine,enragedCounterLine,outOfReachLine,outOfReachCounterLine,
		reachLine,reachCounterLine,selfHarmLine,selfHarmCounterLine);
	}
	public VBox getContainer() {
		return container;
	}
	public void setContainer(VBox container) {
		this.container = container;
	}

}
