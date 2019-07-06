package guiElements;

import attacks.BuffEffect;
import attacks.BuffLifeSteal;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeLifeSteal extends BuffEffectNode {

	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	

	HBox buttonLine = new HBox(3);
	
	HBox lifeStealLine = new HBox(3);
	TextField lifeStealChanceEntry = new TextField();
	Label lifeStealLabel = new Label("LifeSteal Chance : ");
	
	HBox percentSelfLine = new HBox(3);
	TextField percentSelfEntry = new TextField();
	Label percentSelfLabel = new Label("Percent Self : ");
	
	HBox percentTargetLine = new HBox(3);
	TextField percentTargetEntry = new TextField();
	Label percentTargetLabel = new Label("Percent Target : ");
	
	BuffNodeLifeSteal(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		lifeStealLine.getChildren().addAll(lifeStealLabel, lifeStealChanceEntry);
		percentSelfLine.getChildren().addAll(this.percentSelfLabel, this.percentSelfEntry);
		percentTargetLine.getChildren().addAll(this.percentTargetLabel, this.percentTargetEntry);
		
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, lifeStealLine, percentSelfLine, percentTargetLine);
		
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
			effect = new BuffLifeSteal(
					Integer.parseInt(this.lifeStealChanceEntry.getText()), 
					Double.parseDouble(this.percentSelfEntry.getText()),
					Double.parseDouble(this.percentTargetEntry.getText())); 
				
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
