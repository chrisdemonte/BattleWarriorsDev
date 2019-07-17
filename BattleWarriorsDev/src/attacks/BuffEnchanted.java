package attacks;

import java.util.Random;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffEnchanted extends BuffEffect{

	public BuffEnchanted(int chance) {
		super(chance);
		this.keyword = "enchanted";
		
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		Random rand = new Random();
		int applicationChance = this.chance 
				+ (int)(self.getBattleStats().getCunning() * self.getBattleStats().getCunningMod() *.25)
				+ (int)(self.getBattleStats().getMagic() * self.getBattleStats().getMagicMod() *.25)
				- (int)(stats.getResistance() * stats.getResistanceMod() *.5);
		if (rand.nextInt(100) < applicationChance && !stats.isEnraged()) {
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
		return "BuffEnchanted [chance=" + chance + "\nkeyword=" + keyword + "]";
	}
	

}
