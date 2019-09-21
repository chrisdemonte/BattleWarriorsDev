package guiElements;

import attacks.Move;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class BattleActionTimeDisplay {

	Pane container = new Pane();
	HBox container2 = new HBox();
	HBox priorityTabs = new HBox(2);
	HBox normalTabs = new HBox(2);
	
	BattleScene arena;
	
	public BattleActionTimeDisplay(BattleScene arena){
		container2.setMinSize(arena.getWidth()*.35, 10);
		container2.setMaxSize(arena.getWidth()*.35, 10);
		container2.getChildren().addAll(priorityTabs, normalTabs);
		container.setMinSize(arena.getWidth()*.35, 10);
		container.setMaxSize(arena.getWidth()*.35, 10);
		container.setBackground(new Background(new BackgroundImage(arena.getImageFactory().getImage("grey_pixel_pattern"),
			        BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			          BackgroundSize.DEFAULT)));
		container.getChildren().add(container2);
	}

	public HBox getContainer2() {
		return container2;
	}

	public void setContainer2(HBox container) {
		this.container2 = container;
	}
	public void clearTabs() {
		this.priorityTabs.getChildren().clear();
		this.normalTabs.getChildren().clear();
	}

	public HBox getPriorityTabs() {
		return priorityTabs;
	}

	public void setPriorityTabs(HBox priorityTabs) {
		this.priorityTabs = priorityTabs;
	}

	public HBox getNormalTabs() {
		return normalTabs;
	}

	public void setNormalTabs(HBox normalTabs) {
		this.normalTabs = normalTabs;
	}

	public Pane getContainer() {
		return container;
	}

	public void setContainer(Pane container) {
		this.container = container;
	}

	public BattleScene getArena() {
		return arena;
	}

	public void setArena(BattleScene arena) {
		this.arena = arena;
	}
	
	
}
