package works;

import base.Man;
import gameResources.Money;

public class Butcher extends Man{
	
	public Butcher() {
		super();
	}

	public Butcher(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "K"
				);
	}

}
