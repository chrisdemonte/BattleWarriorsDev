package attacks;

import BattleSystem.BattleBuffHolder;
import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffSelfHarm extends BuffEffect{

	private static final long serialVersionUID = 2054899987872560988L;
	boolean enraged;
	int enragedCounter;
	boolean selfHarm;
	int selfHarmCounter;
	
	public BuffSelfHarm(int chance, boolean enraged,
			int enragedCounter, boolean selfHarm, int selfHarmCounter) {
		super(chance);
		this.enraged = enraged;
		this.enragedCounter = enragedCounter;
		this.selfHarm = selfHarm;
		this.selfHarmCounter = selfHarmCounter;
		this.keyword = "self harm";
	}
	@Override
	public void doBuffEffect(Player target, Player self, BattleBuffHolder bbHolder, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		if (this.enragedCounter != 0) {
			stats.setEnraged(this.enraged);
			if (this.enragedCounter > stats.getEnragedCounter() && stats.isEnraged()) {
				stats.setEnragedCounter(this.enragedCounter);
			}
			if (!stats.isEnraged()) {
				stats.setEnragedCounter(0);
			}
		}
		if (this.selfHarmCounter != 0) {
			stats.setSelfHarm(this.selfHarm);
			if (this.selfHarmCounter > stats.getSelfHarmCounter() && stats.isSelfHarm()) {
				stats.setSelfHarmCounter(this.selfHarmCounter);
			}
			if (!stats.isSelfHarm()) {
				stats.setSelfHarmCounter(0);
			}
		}
	}
	@Override
	public String toString() {
		return "BuffSelfHarm [enraged=" + enraged + "\nenragedCounter=" + enragedCounter + "\nselfHarm=" + selfHarm
				+ "\nselfHarmCounter=" + selfHarmCounter + "\nchance=" + chance + "\nkeyword=" + keyword + "]";
	}
	
	
}
