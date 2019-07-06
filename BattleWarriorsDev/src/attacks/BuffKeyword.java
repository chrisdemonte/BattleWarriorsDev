package attacks;

import models.Player;
import utilities.BattleLog;

public class BuffKeyword extends BuffEffect{

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
	public void doBuffEffect(Player target, Player self, BattleLog log) {
		// TODO Auto-generated method stub
		super.doBuffEffect(target, self, log);
	}
	

}
