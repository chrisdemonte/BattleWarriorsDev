package guiElements;

import BattleAnimation.BattleAnimation;
import BattleAnimation.BattleFlipAnimation;
import BattleAnimation.BattleFlippingLeapAnimation;
import BattleAnimation.BattleLeapingAnimation;
import BattleAnimation.BattleNoAnimation;
import BattleAnimation.BattleSlidingAnimation;
import attacks.Move;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AttackMakerAnimationMaker {

	VBox container = new VBox(3);
	Label comboBoxLabel = new Label ("Animation Choices:");
	ComboBox<String> comboBox = new ComboBox<String>();
	VBox animationNodeContainer = new VBox();
	
	
	public AttackMakerAnimationMaker () {
		this.generateLayout();
	}

	private void generateLayout() {
		comboBox.getItems().addAll("None", "Sliding Animation", "Leaping Animation", "Flip Animation", "Flipping Leap Animation");
		comboBox.setValue("None");
		this.setComboBoxAction();
		container.getChildren().addAll(comboBoxLabel, comboBox);
		
	}
	private void setComboBoxAction () {
		comboBox.setOnAction(e->{
			if (comboBox.getValue().contentEquals("None")) {
				
			}
			else if (comboBox.getValue().contentEquals("Sliding Animation")) {
				
			}
		});
	}
	public BattleAnimation generateAnimation (Move attack) {
		BattleAnimation animation = null; 
		if (comboBox.getValue().contentEquals("None")) {
			animation = new BattleNoAnimation(attack);
		}
		else if (comboBox.getValue().contentEquals("Sliding Animation")) {
			animation = new BattleSlidingAnimation(attack);
		}
		else if (comboBox.getValue().contentEquals("Leaping Animation")) {
			animation = new BattleLeapingAnimation(attack);
		}
		else if (comboBox.getValue().contentEquals("Flip Animation")) {
			animation = new BattleFlipAnimation(attack);
		}
		else if (comboBox.getValue().contentEquals("Flipping Leap Animation")) {
			animation = new BattleFlippingLeapAnimation(attack);
		}
		return animation;
	}

	public VBox getContainer() {
		return container;
	}

	public void setContainer(VBox container) {
		this.container = container;
	}

	public Label getComboBoxLabel() {
		return comboBoxLabel;
	}

	public void setComboBoxLabel(Label comboBoxLabel) {
		this.comboBoxLabel = comboBoxLabel;
	}

	public ComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(ComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public VBox getAnimationNodeContainer() {
		return animationNodeContainer;
	}

	public void setAnimationNodeContainer(VBox animationNodeContainer) {
		this.animationNodeContainer = animationNodeContainer;
	}
	
}
