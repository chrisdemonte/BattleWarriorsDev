package attacks;

import models.Player;

public class BuffHeal extends BuffEffect{

	double physicalMod;
	double magicMod;
	double bonusHealing;
	
	public BuffHeal(String name, String description, String keyword, double physicalMod,
			double magicMod, double bonusHealing) {
		super(name, description, keyword);
		this.physicalMod = physicalMod;
		this.magicMod = magicMod;
		this.bonusHealing = bonusHealing;
	}

	@Override
	public void doBuffEffect(Player target, Player self) {
		// TODO Auto-generated method stub
		super.doBuffEffect(target, self);
	}
	
}
