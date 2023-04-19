package personas;

import base.Man;
import recursos.Money;

public class Minero extends Man{
	
	public Minero() {
		super();
	}

	public Minero(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "R"
				);
	}

}
