package guiElements;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BattleActionButtonPane {
	
	VBox container = new VBox(3);
	
	Button attackButton = new Button("Attack");
	Button itemButton = new Button("Items");
	Button skipTurnButton = new Button("Skip Turn");
	Button runButton = new Button ("Run");
	
	int previousSelection = 0;
	
	BattleScene scene;
	
	public BattleActionButtonPane ( BattleScene scene) {
		this.scene = scene;
		this.generateLayout(scene);
	}

	private void generateLayout(BattleScene scene2) {
		attackButton.setOnAction(e->{
			if (previousSelection != 1) {
				scene.attackPane.getChildren().clear();
				scene.attackPane.getChildren().add(scene.getSelectionPane().getContainer());
				previousSelection = 1;
			}
		});
		container.getChildren().addAll(attackButton, itemButton, skipTurnButton, runButton);
		
	}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}

	public int getPreviousSelection() {
		return previousSelection;
	}

	public void setPreviousSelection(int previousSelection) {
		this.previousSelection = previousSelection;
	}

}
