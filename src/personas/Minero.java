package personas;

import base.Sujeto;
import recursos.Moneda;

public class Minero extends Sujeto{
	
	public Minero() {
		super();
	}

	public Minero(int ID, int HP, Moneda money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "R"
				);
	}

}
