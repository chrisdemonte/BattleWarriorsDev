package guiElements;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class AttackMaker {
	
	TabPane container = new TabPane();
	Tab attackMain = new Tab();
	Tab selfBuff = new Tab();
	Tab targetBuff = new Tab();
	
	AttackMakerMovePane moveMaker = new AttackMakerMovePane();
	BuffMaker selfBuffMaker = new BuffMaker();
	BuffMaker targetBuffMaker = new BuffMaker();
	
	public AttackMaker () {
		this.generateLayout();
	}

	private void generateLayout() {
		attackMain.setText("Main");
		selfBuff.setText("Self Buff");
		targetBuff.setText("Target Buff");
		
		attackMain.setContent(moveMaker.getContainer());
		selfBuff.setContent(this.selfBuffMaker.getContainer());
		targetBuff.setContent(this.targetBuffMaker.getContainer());
		
		container.getTabs().addAll(attackMain, selfBuff, targetBuff);
		
	}

	public TabPane getContainer() {
		return container;
	}

	public void setContainer(TabPane container) {
		this.container = container;
	}
	
	

}
