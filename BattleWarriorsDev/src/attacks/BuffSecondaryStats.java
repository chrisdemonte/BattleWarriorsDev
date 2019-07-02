package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffSecondaryStats extends BuffEffect{
	
	int damageSpike;
	double crit;
	double critMod;
	double accuracy;
	double accuracyMod;
	double avoidance;
	double avoidanceMod;
	double blocking;
	double blockingMod;
	double penetration; 
	double penetrationMod;
	
	public BuffSecondaryStats(int chance, int damageSpike, double crit,
			double critMod, double accuracy, double accuracyMod, double avoidance, double avoidanceMod, double blocking,
			double blockingMod, double penetration, double penetrationMod) {
		super(chance);
		this.damageSpike = damageSpike;
		this.crit = crit;
		this.critMod = critMod;
		this.accuracy = accuracy;
		this.accuracyMod = accuracyMod;
		this.avoidance = avoidance;
		this.avoidanceMod = avoidanceMod;
		this.blocking = blocking;
		this.blockingMod = blockingMod;
		this.penetration = penetration;
		this.penetrationMod = penetrationMod;
		this.keyword = "secondary stats";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		
		 stats.setDamageSpike(stats.getDamageSpike() + this.damageSpike );
		 if (stats.getDamageSpike() < 0) {
			 stats.setDamageSpike(0);
		 }
		 
		 stats.setCrit(stats.getCrit() + this.crit );
		 if (stats.getCrit() < 0.0) {
			 stats.setCrit(0.0);
		 }
		 if (this.critMod != 0.0) {
			 double multiplier = 1.0;
			 if (stats.getCritMod() > 1.0) {
				 multiplier = 2.0;
			 }
			 stats.setCritMod(stats.getCritMod() + (this.critMod * multiplier));
		 }
		 if (stats.getCritMod() < 0.1) {
			 stats.setCritMod(0.1);
		 }
		 if (stats.getCritMod() > 3.1) {
			 stats.setCritMod(3.1);
		 }
		
		 
		 stats.setAccuracy(stats.getAccuracy() + this.accuracy );
		 if (stats.getAccuracy() < 0.0) {
			 stats.setAccuracy(0.0);
		 }
		 if (this.accuracyMod != 0.0) {
			 double multiplier = 1.0;
			 if (stats.getAccuracyMod() > 1.0) {
				 multiplier = 2.0;
			 }
			 stats.setAccuracyMod(stats.getAccuracyMod() + (this.accuracyMod * multiplier));
		 }
		 if (stats.getAccuracyMod() < 0.1) {
			 stats.setAccuracyMod(0.1);
		 }
		 if (stats.getAccuracyMod() > 3.1) {
			 stats.setAccuracyMod(3.1);
		 }
		 
		 
		 stats.setAvoidance(stats.getAvoidance() + this.avoidance);
		 if (this.avoidanceMod != 0.0) {
			 double multiplier = 1.0;
			 if (stats.getAvoidanceMod() > 1.0) {
				 multiplier = 2.0;
			 }
			 stats.setAvoidanceMod(stats.getAvoidanceMod() + (this.avoidanceMod * multiplier));
		 }
		 if (stats.getAvoidanceMod() < 0.1) {
			 stats.setAvoidanceMod(0.1);
		 }
		 if (stats.getAvoidanceMod() > 3.1) {
			 stats.setAvoidanceMod(3.1);
		 }
		 
		 
		 stats.setBlocking(stats.getBlocking() + this.blocking );
		 if (stats.getBlocking() < 0.0) {
			 stats.setBlocking(0.0);
		 }
		 if (this.blockingMod != 0.0) {
			 double multiplier = 1.0;
			 if (stats.getBlockingMod() > 1.0) {
				 multiplier = 2.0;
			 }
			 stats.setBlockingMod(stats.getBlockingMod() + (this.blockingMod * multiplier));
		 }
		 if (stats.getBlockingMod() < 0.1) {
			 stats.setBlockingMod(0.1);
		 }
		 if (stats.getBlockingMod() > 3.1) {
			 stats.setBlockingMod(3.1);
		 }
		 
		 
		 stats.setPenetration(stats.getPenetration() + this.penetration );
		 if (stats.getPenetration() < 0.0) {
			 stats.setPenetration(0.0);
		 }
		 if (stats.getPenetration() > 100.0) {
			 stats.setPenetration(100.0);
		 }
		 if (this.penetrationMod != 0.0) {
			 double multiplier = 1.0;
			 if (stats.getPenetrationMod() > 1.0) {
				 multiplier = 2.0;
			 }
			 stats.setPenetrationMod(stats.getPenetrationMod() + (this.penetrationMod * multiplier));
		 }
		 if (stats.getPenetrationMod() < 0.1) {
			 stats.setPenetrationMod(0.1);
		 }
		 if (stats.getPenetrationMod() > 3.1) {
			 stats.setPenetrationMod(3.1);
		 }
		
	}
	
	
	

}
