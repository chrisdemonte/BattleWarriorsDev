package attacks;

import models.BaseStats;

public class FinishingAttack extends Move{
	
	double physicalPower;
	double magicPower;
	double bonusDamage;
	double percentAvailable;
	
	double accuracy;
	double avoidability;
	double crit;
	double penetration; 
	boolean rangedAttack;
	boolean priority;
	
	public FinishingAttack(String name, String description, String[] keywords, int energyCost, int uses, int currentUses,
			int comboPointGain, int comboPointRequirement, int time, int cooldown, int cooldownCounter, Buff self,
			Buff target, BaseStats requirements, double physicalPower, double magicPower, double bonusDamage,
			double percentAvailable, double accuracy, double avoidability, double crit, double penetration,
			boolean rangedAttack, boolean priority) {
		super(name, description, keywords, energyCost, uses, currentUses, comboPointGain, comboPointRequirement, time, cooldown,
				cooldownCounter, self, target, requirements);
		this.physicalPower = physicalPower;
		this.magicPower = magicPower;
		this.bonusDamage = bonusDamage;
		this.percentAvailable = percentAvailable;
		this.accuracy = accuracy;
		this.avoidability = avoidability;
		this.crit = crit;
		this.penetration = penetration;
		this.rangedAttack = rangedAttack;
		this.priority = priority;
	}
	


	
}
