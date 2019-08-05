package attacks;

import java.io.Serializable;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffActions extends BuffEffect {


	private static final long serialVersionUID = -5340333908832456536L;
	boolean canAttack;
	int canAttackCounter;
	boolean canUseItems;
	int canUseItemsCounter;
	boolean canSkipTurn;
	int canSkipTurnCounter;
	boolean canRun;
	int canRunCounter;
	boolean locked;
	int lockedCounter;
	
	public BuffActions(int chance, boolean canAttack,
			int canAttackCounter, boolean canUseItems, int canUseItemsCounter, boolean canSkipTurn,
			int canSkipTurnCounter, boolean canRun, int canRunCounter, boolean locked, int lockedCounter) {
		super(chance);
		this.canAttack = canAttack;
		this.canAttackCounter = canAttackCounter;
		this.canUseItems = canUseItems;
		this.canUseItemsCounter = canUseItemsCounter;
		this.canSkipTurn = canSkipTurn;
		this.canSkipTurnCounter = canSkipTurnCounter;
		this.canRun = canRun;
		this.canRunCounter = canRunCounter;
		this.locked = locked;
		this.lockedCounter = lockedCounter;
		this.keyword = "actions";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		if (this.canAttackCounter != 0) {
			stats.setCanAttack(this.canAttack);
			if (this.canAttackCounter > stats.getCanAttackCounter() && !stats.isCanAttack()) {
				stats.setCanAttackCounter(this.canAttackCounter);
			}
			if (stats.isCanAttack()) {
				stats.setCanAttackCounter(0);
			}
		}
		if (this.canUseItemsCounter != 0) {
			stats.setCanUseItems(this.canUseItems);
			if (this.canUseItemsCounter > stats.getCanUseItemsCounter() && !stats.isCanUseItems()) {
				stats.setCanUseItemsCounter(this.canUseItemsCounter);
			}
			if (stats.isCanUseItems()) {
				stats.setCanUseItemsCounter(0);
			}
		}
		if (this.canSkipTurnCounter != 0) {
			stats.setCanSkipTurn(this.canSkipTurn);
			if (this.canSkipTurnCounter > stats.getCanSkipTurnCounter()&& !stats.isCanSkipTurn()) {
				stats.setCanSkipTurnCounter(this.canSkipTurnCounter);
			}
			if (stats.isCanSkipTurn()) {
				stats.setCanSkipTurnCounter(0);
			}
		}
		if (this.canRunCounter != 0) {
			stats.setCanRun(this.canRun);
			if (this.canRunCounter > stats.getCanRunCounter() && !stats.isCanRun()) {
				stats.setCanRunCounter(this.canRunCounter);
			}
			if (stats.isCanRun()) {
				stats.setCanRunCounter(0);
			}
		}
		if (this.lockedCounter != 0) {
			stats.setLocked(this.locked);
			if (this.lockedCounter > stats.getLockedCounter() && stats.isLocked()) {
				stats.setLockedCounter(this.lockedCounter);
			}
			if (!stats.isLocked()) {
				stats.setLockedCounter(0);
			}
		}
	}

	public boolean isCanAttack() {
		return canAttack;
	}

	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}

	public int getCanAttackCounter() {
		return canAttackCounter;
	}

	public void setCanAttackCounter(int canAttackCounter) {
		this.canAttackCounter = canAttackCounter;
	}

	public boolean isCanUseItems() {
		return canUseItems;
	}

	public void setCanUseItems(boolean canUseItems) {
		this.canUseItems = canUseItems;
	}

	public int getCanUseItemsCounter() {
		return canUseItemsCounter;
	}

	public void setCanUseItemsCounter(int canUseItemsCounter) {
		this.canUseItemsCounter = canUseItemsCounter;
	}

	public boolean isCanSkipTurn() {
		return canSkipTurn;
	}

	public void setCanSkipTurn(boolean canSkipTurn) {
		this.canSkipTurn = canSkipTurn;
	}

	public int getCanSkipTurnCounter() {
		return canSkipTurnCounter;
	}

	public void setCanSkipTurnCounter(int canSkipTurnCounter) {
		this.canSkipTurnCounter = canSkipTurnCounter;
	}

	public boolean isCanRun() {
		return canRun;
	}

	public void setCanRun(boolean canRun) {
		this.canRun = canRun;
	}

	public int getCanRunCounter() {
		return canRunCounter;
	}

	public void setCanRunCounter(int canRunCounter) {
		this.canRunCounter = canRunCounter;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public int getLockedCounter() {
		return lockedCounter;
	}

	public void setLockedCounter(int lockedCounter) {
		this.lockedCounter = lockedCounter;
	}

	@Override
	public String toString() {
		return "BuffActions \ncanAttack=" + canAttack + "\ncanAttackCounter=" + canAttackCounter + "\ncanUseItems="
				+ canUseItems + "\ncanUseItemsCounter=" + canUseItemsCounter + "\ncanSkipTurn=" + canSkipTurn
				+ "\ncanSkipTurnCounter=" + canSkipTurnCounter + "\ncanRun=" + canRun + "\ncanRunCounter="
				+ canRunCounter + "\nlocked=" + locked + "\nlockedCounter=" + lockedCounter + "]";
	}
	
	
	

}
