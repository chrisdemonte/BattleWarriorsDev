package BattleSystem;

import java.util.ArrayList;
import java.util.Random;

import attacks.Move;
import guiElements.BattleScene;
import models.Player;

public class Battle {
	
	Player self;
	Player enemy;
	
	ArrayList<Move> selfPriorityAttacks = new ArrayList<Move>();
	ArrayList<Move> selfAttacks = new ArrayList<Move>();
	int selfTimeCounter;
	boolean selfTryingToRun;
	boolean selfSkippingTurn;
	ArrayList<Move> enemyPriorityAttacks = new ArrayList<Move>();
	ArrayList<Move> enemyAttacks = new ArrayList<Move>();
	int enemyTimeCounter;
	boolean enemyTryingToRun;
	boolean enemySkippingTurn;
	
	BattleScene arena;
	
	public Battle (Player self, Player enemy) {
		arena = new BattleScene(self, enemy);
	}
	
	public void doTurn() {
		this.doBuffs();
		Player faster;
		Player slower;
		int result = this.whosFasfter();
		if (result == 0) {
			faster = self;
			slower = enemy;
		}
		else {
			faster = enemy;
			slower = self;
		}
	}

	private int whosFasfter() {
		if ((self.getBattleStats().getSpeed() * self.getBattleStats().getSpeedMod()) >
		(enemy.getBattleStats().getSpeed() * enemy.getBattleStats().getSpeedMod())) {
			return 0;
		}
		else if ((self.getBattleStats().getSpeed() * self.getBattleStats().getSpeedMod()) ==
		(enemy.getBattleStats().getSpeed() * enemy.getBattleStats().getSpeedMod())) {
			Random rand = new Random();
			if (rand.nextInt(2) == 0) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else {
			return 1;
		}
	}

	private void doBuffs() {
		// TODO Auto-generated method stub
		
	}

}
