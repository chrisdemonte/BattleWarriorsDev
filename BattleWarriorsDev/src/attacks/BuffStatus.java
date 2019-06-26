package attacks;

import models.BattleStats;
import models.Player;

public class BuffStatus extends BuffEffect {
	BattleStats stats;
	
	public BuffStatus(String name, String description, String keyword, int chance, BattleStats stats) {
		super(name, description, keyword, chance);
		this.stats = stats;
	}

	@Override
	public void doBuffEffect(Player target, Player self) {
		target.getBattleStats().changeBattleStats(this.stats);
	}

}
