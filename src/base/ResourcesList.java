package base;

import map.Board;
import minerales.GoldOreMineral;
import utils.ObjectsList;

public class ResourcesList {
	
	// List
	public ObjectsList resourceList = new ObjectsList();
	
	// Constructor
	public ResourcesList() {
	}
	
	// Methods
	
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
