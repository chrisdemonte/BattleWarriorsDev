package models;

public class Armor extends Item implements Equipable{

	BattleStats stats;
	BaseStats requirements;
	String slot;

	public Armor(String name, String description, String id, BattleStats stats, BaseStats requirements, String slot) {
		super(name, description, id);
		this.stats = stats;
		this.requirements = requirements;
		this.slot = slot;
	}
	
	Armor(String slot){
		super("Empty", "Have no armor in this slot", "0");
		this.stats = new BattleStats();
		this.requirements = new BaseStats();
		this.slot = slot;
	}

	@Override
	public void equip(Item item) {
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
