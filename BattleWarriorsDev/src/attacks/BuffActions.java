package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffActions extends BuffEffect{
	
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
	
	public BuffActions(String name, String description, String keyword, int chance, boolean canAttack,
			int canAttackCounter, boolean canUseItems, int canUseItemsCounter, boolean canSkipTurn,
			int canSkipTurnCounter, boolean canRun, int canRunCounter, boolean locked, int lockedCounter) {
		super(name, description, keyword, chance);
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
	
	

}
