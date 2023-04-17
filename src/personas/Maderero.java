package personas;

import base.Sujeto;
import recursos.Arbol;
import recursos.Madera;
import recursos.Moneda;

public class Maderero extends Sujeto{
	
	public Maderero() {
		super();
	}

	public Maderero(int ID, int HP, Moneda money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "M"
				);
	}
	
	public Object talar(Arbol tree) {
		
		int cantidad = tree.getCantidad();
		
		Madera resultado = new Madera(icon, icon);
		resultado.setCantidad(cantidad/2);
		
		return resultado;
		
	}

}
