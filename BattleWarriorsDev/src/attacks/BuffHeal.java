package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffHeal extends BuffEffect{

	double physicalMod;
	double magicMod;
	double bonusHealing;
	
	public BuffHeal(int chance, double physicalMod,
			double magicMod, double bonusHealing) {
		super(chance);
		this.physicalMod = physicalMod;
		this.magicMod = magicMod;
		this.bonusHealing = bonusHealing;
		this.keyword = "heal";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		
		double physicalHeal = 0.0;
		double magicHeal = 0.0;
		
		if (this.physicalMod > 0.0) {
			physicalHeal = 
					(((stats.getSkill() * stats.getSkillMod() * .5) + ((stats.getIntelligence() * stats.getIntelligenceMod() * .5)) * physicalMod))
					+ bonusHealing; 
			if (stats.getPhysicalShield() < 0.0) {
				if (stats.getPhysicalShield() * -1.0 > physicalHeal) {
					stats.setPhysicalShield(stats.getPhysicalShield() + physicalHeal);
					physicalHeal = 0.0;
					if (stats.getPhysicalShield() > 0.0) {
						stats.setPhysicalShield(0.0);
						stats.setPhysicalShieldCounter(0);
					}
				}
				else {
					physicalHeal -= stats.getPhysicalShield();
					stats.setPhysicalShield(0.0);;
					stats.setPhysicalShieldCounter(0);
				}
			}
			if (stats.getBarrier() < 0.0) {
				if (stats.getBarrier() * -1.0 > physicalHeal) {
					stats.setBarrier(stats.getBarrier() + physicalHeal);
					physicalHeal = 0.0;
					if (stats.getBarrier() > 0.0) {
						stats.setBarrier(0.0);
						stats.setBarrierCounter(0);
					}
				}
				else {
					physicalHeal -= stats.getBarrier();
					stats.setBarrier(0.0);
					stats.setBarrierCounter(0);
				}
			}
		}
		if  (this.magicMod > 0.0) {
			magicHeal = 
					(((stats.getMagic() * stats.getMagicMod() * .6) + ((stats.getIntelligence() * stats.getIntelligenceMod() * .4)) * magicMod))
					+ bonusHealing;
			if (stats.getMagicShield() < 0.0) {
				if (stats.getMagicShield() * -1.0 > magicHeal) {
					stats.setMagicShield(stats.getMagicShield() + magicHeal);
					magicHeal = 0.0;
					if (stats.getMagicShield() > 0.0) {
						stats.setMagicShield(0.0);
						stats.setMagicShieldCounter(0);
					}
				}
				else {
					magicHeal -= stats.getMagicShield();
					stats.setMagicShield(0.0);
					stats.setMagicShieldCounter(0);
				}
			}
			if (stats.getBarrier() < 0.0) {
				if (stats.getBarrier() * -1.0 > magicHeal) {
					stats.setBarrier(stats.getBarrier() + magicHeal);
					magicHeal = 0.0;
					if (stats.getBarrier() > 0.0) {
						stats.setBarrier(0.0);
						stats.setBarrierCounter(0);
					}
				}
				else {
					magicHeal -= stats.getBarrier();
					stats.setBarrier(0.0);
					stats.setBarrierCounter(0);
				}
			}
		}
		stats.setCurrentHealth((int)(stats.getCurrentHealth() + magicHeal + physicalHeal));
		if (stats.getCurrentHealth() > stats.getMaxHealth()) {
			stats.setCurrentHealth(stats.getMaxHealth());
		}
	}
	
}
