package personas;

import base.Sujeto;
import minerales.Oro;
import recursos.Moneda;

/*
 * FILL = ((Math.random() * (maxPercent - minPercent)) + minPercent);
 */

public class Herrero extends Sujeto{
	
	public Herrero() {
		super();
	}

	public Herrero(int ID, int HP, Moneda money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "H"
				);
	}
	
	public Moneda fundir(Oro oro) {
		int cantidad = (int)((Math.random() * (11 - 1)) + 1);
		Moneda fundido = new Moneda(cantidad);
		oro = null;
		return fundido;
	}

}
