package maps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Map {

	int xSize;
	int ySize;
	
	Pane container = new Pane();
	Tile[][] mapTiles;
	HBox eastWestContainer;
	VBox[] northSouthContainer;
	
	Image playerAvatar;
	ImageView avatarHolder;
	
	int counter = 0;
	
	public Map(int xSize, int ySize, Pane root) {
		super();
		this.xSize = xSize;
		this.ySize = ySize;
		this.generateMap();
	}

	private void generateMap() {
		eastWestContainer = new HBox();
		mapTiles = new Tile[xSize][ySize];
		northSouthContainer = new VBox[xSize];
		for (int i = 0; i < xSize; i++) {
			northSouthContainer[i] = new VBox();
			eastWestContainer.getChildren().add(northSouthContainer[i]);
			for (int j = 0; j < ySize; j++) {
				mapTiles[i][j] = new TileGrass();
				northSouthContainer[i].getChildren().add(mapTiles[i][j].getContainer());
				
			}
			
		}
		this.loadImages();
		avatarHolder.setFitHeight(50);
		avatarHolder.setFitWidth(50);
		avatarHolder.setTranslateX(200);
		avatarHolder.setTranslateY(180);
		container.getChildren().addAll(eastWestContainer, avatarHolder);
		this.dreamAnimation();
		
	}
	public void dreamAnimation() {
		
		
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		//timeline.setAutoReverse(true);
		
		EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				for(int i = counter; i < xSize; i+=10 ) {
					for (int j = 0; j < ySize; j++) {
						mapTiles[j][i].dreamAnimation();
					}
				}
				counter++;
				counter %= 10;
				
			}	
		};
		
		timeline.getKeyFrames().addAll(
				new KeyFrame(Duration.ZERO),
				new KeyFrame(Duration.millis(500), handler));

		timeline.play();
		
		
	}

	public void loadImages() {
		try {
			File file = new File("resources/images/playerModels/man.PNG");
			avatarHolder = new ImageView(new Image(new FileInputStream(file)));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public int getxSize() {
		return xSize;
	}

	public void setxSize(int xSize) {
		this.xSize = xSize;
	}

	public int getySize() {
		return ySize;
	}

	public void setySize(int ySize) {
		this.ySize = ySize;
	}

	public Pane getContainer() {
		return container;
	}

	public void setContainer(Pane container) {
		this.container = container;
	}

	public Tile[][] getMapTiles() {
		return mapTiles;
	}

	public void setMapTiles(Tile[][] mapTiles) {
		this.mapTiles = mapTiles;
	}

	public HBox getEastWestContainer() {
		return eastWestContainer;
	}

	public void setEastWestContainer(HBox eastWestContainer) {
		this.eastWestContainer = eastWestContainer;
	}

	public VBox[] getNorthSouthContainer() {
		return northSouthContainer;
	}

	public void setNorthSouthContainer(VBox[] northSouthContainer) {
		this.northSouthContainer = northSouthContainer;
	}
	
	
}
