package personas;

import base.Sujeto;
import recursos.Moneda;

public class Pastor extends Sujeto{
	
	public Pastor() {
		super();
	}

	public Pastor(int ID, int HP, Moneda money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "O"
				);
	}

}
