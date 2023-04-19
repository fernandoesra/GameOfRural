package works;

import base.Man;
import gameResources.Money;

public class Baker extends Man{
	
	public Baker() {
		super();
	}

	public Baker(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "B"
				);
	}

}
