package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffProtection extends BuffEffect{
	
	double protection;
	int protectionCounter;
	double immunity;
	int immunityCounter;
	
	public BuffProtection(int chance, double protection,
			int protectionCounter, double immunity, int immunityCounter) {
		super(chance);
		this.protection = protection;
		this.protectionCounter = protectionCounter;
		this.immunity = immunity;
		this.immunityCounter = immunityCounter;
		this.keyword = "protection";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		
		BattleStats stats = target.getBattleStats();
		
		if (this.protectionCounter != 0) {
			stats.setProtection(stats.getProtection() + this.protection);
			if (stats.getProtection() > 100.0) {
				stats.setProtection(100.0);
			}
			if (stats.getProtection() <= 0.0) {
				stats.setProtection(0.0);
				stats.setProtectionCounter(0);
			}
			if (this.protectionCounter > stats.getProtectionCounter() && stats.getProtection() > 0.0) {
				stats.setProtectionCounter(this.protectionCounter);
			}
		}
		if (this.immunityCounter != 0) {
			stats.setImmunity(stats.getImmunity() + this.immunity);
			if (stats.getImmunity() > 100.0) {
				stats.setImmunity(100.0);
			}
			if (stats.getImmunity() <= 0.0) {
				stats.setImmunity(0.0);
				stats.setImmunityCounter(0);
			}
			if (this.immunityCounter > stats.getImmunityCounter() && stats.getImmunity() > 0.0) {
				stats.setImmunityCounter(this.immunityCounter);
			}
		}
	}
	
	

}
