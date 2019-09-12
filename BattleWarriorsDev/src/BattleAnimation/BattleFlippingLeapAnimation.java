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

public class BattleFlippingLeapAnimation extends BattleAnimation {
	
	public BattleFlippingLeapAnimation(Move attack) {
		super( 5, 15 , 45, attack.getTime());
	}
	@Override
	public void doBattleAnimation (BattleScene scene, Battle battle, Player attacker, Player defender, Move attack) {

		HBox playerContainer = scene.getPlayerSpriteContainer();
		HBox enemyContainer = scene.getEnemySpriteContainer();
		
		int timerDelay = ((time - attacker.getBattleStats().getHaste()) * this.delay)/100;
		int timerContact = ((time - attacker.getBattleStats().getHaste()) * this.contact)/100;
		int timerPeakOfJump = timerDelay + ((timerContact - timerDelay)/2);
		int timerRecovery = ((time - attacker.getBattleStats().getHaste()) * this.recovery)/100;
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
				scene.getBattleLogPane().updateLog(scene.getBattleLog());
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
							new KeyValue(playerContainer.translateXProperty(), (scene.getWidth()/3) - 140)),
					new KeyFrame(
							Duration.millis(timerDelay),
							new KeyValue(playerContainer.translateXProperty(), (scene.getWidth()/3) - 140),
							new KeyValue(playerContainer.rotateProperty(), 0),
							new KeyValue(playerContainer.translateYProperty(), (scene.getHeight()/2) - 180)),
					new KeyFrame(
							Duration.millis(timerPeakOfJump),
							new KeyValue(playerContainer.translateYProperty(), (scene.getHeight()/2) - 240)),
					new KeyFrame(
							Duration.millis(timerContact),
							contactHandler,
							new KeyValue(playerContainer.rotateProperty(), 360),
							new KeyValue(playerContainer.translateXProperty(), ((scene.getWidth() * 2)/3) - 160),
							new KeyValue(playerContainer.translateYProperty(), (scene.getHeight()/2) - 180)),
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
							new KeyValue(playerContainer.translateXProperty(), (scene.getWidth()/3) - 140)),
					new KeyFrame(
							Duration.millis(timerTime),
							finalHandler)
					);
			timeline.play();
			
		}
		else {
			timeline.getKeyFrames().addAll(
					new KeyFrame(
							Duration.ZERO,
							new KeyValue(enemyContainer.translateXProperty(), ((scene.getWidth() * 2)/3) - 60),
							new KeyValue(playerContainer.translateXProperty(), (scene.getWidth()/3) - 140)),
					new KeyFrame(
							Duration.millis(timerDelay),
							new KeyValue(enemyContainer.translateXProperty(), ((scene.getWidth() * 2)/3) - 60),
							new KeyValue(enemyContainer.rotateProperty(), 0),
							new KeyValue(enemyContainer.translateYProperty(), (scene.getHeight()/2) - 180)),	
					new KeyFrame(
							Duration.millis(timerPeakOfJump),
							new KeyValue(enemyContainer.translateYProperty(), (scene.getHeight()/2) - 240)),
					new KeyFrame(
							Duration.millis(timerContact),
							contactHandler,
							new KeyValue(enemyContainer.rotateProperty(), -360),
							new KeyValue(enemyContainer.translateXProperty(), (scene.getWidth()/3) - 40),
							new KeyValue(enemyContainer.translateYProperty(), (scene.getHeight()/2) - 180)),
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
							new KeyValue(enemyContainer.translateXProperty(), ((scene.getWidth() * 2)/3) - 60)),
					new KeyFrame(
							Duration.millis(timerTime),
							finalHandler)
					);
			timeline.play();
			
		}
	}
}
