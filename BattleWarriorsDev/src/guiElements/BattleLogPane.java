package guiElements;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import utilities.BattleLog;

public class BattleLogPane {
	
	VBox container = new VBox();
	TextArea display = new TextArea();
	
	int width;
	int height;
	BattleScene arena;
	
	public BattleLogPane (int width, int height, BattleScene arena ){
		this.width = width;
		this.height = height;
		this.arena = arena;
		this.generateLayout();
	}

	private void generateLayout() {
		container.setMaxSize((width / 3) + 20, height - 600);
		container.setMinSize((width / 3) + 20, height - 600);
		container.setPadding(new Insets(10, 0 , 0, 10));
		
		display.setMaxSize((width / 3), height - 573);
		display.setMinSize((width / 3), height - 573);	
		display.setWrapText(true);
		display.setFont(arena.getRoot().getSettings().getSmallFont());
		
		container.getChildren().addAll(display);
	}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}
	public void updateLog(BattleLog log) {
		String str = new String();
		for (int i = log.getLog().size() - 1; i >= 0; i--) {
			str += ("\n" + log.getLog().get(i));
		}
		display.setText(str);
	}

}
