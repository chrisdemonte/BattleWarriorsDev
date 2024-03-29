package attacks;

import java.util.Random;

import BattleSystem.BattleBuffHolder;
import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffGrab extends BuffEffect{

	private static final long serialVersionUID = 1L;

	public BuffGrab(int chance) {
		super(chance);
		this.keyword = "grab";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleBuffHolder bbHolder, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		Random rand = new Random();
		int applicationChance = this.chance 
				+ (int)(self.getBattleStats().getSpeed() * self.getBattleStats().getSpeedMod() *.25)
				+ (int)(self.getBattleStats().getStrength() * self.getBattleStats().getStrengthMod() *.25)
				- (int)(stats.getSpeed() * stats.getSpeedMod() *.25)
				- (int)(stats.getStrength() * stats.getStrength() *.25);
		if (rand.nextInt(100) < applicationChance && (!stats.isOutOfReach() || self.getBattleStats().isReach())) {
			stats.setCanAttack(false);
			stats.setCanAttackCounter(1);
			stats.setCanRun(false);
			stats.setCanRunCounter(1);
			stats.setCanUseItems(false);
			stats.setCanUseItemsCounter(1);
			
		}
	}

	@Override
	public String toString() {
		return "BuffGrab [chance=" + chance + "\nkeyword=" + keyword + "]";
	}
	
	

}
