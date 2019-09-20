package maps;

import attacks.Buff;

public class TileData {
	
	int xCoord;
	int yCoord;
	String imageKey = "";
	boolean traversable = true;
	boolean breakable = true;
	boolean buildable = true;
	boolean tilable = true;
	boolean jumpable = true;
	boolean enemySpawn = false;
	int spawnRate = 0;
	boolean water = false;
	boolean hasEntity = false;
	EntityData entity = null;
	Buff buff = null;
	
	public TileData(int xCoord, int yCoord) {
		super();
		this.xCoord = xCoord;
		this.yCoord = yCoord;
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
	public boolean isTraversable() {
		return traversable;
	}
	public void setTraversable(boolean traversable) {
		this.traversable = traversable;
	}
	public boolean isBreakable() {
		return breakable;
	}
	public void setBreakable(boolean breakable) {
		this.breakable = breakable;
	}
	public boolean isBuildable() {
		return buildable;
	}
	public void setBuildable(boolean buildable) {
		this.buildable = buildable;
	}
	public boolean isTilable() {
		return tilable;
	}
	public void setTilable(boolean tilable) {
		this.tilable = tilable;
	}
	public boolean isJumpable() {
		return jumpable;
	}
	public void setJumpable(boolean jumpable) {
		this.jumpable = jumpable;
	}
	public boolean isEnemySpawn() {
		return enemySpawn;
	}
	public void setEnemySpawn(boolean enemySpawn) {
		this.enemySpawn = enemySpawn;
	}
	public int getSpawnRate() {
		return spawnRate;
	}
	public void setSpawnRate(int spawnRate) {
		this.spawnRate = spawnRate;
	}
	public boolean isWater() {
		return water;
	}
	public void setWater(boolean water) {
		this.water = water;
	}
	public boolean isHasEntity() {
		return hasEntity;
	}
	public void setHasEntity(boolean hasEntity) {
		this.hasEntity = hasEntity;
	}
	public EntityData getEntity() {
		return entity;
	}
	public void setEntity(EntityData entity) {
		this.entity = entity;
	}
	public Buff getBuff() {
		return buff;
	}
	public void setBuff(Buff buff) {
		this.buff = buff;
	}
	
	
}
