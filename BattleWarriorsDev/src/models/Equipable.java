package models;

public class Equipable extends Item {

	BattleStats stats;
	BaseStats requirements;
	
	public Equipable(String name, String description, String id, BattleStats stats, BaseStats requirements) {
		super(name, description, id);
		this.stats = new BattleStats();
		this.stats.addBattleStats(stats);
		this.requirements = new BaseStats(requirements);
		
	}
	public Equipable (String name, String description, String id){
		super(name, description, id);
		this.stats = new BattleStats();
		this.requirements = new BaseStats();
	}
	
	public void equip (Character character) {
		
	}

}
