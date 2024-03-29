package attacks;

import BattleSystem.BattleBuffHolder;
import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffProtection extends BuffEffect{
	
	private static final long serialVersionUID = 2400305706008634042L;
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
	public void doBuffEffect(Player target, Player self, BattleBuffHolder bbHolder, BattleLog log) {
		
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

	@Override
	public String toString() {
		return "BuffProtection [protection=" + protection + "\nprotectionCounter=" + protectionCounter + "\nimmunity="
				+ immunity + "\nimmunityCounter=" + immunityCounter + "\nchance=" + chance + "\nkeyword=" + keyword
				+ "]";
	}
	
	

}
