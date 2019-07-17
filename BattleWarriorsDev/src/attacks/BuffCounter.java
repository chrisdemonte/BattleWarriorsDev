package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffCounter extends BuffEffect{
	
	double countering;
	int counteringCounter;
	double reflecting;
	int reflectingCounter;
	
	public BuffCounter(int chance, double countering,
			int counteringCounter, double reflecting, int reflectingCounter) {
		super(chance);
		this.countering = countering;
		this.counteringCounter = counteringCounter;
		this.reflecting = reflecting;
		this.reflectingCounter = reflectingCounter;
		this.keyword = "counter";
	}
	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		
		BattleStats stats = target.getBattleStats();
		
		if (this.counteringCounter != 0) {
			stats.setCountering(stats.getCountering() + this.countering);
			if (stats.getCountering() > 100.0) {
				stats.setCountering(100.0);
			}
			if (stats.getCountering() < 0.0) {
				stats.setCountering(0.0);
				stats.setCounteringCounter(0);
			}
			if (this.counteringCounter > stats.getCounteringCounter() && stats.getCountering() > 0.0) {
				stats.setCounteringCounter(this.counteringCounter);
			}
		}
		if (this.reflectingCounter != 0) {
			stats.setReflecting(stats.getReflecting() + this.reflecting);
			if (stats.getReflecting() > 100.0) {
				stats.setReflecting(100.0);
			}
			if (stats.getReflecting() < 0.0) {
				stats.setReflecting(0.0);
				stats.setReflectingCounter(0);
			}
			if (this.reflectingCounter > stats.getReflectingCounter() && stats.getReflecting() > 0.0) {
				stats.setReflectingCounter(this.reflectingCounter);
			}
			
		}
	}
	@Override
	public String toString() {
		return "BuffCounter [countering=" + countering + "\ncounteringCounter=" + counteringCounter + "\nreflecting="
				+ reflecting + "\nreflectingCounter=" + reflectingCounter + "\nchance=" + chance + "\nkeyword="
				+ keyword + "]";
	}
	
	

}
