package recursos;

import base.Recurso;

public class Arbol extends Recurso{
	
	int cantidad;
	
	public Arbol(String name, String icon) {
		super("Arbol", icon);
		cantidad = 10;
	}
	
	public int getCantidad() {
		return cantidad;
	}

}
