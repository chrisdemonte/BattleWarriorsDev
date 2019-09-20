package maps;

import java.io.FileNotFoundException;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Tile {
	
	TileData data;
	int tileWidth;
	int tileHeight;
	
	Pane container = new Pane();
	Image image;
	ImageView imageView;
	Image entityImage;
	ImageView entityView;
	Map map;
	
	public Tile (int x, int y, int width, int height, Map map) {
		data = new TileData(x,y);
		this.tileHeight = height;
		this.tileWidth = width;
		this.map = map;
	}

	private void generateLayout() {
		
	}

	private void loadImages() {
	
	}
	public void addEntity(EntityData entData) {
		if (!data.hasEntity) {
			data.setEntity(entData);
			entityImage = map.getImageFactory().getImage("demonstawberry");
			entityView = new ImageView(entityImage);
			map.getContainer().getChildren().add(entityView);
			entityView.setTranslateX(getxCoord()*tileWidth);
			entityView.setTranslateY(getyCoord()*tileHeight);
			entityView.setFitHeight(tileWidth);
			entityView.setFitWidth(tileHeight);
		}
	}

	public void dreamAnimation() {
		Timeline timeline = new Timeline();
		timeline.setAutoReverse(true);
		timeline.setCycleCount(1);
		
		EventHandler<ActionEvent> finalHandler = new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				timeline.stop();
				
			}
			
		};
		
		timeline.getKeyFrames().addAll(
				
				new KeyFrame (Duration.ZERO, new KeyValue(imageView.scaleXProperty(), 1.0), new KeyValue(imageView.scaleYProperty(), 1.0)),
				//new KeyFrame (Duration.millis(2250), new KeyValue(imageView.scaleXProperty(), 1.125), new KeyValue (imageView.scaleYProperty(), 1.1)),
				new KeyFrame (Duration.millis(2250), new KeyValue(imageView.scaleXProperty(), 1.2), new KeyValue (imageView.scaleYProperty(), 1.2)),
				new KeyFrame (Duration.millis(4500), finalHandler, new KeyValue(imageView.scaleXProperty(), 1.0), new KeyValue(imageView.scaleYProperty(), 1.0)));
		
		timeline.play();
		
	}
	public void windAnimation() {
		Timeline timeline = new Timeline();
		timeline.setAutoReverse(true);
		timeline.setCycleCount(1);
		
		EventHandler<ActionEvent> finalHandler = new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				timeline.stop();
				
			}
			
		};
		
		timeline.getKeyFrames().addAll(
				
				new KeyFrame (Duration.ZERO, new KeyValue(imageView.translateXProperty(), 0), new KeyValue(imageView.translateYProperty(), 0)),
				new KeyFrame (Duration.millis(2250), new KeyValue(imageView.translateXProperty(), 10), new KeyValue (imageView.translateYProperty(), 5)),
				//new KeyFrame (Duration.millis(2250), new KeyValue(imageView.translateXProperty(), 2), new KeyValue (imageView.translateYProperty(), 2)),
				new KeyFrame (Duration.millis(4500), finalHandler, new KeyValue(imageView.translateXProperty(), 0), new KeyValue(imageView.translateYProperty(), 0)));
		
		timeline.play();
		
	}
	public int getxCoord() {
		return data.getxCoord();
	}

	public void setxCoord(int xCoord) {
		this.data.setxCoord(xCoord);;
	}

	public int getyCoord() {
		return data.getyCoord();
	}

	public void setyCoord(int yCoord) {
		this.data.setyCoord(yCoord);
	}

	public Pane getContainer() {
		return container;
	}

	public void setContainer(Pane container) {
		this.container = container;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
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

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public TileData getData() {
		return data;
	}

	public void setData(TileData data) {
		this.data = data;
	}
	

}
