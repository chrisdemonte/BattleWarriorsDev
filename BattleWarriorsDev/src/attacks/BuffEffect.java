package attacks;

import java.util.Random;

import models.Player;
import utilities.BattleLog;

public class BuffEffect {

	String keyword;
	int chance;
	
	public BuffEffect(String keyword, int chance) {
		super();
		this.keyword = keyword;
		this.chance = chance;
	}
	
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		
	}
	public boolean willDoEffect() {
		Random rand = new Random();
		return this.chance > rand.nextInt(100);
	}
	

}
