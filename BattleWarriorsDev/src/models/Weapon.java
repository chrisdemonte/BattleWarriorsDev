package models;

public class Weapon extends Equipable{
	
	String slot;
	
	public Weapon(String name, String description, String id, BattleStats stats, BaseStats requirements, String slot) {
		super(name, description, id, stats, requirements);
		this.slot = new String(slot);
	}
	
	public Weapon (String slot) {
		super("Empty", "No armor in this slot", "0");
		this.slot = new String(slot);
	}

	@Override
	public void equip(Character character) {
		// TODO Auto-generated method stub
		
	}
	

}
