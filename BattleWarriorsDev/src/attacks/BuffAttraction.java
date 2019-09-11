package attacks;

import java.io.Serializable;
import java.util.Random;

import BattleSystem.BattleBuffHolder;
import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffAttraction extends BuffEffect {


	private static final long serialVersionUID = -8317796610613304586L;

	public BuffAttraction(int chance) {
		super(chance);
		this.keyword = "attraction";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleBuffHolder bbHolder, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		Random rand = new Random();
		int applicationChance = this.chance 
				+ (int)(self.getBattleStats().getCunning() * self.getBattleStats().getCunningMod() *.5)
				- (int)(stats.getIntelligence() * stats.getIntelligenceMod() *.5);
		if (rand.nextInt(100) < applicationChance && !stats.isEnraged()) {
			stats.setCanAttack(false);
			stats.setCanAttackCounter(1);
			stats.setCanRun(false);
			stats.setCanRunCounter(1);
			
		}
	}

	@Override
	public String toString() {
		return "BuffBind [chance=" + chance + "\nkeyword=" + keyword + "]";
	}
	
	
	

}
