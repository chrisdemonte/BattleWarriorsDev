package BattleSystem;

import java.util.ArrayList;
import java.util.Random;

import BattleAnimation.BattleAnimationManager;
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
	
	Player faster = null;
	ArrayList<Move> fasterPriorityAttacks = new ArrayList<Move>();
	ArrayList<Move> fasterAttacks = new ArrayList<Move>();
	int fasterTimeCounter = 2000;
	boolean fasterTryingToRun = false;
	boolean fasterSkippingTurn = false;
	
	Player slower = null;
	ArrayList<Move> slowerPriorityAttacks = new ArrayList<Move>();
	ArrayList<Move> slowerAttacks = new ArrayList<Move>();
	int slowerTimeCounter = 2000;
	boolean slowerTryingToRun = false;
	boolean slowerSkippingTurn = false;
	
	BattleScene arena;
	
	int sequenceCounter = 0;
	int attackCounter = 0;
	
	public Battle (Player self, Player enemy, BattleScene arena) {
		this.self = self;
		this.enemy = enemy;
		this.arena = arena;
		
	}
	
	public void doTurn() {
		this.doBuffs();
		this.randomAI();
		BattleAnimationManager animation = new BattleAnimationManager();
		animation.doAttackSequence(this, arena);
		
		/**
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
			Move attack = fasterPriorityAttacks.get(z);
			attack.makeMove(faster, slower, arena.getBattleLog());
			arena.getPlayerBar().changeHealthBar();
			arena.getPlayerEnergy().changeEnergyBar();
			arena.getEnemyBar().changeHealthBar();
			if (attack.getSelf() != null) {
				if (attack.getSelf().getInitial() != null) {
					Random rand = new Random();
					if (rand.nextInt(100) < attack.getSelf().getInitialChance()) {
						for (int index = 0; index < attack.getSelf().getInitial().size(); index++) {
							attack.getSelf().getInitial().get(index).doBuffEffect(faster, faster, arena.getBattleLog());
						}
					}	
				}
			}
			if (attack.getTarget() != null) {
				if (attack.getTarget().getInitial() != null) {
					Random rand = new Random();
					if (rand.nextInt(100) < attack.getTarget().getInitialChance()) {
						for (int index = 0; index < attack.getTarget().getInitial().size(); index++) {
							attack.getTarget().getInitial().get(index).doBuffEffect(slower, faster, arena.getBattleLog());
						}
					}	
				}
			}
			//this.deathCheck();
		
		}
		for (int y = 0; y < slowerPriorityAttacks.size(); y++) {
			slowerPriorityAttacks.get(y).makeMove(slower, faster, arena.getBattleLog());
			arena.getPlayerBar().changeHealthBar();
			arena.getPlayerEnergy().changeEnergyBar();
			arena.getEnemyBar().changeHealthBar();
			Move attack = slowerPriorityAttacks.get(y);
			if (attack.getSelf() != null) {
				if (attack.getSelf().getInitial() != null) {
					Random rand = new Random();
					if (rand.nextInt(100) < attack.getSelf().getInitialChance()) {
						for (int index = 0; index < attack.getSelf().getInitial().size(); index++) {
							attack.getSelf().getInitial().get(index).doBuffEffect(slower, slower, arena.getBattleLog());
						}
					}	
				}
			}
			if (attack.getTarget() != null) {
				if (attack.getTarget().getInitial() != null) {
					Random rand = new Random();
					if (rand.nextInt(100) < attack.getTarget().getInitialChance()) {
						for (int index = 0; index < attack.getTarget().getInitial().size(); index++) {
							attack.getTarget().getInitial().get(index).doBuffEffect(faster, slower, arena.getBattleLog());
						}
					}	
				}
			}
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
			Move attack = fasterAttacks.get(x);
			if (attack.getSelf() != null) {
				if (attack.getSelf().getInitial() != null) {
					Random rand = new Random();
					if (rand.nextInt(100) < attack.getSelf().getInitialChance()) {
						for (int index = 0; index < attack.getSelf().getInitial().size(); index++) {
							attack.getSelf().getInitial().get(index).doBuffEffect(faster, faster, arena.getBattleLog());
						}
					}	
				}
			}
			if (attack.getTarget() != null) {
				if (attack.getTarget().getInitial() != null) {
					Random rand = new Random();
					if (rand.nextInt(100) < attack.getTarget().getInitialChance()) {
						for (int index = 0; index < attack.getTarget().getInitial().size(); index++) {
							attack.getTarget().getInitial().get(index).doBuffEffect(slower, faster, arena.getBattleLog());
						}
					}	
				}
			}
		}
		for (int w = 0; w < slowerAttacks.size(); w++) {
			slowerAttacks.get(w).makeMove(slower, faster, arena.getBattleLog());
			arena.getPlayerBar().changeHealthBar();
			arena.getPlayerEnergy().changeEnergyBar();
			arena.getEnemyBar().changeHealthBar();
			Move attack = slowerAttacks.get(w);
			if (attack.getSelf() != null) {
				if (attack.getSelf().getInitial() != null) {
					Random rand = new Random();
					if (rand.nextInt(100) < attack.getSelf().getInitialChance()) {
						for (int index = 0; index < attack.getSelf().getInitial().size(); index++) {
							attack.getSelf().getInitial().get(index).doBuffEffect(slower, slower, arena.getBattleLog());
						}
					}	
				}
			}
			if (attack.getTarget() != null) {
				if (attack.getTarget().getInitial() != null) {
					Random rand = new Random();
					if (rand.nextInt(100) < attack.getTarget().getInitialChance()) {
						for (int index = 0; index < attack.getTarget().getInitial().size(); index++) {
							attack.getTarget().getInitial().get(index).doBuffEffect(faster, slower, arena.getBattleLog());
						}
					}	
				}
			}
		
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
		**/
	}

	public int whosFasfter() {
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
		int num = 2;
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
		else {
			enemy.getBattleStats().setCurrentEnergy(20);
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

	public ArrayList<Move> getEnemyChoice() {
		return enemyChoice;
	}

	public void setEnemyChoice(ArrayList<Move> enemyChoice) {
		this.enemyChoice = enemyChoice;
	}

	public ArrayList<Move> getEnemyPriorityChoice() {
		return enemyPriorityChoice;
	}

	public void setEnemyPriorityChoice(ArrayList<Move> enemyPriorityChoice) {
		this.enemyPriorityChoice = enemyPriorityChoice;
	}

	public Player getFaster() {
		return faster;
	}

	public void setFaster(Player faster) {
		this.faster = faster;
	}

	public Player getSlower() {
		return slower;
	}

	public void setSlower(Player slower) {
		this.slower = slower;
	}

	public int getSequenceCounter() {
		return sequenceCounter;
	}

	public void setSequenceCounter(int sequenceCounter) {
		this.sequenceCounter = sequenceCounter;
	}

	public int getAttackCounter() {
		return attackCounter;
	}

	public void setAttackCounter(int attackCounter) {
		this.attackCounter = attackCounter;
	}

}
