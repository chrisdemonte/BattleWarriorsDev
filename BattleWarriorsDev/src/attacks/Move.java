package attacks;

import models.BaseStats;

public abstract class Move {
	
	String name;
	String description;
	int energyCost;
	int uses;
	int currentUses;
	int comboPointGain;
	int comboPointRequirement;
	int time;
	int cooldown;
	int cooldownCounter;
	
	Buff self;
	Buff target;
	BaseStats requirements;
	
	
	public Move(String name, String description, int energyCost, int uses, int currentUses, int comboPointGain,
			int comboPointRequirement, int time, int cooldown, int cooldownCounter, Buff self, Buff target,
			BaseStats requirements) {
		super();
		this.name = name;
		this.description = description;
		this.energyCost = energyCost;
		this.uses = uses;
		this.currentUses = currentUses;
		this.comboPointGain = comboPointGain;
		this.comboPointRequirement = comboPointRequirement;
		this.time = time;
		this.cooldown = cooldown;
		this.cooldownCounter = cooldownCounter;
		this.self = self;
		this.target = target;
		this.requirements = requirements;
	}

	public void resetUses() {
		this.currentUses = this.uses;
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

	public int getEnergyCost() {
		return energyCost;
	}

	public void setEnergyCost(int energyCost) {
		this.energyCost = energyCost;
	}

	public int getUses() {
		return uses;
	}

	public void setUses(int uses) {
		this.uses = uses;
	}

	public int getCurrentUses() {
		return currentUses;
	}

	public void setCurrentUses(int currentUses) {
		this.currentUses = currentUses;
	}

	public int getComboPointGain() {
		return comboPointGain;
	}

	public void setComboPointGain(int comboPointGain) {
		this.comboPointGain = comboPointGain;
	}

	public int getComboPointRequirement() {
		return comboPointRequirement;
	}

	public void setComboPointRequirement(int comboPointRequirement) {
		this.comboPointRequirement = comboPointRequirement;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Buff getSelf() {
		return self;
	}

	public void setSelf(Buff self) {
		this.self = self;
	}

	public Buff getTarget() {
		return target;
	}

	public void setTarget(Buff target) {
		this.target = target;
	}

	public BaseStats getRequirements() {
		return requirements;
	}

	public void setRequirements(BaseStats requirements) {
		this.requirements = requirements;
	}
	
	

}
