package guiElements;

import attacks.BuffEffect;
import attacks.BuffMindControl;
import attacks.BuffProtection;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeProtection extends BuffEffectNode {

	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	

	HBox buttonLine = new HBox(3);
	
	HBox protectChanceLine = new HBox(3);
	TextField protectChanceEntry = new TextField();
	Label protectChanceLabel = new Label("Protect Chance : ");
	
	HBox protectLine = new HBox(3);
	TextField protectEntry = new TextField();
	Label protectLabel = new Label("Protect Chance : ");
	HBox protectCounterLine = new HBox(3);
	TextField protectCounterEntry = new TextField();
	Label protectCounterLabel = new Label("Protect Counter : ");
	
	HBox immuneLine = new HBox(3);
	TextField immuneEntry = new TextField();
	Label immuneLabel = new Label("Immune : ");
	HBox immuneCounterLine = new HBox(3);
	TextField immuneCounterEntry = new TextField();
	Label immuneCounterLabel = new Label("Immune Counter : ");
	
	BuffNodeProtection(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		protectChanceLine.getChildren().addAll(protectChanceLabel, protectChanceEntry);
		protectLine.getChildren().addAll(protectLabel, protectEntry);
		protectCounterLine.getChildren().addAll(protectCounterLabel, protectCounterEntry);
		immuneLine.getChildren().addAll(immuneLabel, immuneEntry);
		immuneCounterLine.getChildren().addAll(immuneCounterLabel, immuneCounterEntry);
		
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, protectChanceLine, protectLine, protectCounterLine, immuneLine, immuneCounterLine);
		
	}

	private void setDeleteButton(BuffEffectListMaker maker) {
		this.deleteButton.setOnAction(e->{
			int temp = this.id;
			if (maker.getList().size() == 1) {
				maker.getList().remove(0);
				maker.getContainer().getChildren().remove(2);
				maker.idCounter--;
				return;
			}
			else if (temp < maker.idCounter - 1) {
				for (int i = temp; i < maker.idCounter; i++) {
					maker.getBuffNodes().get(i).setId(i-1);
				}
			
			}
			maker.getList().remove(temp);
			maker.getContainer().getChildren().remove(temp + 2);
			maker.idCounter--;
			
		});
		
	}

	@Override
	public BuffEffect createBuffEffect() {
		BuffEffect effect;
		try{
			effect = new BuffProtection(
					Integer.parseInt(this.protectChanceEntry.getText()),
					Double.parseDouble(this.protectEntry.getText()),
					Integer.parseInt(this.protectCounterEntry.getText()),
					Double.parseDouble(this.immuneEntry.getText()),
					Integer.parseInt(this.immuneCounterEntry.getText()));
		
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