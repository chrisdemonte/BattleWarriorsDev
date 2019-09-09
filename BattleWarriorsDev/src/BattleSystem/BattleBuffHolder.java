package BattleSystem;

import attacks.Buff;

public class BattleBuffHolder {
	
	Buff buff = null;
	int cooldownCounter = 0;
	int cooldown = 0;
	
	public BattleBuffHolder (Buff buff) {
		this.buff = buff;
		cooldownCounter = buff.getDuration();
		cooldown = buff.getDuration();
	}

	public Buff getBuff() {
		return buff;
	}

	public void setBuff(Buff buff) {
		this.buff = buff;
	}

	public int getCooldownCounter() {
		return cooldownCounter;
	}

	public void setCooldownCounter(int cooldownCounter) {
		this.cooldownCounter = cooldownCounter;
	}

	public void decrimentCooldown() {
		this.cooldownCounter -= 1;
	}
	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

}
