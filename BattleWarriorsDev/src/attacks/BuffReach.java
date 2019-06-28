package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffReach extends BuffEffect{
	
	boolean outOfReach;
	int outOfReachCounter;
	boolean reach;
	int reachCounter;
	boolean hidden;
	int hiddenCounter;
	
	public BuffReach(String name, String description, String keyword, int chance, boolean outOfReach,
			int outOfReachCounter, boolean reach, int reachCounter, boolean hidden, int hiddenCounter) {
		super(name, description, keyword, chance);
		this.outOfReach = outOfReach;
		this.outOfReachCounter = outOfReachCounter;
		this.reach = reach;
		this.reachCounter = reachCounter;
		this.hidden = hidden;
		this.hiddenCounter = hiddenCounter;
	}
	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		if (this.outOfReachCounter != 0) {
			stats.setOutOfReach(this.outOfReach);
			if (this.outOfReachCounter > stats.getOutOfReachCounter() && stats.isOutOfReach()) {
				stats.setOutOfReachCounter(this.outOfReachCounter);
			}
			if (!stats.isOutOfReach()) {
				stats.setOutOfReachCounter(0);
			}
		}
		if (this.reachCounter != 0) {
			stats.setReach(this.reach);
			if (this.reachCounter > stats.getReachCounter() && stats.isReach()) {
				stats.setReachCounter(this.reachCounter);
			}
			if (!stats.isReach()) {
				stats.setReachCounter(0);
			}
		}
		if (this.hiddenCounter != 0) {
			stats.setHidden(this.hidden);
			if (this.hiddenCounter > stats.getHiddenCounter()&& stats.isHidden()) {
				stats.setHiddenCounter(this.hiddenCounter);
			}
			if (!stats.isHidden()) {
				stats.setHiddenCounter(0);
			}
		}
	}
	
	

}