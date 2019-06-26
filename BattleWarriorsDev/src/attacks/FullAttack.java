package attacks;

import models.BaseStats;

public class FullAttack extends Move{
	
	double physicalPower;
	double magicPower;
	double bonusDamage;
	
	double accuracy;
	double avoidability;
	double crit;
	double penetration; 
	boolean rangedAttack;
	boolean priority;
	
	Buff intialSelf;
	Buff intialTarget;
	Buff periodicSelf;
	Buff periodicTarget;
	Buff finalSelf;
	Buff finalTarget;
	
	BaseStats requirements;
	


	public FullAttack(String name, String description, int energyCost, int uses, int currentUses, int comboPointGain,
			int comboPointRequirement, int time, int cooldown, int cooldownCounter, Buff self, Buff target,
			BaseStats requirements, double physicalPower, double magicPower, double bonusDamage, double accuracy,
			double avoidability, double crit, double penetration, boolean rangedAttack, boolean priority,
			Buff intialSelf, Buff intialTarget, Buff periodicSelf, Buff periodicTarget, Buff finalSelf,
			Buff finalTarget, BaseStats requirements2) {
		super(name, description, energyCost, uses, currentUses, comboPointGain, comboPointRequirement, time, cooldown,
				cooldownCounter, self, target, requirements);
		this.physicalPower = physicalPower;
		this.magicPower = magicPower;
		this.bonusDamage = bonusDamage;
		this.accuracy = accuracy;
		this.avoidability = avoidability;
		this.crit = crit;
		this.penetration = penetration;
		this.rangedAttack = rangedAttack;
		this.priority = priority;
		this.intialSelf = intialSelf;
		this.intialTarget = intialTarget;
		this.periodicSelf = periodicSelf;
		this.periodicTarget = periodicTarget;
		this.finalSelf = finalSelf;
		this.finalTarget = finalTarget;
		requirements = requirements2;
	}

	public FullAttack () {
		super("Sample Attack", "You strike a foe on the body and/or head", 1, 50, 50, 0, 0, 1000, 0, 0, null, null, null);
		this.physicalPower = 1.0;
		this.magicPower = 1.0;
		this.bonusDamage = 5;
		this.accuracy = 0.0;
		this.avoidability = 0.0;
		this.crit = 0.0;
		this.penetration = 0.0;
		this.rangedAttack = false;
		this.priority = false;
	}

	public double getPhysicalPower() {
		return physicalPower;
	}
	public void setPhysicalPower(double physicalPower) {
		this.physicalPower = physicalPower;
	}
	public double getMagicPower() {
		return magicPower;
	}
	public void setMagicPower(double magicPower) {
		this.magicPower = magicPower;
	}
	public double getBonusDamage() {
		return bonusDamage;
	}
	public void setBonusDamage(double bonusDamage) {
		this.bonusDamage = bonusDamage;
	}
	public double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}
	public double getAvoidability() {
		return avoidability;
	}
	public void setAvoidability(double avoidability) {
		this.avoidability = avoidability;
	}
	public double getCrit() {
		return crit;
	}
	public void setCrit(double crit) {
		this.crit = crit;
	}
	public double getPenetration() {
		return penetration;
	}
	public void setPenetration(double penetration) {
		this.penetration = penetration;
	}
	public boolean isRangedAttack() {
		return rangedAttack;
	}
	public void setRangedAttack(boolean rangedAttack) {
		this.rangedAttack = rangedAttack;
	}
	public boolean isPriority() {
		return priority;
	}
	public void setPriority(boolean priority) {
		this.priority = priority;
	}
	public Buff getIntialSelf() {
		return intialSelf;
	}
	public void setIntialSelf(Buff intialSelf) {
		this.intialSelf = intialSelf;
	}
	public Buff getIntialTarget() {
		return intialTarget;
	}
	public void setIntialTarget(Buff intialTarget) {
		this.intialTarget = intialTarget;
	}
	public Buff getPeriodicSelf() {
		return periodicSelf;
	}
	public void setPeriodicSelf(Buff periodicSelf) {
		this.periodicSelf = periodicSelf;
	}
	public Buff getPeriodicTarget() {
		return periodicTarget;
	}
	public void setPeriodicTarget(Buff periodicTarget) {
		this.periodicTarget = periodicTarget;
	}
	public Buff getFinalSelf() {
		return finalSelf;
	}
	public void setFinalSelf(Buff finalSelf) {
		this.finalSelf = finalSelf;
	}
	public Buff getFinalTarget() {
		return finalTarget;
	}
	public void setFinalTarget(Buff finalTarget) {
		this.finalTarget = finalTarget;
	}
	public BaseStats getRequirements() {
		return requirements;
	}
	public void setRequirements(BaseStats requirements) {
		this.requirements = requirements;
	}

}
