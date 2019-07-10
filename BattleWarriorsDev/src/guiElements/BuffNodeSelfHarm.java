package guiElements;

import attacks.BuffEffect;
import attacks.BuffMindControl;
import attacks.BuffSelfHarm;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeSelfHarm extends BuffEffectNode{
	VBox container = new VBox(3);
	Button deleteButton = new Button("-");

	HBox buttonLine = new HBox(3);
	
	HBox selfHarmChanceLine = new HBox(3);
	TextField selfHarmChanceEntry = new TextField();
	Label selfHarmChanceLabel = new Label("Self Harm Chance : ");
	HBox enragedLine = new HBox(3);
	CheckBox enragedEntry = new CheckBox();
	Label enragedLabel = new Label("Enraged : ");
	HBox enragedCounterLine = new HBox(3);
	TextField enragedCounterEntry = new TextField();
	Label enragedCounterLabel = new Label("Enraged Counter : ");
	HBox selfHarmLine = new HBox(3);
	CheckBox selfHarmEntry = new CheckBox();
	Label selfHarmLabel = new Label("Self Harm  : ");
	HBox selfHarmCounterLine = new HBox(3);
	TextField selfHarmCounterEntry = new TextField();
	Label selfHarmCounterLabel = new Label("Self Harm Counter : ");
	
	
	BuffNodeSelfHarm(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		selfHarmChanceLine.getChildren().addAll(selfHarmChanceLabel, selfHarmChanceEntry);
		enragedLine.getChildren().addAll(enragedLabel, enragedEntry);
		enragedCounterLine.getChildren().addAll(enragedCounterLabel, enragedCounterEntry);
		selfHarmLine.getChildren().addAll(selfHarmLabel, selfHarmEntry);
		selfHarmChanceLine.getChildren().addAll(selfHarmCounterLabel, selfHarmCounterEntry);
		
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, selfHarmLine, enragedLine, enragedCounterLine,
				selfHarmLine, selfHarmChanceLine);
		
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
			effect = new BuffSelfHarm(
					Integer.parseInt(this.selfHarmChanceEntry.getText()),
					this.enragedEntry.isSelected(),
					Integer.parseInt(this.enragedCounterEntry.getText()),
					this.selfHarmEntry.isSelected(),
					Integer.parseInt(this.selfHarmCounterEntry.getText()));
		
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