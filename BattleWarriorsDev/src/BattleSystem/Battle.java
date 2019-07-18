package BattleSystem;

import java.util.ArrayList;

import attacks.Move;
import guiElements.BattleScene;
import models.Player;

public class Battle {
	
	Player self;
	Player enemy;
	
	ArrayList<Move> selfPriorityAttacks = new ArrayList<Move>();
	ArrayList<Move> selfAttacks = new ArrayList<Move>();
	int selfTimeCounter;
	ArrayList<Move> enemyPriorityAttacks = new ArrayList<Move>();
	ArrayList<Move> enemyAttacks = new ArrayList<Move>();
	int enemyTimeCounter;
	
	BattleScene arena;
	
	public Battle (Player self, Player enemy) {
		arena = new BattleScene(self, enemy);
	}

}
