package BattleAnimation;

import java.util.ArrayList;
import java.util.Random;

import BattleSystem.Battle;
import attacks.Move;
import guiElements.BattleScene;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import models.Player;

public class BattleSlidingAnimation extends BattleAnimation {

	private static final long serialVersionUID = 151643291110732168L;
	int counter = 0;
	
	public BattleSlidingAnimation(int delay, int contact, int recovery, int time) {
		super(delay, contact, recovery, time);
			
	}
	public BattleSlidingAnimation(Move attack) {
		super( 5, 15 , 45, attack.getTime());
	}
	@Override
	public void doBattleAnimation (BattleScene scene, Battle battle, Player attacker, Player defender, Move attack) {

		HBox playerContainer = scene.getPlayerSpriteContainer();
		HBox enemyContainer = scene.getEnemySpriteContainer();
		
		int timerDelay = ((time - attacker.getBattleStats().getHaste()) * this.delay)/100;
		int timerContact = ((time - attacker.getBattleStats().getHaste()) * this.contact)/100;
		int timerRecovery = ((time - attacker.getBattleStats().getHaste()) * this.recovery)/100;
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
							Duration.ZERO,
							new KeyValue(playerContainer.translateXProperty(), (scene.getWidth()/3) - 140)),
					new KeyFrame(
							Duration.millis(timerDelay),
							new KeyValue(playerContainer.translateXProperty(), (scene.getWidth()/3) - 140)),
					new KeyFrame(
							Duration.millis(timerContact),
							contactHandler,
							new KeyValue(playerContainer.translateXProperty(), ((scene.getWidth() * 2)/3) - 160)),
					new KeyFrame(
							Duration.millis(timerContact + ((timerRecovery - timerContact)/ 4)),
							new KeyValue(enemyContainer.translateXProperty(), ((scene.getWidth() * 2)/3) - 60)),		
					new KeyFrame(
							Duration.millis(timerContact + ((timerRecovery - timerContact)/ 3)),
							new KeyValue(enemyContainer.translateXProperty(), ((scene.getWidth() * 2)/3) - 30)),
					new KeyFrame(
							Duration.millis(timerRecovery),
							new KeyValue(playerContainer.translateXProperty(), ((scene.getWidth() * 2)/3) - 160),
							new KeyValue(enemyContainer.translateXProperty(), ((scene.getWidth() * 2)/3) - 30)),
					new KeyFrame(
							Duration.millis(timerRecovery + ((timerTime - timerRecovery)/ 2)),
							new KeyValue(enemyContainer.translateXProperty(), ((scene.getWidth() * 2)/3) - 60)),
					new KeyFrame(
							Duration.millis(timerTime),
							new KeyValue(playerContainer.translateXProperty(), (scene.getWidth()/3) - 140))
						
					);
			timeline.play();
			
		}
		else {
			timeline.getKeyFrames().addAll(
					new KeyFrame(
							Duration.ZERO,
							new KeyValue(enemyContainer.translateXProperty(), ((scene.getWidth() * 2)/3) - 60)),
					new KeyFrame(
							Duration.millis(timerDelay),
							new KeyValue(enemyContainer.translateXProperty(), ((scene.getWidth() * 2)/3) - 60)),	
					new KeyFrame(
							Duration.millis(timerContact),
							contactHandler,
							new KeyValue(enemyContainer.translateXProperty(), (scene.getWidth()/3) - 40)),
					new KeyFrame(
							Duration.millis(timerContact + ((timerRecovery - timerContact)/ 4)),
							new KeyValue(playerContainer.translateXProperty(), (scene.getWidth()/3) - 140)),	
					new KeyFrame(
							Duration.millis(timerContact + ((timerRecovery - timerContact)/ 3)),
							new KeyValue(playerContainer.translateXProperty(), (scene.getWidth()/3) - 170)),
					new KeyFrame(
							Duration.millis(timerRecovery),
							new KeyValue(enemyContainer.translateXProperty(), (scene.getWidth()/3) - 40),
							new KeyValue(playerContainer.translateXProperty(), (scene.getWidth()/3) - 170)),
					new KeyFrame(
							Duration.millis(timerRecovery + ((timerTime - timerRecovery)/ 2)),
							new KeyValue(playerContainer.translateXProperty(), (scene.getWidth()/3) - 140)),
					new KeyFrame(
							Duration.millis(timerTime),
							new KeyValue(enemyContainer.translateXProperty(), ((scene.getWidth() * 2)/3) - 60))
						
					);
			timeline.play();
			
		}
	}
	
	
}