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
import guiElements.Window;
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
		
		Window window = new Window(width, height);
		Scene scene = new Scene(window.getContainer());
		window.setScene(scene);
		StartMenu pane = new StartMenu(width, height, window, scene);
		window.getContainer().getChildren().add(pane.getContainer());
		
		
		mainStage.setScene(scene);
		mainStage.setTitle("Battle Warriors Dev 1.1");
		mainStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
