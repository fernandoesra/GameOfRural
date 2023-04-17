package main;

import base.CitizenList;
import map.Board;

public class realLauncher {
	
	public static void main (String[] args) {
		
		// Create a new map
		int height = 28;
		int width = 50;
		Board board = new Board(height, width);
		
		// Create a new list of citizens
		CitizenList listaCiudadanos = new CitizenList();
		
		// Add 10 Agricultores
		listaCiudadanos.createAgricultor(10);
		listaCiudadanos.addCitizensToMap(board);
		
		System.out.println(listaCiudadanos);
		System.out.println(board);
		
		
	}

}
