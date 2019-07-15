package guiElements;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AttackMakerMovePane {
	
	VBox container = new VBox(3);
	
	ComboBox<String> selector = new ComboBox<String>();
	AttackMakerMoveNode moveNode;
	
	public AttackMakerMovePane () {
		this.generateLayout();
	}

	private void generateLayout() {	
		selector.getItems().addAll("Basic Attack");
		selector.getSelectionModel().selectFirst();
		this.setSelectorAction();
		moveNode = new AttackMakerFullAttack();
		container.getChildren().addAll(selector, moveNode.getContainer());
		
	}

	private void setSelectorAction() {
		this.selector.setOnAction(e->{
			String selection = selector.getValue();
			if (selection != null) {
				this.container.getChildren().clear();
				if (selection.contentEquals("Basic Attack")) {
					moveNode = new AttackMakerFullAttack ();
					this.container.getChildren().addAll(selector, moveNode.getContainer());
				}
			}
		});
	}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}

	
}
