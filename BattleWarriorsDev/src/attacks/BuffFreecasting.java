package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffFreecasting extends BuffEffect {

	boolean freecasting;
	int freecastingCounter;
	boolean exhausted;
	int exhaustedCounter;
	
	public BuffFreecasting(int chance, boolean freecasting,
			int freecastingCounter, boolean exhausted, int exhaustedCounter) {
		super(chance);
		this.freecasting = freecasting;
		this.freecastingCounter = freecastingCounter;
		this.exhausted = exhausted;
		this.exhaustedCounter = exhaustedCounter;
		this.keyword = "freecasting";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		if (this.freecastingCounter != 0) {
			stats.setFreecasting(this.freecasting);
			if (this.freecastingCounter > stats.getFreecastingCounter() && stats.isFreecasting()) {
				stats.setFreecastingCounter(this.freecastingCounter);
			}
			if (!stats.isFreecasting()) {
				stats.setFreecastingCounter(0);
			}
		}
		if (this.exhaustedCounter != 0) {
			stats.setExhausted(this.exhausted);
			if (this.exhaustedCounter > stats.getExhaustedCounter() && stats.isExhausted()) {
				stats.setExhaustedCounter(this.exhaustedCounter);
			}
			if (!stats.isExhausted()) {
				stats.setExhaustedCounter(0);
			}
		}
	
	}

	@Override
	public String toString() {
		return "BuffFreecasting [freecasting=" + freecasting + "\nfreecastingCounter=" + freecastingCounter
				+ "\nexhausted=" + exhausted + "\nexhaustedCounter=" + exhaustedCounter + "\nchance=" + chance
				+ "\nkeyword=" + keyword + "]";
	}
	
	
}
