package base;

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
