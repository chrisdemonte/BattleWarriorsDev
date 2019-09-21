package BattleSystem;

import BattleAnimation.BattleAnimation;
import BattleAnimation.BuffAnimation;
import attacks.Buff;
import models.Player;

public class BattleBuffHolder {
	
	Buff buff = null;
	int cooldownCounter = 0;
	int cooldown = 0;
	
	double userStamina = 0.0;
	double userStrength = 0.0;
	double userDefense = 0.0;
	double userMagic = 0.0;
	double userResistance = 0.0;
	double userCunning = 0.0;
	double userIntelligence = 0.0;
	double userSkill = 0.0;
	double userSpeed = 0.0;
	
	String key;
	BuffAnimation animation;
	
	public BattleBuffHolder (Buff buff, Player user) {
		this.buff = buff;
		//this.key = buff.getKeywords()[0];
		//animation = new BuffAnimation("heal_icon");
		cooldownCounter = buff.getDuration();
		cooldown = buff.getDuration();
		this.userStamina = user.getBattleStats().getStamina() * user.getBattleStats().getStaminaMod();
		this.userStrength = user.getBattleStats().getStrength() * user.getBattleStats().getStrengthMod();
		this.userDefense = user.getBattleStats().getDefense() * user.getBattleStats().getDefenseMod();
		this.userMagic = user.getBattleStats().getMagic() * user.getBattleStats().getMagicMod();
		this.userResistance = user.getBattleStats().getResistance() * user.getBattleStats().getResistanceMod();
		this.userCunning = user.getBattleStats().getCunning() * user.getBattleStats().getCunningMod();
		this.userIntelligence = user.getBattleStats().getIntelligence() * user.getBattleStats().getIntelligenceMod();
		this.userSkill = user.getBattleStats().getSkill() * user.getBattleStats().getSkillMod();
		this.userSpeed = user.getBattleStats().getSpeed() * user.getBattleStats().getSpeedMod();
	
	}
	public BattleBuffHolder (Player user) {
		this.buff = null;
		cooldownCounter = 0;
		cooldown = 0;
		this.userStamina = user.getBattleStats().getStamina() * user.getBattleStats().getStaminaMod();
		this.userStrength = user.getBattleStats().getStrength() * user.getBattleStats().getStrengthMod();
		this.userDefense = user.getBattleStats().getDefense() * user.getBattleStats().getDefenseMod();
		this.userMagic = user.getBattleStats().getMagic() * user.getBattleStats().getMagicMod();
		this.userResistance = user.getBattleStats().getResistance() * user.getBattleStats().getResistanceMod();
		this.userCunning = user.getBattleStats().getCunning() * user.getBattleStats().getCunningMod();
		this.userIntelligence = user.getBattleStats().getIntelligence() * user.getBattleStats().getIntelligenceMod();
		this.userSkill = user.getBattleStats().getSkill() * user.getBattleStats().getSkillMod();
		this.userSpeed = user.getBattleStats().getSpeed() * user.getBattleStats().getSpeedMod();
	
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
	public double getUserStamina() {
		return userStamina;
	}
	public void setUserStamina(double userStamina) {
		this.userStamina = userStamina;
	}
	public double getUserStrength() {
		return userStrength;
	}
	public void setUserStrength(double userStrength) {
		this.userStrength = userStrength;
	}
	public double getUserDefense() {
		return userDefense;
	}
	public void setUserDefense(double userDefense) {
		this.userDefense = userDefense;
	}
	public double getUserMagic() {
		return userMagic;
	}
	public void setUserMagic(double userMagic) {
		this.userMagic = userMagic;
	}
	public double getUserResistance() {
		return userResistance;
	}
	public void setUserResistance(double userResistance) {
		this.userResistance = userResistance;
	}
	public double getUserCunning() {
		return userCunning;
	}
	public void setUserCunning(double userCunning) {
		this.userCunning = userCunning;
	}
	public double getUserIntelligence() {
		return userIntelligence;
	}
	public void setUserIntelligence(double userIntelligence) {
		this.userIntelligence = userIntelligence;
	}
	public double getUserSkill() {
		return userSkill;
	}
	public void setUserSkill(double userSkill) {
		this.userSkill = userSkill;
	}
	public double getUserSpeed() {
		return userSpeed;
	}
	public void setUserSpeed(double userSpeed) {
		this.userSpeed = userSpeed;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public BuffAnimation getAnimation() {
		return animation;
	}
	public void setAnimation(BuffAnimation animation) {
		this.animation = animation;
	}

}
