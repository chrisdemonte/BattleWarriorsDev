package models;

public class BattleStats {
	
	double level;
	double stamina;
	double strength;
	double defense;
	double magic;
	double resistance;
	double cunning;
	double intelligence;
	double speed;
	double skill;
	
	int maxHealth;
	int currentHealth;
	int maxEnergy;
	int currentEnergy;
	int maxComboPoints;
	int currentComboPoints;
	int actionTime;
	int daze;
	int haste;
	int damageSpike;
	
	double crit;
	double accuracy;
	double avoidance;
	double blocking;
	double penetration; 
	
	double barrier;
	double physicalShield;
	double magicShield;
	
	//if afraid is true, chance to take no actions vs. skill + resistance
	double fear;
	double intimidation;
	boolean afraid;
	int afraidCounter;
	
	boolean canAttack;
	int canAttackCounter;
	boolean canUseItems;
	int canUseItemsCounter;
	boolean canSkipTurn;
	int canSkipTurnCounter;
	boolean canRun;
	int canRunCounter;
	
	//if charmed is true, chance to take no actions vs. resistance
	boolean charmed;
	int charmCounter;
	
	//if attracted is true, chance to take no actions vs. intelligence
	boolean attracted;
	int attractedCounter;
	
	//if confused is true, chance to take no actions vs. skill
	boolean confused;
	int confusionCounter;
	
	//if vulnerable is true, enemy attacks ignore avoidance, blocking, barriers and shields, counter, and reflecting (protection and immunity still apply)
	boolean vulnerable;
	int vulnerableCounter;
	
	double protection;
	int protectionCounter;
	double countering;
	int counteringCounter;
	
	double immunity;
	int immunityCounter;
	double reflecting;
	int reflectingCounter;
	
	boolean freecasting;
	int freecastingCounter;
	boolean exhausted;
	int exhaustedCounter;
	
	//if locked is true, your character is locked into using it's last attack
	boolean locked;
	int lockedCounter;
	
	//if mindControled is true, your character has a chance of hurting itself, doing no actions, or doing its normal actions vs. resistance 
	boolean mindControlled;
	int mindControlledCounter;
	
	public BattleStats (BaseStats base) {
		this.level = base.getLevel();
		this.stamina = base.getStamina();
		this.strength = base.getStrength();
		this.defense = base.getDefense();
		this.magic = base.getMagic();
		this.resistance = base.getResistance();
	}

	public BattleStats() {
		super();
		this.level = 0.0;
		this.stamina = 0.0;
		this.strength = 0.0;
		this.defense = 0.0;
		this.magic = 0.0;
		this.resistance = 0.0;
		this.cunning = 0.0;
		this.intelligence = 0.0;
		this.speed = 0.0;
		this.skill = 0.0;
		this.maxHealth = 0;
		this.currentHealth = 0;
		this.maxEnergy = 0;
		this.currentEnergy = 0;
		this.maxComboPoints = 0;
		this.currentComboPoints = 0;
		this.actionTime = 0;
		this.daze = 0;
		this.haste = 0;
		this.damageSpike = 0;
		this.crit = 0.0;
		this.accuracy = 0.0;
		this.avoidance = 0.0;
		this.blocking = 0.0;
		this.penetration = 0.0;
		this.barrier = 0.0;
		this.physicalShield = 0.0;
		this.magicShield = 0.0;
		this.fear = 0.0;
		this.intimidation = 0.0;
		this.afraid = false;
		this.afraidCounter = 0;
		this.canAttack = true;
		this.canAttackCounter = 0;
		this.canUseItems = true;
		this.canUseItemsCounter = 0;
		this.canSkipTurn = true;
		this.canSkipTurnCounter = 0;
		this.canRun = true;
		this.canRunCounter = 0;
		this.charmed = false;
		this.charmCounter = 0;
		this.attracted = false;
		this.attractedCounter = 0;
		this.confused = false;
		this.confusionCounter = 0;
		this.vulnerable = false;
		this.vulnerableCounter = 0;
		this.protection = 0.0;
		this.protectionCounter = 0;
		this.countering = 0.0;
		this.counteringCounter = 0;
		this.immunity = 0.0;
		this.immunityCounter = 0;
		this.reflecting = 0.0;
		this.reflectingCounter = 0;
		this.freecasting = false;
		this.freecastingCounter = 0;
		this.exhausted = false;
		this.exhaustedCounter = 0;
		this.locked = false;
		this.lockedCounter = 0;
		this.mindControlled = false;
		this.mindControlledCounter = 0;
	}
	
	

}
