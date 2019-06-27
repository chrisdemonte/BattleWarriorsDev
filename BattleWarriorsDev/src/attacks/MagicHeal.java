package attacks;

import java.util.Random;

import models.BaseStats;
import models.BattleStats;
import models.Player;
import utilities.BattleLog;

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

	@Override
	public void makeMove(Player self, Player target, BattleLog log) {
		BattleStats selfStats = self.getBattleStats();
		Random rand = new Random();
		double mod = 1.0;
		if (rand.nextInt(100) < (this.crit + (selfStats.getCrit() * selfStats.getCritMod()))) {
			mod += .7;
		}
		double healing = (((selfStats.getMagic() * selfStats.getMagicMod() * .6) + (selfStats.getSkill() * selfStats.getSkillMod() * .4)) * this.healingPower) + bonusHealing;
		healing *= mod;
		if (selfStats.getMagicShield() < 0) {
			if ( (-1.0 * healing) >= selfStats.getMagicShield()) {
				healing += selfStats.getMagicShield();
				selfStats.setMagicShield(0.0);
			}
			else {
				selfStats.setMagicShield(selfStats.getMagicShield() - healing);
				healing = 0;
			}
		}
	
		if (selfStats.getBarrier() < 0) {
			if ( (-1.0 * healing) >= selfStats.getBarrier()) {
				healing += selfStats.getBarrier();
				selfStats.setBarrier(0.0);
			}
			else {
				selfStats.setBarrier(selfStats.getBarrier() - healing);
				healing = 0;
			}
			
		}
		selfStats.setCurrentHealth(selfStats.getCurrentHealth() + (int)healing);
		log.getLog().add(self.getName() + " was healed for " + (int)healing + ".");
		
	}
	
	


}
