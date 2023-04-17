package personas;

import base.Sujeto;
import recursos.Moneda;

public class Pescadero extends Sujeto{
	
	public Pescadero() {
		super();
	}

	public Pescadero(int ID, int HP, Moneda money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "S"
				);
	}

}
