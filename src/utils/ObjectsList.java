package utils;


import java.util.Arrays;

public class ObjectsList {
	
	// Attributes
	protected Object lista[];

	// Constructor
	public ObjectsList() {
		lista = new Object[0];
	}

	// Get and Set
	public Object[] getLista() {
		return lista;
	}

	// Methods
	@Override
	public String toString() {
		String respuesta = "";
		for (int i = 0; i < lista.length; i++) {
			respuesta += "Object "+(i+1)+": "+lista[i].toString() + "\n";
		}
		return respuesta;
	}

	@Override
	public boolean equals(Object obj) {
		boolean respuesta = false;
		ObjectsList l1 = (ObjectsList) obj;
		int aciertos = lista.length;
		for (int i = 0; i < lista.length && i < l1.lista.length; i++) {
			if (lista[i].equals(obj)) {
				aciertos--;
			}
		}
		if (aciertos == 0) {
			respuesta = true;
		}
		return respuesta;
	}

	public int getLength() {
		int cantidad = lista.length;
		return cantidad;
	}

	public void addEnd(Object numero) {
		lista = Arrays.copyOf(lista, lista.length + 1);
		lista[lista.length - 1] = numero;
	}

	private void addStart(Object numero) {
		lista = Arrays.copyOf(lista, lista.length + 1);
		for (int i = lista.length - 1; i > 0; i--) {
			lista[i] = lista[i - 1];
		}
		lista[0] = numero;
	}

	private void addOnIndex(Object numero, int index) {
		int longitud = lista.length - 1;
		if (index <= longitud) {
			lista = Arrays.copyOf(lista, lista.length + 1);
			System.arraycopy(lista, index, lista, index + 1, lista.length - index - 1);
			lista[index] = numero;
		} else {
			System.out.println("El indice está fuera de rango");
		}
	}

	private void mergeLists(ObjectsList lista2) {
		int longitud1 = lista.length;
		int longitud2 = lista2.lista.length;
		int longTotal = longitud1 + longitud2;
		lista = Arrays.copyOf(lista, longTotal);
		for (int i = longitud1, j = 0; i < longTotal; i++, j++) {
			lista[i] = lista2.lista[j];
		}
	}

	protected void eraseFromIndex(int indice) {
		int longitud = lista.length -1;
		if (indice <= longitud) {
			for (int i = indice; i < longitud; i++) {
				lista[i] = lista[i + 1];
			}
			lista = Arrays.copyOf(lista, longitud);
		} else {
			System.out.println("El indice está fuera de rango");
		}
	}

	public Object getObjectOnIndex(int indice) {
		Object respuesta = null;
		int longitud = lista.length - 1;
		if (indice <= longitud) {
			respuesta = lista[indice];
		} else {
			System.out.println("El indice está fuera de rango");
		}
		return respuesta;
	}

	protected int search(Object busqueda) {
		int respuesta = -1;
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == busqueda) {
				respuesta = i;
			}
		}
		return respuesta;
	}

}
