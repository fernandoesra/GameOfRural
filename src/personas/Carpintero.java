package personas;

import base.Man;
import recursos.Money;

public class Carpintero extends Man{
	
	public Carpintero() {
		super();
	}

	public Carpintero(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "I"
				);
	}

}
