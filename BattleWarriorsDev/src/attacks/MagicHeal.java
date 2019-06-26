package attacks;

import models.BaseStats;
import models.Player;

public class MagicHeal extends Move{
	
	double healingPower;
	double bonusHealing; 
	double accuracy;
	double crit;

	Buff intialSelf;
	Buff intialTarget;
	Buff periodicSelf;
	Buff periodicTarget;
	Buff finalSelf;
	Buff finalTarget;
	
	BaseStats requirements;

	public MagicHeal(String name, String description, int energyCost, int uses, int currentUses, int comboPointGain,
			int comboPointRequirement, int time, double healingPower, double bonusHealing, double accuracy, double crit,
			Buff intialSelf, Buff intialTarget, Buff periodicSelf, Buff periodicTarget, Buff finalSelf,
			Buff finalTarget, BaseStats requirements) {
		super(name, description, energyCost, uses, currentUses, comboPointGain, comboPointRequirement, time);
		this.healingPower = healingPower;
		this.bonusHealing = bonusHealing;
		this.accuracy = accuracy;
		this.crit = crit;
		this.intialSelf = intialSelf;
		this.intialTarget = intialTarget;
		this.periodicSelf = periodicSelf;
		this.periodicTarget = periodicTarget;
		this.finalSelf = finalSelf;
		this.finalTarget = finalTarget;
		this.requirements = requirements;
	}





}
