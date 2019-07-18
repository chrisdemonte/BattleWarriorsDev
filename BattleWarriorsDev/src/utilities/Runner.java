package utilities;

import guiElements.AttackMaker;
import guiElements.BaseStatEditor;
import guiElements.BattleScene;
import guiElements.BattleSelectionTab;
import guiElements.BattleStatCreator;
import guiElements.BuffEffectListMaker;
import guiElements.BuffMaker;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


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
	//	AttackMaker editor = new AttackMaker();
		BattleSelectionTab tab = new BattleSelectionTab();
		//BattleScene pane = new BattleScene(1200, 800);
		root.getChildren().add(tab.getContainer());
		Scene scene = new Scene(window);
		
		mainStage.setScene(scene);
		mainStage.setTitle("Battle Warriors Dev 1.1");
		mainStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
