package personas;

import base.Sujeto;
import recursos.Moneda;

public class Panadero extends Sujeto{
	
	public Panadero() {
		super();
	}

	public Panadero(int ID, int HP, Moneda money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "B"
				);
	}

}
