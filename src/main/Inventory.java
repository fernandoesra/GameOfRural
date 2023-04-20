package main;

import base.Resource;
import utils.ObjectsList;

public class Inventory {
	
	ObjectsList inventory;
	
	public Inventory() {
		inventory = new ObjectsList();
	};
	
	public void addToInventory(Object item) {
		inventory.addEnd(item);
	}
	
	public boolean removeFromInventory(Object item) {
		boolean removed = false;
		if (inventory.search(item) >= 0) {
			inventory.eraseFromIndex(inventory.search(item));
			removed = true;
		}
		return removed;
	}
	
	public boolean searchForName(String nameToSearch) {
		boolean find = false;
		if (inventory.getLength() > 0) {
			for (int i = 0; i < inventory.getLength(); i++) {
				Resource actual = (Resource) inventory.getObjectOnIndex(i);
				if (actual.getName().equals(nameToSearch)) {
					find = true;
					break;
				}
			}
		}
		return find;
	}
	
	public Object fetchForName(String nameToFetch) {
		Object toFetch = null;
		if (inventory.getLength() > 0) {
			for (int i = 0; i < inventory.getLength(); i++) {
				Resource actual = (Resource) inventory.getObjectOnIndex(i);
				if (actual.getName().equals(nameToFetch)) {
					toFetch = inventory.getObjectOnIndex(i);
					break;
				}
			}
		}
		return toFetch;
	}
	
	public String toString() {
		String listInventory = "";
		
		if (inventory.getLength() > 0) {
			listInventory += "Inventory: \n";
			for (int i = 0; i < inventory.getLength(); i++) {
				listInventory += "Item " + (i+1) +": " + inventory.getObjectOnIndex(i).toString() + "\n";
			}
		}
		
		return listInventory;
	}

}
