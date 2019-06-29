package guiElements;

import java.util.ArrayList;

import attacks.BuffEffect;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class BuffEffectListMaker {
	
	String title;
	ArrayList<BuffEffect> list;
	String keyword;
	int chance;
	int idCounter;
	VBox container = new VBox(3);
	ComboBox<String> selector = new ComboBox<String>();

	public BuffEffectListMaker(String title) {
		super();
		this.title = title;
		list = new ArrayList<BuffEffect>();
		keyword = "";
		chance = 0;
		idCounter = 0;
		this.generateLayout();
	}

	private void generateLayout() {
		selector.getItems().addAll("Damage", "Healing","Stats", "SecondaryStats", "Actions", "Resources", 
				"Shields", "Protection", "Counter","Time", "Vulnerability","Self Harm", "Reach", "Attraction","Bind","Cheat Death",
				"Confusion","Enchanted", "Fear", "Freecasting", "Grab", "Keyword", "MindControl", "Weather");
		container.getChildren().add(selector);
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<BuffEffect> getList() {
		return list;
	}

	public void setList(ArrayList<BuffEffect> list) {
		this.list = list;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}

	public ComboBox getSelector() {
		return selector;
	}

	public void setSelector(ComboBox selector) {
		this.selector = selector;
	}

	public int getIdCounter() {
		return idCounter;
	}

	public void setIdCounter(int idCounter) {
		this.idCounter = idCounter;
	}
	
	
	

}
