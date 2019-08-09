package BattleSystem;

import java.util.ArrayList;
import java.util.Random;

import attacks.Move;
import guiElements.BattleScene;
import javafx.scene.control.Label;
import models.Player;

public class Battle {
	
	Player self;
	Player enemy;
	
	ArrayList<Move> playerChoice = new ArrayList<Move>();
	ArrayList<Move> playerPriorityChoice = new ArrayList<Move>();
	ArrayList<Move> enemyChoice = new ArrayList<Move>();
	ArrayList<Move> enemyPriorityChoice = new ArrayList<Move>();
	
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
		this.randomAI();
		Player faster;
		Player slower;
		int result = this.whosFasfter();
		if (result == 0) {
			faster = self;
			fasterPriorityAttacks = playerPriorityChoice;
			slower = enemy;
			slowerPriorityAttacks = enemyPriorityChoice;
		}
		else {
			faster = enemy;
			fasterPriorityAttacks = enemyPriorityChoice;
			slower = self;
			slowerPriorityAttacks = playerPriorityChoice;
	
		}
		//************set the faster and slower attack selections
		for (int z = 0; z < fasterPriorityAttacks.size(); z++) {
			fasterPriorityAttacks.get(z).makeMove(faster, slower, arena.getBattleLog());
			arena.getPlayerBar().changeHealthBar();
			arena.getPlayerEnergy().changeEnergyBar();
			arena.getEnemyBar().changeHealthBar();
		
		}
		for (int y = 0; y < slowerPriorityAttacks.size(); y++) {
			slowerPriorityAttacks.get(y).makeMove(slower, faster, arena.getBattleLog());
			arena.getPlayerBar().changeHealthBar();
			arena.getPlayerEnergy().changeEnergyBar();
			arena.getEnemyBar().changeHealthBar();
		}
		result = this.whosFasfter();
		if (result == 0) {
			faster = self;
			fasterAttacks = playerChoice;
			slower = enemy;
			slowerAttacks = enemyChoice;
		}
		else {
			faster = enemy;
			fasterAttacks = enemyChoice;
			slower = self;
			slowerAttacks = playerChoice;
		}
		for (int x = 0; x < fasterAttacks.size(); x++) {
			fasterAttacks.get(x).makeMove(faster, slower, arena.getBattleLog());
			arena.getPlayerBar().changeHealthBar();
			arena.getPlayerEnergy().changeEnergyBar();
			arena.getEnemyBar().changeHealthBar();
			arena.getEnemyBar().getContainer().getChildren().add(new Label("" + slower.getBattleStats().getCurrentHealth()));
		}
		for (int w = 0; w < slowerAttacks.size(); w++) {
			slowerAttacks.get(w).makeMove(slower, faster, arena.getBattleLog());
			arena.getPlayerBar().changeHealthBar();
			arena.getPlayerEnergy().changeEnergyBar();
			arena.getEnemyBar().changeHealthBar();
			
		}

		arena.getActionButtons().setPreviousSelection(0);
		arena.getSelectionPane().resetActions();
		arena.getAttackPane().getChildren().clear();
		this.playerChoice.clear();
		this.playerPriorityChoice.clear();
		this.enemyChoice.clear();
		this.enemyPriorityChoice.clear();
		arena.getPlayerBar().changeHealthBar();
		arena.getPlayerEnergy().changeEnergyBar();
		arena.getEnemyBar().changeHealthBar();
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
	public void randomAI() {
		Random r = new Random();
		int num = r.nextInt(5);
		if (enemy.getBattleStats().getCurrentEnergy() > 5) {
			if (num == 0) {
				this.enemyChoice.add(this.enemy.getAttacks().getMoveList().get(0));
				this.enemyChoice.add(this.enemy.getAttacks().getMoveList().get(1));
			}
			if (num == 1) {
				this.enemyChoice.add(this.enemy.getAttacks().getMoveList().get(0));
				this.enemyChoice.add(this.enemy.getAttacks().getMoveList().get(0));
				this.enemyChoice.add(this.enemy.getAttacks().getMoveList().get(0));
			}
			if (num == 2) {
				this.enemyChoice.add(this.enemy.getAttacks().getMoveList().get(2));
			}
			if (num == 3) {
				this.enemyChoice.add(this.enemy.getAttacks().getMoveList().get(1));
				this.enemyChoice.add(this.enemy.getAttacks().getMoveList().get(1));
			}
			if (num == 4) {
				this.enemyChoice.add(this.enemy.getAttacks().getMoveList().get(3));
			}
		}
		
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
