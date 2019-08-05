package attacks;

import java.io.Serializable;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffFear extends BuffEffect {

	private static final long serialVersionUID = -4130928895872766847L;
	double fear;
	double intimidation;
	
	public BuffFear(int chance, double fear, double intimidation) {
		super(chance);
		this.fear = fear;
		this.intimidation = intimidation;
		this.keyword = "fear";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		
		stats.setFear(stats.getFear() + this.fear);
		if (stats.getFear() < 0.0) {
			stats.setFear(0.0);
		}
		stats.setIntimidation(stats.getIntimidation() + this.intimidation);
		if (stats.getIntimidation() < 0.0) {
			stats.setIntimidation(0.0);
		}


	}

	@Override
	public String toString() {
		return "BuffFear [fear=" + fear + "\nintimidation=" + intimidation + "\nchance=" + chance + "\nkeyword="
				+ keyword + "]";
	}
	

}
