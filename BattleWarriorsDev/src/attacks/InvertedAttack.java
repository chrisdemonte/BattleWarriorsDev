package attacks;

import models.BaseStats;

public class InvertedAttack implements Damage{

	String name;
	String description;
	
	double physicalPower;
	double magicPower;
	double bonusDamage;
	int energyCost;
	int uses;
	int currentUses;
	int comboPointGain;
	int comboPointRequirement;
	
	double accuracy;
	double avoidability;
	double crit;
	double penetration; 
	double time;
	boolean rangedAttack;
	
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
