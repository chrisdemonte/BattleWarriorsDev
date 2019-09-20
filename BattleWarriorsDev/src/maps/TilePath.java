package maps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class TilePath extends Tile{

	public TilePath(int x, int y, int width, int height, Map map) {
		super( x, y, width, height, map);
		this.generateLayout();
	}
	private void generateLayout() {
		this.loadImages();
		this.imageView.setFitHeight(this.tileHeight);
		this.imageView.setFitWidth(this.tileWidth);
		this.container.setMaxSize(this.tileWidth, this.tileHeight);
		this.container.setMinSize(this.tileWidth, this.tileHeight);
		this.container.setClip(new Rectangle(0,0,this.tileWidth,this.tileHeight));
		this.container.getChildren().addAll(imageView);
		if (data.hasEntity) {
			map.getContainer().getChildren().add(entityView);
			entityView.setTranslateX(getxCoord()*50);
			entityView.setTranslateY(getyCoord()*50);
		}
		
		container.setOnMouseClicked(e->{
			this.switchToPath();
		});
		
		
	}

	private void loadImages() {
		image = map.getImageFactory().getImage("tile_path_1");
		this.imageView = new ImageView(image);

	}
	private void switchToPath () {
		TileGrass grass = new TileGrass(this.getxCoord(), this.getyCoord(), this.tileWidth, this.tileHeight, this.map);
		grass.setxCoord(this.getxCoord());
		grass.setyCoord(this.getyCoord());
		this.map.changeTile(grass);
	}
	@Override
	public void dreamAnimation() {
		
	}
	
}
