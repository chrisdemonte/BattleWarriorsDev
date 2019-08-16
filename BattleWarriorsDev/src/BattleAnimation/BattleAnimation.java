package BattleAnimation;

import java.io.Serializable;

import BattleSystem.Battle;
import attacks.Move;
import guiElements.BattleScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import models.Player;

public class BattleAnimation implements Serializable{

	private static final long serialVersionUID = -7130140737481301096L;
	int delay = 0;
	int contact = 0;
	int recovery = 0;
	int time = 0;
	

	
	
	public BattleAnimation(int delay, int contact, int recovery, int time) {
		super();
		this.delay = delay;
		this.contact = contact;
		this.recovery = recovery;
		this.time = time;
		
	}
	
	public void doBattleAnimation (BattleScene scene, Battle battle, Player attacker, Player defender, Move attack) {
		
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public int getRecovery() {
		return recovery;
	}

	public void setRecovery(int recovery) {
		this.recovery = recovery;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}


	

}
