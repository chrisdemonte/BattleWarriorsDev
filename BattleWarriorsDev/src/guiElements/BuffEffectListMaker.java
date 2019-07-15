package guiElements;

import java.util.ArrayList;

import attacks.BuffEffect;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
		selector.getItems().addAll("Damage", "Healing","Stats", "Secondary Stats", "Actions", "Resources", 
				"Shields", "Protection", "Counter","Time", "Vulnerability","Self Harm", "Reach", "Attraction","Bind","Cheat Death",
				"Confusion","Enchanted", "Fear", "Freecasting", "Grab", "Life Steal", "Mind Control","Remove Self Buff", "Remove Target Buff");
		
		topRow.getChildren().addAll(selector, selectorButton);
		this.setSelectorButton();
		container.getChildren().addAll(new Label(this.title), topRow);
		
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
				else if (selection.contentEquals("Counter")) {
					BuffNodeCounter temp = new BuffNodeCounter(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Enchanted")) {
					BuffNodeEnchanted temp = new BuffNodeEnchanted(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Fear")) {
					BuffNodeFear temp = new BuffNodeFear(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Freecasting")) {
					BuffNodeFreecasting temp = new BuffNodeFreecasting(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Grab")) {
					BuffNodeGrab temp = new BuffNodeGrab(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Life Steal")) {
					BuffNodeLifeSteal temp = new BuffNodeLifeSteal(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Mind Control")) {
					BuffNodeMindControl temp = new BuffNodeMindControl(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Protection")) {
					BuffNodeProtection temp = new BuffNodeProtection(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Reach")) {
					BuffNodeReach temp = new BuffNodeReach(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Resources")) {
					BuffNodeResources temp = new BuffNodeResources(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Secondary Stats")) {
					BuffNodeSecondaryStats temp = new BuffNodeSecondaryStats(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Self Harm")) {
					BuffNodeSelfHarm temp = new BuffNodeSelfHarm(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Remove Self Buff")) {
					BuffNodeSelfRemoval temp = new BuffNodeSelfRemoval(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Shields")) {
					BuffNodeShields temp = new BuffNodeShields(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Stats")) {
					BuffNodeStatus temp = new BuffNodeStatus(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Remove Target Buff")) {
					BuffNodeTargetRemoval temp = new BuffNodeTargetRemoval(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Time")) {
					BuffNodeTime temp = new BuffNodeTime(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Vulnerability")) {
					BuffNodeVulnerability temp = new BuffNodeVulnerability(this);
					this.buffNodes.add(temp);
					this.container.getChildren().add(temp.getContainer());
				}
				else if (selection.contentEquals("Weather")) {
					BuffNodeWeather temp = new BuffNodeWeather(this);
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
		list.clear();
		for (int i = 0; i < buffNodes.size(); i++) {
			if (buffNodes.get(i).createBuffEffect() != null) {
				list.add(buffNodes.get(i).createBuffEffect());
			}
		}
		if (list.size() == 0) {
			return null;
		}
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
