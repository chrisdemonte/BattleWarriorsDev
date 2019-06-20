package models;

public class Entity {
	
	private String name;
	private String description; 
	private int xCoord;
	private int yCoord;
	
	public Entity(String name, String description) {
		this.name = name;
		this.description = description;
		this.xCoord = 0;
		this.yCoord = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	

}
