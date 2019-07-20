package BattleSystem;

import java.util.ArrayList;
import java.util.Random;

import attacks.Move;
import guiElements.BattleScene;
import models.Player;

public class Battle {
	
	Player self;
	Player enemy;
	
	ArrayList<Move> fasterPriorityAttacks = new ArrayList<Move>();
	ArrayList<Move> fasterAttacks = new ArrayList<Move>();
	int fasterTimeCounter;
	boolean fasterTryingToRun;
	boolean fasterSkippingTurn;
	ArrayList<Move> slowerPriorityAttacks = new ArrayList<Move>();
	ArrayList<Move> slowerAttacks = new ArrayList<Move>();
	int slowerTimeCounter;
	boolean slowerTryingToRun;
	boolean slowerSkippingTurn;
	
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
		//************set the faster and slower attack selections
		for (int i = 0; i < fasterPriorityAttacks.size(); i++) {
			fasterPriorityAttacks.get(i).makeMove(faster, slower, arena.getBattleLog());
		}
		for (int i = 0; i < slowerPriorityAttacks.size(); i++) {
			slowerPriorityAttacks.get(i).makeMove(slower, slower, arena.getBattleLog());
		}
		for (int i = 0; i < fasterAttacks.size(); i++) {
			fasterPriorityAttacks.get(i).makeMove(faster, slower, arena.getBattleLog());
		}
		for (int i = 0; i < slowerAttacks.size(); i++) {
			slowerPriorityAttacks.get(i).makeMove(slower, slower, arena.getBattleLog());
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
