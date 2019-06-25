package models;

import java.util.Hashtable;

public class BattleStats {
	
	double level;
	double stamina;
	double staminaMod;
	double strength;
	double strengthMod;
	double defense;
	double defenseMod;
	double magic;
	double magicMod;
	double resistance;
	double resistanceMod;
	double cunning;
	double cunningMod;
	double intelligence;
	double intelligenceMod;
	double speed;
	double speedMod;
	double skill;
	double skillMod;
	
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
	double critMod;
	double accuracy;
	double accuracyMod;
	double avoidance;
	double avoidanceMod;
	double blocking;
	double blockingMod;
	double penetration; 
	double penetrationMod;
	
	double barrier;
	int barrierCounter;
	double physicalShield;
	int physicalShieldCounter;
	double magicShield;
	int magicShieldCounter;
	
	double fear;
	double intimidation;
	
	boolean canAttack;
	int canAttackCounter;
	boolean canUseItems;
	int canUseItemsCounter;
	boolean canSkipTurn;
	int canSkipTurnCounter;
	boolean canRun;
	int canRunCounter;
	
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
	
	boolean locked;
	int lockedCounter;
	boolean enraged;
	int enragedCounter;
	
	double adjuster = 10.0;
	
	public BattleStats (Character character) {
		this();
		this.setBattleStats(character);
		
	}

	public BattleStats() {
		super();
		this.level = 0.0;
		this.stamina = 0.0;
		this.staminaMod = 0.0;
		this.strength = 0.0;
		this.strengthMod = 0.0;
		this.defense = 0.0;
		this.defenseMod = 0.0;
		this.magic = 0.0;
		this.magicMod = 0.0;
		this.resistance = 0.0;
		this.resistanceMod = 0.0;
		this.cunning = 0.0;
		this.cunningMod = 0.0;
		this.intelligence = 0.0;
		this.intelligenceMod = 0.0;
		this.speed = 0.0;
		this.speedMod = 0.0;
		this.skill = 0.0;
		this.skillMod = 0.0;
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
		this.critMod = 0.0;
		this.accuracy = 0.0;
		this.accuracyMod = 0.0;
		this.avoidance = 0.0;
		this.avoidanceMod = 0.0;
		this.blocking = 0.0;
		this.blockingMod = 0.0;
		this.penetration = 0.0;
		this.penetrationMod = 0.0;
		this.barrier = 0.0;
		this.barrierCounter = 0;
		this.physicalShield = 0.0;
		this.physicalShieldCounter = 0;
		this.magicShield = 0.0;
		this.magicShieldCounter = 0;
		this.fear = 0.0;
		this.intimidation = 0.0;
		this.canAttack = true;
		this.canAttackCounter = 0;
		this.canUseItems = true;
		this.canUseItemsCounter = 0;
		this.canSkipTurn = true;
		this.canSkipTurnCounter = 0;
		this.canRun = true;
		this.canRunCounter = 0;
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
		this.enraged = false;
		this.enragedCounter = 0;
		
	}
	public void addBattleStats(BattleStats other) {
		
		this.stamina += other.getStamina();
		this.staminaMod += other.getStaminaMod();
		this.strength += other.getStrength();
		this.strengthMod += other.getStrengthMod();
		this.defense += other.getDefense();
		this.defenseMod += other.getDefenseMod();
		this.magic += other.getMagic();
		this.magicMod += other.getMagicMod();
		this.resistance += other.getResistance();
		this.resistanceMod += other.getResistanceMod();
		this.cunning += other.getCunning();
		this.cunningMod += other.getCunningMod();
		this.intelligence += other.getIntelligence();
		this.intelligenceMod += other.getIntelligenceMod();
		this.speed += other.getSpeed();
		this.speedMod += other.getSpeedMod();
		this.skill += other.getSkill();
		this.skillMod += other.getSkillMod();
		this.maxHealth += other.getMaxHealth();
		this.currentHealth += other.getCurrentHealth();
		this.maxEnergy += other.getMaxEnergy();
		this.currentEnergy += other.getCurrentEnergy();
		this.maxComboPoints += other.getMaxComboPoints();
		this.currentComboPoints += other.getCurrentComboPoints();
		this.actionTime += other.getActionTime();
		this.daze += other.getDaze();
		this.haste += other.getHaste();
		this.damageSpike += other.getDamageSpike();
		this.crit += other.getCrit();
		this.critMod += other.getCritMod();
		this.accuracy += other.getAccuracy();
		this.accuracyMod += other.getAccuracyMod();
		this.avoidance += other.getAvoidance();
		this.avoidanceMod += other.getAvoidanceMod();
		this.blocking += other.getBlocking();
		this.blockingMod += other.getBlockingMod();
		this.penetration += other.getPenetration();
		this.penetrationMod += other.getPenetrationMod();
		this.barrier += other.getBarrier();
		this.barrierCounter += other.getBarrierCounter();
		this.physicalShield += other.getPhysicalShield();
		this.physicalShieldCounter += other.getPhysicalShieldCounter();
		this.magicShield += other.getMagicShield();
		this.magicShieldCounter += other.getMagicShieldCounter();
		this.fear += other.getFear();
		this.intimidation += other.getIntimidation();
		if (!other.isCanAttack()) {
			this.canAttack = false;
			if (other.getCanAttackCounter() > this.canAttackCounter) {
				this.canAttackCounter = other.getCanAttackCounter();
			}
		}
		if (!other.isCanUseItems()) {
			this.canUseItems = false;
			if (other.getCanUseItemsCounter() > this.getCanUseItemsCounter()) {
				this.canUseItemsCounter = other.getCanUseItemsCounter();
			}
		}
		if (!other.isCanSkipTurn()) {
			this.canSkipTurn = false;
			if (other.getCanSkipTurnCounter() > this.canSkipTurnCounter) {
				this.canSkipTurnCounter = other.getCanSkipTurnCounter();
			}
		}
		if (!other.isCanRun()) {
			this.canRun = false;
			if (other.getCanRunCounter() > this.canRunCounter) {
				this.canRunCounter = other.getCanRunCounter();
			}
		}
		this.protection += other.getProtection();
		if (other.getPhysicalShieldCounter() > this.protectionCounter) {
			this.protectionCounter = other.getProtectionCounter();
		}
		this.countering += other.getCountering();
		if (other.getCounteringCounter() > this.counteringCounter) {
			this.counteringCounter = other.getCounteringCounter();
		}
		this.immunity += other.getImmunity();
		if (other.getImmunityCounter() > this.immunityCounter) {
			this.immunityCounter = other.getImmunityCounter();
		}
		this.reflecting += other.getReflecting();
		if (other.getReflectingCounter() > this.reflectingCounter) {
			this.reflectingCounter = other.getReflectingCounter();
		}
		if (other.isFreecasting()) {
			this.freecasting = true;
			if (other.getFreecastingCounter() > this.freecastingCounter) {
				this.freecastingCounter = other.getFreecastingCounter();
			}
		}
		if (other.isExhausted()) {
			this.exhausted = true;
			if (other.getExhaustedCounter() > this.exhaustedCounter) {
				this.exhaustedCounter = other.getExhaustedCounter();
			}
		}
		if (other.isLocked()) {
			this.locked = true;
			if (other.getLockedCounter() > this.lockedCounter) {
				this.lockedCounter = other.getLockedCounter();
			}
		}
		if (other.isEnraged()) {
			this.enraged = true;
			if (other.getEnragedCounter() > this.enragedCounter) {
				this.enragedCounter = other.getEnragedCounter();
			}
		}
		
		
	}

