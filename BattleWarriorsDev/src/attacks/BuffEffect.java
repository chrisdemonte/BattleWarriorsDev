package attacks;

import java.util.Random;

import models.Player;

public class BuffEffect {
	
	String name;
	String description;
	String keyword;
	int chance;
	
	public BuffEffect(String name, String description, String keyword, int chance) {
		super();
		this.name = name;
		this.description = description;
		this.keyword = keyword;
		this.chance = chance;
	}
	
	public void doBuffEffect(Player target, Player self) {
		
	}
	public boolean willDoEffect() {
		Random rand = new Random();
		return this.chance > rand.nextInt(100);
	}
	

}
