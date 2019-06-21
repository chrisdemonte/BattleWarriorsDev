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

	public double getLevel() {
		return level;
	}

	public void setLevel(double level) {
		this.level = level;
	}

	public double getStamina() {
		return stamina;
	}

	public void setStamina(double stamina) {
		this.stamina = stamina;
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		this.defense = defense;
	}

	public double getMagic() {
		return magic;
	}

	public void setMagic(double magic) {
		this.magic = magic;
	}

	public double getResistance() {
		return resistance;
	}

	public void setResistance(double resistance) {
		this.resistance = resistance;
	}

	public double getCunning() {
		return cunning;
	}

	public void setCunning(double cunning) {
		this.cunning = cunning;
	}

	public double getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(double intelligence) {
		this.intelligence = intelligence;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getSkill() {
		return skill;
	}

	public void setSkill(double skill) {
		this.skill = skill;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public int getMaxEnergy() {
		return maxEnergy;
	}

	public void setMaxEnergy(int maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	public int getCurrentEnergy() {
		return currentEnergy;
	}

	public void setCurrentEnergy(int currentEnergy) {
		this.currentEnergy = currentEnergy;
	}

	public int getMaxComboPoints() {
		return maxComboPoints;
	}

	public void setMaxComboPoints(int maxComboPoints) {
		this.maxComboPoints = maxComboPoints;
	}

	public int getCurrentComboPoints() {
		return currentComboPoints;
	}

	public void setCurrentComboPoints(int currentComboPoints) {
		this.currentComboPoints = currentComboPoints;
	}

	public int getActionTime() {
		return actionTime;
	}

	public void setActionTime(int actionTime) {
		this.actionTime = actionTime;
	}

	public int getDaze() {
		return daze;
	}

	public void setDaze(int daze) {
		this.daze = daze;
	}

	public int getHaste() {
		return haste;
	}

	public void setHaste(int haste) {
		this.haste = haste;
	}

	public int getDamageSpike() {
		return damageSpike;
	}

	public void setDamageSpike(int damageSpike) {
		this.damageSpike = damageSpike;
	}

	public double getCrit() {
		return crit;
	}

	public void setCrit(double crit) {
		this.crit = crit;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	public double getAvoidance() {
		return avoidance;
	}

	public void setAvoidance(double avoidance) {
		this.avoidance = avoidance;
	}

	public double getBlocking() {
		return blocking;
	}

	public void setBlocking(double blocking) {
		this.blocking = blocking;
	}

	public double getPenetration() {
		return penetration;
	}

	public void setPenetration(double penetration) {
		this.penetration = penetration;
	}

	public double getBarrier() {
		return barrier;
	}

	public void setBarrier(double barrier) {
		this.barrier = barrier;
	}

	public double getPhysicalShield() {
		return physicalShield;
	}

	public void setPhysicalShield(double physicalShield) {
		this.physicalShield = physicalShield;
	}

	public double getMagicShield() {
		return magicShield;
	}

	public void setMagicShield(double magicShield) {
		this.magicShield = magicShield;
	}

	public double getFear() {
		return fear;
	}

	public void setFear(double fear) {
		this.fear = fear;
	}

	public double getIntimidation() {
		return intimidation;
	}

	public void setIntimidation(double intimidation) {
		this.intimidation = intimidation;
	}

	public boolean isAfraid() {
		return afraid;
	}

	public void setAfraid(boolean afraid) {
		this.afraid = afraid;
	}

	public int getAfraidCounter() {
		return afraidCounter;
	}

	public void setAfraidCounter(int afraidCounter) {
		this.afraidCounter = afraidCounter;
	}

	public boolean isCanAttack() {
		return canAttack;
	}

	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}

	public int getCanAttackCounter() {
		return canAttackCounter;
	}

	public void setCanAttackCounter(int canAttackCounter) {
		this.canAttackCounter = canAttackCounter;
	}

	public boolean isCanUseItems() {
		return canUseItems;
	}

	public void setCanUseItems(boolean canUseItems) {
		this.canUseItems = canUseItems;
	}

	public int getCanUseItemsCounter() {
		return canUseItemsCounter;
	}

	public void setCanUseItemsCounter(int canUseItemsCounter) {
		this.canUseItemsCounter = canUseItemsCounter;
	}

	public boolean isCanSkipTurn() {
		return canSkipTurn;
	}

	public void setCanSkipTurn(boolean canSkipTurn) {
		this.canSkipTurn = canSkipTurn;
	}

	public int getCanSkipTurnCounter() {
		return canSkipTurnCounter;
	}

	public void setCanSkipTurnCounter(int canSkipTurnCounter) {
		this.canSkipTurnCounter = canSkipTurnCounter;
	}

	public boolean isCanRun() {
		return canRun;
	}

	public void setCanRun(boolean canRun) {
		this.canRun = canRun;
	}

	public int getCanRunCounter() {
		return canRunCounter;
	}

	public void setCanRunCounter(int canRunCounter) {
		this.canRunCounter = canRunCounter;
	}

	public boolean isCharmed() {
		return charmed;
	}

	public void setCharmed(boolean charmed) {
		this.charmed = charmed;
	}

	public int getCharmCounter() {
		return charmCounter;
	}

	public void setCharmCounter(int charmCounter) {
		this.charmCounter = charmCounter;
	}

	public boolean isAttracted() {
		return attracted;
	}

	public void setAttracted(boolean attracted) {
		this.attracted = attracted;
	}

	public int getAttractedCounter() {
		return attractedCounter;
	}

	public void setAttractedCounter(int attractedCounter) {
		this.attractedCounter = attractedCounter;
	}

	public boolean isConfused() {
		return confused;
	}

	public void setConfused(boolean confused) {
		this.confused = confused;
	}

	public int getConfusionCounter() {
		return confusionCounter;
	}

	public void setConfusionCounter(int confusionCounter) {
		this.confusionCounter = confusionCounter;
	}

	public boolean isVulnerable() {
		return vulnerable;
	}

	public void setVulnerable(boolean vulnerable) {
		this.vulnerable = vulnerable;
	}

	public int getVulnerableCounter() {
		return vulnerableCounter;
	}

	public void setVulnerableCounter(int vulnerableCounter) {
		this.vulnerableCounter = vulnerableCounter;
	}

	public double getProtection() {
		return protection;
	}

	public void setProtection(double protection) {
		this.protection = protection;
	}

	public int getProtectionCounter() {
		return protectionCounter;
	}

	public void setProtectionCounter(int protectionCounter) {
		this.protectionCounter = protectionCounter;
	}

	public double getCountering() {
		return countering;
	}

	public void setCountering(double countering) {
		this.countering = countering;
	}

	public int getCounteringCounter() {
		return counteringCounter;
	}

	public void setCounteringCounter(int counteringCounter) {
		this.counteringCounter = counteringCounter;
	}

	public double getImmunity() {
		return immunity;
	}

	public void setImmunity(double immunity) {
		this.immunity = immunity;
	}

	public int getImmunityCounter() {
		return immunityCounter;
	}

	public void setImmunityCounter(int immunityCounter) {
		this.immunityCounter = immunityCounter;
	}

	public double getReflecting() {
		return reflecting;
	}

	public void setReflecting(double reflecting) {
		this.reflecting = reflecting;
	}

	public int getReflectingCounter() {
		return reflectingCounter;
	}

	public void setReflectingCounter(int reflectingCounter) {
		this.reflectingCounter = reflectingCounter;
	}

	public boolean isFreecasting() {
		return freecasting;
	}

	public void setFreecasting(boolean freecasting) {
		this.freecasting = freecasting;
	}

	public int getFreecastingCounter() {
		return freecastingCounter;
	}

	public void setFreecastingCounter(int freecastingCounter) {
		this.freecastingCounter = freecastingCounter;
	}

	public boolean isExhausted() {
		return exhausted;
	}

	public void setExhausted(boolean exhausted) {
		this.exhausted = exhausted;
	}

	public int getExhaustedCounter() {
		return exhaustedCounter;
	}

	public void setExhaustedCounter(int exhaustedCounter) {
		this.exhaustedCounter = exhaustedCounter;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public int getLockedCounter() {
		return lockedCounter;
	}

	public void setLockedCounter(int lockedCounter) {
		this.lockedCounter = lockedCounter;
	}

	public boolean isMindControlled() {
		return mindControlled;
	}

	public void setMindControlled(boolean mindControlled) {
		this.mindControlled = mindControlled;
	}

	public int getMindControlledCounter() {
		return mindControlledCounter;
	}

	public void setMindControlledCounter(int mindControlledCounter) {
		this.mindControlledCounter = mindControlledCounter;
	}
	
	

}
