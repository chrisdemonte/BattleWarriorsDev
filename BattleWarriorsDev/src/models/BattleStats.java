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
	
	//if charmed is true, chance to take no actions vs. intelligence + resistance
	boolean charmed;
	int charmCounter;
	
	//if attracted is true, chance to take no actions vs. intelligence
	boolean attracted;
	int attractedCounter;
	
	//if confused is true, chance to take no actions vs. skill
	boolean confused;
	int confusionCounter;
	
	//if vulnerable is true, enemy attacks ignore avoidance, blocking, barriers and shields, protection, counter, immunity, and reflecting 
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
	
	

}
