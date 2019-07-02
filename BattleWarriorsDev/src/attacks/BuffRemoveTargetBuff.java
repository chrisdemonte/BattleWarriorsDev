package attacks;

import java.util.ArrayList;

import models.Player;
import utilities.BattleLog;

public class BuffRemoveTargetBuff extends BuffEffect{

	String[] keywords;

	public BuffRemoveTargetBuff(int chance, String[] keywords) {
		super(chance);
		this.keywords = keywords;
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
	ArrayList <Buff> list = target.getBattleBuffs();
		
		for (int i = 0; i < this.keywords.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				for (int k = 0; k < list.get(j).getKeywords().length; k++) {
					if (this.keywords[i].contentEquals(list.get(j).getKeywords()[k])){
						list.remove(j);
						return;
					}
				}
			}
		}
	}
	
	
}