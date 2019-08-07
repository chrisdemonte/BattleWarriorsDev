package BattleSystem;

import java.util.ArrayList;
import java.util.Random;

import attacks.Move;
import guiElements.BattleScene;
import models.Player;

public class Battle {
	
	Player self;
	Player enemy;
	
	ArrayList<Move> playerChoice = new ArrayList<Move>();
	ArrayList<Move> playerPriorityChoice = new ArrayList<Move>();
	
	ArrayList<Move> fasterPriorityAttacks = new ArrayList<Move>();
	ArrayList<Move> fasterAttacks = new ArrayList<Move>();
	int fasterTimeCounter = 2000;
	boolean fasterTryingToRun = false;
	boolean fasterSkippingTurn = false;
	
	ArrayList<Move> slowerPriorityAttacks = new ArrayList<Move>();
	ArrayList<Move> slowerAttacks = new ArrayList<Move>();
	int slowerTimeCounter = 2000;
	boolean slowerTryingToRun = false;
	boolean slowerSkippingTurn = false;
	
	BattleScene arena;
	
	public Battle (Player self, Player enemy, BattleScene arena) {
		this.self = self;
		this.enemy = enemy;
		this.arena = arena;
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
		result = this.whosFasfter();
		if (result == 0) {
			faster = self;
			slower = enemy;
		}
		else {
			faster = enemy;
			slower = self;
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

	public Player getSelf() {
		return self;
	}

	public void setSelf(Player self) {
		this.self = self;
	}

	public Player getEnemy() {
		return enemy;
	}

	public void setEnemy(Player enemy) {
		this.enemy = enemy;
	}

	public ArrayList<Move> getFasterPriorityAttacks() {
		return fasterPriorityAttacks;
	}

	public void setFasterPriorityAttacks(ArrayList<Move> fasterPriorityAttacks) {
		this.fasterPriorityAttacks = fasterPriorityAttacks;
	}

	public ArrayList<Move> getFasterAttacks() {
		return fasterAttacks;
	}

	public void setFasterAttacks(ArrayList<Move> fasterAttacks) {
		this.fasterAttacks = fasterAttacks;
	}

	public int getFasterTimeCounter() {
		return fasterTimeCounter;
	}

	public void setFasterTimeCounter(int fasterTimeCounter) {
		this.fasterTimeCounter = fasterTimeCounter;
	}

	public boolean isFasterTryingToRun() {
		return fasterTryingToRun;
	}

	public void setFasterTryingToRun(boolean fasterTryingToRun) {
		this.fasterTryingToRun = fasterTryingToRun;
	}

	public boolean isFasterSkippingTurn() {
		return fasterSkippingTurn;
	}

	public void setFasterSkippingTurn(boolean fasterSkippingTurn) {
		this.fasterSkippingTurn = fasterSkippingTurn;
	}

	public ArrayList<Move> getSlowerPriorityAttacks() {
		return slowerPriorityAttacks;
	}

	public void setSlowerPriorityAttacks(ArrayList<Move> slowerPriorityAttacks) {
		this.slowerPriorityAttacks = slowerPriorityAttacks;
	}

	public ArrayList<Move> getSlowerAttacks() {
		return slowerAttacks;
	}

	public void setSlowerAttacks(ArrayList<Move> slowerAttacks) {
		this.slowerAttacks = slowerAttacks;
	}

	public int getSlowerTimeCounter() {
		return slowerTimeCounter;
	}

	public void setSlowerTimeCounter(int slowerTimeCounter) {
		this.slowerTimeCounter = slowerTimeCounter;
	}

	public boolean isSlowerTryingToRun() {
		return slowerTryingToRun;
	}

	public void setSlowerTryingToRun(boolean slowerTryingToRun) {
		this.slowerTryingToRun = slowerTryingToRun;
	}

	public boolean isSlowerSkippingTurn() {
		return slowerSkippingTurn;
	}

	public void setSlowerSkippingTurn(boolean slowerSkippingTurn) {
		this.slowerSkippingTurn = slowerSkippingTurn;
	}

	public BattleScene getArena() {
		return arena;
	}

	public void setArena(BattleScene arena) {
		this.arena = arena;
	}

	public ArrayList<Move> getPlayerChoice() {
		return playerChoice;
	}

	public void setPlayerChoice(ArrayList<Move> playerChoice) {
		this.playerChoice = playerChoice;
	}

	public ArrayList<Move> getPlayerPriorityChoice() {
		return playerPriorityChoice;
	}

	public void setPlayerPriorityChoice(ArrayList<Move> playerPriorityChoice) {
		this.playerPriorityChoice = playerPriorityChoice;
	}

}
