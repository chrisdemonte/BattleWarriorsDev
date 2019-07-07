package guiElements;

import attacks.BuffEffect;
import attacks.BuffFear;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeFear extends BuffEffectNode{
	
	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	

	HBox buttonLine = new HBox(3);
	
	HBox fearChanceLine = new HBox(3);
	TextField fearChanceEntry = new TextField("100");
	Label fearChanceLabel = new Label("Fear Chance : ");

	TextField fearEntry = new TextField("0");
	TextField intimidationEntry = new TextField("0");

	Label fearLabel= new Label("Fear : ");
	Label intimidationLabel= new Label("Intimidation : ");
	
	HBox fearLine= new HBox(3);
	HBox intimidationLine= new HBox(3);
	
	
	BuffNodeFear(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		fearChanceLine.getChildren().addAll(fearChanceLabel, fearChanceEntry);
		fearLine.getChildren().addAll(fearLabel, fearEntry);
		intimidationLine.getChildren().addAll(intimidationLabel, intimidationEntry);
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, fearChanceLine, fearLine, intimidationLine);
		
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
			effect = new BuffFear(
					Integer.parseInt(this.fearChanceEntry.getText()), 
					Integer.parseInt(this.fearEntry.getText()),
					Integer.parseInt(this.intimidationEntry.getText())); 
				
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