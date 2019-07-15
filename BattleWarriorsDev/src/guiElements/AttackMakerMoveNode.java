package guiElements;

import attacks.Move;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class AttackMakerMoveNode {
	
	VBox container = new VBox(3);
	Button submitButton = new Button ("Create Attack");
	public AttackMakerMoveNode() {
		
	}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}

	public Button getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(Button submitButton) {
		this.submitButton = submitButton;
	}
	
	public Move generateAttack() {
		return null;
	}

}
