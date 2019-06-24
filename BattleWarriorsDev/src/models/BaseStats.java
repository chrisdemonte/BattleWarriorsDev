package models;

public class BaseStats {
	
	private int level;
	private int stamina;
	private int strength;
	private int defense;
	private int magic;
	private int resistance; 
	private int cunning;
	private int intelligence; 
	private int speed;
	private int skill;
	
	//
	public BaseStats(int level, int stamina, int strength, int defense, int magic, int resistance, int cunning,
			int intelligence, int speed, int skill) {
		
		this.level = level;
		this.stamina = stamina;
		this.strength = strength;
		this.defense = defense;
		this.magic = magic;
		this.resistance = resistance;
		this.cunning = cunning;
		this.intelligence = intelligence;
		this.speed = speed;
		this.skill = skill;
	}
	public BaseStats (BaseStats other) {
		this.level = other.level;
		this.stamina = other.stamina;
		this.strength = other.strength;
		this.defense = other.defense;
		this.magic = other.magic;
		this.resistance = other.resistance;
		this.cunning = other.cunning;
		this.intelligence = other.intelligence;
		this.speed = other.speed;
		this.skill = other.skill;
	}
	
	public BaseStats () {
		this.level = 1;
		this.stamina = 1;
		this.strength = 1;
		this.defense = 1;
		this.magic = 1;
		this.resistance = 1;
		this.cunning = 1;
		this.intelligence = 1;
		this.speed = 1;
		this.skill = 1;
		
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
		
		if (this.stamina < 1) {
			this.stamina = 1;
		}
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
		if (this.strength < 1) {
			this.strength = 1;
		}
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
		if (this.defense < 1) {
			this.defense = 1;
		}
	}

	public int getMagic() {
		return magic;
	}

	public void setMagic(int magic) {
		this.magic = magic;
		if (this.magic < 1) {
			this.magic = 1;
		}
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
		if (this.resistance < 1) {
			this.resistance = 1;
		}
	}

	public int getCunning() {
		return cunning;
	}

	public void setCunning(int cunning) {
		this.cunning = cunning;
		if (this.cunning < 1) {
			this.cunning = 1;
		}
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
		if (this.intelligence < 1) {
			this.intelligence = 1;
		}
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
		if (this.speed < 1) {
			this.speed = 1;
		}
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
		if (this.skill < 1) {
			this.skill = 1;
		}
	}
	
	
	
	

}
