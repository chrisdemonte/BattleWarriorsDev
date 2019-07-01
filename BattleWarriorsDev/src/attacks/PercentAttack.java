package attacks;

import models.BaseStats;

public class PercentAttack extends Move {
	
	double percentDamage;
	
	double accuracy;
	double avoidability;
	boolean rangedAttack;
	boolean priority;
	
	public PercentAttack(String name, String description, String[] keywords,int energyCost, int uses, int currentUses, int comboPointGain,
			int comboPointRequirement, int time, int cooldown, int cooldownCounter, Buff self, Buff target,
			BaseStats requirements, double percentDamage, double accuracy, double avoidability, boolean rangedAttack,
			boolean priority) {
		super(name, description, keywords, energyCost, uses, currentUses, comboPointGain, comboPointRequirement, time, cooldown,
				cooldownCounter, self, target, requirements);
		this.percentDamage = percentDamage;
		this.accuracy = accuracy;
		this.avoidability = avoidability;
		this.rangedAttack = rangedAttack;
		this.priority = priority;
	}
	

}
