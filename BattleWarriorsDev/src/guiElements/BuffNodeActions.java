package guiElements;

import attacks.BuffEffect;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeActions extends BuffEffectNode{
	
	TextField actionsChanceEntry = new TextField("0");
	CheckBox canAttackEntry = new CheckBox();
	TextField canAttackCounterEntry = new TextField("0");
	CheckBox canUseItemsEntry = new CheckBox();
	TextField canUseItemsCounterEntry = new TextField("0");
	CheckBox canSkipTurnEntry = new CheckBox();
	TextField canSkipTurnCounterEntry = new TextField("0");
	CheckBox canRunEntry = new CheckBox();
	TextField canRunCounterEntry = new TextField("0");
	CheckBox lockedEntry = new CheckBox();
	TextField lockedCounterEntry = new TextField("0");
	
	Label actionsChanceLabel= new Label("Chance : ");
	Label canAttackLabel= new Label("Can Attack : ");
	Label canAttackCounterLabel= new Label("Duration : ");
	Label canUseItemsLabel= new Label("Can Use Items : ");
	Label canUseItemsCounterLabel= new Label("Duration : ");
	Label canSkipTurnLabel= new Label("Can Skip Turn : ");
	Label canSkipTurnCounterLabel= new Label("Duration : ");
	Label canRunLabel= new Label("Can Run : ");
	Label canRunCounterLabel= new Label("Duration : ");
	Label lockedLabel= new Label("Locked : ");
	Label lockedCounterLabel= new Label("Duration : ");
	
	HBox actionsChanceLine= new HBox(3);
	HBox canAttackLine= new HBox(3);
	HBox canAttackCounterLine= new HBox(3);
	HBox canUseItemsLine= new HBox(3);
	HBox canUseItemsCounterLine= new HBox(3);
	HBox canSkipTurnLine= new HBox(3);
	HBox canSkipTurnCounterLine= new HBox(3);
	HBox canRunLine= new HBox(3);
	HBox canRunCounterLine= new HBox(3);
	HBox lockedLine= new HBox(3);
	HBox lockedCounterLine= new HBox(3);
	
	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	HBox buttonLine = new HBox(3);
	

	public BuffNodeActions( BuffEffectListMaker maker) {
		super(maker.getList().size());
		maker.getList().add(null);
		this.generateLayout(maker);
	}



	private void generateLayout( BuffEffectListMaker maker) {
		
		actionsChanceLine.getChildren().addAll(actionsChanceLabel, actionsChanceEntry);
		canAttackLine.getChildren().addAll(canAttackLabel, canAttackEntry);
		canAttackCounterLine.getChildren().addAll(canAttackCounterLabel, canAttackCounterEntry);
		canUseItemsLine.getChildren().addAll(canUseItemsLabel, canUseItemsEntry);
		canUseItemsCounterLine.getChildren().addAll(canUseItemsCounterLabel, canUseItemsCounterEntry);
		canSkipTurnLine.getChildren().addAll(canSkipTurnLabel, canSkipTurnEntry);
		canSkipTurnCounterLine.getChildren().addAll(canSkipTurnCounterLabel, canSkipTurnCounterEntry);
		canRunLine.getChildren().addAll(canRunLabel, canRunEntry);
		canRunCounterLine.getChildren().addAll(canRunCounterLabel, canRunCounterEntry);
		lockedLine.getChildren().addAll(lockedLabel, lockedEntry);
		lockedCounterLine.getChildren().addAll(lockedCounterLabel, lockedCounterEntry);
		
		buttonLine.getChildren().addAll(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, this.actionsChanceLine, this.canAttackLine, this.canAttackCounterLine,
				this.canUseItemsLine, this.canUseItemsCounterLine, this.canSkipTurnLine, this.canSkipTurnCounterLine,
				this.canRunLine, this.canRunCounterLine, this.lockedLine, this.lockedCounterLine);
		
	}
	private void setDeleteButton( BuffEffectListMaker maker) {
		
		this.deleteButton.setOnAction(e->{
			int temp = this.id;
			if (temp < maker.idCounter - 1) {
				for (int i = temp; i < maker.idCounter; i++) {
					maker.getBuffNodes().get(i).setId(i - 1);
				}
			}
			maker.getList().remove(temp);
			maker.getContainer().getChildren().remove(temp + 1);
			
		});
		
	}

	@Override
	public BuffEffect createBuffEffect() {
		return super.createBuffEffect();
	}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}

	
}
