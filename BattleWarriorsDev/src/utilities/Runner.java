package utilities;

import guiElements.BaseStatEditor;
import guiElements.BattleStatCreator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.BaseStats;

public class Runner extends Application {

	@Override
	public void start(Stage mainStage) throws Exception {
		
		Pane root = new Pane();
		root.setMinSize(800, 600);
		ScrollPane window = new ScrollPane(root);
		window.setMinSize(800, 600);
		window.setMaxSize(800, 600);
		
		//BaseStatEditor editor = new BaseStatEditor(new BaseStats(), 9);
		BattleStatCreator editor = new BattleStatCreator();
		root.getChildren().add(editor.getContainer());
		Scene scene = new Scene(window);
		
		mainStage.setScene(scene);
		mainStage.setTitle("Battle Warriors Dev 1.1");
		mainStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
