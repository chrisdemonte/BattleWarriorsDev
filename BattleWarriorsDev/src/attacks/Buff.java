package attacks;

import models.BattleStats;

public abstract class Buff {
	
	String name;
	String description;
	String keyword;
	
	BattleStats intial;
	BattleStats periodic;
	BattleStats end;
	int duration;
	int counter;

}
