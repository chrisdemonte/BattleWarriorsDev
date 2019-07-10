package guiElements;

import attacks.BuffEffect;
import attacks.BuffGrab;
import attacks.BuffSecondaryStats;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuffNodeSecondaryStats extends BuffEffectNode{
	
	VBox container = new VBox(3);
	Button deleteButton = new Button("-");
	

	HBox buttonLine = new HBox(3);
	
	HBox secondaryStatsLine = new HBox(3);
	TextField secondaryStatsChanceEntry = new TextField();
	Label secondaryStatsLabel = new Label("Secondary Stats Chance : ");
	
	HBox damageSpikeLine = new HBox(3);
	TextField damageSpikeEntry = new TextField();
	Label damageSpikeLabel = new Label("damageSpike : ");
	HBox critLine = new HBox(3);
	TextField critEntry = new TextField();
	Label critLabel = new Label("crit : ");
	HBox critModLine = new HBox(3);
	TextField critModEntry = new TextField();
	Label critModLabel = new Label("critMod : ");
	HBox accuracyLine = new HBox(3);
	TextField accuracyEntry = new TextField();
	Label accuracyLabel = new Label("accuracy : ");
	HBox accuracyModLine = new HBox(3);
	TextField accuracyModEntry = new TextField();
	Label accuracyModLabel = new Label("accuracyMod : ");
	HBox avoidanceLine = new HBox(3);
	TextField avoidanceEntry = new TextField();
	Label avoidanceLabel = new Label("avoidance : ");
	HBox avoidanceModLine = new HBox(3);
	TextField avoidanceModEntry = new TextField();
	Label avoidanceModLabel = new Label("avoidanceMod : ");
	HBox blockingLine = new HBox(3);
	TextField blockingEntry = new TextField();
	Label blockingLabel = new Label("blocking : ");
	HBox blockingModLine = new HBox(3);
	TextField blockingModEntry = new TextField();
	Label blockingModLabel = new Label("blockingMod : ");
	HBox penetrationLine = new HBox(3);
	TextField penetrationEntry = new TextField();
	Label penetrationLabel = new Label("penetration : ");
	HBox penetrationModLine = new HBox(3);
	TextField penetrationModEntry = new TextField();
	Label penetrationModLabel = new Label("penetrationMod : ");
	
	BuffNodeSecondaryStats(BuffEffectListMaker maker) {
		super(maker.idCounter);
		maker.getList().add(null);
		maker.idCounter++;
		this.generateLayout(maker);
	}

	private void generateLayout(BuffEffectListMaker maker) {
		secondaryStatsLine.getChildren().addAll(secondaryStatsLabel, secondaryStatsChanceEntry);
		damageSpikeLine.getChildren().addAll(damageSpikeLabel, damageSpikeEntry);
		critLine.getChildren().addAll(critLabel, critEntry);
		critModLine.getChildren().addAll(critModLabel, critModEntry);
		accuracyLine.getChildren().addAll(accuracyLabel, accuracyEntry);
		accuracyModLine.getChildren().addAll(accuracyModLabel, accuracyModEntry);
		avoidanceLine.getChildren().addAll(avoidanceLabel, avoidanceEntry);
		avoidanceModLine.getChildren().addAll(avoidanceModLabel, avoidanceModEntry);
		blockingLine.getChildren().addAll(blockingLabel, blockingEntry);
		blockingModLine.getChildren().addAll(blockingModLabel, blockingModEntry);
		penetrationLine.getChildren().addAll(penetrationLabel, penetrationEntry);
		penetrationModLine.getChildren().addAll(penetrationModLabel, penetrationModEntry);
		
		buttonLine.getChildren().add(deleteButton);
		this.setDeleteButton(maker);
		
		container.getChildren().addAll(buttonLine, secondaryStatsLine, damageSpikeLine, critLine, critModLine, accuracyLine,
				accuracyModLine, avoidanceLine, avoidanceModLine, blockingLine, blockingModLine, penetrationLine, penetrationModLine);
		
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
			effect = new BuffSecondaryStats(
					Integer.parseInt(this.secondaryStatsChanceEntry.getText()),
					Integer.parseInt(this.damageSpikeEntry.getText()),
					Double.parseDouble(this.critEntry.getText()),
					Double.parseDouble(this.critModEntry.getText()),
					Double.parseDouble(this.accuracyEntry.getText()),
					Double.parseDouble(this.accuracyModEntry.getText()),
					Double.parseDouble(this.avoidanceEntry.getText()),
					Double.parseDouble(this.avoidanceModEntry.getText()),
					Double.parseDouble(this.blockingEntry.getText()),
					Double.parseDouble(this.blockingModEntry.getText()),
					Double.parseDouble(this.penetrationEntry.getText()),
					Double.parseDouble(this.penetrationModEntry.getText()));
		
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