	public void setBattleStats(Character character) {
		
		
		this.level = character.getBaseStats().getLevel();
		
		this.stamina = character.getBaseStats().getStamina() + adjuster;
		this.staminaMod = 1.0;
		this.strength = character.getBaseStats().getStrength() + adjuster;
		this.strengthMod = 1.0;
		this.defense = character.getBaseStats().getDefense() + adjuster;
		this.defenseMod = 1.0;
		this.magic = character.getBaseStats().getMagic() + adjuster;
		this.magicMod = 1.0;
		this.resistance = character.getBaseStats().getResistance() + adjuster;
		this.resistanceMod = 1.0;
		this.cunning = character.getBaseStats().getCunning() + adjuster;
		this.cunningMod = 1.0;
		this.intelligence = character.getBaseStats().getIntelligence() + adjuster;
		this.intelligenceMod = 1.0;
		this.speed = character.getBaseStats().getSpeed() + adjuster;
		this.speedMod = 1.0;
		this.skill = character.getBaseStats().getSkill() + adjuster;
		this.skillMod = 1.0;
		
		Hashtable<String, Equipable> equipment = character.getInventory().getEquipment();
		this.addBattleStats(equipment.get("head").getStats());
		this.addBattleStats(equipment.get("chest").getStats());
		this.addBattleStats(equipment.get("legs").getStats());
		this.addBattleStats(equipment.get("hands").getStats());
		this.addBattleStats(equipment.get("feet").getStats());
		this.addBattleStats(equipment.get("trinket1").getStats());
		this.addBattleStats(equipment.get("trinket2").getStats());
		this.addBattleStats(equipment.get("2HWeapon").getStats());
		this.addBattleStats(equipment.get("1HMain").getStats());
		this.addBattleStats(equipment.get("1HOffHand").getStats());
		
		this.maxHealth += (int)(stamina + level + (defense * 0.1)) * 10;
		this.currentHealth += maxHealth;
		this.maxEnergy += (int)(stamina + level + (magic * .5) + (strength * 0.1));
		this.currentEnergy += maxEnergy;
		this.maxComboPoints += 3 + (int)((skill + cunning + intelligence)/(level * 6));
		this.currentComboPoints += 0;
		this.actionTime += 2000;
		this.daze += 0;
		this.haste += (int)((speed + skill + cunning)/(level * 20.0));
		this.damageSpike += 0;
		this.crit += .01 + (((speed * .25) + (skill * 1.5) + (cunning * 1.5) + (intelligence * .75))/ 2150.0);
		this.critMod += 1.0;
		this.accuracy += .95 + (((skill * 3.0) + (intelligence) + (cunning)) / 2150.0);
		this.accuracyMod += 1.0;
		this.avoidance += .01 + (((skill) + (cunning * 1.5) + (speed * 1.5)) / 2150.0);
		this.avoidanceMod += 1.0;
		this.blocking += ((defense * 3.0) / 2150.0);
		this.blockingMod += 1.0;
		this.penetration += (cunning)/ 2150.0;
		this.penetrationMod += 1.0;
		this.barrier += 0.0;
		this.barrierCounter += 0;
		this.physicalShield += 0.0;
		this.physicalShieldCounter += 0;
		this.magicShield += 0.0;
		this.magicShieldCounter += 0;
		this.fear += 0.0;
		this.intimidation += (stamina * .1) + (strength * .1) + (magic * .1) + (skill * .1);
		this.protection += 0.0;
		this.protectionCounter += 0;
		this.countering += 0.0;
		this.counteringCounter += 0;
		this.immunity += 0.0;
		this.immunityCounter += 0;
		this.reflecting += 0.0;
		this.reflectingCounter += 0;
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

	public double getStaminaMod() {
		return staminaMod;
	}

	public void setStaminaMod(double staminaMod) {
		this.staminaMod = staminaMod;
	}

	public double getStrengthMod() {
		return strengthMod;
	}

	public void setStrengthMod(double strengthMod) {
		this.strengthMod = strengthMod;
	}

	public double getDefenseMod() {
		return defenseMod;
	}

	public void setDefenseMod(double defenseMod) {
		this.defenseMod = defenseMod;
	}

	public double getMagicMod() {
		return magicMod;
	}

	public void setMagicMod(double magicMod) {
		this.magicMod = magicMod;
	}

	public double getResistanceMod() {
		return resistanceMod;
	}

	public void setResistanceMod(double resistanceMod) {
		this.resistanceMod = resistanceMod;
	}

	public double getCunningMod() {
		return cunningMod;
	}

	public void setCunningMod(double cunningMod) {
		this.cunningMod = cunningMod;
	}

	public double getIntelligenceMod() {
		return intelligenceMod;
	}

	public void setIntelligenceMod(double intelligenceMod) {
		this.intelligenceMod = intelligenceMod;
	}

	public double getSpeedMod() {
		return speedMod;
	}

	public void setSpeedMod(double speedMod) {
		this.speedMod = speedMod;
	}

	public double getSkillMod() {
		return skillMod;
	}

	public void setSkillMod(double skillMod) {
		this.skillMod = skillMod;
	}

	public double getCritMod() {
		return critMod;
	}

	public void setCritMod(double critMod) {
		this.critMod = critMod;
	}

	public double getAccuracyMod() {
		return accuracyMod;
	}

	public void setAccuracyMod(double accuracyMod) {
		this.accuracyMod = accuracyMod;
	}

	public double getAvoidanceMod() {
		return avoidanceMod;
	}

	public void setAvoidanceMod(double avoidanceMod) {
		this.avoidanceMod = avoidanceMod;
	}

	public double getBlockingMod() {
		return blockingMod;
	}

	public void setBlockingMod(double blockingMod) {
		this.blockingMod = blockingMod;
	}

	public double getPenetrationMod() {
		return penetrationMod;
	}

	public void setPenetrationMod(double penetrationMod) {
		this.penetrationMod = penetrationMod;
	}

	public int getBarrierCounter() {
		return barrierCounter;
	}

	public void setBarrierCounter(int barrierCounter) {
		this.barrierCounter = barrierCounter;
	}

	public int getPhysicalShieldCounter() {
		return physicalShieldCounter;
	}

	public void setPhysicalShieldCounter(int physicalShieldCounter) {
		this.physicalShieldCounter = physicalShieldCounter;
	}

	public int getMagicShieldCounter() {
		return magicShieldCounter;
	}

	public void setMagicShieldCounter(int magicShieldCounter) {
		this.magicShieldCounter = magicShieldCounter;
	}

	public boolean isEnraged() {
		return enraged;
	}

	public void setEnraged(boolean enraged) {
		this.enraged = enraged;
	}

	public int getEnragedCounter() {
		return enragedCounter;
	}

	public void setEnragedCounter(int enragedCounter) {
		this.enragedCounter = enragedCounter;
	}

}
