package utilities;

import guiElements.AttackMaker;
import guiElements.BaseStatEditor;
import guiElements.BattleScene;
import guiElements.BattleSelectionPane;
import guiElements.BattleSelectionTab;
import guiElements.BattleStatCreator;
import guiElements.BuffEffectListMaker;
import guiElements.BuffMaker;
import guiElements.StartMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Player;


public class Runner extends Application {

	@Override
	public void start(Stage mainStage) throws Exception {
		
		int width = 1200;
		int height = 800;
		Pane root = new Pane();
		root.setMinSize(width, height);
		
		HBox window = new HBox(root);
		window.setMinSize(width, height);
		window.setMaxSize(width, height);
		
		StartMenu pane = new StartMenu(width, height, root);
		
		root.getChildren().add(pane.getContainer());
		Scene scene = new Scene(window);
		
		mainStage.setScene(scene);
		mainStage.setTitle("Battle Warriors Dev 1.1");
		mainStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
