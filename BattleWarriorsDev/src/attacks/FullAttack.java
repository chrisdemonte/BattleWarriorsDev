package attacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import models.BaseStats;
import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class FullAttack extends Move{
	

	private static final long serialVersionUID = 3317491816116719451L;
	double physicalPower;
	double magicPower;
	double bonusDamage;
	
	double accuracy;
	double avoidability;
	double crit;
	double penetration; 
	boolean rangedAttack;
	
	
	public FullAttack(String name, String description, String customText, String[] keywords,int energyCost, int uses, int currentUses, int comboPointGain,
			int comboPointRequirement, int time, int cooldown, int cooldownCounter, Buff self, Buff target,
			BaseStats requirements, double physicalPower, double magicPower, double bonusDamage, double accuracy,
			double avoidability, double crit, double penetration, boolean rangedAttack, boolean priority ) {
		super(name, description, customText, keywords, energyCost, uses, currentUses, comboPointGain, comboPointRequirement, time, cooldown,
				cooldownCounter, priority, self, target, requirements);
		this.physicalPower = physicalPower;
		this.magicPower = magicPower;
		this.bonusDamage = bonusDamage;
		this.accuracy = accuracy;
		this.avoidability = avoidability;
		this.crit = crit;
		this.penetration = penetration;
		this.rangedAttack = rangedAttack;
		
	
	}

	public FullAttack () {
		super("Sample Attack", "You strike a foe on the body and/or head", "",null, 1, 50, 50, 0, 0, 600, 0, 0, false, null, null, null);
		this.physicalPower = 1.0;
		this.magicPower = 1.0;
		this.bonusDamage = 5;
		this.accuracy = 0.0;
		this.avoidability = 0.0;
		this.crit = 0.0;
		this.penetration = 0.0;
		this.rangedAttack = false;
		this.priority = false;
	}

	
	@Override
	public void makeMove(Player self, Player target, BattleLog log) {
		
		BattleStats selfStats = self.getBattleStats();
		BattleStats targetStats = target.getBattleStats();
		Random rand = new Random();
		ArrayList<String> logDetails = new ArrayList<String>();
		//damage multiplier
		double mod = 1.0;
		if (rand.nextInt(100) < (selfStats.getCrit() * selfStats.getCritMod())){
			mod += .6;
			logDetails.add("\t!! Critical Hit !!");
		}
		if (selfStats.getDamageSpike() > 0) {
			mod += .3;
			selfStats.setDamageSpike(selfStats.getDamageSpike() - 1);
			logDetails.add("\t!! Damage Spike !!");
		}
		//energy cost, cooldown, and attack uses
		
		this.currentUses--;
		int cost = this.energyCost;
		if (selfStats.isExhausted()) {
			cost *= 2;
		}
		if (selfStats.isFreecasting()) {
			cost*= 0;
		}
		selfStats.setCurrentEnergy(selfStats.getCurrentEnergy() - cost);
		this.cooldownCounter = this.cooldown;
		//hit, miss, or enemy dodge
		
		boolean makeContact = true;
		if (targetStats.isOutOfReach() && (!selfStats.isReach() && !this.rangedAttack)) {
			makeContact = false;
			log.getLog().add(self.getName() + "'s " + this.getName() + " missed. " + target.getName() + " is out of range!");
			log.setLogLength(log.getLogLength() + 1);
		}
		if (makeContact && (rand.nextInt(100) > ((selfStats.getAccuracy() * selfStats.getAccuracyMod() * 100) + this.accuracy))) {
			
			makeContact = false;
			log.getLog().add(self.getName() + "'s " + this.getName() + " missed.");
			log.setLogLength(log.getLogLength() + 1);
		}
		if (makeContact && (rand.nextInt(100) < ((targetStats.getAvoidance() * targetStats.getAvoidanceMod() * 100) - (this.avoidability + (selfStats.getSkill()/4350.0))))
				&& !targetStats.isVulnerable()){
			
			makeContact = false;
			log.getLog().add(self.getName() + "'s " + this.getName() + " was dodged.");
			log.setLogLength(log.getLogLength() + 1);
		}
		//damage
		if (makeContact) {
			double physicalDamage = 0.0;
			double magicDamage = 0.0;
			
			double totalPhysical = 0.0;
			double totalMagic = 0.0;
			
			double multiplier = 1.0;
			
			double physicalBounceBack = 0.0;
			double magicBounceBack = 0.0;
			
			double targetResist = (targetStats.getResistance() * targetStats.getResistanceMod()) * (1.0 - (self.getBattleStats().getPenetration() * self.getBattleStats().getPenetrationMod()));
			double targetDef = (targetStats.getDefense() * targetStats.getDefenseMod())*(1.0 - (self.getBattleStats().getPenetration() * self.getBattleStats().getPenetrationMod()));
			
			String logEntry = new String(self.getName() + "'s " + this.getName() + " did ");
			
			
			if (this.physicalPower > 0.0) {
				physicalDamage += (selfStats.getStrength() * selfStats.getStrengthMod() * mod * this.physicalPower) + this.getBonusDamage();
				multiplier = (((2 * self.getBattleStats().getLevel()) + 50.0) - targetDef) / ((2 * self.getBattleStats().getLevel()) + 50.0);
				if (multiplier < .1) {
					multiplier = .1;
				}
				double subtraction = (physicalDamage * .5) - targetDef;
				if (subtraction < 0) {
					subtraction = 0;
				}
				double division = (physicalDamage * .5) * multiplier;
				
				totalPhysical = division + subtraction;
				
				if (targetStats.getCountering() > 0.0) {
					physicalBounceBack += totalPhysical * targetStats.getCountering();
				}
				if (!targetStats.isVulnerable() && rand.nextInt(100) < targetStats.getBlocking()) {
					logDetails.add("\t" + (int)(physicalDamage * targetStats.getBlocking()) + " blocked.");
					physicalDamage -= physicalDamage * targetStats.getBlocking();
				}
			}
			if (this.magicPower > 0.0) {
				magicDamage += (selfStats.getMagic() * selfStats.getMagicMod() * mod * this.magicPower) + this.getBonusDamage();
				multiplier = (((2 * self.getBattleStats().getLevel()) + 50.0) - targetResist) / ((2 * self.getBattleStats().getLevel()) + 50.0);
				if (multiplier < .1) {
					multiplier = .1;
				}
				double subtraction = (magicDamage * .5) - targetResist ;
				if (subtraction < 0) {
					subtraction = 0;
				}
				double division = (magicDamage * .5) * multiplier;
				totalMagic = division + subtraction;
				
				if (targetStats.getReflecting() > 0.0) {
					magicBounceBack += totalMagic * targetStats.getReflecting(); 
				}
			}
			if (targetStats.getImmunity() > 0.0) {
				logDetails.add("\t" + (int)((1.0 - targetStats.getImmunity())* 100) + "% damage resisted.");
				totalMagic *= (1.0 - targetStats.getImmunity());
			}
			if (targetStats.getProtection() > 0.0) {
				logDetails.add("\t" + (int)((1.0 - targetStats.getProtection())* 100) + "% damage reduced.");
				totalPhysical *= (1.0 - targetStats.getProtection());
			}
			if (totalMagic > 0.0 && targetStats.getMagicShield() > 0.0 && !targetStats.isVulnerable()) {
				if (totalMagic >= targetStats.getMagicShield()) {
					logDetails.add("\t" + (int)targetStats.getMagicShield() + " damage absorbed.");
					totalMagic -= targetStats.getMagicShield();
					targetStats.setMagicShield(0.0);
				}
				else  {
					logDetails.add("\t" + (int)totalMagic + " damage absorbed.");
					targetStats.setMagicShield(targetStats.getMagicShield() - totalMagic);
					totalMagic = 0.0;
				}
			}
			if (totalPhysical > 0.0 && targetStats.getPhysicalShield() > 0.0 && !targetStats.isVulnerable()) {
				if (totalPhysical >= targetStats.getPhysicalShield()) {
					logDetails.add("\t" + (int)targetStats.getPhysicalShield() + " damage shielded.");
					totalPhysical -= targetStats.getPhysicalShield();
					targetStats.setPhysicalShield(0.0);
				}
				else {
					logDetails.add("\t" + (int)totalPhysical + " damage shielded.");
					targetStats.setPhysicalShield(targetStats.getPhysicalShield() - totalPhysical);
					totalPhysical = 0.0;
				}
			}
			if (targetStats.getBarrier() > 0.0 && !targetStats.isVulnerable()) {
				if (totalMagic >= targetStats.getBarrier()) {
					logDetails.add("\t" + (int)targetStats.getBarrier() + " damage absorbed.");
					totalMagic -= targetStats.getBarrier();
					targetStats.setBarrier(0.0);
				}
				if (totalMagic < targetStats.getBarrier()) {
					logDetails.add("\t" + (int)totalMagic + " damage absorbed.");
					targetStats.setBarrier(targetStats.getBarrier() - totalMagic);
					totalMagic = 0.0;
				}
				if (totalPhysical >= targetStats.getBarrier()) {
					logDetails.add("\t" + (int)targetStats.getBarrier() + " damage shielded.");
					totalPhysical -= targetStats.getBarrier();
					targetStats.setBarrier(0.0);
				}
				if (totalPhysical < targetStats.getBarrier()) {
					logDetails.add("\t" + (int)totalPhysical + " damage shielded.");
					targetStats.setBarrier(targetStats.getBarrier() - totalPhysical);
					totalPhysical = 0.0;
				}
				
			}
			//**
			//targetStats.setCurrentHealth(targetStats.getCurrentHealth() - 5);
			//*************
			targetStats.setCurrentHealth(targetStats.getCurrentHealth() - (int)totalPhysical - (int)totalMagic);
			if (this.physicalPower > 0.0) {
				logEntry += (int)totalPhysical  + " physical damage";
				if (this.bonusDamage <= 0.0 ) {
					logEntry += ".";
				}
			}
			if (this.magicPower > 0.0) {
				if (this.physicalPower > 0.0) {
					logEntry += " and ";
				}
				logEntry += (int)totalMagic + " magic damage.";
			
			}
			if (physicalBounceBack != 0.0 || magicBounceBack != 0.0) {
				if (selfStats.getImmunity() > 0.0) {
					magicBounceBack *= (1.0 - selfStats.getImmunity());
				}
				if (selfStats.getProtection() > 0.0) {
					physicalBounceBack *= (1.0 - selfStats.getProtection());
				}
				if (magicBounceBack > 0.0 && selfStats.getMagicShield() > 0.0 && !selfStats.isVulnerable()) {
					if (magicBounceBack >= selfStats.getMagicShield()) {
						magicBounceBack -= selfStats.getMagicShield();
						selfStats.setMagicShield(0.0);
					}
					if (magicBounceBack < selfStats.getMagicShield()) {
						selfStats.setMagicShield(selfStats.getMagicShield() - magicBounceBack);
						magicBounceBack = 0.0;
					}
				}
				if (physicalBounceBack > 0.0 && selfStats.getPhysicalShield() > 0.0 && !selfStats.isVulnerable()) {
					if (physicalBounceBack >= selfStats.getPhysicalShield()) {
						physicalBounceBack -= selfStats.getPhysicalShield();
						selfStats.setPhysicalShield(0.0);
					}
					if (physicalBounceBack < selfStats.getPhysicalShield()) {
						selfStats.setPhysicalShield(selfStats.getPhysicalShield() - physicalBounceBack);
						physicalBounceBack = 0.0;
					}
				}
				if (selfStats.getBarrier() > 0.0 && !selfStats.isVulnerable()) {
					if (magicBounceBack >= selfStats.getBarrier()) {
						magicBounceBack -= selfStats.getBarrier();
						selfStats.setBarrier(0.0);
					}
					if (magicBounceBack < selfStats.getBarrier()) {
						selfStats.setBarrier(selfStats.getBarrier() - magicBounceBack);
						magicBounceBack = 0.0;
					}
					if (physicalBounceBack >= selfStats.getBarrier()) {
						physicalBounceBack -= selfStats.getBarrier();
						selfStats.setBarrier(0.0);
					}
					if (physicalBounceBack < selfStats.getBarrier()) {
						selfStats.setBarrier(selfStats.getBarrier() - physicalBounceBack);
						physicalBounceBack = 0.0;
					}
					
				}
				logDetails.add("\t" + ((int)physicalBounceBack - (int)magicBounceBack) + " damage bounced back at " + self.getName() + ".");
				selfStats.setCurrentHealth(selfStats.getCurrentHealth() - (int)physicalBounceBack - (int)magicBounceBack);
				
			}
			for (int i = 0; i < logDetails.size(); i++) {
				log.addToLog(logDetails.get(i));
			}
			if (this.physicalPower > 0.0 || this.magicPower > 0.0) {
				log.addToLog(logEntry);
			}
		}
		
		
	}

	public void randomAI() {
		Random r = new Random();
		
	}
	@Override
	public String toString() {
		return "FullAttack [physicalPower=" + physicalPower + "\nmagicPower=" + magicPower + "\nbonusDamage="
				+ bonusDamage + "\naccuracy=" + accuracy + "\navoidability=" + avoidability + "\ncrit=" + crit
				+ "\npenetration=" + penetration + "\nrangedAttack=" + rangedAttack + "\npriority=" + priority
				+ "\nname=" + name + "\ndescription=" + description + "\ncustomText=" + customText + "\nkeywords="
				+ Arrays.toString(keywords) + "\nenergyCost=" + energyCost + "\nuses=" + uses + "\ncurrentUses="
				+ currentUses + "\ncomboPointGain=" + comboPointGain + "\ncomboPointRequirement="
				+ comboPointRequirement + "\ntime=" + time + "\ncooldown=" + cooldown + "\ncooldownCounter="
				+ cooldownCounter + "\nself=" + self.toString() + "\ntarget=" + target.toString() + "\nrequirements= null"
				+ "\nanimation=" + animation + "]";
	}

	public double getPhysicalPower() {
		return physicalPower;
	}
	public void setPhysicalPower(double physicalPower) {
		this.physicalPower = physicalPower;
	}
	public double getMagicPower() {
		return magicPower;
	}
	public void setMagicPower(double magicPower) {
		this.magicPower = magicPower;
	}
	public double getBonusDamage() {
		return bonusDamage;
	}
	public void setBonusDamage(double bonusDamage) {
		this.bonusDamage = bonusDamage;
	}
	public double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}
	public double getAvoidability() {
		return avoidability;
	}
	public void setAvoidability(double avoidability) {
		this.avoidability = avoidability;
	}
	public double getCrit() {
		return crit;
	}
	public void setCrit(double crit) {
		this.crit = crit;
	}
	public double getPenetration() {
		return penetration;
	}
	public void setPenetration(double penetration) {
		this.penetration = penetration;
	}
	public boolean isRangedAttack() {
		return rangedAttack;
	}
	public void setRangedAttack(boolean rangedAttack) {
		this.rangedAttack = rangedAttack;
	}
	public boolean isPriority() {
		return priority;
	}
	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	public BaseStats getRequirements() {
		return requirements;
	}
	public void setRequirements(BaseStats requirements) {
		this.requirements = requirements;
	}

}
