package attacks;

import java.io.Serializable;
import java.util.Random;

import BattleSystem.BattleBuffHolder;
import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffConfusion extends BuffEffect {


	private static final long serialVersionUID = -7409751857552047965L;

	public BuffConfusion(int chance) {
		super(chance);
		this.keyword = "confusion";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleBuffHolder bbHolder, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		Random rand = new Random();
		int applicationChance = this.chance 
				+ (int)(self.getBattleStats().getCunning() * self.getBattleStats().getCunningMod() *.5)
				- (int)(stats.getSkill() * stats.getSkillMod() *.5);
		if (rand.nextInt(100) < applicationChance ) {
			stats.setCanUseItems(false);
			stats.setCanUseItemsCounter(1);
			stats.setSelfHarm(true);
			stats.setSelfHarmCounter(1);
			
		}
	}

	@Override
	public String toString() {
		return "BuffConfusion [chance=" + chance + "\nkeyword=" + keyword + "]";
	}
	

}
