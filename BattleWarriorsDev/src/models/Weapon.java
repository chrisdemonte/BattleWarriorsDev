package models;

public class Weapon extends Equipable{
	
	String slot;
	
	public Weapon(String name, String description, String id, BattleStats stats, BaseStats requirements, String slot) {
		super(name, description, id, stats, requirements);
		this.stats = stats;
		this.requirements = requirements;
		this.slot = slot;
	}

	@Override
	public void equip(Character character) {
		// TODO Auto-generated method stub
		
	}
	

}
