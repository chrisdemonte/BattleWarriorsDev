package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffStatus extends BuffEffect {
	

	private static final long serialVersionUID = -2030340221380872407L;
	double level;
	double stamina;
	double staminaMod;
	double strength;
	double strengthMod;
	double defense;
	double defenseMod;
	double magic;
	double magicMod;
	double resistance;
	double resistanceMod;
	double cunning;
	double cunningMod;
	double intelligence;
	double intelligenceMod;
	double speed;
	double speedMod;
	double skill;
	double skillMod;
	
	

	public BuffStatus(int chance, double level, double stamina,
			double staminaMod, double strength, double strengthMod, double defense, double defenseMod, double magic,
			double magicMod, double resistance, double resistanceMod, double cunning, double cunningMod,
			double intelligence, double intelligenceMod, double speed, double speedMod, double skill, double skillMod) {
		super(chance);
		this.level = level;
		this.stamina = stamina;
		this.staminaMod = staminaMod;
		this.strength = strength;
		this.strengthMod = strengthMod;
		this.defense = defense;
		this.defenseMod = defenseMod;
		this.magic = magic;
		this.magicMod = magicMod;
		this.resistance = resistance;
		this.resistanceMod = resistanceMod;
		this.cunning = cunning;
		this.cunningMod = cunningMod;
		this.intelligence = intelligence;
		this.intelligenceMod = intelligenceMod;
		this.speed = speed;
		this.speedMod = speedMod;
		this.skill = skill;
		this.skillMod = skillMod;
		this.keyword = "status";
	}



	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		stats.setStamina(stats.getStamina() +this.stamina);
		stats.changeStaminaMod(this.staminaMod);
		stats.setStrength(stats.getStrength() +this.strength);
		stats.changeStrengthMod(this.strengthMod);
		stats.setDefense(stats.getDefense() +this.defense);
		stats.changeDefenseMod(this.defenseMod);
		stats.setMagic(stats.getMagic() +this.magic);
		stats.changeMagicMod(this.magicMod);
		stats.setResistance(stats.getResistance() +this.resistance);
		stats.changeResistanceMod(this.resistanceMod);
		stats.setCunning(stats.getCunning() +this.cunning);
		stats.changeCunningMod(this.cunningMod);
		stats.setIntelligence(stats.getIntelligence() +this.intelligence);
		stats.changeIntelligenceMod(this.intelligenceMod);
		stats.setSpeed(stats.getSpeed() +this.speed);
		stats.changeSpeedMod(this.speedMod);
		stats.setSkill(stats.getSkill() +this.skill);
		stats.changeSkillMod(this.skillMod);
	}



	@Override
	public String toString() {
		return "BuffStatus [level=" + level + "\nstamina=" + stamina + "\nstaminaMod=" + staminaMod + "\nstrength="
				+ strength + "\nstrengthMod=" + strengthMod + "\ndefense=" + defense + "\ndefenseMod=" + defenseMod
				+ "\nmagic=" + magic + "\nmagicMod=" + magicMod + "\nresistance=" + resistance + "\nresistanceMod="
				+ resistanceMod + "\ncunning=" + cunning + "\ncunningMod=" + cunningMod + "\nintelligence="
				+ intelligence + "\nintelligenceMod=" + intelligenceMod + "\nspeed=" + speed + "\nspeedMod=" + speedMod
				+ "\nskill=" + skill + "\nskillMod=" + skillMod + "\nchance=" + chance + "\nkeyword=" + keyword + "]";
	}

}
