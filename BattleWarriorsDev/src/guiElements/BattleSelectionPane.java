package guiElements;

import java.util.ArrayList;

import attacks.Move;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Player;

public class BattleSelectionPane {
	
	ArrayList<Move> priorityAttacks;
	ArrayList<Move> attacks;
	ArrayList<Move> attackList;
	
	ArrayList<BattleSelectionTab> choice = new ArrayList<BattleSelectionTab>();
	
	int timeCounter;
	
	VBox container = new VBox(3);
	ScrollPane scrollPane = new ScrollPane();
	HBox[] rows;
	Button clearButton; 
	Button submitButton;
	
	BattleScene arena;
	
	public BattleSelectionPane (){
		
	}
	public BattleSelectionPane (BattleScene arena, Player player) {
		this.arena = arena;
		this.attackList = player.getAttacks().getMoveList();
		this.rows = new HBox[(this.attackList.size()/3) + 1];
	}

}
