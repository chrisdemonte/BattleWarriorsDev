package guiElements;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.Player;
import utilities.FileManager;

public class StartMenu {
	
	HBox container = new HBox();
	VBox menuContainer = new VBox(5);
	
	Button charCreationButton = new Button("One Player Battle");
	Button twoPlayerBattle = new Button("Two Player Battle");
	Button battleButton = new Button ("Quick Batte");
	Button attackEditorButton = new Button("Attack Maker");
	
	Pane root;
	int width = 0;
	int height = 0;
	
	public StartMenu (int width, int height, Pane root) {
		this.width = width;
		this.height = height;
		this.generateLayout();
		this.root = root;
		
	}

	private void generateLayout() {
		this.container.setMinSize(width, height);
		this.container.setMaxSize(width, height);
		this.container.setAlignment(Pos.BASELINE_CENTER);
		
		this.setButtonActions();
		this.menuContainer.getChildren().addAll(this.charCreationButton, this.twoPlayerBattle, this.battleButton, this.attackEditorButton);
		this.menuContainer.setPadding(new Insets(height / 3, 0, 0, 0));
		
		this.container.getChildren().add(menuContainer);
	}

	private void setButtonActions() {
		
		charCreationButton.setOnAction(e->{
			CharacterCreator charCreator = new CharacterCreator(width, height, root);
			this.root.getChildren().clear();
			this.root.getChildren().add(charCreator.getContainer());
		});
		charCreationButton.setMinSize(width/10, height/20);
		
		twoPlayerBattle.setOnAction(e->{
			CharacterCreatorTwoPlayer charCreator = new CharacterCreatorTwoPlayer(width, height, root);
			this.root.getChildren().clear();
			this.root.getChildren().add(charCreator.getContainer());
		});
		twoPlayerBattle.setMinSize(width/10, height/20);
		charCreationButton.setMinSize(width/10, height/20);
		
		attackEditorButton.setOnAction(e->{
			
			AttackMaker attackMaker = new AttackMaker(this.width, this.height, this.root);
			this.root.getChildren().clear();
			this.root.getChildren().add(attackMaker.getContainer());
		});
		attackEditorButton.setMinSize(width/10, height/20);
		battleButton.setOnAction(e->{
			
			FileManager manager = new FileManager();
			Player user = new Player("Chris", "Developer");
			user.getAttacks().getMoveList().add(manager.loadMove("Punch"));
			user.getAttacks().getMoveList().add(manager.loadMove("Kick"));
			user.getAttacks().getMoveList().add(manager.loadMove("Scratch"));
			user.getAttacks().getMoveList().add(manager.loadMove("Jab"));
			user.getAttacks().getMoveList().add(manager.loadMove("Cross Punch"));
			user.getAttacks().getMoveList().add(manager.loadMove("Double Tiger Strike"));
			user.getAttacks().getMoveList().add(manager.loadMove("Wild Attack"));
			user.getAttacks().getMoveList().add(manager.loadMove("Raise Defense"));
			user.getAttacks().getMoveList().add(manager.loadMove("Gather Strength"));
			user.getAttacks().getMoveList().add(manager.loadMove("Dev Buff"));
			user.getAttacks().getMoveList().add(manager.loadMove("Spit"));
			user.getAttacks().getMoveList().add(manager.loadMove("Bandage"));
			user.getAttacks().getMoveList().add(manager.loadMove("Fireball"));
			user.setNPC(false);
			
			Player enemy = new Player("Demon Stawberry", "A stawberry with demonic powers. Is that jelly or blood?");
			enemy.getAttacks().getMoveList().add(manager.loadMove("Bubble"));
			enemy.getAttacks().getMoveList().add(manager.loadMove("Bubble Burst"));
			enemy.getAttacks().getMoveList().add(manager.loadMove("Vegitable Throw"));
			enemy.getAttacks().getMoveList().add(manager.loadMove("Spit"));
			
			BattleSinglePlayerScene battleScene = new BattleSinglePlayerScene(user, enemy, this.width, this.height, this.root);
			this.root.getChildren().clear();
			this.root.getChildren().add(battleScene.getContainer());
		});
		battleButton.setMinSize(width/10, height/20);
		
	}

	public HBox getContainer() {
		return container;
	}

	public void setContainer(HBox container) {
		this.container = container;
	}

	public VBox getMenuContainer() {
		return menuContainer;
	}

	public void setMenuContainer(VBox menuContainer) {
		this.menuContainer = menuContainer;
	}

	public Button getCharCreationButton() {
		return charCreationButton;
	}

	public void setCharCreationButton(Button charCreationButton) {
		this.charCreationButton = charCreationButton;
	}

	public Button getBattleButton() {
		return battleButton;
	}

	public void setBattleButton(Button battleButton) {
		this.battleButton = battleButton;
	}

	public Button getAttackEditorButton() {
		return attackEditorButton;
	}

	public void setAttackEditorButton(Button attackEditorButton) {
		this.attackEditorButton = attackEditorButton;
	}

	public Pane getRoot() {
		return root;
	}

	public void setRoot(HBox root) {
		this.root = root;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
