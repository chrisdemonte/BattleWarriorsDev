package attacks;

import models.BattleStats;
import models.Player;

public class BuffStatus extends BuffEffect {
	BattleStats stats;
	
	public BuffStatus(String name, String description, String keyword, BattleStats stats) {
		super(name, description, keyword);
		this.stats = stats;
	}

	@Override
	public void doBuffEffect(Player target, Player self) {
		target.getBattleStats().addBattleStats(this.stats);
	}

}
