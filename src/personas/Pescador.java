package personas;

import base.Man;
import recursos.Money;

public class Pescador extends Man{
	
	public Pescador() {
		super();
	}

	public Pescador(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "J"
				);
	}

}
