package BattleAnimation;

import java.util.ArrayList;

import BattleSystem.Battle;
import attacks.Move;
import guiElements.BattleScene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import models.Player;

public class BattleAnimationManager {
	
	Timeline timer;
	public BattleAnimationManager() {
		super();
	}

	public void doAttackSequence(Battle battle, BattleScene scene) {
	
		this.doPriorityAttacks(battle, scene);
	}
	public void doPriorityAttacks (Battle battle, BattleScene scene) {
		
		if (battle.getFasterPriorityAttacks().size() + battle.getSlowerPriorityAttacks().size() > 0) {
			battle.whosFasfter();
			int delayCounter = 0;
			timer = new Timeline();
			ArrayList<EventHandler<ActionEvent>> eventList = new ArrayList<EventHandler<ActionEvent>>();
			
			for (int i = 0; i < battle.getFasterPriorityAttacks().size(); i++) {
				Move attack = battle.getFasterPriorityAttacks().get(i);
				eventList.add(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						attack.getAnimation().doBattleAnimation(scene, battle, battle.getFaster(), battle.getSlower(), attack);	
					}});
					
				timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), eventList.get(i)));
				delayCounter += battle.getFasterPriorityAttacks().get(i).getTime();
			}
			for (int i = 0; i < battle.getSlowerPriorityAttacks().size(); i++) {
				Move attack = battle.getSlowerPriorityAttacks().get(i);
				eventList.add(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent t) {
						attack.getAnimation().doBattleAnimation(scene, battle, battle.getSlower(), battle.getFaster(), attack);
					}});
				
				timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), eventList.get(i + battle.getFasterPriorityAttacks().size())));
				delayCounter += battle.getSlowerPriorityAttacks().get(i).getTime();
			}
			EventHandler<ActionEvent> nextHandler = new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {	
					battle.whosFasfter();
						int delayCounter = 0;
						timer = new Timeline();
						ArrayList<EventHandler<ActionEvent>> eventList = new ArrayList<EventHandler<ActionEvent>>();
						
						for (int i = 0; i < battle.getFasterAttacks().size(); i++) {
							Move attack = battle.getFasterAttacks().get(i);
							eventList.add(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent e) {
									attack.getAnimation().doBattleAnimation(scene, battle, battle.getFaster(), battle.getSlower(), attack);
								}});
								
							timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), eventList.get(i)));
							delayCounter += battle.getFasterAttacks().get(i).getTime();
						}
						for (int i = 0; i < battle.getSlowerAttacks().size(); i++) {
							Move attack = battle.getSlowerAttacks().get(i);
							eventList.add(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent e) {
									attack.getAnimation().doBattleAnimation(scene, battle, battle.getSlower(), battle.getFaster(), attack);
								}});
							
							timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), eventList.get(i + battle.getFasterAttacks().size())));
							delayCounter += battle.getSlowerAttacks().get(i).getTime();
						}
						EventHandler<ActionEvent> finalHandler = new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent e) {
								scene.clearTimeDisplayTabs();
								scene.refreshBars();
								scene.getAttackPane().getChildren().clear();
								battle.clearAttackChoices();
								battle.setUpNextTurn();
								timer.stop();
							}};
						timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), finalHandler));
						timer.play();
					}
			};
			timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), nextHandler));
			timer.play();
		}
		else {
			this.doNormalAttacks(battle, scene);
		}
	}
	
	public void doNormalAttacks(Battle battle, BattleScene scene) {
		 battle.whosFasfter();
	
			int delayCounter = 0;
			timer = new Timeline();
			ArrayList<EventHandler<ActionEvent>> eventList = new ArrayList<EventHandler<ActionEvent>>();
			if (battle.confusionCheck(battle.getFaster())){
				battle.rollOnConfusion(battle.getFaster());
			}
			for (int i = 0; i < battle.getFasterAttacks().size(); i++) {
				Move attack = battle.getFasterAttacks().get(i);
				eventList.add(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						attack.getAnimation().doBattleAnimation(scene, battle, battle.getFaster(), battle.getSlower(), attack);	
					}});
			
				timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), eventList.get(i)));
				delayCounter += battle.getFasterAttacks().get(i).getTime();
			}
			if (battle.confusionCheck(battle.getSlower())){
				battle.rollOnConfusion(battle.getSlower());
			}
			for (int i = 0; i < battle.getSlowerAttacks().size(); i++) {
				Move attack = battle.getSlowerAttacks().get(i);
				eventList.add(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						attack.getAnimation().doBattleAnimation(scene, battle, battle.getSlower(), battle.getFaster(), attack);	
					}});	
				
				timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), eventList.get(i + battle.getFasterAttacks().size())));
				delayCounter += battle.getSlowerAttacks().get(i).getTime() ;
			}
			EventHandler<ActionEvent> finalHandler = new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					//scene.getActionButtons().setPreviousSelection(0);
					scene.refreshBars();
					scene.getAttackPane().getChildren().clear();
					battle.clearAttackChoices();
					battle.setUpNextTurn();
					timer.stop();
				}};
			timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), finalHandler));
			timer.play();
		}
	
	

}
