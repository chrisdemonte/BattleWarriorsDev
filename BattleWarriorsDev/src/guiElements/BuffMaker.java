package guiElements;

import attacks.Buff;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffMaker {
	

	VBox container = new VBox(1);
	
	HBox nameLine = new HBox(3);
	Label nameLabel = new Label("Buff Name : ");
	TextField nameEntry = new TextField("");
	
	HBox descriptionLine = new HBox(3);
	Label descriptionLabel = new Label("Buff Description : ");
	TextField descriptionEntry = new TextField("");
	
	HBox durationLine = new HBox(3);
	Label durationLabel = new Label("Duration : ");
	TextField durationEntry = new TextField("");
	
	HBox intialChanceLine = new HBox(3);
	Label intialChanceLabel = new Label("Buff intialChance : ");
	TextField intialChanceEntry = new TextField("");
	
	HBox periodicChanceLine = new HBox(3);
	Label periodicChanceLabel = new Label("Buff periodicChance : ");
	TextField periodicChanceEntry = new TextField("");
	
	HBox keywordsLine = new HBox(3);
	Label keywordsLabel = new Label("Buff Keywords : ");
	TextField keywordsEntry = new TextField("");
	
	HBox buffEffectMakerContainer = new HBox();
	
	VBox intialContainer = new VBox(1);
	BuffEffectListMaker initialBuffMaker = new BuffEffectListMaker("Initial Effect");
	VBox periodicContainer = new VBox(1);
	BuffEffectListMaker periodicBuffMaker = new BuffEffectListMaker("Periodic Effect");
	VBox endContainer = new VBox(1);
	BuffEffectListMaker endBuffMaker = new BuffEffectListMaker("End Effect");
	
	public BuffMaker (){
		this.generateLayout();
	}

	private void generateLayout() {
		nameLine.getChildren().addAll(nameLabel, nameEntry);
		descriptionLine.getChildren().addAll(descriptionLabel, descriptionEntry);
		durationLine.getChildren().addAll(durationLabel, durationEntry);
		intialChanceLine.getChildren().addAll(intialChanceLabel, intialChanceEntry);
		periodicChanceLine.getChildren().addAll(periodicChanceLabel, periodicChanceEntry);
		keywordsLine.getChildren().addAll(keywordsLabel, keywordsEntry);
		
		intialContainer.getChildren().addAll(initialBuffMaker.getContainer());
		periodicContainer.getChildren().addAll(periodicBuffMaker.getContainer());
		endContainer.getChildren().addAll(endBuffMaker.getContainer());
		
		buffEffectMakerContainer.getChildren().addAll(intialContainer, periodicContainer, endContainer);
		
		container.getChildren().addAll(nameLine, descriptionLine, durationLine, intialChanceLine, periodicChanceLine,
				buffEffectMakerContainer);
		
	}
	
	public Buff getBuff () {
		Buff theBuff = null;
		try {
			theBuff = new Buff(
					this.nameEntry.getText(),
					this.descriptionEntry.getText(),
					this.initialBuffMaker.generateList(),
					this.periodicBuffMaker.generateList(),
					this.endBuffMaker.generateList(),
					Integer.parseInt(this.durationEntry.getText()),
					Integer.parseInt(this.intialChanceEntry.getText()),
					Integer.parseInt(this.periodicChanceEntry.getText()),
					this.keywordsEntry.getText().split(", "));
		}
		catch (Exception ex) {
			theBuff = null;
		}
		if (this.nameEntry.getText().contentEquals("")) {
			theBuff = null;
		}
		return theBuff;
	}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}

}
