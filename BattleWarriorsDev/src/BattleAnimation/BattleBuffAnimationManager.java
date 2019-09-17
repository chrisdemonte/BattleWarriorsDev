package BattleAnimation;

import java.util.ArrayList;

import BattleSystem.Battle;
import BattleSystem.BattleBuffHolder;
import attacks.Buff;
import guiElements.BattleScene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class BattleBuffAnimationManager {

	Timeline timer;
	public BattleBuffAnimationManager() {
		
	}
	
	public void doBuffAnimations (Battle battle, BattleScene scene) {
		battle.whosFasfter();
		timer = new Timeline();
		ArrayList<EventHandler<ActionEvent>> eventList = new ArrayList<EventHandler<ActionEvent>>();
		for (int i = 0; i < battle.getSlower().getBattleBuffs().size(); i++) {
			BattleBuffHolder buff = battle.getSlower().getBattleBuffs().get(i);
			eventList.add(e->{
				if (buff.getCooldownCounter() > 1) {
					buff.getBuff().doPeriodicBuff(battle.getSlower(), battle.getSlower(), buff, scene.getBattleLog());
				}
				else {
					if (buff.getBuff().getEnd() != null) {
						buff.getBuff().doEndBuff(battle.getSlower(), battle.getSlower(), buff, scene.getBattleLog());
					}
					else {
						buff.getBuff().doPeriodicBuff(battle.getSlower(), battle.getSlower(), buff, scene.getBattleLog());
					}
				}
				if(battle.deathCheck()) {
					battle.doMoves();
					timer.stop();
					
				}
				scene.refreshBars();
			});
		}
		for (int i = 0; i < battle.getSlower().getBattleDebuffs().size(); i++) {
			BattleBuffHolder buff = battle.getSlower().getBattleDebuffs().get(i);
			eventList.add(e->{
				if (buff.getCooldownCounter() > 1) {
					buff.getBuff().doPeriodicBuff(battle.getSlower(), battle.getFaster(), buff, scene.getBattleLog());
				}
				else {
					if (buff.getBuff().getEnd() !=null) {
						buff.getBuff().doEndBuff(battle.getSlower(), battle.getFaster(), buff, scene.getBattleLog());
					}
					else {
						buff.getBuff().doPeriodicBuff(battle.getSlower(), battle.getFaster(), buff, scene.getBattleLog());
					}
				}
				if(battle.deathCheck()) {
					battle.doMoves();
					timer.stop();
				}
				scene.refreshBars();
			});
		}
		for (int i = 0; i < battle.getFaster().getBattleBuffs().size(); i++) {
			BattleBuffHolder buff = battle.getFaster().getBattleBuffs().get(i);
			eventList.add(e->{
				if (buff.getCooldownCounter() > 1) {
					buff.getBuff().doPeriodicBuff(battle.getFaster(), battle.getFaster(), buff, scene.getBattleLog());
				}
				else {
					if (buff.getBuff().getEnd() != null) {
						buff.getBuff().doEndBuff(battle.getFaster(), battle.getFaster(), buff, scene.getBattleLog());
					}
					else {
						buff.getBuff().doPeriodicBuff(battle.getFaster(), battle.getFaster(), buff, scene.getBattleLog());
					}
				}
				if(battle.deathCheck()) {
					battle.doMoves();
					timer.stop();
					
				}
				scene.refreshBars();
			});
		}
		for (int i = 0; i < battle.getFaster().getBattleDebuffs().size(); i++) {
			BattleBuffHolder buff = battle.getFaster().getBattleDebuffs().get(i);
			eventList.add(e->{
				if (buff.getCooldownCounter() > 1) {
					buff.getBuff().doPeriodicBuff(battle.getFaster(), battle.getSlower(), buff, scene.getBattleLog());
				}
				else {
					if (buff.getBuff().getEnd() !=null) {
						buff.getBuff().doEndBuff(battle.getFaster(), battle.getSlower(), buff, scene.getBattleLog());
					}
					else {
						buff.getBuff().doPeriodicBuff(battle.getFaster(), battle.getSlower(), buff, scene.getBattleLog());
					}
				}
				if(battle.deathCheck()) {
					battle.doMoves();
					timer.stop();
					
				}
				scene.refreshBars();
			});
		}
		eventList.add(e->{
			for (int i = battle.getSelf().getBattleBuffs().size() - 1; i >= 0 ; i--) {
				BattleBuffHolder buff = battle.getSelf().getBattleBuffs().get(i);
				if (buff.getCooldownCounter() <= 0) {
					battle.getSelf().getBattleBuffs().remove(i);
				}
				else {
					battle.getSelf().getBattleBuffs().get(i).decrimentCooldown();
				}
			}
			for (int i = battle.getSelf().getBattleDebuffs().size() - 1; i >= 0 ; i--) {
				BattleBuffHolder buff = battle.getSelf().getBattleDebuffs().get(i);
				if (buff.getCooldownCounter() <= 0) {
					battle.getSelf().getBattleDebuffs().remove(i);
				}
				else {
					battle.getSelf().getBattleDebuffs().get(i).decrimentCooldown();
				}
			}
			for (int i = battle.getEnemy().getBattleBuffs().size() - 1; i >= 0 ; i--) {
				BattleBuffHolder buff = battle.getEnemy().getBattleBuffs().get(i);
				if (buff.getCooldownCounter() <= 0) {
					battle.getEnemy().getBattleBuffs().remove(i);
				}
				else {
					battle.getEnemy().getBattleBuffs().get(i).decrimentCooldown();
				}
			}
			for (int i = battle.getEnemy().getBattleDebuffs().size() - 1; i >= 0 ; i--) {
				BattleBuffHolder buff = battle.getEnemy().getBattleDebuffs().get(i);
				if (buff.getCooldownCounter() <= 0) {
					battle.getEnemy().getBattleDebuffs().remove(i);
				}
				else {
					battle.getEnemy().getBattleDebuffs().get(i).decrimentCooldown();
				}
			}
			battle.doMoves();
			timer.stop();
		});
		int delay = 1000;
		if (eventList.size() == 1) {
			delay = 100;
		}
		for (int i = 0; i < eventList.size(); i++) {
			timer.getKeyFrames().add(
					new KeyFrame(Duration.millis(delay), eventList.get(i)));
			delay += 1000;
		}
		timer.play();
	}
}
