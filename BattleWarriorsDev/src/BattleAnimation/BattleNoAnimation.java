package BattleAnimation;

import java.util.Random;

import BattleSystem.Battle;
import attacks.Move;
import guiElements.BattleScene;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import models.Player;

public class BattleNoAnimation extends BattleAnimation{

	
	private static final long serialVersionUID = -1070711046694756798L;
	
	public BattleNoAnimation(int delay, int contact, int recovery, int time) {
		super(delay, contact, recovery, time);
			
	}
	public BattleNoAnimation(Move attack) {
		super( 5, 15 , 45, attack.getTime());
	}
	@Override
	public void doBattleAnimation (BattleScene scene, Battle battle, Player attacker, Player defender, Move attack) {	

		int timerContact = ((time - attacker.getBattleStats().getHaste()) * this.contact)/100;
		int timerTime = time - attacker.getBattleStats().getHaste();
		
		Timeline timeline = new Timeline();
		EventHandler<ActionEvent> contactHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (attack.makeContact(attacker, defender, scene.getBattleLog())) {
					attack.makeMove(attacker, defender, scene.getBattleLog());
					attack.applyBuffs(attacker, defender, attack, scene.getBattleLog());
				}
				scene.getPlayerBar().changeHealthBar();
				scene.getPlayerEnergy().changeEnergyBar();
				scene.getEnemyBar().changeHealthBar();
			}	
		};
		EventHandler<ActionEvent> finalHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				timeline.stop();
			}	
		};
		
		if (!attacker.isNPC()) {
			timeline.getKeyFrames().addAll(
					new KeyFrame(
							Duration.millis(timerContact),
							contactHandler),
					new KeyFrame(
							Duration.millis(timerTime),
							finalHandler)	
					);
			timeline.play();
			
		}
		else {
			timeline.getKeyFrames().addAll(	
					new KeyFrame(
							Duration.millis(timerContact),
							contactHandler),
					new KeyFrame(
							Duration.millis(timerTime),
							finalHandler)	
					);
			timeline.play();
			
		}
	}
}
