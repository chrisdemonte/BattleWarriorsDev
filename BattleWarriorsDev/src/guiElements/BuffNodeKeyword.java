package guiElements;

import attacks.BuffEffect;
import attacks.BuffKeyword;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeKeyword extends BuffEffectNode {

	
	VBox container = new VBox();
	Button deleteButton = new Button("-");
	HBox buttonLine = new HBox(3);
	
	HBox keywordChanceLine = new HBox(3);
	TextField keywordChanceEntry = new TextField();
	Label keywordChanceLabel = new Label("Keyword Chance : ");
	
	HBox selfKeywordLine = new HBox(3);
	TextField selfKeywordEntry = new TextField();
	Label selfKeywordLabel = new Label("Self Keyword : ");
	
	HBox selfKeywordCounterLine = new HBox(3);
	TextField selfKeywordCounterEntry = new TextField();
	Label selfKeywordCounterLabel = new Label("Self Keyword Counter : ");
	
	HBox targetKeywordLine = new HBox(3);
	TextField targetKeywordEntry = new TextField();
	Label targetKeywordLabel = new Label("Target Keyword : ");
	
	HBox targetKeywordCounterLine = new HBox(3);
	TextField targetKeywordCounterEntry = new TextField();
	Label targetKeywordCounterLabel = new Label("Target Keyword Counter : ");
	
	BuffNodeKeyword(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		keywordChanceLine.getChildren().addAll(keywordChanceLabel, keywordChanceEntry);
		this.selfKeywordLine.getChildren().addAll(this.selfKeywordLabel, this.selfKeywordEntry);
		this.selfKeywordCounterLine.getChildren().addAll(this.selfKeywordCounterLabel, this.selfKeywordCounterEntry);
		this.targetKeywordLine.getChildren().addAll(this.targetKeywordLabel, this.targetKeywordEntry);
		this.targetKeywordCounterLine.getChildren().addAll(this.targetKeywordCounterLabel, this.targetKeywordCounterEntry);
		
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, keywordChanceLine, selfKeywordLine, selfKeywordCounterLine, 
				targetKeywordLine, targetKeywordCounterLine);
		
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
			effect = new BuffKeyword(
					Integer.parseInt(this.keywordChanceEntry.getText()),
					this.selfKeywordEntry.getText(),
					Integer.parseInt(this.selfKeywordCounterEntry.getText()),
					this.targetKeywordEntry.getText(),
					Integer.parseInt(this.targetKeywordCounterEntry.getText()));
		
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
