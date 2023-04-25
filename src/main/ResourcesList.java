package main;

import map.Board;
import resources.GoldOreMineral;
import resources.Grain;
import utils.ObjectsList;

/**
 * This class store a ObjectsList to save the Resources in the map like the
 * minerals or animals. Is main objective its to create the posibility of create
 * objects and later add its to the map.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Resource
 * @see utils.ObjectsList
 * @see map.Board
 * 
 */

public class ResourcesList {
	
	// Attributes
	ObjectsList resourceList;

	/**
	 * Create a new empty resourceList.
	 */
	public ResourcesList() {
		resourceList = new ObjectsList();
	}
	
	// Methods
	
	/**
	 * This method add one object at the end of the resourceList.
	 * 
	 * @param newResource The object to add.
	 */
	public void addGenericResource(Object newResource) {
		resourceList.addEnd(newResource);
	}
	
	/**
	 * This method run over all the resourceList and add all the objects inside the
	 * list in randoms valid positions of one map.
	 * 
	 * @param board The board with the map to fill with resources.
	 */
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
	
	/**
	 * This method created 'x' GoldOreMineral objects and adds them to the end of
	 * the resourceList.
	 * 
	 * @param amount How much Gold Ore Mineral to create.
	 */
	public void addGoldOreMineral(int amount) {
		for (int i = 0; i < amount; i++) {
			GoldOreMineral oreMineral = new GoldOreMineral();
			resourceList.addEnd(oreMineral);
		}
	}
	
	/**
	 * This method created 'x' Grain objects and adds them to the end of the
	 * resourceList.
	 * 
	 * @param amount How much Grain to create.
	 */
	public void addGrain(int amount) {
		for (int i = 0; i < amount; i++) {
			Grain grain = new Grain();
			resourceList.addEnd(grain);
		}
	}
}
