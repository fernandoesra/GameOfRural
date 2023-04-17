package recursos;

import base.Recurso;

public class Madera extends Recurso{
	
	int cantidad;
	
	public Madera(String name, String icon) {
		super("Madera", icon);
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
