package attacks;

import BattleSystem.BattleBuffHolder;
import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffFullStats extends BuffEffect {
	

	private static final long serialVersionUID = -146531633100552495L;
	BattleStats stats;
	
	public BuffFullStats(int chance, BattleStats stats) {
		super(chance);
		this.stats = stats;
	}
	
	@Override
	public void doBuffEffect(Player target, Player self, BattleBuffHolder bbHolder, BattleLog log) {
		target.getBattleStats().changeBattleStats(this.stats);
	}
}
