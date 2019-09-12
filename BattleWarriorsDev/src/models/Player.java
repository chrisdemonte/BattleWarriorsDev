package models;

import java.util.ArrayList;

import BattleSystem.BattleBuffHolder;
import attacks.Buff;
import attacks.Move;
import utilities.AttackList;
import utilities.BattleLog;
import utilities.FileManager;

public class Player extends Entity{

	BaseStats baseStats;
	BattleStats battleStats;
	Inventory inventory;
	ArrayList<BattleBuffHolder> battleBuffs;
	ArrayList<BattleBuffHolder> battleDebuffs;
	AttackList attacks;
	boolean isNPC = true;

	public Player(String name, String description) {
		super(name, description);
		this.inventory = new Inventory();
		this.baseStats = new BaseStats();
		this.battleStats = new BattleStats(this);
		this.battleBuffs = new ArrayList<BattleBuffHolder>();
		this.battleDebuffs = new ArrayList<BattleBuffHolder>();
		attacks = new AttackList();
	}
	public Player(String name, String description, BaseStats baseStats, ArrayList<Move> attackList) {
		super(name, description);
		this.inventory = new Inventory();
		this.baseStats = baseStats;
		this.battleStats = new BattleStats(this);
		this.battleBuffs = new ArrayList<BattleBuffHolder>();
		this.battleDebuffs = new ArrayList<BattleBuffHolder>();
		attacks = new AttackList();
		this.generateAttacks(attackList);
	}
	
	private void generateAttacks(ArrayList<Move> attackList) {
		for (int i = 0; i < attackList.size(); i++) {
			this.attacks.getMoveList().add(attackList.get(i));
		}
		
	}
	public Player(String name, String description, BaseStats baseStats, BattleStats battleStats, Inventory inventory,
			ArrayList<BattleBuffHolder> battleBuffs, AttackList attacks) {
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
	public ArrayList<BattleBuffHolder> getBattleBuffs() {
		return battleBuffs;
	}
	public void setBattleBuffs(ArrayList<BattleBuffHolder> battleBuffs) {
		this.battleBuffs = battleBuffs;
	}
	public AttackList getAttacks() {
		return attacks;
	}
	public void setAttacks(AttackList attacks) {
		this.attacks = attacks;
	}
	public boolean isNPC() {
		return isNPC;
	}
	public void setNPC(boolean isNPC) {
		this.isNPC = isNPC;
	}

	public ArrayList<BattleBuffHolder> getBattleDebuffs() {
		return battleDebuffs;
	}

	public void setBattleDebuffs(ArrayList<BattleBuffHolder> battleDebuffs) {
		this.battleDebuffs = battleDebuffs;
	}
	
}
