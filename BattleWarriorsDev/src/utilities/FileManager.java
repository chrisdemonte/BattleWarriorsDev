package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import attacks.Move;

public class FileManager {
	
	public FileManager() {
		
	}
	
	public void saveMove (Move move) {
		Move output = move;
		ObjectOutputStream oos = null;
		File file = new File("resources\\data\\attacks\\" + move.getName() + ".data");
		
		try {
			if (!file.isFile()) {
				file.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(output);
			oos.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Move loadMove (String id) {
		Move move = null;
		ObjectInputStream ois = null;
		File file = new File("resources\\data\\attacks\\" + id + ".data");
		
		try {
			if (!file.isFile()) {
				move = null;
			}
			else {
				ois = new ObjectInputStream(new FileInputStream(file));
				move = (Move)ois.readObject();
				ois.close();	
				}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return move;
	}

}
