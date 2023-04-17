package utils;


import java.util.Arrays;

public class ListaObjetos {
	
	// Atributos
	protected Object lista[];

	// Constructor
	public ListaObjetos() {
		lista = new Object[0];
	}

	// Get y Set
	public Object[] getLista() {
		return lista;
	}

	// Metodos
	@Override
	public String toString() {
		String respuesta = "";
		for (int i = 0; i < lista.length; i++) {
			respuesta += "Objeto "+(i+1)+": "+lista[i].toString() + "\n";
		}
		return respuesta;
	}

	@Override
	public boolean equals(Object obj) {
		boolean respuesta = false;
		ListaObjetos l1 = (ListaObjetos) obj;
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

	public int consultarCantidad() {
		int cantidad = lista.length;
		return cantidad;
	}

	public void addFinal(Object numero) {
		lista = Arrays.copyOf(lista, lista.length + 1);
		lista[lista.length - 1] = numero;
	}

	private void addInicio(Object numero) {
		lista = Arrays.copyOf(lista, lista.length + 1);
		for (int i = lista.length - 1; i > 0; i--) {
			lista[i] = lista[i - 1];
		}
		lista[0] = numero;
	}

	private void addEnIndice(Object numero, int indice) {
		int longitud = lista.length - 1;
		if (indice <= longitud) {
			lista = Arrays.copyOf(lista, lista.length + 1);
			System.arraycopy(lista, indice, lista, indice + 1, lista.length - indice - 1);
			lista[indice] = numero;
		} else {
			System.out.println("El indice está fuera de rango");
		}
	}

	private void fusionListas(ListaObjetos lista2) {
		int longitud1 = lista.length;
		int longitud2 = lista2.lista.length;
		int longTotal = longitud1 + longitud2;
		lista = Arrays.copyOf(lista, longTotal);
		for (int i = longitud1, j = 0; i < longTotal; i++, j++) {
			lista[i] = lista2.lista[j];
		}
	}

	protected void elimiarIndice(int indice) {
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

	public Object lecturaIndice(int indice) {
		Object respuesta = null;
		int longitud = lista.length - 1;
		if (indice <= longitud) {
			respuesta = lista[indice];
		} else {
			System.out.println("El indice está fuera de rango");
		}
		return respuesta;
	}

	protected int buscar(Object busqueda) {
		int respuesta = -1;
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == busqueda) {
				respuesta = i;
			}
		}
		return respuesta;
	}

}
