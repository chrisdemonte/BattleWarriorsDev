package guiElements;

import attacks.Move;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.Player;
import utilities.FileManager;

public class CharacterCreatorTwoPlayer {

Player player;
Player enemy;
HBox container = new HBox();
VBox container1 = new VBox();
HBox playerOneContainer = new HBox();
VBox infoColumn = new VBox(3);
VBox statEditorColumn = new VBox(3);
VBox attackViewColumn = new VBox(3);

TextField nameEntry;
TextArea backstoryEntry;
BaseStatDoubleEditor statEditor;
Button submitButton;
Button backButton;
Button battleButton;

HBox enemyContainer = new HBox();
VBox infoColumn2 = new VBox(3);
VBox statEditorColumn2 = new VBox(3);
VBox attackViewColumn2 = new VBox(3);

TextField nameEntry2;
TextArea backstoryEntry2;
BaseStatDoubleEditor statEditor2;
Button submitButton2;
Button backButton2;
Button battleButton2;

boolean firstClick = false;
boolean secondClick = false;

Scene scene;
Window root;
int height;
int width;

public CharacterCreatorTwoPlayer(int width, int height, Window root, Scene scene ) {
	
	this.root = root;
	this.height = height;
	this.width = width;
	this.statEditor = new BaseStatDoubleEditor(5, width, height, this, false);
	this.statEditor2 = new BaseStatDoubleEditor(5, width, height, this, true);
	this.generateLayout();
	this.scene = scene;
	
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
	this.submitButton2.setOnAction(e->{
		try {
			this.enemy = new Player(
					this.nameEntry2.getText(),
					this.backstoryEntry2.getText(),
					this.statEditor2.getBaseStats(),
					this.statEditor2.getStarterAttacks());
			this.battleButton2.setDisable(false);
		}
		catch (NumberFormatException error) {
			error.printStackTrace();
		}
	});
	this.backButton.setOnAction(e->{
		this.root.getContainer().getChildren().clear();
		StartMenu menu = new StartMenu(this.width, this.height, this.root, this.scene);
		this.root.getContainer().getChildren().add(menu.getContainer());
	});
	this.battleButton.setOnAction(e->{
		this.firstClick = true;
		if (this.firstClick && this.secondClick) {
			BattleTwoPlayerScene battleScene = new BattleTwoPlayerScene(this.player, this.enemy, this.width, this.height, this.root, this.scene);
			this.root.getContainer().getChildren().clear();
			this.root.getContainer().getChildren().add(battleScene.getContainer());
		}
	});
	this.battleButton2.setOnAction(e->{
		this.secondClick = true;
		if (this.firstClick && this.secondClick) {
			BattleTwoPlayerScene battleScene = new BattleTwoPlayerScene(this.player, this.enemy, this.width, this.height, this.root, this.scene);
			this.root.getContainer().getChildren().clear();
			this.root.getContainer().getChildren().add(battleScene.getContainer());
		}
	});
	
}
private void generateLayout() {
	this.playerOneContainer.setMinSize(width, height*.4);
	this.enemyContainer.setMinSize(width, height*.4);
	this.generateInfoColumn();
	this.generateStatEditorColumn();
	this.generateAttackViewColumn();
	
	this.playerOneContainer.getChildren().addAll(infoColumn, statEditorColumn, attackViewColumn);
	this.enemyContainer.getChildren().addAll(infoColumn2, statEditorColumn2, attackViewColumn2);
	this.container1.getChildren().addAll(playerOneContainer, enemyContainer);
	this.container.getChildren().add(container1);
	
}
private void generateStatEditorColumn() {
	statEditorColumn.setMinSize(width/3, height*.4);
	statEditorColumn.setAlignment(Pos.TOP_CENTER);
	statEditorColumn.getChildren().add(statEditor.getContainer());
	statEditorColumn2.setMinSize(width/3, height*.4);
	statEditorColumn2.setAlignment(Pos.TOP_CENTER);
	statEditorColumn2.getChildren().add(statEditor2.getContainer());
	statEditorColumn2.setPadding(new Insets(height/10, 0,0,0));
}
@SuppressWarnings("unchecked")
public void generateAttackViewColumn() {
	this.attackViewColumn.getChildren().clear();
	this.attackViewColumn.setMinSize(width/3, height*.4);
	this.attackViewColumn.setAlignment(Pos.TOP_CENTER);
	attackViewColumn2.getChildren().clear();
	attackViewColumn2.setMinSize(width/3, height*.4);
	attackViewColumn2.setAlignment(Pos.TOP_CENTER);
	attackViewColumn2.setPadding(new Insets(height/10, 0,0,0));
	
	TableView<Move> table = new TableView<Move>();
	TableColumn<Move, String> attacks = new TableColumn<Move, String>("Attacks");
	attacks.setCellValueFactory(
            new PropertyValueFactory<Move, String>("name"));
	attacks.setPrefWidth((width/4));
	table.getColumns().addAll(attacks);
	table.setMinSize(width/4, height/3);
	table.setMaxSize(width/4, height/3);
	
	
	ObservableList<Move> list1 = FXCollections.observableArrayList(this.statEditor.getStarterAttacks());
	table.setItems(list1);
	
	TableView<Move> table2 = new TableView<Move>();
	TableColumn<Move, String> attacks2 = new TableColumn<Move, String>("Attacks");
	attacks2.setCellValueFactory(
            new PropertyValueFactory<Move, String>("name"));
	attacks2.setPrefWidth((width/4));
	table2.getColumns().addAll(attacks2);
	table2.setMinSize(width/4, height/3);
	table2.setMaxSize(width/4, height/3);
	
	
	ObservableList<Move> list2 = FXCollections.observableArrayList(this.statEditor2.getStarterAttacks());
	table2.setItems(list2);
	
	this.submitButton = new Button ("Create Player One");
	this.battleButton = new Button ("Battle!");
	this.battleButton.setDisable(true);
	this.submitButton2 = new Button ("Create Player Two");
	this.battleButton2 = new Button ("Battle!");
	this.backButton = new Button ("Back");
	this.battleButton2.setDisable(true);
	this.setButtonActions();
	this.attackViewColumn.getChildren().addAll(table, submitButton, battleButton);
	this.attackViewColumn2.getChildren().addAll(table2, submitButton2, battleButton2, backButton);
}
private void generateInfoColumn() {
	infoColumn.setMinSize(width/3, height*.4);
	infoColumn.setMaxSize(width/3, height*.4);
	infoColumn.setAlignment(Pos.TOP_CENTER);
	
	Label nameLabel = new Label ("Name :");
	nameLabel.setMinWidth(width/4);
	this.nameEntry = new TextField();
	this.nameEntry.setMinWidth(width/4);
	this.nameEntry.setMaxWidth(width/4);
	Label backstoryLabel = new Label ("Backstory:");
	backstoryLabel.setMinWidth(width/4);
	this.backstoryEntry = new TextArea();
	this.backstoryEntry.setMinSize(width/4, height/3);
	this.backstoryEntry.setMaxSize(width/4, height/3);
	this.backstoryEntry.setEditable(true);
	this.backstoryEntry.setWrapText(true);
	infoColumn.getChildren().addAll(nameLabel, nameEntry, backstoryLabel, backstoryEntry);
	
	infoColumn2.setMinSize(width/3, height*.4);
	infoColumn2.setMaxSize(width/3, height*.4);
	infoColumn2.setAlignment(Pos.TOP_CENTER);
	infoColumn2.setPadding(new Insets(height/10, 0,0,0));
	
	Label nameLabel2 = new Label ("Name :");
	nameLabel2.setMinWidth(width/4);
	this.nameEntry2 = new TextField();
	this.nameEntry2.setMinWidth(width/4);
	this.nameEntry2.setMaxWidth(width/4);
	Label backstoryLabel2 = new Label ("Backstory:");
	backstoryLabel2.setMinWidth(width/4);
	this.backstoryEntry2 = new TextArea();
	this.backstoryEntry2.setMinSize(width/4, height/3);
	this.backstoryEntry2.setMaxSize(width/4, height/3);
	this.backstoryEntry2.setEditable(true);
	this.backstoryEntry2.setWrapText(true);
	infoColumn2.getChildren().addAll(nameLabel2, nameEntry2, backstoryLabel2, backstoryEntry2);
}
public HBox getplayerOneContainer() {
	return playerOneContainer;
}
public void setplayerOneContainer(HBox playerOneContainer) {
	this.playerOneContainer = playerOneContainer;
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
public Window getRoot() {
	return root;
}
public void setRoot(Window root) {
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
public Player getEnemy() {
	return enemy;
}
public void setEnemy(Player enemy) {
	this.enemy = enemy;
}
public HBox getContainer() {
	return container;
}
public void setContainer(HBox container) {
	this.container = container;
}

}
