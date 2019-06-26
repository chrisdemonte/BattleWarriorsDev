package attacks;

import models.BaseStats;
import models.Player;

public class MagicHeal extends Move{
	
	double healingPower;
	double bonusHealing; 
	double accuracy;
	double crit;
	
	public MagicHeal(String name, String description, int energyCost, int uses, int currentUses, int comboPointGain,
			int comboPointRequirement, int time, int cooldown, int cooldownCounter, Buff self, Buff target,
			BaseStats requirements, double healingPower, double bonusHealing, double accuracy, double crit) {
		super(name, description, energyCost, uses, currentUses, comboPointGain, comboPointRequirement, time, cooldown,
				cooldownCounter, self, target, requirements);
		this.healingPower = healingPower;
		this.bonusHealing = bonusHealing;
		this.accuracy = accuracy;
		this.crit = crit;
	}


}
