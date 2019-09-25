package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.scene.text.Font;

public class GUISettings {
	
	int width;
	int height;
	Font largeFont;
	Font smallFont;
	Font tinyFont;
	
	public GUISettings (int width, int height) {
		this.width = width;
		this.height = height;
		this.loadFonts();
	}
	
	public void loadFonts() {
		try {
			File file = new File("resources/fonts/Battlewarriors_8x5_font.ttf");
			//File file = new File("resources/fonts/mainFont.ttf");
			//File file = new File("resources/fonts/joystix.ttf");
			FileInputStream fis = new FileInputStream(file);
			largeFont = Font.loadFont(fis, 30);
			fis.close();
			FileInputStream fis2 = new FileInputStream(file);
			smallFont = Font.loadFont(fis2, 20);
			fis2.close();
			FileInputStream fis3 = new FileInputStream(file);
			tinyFont = Font.loadFont(fis3, 16);
			fis3.close();
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
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

	public Font getLargeFont() {
		return largeFont;
	}

	public void setLargeFont(Font largeFont) {
		this.largeFont = largeFont;
	}

	public Font getSmallFont() {
		return smallFont;
	}

	public void setSmallFont(Font smallFont) {
		this.smallFont = smallFont;
	}

	public Font getTinyFont() {
		return tinyFont;
	}

	public void setTinyFont(Font tinyFont) {
		this.tinyFont = tinyFont;
	}
	

}
