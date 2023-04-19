package personas;

import base.Man;
import recursos.Money;

public class Panadero extends Man{
	
	public Panadero() {
		super();
	}

	public Panadero(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "B"
				);
	}

}
