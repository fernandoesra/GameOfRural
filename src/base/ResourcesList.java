package base;

import minerales.GoldOreMineral;
import utils.ObjectsList;

public class ResourcesList {
	
	// List
	public ObjectsList resourceList = new ObjectsList();
	
	// Constructor
	public ResourcesList() {
	}
	
	// Methods
	public void addGoldOreMineral(int amount) {
		for (int i = 0; i < amount; i++) {
			GoldOreMineral oreMineral = new GoldOreMineral();
			resourceList.addEnd(oreMineral);
		}
	}
}
