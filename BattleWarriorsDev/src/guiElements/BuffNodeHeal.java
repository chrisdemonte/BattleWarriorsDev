package guiElements;

import attacks.BuffEffect;
import attacks.BuffHeal;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeHeal extends BuffEffectNode{
	
	VBox container = new VBox();
	Button deleteButton = new Button("-");
	
	TextField healChanceEntry= new TextField("100.0");
	TextField physicalModEntry= new TextField("0");
	TextField magicModEntry= new TextField("0");
	TextField bonusDamageEntry= new TextField("0");
	
	Label healChanceLabel = new Label("Heal Chance :");
	Label physicalModLabel= new Label("Physical Mod :");
	Label magicModLabel= new Label("Magic Mod :");
	Label bonusDamageLabel= new Label("Bonus Healing : ");
	
	HBox healChanceLine = new HBox(3);
	HBox physicalModLine= new HBox(3);
	HBox magicModLine= new HBox(3);
	HBox bonusDamageLine= new HBox(3);
	
	BuffNodeHeal(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		healChanceLine.getChildren().addAll(healChanceLabel, healChanceEntry);
		physicalModLine.getChildren().addAll(physicalModLabel, physicalModEntry);
		magicModLine.getChildren().addAll(magicModLabel, magicModEntry);
		bonusDamageLine.getChildren().addAll(bonusDamageLabel, bonusDamageEntry);
		
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(deleteButton, healChanceLine, physicalModLine, magicModLine,bonusDamageLine);
		
	}

	private void setDeleteButton(BuffEffectListMaker maker) {
		
		this.deleteButton.setOnAction(e->{
			int temp = this.id;
			if (maker.getList().size() == 1) {
				maker.getList().remove(0);
				maker.getContainer().getChildren().remove(2);
				maker.idCounter--;
				return;
			}
			else if (temp < maker.idCounter - 1) {
				for (int i = temp; i < maker.idCounter; i++) {
					maker.getBuffNodes().get(i).setId(i - 1);
				}
			
			}
			maker.getList().remove(temp);
			maker.getContainer().getChildren().remove(temp + 2);
			maker.idCounter--;
			
		});
		
	}
	@Override
	public BuffEffect createBuffEffect() {

		BuffEffect effect;
		try{
			effect = new BuffHeal(
					Integer.parseInt(this.healChanceEntry.getText()), 
					Double.parseDouble(this.physicalModEntry.getText()), 
					Double.parseDouble(this.magicModEntry.getText()), 
					Double.parseDouble(this.bonusDamageEntry.getText())); 
		}
		catch (Exception ex) {
			effect = null;
		}
		return effect;
	}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}
	
	

}
