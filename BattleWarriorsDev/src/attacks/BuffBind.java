package attacks;

import java.util.Random;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffBind extends BuffEffect{

	public BuffBind(int chance) {
		super(chance);
		this.keyword = "bind";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		Random rand = new Random();
		int applicationChance = this.chance 
				+ (int)(self.getBattleStats().getCunning() * self.getBattleStats().getCunningMod() *.25)
				+ (int)(self.getBattleStats().getSpeed() * self.getBattleStats().getSpeedMod() *.25)
				- (int)(stats.getSpeed() * stats.getSpeedMod() *.5);
		if (rand.nextInt(100) < applicationChance) {
			stats.setCanAttack(false);
			stats.setCanAttackCounter(1);
			stats.setCanRun(false);
			stats.setCanRunCounter(1);
			stats.setCanUseItems(false);
			stats.setCanUseItemsCounter(1);
			
		}
	}
	
	

}
