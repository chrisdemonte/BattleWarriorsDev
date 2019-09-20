package guiElements;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import utilities.GUISettings;

public class Window {
	
	Pane container = new Pane();
	GUISettings settings;
	Scene scene;
	
	public Window(int width, int height) {
		settings = new GUISettings(width, height);
		this.generateLayout();
	}

	private void generateLayout() {
		container.setMinSize(settings.getWidth(), settings.getHeight());
		
	}

	public Pane getContainer() {
		return container;
	}

	public void setContainer(Pane container) {
		this.container = container;
	}

	public GUISettings getSettings() {
		return settings;
	}

	public void setSettings(GUISettings settings) {
		this.settings = settings;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	

}
