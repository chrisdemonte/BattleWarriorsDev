package guiElements;

import attacks.Move;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import utilities.FileManager;

public class AttackMaker {
	
	TabPane container = new TabPane();
	Tab attackMain = new Tab();
	Tab selfBuff = new Tab();
	Tab targetBuff = new Tab();
	Tab animationTab = new Tab();
	
	AttackMakerMovePane moveMaker;
	BuffMaker selfBuffMaker = new BuffMaker();
	BuffMaker targetBuffMaker = new BuffMaker();
	AttackMakerAnimationMaker animationMaker = new AttackMakerAnimationMaker();
	
	Button submitButton = new Button ("Create Attack");
	
	FileManager manager = new FileManager();
	
	Label debugTester = new Label("");
	
	public AttackMaker () {
		this.moveMaker = new AttackMakerMovePane(selfBuffMaker, targetBuffMaker, animationMaker);
		this.generateLayout();
	}

	private void generateLayout() {
		attackMain.setText("Main");
		selfBuff.setText("Self Buff");
		targetBuff.setText("Target Buff");
		animationTab.setText("Animations");
		
		attackMain.setContent(moveMaker.getContainer());
		selfBuff.setContent(this.selfBuffMaker.getContainer());
		targetBuff.setContent(this.targetBuffMaker.getContainer());
		animationTab.setContent(this.animationMaker.getContainer());
		container.setMinSize(1200, 800);
		moveMaker.getContainer().getChildren().addAll(this.submitButton, this.debugTester);
		this.setButtonAction();
		container.getTabs().addAll(attackMain, selfBuff, targetBuff, animationTab);
		
	}
	
	public Move createMove() {
		return moveMaker.getMoveNode().generateAttack();
	}
	public void saveMove() {
		this.manager.saveMove(this.moveMaker.getMoveNode().generateAttack());
	}
	public void setButtonAction () {
		this.submitButton.setOnAction(e->{
			this.saveMove();
		});
	}
	public void useDebugger () {
		Move move = this.manager.loadMove("Punch");
		this.debugTester.setText(move.getName() + "\n" + move.getDescription());
	}

	public TabPane getContainer() {
		return container;
	}

	public void setContainer(TabPane container) {
		this.container = container;
	}
	
	

}
