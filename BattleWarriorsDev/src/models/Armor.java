package models;

public class Armor extends Equipable{

	String slot;

	public Armor(String name, String description, String id, BattleStats stats, BaseStats requirements, String slot) {
		super(name, description, id, stats, requirements);
		this.slot = slot;
	}
	
	Armor(String slot){
		super("Empty", "No armor in this slot", "0");
		this.slot = new String(slot);
	}

	@Override
	public void equip(Character character) {
		// TODO Auto-generated method stub
	}


	public BattleStats getStats() {
		return stats;
	}


	public void setStats(BattleStats stats) {
		this.stats = stats;
	}


	public BaseStats getRequirements() {
		return requirements;
	}


	public void setRequirements(BaseStats requirements) {
		this.requirements = requirements;
	}


	public String getSlot() {
		return slot;
	}


	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	
}
