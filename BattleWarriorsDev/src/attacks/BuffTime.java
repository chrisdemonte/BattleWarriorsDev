package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffTime extends BuffEffect{
	
	private static final long serialVersionUID = -3408289504989445140L;
	int actionTime;
	int daze;
	int haste;
	
	public BuffTime(int chance, int actionTime, int daze, int haste) {
		super(chance);
		this.actionTime = actionTime;
		this.daze = daze;
		this.haste = haste;
		this.keyword = "time";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		
		BattleStats stats = target.getBattleStats();
		stats.setActionTime(stats.getActionTime() + this.actionTime);
		if (stats.getActionTime() < 500) {
			stats.setActionTime(500);
		}
		if (stats.getActionTime() > 6000) {
			stats.setActionTime(6000);
		}
		stats.setDaze(stats.getDaze() + this.daze);
		if (stats.getDaze() > 4000) {
			stats.setDaze(4000);
		}
		if (stats.getDaze() < 0) {
			stats.setDaze(0);
		}
		stats.setHaste(stats.getHaste() + this.haste);
		if (stats.getHaste() < 0) {
			stats.setHaste(0);
		}
	}

	@Override
	public String toString() {
		return "BuffTime [actionTime=" + actionTime + "\ndaze=" + daze + "\nhaste=" + haste + "\nchance=" + chance
				+ "\nkeyword=" + keyword + "]";
	}

	
}
