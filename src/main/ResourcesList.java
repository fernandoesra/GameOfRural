package main;

import map.Board;
import minerals.GoldOreMineral;
import utils.ObjectsList;

public class ResourcesList {
	
	// List
	ObjectsList resourceList;
	
	// Constructor
	public ResourcesList() {
		resourceList = new ObjectsList();
	}
	
	// Methods
	
	public void addGenericResource(Object newResource) {
		resourceList.addEnd(newResource);
	}
	
	public void addResourcesToMap(Board board) {
		int mapX = board.getHeight();
		int mapY = board.getWidth();
		
		for (int i = 0; i < resourceList.getLength(); i++) {
			
			int tryMapX = 0;
			int tryMapY = 0;
			
			do {
				tryMapX = (int)((Math.random() * (mapX - 0)) + 0);
				tryMapY = (int)((Math.random() * (mapY - 0)) + 0);
			} while (board.validPosition(tryMapX, tryMapY) == false);
			
			board.addSomething(resourceList.getObjectOnIndex(i), tryMapX, tryMapY);
			
		}
	}
	
	public void addGoldOreMineral(int amount) {
		for (int i = 0; i < amount; i++) {
			GoldOreMineral oreMineral = new GoldOreMineral();
			resourceList.addEnd(oreMineral);
		}
	}
}
