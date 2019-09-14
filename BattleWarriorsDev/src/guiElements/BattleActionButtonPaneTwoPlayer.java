package guiElements;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BattleActionButtonPaneTwoPlayer {
	
	VBox container = new VBox(10);
	Button runButton = new Button("Run");
	
	BattleTwoPlayerScene scene;

	public BattleActionButtonPaneTwoPlayer(BattleTwoPlayerScene scene, int width, int height) {
		super();
		this.scene = scene;
		this.generateLayout(width, height);
	}

	private void generateLayout(int width, int height) {
		this.runButton.setOnAction(e->{
			StartMenu menu = new StartMenu(this.scene.getWidth(), this.scene.getHeight(), this.scene.getRoot());
			this.scene.getRoot().getChildren().clear();
			this.scene.getRoot().getChildren().add(menu.getContainer());
		});
		
		this.runButton.setMinSize(140, 40);	
		container.getChildren().addAll( runButton, scene.getOutput());
		this.container.setPadding(new Insets(10, 0,0,10));
		
	}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}

	public Button getRunButton() {
		return runButton;
	}

	public void setRunButton(Button runButton) {
		this.runButton = runButton;
	}
	public BattleTwoPlayerScene getScene() {
		return scene;
	}

	public void setScene(BattleTwoPlayerScene scene) {
		this.scene = scene;
	}
	
	
	

}
