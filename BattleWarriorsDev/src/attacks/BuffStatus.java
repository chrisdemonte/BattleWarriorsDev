package attacks;

import java.util.ArrayList;

import BattleSystem.BattleBuffHolder;
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
	public void doBuffEffect(Player target, Player self, BattleBuffHolder bbHolder, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		if (this.willDoEffect()) {
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
			
			String logEntry = target.getName() + "'s ";
			ArrayList<String> tempArray = new ArrayList<String>();
			int count = 0;
			if (this.staminaMod > 0.0) {
				tempArray.add(" stamina ");
				count++;
			}
			if (this.strengthMod > 0.0) {
				tempArray.add(" strength ");	
				count++;
			}
			if (this.defenseMod > 0.0) {
				tempArray.add(" defense ");
				count++;
			}
			if (this.magicMod > 0.0) {
				tempArray.add(" magic ");
				count++;
			}
			if (this.resistanceMod > 0.0) {
				tempArray.add(" resistance ");
				count++;
			}
			if (this.cunningMod> 0.0) {
				tempArray.add(" cunning ");
				count++;
			}
			if (this.intelligenceMod > 0.0) {
				tempArray.add(" intelligence ");
				count++;
			}
			if (this.speedMod > 0.0) {
				tempArray.add(" speed ");
				count++;
			}
			if (this.skillMod > 0.0) {
				tempArray.add(" skill ");
				count++;
			}
			if (count > 1) {
				tempArray.set(count - 1, " and" + tempArray.get(count - 1) + "were boosted.");
				logEntry += tempArray.get(0);
				for (int i = 1; i < tempArray.size(); i++) {
					logEntry += "," + tempArray.get(i);
				}
				log.addToLog(logEntry);
			}
			else if (count == 1){
				logEntry += tempArray.get(0) + " was boosted.";
				log.addToLog(logEntry);
			}
			logEntry = target.getName() + "'s ";
			tempArray = new ArrayList<String>();
			count = 0;
			if (this.staminaMod < 0.0) {
				tempArray.add(" stamina ");
				count++;
			}
			if (this.strengthMod < 0.0) {
				tempArray.add(" strength ");	
				count++;
			}
			if (this.defenseMod < 0.0) {
				tempArray.add(" defense ");
				count++;
			}
			if (this.magicMod < 0.0) {
				tempArray.add(" magic ");
				count++;
			}
			if (this.resistanceMod < 0.0) {
				tempArray.add(" resistance ");
				count++;
			}
			if (this.cunningMod< 0.0) {
				tempArray.add(" cunning ");
				count++;
			}
			if (this.intelligenceMod < 0.0) {
				tempArray.add(" intelligence ");
				count++;
			}
			if (this.speedMod < 0.0) {
				tempArray.add(" speed ");
				count++;
			}
			if (this.skillMod < 0.0) {
				tempArray.add(" skill ");
				count++;
			}
			if (count > 1) {
				tempArray.set(count - 1, " and" + tempArray.get(count - 1) + "were lowered");
				logEntry += tempArray.get(0);
				if (count > 2) {
					for (int i = 1; i < tempArray.size(); i++) {
						logEntry += "," + tempArray.get(i);
					}
				}
				log.addToLog(logEntry);
			}
			else if (count == 1){
				logEntry += tempArray.get(0) + " was lowered.";
				log.addToLog(logEntry);
			}
			
		}
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
