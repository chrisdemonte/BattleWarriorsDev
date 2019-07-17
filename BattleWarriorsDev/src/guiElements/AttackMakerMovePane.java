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
	
	public AttackMakerMovePane (BuffMaker self, BuffMaker target) {
		this.generateLayout(self, target);
	}

	private void generateLayout(BuffMaker self, BuffMaker target) {	
		selector.getItems().addAll("Basic Attack");
		selector.getSelectionModel().selectFirst();
		this.setSelectorAction(self, target);
		moveNode = new AttackMakerFullAttack(self, target);
		container.getChildren().addAll(selector, moveNode.getContainer());
		
	}

	private void setSelectorAction(BuffMaker self, BuffMaker target) {
		this.selector.setOnAction(e->{
			String selection = selector.getValue();
			if (selection != null) {
				this.container.getChildren().clear();
				if (selection.contentEquals("Basic Attack")) {
					moveNode = new AttackMakerFullAttack (self, target);
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

	public AttackMakerMoveNode getMoveNode() {
		return moveNode;
	}

	public void setMoveNode(AttackMakerMoveNode moveNode) {
		this.moveNode = moveNode;
	}

	
}
