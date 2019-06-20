package models;

import java.util.ArrayList;
import java.util.Hashtable;

public class Inventory {
	
	Hashtable<String, Equipable> equipment = new Hashtable<String, Equipable>(15);
	ArrayList<Item> bag = new ArrayList<Item>(50);
	int coin; 

}
