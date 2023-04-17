package personas;

import base.Sujeto;
import recursos.Moneda;

public class Carnicero extends Sujeto{
	
	public Carnicero() {
		super();
	}

	public Carnicero(int ID, int HP, Moneda money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "C"
				);
	}

}
