package guiElements;

import attacks.BuffEffect;
import attacks.BuffRemoveTargetBuff;
import attacks.BuffTime;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeTime extends BuffEffectNode{
	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	

	HBox buttonLine = new HBox(3);
	
	HBox timeChanceLine = new HBox(3);
	TextField timeChanceEntry = new TextField();
	Label timeChanceLabel = new Label("Time Chance : ");
	HBox actionTimeLine = new HBox(3);
	TextField actionTimeEntry = new TextField();
	Label actionTimeLabel = new Label("Action Time : ");
	HBox dazeLine = new HBox(3);
	TextField dazeEntry = new TextField();
	Label dazeLabel = new Label("Daze : ");
	HBox hasteLine = new HBox(3);
	TextField hasteEntry = new TextField();
	Label hasteLabel = new Label("Haste : ");
	
	BuffNodeTime(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		timeChanceLine.getChildren().addAll(timeChanceLabel, timeChanceEntry);
		actionTimeLine.getChildren().addAll(actionTimeLabel, actionTimeEntry);
		dazeLine.getChildren().addAll(dazeLabel, dazeEntry);
		hasteLine.getChildren().addAll(hasteLabel, hasteEntry);
		
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, timeChanceLine, actionTimeLine, dazeLine, 
				hasteLine);
		
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
			effect = new BuffTime(
					Integer.parseInt(this.timeChanceEntry.getText()),
					Integer.parseInt(this.actionTimeEntry.getText()),
					Integer.parseInt(this.dazeEntry.getText()),
					Integer.parseInt(this.hasteEntry.getText()));
		
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