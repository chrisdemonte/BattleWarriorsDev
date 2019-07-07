package guiElements;

import attacks.BuffEffect;
import attacks.BuffGrab;
import attacks.BuffReach;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeReach extends BuffEffectNode{
	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	

	HBox buttonLine = new HBox(3);
	
	HBox reachChanceLine = new HBox(3);
	TextField reachChanceEntry = new TextField();
	Label reachChanceLabel = new Label("Reach Chance : ");
	
	HBox reachLine = new HBox(3);
	CheckBox reachEntry = new CheckBox();
	Label reachLabel = new Label("Reach : ");
	
	HBox reachCounterLine = new HBox(3);
	TextField reachCounterEntry = new TextField();
	Label reachCounterLabel = new Label("Reach Counter : ");
	
	HBox outOfReachLine = new HBox(3);
	CheckBox outOfReachEntry = new CheckBox();
	Label outOfReachLabel = new Label("Out Of Reach : ");
	
	HBox outOfReachCounterLine = new HBox(3);
	TextField outOfReachCounterEntry = new TextField();
	Label outOfReachCounterLabel = new Label("Out Of Reach Counter : ");
	
	HBox hiddenLine = new HBox(3);
	CheckBox hiddenEntry = new CheckBox();
	Label hiddenLabel = new Label("Hidden Chance : ");
	
	HBox hiddenCounterLine = new HBox(3);
	TextField hiddenCounterEntry = new TextField();
	Label hiddenCounterLabel = new Label("Hidden Counter : ");
	
	BuffNodeReach(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		reachChanceLine.getChildren().addAll(reachChanceLabel, reachChanceEntry);
		reachLine.getChildren().addAll(reachLabel, reachEntry);
		reachCounterLine.getChildren().addAll(reachCounterLabel, reachCounterEntry);
		outOfReachLine.getChildren().addAll(outOfReachLabel, outOfReachEntry);
		outOfReachCounterLine.getChildren().addAll(outOfReachCounterLabel, outOfReachCounterEntry);
		hiddenLine.getChildren().addAll(hiddenLabel, hiddenEntry);
		hiddenCounterLine.getChildren().addAll(hiddenCounterLabel, hiddenCounterEntry);
		
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, reachChanceLine, reachLine, reachCounterLine, outOfReachLine, 
				outOfReachCounterLine, hiddenLine, hiddenCounterLine);
		
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
			effect = new BuffReach(
					Integer.parseInt(this.reachChanceEntry.getText()),
					this.reachEntry.isSelected(),
					Integer.parseInt(this.reachCounterEntry.getText()),
					this.outOfReachEntry.isSelected(),
					Integer.parseInt(this.outOfReachCounterEntry.getText()),
					this.hiddenEntry.isSelected(),
					Integer.parseInt(this.hiddenCounterEntry.getText()));
		
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