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
	String[] keywords;
	String custom = new String();

	public Buff(String name, String description, ArrayList<BuffEffect> initial, ArrayList<BuffEffect> periodic,
			ArrayList<BuffEffect> end, int duration, int counter, int initialChance, int periodicChance, String[] keywords) {
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
		this.keywords = keywords;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<BuffEffect> getInitial() {
		return initial;
	}
	public void setInitial(ArrayList<BuffEffect> initial) {
		this.initial = initial;
	}
	public ArrayList<BuffEffect> getPeriodic() {
		return periodic;
	}
	public void setPeriodic(ArrayList<BuffEffect> periodic) {
		this.periodic = periodic;
	}
	public ArrayList<BuffEffect> getEnd() {
		return end;
	}
	public void setEnd(ArrayList<BuffEffect> end) {
		this.end = end;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public int getInitialChance() {
		return initialChance;
	}
	public void setInitialChance(int initialChance) {
		this.initialChance = initialChance;
	}
	public int getPeriodicChance() {
		return periodicChance;
	}
	public void setPeriodicChance(int periodicChance) {
		this.periodicChance = periodicChance;
	}
	public String[] getKeywords() {
		return keywords;
	}
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	public String getCustom() {
		return custom;
	}
	public void setCustom(String custom) {
		this.custom = custom;
	}
	
}
