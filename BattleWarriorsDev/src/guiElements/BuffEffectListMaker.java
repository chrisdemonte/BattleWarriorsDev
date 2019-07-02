package guiElements;

import java.util.ArrayList;

import attacks.BuffEffect;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffEffectListMaker {
	
	String title;
	ArrayList<BuffEffect> list;
	int chance;
	int idCounter;
	
	VBox container = new VBox(3);
	HBox topRow = new HBox(3);
	ComboBox<String> selector = new ComboBox<String>();
	Button selectorButton = new Button("+"); 
	ArrayList<BuffEffectNode> buffNodes;

	public BuffEffectListMaker(String title) {
		super();
		this.title = title;
		list = new ArrayList<BuffEffect>();
		buffNodes = new ArrayList<BuffEffectNode>();
		chance = 0;
		idCounter = 0;
		this.generateLayout();
	}

	private void generateLayout() {
		selector.getItems().addAll("Damage", "Healing","Stats", "SecondaryStats", "Actions", "Resources", 
				"Shields", "Protection", "Counter","Time", "Vulnerability","Self Harm", "Reach", "Attraction","Bind","Cheat Death",
				"Confusion","Enchanted", "Fear", "Freecasting", "Grab", "Life Steal", "MindControl","Remove Self Buff", "Remove Target Buff", "Weather");
		
		topRow.getChildren().addAll(selector, selectorButton);
		this.setSelectorButton();
		container.getChildren().add(topRow);
		
	}

	private void setSelectorButton() {
		this.selectorButton.setOnAction(e->{
			String selection = selector.getValue();
			if (selection != null) {
				if (selection.contentEquals("Actions")) {
					BuffNodeActions temp = new BuffNodeActions(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Attraction")) {
					BuffNodeAttraction temp = new BuffNodeAttraction(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Damage")) {
					BuffNodeDamage temp = new BuffNodeDamage(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Healing")) {
					BuffNodeHeal temp = new BuffNodeHeal(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Bind")) {
					BuffNodeBind temp = new BuffNodeBind(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Cheat Death")) {
					BuffNodeCheatingDeath temp = new BuffNodeCheatingDeath(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Confusion")) {
					BuffNodeConfusion temp = new BuffNodeConfusion(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
			}
		});
		
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

	public HBox getTopRow() {
		return topRow;
	}

	public void setTopRow(HBox topRow) {
		this.topRow = topRow;
	}

	public Button getSelectorButton() {
		return selectorButton;
	}

	public void setSelectorButton(Button selectorButton) {
		this.selectorButton = selectorButton;
	}

	public ArrayList<BuffEffectNode> getBuffNodes() {
		return buffNodes;
	}

	public void setBuffNodes(ArrayList<BuffEffectNode> buffNodes) {
		this.buffNodes = buffNodes;
	}



	
	

}
