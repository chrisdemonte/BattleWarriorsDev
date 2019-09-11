package BattleAnimation;

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

public class BattleFlipAnimation extends BattleAnimation {
	

	public BattleFlipAnimation(int delay, int contact, int recovery, int time) {
		super(delay, contact, recovery, time);
		// TODO Auto-generated constructor stub
	}

	public BattleFlipAnimation(Move attack) {
		super( 5, 30 , 40, attack.getTime());
	}
	@Override
	public void doBattleAnimation (BattleScene scene, Battle battle, Player attacker, Player defender, Move attack) {

		HBox playerContainer = scene.getPlayerSpriteContainer();
		HBox enemyContainer = scene.getEnemySpriteContainer();
		
		int timerDelay = ((time - attacker.getBattleStats().getHaste()) * this.delay)/100;
		int timePeak = ((time - attacker.getBattleStats().getHaste()) * this.contact)/200;
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
				playerContainer.setRotate(0);
				enemyContainer.setRotate(0);
				timeline.stop();
			}	
		};
		if (!attacker.isNPC()) {
			timeline.getKeyFrames().addAll(
					new KeyFrame(
							Duration.ZERO,
							new KeyValue(playerContainer.rotateProperty(), 0),
							new KeyValue(playerContainer.translateYProperty(), (scene.getHeight()/2) - 180)),
					new KeyFrame(
							Duration.millis(timerDelay),
							new KeyValue(playerContainer.rotateProperty(), 0),
							new KeyValue(playerContainer.translateYProperty(), (scene.getHeight()/2) - 180)),
					new KeyFrame(
							Duration.millis(timePeak),
							contactHandler,
							new KeyValue(playerContainer.translateYProperty(), (scene.getHeight()/2) - 240)),
					new KeyFrame(
							Duration.millis(timerContact),
							new KeyValue(playerContainer.rotateProperty(), 360),
							new KeyValue(playerContainer.translateYProperty(), (scene.getHeight()/2) - 180)),
								
					new KeyFrame(
							Duration.millis(timerTime),
							finalHandler,
							new KeyValue(playerContainer.translateYProperty(), (scene.getHeight()/2) - 180))
					);
			timeline.play();
			
		}
		else {
			timeline.getKeyFrames().addAll(
					new KeyFrame(
							Duration.ZERO,
							new KeyValue(enemyContainer.rotateProperty(), 0),
							new KeyValue(enemyContainer.translateYProperty(), (scene.getHeight()/2) - 180)),
					new KeyFrame(
							Duration.millis(timerDelay),
							new KeyValue(enemyContainer.rotateProperty(), 0),
							new KeyValue(enemyContainer.translateYProperty(), (scene.getHeight()/2) - 180)),
					new KeyFrame(
							Duration.millis(timePeak),
							contactHandler,
							new KeyValue(enemyContainer.translateYProperty(), (scene.getHeight()/2) - 240)),
					new KeyFrame(
							Duration.millis(timerContact),
							new KeyValue(enemyContainer.rotateProperty(), -360),
							new KeyValue(enemyContainer.translateYProperty(), (scene.getHeight()/2) - 180)),
								
					new KeyFrame(
							Duration.millis(timerTime),
							finalHandler,
							new KeyValue(enemyContainer.translateYProperty(), (scene.getHeight()/2) - 180))
					);
			timeline.play();
			
		}
	}
}

