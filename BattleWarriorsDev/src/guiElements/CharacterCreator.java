package guiElements;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.Player;
import utilities.FileManager;

public class CharacterCreator {
	
	Player player;
	
	HBox container = new HBox();
	VBox infoColumn = new VBox(3);
	VBox statEditorColumn = new VBox(3);
	VBox attackViewColumn = new VBox(3);
	
	TextField nameEntry;
	TextArea backstoryEntry;
	BaseStatEditor statEditor;
	Button submitButton;
	Button backButton;
	Button battleButton;
	
	Pane root;
	int height;
	int width;
	
	public CharacterCreator(int width, int height, Pane root ) {
		super();
		this.root = root;
		this.height = height;
		this.width = width;
		this.statEditor = new BaseStatEditor(5, width, height);
		this.generateLayout();
		this.setButtonActions();
	}
	private void setButtonActions() {
		this.submitButton.setOnAction(e->{
			try {
				this.player = new Player(
						this.nameEntry.getText(),
						this.backstoryEntry.getText(),
						this.statEditor.getBaseStats(),
						this.statEditor.getStarterAttacks());
				this.player.setNPC(false);
				this.battleButton.setDisable(false);
			}
			catch (NumberFormatException error) {
				error.printStackTrace();
			}
		});
		this.backButton.setOnAction(e->{
			this.root.getChildren().clear();
			StartMenu menu = new StartMenu(this.width, this.height, this.root);
			this.root.getChildren().add(menu.getContainer());
		});
		this.battleButton.setOnAction(e->{
			
			FileManager manager = new FileManager();
			
			Player enemy = new Player("Demon Stawberry", "A stawberry with demonic powers. Is that jelly or blood?");
			enemy.getAttacks().getMoveList().add(manager.loadMove("Bubble"));
			enemy.getAttacks().getMoveList().add(manager.loadMove("Bubble Burst"));
			enemy.getAttacks().getMoveList().add(manager.loadMove("Vegitable Throw"));
			enemy.getAttacks().getMoveList().add(manager.loadMove("Spit"));
			
			BattleScene battleScene = new BattleScene(this.player, enemy, this.width, this.height, this.root);
			this.root.getChildren().clear();
			this.root.getChildren().add(battleScene.getContainer());
		});
		
	}
	private void generateLayout() {
		container.setMinSize(width, height);
		
		this.generateInfoColumn();
		this.generateStatEditorColumn();
		this.generateAttackViewColumn();
		
		container.getChildren().addAll(infoColumn, statEditorColumn, attackViewColumn);
		
	}
	private void generateStatEditorColumn() {
		statEditorColumn.setMinSize(width/3, height);
		statEditorColumn.setAlignment(Pos.TOP_CENTER);
		statEditorColumn.getChildren().add(statEditor.getContainer());
	}
	private void generateAttackViewColumn() {
		attackViewColumn.setMinSize(width/3, height);
		attackViewColumn.setAlignment(Pos.TOP_CENTER);
		
		TableView<String> table = new TableView<String>();
		TableColumn<String, String> numbers = new TableColumn<String, String>("#");
		numbers.setPrefWidth(40);
		TableColumn<String, String> attacks = new TableColumn<String, String>("Attacks");
		attacks.setPrefWidth((width/4) - 40);
		table.getColumns().addAll(numbers, attacks);
		table.setMinSize(width/4, height/2);
		table.setMaxSize(width/4, height/2);
		
		this.submitButton = new Button ("Create Character");
		this.backButton = new Button ("Back");
		this.battleButton = new Button ("Battle!");
		this.battleButton.setDisable(true);
		attackViewColumn.getChildren().addAll(table, submitButton, battleButton, backButton);
	}
	private void generateInfoColumn() {
		infoColumn.setMinSize(width/3, height);
		infoColumn.setMaxSize(width/3, height);
		infoColumn.setAlignment(Pos.TOP_CENTER);
		
		Label nameLabel = new Label ("Name :");
		nameLabel.setMinWidth(width/4);
		this.nameEntry = new TextField();
		this.nameEntry.setMinWidth(width/4);
		this.nameEntry.setMaxWidth(width/4);
		Label backstoryLabel = new Label ("Backstory:");
		backstoryLabel.setMinWidth(width/4);
		this.backstoryEntry = new TextArea();
		this.backstoryEntry.setMinSize(width/4, height/2);
		this.backstoryEntry.setMaxSize(width/4, height/2);
		this.backstoryEntry.setEditable(true);
		this.backstoryEntry.setWrapText(true);
		infoColumn.getChildren().addAll(nameLabel, nameEntry, backstoryLabel, backstoryEntry);
	}
	public HBox getContainer() {
		return container;
	}
	public void setContainer(HBox container) {
		this.container = container;
	}
	public VBox getInfoColumn() {
		return infoColumn;
	}
	public void setInfoColumn(VBox infoColumn) {
		this.infoColumn = infoColumn;
	}
	public VBox getStatEditorColumn() {
		return statEditorColumn;
	}
	public void setStatEditorColumn(VBox statEditorColumn) {
		this.statEditorColumn = statEditorColumn;
	}
	public VBox getAttackViewColumn() {
		return attackViewColumn;
	}
	public void setAttackViewColumn(VBox attackViewColumn) {
		this.attackViewColumn = attackViewColumn;
	}
	public Pane getRoot() {
		return root;
	}
	public void setRoot(Pane root) {
		this.root = root;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

}
