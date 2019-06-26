package models;

import utilities.BattleLog;

public class Player extends Entity{

	BaseStats baseStats;
	BattleStats battleStats;
	Inventory inventory;
	BattleLog log;

	public Player(String name, String description) {
		super(name, description);
		this.inventory = new Inventory();
		this.baseStats = new BaseStats();
		this.battleStats = new BattleStats(this);
		this.log = new BattleLog();
	}

	public BaseStats getBaseStats() {
		return baseStats;
	}

	public void setBaseStats(BaseStats baseStats) {
		this.baseStats = baseStats;
	}

	public BattleStats getBattleStats() {
		return battleStats;
	}

	public void setBattleStats(BattleStats battleStats) {
		this.battleStats = battleStats;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
}
