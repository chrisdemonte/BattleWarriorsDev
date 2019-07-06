package guiElements;

import attacks.BuffActions;
import attacks.BuffDamage;
import attacks.BuffEffect;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeDamage extends BuffEffectNode{
	
	VBox container = new VBox();
	Button deleteButton = new Button("-");
	
	TextField DamageChanceEntry = new TextField("100.0");
	TextField physicalModEntry= new TextField("0");
	TextField magicModEntry= new TextField("0");
	TextField bonusDamageEntry= new TextField("0");
	
	Label DamageChanceLabel = new Label("Damage Chance : ");
	Label physicalModLabel= new Label("Physical Mod : ");
	Label magicModLabel= new Label("Magic Mod : ");
	Label bonusDamageLabel= new Label("Bonus Damage : ");
	
	HBox DamageChanceLine = new HBox(3);
	HBox physicalModLine= new HBox(3);
	HBox magicModLine= new HBox(3);
	HBox bonusDamageLine= new HBox(3);
	
	BuffNodeDamage(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		DamageChanceLine.getChildren().addAll(DamageChanceLabel, DamageChanceEntry);
		physicalModLine.getChildren().addAll(physicalModLabel, physicalModEntry);
		magicModLine.getChildren().addAll(magicModLabel, magicModEntry);
		bonusDamageLine.getChildren().addAll(bonusDamageLabel, bonusDamageEntry);
		
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(deleteButton, DamageChanceLine, physicalModLine, magicModLine,bonusDamageLine);
		
	}

	private void setDeleteButton(BuffEffectListMaker maker) {
		
		this.deleteButton.setOnAction(e->{
			int temp = this.id;
			if (maker.getList().size() == 1) {
				maker.getList().remove(0);
				maker.getContainer().getChildren().remove(1);
				maker.idCounter--;
				return;
			}
			else if (temp < maker.idCounter - 1) {
				for (int i = temp; i < maker.idCounter; i++) {
					maker.getBuffNodes().get(i).setId(i - 1);
				}
			}
			maker.getList().remove(temp);
			maker.getContainer().getChildren().remove(temp + 1);
			maker.idCounter--;
			
		});
		
	}

	@Override
	public BuffEffect createBuffEffect() {

		BuffEffect effect;
		try{
			effect = new BuffDamage(
					Integer.parseInt(this.DamageChanceEntry.getText()), 
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
