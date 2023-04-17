package personas;

import base.Sujeto;
import recursos.Moneda;

public class Pescador extends Sujeto{
	
	public Pescador() {
		super();
	}

	public Pescador(int ID, int HP, Moneda money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "J"
				);
	}

}
