package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffResources extends BuffEffect{

	int maxHealth;
	int currentHealth;
	int maxEnergy;
	int currentEnergy;
	int maxComboPoints;
	int currentComboPoints;
	
	public BuffResources(int chance, int maxHealth, int currentHealth,
			int maxEnergy, int currentEnergy, int maxComboPoints, int currentComboPoints) {
		super(chance);
		this.maxHealth = maxHealth;
		this.currentHealth = currentHealth;
		this.maxEnergy = maxEnergy;
		this.currentEnergy = currentEnergy;
		this.maxComboPoints = maxComboPoints;
		this.currentComboPoints = currentComboPoints;
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		
		stats.setMaxHealth(stats.getMaxHealth() + this.maxHealth);
		if (stats.getMaxHealth() < stats.getLevel()) {
			stats.setMaxHealth((int)stats.getLevel());
		}
		stats.setCurrentHealth(stats.getCurrentHealth() + this.currentHealth);
		if (stats.getCurrentHealth() > stats.getMaxHealth()) {
			stats.setCurrentHealth(stats.getMaxHealth());
		}
		stats.setMaxEnergy(stats.getMaxEnergy() + this.maxEnergy);
		if (stats.getMaxEnergy() < 10) {
			stats.setMaxEnergy(10);
		}
		stats.setCurrentEnergy(stats.getCurrentEnergy() + this.currentEnergy);
		if (stats.getCurrentEnergy() > stats.getMaxEnergy()) {
			stats.setCurrentEnergy(stats.getMaxEnergy());
		}
		stats.setMaxComboPoints(stats.getMaxComboPoints() + this.maxComboPoints);
		if (stats.getMaxComboPoints() < 1) {
			stats.setMaxComboPoints(1);
		}
		stats.setCurrentComboPoints(stats.getCurrentComboPoints() + this.currentComboPoints);
		if (stats.getCurrentComboPoints() > stats.getMaxComboPoints()) {
			stats.setCurrentComboPoints(stats.getMaxComboPoints());
		}
	}
	
	
}
