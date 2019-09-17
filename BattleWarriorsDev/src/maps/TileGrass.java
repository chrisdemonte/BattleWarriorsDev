package maps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class TileGrass extends Tile{

	public TileGrass () {
		this.generateLayout();
	}

	private void generateLayout() {
		this.loadImages();
		this.imageView.prefWidth(50);
		this.imageView.prefHeight(50);
		this.imageView.setFitHeight(50);
		this.imageView.setFitWidth(50);
		this.container.getChildren().add(imageView);
		container.setOnMouseClicked(e->{
			this.switchToPath();
		});
		
		
	}

	private void loadImages() {
		try {
			File file = new File("resources/images/mapAssets/tile_grass_1.PNG");
			this.imageView = new ImageView(new Image(new FileInputStream(file)));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	private void switchToPath () {
		try {
			File file = new File("resources/images/mapAssets/tile_path_1.PNG");
			this.imageView.setImage(new Image(new FileInputStream(file)));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
