package maps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


public class TileGrass extends Tile{

	public TileGrass (int x, int y, int width, int height, Map map) {
		super( x, y,width, height, map);
		this.generateLayout();
	}

	private void generateLayout() {
		this.loadImages();
		this.imageView.setFitHeight(this.tileHeight);
		this.imageView.setFitWidth(this.tileWidth);
		this.container.setClip(new Rectangle(0,0,this.tileWidth,this.tileHeight));
		this.container.setMaxSize(this.tileWidth, this.tileHeight);
		this.container.setMinSize(this.tileWidth, this.tileHeight);
		
		this.container.getChildren().addAll(imageView);
		
		container.setOnMouseClicked(e->{
			this.switchToPath();
		});
		
		
	}

	private void loadImages() {
		this.image = map.getImageFactory().getImage("tile_grass_1");
		this.imageView = new ImageView(image);
	}
	private void switchToPath () {
		/**
		TilePath path = new TilePath(this.getxCoord(), this.getyCoord(),this.tileWidth, this.tileHeight, this.map);
		path.setxCoord(this.getxCoord());
		path.setyCoord(this.getyCoord());
		map.changeTile(path);
		**/
		this.addEntity(new EntityData(this.getxCoord(), this.getyCoord(), "demonstawberry"));
	}
	
}
