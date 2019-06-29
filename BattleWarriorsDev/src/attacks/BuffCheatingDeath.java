package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffCheatingDeath extends BuffEffect{
	
	boolean cheatingDeath;
	int cheatingDeathCounter;
	
	public BuffCheatingDeath(String keyword, int chance, boolean cheatingDeath,int cheatingDeathCounter) {
		super(keyword, chance);
		this.cheatingDeath = cheatingDeath;
		this.cheatingDeathCounter = cheatingDeathCounter;
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		if (this.cheatingDeathCounter != 0) {
			stats.setCheatingDeath(this.cheatingDeath);
			if (this.cheatingDeathCounter > stats.getCheatingDeathCounter() && stats.isCheatingDeath()) {
				stats.setCheatingDeathCounter(this.cheatingDeathCounter);
			}
			if (!stats.isCheatingDeath()) {
				stats.setCheatingDeathCounter(0);
			}
		}
	}
	
	

}
