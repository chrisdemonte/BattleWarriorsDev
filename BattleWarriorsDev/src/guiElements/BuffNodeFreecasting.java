package guiElements;

import attacks.BuffEffect;
import attacks.BuffFreecasting;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeFreecasting extends BuffEffectNode{
	
	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	

	HBox buttonLine = new HBox(3);
	
	HBox freecastingChanceLine = new HBox(3);
	TextField freecastingChanceEntry = new TextField();
	Label freecastingChanceLabel = new Label("Freecasting Chance : ");
	
	HBox freecastingLine = new HBox(3);
	CheckBox freecastingEntry = new CheckBox();
	Label freecastingLabel = new Label ("Freecasting : ");
	
	HBox freecastingCounterLine = new HBox(3);
	TextField freecastingCounterEntry = new TextField("0");
	Label freecastingCounterLabel = new Label ("Freecasting Counter : ");
	
	HBox exhaustedLine = new HBox(3);
	CheckBox exhaustedEntry = new CheckBox();
	Label exhaustedLabel = new Label ("Exhausted : ");
	
	HBox exhaustedCounterLine = new HBox(3);
	TextField exhaustedCounterEntry = new TextField("0");
	Label exhaustedCounterLabel = new Label ("Exhausted Counter : ");
	
	BuffNodeFreecasting(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		freecastingChanceLine.getChildren().addAll(freecastingChanceLabel, freecastingChanceEntry);
		freecastingLine.getChildren().addAll(freecastingLabel, freecastingEntry);
		freecastingCounterLine.getChildren().addAll(freecastingCounterLabel, freecastingCounterEntry);
		exhaustedLine.getChildren().addAll(exhaustedLabel, exhaustedEntry);
		exhaustedCounterLine.getChildren().addAll(exhaustedCounterLabel, exhaustedCounterEntry);
		
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, freecastingChanceLine, freecastingLine, freecastingCounterLine,
				exhaustedLine, exhaustedCounterLine);
		
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
			effect = new BuffFreecasting(
					Integer.parseInt(this.freecastingChanceEntry.getText()),
					this.freecastingEntry.isSelected(),
					Integer.parseInt(this.freecastingCounterEntry.getText()),
					this.exhaustedEntry.isSelected(),
					Integer.parseInt(this.exhaustedCounterEntry.getText()));
		
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