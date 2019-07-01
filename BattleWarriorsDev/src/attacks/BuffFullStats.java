package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffFullStats extends BuffEffect {
	
BattleStats stats;
	
	public BuffFullStats(int chance, BattleStats stats) {
		super(chance);
		this.stats = stats;
	}
	
	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		target.getBattleStats().changeBattleStats(this.stats);
	}
}
