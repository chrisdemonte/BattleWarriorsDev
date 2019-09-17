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
	
	int xCoord;
	int yCoord;
	
	Pane container = new Pane();
	Image image;
	ImageView imageView;
	
	public Tile () {
		this.generateLayout();
	}

	private void generateLayout() {
		this.loadImages();
		
		
	}

	private void loadImages() {
	
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
				new KeyFrame (Duration.millis(2250), new KeyValue(imageView.scaleXProperty(), 1.125), new KeyValue (imageView.scaleYProperty(), 1.1)),
				new KeyFrame (Duration.millis(4500), finalHandler, new KeyValue(imageView.scaleXProperty(), 1.0), new KeyValue(imageView.scaleYProperty(), 1.0)));
		timeline.play();
		
		
		
		
	}
	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
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

}
