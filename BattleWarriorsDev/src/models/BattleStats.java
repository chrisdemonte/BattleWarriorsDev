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
	boolean locked;
	int lockedCounter;
	
	double protection;
	int protectionCounter;
	double immunity;
	int immunityCounter;
	
	double countering;
	int counteringCounter;
	double reflecting;
	int reflectingCounter;
	
	boolean freecasting;
	int freecastingCounter;
	boolean exhausted;
	int exhaustedCounter;
	
	boolean outOfReach;
	int outOfReachCounter;
	boolean reach;
	int reachCounter;
	boolean hidden;
	int hiddenCounter;
	
	boolean enraged;
	int enragedCounter;
	boolean selfHarm;
	int selfHarmCounter;
	boolean vulnerable;
	int vulnerableCounter;
	
	boolean cheatingDeath;
	int cheatingDeathCounter;
	
	boolean weatherProof;
	int weatherProofCounter;
	
	
	double adjuster = 9.0 + (level / 2);
	
	public BattleStats (Player player) {
		this();
		this.setBattleStats(player);	
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
		this.outOfReach = false;
		this.outOfReachCounter = 0;
		this.reach = false;
		this.reachCounter = 0;
		this.selfHarm = false;
		this.selfHarmCounter = 0;
		this.vulnerable = false;
		this.vulnerableCounter = 0;
		this.hidden = false;
		this.hiddenCounter = 0;
		this.cheatingDeath = false;
		this.cheatingDeathCounter = 0;
		this.weatherProof = false;
		this.weatherProofCounter = 0;
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
		if (other.barrierCounter > this.barrierCounter) {
			this.barrierCounter = other.getBarrierCounter();
		}
		this.physicalShield += other.getPhysicalShield();
		if (other.physicalShieldCounter > this.physicalShieldCounter) {
			this.physicalShieldCounter = other.getPhysicalShieldCounter();
		}
		this.magicShield += other.getMagicShield();
		if (other.getMagicShieldCounter() > this.magicShieldCounter ) {
			this.magicShieldCounter = other.getMagicShieldCounter();
		}
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
		if (other.isOutOfReach()) {
			this.outOfReach = true;
			if (other.getOutOfReachCounter() > this.outOfReachCounter) {
				this.outOfReachCounter = other.getOutOfReachCounter();
			}
		}
		if (other.isReach()) {
			this.reach = true;
			if (other.getReachCounter() > this.getReachCounter()) {
				this.reachCounter = other.getReachCounter();
			}
		}
		if (other.isSelfHarm()) {
			this.selfHarm = true;
			if (other.getSelfHarmCounter() > this.getSelfHarmCounter()) {
				this.selfHarmCounter = other.getSelfHarmCounter();
			}
		}
		if (other.isVulnerable()) {
			this.vulnerable = true;
			if (other.getVulnerableCounter() > this.getVulnerableCounter()) {
				this.vulnerableCounter = other.getVulnerableCounter();
			}
		}
		if (other.isHidden()) {
			this.hidden = true;
			if (other.getHiddenCounter() > this.getHiddenCounter()) {
				this.hiddenCounter = other.getHiddenCounter();
			}
		}
		if (other.isCheatingDeath()) {
			this.cheatingDeath = true;
			if (other.getCheatingDeathCounter() > this.getCheatingDeathCounter()) {
				this.cheatingDeathCounter = other.getCheatingDeathCounter();
			}
		}
		if (other.isWeatherProof()) {
			this.weatherProof = true;
			if (other.getWeatherProofCounter() > this.getWeatherProofCounter()) {
				this.weatherProofCounter = other.getWeatherProofCounter();
			}
		}

	}
	public void changeBattleStats(BattleStats other) {
		this.stamina += other.getStamina();
		this.changeStaminaMod(other.getStaminaMod());
		this.strength += other.getStrength();
		this.changeStrengthMod(other.getStrengthMod());
		this.defense += other.getDefense();
		this.changeDefenseMod(other.getDefenseMod());
		this.magic += other.getMagic();
		this.changeMagicMod(other.getMagicMod());
		this.resistance += other.getResistance();
		this.changeResistanceMod(other.getResistanceMod());
		this.cunning += other.getCunning();
		this.changeCunningMod(other.getCunningMod());
		this.intelligence += other.getIntelligence();
		this.changeIntelligenceMod(other.getIntelligenceMod());
		this.speed += other.getSpeed();
		this.changeSpeedMod(other.getSpeedMod());
		this.skill += other.getSkill();
		this.changeSkillMod(other.getSkillMod());
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
		this.changeCritMod(other.getCritMod());
		this.accuracy += other.getAccuracy();
		this.changeAccuracyMod(other.getAccuracyMod());
		this.avoidance += other.getAvoidance();
		this.changeAvoidanceMod(other.getAvoidanceMod());
		this.blocking += other.getBlocking();
		this.changeBlockingMod(other.getBlockingMod());
		this.penetration += other.getPenetration();
		this.changePenetrationMod(other.getPenetrationMod());
		this.changeBarrier(other.getBarrier());
		if (other.barrierCounter > this.barrierCounter) {
			this.barrierCounter = other.getBarrierCounter();
		}
		this.changePhysicalShield(other.getPhysicalShield());
		if (other.physicalShieldCounter > this.physicalShieldCounter) {
			this.physicalShieldCounter = other.getPhysicalShieldCounter();
		}
		this.changeMagicShield(other.getMagicShield());
		if (other.getMagicShieldCounter() > this.magicShieldCounter ) {
			this.magicShieldCounter = other.getMagicShieldCounter();
		}
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
		this.changeProtection(other.getProtection());
		if (other.getPhysicalShieldCounter() > this.protectionCounter) {
			this.protectionCounter = other.getProtectionCounter();
		}
		this.changeCountering(other.getCountering());
		if (other.getCounteringCounter() > this.counteringCounter) {
			this.counteringCounter = other.getCounteringCounter();
		}
		this.changeImmunity(other.getImmunity());
		if (other.getImmunityCounter() > this.immunityCounter) {
			this.immunityCounter = other.getImmunityCounter();
		}
		this.changeReflecting(other.getReflecting());
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
		if (other.isOutOfReach()) {
			this.outOfReach = true;
			if (other.getOutOfReachCounter() > this.outOfReachCounter) {
				this.outOfReachCounter = other.getOutOfReachCounter();
			}
		}
		if (other.isReach()) {
			this.reach = true;
			if (other.getReachCounter() > this.getReachCounter()) {
				this.reachCounter = other.getReachCounter();
			}
		}
		if (other.isSelfHarm()) {
			this.selfHarm = true;
			if (other.getSelfHarmCounter() > this.getSelfHarmCounter()) {
				this.selfHarmCounter = other.getSelfHarmCounter();
			}
		}
		if (other.isVulnerable()) {
			this.vulnerable = true;
			if (other.getVulnerableCounter() > this.getVulnerableCounter()) {
				this.vulnerableCounter = other.getVulnerableCounter();
			}
		}
		if (other.isHidden()) {
			this.hidden = true;
			if (other.getHiddenCounter() > this.getHiddenCounter()) {
				this.hiddenCounter = other.getHiddenCounter();
			}
		}
		if (other.isCheatingDeath()) {
			this.cheatingDeath = true;
			if (other.getCheatingDeathCounter() > this.getCheatingDeathCounter()) {
				this.cheatingDeathCounter = other.getCheatingDeathCounter();
			}
		}
		if (other.isWeatherProof()) {
			this.weatherProof = true;
			if (other.getWeatherProofCounter() > this.getWeatherProofCounter()) {
				this.weatherProofCounter = other.getWeatherProofCounter();
			}
		}
	}
	public void setBattleStats(Player player) {
		
		this.level = player.getBaseStats().getLevel();
		this.adjuster = 9 + (player.getBaseStats().getLevel()/ 2);
		this.stamina = player.getBaseStats().getStamina() + adjuster;
		this.staminaMod = 1.0;
		this.strength = player.getBaseStats().getStrength() + adjuster;
		this.strengthMod = 1.0;
		this.defense = player.getBaseStats().getDefense() + adjuster;
		this.defenseMod = 1.0;
		this.magic = player.getBaseStats().getMagic() + adjuster;
		this.magicMod = 1.0;
		this.resistance = player.getBaseStats().getResistance() + adjuster;
		this.resistanceMod = 1.0;
		this.cunning = player.getBaseStats().getCunning() + adjuster;
		this.cunningMod = 1.0;
		this.intelligence = player.getBaseStats().getIntelligence() + adjuster;
		this.intelligenceMod = 1.0;
		this.speed = player.getBaseStats().getSpeed() + adjuster;
		this.speedMod = 1.0;
		this.skill = player.getBaseStats().getSkill() + adjuster;
		this.skillMod = 1.0;
		
		Hashtable<String, Equipable> equipment = player.getInventory().getEquipment();
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
		
		this.maxHealth = (int)(stamina + level + (defense * 0.1)) * 10;
		this.currentHealth = maxHealth;
		this.maxEnergy = (int)((2.0 * stamina) + level + (magic * 0.5) + (strength * 0.5) + (cunning * 0.5) );
		this.currentEnergy = maxEnergy;
		this.maxComboPoints = 3 + (int)((skill + cunning + intelligence)/(level * 6));
		this.actionTime = 2000;
		this.haste = (int)((speed + skill + cunning)/(level * 20.0));
		this.crit = .01 + (((speed * .25) + (skill * 1.5) + (cunning * 1.5) + (intelligence * .75))/ 2150.0);
		this.critMod = 1.0;
		this.accuracy = .95 + (((skill * 3.0) + (intelligence) + (cunning)) / 2150.0);
		this.accuracyMod = 1.0;
		this.avoidance = .01 + (((skill) + (cunning * 1.5) + (speed * 1.5)) / 2150.0);
		this.avoidanceMod = 1.0;
		this.blocking = ((defense * 3.0) / 2150.0);
		this.blockingMod = 1.0;
		this.penetration = (cunning)/ 2150.0;
		this.penetrationMod = 1.0;
		this.intimidation = (stamina * .1) + (strength * .1) + (magic * .1) + (skill * .1);
	
	}
	
	public void battleTurnUpdate () {
		
		this.daze = 0;
		this.haste =(int)(((speed * speedMod) + (skill * skillMod) + (cunning * cunningMod))/(level * 20.0));
		this.damageSpike = 0;
		this.crit = .01 + (((speed * .25 * speedMod) + (skill * 1.5 * skillMod) + (cunning * 1.5 * cunningMod) + (intelligence * .75 * intelligenceMod))/ 2150.0);
		
		this.accuracy =.95 + (((skill * skillMod * 3.0) + (intelligence * intelligenceMod) + (cunning * cunningMod)) / 2150.0);
		this.avoidance = .01 + (((skill * skillMod) + (cunning * cunningMod * 1.5) + (speed * speedMod * 1.5)) / 2150.0);
		this.blocking = ((defense * defenseMod * 3.0) / 2150.0);
		this.penetration = (cunning * cunningMod)/ 2150.0;;
		/**
		this.barrierCounter--;
		this.physicalShieldCounter--;
		this.magicShieldCounter--;
		this.intimidation = 0.0;
		this.canAttackCounter--;
		this.canUseItemsCounter--;
		this.canSkipTurnCounter--;
		this.canRunCounter--;
		this.protectionCounter--;
		this.counteringCounter--;
		this.immunityCounter--;
		this.reflectingCounter--;
		this.freecastingCounter--;
		this.exhaustedCounter--;
		this.lockedCounter--;
		this.enragedCounter--;
		this.outOfReachCounter--;
		this.reachCounter--;
		this.selfHarmCounter--;
		this.vulnerableCounter--;
		this.hiddenCounter--;
		this.cheatingDeathCounter--;
		this.weatherProofCounter--;
		**/
	}
	public BattleStats(double level, double stamina, double staminaMod, double strength, double strengthMod,
			double defense, double defenseMod, double magic, double magicMod, double resistance, double resistanceMod,
			double cunning, double cunningMod, double intelligence, double intelligenceMod, double speed,
			double speedMod, double skill, double skillMod, int maxHealth, int currentHealth, int maxEnergy,
			int currentEnergy, int maxComboPoints, int currentComboPoints, int actionTime, int daze, int haste,
			int damageSpike, double crit, double critMod, double accuracy, double accuracyMod, double avoidance,
			double avoidanceMod, double blocking, double blockingMod, double penetration, double penetrationMod,
			double barrier, int barrierCounter, double physicalShield, int physicalShieldCounter, double magicShield,
			int magicShieldCounter, double fear, double intimidation, boolean canAttack, int canAttackCounter,
			boolean canUseItems, int canUseItemsCounter, boolean canSkipTurn, int canSkipTurnCounter, boolean canRun,
			int canRunCounter, double protection, int protectionCounter, double countering, int counteringCounter,
			double immunity, int immunityCounter, double reflecting, int reflectingCounter, boolean freecasting,
			int freecastingCounter, boolean exhausted, int exhaustedCounter, boolean outOfReach, int outOfReachCounter,
			boolean reach, int reachCounter, boolean locked, int lockedCounter, boolean enraged, int enragedCounter,
			boolean selfHarm, int selfHarmCounter, boolean vulnerable, int vulnerableCounter, boolean hidden, int hiddenCounter, 
			boolean cheatingDeath, int cheatingDeathCounter, boolean weatherProof, int weatherProofCounter) {
		super();
		this.level = level;
		this.stamina = stamina;
		this.staminaMod = staminaMod;
		this.strength = strength;
		this.strengthMod = strengthMod;
		this.defense = defense;
		this.defenseMod = defenseMod;
		this.magic = magic;
		this.magicMod = magicMod;
		this.resistance = resistance;
		this.resistanceMod = resistanceMod;
		this.cunning = cunning;
		this.cunningMod = cunningMod;
		this.intelligence = intelligence;
		this.intelligenceMod = intelligenceMod;
		this.speed = speed;
		this.speedMod = speedMod;
		this.skill = skill;
		this.skillMod = skillMod;
		this.maxHealth = maxHealth;
		this.currentHealth = currentHealth;
		this.maxEnergy = maxEnergy;
		this.currentEnergy = currentEnergy;
		this.maxComboPoints = maxComboPoints;
		this.currentComboPoints = currentComboPoints;
		this.actionTime = actionTime;
		this.daze = daze;
		this.haste = haste;
		this.damageSpike = damageSpike;
		this.crit = crit;
		this.critMod = critMod;
		this.accuracy = accuracy;
		this.accuracyMod = accuracyMod;
		this.avoidance = avoidance;
		this.avoidanceMod = avoidanceMod;
		this.blocking = blocking;
		this.blockingMod = blockingMod;
		this.penetration = penetration;
		this.penetrationMod = penetrationMod;
		this.barrier = barrier;
		this.barrierCounter = barrierCounter;
		this.physicalShield = physicalShield;
		this.physicalShieldCounter = physicalShieldCounter;
		this.magicShield = magicShield;
		this.magicShieldCounter = magicShieldCounter;
		this.fear = fear;
		this.intimidation = intimidation;
		this.canAttack = canAttack;
		this.canAttackCounter = canAttackCounter;
		this.canUseItems = canUseItems;
		this.canUseItemsCounter = canUseItemsCounter;
		this.canSkipTurn = canSkipTurn;
		this.canSkipTurnCounter = canSkipTurnCounter;
		this.canRun = canRun;
		this.canRunCounter = canRunCounter;
		this.protection = protection;
		this.protectionCounter = protectionCounter;
		this.countering = countering;
		this.counteringCounter = counteringCounter;
		this.immunity = immunity;
		this.immunityCounter = immunityCounter;
		this.reflecting = reflecting;
		this.reflectingCounter = reflectingCounter;
		this.freecasting = freecasting;
		this.freecastingCounter = freecastingCounter;
		this.exhausted = exhausted;
		this.exhaustedCounter = exhaustedCounter;
		this.outOfReach = outOfReach;
		this.outOfReachCounter = outOfReachCounter;
		this.hidden = hidden;
		this.hiddenCounter = hiddenCounter;
		this.reach = reach;
		this.reachCounter = reachCounter;
		this.locked = locked;
		this.lockedCounter = lockedCounter;
		this.enraged = enraged;
		this.enragedCounter = enragedCounter;
		this.selfHarm = selfHarm;
		this.selfHarmCounter = selfHarmCounter;
		this.vulnerable = vulnerable;
		this.vulnerableCounter = vulnerableCounter;
		this.cheatingDeath = cheatingDeath;
		this.cheatingDeathCounter = cheatingDeathCounter;
		this.weatherProof = weatherProof;
		this.weatherProofCounter = weatherProofCounter;
	}

	@Override
	public String toString() {
		return "BattleStats [stamina=" + stamina + "\n staminaMod=" + staminaMod + "\n strength=" + strength
				+ "\n strengthMod=" + strengthMod + "\n defense=" + defense + "\n defenseMod=" + defenseMod + "\n magic="
				+ magic + "\n magicMod=" + magicMod + "\n resistance=" + resistance + "\n resistanceMod=" + resistanceMod
				+ "\n cunning=" + cunning + "\n cunningMod=" + cunningMod + "\n intelligence=" + intelligence
				+ "\n intelligenceMod=" + intelligenceMod + "\n speed=" + speed + "\n speedMod=" + speedMod + "\n skill="
				+ skill + "\n skillMod=" + skillMod + "\n maxHealth=" + maxHealth + "\n currentHealth=" + currentHealth
				+ "\n maxEnergy=" + maxEnergy + "\n currentEnergy=" + currentEnergy + "\n maxComboPoints=" + maxComboPoints
				+ "\n currentComboPoints=" + currentComboPoints + "\n actionTime=" + actionTime + "\n daze=" + daze
				+ "\n haste=" + haste + "\n damageSpike=" + damageSpike + "\n crit=" + crit + "\n critMod=" + critMod
				+ "\n accuracy=" + accuracy + "\n accuracyMod=" + accuracyMod + "\n avoidance=" + avoidance
				+ "\n avoidanceMod=" + avoidanceMod + "\n blocking=" + blocking + "\n blockingMod=" + blockingMod
				+ "\n penetration=" + penetration + "\n penetrationMod=" + penetrationMod + "\n barrier=" + barrier
				+ "\n barrierCounter=" + barrierCounter + "\n physicalShield=" + physicalShield
				+ "\n physicalShieldCounter=" + physicalShieldCounter + "\n magicShield=" + magicShield
				+ "\n magicShieldCounter=" + magicShieldCounter + "\n fear=" + fear + "\n intimidation=" + intimidation
				+ "\n canAttack=" + canAttack + "\n canAttackCounter=" + canAttackCounter + "\n canUseItems=" + canUseItems
				+ "\n canUseItemsCounter=" + canUseItemsCounter + "\n canSkipTurn=" + canSkipTurn
				+ "\n canSkipTurnCounter=" + canSkipTurnCounter + "\n canRun=" + canRun + "\n canRunCounter="
				+ canRunCounter + "\n locked=" + locked + "\n lockedCounter=" + lockedCounter + "\n protection="
				+ protection + "\n protectionCounter=" + protectionCounter + "\n immunity=" + immunity
				+ "\n immunityCounter=" + immunityCounter + "\n countering=" + countering + "\n counteringCounter="
				+ counteringCounter + "\n reflecting=" + reflecting + "\n reflectingCounter=" + reflectingCounter
				+ "\n freecasting=" + freecasting + "\n freecastingCounter=" + freecastingCounter + "\n exhausted="
				+ exhausted + "\n exhaustedCounter=" + exhaustedCounter + "\n outOfReach=" + outOfReach
				+ "\n outOfReachCounter=" + outOfReachCounter + "\n reach=" + reach + "\n reachCounter=" + reachCounter
				+ "\n hidden=" + hidden + "\n hiddenCounter=" + hiddenCounter + "\n enraged=" + enraged
				+ "\n enragedCounter=" + enragedCounter + "\n selfHarm=" + selfHarm + "\n selfHarmCounter="
				+ selfHarmCounter + "\n vulnerable=" + vulnerable + "\n vulnerableCounter=" + vulnerableCounter
				+ "\n cheatingDeath=" + cheatingDeath + "\n cheatingDeathCounter=" + cheatingDeathCounter + "]";
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
	public void changeBarrier(double barrier) {
		this.barrier += barrier;
	}

	public double getPhysicalShield() {
		return physicalShield;
	}

	public void setPhysicalShield(double physicalShield) {
		this.physicalShield = physicalShield;
	}
	public void changePhysicalShield(double physicalShield) {
		this.physicalShield += physicalShield;
	}

	public double getMagicShield() {
		return magicShield;
	}

	public void setMagicShield(double magicShield) {
		this.magicShield = magicShield;
	}
	public void changeMagicShield(double magicShield) {
		this.magicShield += magicShield;
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
	public void changeProtection(double protectionMod) {
		this.protection += protectionMod;
		if (this.protection < 0.0) {
			this.protection = 0.0;
		}
		if (this.protection > 100.0) {
			this.protection = 100.0;
		}
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
	public void changeCountering(double counteringMod) {
		this.countering += counteringMod;
		if (this.countering < 0.0) {
			this.countering = 0.0;
		}
		if (this.countering > 200.0) {
			this.countering = 200.0;
		}
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
	public void changeImmunity(double immunityMod) {
		this.immunity += immunityMod;
		if (this.immunity < 0.0) {
			this.immunity = 0.0;
		}
		if (this.immunity > 100.0) {
			this.immunity = 100.0;
		}
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
	public void changeReflecting(double reflectingMod) {
		this.reflecting += reflectingMod;
		if (this.reflecting < 0.0) {
			this.reflecting = 0.0;
		}
		if (this.reflecting > 200.0) {
			this.reflecting = 200.0;
		}
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
	public void changeStaminaMod(double staminaMod) {
		double mod = 1.0;
		if (this.staminaMod > 1.0) {
			mod = 2.0;
		}
		this.staminaMod += (staminaMod * mod);
		if (this.staminaMod > 3.1) {
			staminaMod = 3.1;
		}
		if (this.staminaMod < .1) {
			this.staminaMod = .1;
		}
	}

	public double getStrengthMod() {
		return strengthMod;
	}

	public void setStrengthMod(double strengthMod) {
		this.strengthMod = strengthMod;
	}
	public void changeStrengthMod(double strengthMod) {
		double mod = 1.0;
		if (this.strengthMod > 1.0) {
			mod = 2.0;
		}
		this.strengthMod += (strengthMod * mod);
		if (this.strengthMod > 3.1) {
			strengthMod = 3.1;
		}
		if (this.strengthMod < .1) {
			this.strengthMod = .1;
		}
	}

	public double getDefenseMod() {
		return defenseMod;
	}

	public void setDefenseMod(double defenseMod) {
		this.defenseMod = defenseMod;
	}
	public void changeDefenseMod(double defenseMod) {
		double mod = 1.0;
		if (this.defenseMod >= 1.0) {
			mod = 2.0;
		}
		this.defenseMod += (defenseMod * mod);
		if (this.defenseMod > 3.1) {
			defenseMod = 3.1;
		}
		if (this.defenseMod < .1) {
			this.defenseMod = .1;
		}
	}

	public double getMagicMod() {
		return magicMod;
	}

	public void setMagicMod(double magicMod) {
		this.magicMod = magicMod;
	}
	public void changeMagicMod(double magicMod) {
		double mod = 1.0;
		if (this.magicMod > 1.0) {
			mod = 2.0;
		}
		this.magicMod += (magicMod * mod);
		if (this.magicMod > 3.1) {
			magicMod = 3.1;
		}
		if (this.magicMod < .1) {
			this.magicMod = .1;
		}
	}

	public double getResistanceMod() {
		return resistanceMod;
	}

	public void setResistanceMod(double resistanceMod) {
		this.resistanceMod = resistanceMod;
	}
	public void changeResistanceMod(double resistanceMod) {
		double mod = 1.0;
		if (this.resistanceMod > 1.0) {
			mod = 2.0;
		}
		this.resistanceMod += (resistanceMod * mod);
		if (this.resistanceMod > 3.1) {
			resistanceMod = 3.1;
		}
		if (this.resistanceMod < .1) {
			this.resistanceMod = .1;
		}
	}

	public double getCunningMod() {
		return cunningMod;
	}

	public void setCunningMod(double cunningMod) {
		this.cunningMod = cunningMod;
	}
	public void changeCunningMod(double cunningMod) {
		double mod = 1.0;
		if (this.cunningMod > 1.0) {
			mod = 2.0;
		}
		this.cunningMod += (cunningMod * mod);
		if (this.cunningMod > 3.1) {
			cunningMod = 3.1;
		}
		if (this.cunningMod < .1) {
			this.cunningMod = .1;
		}
	}

	public double getIntelligenceMod() {
		return intelligenceMod;
	}

	public void setIntelligenceMod(double intelligenceMod) {
		this.intelligenceMod = intelligenceMod;
	}
	public void changeIntelligenceMod(double intelligenceMod) {
		double mod = 1.0;
		if (this.intelligenceMod > 1.0) {
			mod = 2.0;
		}
		this.intelligenceMod += (intelligenceMod * mod);
		if (this.intelligenceMod > 3.1) {
			intelligenceMod = 3.1;
		}
		if (this.intelligenceMod < .1) {
			this.intelligenceMod = .1;
		}
	}

	public double getSpeedMod() {
		return speedMod;
	}

	public void setSpeedMod(double speedMod) {
		this.speedMod = speedMod;
	}
	public void changeSpeedMod(double speedMod) {
		double mod = 1.0;
		if (this.speedMod > 1.0) {
			mod = 2.0;
		}
		this.speedMod += (speedMod * mod);
		if (this.speedMod > 3.1) {
			speedMod = 3.1;
		}
		if (this.speedMod < .1) {
			this.speedMod = .1;
		}
	}

	public double getSkillMod() {
		return skillMod;
	}

	public void setSkillMod(double skillMod) {
		this.skillMod = skillMod;
	}
	public void changeSkillMod(double skillMod) {
		double mod = 1.0;
		if (this.skillMod > 1.0) {
			mod = 2.0;
		}
		this.skillMod += (skillMod * mod);
		if (this.skillMod > 3.1) {
			skillMod = 3.1;
		}
		if (this.skillMod < .1) {
			this.skillMod = .1;
		}
	}

	public double getCritMod() {
		return critMod;
	}

	public void setCritMod(double critMod) {
		this.critMod = critMod;
	}
	public void changeCritMod(double critMod) {
		double mod = 1.0;
		if (this.critMod > 1.0) {
			mod = 2.0;
		}
		this.critMod += (critMod * mod);
		if (this.critMod > 3.1) {
			critMod = 3.1;
		}
		if (this.critMod < .1) {
			this.critMod = .1;
		}
	}

	public double getAccuracyMod() {
		return accuracyMod;
	}

	public void setAccuracyMod(double accuracyMod) {
		this.accuracyMod = accuracyMod;
	}
	public void changeAccuracyMod(double accuracyMod) {
		double mod = 1.0;
		if (this.accuracyMod > 1.0) {
			mod = 2.0;
		}
		this.accuracyMod += (accuracyMod * mod);
		if (this.accuracyMod > 3.1) {
			accuracyMod = 3.1;
		}
		if (this.accuracyMod < .1) {
			this.accuracyMod = .1;
		}
	}

	public double getAvoidanceMod() {
		return avoidanceMod;
	}

	public void setAvoidanceMod(double avoidanceMod) {
		this.avoidanceMod = avoidanceMod;
	}
	public void changeAvoidanceMod(double avoidanceMod) {
		double mod = 1.0;
		if (this.avoidanceMod > 1.0) {
			mod = 2.0;
		}
		this.avoidanceMod += (avoidanceMod * mod);
		if (this.avoidanceMod > 3.1) {
			avoidanceMod = 3.1;
		}
		if (this.avoidanceMod < .1) {
			this.avoidanceMod = .1;
		}
	}

	public double getBlockingMod() {
		return blockingMod;
	}

	public void setBlockingMod(double blockingMod) {
		this.blockingMod = blockingMod;
	}
	public void changeBlockingMod(double blockingMod) {
		double mod = 1.0;
		if (this.blockingMod > 1.0) {
			mod = 2.0;
		}
		this.blockingMod += (blockingMod * mod);
		if (this.blockingMod > 3.1) {
			blockingMod = 3.1;
		}
		if (this.blockingMod < .1) {
			this.blockingMod = .1;
		}
	}

	public double getPenetrationMod() {
		return penetrationMod;
	}

	public void setPenetrationMod(double penetrationMod) {
		this.penetrationMod = penetrationMod;
	}
	public void changePenetrationMod(double penetrationMod) {
		double mod = 1.0;
		if (this.penetrationMod > 1.0) {
			mod = 2.0;
		}
		this.penetrationMod += (penetrationMod * mod);
		if (this.penetrationMod > 3.1) {
			penetrationMod = 3.1;
		}
		if (this.penetrationMod < .1) {
			this.penetrationMod = .1;
		}
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

	public boolean isOutOfReach() {
		return outOfReach;
	}

	public void setOutOfReach(boolean outOfReach) {
		this.outOfReach = outOfReach;
	}

	public int getOutOfReachCounter() {
		return outOfReachCounter;
	}

	public void setOutOfReachCounter(int outOfReachCounter) {
		this.outOfReachCounter = outOfReachCounter;
	}

	public boolean isReach() {
		return reach;
	}

	public void setReach(boolean reach) {
		this.reach = reach;
	}

	public int getReachCounter() {
		return reachCounter;
	}

	public void setReachCounter(int reachCounter) {
		this.reachCounter = reachCounter;
	}

	public double getAdjuster() {
		return adjuster;
	}

	public void setAdjuster(double adjuster) {
		this.adjuster = adjuster;
	}

	public boolean isSelfHarm() {
		return selfHarm;
	}

	public void setSelfHarm(boolean selfHarm) {
		this.selfHarm = selfHarm;
	}

	public int getSelfHarmCounter() {
		return selfHarmCounter;
	}

	public void setSelfHarmCounter(int selfHarmCounter) {
		this.selfHarmCounter = selfHarmCounter;
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

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public int getHiddenCounter() {
		return hiddenCounter;
	}

	public void setHiddenCounter(int hiddenCounter) {
		this.hiddenCounter = hiddenCounter;
	}

	public boolean isCheatingDeath() {
		return cheatingDeath;
	}

	public void setCheatingDeath(boolean cheatingDeath) {
		this.cheatingDeath = cheatingDeath;
	}

	public int getCheatingDeathCounter() {
		return cheatingDeathCounter;
	}

	public void setCheatingDeathCounter(int cheatingDeathCounter) {
		this.cheatingDeathCounter = cheatingDeathCounter;
	}

	public boolean isWeatherProof() {
		return weatherProof;
	}

	public void setWeatherProof(boolean weatherProof) {
		this.weatherProof = weatherProof;
	}

	public int getWeatherProofCounter() {
		return weatherProofCounter;
	}

	public void setWeatherProofCounter(int weatherProofCounter) {
		this.weatherProofCounter = weatherProofCounter;
	}
	

}
