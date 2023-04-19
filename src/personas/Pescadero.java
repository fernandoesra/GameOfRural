package personas;

import base.Man;
import recursos.Money;

public class Pescadero extends Man{
	
	public Pescadero() {
		super();
	}

	public Pescadero(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "S"
				);
	}

}
