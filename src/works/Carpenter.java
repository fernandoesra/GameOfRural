package works;

import base.Man;
import gameResources.Money;

public class Carpenter extends Man{
	
	public Carpenter() {
		super();
	}

	public Carpenter(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "I"
				);
	}

}
