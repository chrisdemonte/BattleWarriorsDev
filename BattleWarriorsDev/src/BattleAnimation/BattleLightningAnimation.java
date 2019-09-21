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
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import models.Player;

public class BattleLightningAnimation extends BattleAnimation{
	
	private static final long serialVersionUID = 5410439738100957711L;
	int counter = 0;
	ImageView imageView1;
	ImageView imageView2;
	
	
	public BattleLightningAnimation(Move attack) {
		super( 10, 30 , 70, attack.getTime());
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
					scene.getContainer().getChildren().add(imageView1);
					imageView1.setTranslateX(playerStartPosition[0] + (scene.getWidth()/12));
					imageView1.setTranslateY(playerStartPosition[1]);
					imageView1.setOpacity(100.0);
					imageView1.setScaleY(.7);
					imageView1.setScaleX(.8);
					if (attacker.isNPC()) {
						imageView1.setRotate(180);
						//imageView1.setTranslateY((scene.getHeight()/2) - 160);
					}
				}	
			};
		
		
			EventHandler<ActionEvent> secondStrike = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					
					scene.getContainer().getChildren().add(imageView2);
					imageView2.setTranslateX(playerStartPosition[0] + (scene.getWidth()/12));
					imageView2.setTranslateY(playerStartPosition[1]);
					imageView2.setOpacity(100.0);
					imageView2.setScaleY(.7);
					imageView2.setScaleX(.8);
					if (attacker.isNPC()) {
						imageView2.setRotate(180);
						//imageView2.setTranslateY((scene.getHeight()/2) - 135);
					}
					battle.deathCheck();
					
				}	
			};
			
				
			EventHandler<ActionEvent> finalHandler = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					
					scene.getContainer().getChildren().remove(imageView1);
					scene.getContainer().getChildren().remove(imageView2);
					timeline.stop();
				}	
			};
			if (!attacker.isNPC()) {
				timeline.getKeyFrames().addAll(
						new KeyFrame(
								Duration.ZERO),
						new KeyFrame(
								Duration.millis(timerDelay),
								new KeyValue(imageView1.opacityProperty(), 100)),
						
						new KeyFrame(
								Duration.millis(timerContact),
								contactHandler,
								new KeyValue(imageView1.opacityProperty(), 100)),
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 4)),
								secondStrike,
								new KeyValue(imageView1.opacityProperty(), 0),
								new KeyValue(imageView2.opacityProperty(), 100),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0])),
						
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 3)),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0] + (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 2)),
								new KeyValue(imageView2.opacityProperty(), 0)),
						new KeyFrame(
								Duration.millis(timerRecovery),
								new KeyValue(enemyContainer.translateXProperty(), enemyStartPosition[0] + (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerRecovery + ((timerTime - timerRecovery)/ 2)),
								
								new KeyValue(enemyContainer.translateXProperty(),  enemyStartPosition[0])),
						new KeyFrame(
								Duration.millis(timerTime),
								finalHandler)
						);
				timeline.play();
				
			}
			else {
				timeline.getKeyFrames().addAll(
						new KeyFrame(
								Duration.ZERO),
						new KeyFrame(
								Duration.millis(timerDelay),
								new KeyValue(imageView1.opacityProperty(), 100)),
						
						new KeyFrame(
								Duration.millis(timerContact),
								contactHandler,
								new KeyValue(imageView1.opacityProperty(), 100)),
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 4)),
								secondStrike,
								new KeyValue(imageView1.opacityProperty(), 0),
								new KeyValue(imageView2.opacityProperty(), 100),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0])),
						
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 3)),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0] - (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerContact + ((timerRecovery - timerContact)/ 2)),
								new KeyValue(imageView2.opacityProperty(), 0)),
						new KeyFrame(
								Duration.millis(timerRecovery),
								new KeyValue(playerContainer.translateXProperty(), playerStartPosition[0] - (scene.getWidth()* .025))),
						new KeyFrame(
								Duration.millis(timerRecovery + ((timerTime - timerRecovery)/ 2)),
								
								new KeyValue(playerContainer.translateXProperty(),  playerStartPosition[0])),
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
			
			File file = new File("resources/images/attackAssets/projectiles/projectile_" + attack.getName() + "_1.PNG");
			imageView1 = new ImageView( new Image(new FileInputStream(file)));
			File file2 = new File("resources/images/attackAssets/projectiles/projectile_" + attack.getName() + "_2.PNG");
			imageView2 = new ImageView( new Image(new FileInputStream(file2)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			imageView1 = null;
			imageView2 = null;
		}
		
	}
}
