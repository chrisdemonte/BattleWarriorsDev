package guiElements;

import attacks.BuffAttraction;
import attacks.BuffBind;
import attacks.BuffEffect;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeBind extends BuffEffectNode {

	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	HBox buttonLine = new HBox(3);
	
	HBox bindLine = new HBox(3);
	TextField bindChanceEntry = new TextField();
	Label bindLabel = new Label("Bind Chance : ");
	
	BuffNodeBind(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		bindLine.getChildren().addAll(bindLabel, bindChanceEntry);
		
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, bindLine);
		
	}

	private void setDeleteButton(BuffEffectListMaker maker) {
		this.deleteButton.setOnAction(e->{
			int temp = this.id;
			if (maker.getList().size() == 1) {
				maker.getList().remove(0);
				maker.getContainer().getChildren().remove(1);
				maker.idCounter--;
				return;
			}
			else if (temp < maker.idCounter - 1) {
				for (int i = temp; i < maker.idCounter; i++) {
					maker.getBuffNodes().get(i).setId(i - 1);
				}
			}
			maker.getList().remove(temp);
			maker.getContainer().getChildren().remove(temp + 1);
			maker.idCounter--;
		});
		
	}

	@Override
	public BuffEffect createBuffEffect() {
		BuffEffect effect;
		try{
			effect = new BuffBind(Integer.parseInt(this.bindChanceEntry.getText()));
		
		}
		catch (Exception ex) {
			effect = null;
		}
		return effect;
	}
	

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}

}
