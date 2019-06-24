package models;

public class Character extends Entity{
	
	BaseStats baseStats;
	BattleStats battleStats;
	Inventory inventory;

	public Character(String name, String description) {
		super(name, description);
		
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
