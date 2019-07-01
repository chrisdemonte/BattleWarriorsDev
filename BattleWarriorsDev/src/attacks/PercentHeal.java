package attacks;

import models.BaseStats;

public class PercentHeal extends Move{
	
	double percentHeal;
	double accuracy;
	double priority;
	
	public PercentHeal(String name, String description, String[] keywords, int energyCost, int uses, int currentUses, int comboPointGain,
			int comboPointRequirement, int time, int cooldown, int cooldownCounter, Buff self, Buff target,
			BaseStats requirements, double percentHeal, double accuracy, double priority) {
		super(name, description, keywords, energyCost, uses, currentUses, comboPointGain, comboPointRequirement, time, cooldown,
				cooldownCounter, self, target, requirements);
		this.percentHeal = percentHeal;
		this.accuracy = accuracy;
		this.priority = priority;
	}

}
