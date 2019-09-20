package maps;

public class EntityData {

	int xCoord;
	int yCoord;
	String imageKey = "";
	boolean breakable = true;
	boolean lootable = false;
	boolean battleable = false;
	boolean conversational = false;
	boolean useable = false;
	boolean questObject = false;
	boolean hidden = false; 
	
	
	public EntityData(int xCoord, int yCoord, String imageKey) {
		super();
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.imageKey = imageKey;
	}
	public boolean isBattleable() {
		return battleable;
	}
	public void setBattleable(boolean battleable) {
		this.battleable = battleable;
	}
	public boolean isConversational() {
		return conversational;
	}
	public void setConversational(boolean conversational) {
		this.conversational = conversational;
	}
	public boolean isUseable() {
		return useable;
	}
	public void setUseable(boolean useable) {
		this.useable = useable;
	}
	public boolean isQuestObject() {
		return questObject;
	}
	public void setQuestObject(boolean questObject) {
		this.questObject = questObject;
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
	public String getImageKey() {
		return imageKey;
	}
	public void setImageKey(String imageKey) {
		this.imageKey = imageKey;
	}
	public boolean isBreakable() {
		return breakable;
	}
	public void setBreakable(boolean breakable) {
		this.breakable = breakable;
	}
	public boolean isLootable() {
		return lootable;
	}
	public void setLootable(boolean lootable) {
		this.lootable = lootable;
	}

}
