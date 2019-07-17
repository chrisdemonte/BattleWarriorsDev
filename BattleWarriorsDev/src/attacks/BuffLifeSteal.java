package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffLifeSteal extends BuffEffect{

	double percentTargetHealth;
	double percentSelfHealth;
	
	public BuffLifeSteal(int chance, double percentTargetHealth, double percentSelfHealth) {
		super(chance);
		this.percentTargetHealth = percentTargetHealth;
		this.percentSelfHealth = percentSelfHealth;
		this.keyword = "life steal";
	}
	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		BattleStats tStats = target.getBattleStats();
		BattleStats sStats = self.getBattleStats();
		
		tStats.setCurrentHealth(tStats.getCurrentHealth() - (int)(tStats.getCurrentHealth() * this.percentTargetHealth));
		sStats.setCurrentHealth(sStats.getCurrentHealth() + (int)(sStats.getCurrentHealth() * this.percentTargetHealth));
		if (sStats.getCurrentHealth() > sStats.getMaxHealth()) {
			sStats.setCurrentHealth(sStats.getMaxHealth());
		}
		if (tStats.getCurrentHealth() > tStats.getMaxHealth()) {
			tStats.setCurrentHealth(tStats.getMaxHealth());
		}
	}
	@Override
	public String toString() {
		return "BuffLifeSteal [percentTargetHealth=" + percentTargetHealth + "\npercentSelfHealth=" + percentSelfHealth
				+ "\nchance=" + chance + "\nkeyword=" + keyword + "]";
	}
	
	
}
