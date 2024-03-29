package attacks;

import java.io.Serializable;
import java.util.Random;

import BattleSystem.BattleBuffHolder;
import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffBind extends BuffEffect{

	private static final long serialVersionUID = 3469031900773322713L;

	public BuffBind(int chance) {
		super(chance);
		this.keyword = "bind";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleBuffHolder bbHolder, BattleLog log) {
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

	@Override
	public String toString() {
		return "BuffBind [chance=" + chance + "\nkeyword=" + keyword + "]";
	}
	
	

}
