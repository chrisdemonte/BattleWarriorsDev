package guiElements;

import attacks.BuffEffect;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BuffNodeCheatingDeath extends BuffEffectNode{
	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	
	TextField CheatingDeathChanceEntry;
	
	BuffNodeCheatingDeath( BuffEffectListMaker maker) {
		super(maker.getList().size());
		maker.getList().add(null);
	}

	@Override
	public BuffEffect createBuffEffect() {
		return super.createBuffEffect();
	}

}
