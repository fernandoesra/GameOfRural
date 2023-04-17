package personas;

import base.Sujeto;
import recursos.Moneda;

public class Carpintero extends Sujeto{
	
	public Carpintero() {
		super();
	}

	public Carpintero(int ID, int HP, Moneda money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "I"
				);
	}

}
