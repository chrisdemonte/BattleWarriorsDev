package attacks;

import models.BaseStats;

public class PhysicalHeal implements Damage{
	String name;
	String description;
	double healingPower;
	double bonusHealing; 
	int energyCost;
	int uses;
	int currentUses;
	int comboPointGain;
	int comboPointRequirement;
	
	double accuracy;
	double crit;
	double time;
	
	Buff intialSelf;
	Buff intialTarget;
	Buff periodicSelf;
	Buff periodicTarget;
	Buff finalSelf;
	Buff finalTarget;
	
	BaseStats requirements;

	@Override
	public void doDamage(Character self, Character target) {
		// TODO Auto-generated method stub
		
	}

}
