package attacks;

import models.Player;

public class BuffDamage extends BuffEffect{

	double physicalMod;
	double magicMod;
	double bonusDamage;
	
	public BuffDamage(String name, String description, String keyword, int chance, double physicalMod,
			double magicMod, double bonusDamage) {
		super(name, description, keyword, chance);
		this.physicalMod = physicalMod;
		this.magicMod = magicMod;
		this.bonusDamage = bonusDamage;
	}
	@Override
	public void doBuffEffect(Player target, Player self) {
		
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
		}
		
		totalDamage = (int)(totalPhysicalDamage + totalMagicDamage);
		target.getBattleStats().setCurrentHealth(target.getBattleStats().getCurrentHealth() - totalDamage);
		
	}
	
	
}
