package BattleSystem;

import java.util.ArrayList;
import java.util.Random;

import BattleAnimation.BattleAnimationManager;
import BattleAnimation.BattleBuffAnimationManager;
import attacks.Move;
import guiElements.BattleScene;
import javafx.scene.control.Label;
import models.Player;
import utilities.FileManager;

public class Battle {
	
	Player self;
	Player enemy;
	
	boolean playerChose = false;
	ArrayList<Move> playerChoice = new ArrayList<Move>();
	ArrayList<Move> playerPriorityChoice = new ArrayList<Move>();
	boolean enemyChose = false;
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
	Move skipturn = null;
	Move confusion = null;
	int turnCounter = 0;
	
	public Battle () {
		FileManager manager = new FileManager();
		this.skipturn = manager.loadMove("Skip Turn");
		this.confusion = manager.loadMove("Confusion Hit");
	}
	
	public void doTurn() {
		
	}

	public void whosFasfter() {
		int result = 0;
		if ((self.getBattleStats().getSpeed() * self.getBattleStats().getSpeedMod()) >
		(enemy.getBattleStats().getSpeed() * enemy.getBattleStats().getSpeedMod())) {
			result = 0;
		}
		else if ((self.getBattleStats().getSpeed() * self.getBattleStats().getSpeedMod()) ==
		(enemy.getBattleStats().getSpeed() * enemy.getBattleStats().getSpeedMod())) {
			Random rand = new Random();
			if (rand.nextInt(2) == 0) {
				result = 0;
			}
			else {
				result = 1;
			}
		}
		else {
			result = 1;
		}
		if (result == 0) {
			setFaster(getSelf());
			setFasterPriorityAttacks(getPlayerPriorityChoice());
			setFasterAttacks(getPlayerChoice());
			setSlower(getEnemy());
			setSlowerPriorityAttacks(getEnemyPriorityChoice());
			setSlowerAttacks(getEnemyChoice());
		}
		else {
			setFaster(getEnemy());
			setFasterPriorityAttacks(getEnemyPriorityChoice());
			setFasterAttacks(getEnemyChoice());
			setSlower(getSelf());
			setSlowerPriorityAttacks(getPlayerPriorityChoice());
			setSlowerAttacks(getPlayerChoice());
		}
	}

	public void doBuffs() {
		BattleBuffAnimationManager animation = new BattleBuffAnimationManager();
		animation.doBuffAnimations(this, this.arena);
		
	}
	public void doMoves() {
		BattleAnimationManager animation = new BattleAnimationManager();
		animation.doAttackSequence(this, arena);
	}
	public void setUpNextTurn () {
		arena.setButtonsDisabled(false);
		arena.getActionButtons().setPreviousSelection(0);
		self.getBattleStats().battleTurnUpdate();
		enemy.getBattleStats().battleTurnUpdate();
		ArrayList<Move> arr = self.getAttacks().getMoveList();
		for (int i = 0; i < arr.size(); i++) {
			Move move = arr.get(i);
			if (move.getCooldownCounter() > 0) {
				move.setCooldownCounter(move.getCooldownCounter() - 1);
			}
			if (move.getCooldownCounter() < 0) {
				move.setCooldownCounter(0);
			}
		}
		arr = enemy.getAttacks().getMoveList();
		for (int i = 0; i < arr.size(); i++) {
			Move move = arr.get(i);
			if (move.getCooldownCounter() > 0) {
				move.setCooldownCounter(move.getCooldownCounter() - 1);
			}
			if (move.getCooldownCounter() < 0) {
				move.setCooldownCounter(0);
			}
		}
	}
	public void randomAI() {
		Random r = new Random();
		int num = 2;
	//	if (enemy.getBattleStats().getCurrentEnergy() > 5) {
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
	//	}
//		else {
	//		enemy.getBattleStats().setCurrentEnergy(20);
//		}
		
	}
	public void clearAttackChoices() {
		this.getPlayerChoice().clear();
		this.getPlayerPriorityChoice().clear();
		this.getEnemyChoice().clear();
		this.getEnemyPriorityChoice().clear();
		this.getFasterPriorityAttacks().clear();
		this.getFasterAttacks().clear();
		this.getSlowerAttacks().clear();
		this.getSlowerPriorityAttacks().clear();
	}
	public boolean deathCheck() {
		if (self.getBattleStats().getCurrentHealth() <= 0) {
			self.setDead(true);
		}
		if (enemy.getBattleStats().getCurrentHealth() <= 0) {
			enemy.setDead(true);
		}
		return self.isDead() || enemy.isDead();
	}
	public boolean confusionCheck (Player player) {
		boolean confused = false;
		for (int i = 0; i < player.getBattleBuffs().size(); i++) {
			if (player.getBattleBuffs().get(i).getBuff().getName().contentEquals("Confused")) {
				confused = true;
			};
		}
		for (int i = 0; i < player.getBattleDebuffs().size(); i++) {
			if (player.getBattleDebuffs().get(i).getBuff().getName().contentEquals("Confused")) {
				confused = true;
			};
		}
		if (player.getBattleStats().isEnraged()) {
			confused = false;
		}
		return confused; 
	}
	public void rollOnConfusion(Player player) {
		Random rand = new Random();
		int roll = rand.nextInt(100);
		if (roll <= 33) {
			
		}
		else if (roll <=66) {
			player.getBattleStats().setSelfHarm(true);
		}
		else {
			if (player == self) {
				this.playerChoice.clear();
				this.playerPriorityChoice.clear();
				this.playerChoice.add(confusion);
			}
			if (player == enemy) {
				this.enemyChoice.clear();
				this.enemyPriorityChoice.clear();
				this.enemyChoice.add(confusion);
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


	public int getTurnCounter() {
		return turnCounter;
	}

	public void setAttackCounter(int turnCounter) {
		this.turnCounter = turnCounter;
	}

	public Move getSkipturn() {
		return skipturn;
	}

	public void setSkipturn(Move skipturn) {
		this.skipturn = skipturn;
	}

	public boolean isPlayerChose() {
		return playerChose;
	}

	public void setPlayerChose(boolean playerChose) {
		this.playerChose = playerChose;
	}

	public boolean isEnemyChose() {
		return enemyChose;
	}

	public void setEnemyChose(boolean enemyChose) {
		this.enemyChose = enemyChose;
	}

	public void setTurnCounter(int turnCounter) {
		this.turnCounter = turnCounter;
	}

}
