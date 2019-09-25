package models;

import quest.QuestLog;

public class HumanPlayer extends Player{
	
	QuestLog questLog;

	public HumanPlayer(String name, String description) {
		super(name, description);
		this.questLog = null;
	}

}
