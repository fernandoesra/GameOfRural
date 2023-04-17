package base;

import map.Board;
import personas.Agricultor;
import personas.Carnicero;
import personas.Carpintero;
import personas.Herrero;
import personas.Maderero;
import personas.Minero;
import personas.Panadero;
import personas.Pastor;
import personas.Pescadero;
import personas.Pescador;
import recursos.Moneda;
import utils.ListaObjetos;

public class CitizenList {
	
	// List
	ListaObjetos citizenList = new ListaObjetos();
	int IDs;
	
	// Constructor
	public CitizenList() {
		super();
		IDs = 1;
	}
	
	// Add diferent citizens
	
	public void addCitizensToMap(Board board) {
		
		int mapX = board.getHeight();
		int mapY = board.getWidth();
		
		for (int i = 0; i < citizenList.consultarCantidad(); i++) {
			
			int tryMapX = 0;
			int tryMapY = 0;
			
			do {
				tryMapX = (int)((Math.random() * (mapX - 0)) + 0);
				tryMapY = (int)((Math.random() * (mapY - 0)) + 0);
			} while (board.validPosition(tryMapX, tryMapY) == false);
			
			board.addSomething(citizenList.lecturaIndice(i), tryMapX, tryMapY);
			Sujeto a1 = (Sujeto)citizenList.lecturaIndice(i);
			a1.setMapX(tryMapX);
			a1.setMapY(tryMapY);

		}
	}
	
	// Create different citizens
	
	public Object searchForCitizen(int ID) {
		Object find = null;
		for (int i = 0; i < citizenList.consultarCantidad(); i++) {
			
			Sujeto toFind = (Sujeto) citizenList.lecturaIndice(i);
			
			if (toFind.ID == ID) {
				find = toFind;
			}
		}
		return find;
	}
	
	@Override
	public String toString() {
		String respuesta = "";
		
		for (int i = 0; i < citizenList.consultarCantidad(); i++) {
			
			respuesta += "Ciudadano "+(i+1)+": "+ citizenList.lecturaIndice(i).toString() + "\n";
		}
		
		return respuesta;
	}
	
	public void createAll(int cantidad) {
		this.createAgricultor(cantidad);
		this.createCarnicero(cantidad);
		this.createCarpintero(cantidad);
		this.createHerrero(cantidad);
		this.createMaderero(cantidad);
		this.createMinero(cantidad);
		this.createPanadero(cantidad);
		this.createPastor(cantidad);
		this.createPescadero(cantidad);
		this.createPescador(cantidad);
	}
	
	public void createAgricultor(int cantidad) {
		
		for (int i = 0; i < cantidad; i++) {
			Moneda zeroMoney = new Moneda(0);
			Agricultor newCitizen = new Agricultor(IDs,30,zeroMoney,0,0,1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createCarnicero(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Moneda zeroMoney = new Moneda(0);
			Carnicero newCitizen = new Carnicero(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createCarpintero(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Moneda zeroMoney = new Moneda(0);
			Carpintero newCitizen = new Carpintero(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createHerrero(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Moneda zeroMoney = new Moneda(0);
			Herrero newCitizen = new Herrero(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createMaderero(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Moneda zeroMoney = new Moneda(0);
			Maderero newCitizen = new Maderero(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createMinero(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Moneda zeroMoney = new Moneda(0);
			Minero newCitizen = new Minero(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createPanadero(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Moneda zeroMoney = new Moneda(0);
			Panadero newCitizen = new Panadero(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createPastor(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Moneda zeroMoney = new Moneda(0);
			Pastor newCitizen = new Pastor(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createPescadero(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Moneda zeroMoney = new Moneda(0);
			Pescadero newCitizen = new Pescadero(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createPescador(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Moneda zeroMoney = new Moneda(0);
			Pescador newCitizen = new Pescador(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
}
