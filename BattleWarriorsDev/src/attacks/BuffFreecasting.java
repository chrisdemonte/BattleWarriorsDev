package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffFreecasting extends BuffEffect {

	boolean freecasting;
	int freecastingCounter;
	boolean exhausted;
	int exhaustedCounter;
	
	public BuffFreecasting(String name, String description, String keyword, int chance, boolean freecasting,
			int freecastingCounter, boolean exhausted, int exhaustedCounter) {
		super(name, description, keyword, chance);
		this.freecasting = freecasting;
		this.freecastingCounter = freecastingCounter;
		this.exhausted = exhausted;
		this.exhaustedCounter = exhaustedCounter;
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
	
	
}
