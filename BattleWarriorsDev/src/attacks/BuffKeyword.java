package attacks;

import BattleSystem.BattleBuffHolder;
import models.Player;
import utilities.BattleLog;

public class BuffKeyword extends BuffEffect{

	private static final long serialVersionUID = 4092877885619224334L;
	String selfKeyword;
	int selfKeywordCounter;
	String targetKeyword;
	int targetKeywordCounter;
	
	public BuffKeyword(int chance, String selfKeyword, int selfKeywordCounter, String targetKeyword,
			int targetKeywordCounter) {
		super(chance);
		this.selfKeyword = selfKeyword;
		this.selfKeywordCounter = selfKeywordCounter;
		this.targetKeyword = targetKeyword;
		this.targetKeywordCounter = targetKeywordCounter;
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleBuffHolder bbHolder, BattleLog log) {
		// TODO Auto-generated method stub
		super.doBuffEffect(target, self, bbHolder, log);
	}

	@Override
	public String toString() {
		return "BuffKeyword [selfKeyword=" + selfKeyword + "\nselfKeywordCounter=" + selfKeywordCounter
				+ "\ntargetKeyword=" + targetKeyword + "\ntargetKeywordCounter=" + targetKeywordCounter + "\nchance="
				+ chance + "\nkeyword=" + keyword + "]";
	}
	

}
