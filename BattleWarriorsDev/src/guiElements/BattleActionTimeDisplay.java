package guiElements;

import attacks.Move;
import javafx.scene.layout.HBox;

public class BattleActionTimeDisplay {

	HBox container = new HBox(5);
	HBox priorityTabs = new HBox(5);
	HBox normalTabs = new HBox(5);
	
	public BattleActionTimeDisplay(){
		container.setMinSize(300, 25);
		container.setMaxSize(300, 30);
		container.getChildren().addAll(priorityTabs, normalTabs);
	}

	public HBox getContainer() {
		return container;
	}

	public void setContainer(HBox container) {
		this.container = container;
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
	
	
}
