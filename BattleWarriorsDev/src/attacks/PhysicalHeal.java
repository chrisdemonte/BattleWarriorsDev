package attacks;

import models.BaseStats;
import models.Player;

public class PhysicalHeal extends Move{

	double healingPower;
	double bonusHealing; 
	
	double accuracy;
	double crit;
	boolean priority;
	
	public PhysicalHeal(String name, String description, String[] keywords, int energyCost, int uses, int currentUses, int comboPointGain,
			int comboPointRequirement, int time, int cooldown, int cooldownCounter, Buff self, Buff target,
			BaseStats requirements, double healingPower, double bonusHealing, double accuracy, double crit,  boolean priority) {
		super(name, description, keywords, energyCost, uses, currentUses, comboPointGain, comboPointRequirement, time, cooldown,
				cooldownCounter, self, target, requirements);
		this.healingPower = healingPower;
		this.bonusHealing = bonusHealing;
		this.accuracy = accuracy;
		this.crit = crit;
		this.priority = priority;
	}
	

}
