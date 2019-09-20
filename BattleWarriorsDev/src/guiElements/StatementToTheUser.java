package guiElements;


import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class StatementToTheUser {
	
	HBox container = new HBox();
	VBox messageContainer = new VBox(5);
	
	Label text = new Label();
	Button howToPlayButton = new Button("How to Play");
	Button futureButton = new Button("Future Developements");
	Button backButton = new Button("Main Menu");
	ScrollPane scrollPane = new ScrollPane();
	
	Scene scene;
	int width;
	int height;
	Window root;
	
	
	public StatementToTheUser(int width, int height, Window root, Scene scene) {
		this.width = width;
		this.height = height;
		this.root = root;
		this.generateLayout();
		this.scene = scene;
	}

	private void generateLayout() {
		container.setMinSize(width , height);
		container.setMaxSize(width, height );
		container.setAlignment(Pos.CENTER);
		messageContainer.setMinSize(width, height);
		messageContainer.setMaxSize(width, height);
		messageContainer.setAlignment(Pos.CENTER);
		text.setMinWidth(width * .5);
		text.setMaxWidth(width * .5);
		text.setAlignment(Pos.BASELINE_CENTER);
		text.setWrapText(true);
		text.setFont(root.getSettings().getLargeFont());
		scrollPane.setContent(text);
		scrollPane.setMinSize(width * .65, height * .75);
		scrollPane.setMaxSize(width * .65, height * .75);
		scrollPane.setPadding(new Insets(10, 0, 0, width * .075));
		this.messageStatement();
		this.setButtons();
		
		messageContainer.getChildren().addAll(scrollPane, howToPlayButton, futureButton, backButton);
		container.getChildren().add(messageContainer);
		
	}

	private void setButtons() {
		howToPlayButton.setOnAction(e->{
			this.howToPlayStatement();
		});
		backButton.setOnAction(e->{
			StartMenu menu = new StartMenu(width, height, root, scene);
			root.getContainer().getChildren().clear();
			root.getContainer().getChildren().add(menu.getContainer());
		});
		
	}

	private void messageStatement() {
		String str = "\t\t!!!WELCOME TO BATTLE WARRIORS DEV 1.1!!!\n\n"
				+ "\tBattle Warriors is an RPG where you create a character, change their stats, and test them out in battle.\n\n"
				+ "\tThe goal of Battle Warriors is to provide players with a fun and challenging experience, and give the user freedom to express themselves through how they choose to play. "
				+ "For now, the game only offers simple character creation and a battle system, but more will be added in steps. "
				+ "But, the battle system is full and complex, with different styles of fighting. If you only want to use brute force and powerful attacks, you can. "
				+ "If you prefer to use strategy, there are plenty of skills and tricks at your disposal. No one play style is best. All of them have their own strengths and weaknesses.";
		text.setText(str);
		
		
	}
	private void howToPlayStatement() {
		String str = "\t\t!!!HOW TO PLAY!!!\n\n"
				+ "\tBattle system is turn based with game play similar to Pokemon and other RPGs but with an added bonus. "
				+ "Each ATTACK takes a certain amount of TIME to do, and every turn you are given 2 SECONDS of time. This means you dont have to pick just one attack per turn. "
				+ "You can use a stronger attack that uses all of your time, or you can pick multiple fast attacks. "
				+ "This gives the turn based combat some of the flair of a real time battle, and the oppertunity to employ strategy in choosing the best combination of attacks.\n\n"
				+ "\t\t!!!TIPS!!!\n\n"
				+ "\tThe different fighting styles reflect the NINE STATS that every character has:\n"
				+ "\tSTAMINA: Survivability and healing. A well-rounded character that uses buffs and healing to make themselves hard to kill.\n"
				+ "\tSTRENGTH: Powerful physical attacks. A durable character that can deal a lot of damage and end a battle quickly.\n"
				+ "\tDEFENSE: Slow and steady. A character focused on damage mitigation and whittling down the opponent slowly.\n"
				+ "\tMAGIC: Powerful magic attacks. A character with insanely strong attacks that use a lot of energy. Resource management is a must in long battles.\n"
				+ "\tRESISTANCE: Barriers and Reflecting. A tricky character that can bounce damage back at enemies. Especially effective against magic users.\n"
				+ "\tCUNNING: Diception and brutality. An unpredicatble character that can rely on sound strategy or luck to win.\n"
				+ "\tINTELLIGENCE: Buffs and strategy. A knowlegable character with an arsenal of different attacks to use.\n"
				+ "\tSKILL: Technique and Training. A character that relys on the strategic combination of attacks.\n"
				+ "\tSPEED: Precision and Quickness. A frail character with fast attacks that make every turn count.\n";
		text.setText(str);
	}

	public HBox getContainer() {
		return container;
	}

	public void setContainer(HBox container) {
		this.container = container;
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
