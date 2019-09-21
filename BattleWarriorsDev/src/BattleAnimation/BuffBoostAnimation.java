package BattleAnimation;

import BattleSystem.Battle;
import guiElements.BattleScene;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import models.Player;

public class BuffBoostAnimation extends BuffAnimation {


	private static final long serialVersionUID = -746636638439693192L;

	public BuffBoostAnimation (String key) {
	super(key);
	this.key = key;
	}
	
	public void doAnimation (BattleScene scene, Battle battle, Player target) {	
		if (!battle.getSelf().isDead() && !battle.getEnemy().isDead()) {
			
			Image image = scene.getImageFactory().getImage(key);
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(scene.getHeight() / 16.0);
			imageView.setFitWidth(scene.getHeight() / 16.0);
			double[] playerStartPosition = {scene.getWidth() * .197, scene.getHeight() * .275};
			double[] enemyStartPosition = {scene.getWidth() * .6365, scene.getHeight() * .275};
			
			Timeline timeline = new Timeline();
			EventHandler<ActionEvent> contactHandler = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					if (!target.isNPC()) {
						scene.getContainer().getChildren().add(imageView);
						imageView.setTranslateX(playerStartPosition[0] - imageView.getFitHeight());
						imageView.setTranslateY(playerStartPosition[1] + (scene.getPlayerSpriteContainer().getHeight() * .5));
					}
					else {
						scene.getContainer().getChildren().add(imageView);
						imageView.setTranslateX(enemyStartPosition[0] + scene.getEnemySpriteContainer().getWidth());
						imageView.setTranslateY(enemyStartPosition[1] + (scene.getEnemySpriteContainer().getHeight() * .5));
					}
					
				}	
			};
			EventHandler<ActionEvent> finalHandler = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					scene.getContainer().getChildren().remove(imageView);
					timeline.stop();
				}	
			};
			
			if (!target.isNPC()) {
				timeline.getKeyFrames().addAll(
						new KeyFrame(Duration.millis(100), contactHandler, 
								new KeyValue(imageView.translateYProperty(), playerStartPosition[1] + (scene.getPlayerSpriteContainer().getHeight() * .5))),
						new KeyFrame(
								Duration.millis(1000),
								finalHandler,
								new KeyValue(imageView.translateYProperty(), playerStartPosition[1]))	
						);
				timeline.play();
				
			}
			else {
				timeline.getKeyFrames().addAll(	
						new KeyFrame(Duration.millis(100), contactHandler, 
								new KeyValue(imageView.translateYProperty(), enemyStartPosition[1] + (scene.getPlayerSpriteContainer().getHeight() * .5))),
						new KeyFrame(
								Duration.millis(1000),
								finalHandler,
								new KeyValue(imageView.translateYProperty(), enemyStartPosition[1])));	
						
				timeline.play();
				
			}
		}
	}
}
