package utilities;

import guiElements.BaseStatEditor;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.BaseStats;

public class Runner extends Application {

	@Override
	public void start(Stage mainStage) throws Exception {
		
		Pane root = new Pane();
		root.setMinSize(600, 400);
		
		BaseStatEditor editor = new BaseStatEditor(new BaseStats(), 10);
		root.getChildren().add(editor.getContainer());
		Scene scene = new Scene(root);
		
		mainStage.setScene(scene);
		mainStage.setTitle("Battle Warriors Dev 1.0");
		mainStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
