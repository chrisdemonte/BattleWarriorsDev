package guiElements;

import attacks.BuffEffect;
import attacks.BuffGrab;
import attacks.BuffResources;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeResources extends BuffEffectNode {

	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	

	HBox buttonLine = new HBox(3);
	
	HBox resourcesLine = new HBox(3);
	TextField resourcesChanceEntry = new TextField();
	Label resourcesLabel = new Label("Resources Chance : ");
	
	HBox maxHealthLine = new HBox(3);
	TextField maxHealthEntry = new TextField();
	Label maxHealthLabel = new Label("Max Health : ");
	
	HBox currentHealthLine = new HBox(3);
	TextField currentHealthEntry = new TextField();
	Label currentHealthLabel = new Label("Current Health : ");
	
	HBox maxEnergyLine = new HBox(3);
	TextField maxEnergyEntry = new TextField();
	Label maxEnergyLabel = new Label("Max Energy : ");
	
	HBox currentEnergyLine = new HBox(3);
	TextField currentEnergyEntry = new TextField();
	Label currentEnergyLabel = new Label("Current Energy : ");
	
	HBox maxComboPointsLine = new HBox(3);
	TextField maxComboPointsEntry = new TextField();
	Label maxComboPointsLabel = new Label("Max Combo Points : ");
	
	HBox currentComboPointsLine = new HBox(3);
	TextField currentComboPointsEntry = new TextField();
	Label currentComboPointsLabel = new Label("Current Combo Points : ");
	
	BuffNodeResources(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		resourcesLine.getChildren().addAll(resourcesLabel, resourcesChanceEntry);
		maxHealthLine.getChildren().addAll(maxHealthLabel, maxHealthEntry);
		currentHealthLine.getChildren().addAll(currentHealthLabel, currentHealthEntry);
		maxEnergyLine.getChildren().addAll(maxEnergyLabel, maxEnergyEntry);
		currentEnergyLine.getChildren().addAll(currentEnergyLabel, currentEnergyEntry);
		maxComboPointsLine.getChildren().addAll(maxComboPointsLabel, maxComboPointsEntry);
		currentComboPointsLine.getChildren().addAll(currentComboPointsLabel, currentComboPointsEntry);
		
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, resourcesLine, maxHealthLine, currentHealthLine, maxEnergyLine,
				currentEnergyLine, maxComboPointsLine, currentComboPointsLine);
		
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
			effect = new BuffResources(
					Integer.parseInt(this.resourcesChanceEntry.getText()),
					Integer.parseInt(this.maxHealthEntry.getText()),
					Integer.parseInt(this.currentHealthEntry.getText()),
					Integer.parseInt(this.maxEnergyEntry.getText()),
					Integer.parseInt(this.currentEnergyEntry.getText()),
					Integer.parseInt(this.maxComboPointsEntry.getText()),
					Integer.parseInt(this.currentComboPointsEntry.getText()));
		
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