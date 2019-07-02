package guiElements;

import attacks.BuffEffect;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BuffNodeEnchanted extends BuffEffectNode {
	
	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	
	TextField enchantedChanceEntry;
	
	BuffNodeEnchanted(int id) {
		super(id);
	}

	@Override
	public BuffEffect createBuffEffect() {
		return super.createBuffEffect();
	}

}
