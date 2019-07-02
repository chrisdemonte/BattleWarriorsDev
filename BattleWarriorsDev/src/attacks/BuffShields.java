package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffShields extends BuffEffect{

	double barrier;
	int barrierCounter;
	double physicalShield;
	int physicalShieldCounter;
	double magicShield;
	int magicShieldCounter;
	
	public BuffShields(int chance, double barrier, int barrierCounter,
			double physicalShield, int physicalShieldCounter, double magicShield, int magicShieldCounter) {
		super(chance);
		this.barrier = barrier;
		this.barrierCounter = barrierCounter;
		this.physicalShield = physicalShield;
		this.physicalShieldCounter = physicalShieldCounter;
		this.magicShield = magicShield;
		this.magicShieldCounter = magicShieldCounter;
		this.keyword = "shields";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		
		if (this.barrierCounter != 0) {
			if (stats.getBarrier() < 0) {
				stats.setBarrier(stats.getBarrier() + this.barrier);
				if (stats.getBarrier() > 0) {
					stats.setBarrierCounter(this.barrierCounter);
				}
			}
			else {
				stats.setBarrier(stats.getBarrier() + this.barrier);
				if (this.barrierCounter > stats.getBarrierCounter()) {
					stats.setBarrierCounter(this.barrierCounter);
				}
			}
		}
		if (this.physicalShieldCounter != 0) {
			if (stats.getPhysicalShield() < 0) {
				stats.setPhysicalShield(stats.getPhysicalShield() + this.physicalShield);
				if (stats.getPhysicalShield() > 0) {
					stats.setPhysicalShieldCounter(this.physicalShieldCounter);
				}
			}
			else {
				stats.setPhysicalShield(stats.getPhysicalShield() + this.physicalShield);
				if (this.physicalShieldCounter > stats.getPhysicalShieldCounter()) {
					stats.setPhysicalShieldCounter(this.physicalShieldCounter);
				}
			}
		}
		if (this.magicShieldCounter != 0) {
			if (stats.getMagicShield() < 0) {
				stats.setMagicShield(stats.getMagicShield() + this.magicShield);
				if (stats.getMagicShield() > 0) {
					stats.setMagicShieldCounter(this.magicShieldCounter);
				}
			}
			else {
				stats.setMagicShield(stats.getMagicShield() + this.magicShield);
				if (this.magicShieldCounter > stats.getMagicShieldCounter()) {
					stats.setMagicShieldCounter(this.magicShieldCounter);
				}
			}
		}
	}
	
	
}
