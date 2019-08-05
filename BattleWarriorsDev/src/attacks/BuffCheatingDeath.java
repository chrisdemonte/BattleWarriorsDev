package attacks;

import java.io.Serializable;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffCheatingDeath extends BuffEffect {

	private static final long serialVersionUID = -1150038531174901584L;
	boolean cheatingDeath;
	int cheatingDeathCounter;
	
	public BuffCheatingDeath(int chance, boolean cheatingDeath,int cheatingDeathCounter) {
		super(chance);
		this.cheatingDeath = cheatingDeath;
		this.cheatingDeathCounter = cheatingDeathCounter;
		this.keyword = "cheating death";
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

	@Override
	public String toString() {
		return "BuffCheatingDeath [cheatingDeath=" + cheatingDeath + "\ncheatingDeathCounter=" + cheatingDeathCounter
				+ "\nchance=" + chance + "\nkeyword=" + keyword + "]";
	}
	
	

}
