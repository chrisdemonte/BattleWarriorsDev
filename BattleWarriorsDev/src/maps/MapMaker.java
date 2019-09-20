package maps;

import guiElements.Window;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MapMaker {
	
	HBox container = new HBox();
	ScrollPane mapDisplay = new ScrollPane();
	ScrollPane controlsContainer = new ScrollPane();
	VBox controlsDisplay = new VBox();
	
	Map map;
	
	Label newMapLabel = new Label ("New Map");
	Label nameLabel = new Label ("Map Name: ");
	TextField nameEntry = new TextField ("Name");
	Label mapWidthLabel = new Label ("Map Width");
	TextField mapWidthEntry = new TextField ("10");
	Label mapHeightLabel = new Label ("Map Height");
	TextField mapHeightEntry = new TextField ("10");
	Button newMapButton = new Button ("Create");
	
	Window root;
	Scene scene;
	int width;
	int height;
	
	public MapMaker( int width, int height, Window root, Scene scene) {
		super();
		this.root = root;
		this.scene = scene;
		this.width = width;
		this.height = height;
		this.generateLayout();
	}

	private void generateLayout() {
		this.setButtons();
		controlsDisplay.setMinWidth(width * .25);
		controlsDisplay.setMaxWidth(width * .25);
		controlsDisplay.getChildren().addAll(this.newMapLabel, this.nameEntry, this.mapWidthLabel, this.mapWidthEntry,
				this.mapHeightLabel, this.mapHeightEntry, newMapButton);
		controlsContainer.setContent(controlsDisplay);
		controlsContainer.setMinSize(width * .25, height);
		controlsContainer.setMinSize(width * .25, height);
		mapDisplay.setMinSize(width * .75, height);
		mapDisplay.setMaxSize(width * .75, height);
		container.getChildren().addAll(mapDisplay, controlsContainer);
		
	}

	private void setButtons() {
		this.newMapButton.setOnAction(e->{
			try {
				this.map = new Map(
						Integer.parseInt(mapWidthEntry.getText()),
						Integer.parseInt(mapHeightEntry.getText()),
						nameEntry.getText(), 
						50, 
						50, 
						this.root.getContainer());
				mapDisplay.setContent(map.getContainer());
				this.generateControls();
			}
			catch (NumberFormatException exception) {
				exception.printStackTrace();
				map = null;
			}	
		});
		
		
	}

	private void generateControls() {
		// TODO Auto-generated method stub
		
	}

	public HBox getContainer() {
		return container;
	}

	public void setContainer(HBox container) {
		this.container = container;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
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
