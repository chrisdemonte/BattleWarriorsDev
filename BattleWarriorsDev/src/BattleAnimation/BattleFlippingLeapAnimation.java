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

		if (!attacker.isDead() && !defender.isDead()) {
			HBox playerContainer = scene.getPlayerSpriteContainer();
			HBox enemyContainer = scene.getEnemySpriteContainer();
			double[] playerStartPosition = {scene.getWidth() * .197, scene.getHeight() * .275};
			double[] enemyStartPosition = {scene.getWidth() * .6365, scene.getHeight() * .275};
			
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
						attack.makeMove(attacker, defender, scene);
						
					}
					scene.refreshBars();
					scene.getBattleLogPane().updateLog(scene.getBattleLog());
					battle.deathCheck();
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
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0])),
						new KeyFrame(
								Duration.millis(timerDelay),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0]),
								new KeyValue(playerContainer.rotateProperty(), 0),
								new KeyValue(playerContainer.translateYProperty(), playerStartPosition[1])),
						new KeyFrame(
								Duration.millis(timerPeakOfJump),
								new KeyValue(playerContainer.translateYProperty(), playerStartPosition[1] - (scene.getHeight()* .08))),
						new KeyFrame(
								Duration.millis(timerContact),
								contactHandler,
								new KeyValue(playerContainer.rotateProperty(), 360),
								new KeyValue(playerContainer.translateXProperty(), enemyStartPosition[0] - (scene.getWidth() /12)),
								new KeyValue(playerContainer.translateYProperty(), playerStartPosition[1])),
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 4)),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0])),		
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 3)),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0] + (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerRecovery),
								new KeyValue(playerContainer.translateXProperty(), enemyStartPosition[0] - (scene.getWidth() /12)),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0] + (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerRecovery + ((timerTime - timerRecovery)/ 2)),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0])),
						new KeyFrame(
								Duration.millis(timerTime),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0])),
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
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0])),
						new KeyFrame(
								Duration.millis(timerDelay),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0]),
								new KeyValue(enemyContainer.rotateProperty(), 0),
								new KeyValue(enemyContainer.translateYProperty(), enemyStartPosition[1])),
						new KeyFrame(
								Duration.millis(timerPeakOfJump),
								new KeyValue(enemyContainer.translateYProperty(), enemyStartPosition[1] - (scene.getHeight()* .08))),
						new KeyFrame(
								Duration.millis(timerContact),
								contactHandler,
								new KeyValue(enemyContainer.rotateProperty(), -360),
								new KeyValue(enemyContainer.translateXProperty(), playerStartPosition[0] +(scene.getWidth() /12)),
								new KeyValue(enemyContainer.translateYProperty(), enemyStartPosition[1])),
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 4)),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0])),		
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 3)),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0] - (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerRecovery),
								new KeyValue(enemyContainer.translateXProperty(), playerStartPosition[0] + (scene.getWidth() /12)),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0] - (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerRecovery + ((timerTime - timerRecovery)/ 2)),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0])),
						new KeyFrame(
								Duration.millis(timerTime),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0])),
						new KeyFrame(
								Duration.millis(timerTime),
								finalHandler)
						);
				timeline.play();
			}	
		}
	}
}
