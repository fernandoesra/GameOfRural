package personas;

import base.Man;
import recursos.Money;

public class Carnicero extends Man{
	
	public Carnicero() {
		super();
	}

	public Carnicero(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "C"
				);
	}

}
