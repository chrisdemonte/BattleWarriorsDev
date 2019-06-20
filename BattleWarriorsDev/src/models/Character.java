package models;

public class Character extends Entity{
	
	BaseStats baseStats;
	BattleStats battleStats;
	
	Inventory inventory;

	public Character(String name, String description) {
		super(name, description);
		
	}
	
	

}
