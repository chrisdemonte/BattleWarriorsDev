package models;

import java.util.ArrayList;
import java.util.Hashtable;

public class Inventory {
	
	Hashtable<String, Equipable> equipment = new Hashtable<String, Equipable>(15);
	ArrayList<Item> bag = new ArrayList<Item>(50);
	int coin; 
	
	public Inventory (){
		equipment.put("head", new Armor("head"));
		equipment.put("chest", new Armor("chest"));
		equipment.put("legs", new Armor("legs"));
		equipment.put("hands", new Armor("hands"));
		equipment.put("feet", new Armor("feet"));
		equipment.put("trinket1", new Armor("trinket1"));
		equipment.put("trinket2", new Armor("trinket2"));
		equipment.put("2HWeapon", new Armor("2HWeapon"));
		equipment.put("1HMain", new Armor("1HMain"));
		equipment.put("1HOffHand", new Armor("1HOffHand"));
		
		for (int i = 0; i < 50; i++) {
			bag.add(null);
		}
		coin = 0;
	}

	public Hashtable<String, Equipable> getEquipment() {
		return equipment;
	}

	public void setEquipment(Hashtable<String, Equipable> equipment) {
		this.equipment = equipment;
	}

	public ArrayList<Item> getBag() {
		return bag;
	}

	public void setBag(ArrayList<Item> bag) {
		this.bag = bag;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}
	

}
