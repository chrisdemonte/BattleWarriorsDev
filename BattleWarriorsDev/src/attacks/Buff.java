package attacks;

import java.util.ArrayList;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public abstract class Buff {
	
	String name;
	String description;
	ArrayList<BuffEffect> initial;
	ArrayList<BuffEffect> periodic;
	ArrayList<BuffEffect> end;
	int duration;
	int counter;
	int initialChance;
	int periodicChance;

	public Buff(String name, String description, ArrayList<BuffEffect> initial, ArrayList<BuffEffect> periodic,
			ArrayList<BuffEffect> end, int duration, int counter, int initialChance, int periodicChance) {
		super();
		this.name = name;
		this.description = description;
		this.initial = initial;
		this.periodic = periodic;
		this.end = end;
		this.duration = duration;
		this.counter = counter;
		this.initialChance = initialChance;
		this.periodicChance = periodicChance;
	}
	public void doIntialBuff(Player target, Player self, BattleLog log) {
		if (this.initial != null) {
			for (int i = 0; i < this.end.size(); i++) {
				this.initial.get(i).doBuffEffect(target, self, log);
				this.counter -= 1;
			}
		}
	}
	public void doPeriodicBuff(Player target, Player self, BattleLog log) {
		if (this.counter == 1 && this.end != null) {
			for (int i = 0; i < this.end.size(); i++) {
				this.end.get(i).doBuffEffect(target, self, log);
				this.counter -= 1;
			}
		}
		else if (this.counter == 1 && this.end == null && this.periodic != null) {
			for (int i = 0; i < this.end.size(); i++) {
				this.periodic.get(i).doBuffEffect(target, self, log);
				this.counter -= 1;
			}
		
		}
		else if (this.counter > 1 && this.periodic != null) {
			for (int i = 0; i < this.end.size(); i++) {
				this.periodic.get(i).doBuffEffect(target, self, log);
				this.counter -= 1;
			}
		}
		else {
			this.counter -= 1;
		}
	}
}
