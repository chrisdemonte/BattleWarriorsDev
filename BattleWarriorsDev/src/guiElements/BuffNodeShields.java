package guiElements;

import attacks.BuffEffect;
import attacks.BuffRemoveSelfBuff;
import attacks.BuffShields;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeShields extends BuffEffectNode{

	VBox container = new VBox(3);
	Button deleteButton = new Button("-");

	HBox buttonLine = new HBox(3);
	
	HBox shieldsChanceLine = new HBox(3);
	TextField shieldsChanceEntry = new TextField();
	Label shieldsChanceLabel = new Label("shields Chance : ");
	HBox shieldsLine = new HBox(3);
	TextField shieldsEntry = new TextField();
	Label shieldsLabel = new Label("Barrier : ");
	HBox shieldsCounterLine = new HBox(3);
	TextField shieldsCounterEntry = new TextField();
	Label shieldsCounterLabel = new Label("Barrier Counter : ");
	HBox physicalShieldLine = new HBox(3);
	TextField physicalShieldEntry = new TextField();
	Label physicalShieldLabel = new Label("Physical Shield : ");
	HBox physicalShieldCounterLine = new HBox(3);
	TextField physicalShieldCounterEntry = new TextField();
	Label physicalShieldCounterLabel = new Label("Physical Shield Counter : ");
	HBox magicShieldLine = new HBox(3);
	TextField magicShieldEntry = new TextField();
	Label magicShieldLabel = new Label("Magic Shield : ");
	HBox magicShieldCounterLine = new HBox(3);
	TextField magicShieldCounterEntry = new TextField();
	Label magicShieldCounterLabel = new Label("Magic Shield Counter : ");
	
	
	BuffNodeShields(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		shieldsChanceLine.getChildren().addAll(shieldsChanceLabel, shieldsChanceEntry);
		shieldsLine.getChildren().addAll(shieldsLabel, shieldsEntry);
		shieldsCounterLine.getChildren().addAll(shieldsCounterLabel, shieldsCounterEntry);
		physicalShieldLine.getChildren().addAll(physicalShieldLabel, physicalShieldEntry);
		physicalShieldCounterLine.getChildren().addAll(physicalShieldCounterLabel, physicalShieldCounterEntry);
		magicShieldLine.getChildren().addAll(magicShieldLabel, magicShieldEntry);
		magicShieldCounterLine.getChildren().addAll(magicShieldCounterLabel, magicShieldCounterEntry);
		
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, shieldsChanceLine, shieldsLine, shieldsCounterLine,
				physicalShieldLine, physicalShieldCounterLine, magicShieldLine, magicShieldCounterLine);
		
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
			effect = new BuffShields(
					Integer.parseInt(this.shieldsChanceEntry.getText()),
					Double.parseDouble(this.shieldsEntry.getText()), 
					Integer.parseInt(this.shieldsCounterEntry.getText()),
					Double.parseDouble(this.physicalShieldEntry.getText()),
					Integer.parseInt(this.physicalShieldCounterEntry.getText()),
					Double.parseDouble(this.magicShieldEntry.getText()),
					Integer.parseInt(this.magicShieldCounterEntry.getText()));
		
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