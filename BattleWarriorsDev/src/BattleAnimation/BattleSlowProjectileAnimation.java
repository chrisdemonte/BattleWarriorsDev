package BattleAnimation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import BattleSystem.Battle;
import attacks.Move;
import guiElements.BattleScene;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import models.Player;

public class BattleSlowProjectileAnimation extends BattleAnimation {

	private static final long serialVersionUID = 2814397040100052154L;
	int counter = 0;
	ImageView imageView = null;
	
	public BattleSlowProjectileAnimation(int delay, int contact, int recovery, int time) {
		super(delay, contact, recovery, time);
			
	}
	public BattleSlowProjectileAnimation(Move attack) {
		super( 10, 60 , 85, attack.getTime());
	}
	@Override
	public void doBattleAnimation (BattleScene scene, Battle battle, Player attacker, Player defender, Move attack) {
		if (!attacker.isDead() && !defender.isDead()) {
			HBox playerContainer = scene.getPlayerSpriteContainer();
			HBox enemyContainer = scene.getEnemySpriteContainer();
			
			double[] playerStartPosition = {scene.getWidth() * .197, scene.getHeight() * .275};
			double[] enemyStartPosition = {scene.getWidth() * .6365, scene.getHeight() * .275};
			
			this.getImages(attack);
			
			int timerDelay = ((time - attacker.getBattleStats().getHaste()) * this.delay)/100;
			int timerContact = ((time - attacker.getBattleStats().getHaste()) * this.contact)/100;
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
					scene.getContainer().getChildren().remove(imageView);
					battle.deathCheck();
				}	
				
			};
		
			EventHandler<ActionEvent> projectileHandler = new EventHandler<ActionEvent>() {
	
				@Override
				public void handle(ActionEvent e) {
					if (imageView != null) {
						scene.getContainer().getChildren().add(imageView);
						Random rand = new Random();
						imageView.setTranslateY((scene.getHeight()* .35) - rand.nextInt(100));
						
						if (attacker.isNPC()) {
							imageView.setRotate(180);
						}	
					}
					
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
								Duration.ZERO,
								new KeyValue(imageView.translateXProperty(), playerStartPosition[0] + (scene.getWidth()/12))),
						new KeyFrame(
								Duration.millis(timerDelay),
								projectileHandler,
								new KeyValue(imageView.translateXProperty(), playerStartPosition[0] + (scene.getWidth()/12))),
								
						new KeyFrame(
								Duration.millis(timerContact),
								contactHandler,
								new KeyValue(imageView.translateXProperty(), enemyStartPosition[0] - (scene.getWidth()/12))),
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 4)),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0])),		
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 3)),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0] + (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerRecovery),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0] + (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerRecovery + ((timerTime - timerRecovery)/ 2)),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0])),
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
								new KeyValue(imageView.translateXProperty(), enemyStartPosition[0] - (scene.getWidth()/12))),
						new KeyFrame(
								Duration.millis(timerDelay),
								projectileHandler,
								new KeyValue(imageView.translateXProperty(), enemyStartPosition[0] - (scene.getWidth()/12))),
								
						new KeyFrame(
								Duration.millis(timerContact),
								contactHandler,
								new KeyValue(imageView.translateXProperty(), playerStartPosition[0] + (scene.getWidth()/12))),
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 4)),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0])),		
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 3)),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0] - (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerRecovery),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0] - (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerRecovery + ((timerTime - timerRecovery)/ 2)),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0])),
						new KeyFrame(
								Duration.millis(timerTime),
								finalHandler)
						);
				timeline.play();
				
			}
		}
	}
	private void getImages(Move attack) {
		try {
			
			File file = new File("resources/images/attackAssets/projectiles/projectile_" + attack.getName() + ".PNG");
			imageView = new ImageView( new Image(new FileInputStream(file)));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			imageView = null;
		}
		
	}
}
