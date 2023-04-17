package main;

import java.util.Scanner;

import base.CitizenList;
import base.MoveController;
import base.Sujeto;
import map.Board;

public class debugLauncher {
	
	public static void main (String[] args) throws InterruptedException {
		
		Scanner sc1 = new Scanner(System.in);
		
		// Create a new map
		int height = 28;
		int width = 50;
		Board board = new Board(height, width);
		
		// Create a new list of citizens
		CitizenList listaCiudadanos = new CitizenList();
		
		// Add 10 Agricultores
		// listaCiudadanos.createAgricultor(10);
		// listaCiudadanos.addCitizensToMap(board);
		
		// System.out.println(listaCiudadanos);
		// System.out.println(board);
		
		/*
		 * Genera 8 de cada y los mueve aleatorios
		 * 
		listaCiudadanos.createAll(8);
		listaCiudadanos.addCitizensToMap(board);
		
		for (int i = 0; i < 2; i++) {
			System.out.println(board);
			Thread.sleep(1000);
			MoveController.moveAllCitizens(board, listaCiudadanos);
		}
		
		System.out.println(listaCiudadanos);
		*/
		
		listaCiudadanos.createAgricultor(1);
		listaCiudadanos.addCitizensToMap(board);
		
		String eleccion = "";
		
		do {
			System.out.println(board);
			System.out.println("Moverte con W, A, S, D");
			Sujeto toMove = (Sujeto) listaCiudadanos.searchForCitizen(1);
			eleccion = sc1.next();

			switch (eleccion) {
			case "w":
				MoveController.moveOneCitizenUp(board, toMove);
				break;
			case "s":
				MoveController.moveOneCitizenDown(board, toMove);
				break;
			case "d":
				MoveController.moveOneCitizenRight(board, toMove);
				break;
			case "a":
				MoveController.moveOneCitizenLeft(board, toMove);
				break;
			}

		} while (eleccion != "");

	}

}
