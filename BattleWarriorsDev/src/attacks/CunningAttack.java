package attacks;

import models.BaseStats;
import models.Player;

public class CunningAttack extends Move{
	
	double physicalPower;
	double magicPower;
	double cunningPower;
	double bonusDamage;
	
	double accuracy;
	double avoidability;
	double crit;
	double penetration; 
	boolean rangedAttack;
	boolean priority;
	
	public CunningAttack(String name, String description, String[] keywords, int energyCost, int uses, int currentUses, int comboPointGain,
			int comboPointRequirement, int time, int cooldown, int cooldownCounter, Buff self, Buff target,
			BaseStats requirements, double physicalPower, double magicPower, double cunningPower, double bonusDamage, double accuracy,
			double avoidability, double crit, double penetration, boolean rangedAttack,  boolean priority) {
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
		this.cunningPower = cunningPower;
		this.priority = priority;
	}








}
