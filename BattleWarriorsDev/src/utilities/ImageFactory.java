package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.TreeSet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class ImageFactory {
	
	HashMap<String, Image> images = new HashMap<String, Image>(100);
	
	public ImageFactory() {
		this.loadImages();
	}

	private void loadImages() {
		// TODO Auto-generated method stub
		try {
			File file = new File("resources/images/mapAssets/tile_grass_1.PNG");
			images.put("tile_grass_1", new Image(new FileInputStream(file)));
			file = new File("resources/images/mapAssets/tile_path_1.PNG");
			images.put("tile_path_1", new Image(new FileInputStream(file)));
			
			file = new File("resources/images/red_pixel_pattern.PNG");
			images.put("red_pixel_pattern",new  Image(new FileInputStream(file)));
	
			file = new File("resources/images/black_pixel_pattern.PNG");
			images.put("black_pixel_pattern",new Image(new FileInputStream(file)));
			
			file = new File("resources/images/grey_pixel_pattern.PNG");
			images.put("grey_pixel_pattern",new Image(new FileInputStream(file)));
			
			file = new File("resources/images/playerModels/man.PNG");
			images.put("man",new Image(new FileInputStream(file)));
			
			file = new File("resources/images/playerModels/man_red.PNG");
			images.put("man_red",new Image(new FileInputStream(file)));
			
			file = new File("resources/images/playerModels/demonstawberry.PNG");
			images.put("demonstawberry",new Image(new FileInputStream(file)));
			
			file = new File("resources/images/attackAssets/buff_icon.PNG");
			images.put("buff_icon",new  Image(new FileInputStream(file)));
	
			file = new File("resources/images/attackAssets/debuff_icon.PNG");
			images.put("debuff_icon",new Image(new FileInputStream(file)));
			
			file = new File("resources/images/attackAssets/heal_icon.PNG");
			images.put("heal_icon",new Image(new FileInputStream(file)));
			
			file = new File("resources/images/attackAssets/damage_icon.PNG");
			images.put("damage_icon",new Image(new FileInputStream(file)));
			
			file = new File("resources/images/attackAssets/shield_icon.PNG");
			images.put("shield_icon",new Image(new FileInputStream(file)));
			
			file = new File("resources/images/attackAssets/sword_icon.PNG");
			images.put("sword_icon",new Image(new FileInputStream(file)));
			
			file = new File("resources/images/attackAssets/magic_icon.PNG");
			images.put("magic_icon",new Image(new FileInputStream(file)));
			
			file = new File("resources/images/attackAssets/combopoint_icon.PNG");
			images.put("combopoint_icon",new Image(new FileInputStream(file)));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, Image> getImages() {
		return images;
	}

	public void setImages(HashMap<String, Image> images) {
		this.images = images;
	}
	public Image getImage(String key) {
		if (images.containsKey(key)) {
			return images.get(key);
		}
		else {
			return null;
		}
	}

}
