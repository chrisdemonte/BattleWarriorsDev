package models;

public class Weapon extends Item implements Equipable{
	
	BattleStats stats;
	BaseStats requirements;
	String slot;
	
	public Weapon(String name, String description, String id, BattleStats stats, BaseStats requirements, String slot) {
		super(name, description, id);
		this.stats = stats;
		this.requirements = requirements;
		this.slot = slot;
	}

	@Override
	public void equip(Item item) {
		// TODO Auto-generated method stub
		
	}
	

}
