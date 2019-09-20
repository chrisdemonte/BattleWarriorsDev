package guiElements;

import attacks.Move;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import utilities.FileManager;

public class AttackMaker {
	
	TabPane container = new TabPane();
	Tab attackMain = new Tab();
	Tab selfBuff = new Tab();
	Tab targetBuff = new Tab();
	Tab animationTab = new Tab();
	Tab optionsTab = new Tab();
	
	AttackMakerMovePane moveMaker;
	BuffMaker selfBuffMaker = new BuffMaker();
	BuffMaker targetBuffMaker = new BuffMaker();
	AttackMakerAnimationMaker animationMaker = new AttackMakerAnimationMaker();
	
	Button submitButton = new Button ("Create Attack");
	Button backButton = new Button("Back");
	
	FileManager manager = new FileManager();
	
	Label debugTester = new Label("");
	
	Scene scene;
	Window root;
	int width;
	int height;
	
	public AttackMaker (int width, int height, Window root, Scene scene) {
		this.moveMaker = new AttackMakerMovePane(selfBuffMaker, targetBuffMaker, animationMaker);
		this.root = root;
		this.width = width;
		this.height = height;
		this.generateLayout();
		this.scene = scene;
	}

	private void generateLayout() {
		attackMain.setText("Main");
		selfBuff.setText("Self Buff");
		targetBuff.setText("Target Buff");
		animationTab.setText("Animations");
		optionsTab.setText("Options");
		
		VBox optionsButtons = new VBox(3);
		optionsButtons.getChildren().add(this.backButton);
		
		
		attackMain.setContent(moveMaker.getContainer());
		selfBuff.setContent(this.selfBuffMaker.getOuterContainer());
		targetBuff.setContent(this.targetBuffMaker.getOuterContainer());
		animationTab.setContent(this.animationMaker.getContainer());
		optionsTab.setContent(optionsButtons);
		container.setMinSize(1200, 800);
		moveMaker.getContainer().getChildren().addAll(this.submitButton, this.debugTester);
		this.setButtonAction();
		container.getTabs().addAll(attackMain, selfBuff, targetBuff, animationTab, optionsTab);
		
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
		this.backButton.setOnAction(e->{
			this.root.getContainer().getChildren().clear();
			StartMenu menu = new StartMenu(this.width, this.height, this.root, scene);
			this.root.getContainer().getChildren().add(menu.getContainer());
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
