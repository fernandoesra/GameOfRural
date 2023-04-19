package works;

import base.Man;
import gameResources.Money;

public class Fisherman extends Man{
	
	public Fisherman() {
		super();
	}

	public Fisherman(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "J"
				);
	}

}
