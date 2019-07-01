package attacks;

import models.BaseStats;
import models.Player;

public class InvertedAttack extends Move{

	double physicalPower;
	double magicPower;
	double bonusDamage;

	double accuracy;
	double avoidability;
	double crit;
	double penetration; 
	boolean rangedAttack;
	boolean priority;

	public InvertedAttack(String name, String description, String[] keywords,int energyCost, int uses, int currentUses,
			int comboPointGain, int comboPointRequirement, int time, int cooldown, int cooldownCounter, Buff self,
			Buff target, BaseStats requirements, double physicalPower, double magicPower, double bonusDamage,
			double accuracy, double avoidability, double crit, double penetration, boolean rangedAttack,  boolean priority) {
		super(name, description, keywords, energyCost, uses, currentUses, comboPointGain, comboPointRequirement, time, cooldown,
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

	public BaseStats getRequirements() {
		return requirements;
	}

	public void setRequirements(BaseStats requirements) {
		this.requirements = requirements;
	}

	
	
}
