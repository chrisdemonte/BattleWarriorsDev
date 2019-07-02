package models;

import java.util.ArrayList;

import attacks.Buff;
import utilities.AttackList;
import utilities.BattleLog;

public class Player extends Entity{

	BaseStats baseStats;
	BattleStats battleStats;
	Inventory inventory;
	ArrayList<Buff> battleBuffs;
	AttackList attacks;

	public Player(String name, String description) {
		super(name, description);
		this.inventory = new Inventory();
		this.baseStats = new BaseStats();
		this.battleStats = new BattleStats(this);
		battleBuffs = new ArrayList<Buff>();
		attacks = new AttackList();
	}
	

	public Player(String name, String description, BaseStats baseStats, BattleStats battleStats, Inventory inventory,
			ArrayList<Buff> battleBuffs, AttackList attacks) {
		super(name, description);
		this.baseStats = baseStats;
		this.battleStats = battleStats;
		this.inventory = inventory;
		this.battleBuffs = battleBuffs;
		this.attacks = attacks;
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


	public ArrayList<Buff> getBattleBuffs() {
		return battleBuffs;
	}


	public void setBattleBuffs(ArrayList<Buff> battleBuffs) {
		this.battleBuffs = battleBuffs;
	}


	public AttackList getAttacks() {
		return attacks;
	}


	public void setAttacks(AttackList attacks) {
		this.attacks = attacks;
	}
	
}
