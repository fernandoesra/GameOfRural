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
import recursos.Money;
import utils.ListaObjetos;

public class CitizenList {
	
	// List
	public ListaObjetos citizenList = new ListaObjetos();
	int IDs;
	
	// Constructor
	public CitizenList() {
		super();
		IDs = 1;
	}
	
	public int consultarCantidad() {
		int cantidad = citizenList.consultarCantidad();
		return cantidad;
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
			Man a1 = (Man)citizenList.lecturaIndice(i);
			a1.setMapX(tryMapX);
			a1.setMapY(tryMapY);

		}
	}
	
	/**
	 * 
	 * @param ID to search
	 * @return If the citizen with the ID are on the list, return that citizen
	 */
	public Object searchForCitizen(int ID) {
		Object find = null;
		for (int i = 0; i < citizenList.consultarCantidad(); i++) {
			
			Man toFind = (Man) citizenList.lecturaIndice(i);
			
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
			
			respuesta += "Citizen "+(i+1)+": "+ citizenList.lecturaIndice(i).toString() + "\n";
		}
		
		return respuesta;
	}
	
	public String getInfoID(int ID) {
		String info = "";
		
		if ((Man)this.searchForCitizen(ID) != null) {
			Man search = (Man)this.searchForCitizen(ID);
			info = search.toString();
		}
		return info;
	}
	
	public int getCitizenID(Man search) {
		int ID = 0;
		for (int i = 0; i < citizenList.consultarCantidad(); i++) {
			if (citizenList.lecturaIndice(i) == search) {
				Man find = (Man) citizenList.lecturaIndice(i);
				ID = find.ID;
			}
		}
		return ID;
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
			Money zeroMoney = new Money(0);
			Agricultor newCitizen = new Agricultor(IDs,30,zeroMoney,0,0,1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createCarnicero(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Money zeroMoney = new Money(0);
			Carnicero newCitizen = new Carnicero(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createCarpintero(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Money zeroMoney = new Money(0);
			Carpintero newCitizen = new Carpintero(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createHerrero(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Money zeroMoney = new Money(0);
			Herrero newCitizen = new Herrero(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createMaderero(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Money zeroMoney = new Money(0);
			Maderero newCitizen = new Maderero(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createMinero(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Money zeroMoney = new Money(0);
			Minero newCitizen = new Minero(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createPanadero(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Money zeroMoney = new Money(0);
			Panadero newCitizen = new Panadero(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createPastor(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Money zeroMoney = new Money(0);
			Pastor newCitizen = new Pastor(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createPescadero(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Money zeroMoney = new Money(0);
			Pescadero newCitizen = new Pescadero(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
	public void createPescador(int cantidad) {

		for (int i = 0; i < cantidad; i++) {
			Money zeroMoney = new Money(0);
			Pescador newCitizen = new Pescador(IDs, 30, zeroMoney, 0, 0, 1);
			citizenList.addFinal(newCitizen);
			IDs++;
		}
	}
	
}
