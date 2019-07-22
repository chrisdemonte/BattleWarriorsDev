package guiElements;

import attacks.Move;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BattleSelectionTab {
	
	VBox container = new VBox(1);
	
	HBox row1 = new HBox(3);
	Label nameLabel = new Label();
	HBox row2 = new HBox(3);
	Label infoLabel = new Label();
	Tooltip toolTip = new Tooltip();
	
	Move attack = null;
	
	public BattleSelectionTab() {
		nameLabel.setText("Name");
		nameLabel.setTooltip(toolTip);
		nameLabel.setMinSize(120, 20);
		nameLabel.setAlignment(Pos.TOP_LEFT);
		infoLabel.setText("Info\tInfo");
		infoLabel.setTooltip(toolTip);
		infoLabel.setMinSize(120, 20);
		infoLabel.setAlignment(Pos.BOTTOM_RIGHT);
		toolTip.setText("Description");
		row1.getChildren().addAll(nameLabel);
		row2.getChildren().addAll(infoLabel);
		container.getChildren().addAll(row1, row2);
	}
	public BattleSelectionTab(Move attack, BattleScene arena) {
		this.attack = attack;
		nameLabel.setText(attack.getName());
		nameLabel.setTooltip(toolTip);
		nameLabel.setMinSize(120, 20);
		nameLabel.setAlignment(Pos.TOP_LEFT);
		if (attack.getCooldownCounter() > 0) {
			infoLabel.setText("Cooldown:\t" + attack.getCooldownCounter() + " turns\tUses\t" + attack.getCurrentUses() + "/" + attack.getUses());
		}
		else {
			infoLabel.setText("Uses:\t" + attack.getCurrentUses() + "/" + attack.getUses());
		}
		infoLabel.setTooltip(toolTip);
		infoLabel.setMinSize(120, 20);
		infoLabel.setAlignment(Pos.BOTTOM_RIGHT);
		row1.getChildren().addAll(nameLabel);
		row2.getChildren().addAll(infoLabel);
		toolTip.setText(attack.getDescription());
		container.getChildren().addAll(row1, row2);
	}


	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}

	public Label getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(Label nameLabel) {
		this.nameLabel = nameLabel;
	}
	public Move getAttack() {
		return attack;
	}
	public void setAttack(Move attack) {
		this.attack = attack;
	}
	
	
	
}
