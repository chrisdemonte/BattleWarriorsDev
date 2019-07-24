package attacks;

import java.util.Arrays;
import java.util.Random;

import models.BaseStats;
import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class FullAttack extends Move{
	
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
		super("Sample Attack", "You strike a foe on the body and/or head", "",null, 1, 50, 50, 0, 0, 1000, 0, 0, false, null, null, null);
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
		
		//damage multiplier
		double mod = 1.0;
		if (rand.nextInt(100) < (selfStats.getCrit() * selfStats.getCritMod())){
			mod += .5;
		}
		if (selfStats.getDamageSpike() > 0) {
			mod += .25;
			selfStats.setDamageSpike(selfStats.getDamageSpike() - 1);
		}
		//energy cost and attack uses
		
		this.uses--;
		int cost = this.energyCost;
		if (selfStats.isExhausted()) {
			cost *= 2;
		}
		if (selfStats.isFreecasting()) {
			cost*= 0;
		}
		selfStats.setCurrentEnergy(selfStats.getCurrentEnergy() - cost);
		//hit, miss, or enemy dodge
		
		boolean makeContact = true;
		if (targetStats.isOutOfReach() && !selfStats.isReach() && !this.rangedAttack) {
			makeContact = false;
			log.getLog().add(self.getName() + "'s " + this.getName() + " missed.");
			log.setLogLength(log.getLogLength() + 1);
		}
		if (makeContact && rand.nextInt(100) > ((selfStats.getAccuracy() * selfStats.getAccuracyMod()) + this.accuracy)) {
			
			makeContact = false;
			log.getLog().add(self.getName() + "'s " + this.getName() + " missed.");
			log.setLogLength(log.getLogLength() + 1);
		}
		if (makeContact && rand.nextInt(100) < ((targetStats.getAvoidance() * targetStats.getAvoidanceMod()) - (this.avoidability + (selfStats.getSkill()/4350.0)))
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
			double targetResist = (targetStats.getResistance() * targetStats.getResistanceMod()) * (1.0 - (selfStats.getPenetration() * selfStats.getPenetrationMod()));
			double targetDef = (targetStats.getDefense() * targetStats.getDefenseMod()) * (1.0 - (selfStats.getPenetration() * selfStats.getPenetrationMod()));
			String logEntry = new String(self.getName() + "'s " + this.getName() + " did ");
			
			if (this.physicalPower > 0.0) {
				physicalDamage += (selfStats.getStrength() * selfStats.getStrengthMod() * mod) + this.getBonusDamage();
				multiplier = (250 - targetDef) / 250.0;
				if (multiplier < .05) {
					multiplier = .05;
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
					physicalDamage -= physicalDamage * targetStats.getBlocking();
				}
			}
			if (this.magicPower > 0.0) {
				magicDamage += (selfStats.getMagic() * selfStats.getMagicMod() * mod) + this.getBonusDamage();
				multiplier = (250 - targetResist)/ 250.0;
				if (multiplier < .05) {
					multiplier = .05;
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
				totalMagic *= (1.0 - targetStats.getImmunity());
			}
			if (targetStats.getProtection() > 0.0) {
				totalPhysical *= (1.0 - targetStats.getProtection());
			}
			if (totalMagic > 0.0 && targetStats.getMagicShield() > 0.0 && !targetStats.isVulnerable()) {
				if (totalMagic >= targetStats.getMagicShield()) {
					totalMagic -= targetStats.getMagicShield();
					targetStats.setMagicShield(0.0);
				}
				if (totalMagic < targetStats.getMagicShield()) {
					targetStats.setMagicShield(targetStats.getMagicShield() - totalMagic);
					totalMagic = 0.0;
				}
			}
			if (totalPhysical > 0.0 && targetStats.getPhysicalShield() > 0.0 && !targetStats.isVulnerable()) {
				if (totalPhysical >= targetStats.getPhysicalShield()) {
					totalPhysical -= targetStats.getPhysicalShield();
					targetStats.setPhysicalShield(0.0);
				}
				if (totalPhysical < targetStats.getPhysicalShield()) {
					targetStats.setPhysicalShield(targetStats.getPhysicalShield() - totalPhysical);
					totalPhysical = 0.0;
				}
			}
			if (targetStats.getBarrier() > 0.0 && !targetStats.isVulnerable()) {
				if (totalMagic >= targetStats.getBarrier()) {
					totalMagic -= targetStats.getBarrier();
					targetStats.setBarrier(0.0);
				}
				if (totalMagic < targetStats.getBarrier()) {
					targetStats.setBarrier(targetStats.getBarrier() - totalMagic);
					totalMagic = 0.0;
				}
				if (totalPhysical >= targetStats.getBarrier()) {
					totalPhysical -= targetStats.getBarrier();
					targetStats.setBarrier(0.0);
				}
				if (totalPhysical < targetStats.getBarrier()) {
					targetStats.setBarrier(targetStats.getBarrier() - totalPhysical);
					totalPhysical = 0.0;
				}
				
			}
			targetStats.setCurrentHealth(targetStats.getCurrentHealth() - (int)physicalDamage - (int)magicDamage);
			if (this.physicalPower > 0.0) {
				logEntry += (int)physicalDamage + " physical damage";
				if (this.bonusDamage <= 0.0 ) {
					logEntry += ".";
				}
			}
			if (this.magicPower > 0.0) {
				if (this.physicalPower > 0.0) {
					logEntry += " and ";
				}
				logEntry += (int)magicDamage + " magic damage.";
				log.getLog().add(logEntry);
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
				selfStats.setCurrentHealth(selfStats.getCurrentHealth() - (int)physicalBounceBack - (int)magicBounceBack);
				log.getLog().add(self.getName() + " recieved " + (physicalBounceBack + magicBounceBack) + " bounce back damage.");
			}
		
		}
		
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
