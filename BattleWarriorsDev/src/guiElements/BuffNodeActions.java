package guiElements;

import attacks.BuffActions;
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
	
	VBox container = new VBox();
	Button deleteButton = new Button("-");
	HBox buttonLine = new HBox(3);
	

	public BuffNodeActions( BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}
	public BuffNodeActions (BuffEffectListMaker maker, BuffActions buff) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateContainer(maker, buff);
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
		
		canAttackEntry.setSelected(true);
		canUseItemsEntry.setSelected(true);
		canSkipTurnEntry.setSelected(true);
		canRunEntry.setSelected(true);
		lockedEntry.setSelected(false);
		
		buttonLine.getChildren().addAll(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, this.actionsChanceLine, this.canAttackLine, this.canAttackCounterLine,
				this.canUseItemsLine, this.canUseItemsCounterLine, this.canSkipTurnLine, this.canSkipTurnCounterLine,
				this.canRunLine, this.canRunCounterLine, this.lockedLine, this.lockedCounterLine);
		
	}
	public void generateContainer(BuffEffectListMaker maker, BuffActions buff) {
		
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
		
		actionsChanceEntry.setText("" + buff.getChance());
		canAttackEntry.setSelected(buff.isCanAttack());
		canAttackCounterEntry.setText("" + buff.getCanAttackCounter());
		canUseItemsEntry.setSelected(buff.isCanUseItems());
		canUseItemsCounterEntry.setText("" + buff.getCanUseItemsCounter());
		canSkipTurnEntry.setSelected(buff.isCanSkipTurn());
		canSkipTurnCounterEntry.setText("" + buff.getCanSkipTurnCounter());
		canRunEntry.setSelected(buff.isCanRun());
		canRunCounterEntry.setText("" + buff.getCanRunCounter());
		lockedEntry.setSelected(buff.isLocked());
		lockedCounterEntry.setText("" + buff.getLockedCounter());
		
		buttonLine.getChildren().addAll(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, this.actionsChanceLine, this.canAttackLine, this.canAttackCounterLine,
				this.canUseItemsLine, this.canUseItemsCounterLine, this.canSkipTurnLine, this.canSkipTurnCounterLine,
				this.canRunLine, this.canRunCounterLine, this.lockedLine, this.lockedCounterLine);
		
	}
	private void setDeleteButton( BuffEffectListMaker maker) {
		
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
			effect = new BuffActions(
					Integer.parseInt(this.actionsChanceEntry.getText()), 
					this.canAttackEntry.isSelected(), 
					Integer.parseInt(this.canAttackCounterEntry.getText()), 
					this.canUseItemsEntry.isSelected(),
					Integer.parseInt(this.canUseItemsCounterEntry.getText()), 
					this.canSkipTurnEntry.isSelected(), 
					Integer.parseInt(this.canSkipTurnCounterEntry.getText()), 
					this.canRunEntry.isSelected(),
					Integer.parseInt(this.canRunEntry.getText()), 
					this.lockedEntry.isSelected(),
					Integer.parseInt(this.lockedCounterEntry.getText()));
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
