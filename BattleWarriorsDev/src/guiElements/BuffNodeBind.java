package guiElements;

import attacks.BuffEffect;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BuffNodeBind extends BuffEffectNode {

	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	
	TextField BindChanceEntry;
	
	BuffNodeBind( BuffEffectListMaker maker) {
		super(maker.getList().size());
		maker.getList().add(null);
	}

	@Override
	public BuffEffect createBuffEffect() {
		return super.createBuffEffect();
	}
}
