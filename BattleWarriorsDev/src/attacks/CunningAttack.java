package attacks;

import models.BaseStats;
import models.Player;

public class CunningAttack extends Move{
	
	double physicalPower;
	double magicPower;
	double bonusDamage;
	
	double accuracy;
	double avoidability;
	double crit;
	double penetration; 
	boolean rangedAttack;
	
	public CunningAttack(String name, String description, int energyCost, int uses, int currentUses, int comboPointGain,
			int comboPointRequirement, int time, int cooldown, int cooldownCounter, Buff self, Buff target,
			BaseStats requirements, double physicalPower, double magicPower, double bonusDamage, double accuracy,
			double avoidability, double crit, double penetration, boolean rangedAttack) {
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
	}








}
