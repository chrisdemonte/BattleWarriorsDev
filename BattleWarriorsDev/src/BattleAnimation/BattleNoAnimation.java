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
import javafx.scene.layout.HBox;
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
		
		EventHandler<ActionEvent> contactHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				attack.makeMove(attacker, defender, scene.getBattleLog());
				scene.getPlayerBar().changeHealthBar();
				scene.getPlayerEnergy().changeEnergyBar();
				scene.getEnemyBar().changeHealthBar();
				if (attack.getSelf() != null) {
					if (attack.getSelf().getInitial() != null) {
						Random rand = new Random();
						if (rand.nextInt(100) < attack.getSelf().getInitialChance()) {
							for (int index = 0; index < attack.getSelf().getInitial().size(); index++) {
								attack.getSelf().getInitial().get(index).doBuffEffect(attacker, attacker, scene.getBattleLog());
							}
						}	
					}
				}
				if (attack.getTarget() != null) {
					if (attack.getTarget().getInitial() != null) {
						Random rand = new Random();
						if (rand.nextInt(100) < attack.getTarget().getInitialChance()) {
							for (int index = 0; index < attack.getTarget().getInitial().size(); index++) {
								attack.getTarget().getInitial().get(index).doBuffEffect(defender, attacker, scene.getBattleLog());
							}
						}	
					}
				}
			}
			
		};
	
		Timeline timeline = new Timeline();
		if (!attacker.isNPC()) {
			timeline.getKeyFrames().addAll(
					new KeyFrame(
							Duration.millis(timerContact),
							contactHandler),
					new KeyFrame(
							Duration.millis(timerTime))
						
					);
			timeline.play();
			
		}
		else {
			timeline.getKeyFrames().addAll(	
					new KeyFrame(
							Duration.millis(timerContact),
							contactHandler),
					new KeyFrame(
							Duration.millis(timerTime))
						
					);
			timeline.play();
			
		}
	}
}
