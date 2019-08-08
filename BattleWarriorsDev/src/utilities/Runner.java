package utilities;

import guiElements.AttackMaker;
import guiElements.BaseStatEditor;
import guiElements.BattleScene;
import guiElements.BattleSelectionPane;
import guiElements.BattleSelectionTab;
import guiElements.BattleStatCreator;
import guiElements.BuffEffectListMaker;
import guiElements.BuffMaker;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Player;


public class Runner extends Application {

	@Override
	public void start(Stage mainStage) throws Exception {
		
		Pane root = new Pane();
		root.setMinSize(1200, 800);
		Pane window = new Pane(root);
		window.setMinSize(1200, 900);
		window.setMaxSize(1200, 900);
		
		//BaseStatEditor editor = new BaseStatEditor(new BaseStats(), 9);
		//BattleStatCreator editor = new BattleStatCreator();
		//BuffEffectListMaker editor = new BuffEffectListMaker("Test");
		//AttackMaker pane = new AttackMaker();
		//BattleSelectionTab tab = new BattleSelectionTab();
		FileManager manager = new FileManager();
		Player user = new Player("Chris", "Developer");
		user.getAttacks().getMoveList().add(manager.loadMove("Punch"));
		user.getAttacks().getMoveList().add(manager.loadMove("Kick"));
		user.getAttacks().getMoveList().add(manager.loadMove("Spit"));
		user.getAttacks().getMoveList().add(manager.loadMove("Jab"));
		user.getAttacks().getMoveList().add(manager.loadMove("Cross Punch"));
		user.getAttacks().getMoveList().add(manager.loadMove("Double Tiger Strike"));
		Player enemy = new Player("Slime", "Slime");
		enemy.getAttacks().getMoveList().add(manager.loadMove("Bubble"));
		enemy.getAttacks().getMoveList().add(manager.loadMove("Bubble Burst"));
		enemy.getAttacks().getMoveList().add(manager.loadMove("Bubble Bomb"));
		BattleScene pane = new BattleScene(user, enemy);
		//BattleSelectionPane pane = new BattleSelectionPane();
		root.getChildren().add(pane.getRoot());
		Scene scene = new Scene(window);
		
		mainStage.setScene(scene);
		mainStage.setTitle("Battle Warriors Dev 1.1");
		mainStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
