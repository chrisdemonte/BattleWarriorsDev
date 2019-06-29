package attacks;

import models.Player;
import utilities.BattleLog;

public class BuffDamage extends BuffEffect{

	double physicalMod;
	double magicMod;
	double bonusDamage;
	
	public BuffDamage(String keyword, int chance, double physicalMod,
			double magicMod, double bonusDamage) {
		super( keyword, chance);
		this.physicalMod = physicalMod;
		this.magicMod = magicMod;
		this.bonusDamage = bonusDamage;
	}
	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		if (this.willDoEffect()) {
			double rawPhysicalDamage = 0.0;
			double rawMagicDamage = 0.0;
			double physicalSubtraction = 0.0;
			double totalPhysicalDamage = 0.0;
			double magicSubtraction = 0.0;
			double totalMagicDamage = 0.0;
			int totalDamage = 0;
			double multiplier = 0.0;
			
			if (physicalMod > 0.0) {
				rawPhysicalDamage = bonusDamage + (physicalMod * self.getBattleStats().getStrength() * self.getBattleStats().getStrengthMod());
				physicalSubtraction = (rawPhysicalDamage * .5) - (target.getBattleStats().getDefense() * target.getBattleStats().getDefenseMod());
				if (physicalSubtraction < 0.0) {
					physicalSubtraction = 0.0;
				}
				multiplier = (250.0 - (target.getBattleStats().getDefense()* target.getBattleStats().getDefenseMod())) / 250.0;
				if (multiplier < .05) {
					multiplier = .05;
				}
				totalPhysicalDamage = ((rawPhysicalDamage * .5) * multiplier) + physicalSubtraction;
				if (target.getBattleStats().getPhysicalShield() > 0.0) {
					if (target.getBattleStats().getPhysicalShield() > totalPhysicalDamage) {
						target.getBattleStats().setPhysicalShield(target.getBattleStats().getPhysicalShield() - totalPhysicalDamage);
						totalPhysicalDamage = 0.0;
					}
					else {
						totalPhysicalDamage -= target.getBattleStats().getPhysicalShield();
						target.getBattleStats().setPhysicalShield(0.0);
					}
				}
				if (target.getBattleStats().getBarrier() > 0.0) {
					if (target.getBattleStats().getBarrier() > totalPhysicalDamage) {
						target.getBattleStats().setBarrier(target.getBattleStats().getBarrier() - totalPhysicalDamage);
						totalPhysicalDamage = 0.0;
					}
					else {
						totalPhysicalDamage -= target.getBattleStats().getBarrier();
						target.getBattleStats().setBarrier(0.0);
					}
				}
			}
			if (magicMod > 0.0) {
				rawMagicDamage = bonusDamage + (magicMod * self.getBattleStats().getMagic() * self.getBattleStats().getMagicMod());
				magicSubtraction = (rawMagicDamage * .5) - (target.getBattleStats().getResistance() * target.getBattleStats().getResistanceMod());
				if (magicSubtraction < 0.0) {
					magicSubtraction = 0.0;
				}
				multiplier = (250 - (target.getBattleStats().getResistance()* target.getBattleStats().getResistanceMod())) / 250.0;
				if (multiplier < .05) {
					multiplier = .05;
				}
				totalMagicDamage = ((rawMagicDamage * .5)  * multiplier)+ magicSubtraction;
				if (target.getBattleStats().getMagicShield() > 0.0) {
					if (target.getBattleStats().getMagicShield() > totalMagicDamage) {
						target.getBattleStats().setMagicShield(target.getBattleStats().getMagicShield() - totalMagicDamage);
						totalMagicDamage = 0.0;
					}
					else {
						totalMagicDamage -= target.getBattleStats().getMagicShield();
						target.getBattleStats().setMagicShield(0.0);
					}
				}
				if (target.getBattleStats().getBarrier() > 0.0) {
					if (target.getBattleStats().getBarrier() > totalMagicDamage) {
						target.getBattleStats().setBarrier(target.getBattleStats().getBarrier() - totalMagicDamage);
						totalMagicDamage = 0.0;
					}
					else {
						totalMagicDamage -= target.getBattleStats().getBarrier();
						target.getBattleStats().setBarrier(0.0);
					}
				}
			}
			
			totalDamage = (int)(totalPhysicalDamage + totalMagicDamage);
			target.getBattleStats().setCurrentHealth(target.getBattleStats().getCurrentHealth() - totalDamage);
		}
	}
	
	
}
