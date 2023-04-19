package works;

import base.Man;
import gameResources.Money;

public class Fishmonger extends Man{
	
	public Fishmonger() {
		super();
	}

	public Fishmonger(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "G"
				);
	}

}
