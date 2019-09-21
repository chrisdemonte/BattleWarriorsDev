package attacks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import BattleAnimation.BuffAnimation;
import BattleAnimation.BuffBoostAnimation;
import BattleAnimation.BuffLowerAnimation;
import BattleAnimation.BuffSpinningAnimation;
import BattleSystem.Battle;
import BattleSystem.BattleBuffHolder;
import guiElements.BattleScene;
import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class Buff implements Serializable{
	
	private static final long serialVersionUID = 1954235966522599290L;
	String name;
	String description;
	ArrayList<BuffEffect> initial;
	ArrayList<BuffEffect> periodic;
	ArrayList<BuffEffect> end;
	int duration;
	int initialChance;
	int periodicChance;
	String[] keywords;
	String custom = new String();

	public Buff(String name, String description, ArrayList<BuffEffect> initial, ArrayList<BuffEffect> periodic,
			ArrayList<BuffEffect> end, int duration,  int initialChance, int periodicChance, String[] keywords) {
		super();
		this.name = name;
		this.description = description;
		this.initial = initial;
		this.periodic = periodic;
		this.end = end;
		this.duration = duration;
		this.initialChance = initialChance;
		this.periodicChance = periodicChance;
		this.keywords = keywords;
	}
	public void doIntialBuff(Player target, Player self, BattleBuffHolder bbHolder, BattleLog log) {
		if (this.initial != null) {
			for (int i = 0; i < this.initial.size(); i++) {
				this.initial.get(i).doBuffEffect(target, self, bbHolder, log);
			}
		}
	}
	public void doPeriodicBuff(Player target, Player self, BattleBuffHolder bbHolder, BattleLog log) {
		if (this.periodic != null) {
			for (int i = 0; i < this.periodic.size(); i++) {
				this.periodic.get(i).doBuffEffect(target, self, bbHolder, log);
			}
		}
	}
	public void doEndBuff(Player target, Player self, BattleBuffHolder bbHolder, BattleLog log) {
		if (this.end != null) {
			for (int i = 0; i < this.end.size(); i++) {
				this.end.get(i).doBuffEffect(target, self, bbHolder, log);
			}
		}
	}
	
	@Override
	public String toString() {
		String temp = "\nBuff [name=" + name + "\ndescription=" + description + "\ninitial="; 
		
		if (this.initial != null) {
			for (int i = 0; i < this.initial.size(); i++) {
				temp += "\n" + initial.get(i).toString();
			}
		}
		else {
			temp += "null";
		}
		temp += "\nperiodic="; 
		if (this.periodic!= null) {
			for (int i = 0; i < periodic.size(); i++) {
				temp+= "\n" + periodic.get(i).toString();
			}
		}
		else {
			temp += "null";
		}
		if (this.end!= null) {
			for (int i = 0; i < end.size(); i++) {
				temp+= "\n" + end.get(i).toString();
			}
		}
		else {
			temp += "null";
		}
		temp += "\nduration=" + duration + "\ninitialChance="
				+ initialChance + "\nperiodicChance=" + periodicChance + "\nkeywords=" + Arrays.toString(keywords)
				+ "\ncustom=" + custom + "]";
		return temp;
	}
	public void runAnimation (Battle battle, BattleScene scene, Player target, int option) {
		//option 0 is initial, option 1 is periodic, option 2 is end
		String animationKey;
		String iconKey;
		if (option == 0) {
			animationKey = this.keywords[0];
			iconKey = this.keywords[1];
		}
		else if (option == 1) {
			animationKey = this.keywords[2];
			iconKey = this.keywords[3];
		}
		else if (option == 2) {
			animationKey = this.keywords[4];
			iconKey = this.keywords[5];
		}
		else {
			animationKey = null;
			iconKey = null;
			
		}
		if (animationKey == null) {
			BuffAnimation animation = new BuffAnimation("heal_icon");
			animation.doAnimation(scene, battle, target);
		}
		else if (animationKey.contentEquals("boost")) {
			BuffBoostAnimation animation = new BuffBoostAnimation(iconKey);
			animation.doAnimation(scene, battle, target);
		}
		else if (animationKey.contentEquals("lower")) {
			BuffLowerAnimation animation = new BuffLowerAnimation(iconKey);
			animation.doAnimation(scene, battle, target);
		}
		else if (animationKey.contentEquals("spin")) {
			BuffSpinningAnimation animation = new BuffSpinningAnimation(iconKey);
			animation.doAnimation(scene, battle, target);
		}
		else {
			BuffAnimation animation = new BuffAnimation("combopoint_icon");
			animation.doAnimation(scene, battle, target);
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
