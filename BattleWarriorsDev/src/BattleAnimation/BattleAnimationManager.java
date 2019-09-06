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
	
	
	public BattleAnimationManager() {
		super();
	}

	public void doAttackSequence(Battle battle, BattleScene scene) {
	
		battle.setSequenceCounter(0);
		battle.setAttackCounter(0);
		this.doPriorityAttacks(battle, scene);
	}
	public void doPriorityAttacks (Battle battle, BattleScene scene) {
		
		if (battle.getFasterPriorityAttacks().size() + battle.getSlowerPriorityAttacks().size() > 0) {
			int result = battle.whosFasfter();
			if (result == 0) {
				battle.setFaster(battle.getSelf());
				battle.setFasterPriorityAttacks(battle.getPlayerPriorityChoice());
				battle.setSlower(battle.getEnemy());
				battle.setSlowerPriorityAttacks(battle.getEnemyPriorityChoice());
			}
			else {
				battle.setFaster(battle.getEnemy());
				battle.setFasterPriorityAttacks((battle.getEnemyPriorityChoice()));
				battle.setSlower(battle.getSelf());
				battle.setSlowerPriorityAttacks(battle.getPlayerPriorityChoice());
			}
			int delayCounter = 0;
			Timeline timer = new Timeline();
			ArrayList<EventHandler<ActionEvent>> eventList = new ArrayList<EventHandler<ActionEvent>>();
			
			for (int i = 0; i < battle.getFasterPriorityAttacks().size(); i++) {
				Move attack = battle.getFasterPriorityAttacks().get(i);
				eventList.add(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						attack.getAnimation().doBattleAnimation(scene, battle, battle.getFaster(), battle.getSlower(), attack);
						
					}
				});
					
				
				timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), eventList.get(i)));
				delayCounter += battle.getFasterPriorityAttacks().get(i).getTime() - battle.getFaster().getBattleStats().getHaste();
			}
			for (int i = 0; i < battle.getSlowerPriorityAttacks().size(); i++) {
				Move attack = battle.getSlowerPriorityAttacks().get(i);
				eventList.add(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent t) {
						attack.getAnimation().doBattleAnimation(scene, battle, battle.getSlower(), battle.getFaster(), attack);
						
					}});
					
				
				timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), eventList.get(i + battle.getFasterPriorityAttacks().size())));
				delayCounter += battle.getSlowerPriorityAttacks().get(i).getTime() - battle.getSlower().getBattleStats().getHaste();
			}
			EventHandler<ActionEvent> nextHandler = new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					
					int result = battle.whosFasfter();
					if (result == 0) {
						battle.setFaster(battle.getSelf());
						battle.setFasterAttacks(battle.getPlayerChoice());
						battle.setSlower(battle.getEnemy());
						battle.setSlowerAttacks(battle.getEnemyChoice());
					}
					else {
						battle.setFaster(battle.getEnemy());
						battle.setFasterAttacks((battle.getEnemyChoice()));
						battle.setSlower(battle.getSelf());
						battle.setSlowerAttacks(battle.getPlayerChoice());
					}
						int delayCounter = 0;
						Timeline timer = new Timeline();
						ArrayList<EventHandler<ActionEvent>> eventList = new ArrayList<EventHandler<ActionEvent>>();
						
						for (int i = 0; i < battle.getFasterAttacks().size(); i++) {
							Move attack = battle.getFasterAttacks().get(i);
							eventList.add(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent e) {
									attack.getAnimation().doBattleAnimation(scene, battle, battle.getFaster(), battle.getSlower(), attack);
									
								}});
								
							
							timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), eventList.get(i)));
							delayCounter += battle.getFasterAttacks().get(i).getTime() - battle.getFaster().getBattleStats().getHaste();
						}
						for (int i = 0; i < battle.getSlowerAttacks().size(); i++) {
							Move attack = battle.getSlowerAttacks().get(i);
							eventList.add(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent e) {
									attack.getAnimation().doBattleAnimation(scene, battle, battle.getSlower(), battle.getFaster(), attack);
									
								}});
								
							
							timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), eventList.get(i + battle.getFasterAttacks().size())));
							delayCounter += battle.getSlowerAttacks().get(i).getTime() - battle.getSlower().getBattleStats().getHaste();
						}
						EventHandler<ActionEvent> finalHandler = new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent e) {
								scene.getActionButtons().setPreviousSelection(0);
								scene.getActionTime().clearTabs();
								scene.getAttackPane().getChildren().clear();
								battle.getPlayerChoice().clear();
								battle.getPlayerPriorityChoice().clear();
								battle.getEnemyChoice().clear();
								battle.getEnemyPriorityChoice().clear();
								scene.getPlayerBar().changeHealthBar();
								scene.getPlayerEnergy().changeEnergyBar();
								scene.getEnemyBar().changeHealthBar();
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
		int result = battle.whosFasfter();
		if (result == 0) {
			battle.setFaster(battle.getSelf());
			battle.setFasterAttacks(battle.getPlayerChoice());
			battle.setSlower(battle.getEnemy());
			battle.setSlowerAttacks(battle.getEnemyChoice());
		}
		else {
			battle.setFaster(battle.getEnemy());
			battle.setFasterAttacks((battle.getEnemyChoice()));
			battle.setSlower(battle.getSelf());
			battle.setSlowerAttacks(battle.getPlayerChoice());
		}
	
			int delayCounter = 0;
			Timeline timer = new Timeline();
			ArrayList<EventHandler<ActionEvent>> eventList = new ArrayList<EventHandler<ActionEvent>>();
			
			for (int i = 0; i < battle.getFasterAttacks().size(); i++) {
				Move attack = battle.getFasterAttacks().get(i);
				eventList.add(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						attack.getAnimation().doBattleAnimation(scene, battle, battle.getFaster(), battle.getSlower(), attack);
						
					}});
					
				
				timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), eventList.get(i)));
				delayCounter += battle.getFasterAttacks().get(i).getTime() - battle.getFaster().getBattleStats().getHaste();
			}
			for (int i = 0; i < battle.getSlowerAttacks().size(); i++) {
				Move attack = battle.getSlowerAttacks().get(i);
				eventList.add(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						attack.getAnimation().doBattleAnimation(scene, battle, battle.getSlower(), battle.getFaster(), attack);
						
					}});
					
				
				timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), eventList.get(i + battle.getFasterAttacks().size())));
				delayCounter += battle.getSlowerAttacks().get(i).getTime() - battle.getSlower().getBattleStats().getHaste();
			}
			EventHandler<ActionEvent> finalHandler = new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					scene.getActionButtons().setPreviousSelection(0);
					scene.getActionTime().clearTabs();
					scene.getAttackPane().getChildren().clear();
					battle.getPlayerChoice().clear();
					battle.getPlayerPriorityChoice().clear();
					battle.getEnemyChoice().clear();
					battle.getEnemyPriorityChoice().clear();
					scene.getPlayerBar().changeHealthBar();
					scene.getPlayerEnergy().changeEnergyBar();
					scene.getEnemyBar().changeHealthBar();
				}};
			timer.getKeyFrames().add(new KeyFrame(Duration.millis(delayCounter), finalHandler));
			timer.play();
		}
	
	

}