package guiElements;

import attacks.BuffCheatingDeath;
import attacks.BuffEffect;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeCheatingDeath extends BuffEffectNode{
	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	
	HBox buttonLine = new HBox(3);
	
	HBox cheatingDeathChanceLine = new HBox(3);
	TextField cheatingDeathChanceEntry = new TextField();
	Label cheatingDeathChanceLabel = new Label("Cheat Death Chance : ");
	
	HBox cheatingDeathLine = new HBox(3);
	CheckBox cheatingDeathEntry = new CheckBox();
	Label cheatingDeathLabel = new Label ("Cheating Death : ");
	
	HBox cheatingDeathCounterLine = new HBox(3);
	TextField cheatingDeathCounterEntry = new TextField("0");
	Label cheatingDeathCounterLabel = new Label ("Cheating Death Counter : ");
	
	BuffNodeCheatingDeath(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		cheatingDeathChanceLine.getChildren().addAll(cheatingDeathChanceLabel, cheatingDeathChanceEntry);
		cheatingDeathLine.getChildren().addAll(cheatingDeathLabel, cheatingDeathEntry);
		cheatingDeathCounterLine.getChildren().addAll(cheatingDeathCounterLabel, cheatingDeathCounterEntry);
		
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, cheatingDeathChanceLine, cheatingDeathLine, cheatingDeathCounterLine);
		
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
			effect = new BuffCheatingDeath(
					Integer.parseInt(this.cheatingDeathChanceEntry.getText()),
					this.cheatingDeathEntry.isSelected(),
					Integer.parseInt(this.cheatingDeathCounterEntry.getText())
					);
		
		
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
