package guiElements;

import attacks.BuffEffect;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BuffNodeActions extends BuffEffectNode{
	
	TextField actionsChanceEntry;
	CheckBox canAttackEntry;
	TextField canAttackCounterEntry;
	CheckBox canUseItemsEntry;
	TextField canUseItemsCounterEntry;
	CheckBox canSkipTurnEntry;
	TextField canSkipTurnCounterEntry;
	CheckBox canRunEntry;
	TextField canRunCounterEntry;
	CheckBox lockedEntry;
	TextField lockedCounterEntry;
	
	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	
	BuffNodeActions(int id) {
		super(id);
	}

	@Override
	public BuffEffect createBuffEffect() {
		return super.createBuffEffect();
	}

	
}
