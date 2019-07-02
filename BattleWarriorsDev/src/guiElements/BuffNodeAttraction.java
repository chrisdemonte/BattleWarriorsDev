package guiElements;

import attacks.BuffEffect;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeAttraction extends BuffEffectNode {
	
	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	
	HBox attractionLine = new HBox(3);
	TextField attractionChanceEntry = new TextField();
	Label attractionLabel = new Label("Attraction Chance : ");
	
	BuffNodeAttraction(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		attractionLine.getChildren().addAll(attractionLabel, attractionChanceEntry);
		
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(deleteButton, attractionLine);
		
	}

	private void setDeleteButton(BuffEffectListMaker maker) {
		this.deleteButton.setOnAction(e->{
			int temp = this.id;
			if (temp < maker.idCounter - 1) {
				for (int i = temp; i < maker.idCounter; i++) {
					maker.getBuffNodes().get(i).setId(i - 1);
				}
			}
			maker.getList().remove(temp);
			maker.getContainer().getChildren().remove(temp + 1);
		});
		
	}

	@Override
	public BuffEffect createBuffEffect() {
		return super.createBuffEffect();
	}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}

	
}
