package guiElements;

import attacks.BuffCounter;
import attacks.BuffEffect;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeCounter extends BuffEffectNode{

	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	
	HBox buttonLine = new HBox(3);
	
	HBox counterChanceLine = new HBox(3);
	TextField counterChanceEntry = new TextField();
	Label counterChanceLabel = new Label("Counter Chance : ");
	
	HBox counterLine = new HBox(3);
	TextField counterEntry = new TextField("0.0");
	Label counterLabel = new Label("Counter : ");
	HBox counterCounterLine = new HBox(3);
	TextField counterCounterEntry = new TextField("0");
	Label counterCounterLabel = new Label("Counter Duration : ");
	
	HBox reflectLine = new HBox(3);
	TextField reflectEntry = new TextField("0.0");
	Label reflectLabel = new Label("Reflect : ");
	HBox reflectCounterLine = new HBox(3);
	TextField reflectCounterEntry = new TextField("0");
	Label reflectCounterLabel = new Label("Reflect Duration : ");
	
	BuffNodeCounter(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		counterChanceLine.getChildren().addAll(counterChanceLabel, counterChanceEntry);
		counterLine.getChildren().addAll(counterLabel, counterEntry);
		counterCounterLine.getChildren().addAll(counterCounterLabel, counterCounterEntry);
		reflectLine.getChildren().addAll(reflectLabel, reflectEntry);
		reflectCounterLine.getChildren().addAll(reflectCounterLabel, reflectCounterEntry);
		
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, counterChanceLine, counterLine, counterCounterLine,
				reflectLine, reflectCounterLine);
		
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
			effect = new BuffCounter(
					Integer.parseInt(this.counterChanceEntry.getText()), 
					Double.parseDouble(this.counterEntry.getText()), 
					Integer.parseInt(this.counterCounterEntry.getText()), 
					Double.parseDouble(this.reflectEntry.getText()), 
					Integer.parseInt(this.reflectCounterEntry.getText()));
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