package attacks;

import java.io.Serializable;
import java.util.Random;

import BattleAnimation.BattleAnimation;
import BattleSystem.BattleBuffHolder;
import models.BaseStats;
import models.Player;
import utilities.BattleLog;

public abstract class Move implements Serializable{
	

	private static final long serialVersionUID = 8651754386121982630L;
	String name;
	String description;
	String customText;
	String[] keywords;
	int energyCost;
	int uses;
	int currentUses;
	int comboPointGain;
	int comboPointRequirement;
	int time;
	int cooldown;
	int cooldownCounter;
	boolean priority;
	
	Buff self;
	Buff target;
	BaseStats requirements;
	
	BattleAnimation animation;
	
	public Move(String name, String description, String customText, String[] keywords, int energyCost, int uses, int currentUses, int comboPointGain,
			int comboPointRequirement, int time, int cooldown, int cooldownCounter, boolean priority, Buff self, Buff target,
			BaseStats requirements) {
		super();
		this.name = name;
		this.description = description;
		this.customText = customText;
		this.keywords = keywords;
		this.energyCost = energyCost;
		this.uses = uses;
		this.currentUses = currentUses;
		this.comboPointGain = comboPointGain;
		this.comboPointRequirement = comboPointRequirement;
		this.time = time;
		this.cooldown = cooldown;
		this.cooldownCounter = cooldownCounter;
		this.priority = priority;
		this.self = self;
		this.target = target;
		this.requirements = requirements;
		this.animation = null;
	}
	public void makeMove(Player self, Player target, BattleLog log) {
		
	}

	public boolean makeContact (Player self, Player target, BattleLog log ) {
		boolean makesContact = true;
		
		if (!self.getBattleStats().isCanAttack()) {
			makesContact = false;
		}
		if (target.getBattleStats().isOutOfReach() && !self.getBattleStats().isReach()) {
			makesContact = false;
		}
		if (target.getBattleStats().isHidden()) {
			makesContact = false;
		}
		/**
		if (target.getBattleStats().getIntimidation() > 0 || self.getBattleStats().getFear() > 0) {
			int totalFear = (int)(target.getBattleStats().getIntimidation() + self.getBattleStats().getFear());
			Random rand = new Random();
			if (rand.nextInt(totalFear) >  )
		}
		**/
		return makesContact;
	}
	public void applyBuffs (Player self, Player target, Move attack, BattleLog log) {
		if (attack.getSelf() != null) {
			if (attack.getSelf().getInitial() != null) {
				Random rand = new Random();
				if (rand.nextInt(100) < attack.getSelf().getInitialChance()) {
					for (int index = 0; index < attack.getSelf().getInitial().size(); index++) {
						attack.getSelf().getInitial().get(index).doBuffEffect(self, self, new BattleBuffHolder(self), log);
						
					}
				}	
				System.out.println("Buff Self");
			}
			if (attack.getSelf().getPeriodic() != null || attack.getSelf().getEnd() != null) {
				Random rand = new Random();
				if (rand.nextInt(100) < attack.getSelf().getPeriodicChance()) {
					self.getBattleBuffs().add(new BattleBuffHolder(attack.getSelf(), self));
					
				}
				System.out.println("Buff Periodic Self");
			}
		}
		if (attack.getTarget() != null) {
			if (attack.getTarget().getInitial() != null) {
				Random rand = new Random();
				if (rand.nextInt(100) < attack.getTarget().getInitialChance()) {
					for (int index = 0; index < attack.getTarget().getInitial().size(); index++) {
						attack.getTarget().getInitial().get(index).doBuffEffect(target, self, new BattleBuffHolder(self), log);
					}
				}	
				System.out.println("DeBuff Target");
			}
			if (attack.getTarget().getPeriodic() != null || attack.getTarget().getEnd() != null) {
				Random rand = new Random();
				if (rand.nextInt(100) < attack.getTarget().getPeriodicChance()) {
					target.getBattleDebuffs().add(new BattleBuffHolder(attack.getTarget(), self));
				}
				System.out.println("DeBuff Periodic Target");
			}
		}
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
	public int getCooldown() {
		return cooldown;
	}
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	public int getCooldownCounter() {
		return cooldownCounter;
	}
	public void setCooldownCounter(int cooldownCounter) {
		this.cooldownCounter = cooldownCounter;
	}
	public String getCustomText() {
		return customText;
	}
	public void setCustomText(String customText) {
		this.customText = customText;
	}
	public String[] getKeywords() {
		return keywords;
	}
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	public boolean isPriority() {
		return priority;
	}
	public void setPriority(boolean priority) {
		this.priority = priority;
	}
	public BattleAnimation getAnimation() {
		return animation;
	}
	public void setAnimation(BattleAnimation animation) {
		this.animation = animation;
	}
	
	

}
