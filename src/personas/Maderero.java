package personas;

import base.Man;
import recursos.Tree;
import recursos.Wood;
import recursos.Money;

public class Maderero extends Man{
	
	public Maderero() {
		super();
	}

	public Maderero(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "M"
				);
	}
	
	public Object talar(Tree tree) {
		
		int cantidad = tree.getAmount();
		
		Wood resultado = new Wood(icon, icon);
		resultado.setCantidad(cantidad/2);
		
		return resultado;
		
	}

}
