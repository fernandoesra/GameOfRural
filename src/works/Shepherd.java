package works;

import base.Man;
import gameResources.Money;

public class Shepherd extends Man{
	
	public Shepherd() {
		super();
	}

	public Shepherd(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "S"
				);
	}

}
