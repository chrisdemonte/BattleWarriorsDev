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

public class BattleAcceleratingAnimation extends BattleAnimation {


	private static final long serialVersionUID = -791979816602090745L;
	public BattleAcceleratingAnimation(int delay, int contact, int recovery, int time) {
		super(delay, contact, recovery, time);

	}

	public BattleAcceleratingAnimation(Move attack) {
		super( 5, 15 , 45, attack.getTime());
	}
	@Override
	public void doBattleAnimation (BattleScene scene, Battle battle, Player attacker, Player defender, Move attack) {

		
		if (!attacker.isDead() && !defender.isDead()) {
			int timerDelay = ((time - attacker.getBattleStats().getHaste()) * this.delay)/100;
			int timerContact = ((time - attacker.getBattleStats().getHaste()) * this.contact)/100;
			int timerRecovery = ((time - attacker.getBattleStats().getHaste()) * this.recovery)/100;
			int timerTime = time - attacker.getBattleStats().getHaste();
			
			HBox playerContainer = scene.getPlayerSpriteContainer();
			HBox enemyContainer = scene.getEnemySpriteContainer();
			double[] playerStartPosition = {scene.getWidth() * .197, scene.getHeight() * .275};
			double[] enemyStartPosition = {scene.getWidth() * .6365, scene.getHeight() * .275};
			double distance = enemyStartPosition[0] - playerStartPosition[0];
			double accelTime = timerContact - timerDelay;
			double acceleration = distance / (accelTime * accelTime);
			double velocity = 0;
			
			
			
			Timeline timeline = new Timeline();
			
			EventHandler<ActionEvent> contactHandler = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					if (attack.makeContact(attacker, defender, scene.getBattleLog())) {
						attack.makeMove(attacker, defender, scene.getBattleLog());
						attack.applyBuffs(attacker, defender, attack, scene.getBattleLog());
					}
					scene.refreshBars();
					scene.getBattleLogPane().updateLog(scene.getBattleLog());
					battle.deathCheck();
				}	
			};
		
			EventHandler<ActionEvent> finalHandler = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					
					timeline.stop();
				}	
			};
			
			if (!attacker.isNPC()) {
				int counter = 0;
				timeline.getKeyFrames().addAll(
						new KeyFrame(Duration.ZERO, new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0])));	
				while (timerDelay + counter < timerContact) {
					timeline.getKeyFrames().addAll(
							new KeyFrame(Duration.millis(timerDelay + counter), new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0] + velocity)));
					velocity += acceleration;
					counter += 15;	
				}
				timeline.getKeyFrames().addAll(
						new KeyFrame(
								Duration.millis(timerContact),
								contactHandler,
								new KeyValue(playerContainer.translateXProperty(), enemyStartPosition[0] - (scene.getWidth() /12))),
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 4)),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0])),		
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 3)),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0] + (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerRecovery),
								new KeyValue(playerContainer.translateXProperty(), enemyStartPosition[0] - (scene.getWidth() /12)),
								new KeyValue(enemyContainer.translateXProperty(),  enemyStartPosition[0] + (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerRecovery + ((timerTime - timerRecovery)/ 2)),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0])),
						new KeyFrame(
								Duration.millis(timerTime),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0]),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0])),
						new KeyFrame(
								Duration.millis(timerTime + attacker.getBattleStats().getHaste()),
								finalHandler)
						);
				timeline.play();
				
			}
			else {
				int counter = 0;
				timeline.getKeyFrames().addAll(
						new KeyFrame(Duration.ZERO, new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0])));	
				while (timerDelay + counter < timerContact) {
					timeline.getKeyFrames().addAll(
							new KeyFrame(Duration.millis(timerDelay + counter), new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0] - velocity)));
					velocity += acceleration;
					counter += 15;	
				}
				timeline.getKeyFrames().addAll(
						new KeyFrame(
								Duration.millis(timerContact),
								contactHandler,
								new KeyValue(enemyContainer.translateXProperty(), playerStartPosition[0] + (scene.getWidth() /12))),
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 4)),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0])),		
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 3)),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0] - (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerRecovery),
								new KeyValue(enemyContainer.translateXProperty(), playerStartPosition[0] + (scene.getWidth() /12)),
								new KeyValue(playerContainer.translateXProperty(),  playerStartPosition[0] - (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerRecovery + ((timerTime - timerRecovery)/ 2)),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0])),
						new KeyFrame(
								Duration.millis(timerTime),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0]),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0])),
						new KeyFrame(
								Duration.millis(timerTime + attacker.getBattleStats().getHaste()),
								finalHandler)
						);
				timeline.play();
			}
		}
	}
	
}
