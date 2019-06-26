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
	
	Buff intialSelf;
	Buff intialTarget;
	Buff periodicSelf;
	Buff periodicTarget;
	Buff finalSelf;
	Buff finalTarget;
	
	BaseStats requirements;

	public CunningAttack(String name, String description, int energyCost, int uses, int currentUses, int comboPointGain,
			int comboPointRequirement, int time, double physicalPower, double magicPower, double bonusDamage,
			double accuracy, double avoidability, double crit, double penetration, boolean rangedAttack,
			Buff intialSelf, Buff intialTarget, Buff periodicSelf, Buff periodicTarget, Buff finalSelf,
			Buff finalTarget, BaseStats requirements) {
		super(name, description, energyCost, uses, currentUses, comboPointGain, comboPointRequirement, time);
		this.physicalPower = physicalPower;
		this.magicPower = magicPower;
		this.bonusDamage = bonusDamage;
		this.accuracy = accuracy;
		this.avoidability = avoidability;
		this.crit = crit;
		this.penetration = penetration;
		this.rangedAttack = rangedAttack;
		this.intialSelf = intialSelf;
		this.intialTarget = intialTarget;
		this.periodicSelf = periodicSelf;
		this.periodicTarget = periodicTarget;
		this.finalSelf = finalSelf;
		this.finalTarget = finalTarget;
		this.requirements = requirements;
	}






}
