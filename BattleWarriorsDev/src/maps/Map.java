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
import utilities.ImageFactory;

public class Map {

	String name;
	int xSize;
	int ySize;
	int tileWidth;
	int tileHeight;
	
	Pane container = new Pane();
	Tile[][] mapTiles;
	HBox eastWestContainer;
	VBox[] northSouthContainer;
	
	Image playerAvatar;
	ImageView avatarHolder;
	Pane avatarPane = new Pane();
	ImageFactory imageFactory;
	
	int counter = 0;
	
	public Map(int xSize, int ySize, String name, int tileWidth, int tileHeight, Pane root) {
		super();
		this.name = name;
		this.xSize = xSize;
		this.ySize = ySize;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.imageFactory = new ImageFactory();
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
				mapTiles[i][j] = new TileGrass(i,j,tileWidth, tileHeight, this);
				mapTiles[i][j].setxCoord(i);
				mapTiles[i][j].setyCoord(j);
				northSouthContainer[i].getChildren().add(mapTiles[i][j].getContainer());
				
			}
			
		}
		this.loadImages();
		avatarHolder.setFitHeight(50);
		avatarHolder.setFitWidth(50);
		avatarPane.setTranslateX(200);
		avatarPane.setTranslateY(180);
		avatarPane.getChildren().add(avatarHolder);
		avatarPane.setMinSize(50,50);
		avatarPane.setMaxSize(50, 50);
		container.getChildren().addAll(eastWestContainer, avatarPane);
		this.dreamAnimation();
		//
		avatarPane.setOnMouseClicked(e->{
			avatarPane.setTranslateZ(10);
		});
		//
		
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

	public void changeTile(Tile newTile) {
		VBox column = this.northSouthContainer[newTile.getxCoord()];
		column.getChildren().remove(newTile.getyCoord());
		column.getChildren().add(newTile.getyCoord(), newTile.getContainer());
		this.mapTiles[newTile.getxCoord()][newTile.getyCoord()] = newTile;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}

	public Image getPlayerAvatar() {
		return playerAvatar;
	}

	public void setPlayerAvatar(Image playerAvatar) {
		this.playerAvatar = playerAvatar;
	}

	public ImageView getAvatarHolder() {
		return avatarHolder;
	}

	public void setAvatarHolder(ImageView avatarHolder) {
		this.avatarHolder = avatarHolder;
	}

	public ImageFactory getImageFactory() {
		return imageFactory;
	}

	public void setImageFactory(ImageFactory imageFactory) {
		this.imageFactory = imageFactory;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
}
