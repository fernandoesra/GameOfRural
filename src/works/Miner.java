package works;

import base.Man;
import gameResources.Money;

public class Miner extends Man{
	
	public Miner() {
		super();
	}

	public Miner(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "M"
				);
	}

}
