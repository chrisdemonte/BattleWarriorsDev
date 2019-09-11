package attacks;

import java.io.Serializable;
import java.util.Random;

import BattleSystem.BattleBuffHolder;
import models.Player;
import utilities.BattleLog;

public class BuffEffect implements Serializable {

	private static final long serialVersionUID = -2073938376105187425L;
	int chance;
	String keyword = "";
	
	public BuffEffect(int chance) {
		super();
		this.chance = chance;
	}
	
	public void doBuffEffect(Player target, Player self, BattleBuffHolder bbHolder, BattleLog log) {
		
	}
	public boolean willDoEffect() {
		Random rand = new Random();
		boolean willIt = this.chance > rand.nextInt(100);
		System.out.println(willIt);
		return willIt;

	}

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	

}
