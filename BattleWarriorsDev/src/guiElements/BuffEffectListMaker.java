package guiElements;

import java.util.ArrayList;

import attacks.BuffEffect;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BuffEffectListMaker {
	
	String title;
	ArrayList<BuffEffect> list;
	int chance;
	int idCounter;
	
	VBox container = new VBox(3);
	ComboBox<String> selector = new ComboBox<String>();
	Button selectorButton = new Button("+"); 
	ArrayList<BuffEffectNode> buffNodes;
	
	TextField bindChanceEntry;
	
	int cheatingDeathChance;
	boolean cheatingDeath;
	int cheatingDeathCounter;
	
	int confusionChance;
	
	int counteringChance;
	double countering;
	int counteringCounter;
	double reflecting;
	int reflectingCounter;
	
	int damageChance;
	double physicalMod;
	double magicMod;
	double bonusDamage;
	
	int enchantedChance;
	
	int fearChance;
	double fear;
	double intimidation;
	
	int freecastingChance;
	boolean freecasting;
	int freecastingCounter;
	boolean exhausted;
	int exhaustedCounter;
	
	int grabChance;

	public BuffEffectListMaker(String title) {
		super();
		this.title = title;
		list = new ArrayList<BuffEffect>();
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
