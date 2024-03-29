package attacks;

import java.util.Random;

import BattleSystem.BattleBuffHolder;
import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffMindControl extends BuffEffect {

	private static final long serialVersionUID = 1531599876635484104L;

	public BuffMindControl(int chance) {
		super(chance);
		this.keyword = "mind control";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleBuffHolder bbHolder, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		Random rand = new Random();
		int applicationChance = this.chance 
				+ (int)(self.getBattleStats().getCunning() * self.getBattleStats().getCunningMod() *.25)
				+ (int)(self.getBattleStats().getMagic() * self.getBattleStats().getMagicMod() *.25)
				- (int)(stats.getResistance() * stats.getResistanceMod() *.25)
				- (int)(stats.getIntelligence() * stats.getIntelligenceMod() *.25);
		if (rand.nextInt(100) < applicationChance ) {
			stats.setCanAttack(false);
			stats.setCanAttackCounter(1);
			stats.setCanRun(false);
			stats.setCanRunCounter(1);
			stats.setCanUseItems(false);
			stats.setCanUseItemsCounter(1);
			stats.setSelfHarm(true);
			stats.setSelfHarmCounter(1);
			
		}
	}

	@Override
	public String toString() {
		return "BuffMindControl [chance=" + chance + "\nkeyword=" + keyword + "]";
	}
	

}
