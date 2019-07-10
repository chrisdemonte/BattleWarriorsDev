package guiElements;

import attacks.BuffEffect;
import attacks.BuffRemoveSelfBuff;
import attacks.BuffSecondaryStats;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeSelfRemoval extends BuffEffectNode{
	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	

	HBox buttonLine = new HBox(3);
	
	HBox selfRemovalLine = new HBox(3);
	TextField selfRemovalChanceEntry = new TextField();
	Label selfRemovalLabel = new Label("selfRemoval Chance : ");
	HBox keywordsLine = new HBox(3);
	TextField keywordsEntry = new TextField();
	Label keywordsLabel = new Label("Keywords : ");
	
	BuffNodeSelfRemoval(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		selfRemovalLine.getChildren().addAll(selfRemovalLabel, selfRemovalChanceEntry);
		keywordsLine.getChildren().addAll(keywordsLabel, keywordsEntry);
		
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, selfRemovalLine, keywordsLine);
		
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
					maker.getBuffNodes().get(i).setId(i-1);
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
			effect = new BuffRemoveSelfBuff(
					Integer.parseInt(this.selfRemovalChanceEntry.getText()),
					this.keywordsEntry.getText().split(", "));
		
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