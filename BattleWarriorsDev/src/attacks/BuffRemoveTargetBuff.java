package attacks;

import java.util.ArrayList;
import java.util.Arrays;

import BattleSystem.BattleBuffHolder;
import models.Player;
import utilities.BattleLog;

public class BuffRemoveTargetBuff extends BuffEffect{

	private static final long serialVersionUID = 7374374552711529129L;
	String[] keywords;

	public BuffRemoveTargetBuff(int chance, String[] keywords) {
		super(chance);
		this.keywords = keywords;
		this.keyword = "remove target buff";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
	ArrayList <BattleBuffHolder> list = target.getBattleBuffs();
		
		for (int i = 0; i < this.keywords.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				for (int k = 0; k < list.get(j).getBuff().getKeywords().length; k++) {
					if (this.keywords[i].contentEquals(list.get(j).getBuff().getKeywords()[k])){
						list.remove(j);
						return;
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return "BuffRemoveTargetBuff [keywords=" + Arrays.toString(keywords) + "\nchance=" + chance + "\nkeyword="
				+ keyword + "]";
	}
	
	
}
