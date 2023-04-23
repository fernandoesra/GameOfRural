package main;

import base.Resource;
import utils.ObjectsList;

/**
 * This class store a ObjectsList for different types of objects simulating the
 * inventory of a character. The main methods are addToInventory(item) and
 * removeFromInventory(item).
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see utils.ObjectsList
 * @see base.Man
 * @see base.Resource
 * 
 */

public class Inventory {
	
	// Attribute
	ObjectsList inventory;
	
	/**
	 * This constructor create a new empty ObjectsList.
	 */
	public Inventory() {
		inventory = new ObjectsList();
	};
	
	/**
	 * This method add a object at the end of the inventory.
	 * 
	 * @param item A new object to add to the inventory
	 */
	public void addToInventory(Object item) {
		inventory.addEnd(item);
	}
	
	/**
	 * 
	 * @param item A object to remove from the inventory, if exists inside the
	 *             inventory.
	 * 
	 * @return <b><i>true</i></b> if the object exists in the inventory ant its
	 *         possible to delete, then delete the object.<br>
	 *         <b><i>False</i></b> if the item its not in the inventory.
	 */
	public boolean removeFromInventory(Object item) {
		boolean removed = false;
		if (inventory.searchIndex(item) >= 0) {
			inventory.eraseFromIndex(inventory.searchIndex(item));
			removed = true;
		}
		return removed;
	}
	
	/**
	 * Search one object in the inventory using the name attribute. This method only
	 * work with base.Resource objects.
	 * <b>Important: </b>This method only reads the first occurrence of the searched
	 * object name. If more objects exists, this method dont read this objects. 
	 * 
	 * @param nameToSearch The name attribute (not the class name) for the object
	 *                     being searched.
	 * 
	 * @return <b><i>true</i></b> if the object exists inside the inventory,
	 *         <b><i>False</i></b> if not.
	 */
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
	
	/**
	 * This method return a Resource object that matches the nameToFetch. If no one
	 * object of the searche name exists, return null. <b>Important: </b>This method
	 * only reads the first occurrence of the searched object name. If more objects
	 * exists, this method dont read this objects.
	 * 
	 * @param nameToFetch The name attribute (not the class name) for the object
	 *                    being searched.
	 * @return If one object with the searched name exists, return that object. If
	 *         not, return null.
	 */
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
