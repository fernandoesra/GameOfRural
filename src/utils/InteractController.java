package utils;

import base.Man;
import map.Board;
import minerals.GoldOreMineral;
import works.Miner;

public class InteractController {
	
	public static void interactSpecific(Board board, Man genericCitizen) {
		
		
		String nameOfClass = genericCitizen.getClass().getName();
		
		// Miner actions
		if (nameOfClass.indexOf("Miner") >= 0) {
			Miner actualMiner = (Miner) genericCitizen;
			int actualX = actualMiner.getMapX();
			int actualY = actualMiner.getMapY();
			
			if (!board.validPosition(actualX-1, actualY)) {
				String nameOfItem = board.getNameOfItem(actualX-1, actualY);
				if (nameOfItem.indexOf("GoldOreMineral") >= 0) {
					GoldOreMineral mineral = (GoldOreMineral) board.getObjectAt(actualX-1, actualY);
					actualMiner.crushingGoldOre(mineral);
					board.eraseObjectAt(actualX-1, actualY);
				}
				
			}
			
			if (!board.validPosition(actualX+1, actualY)) {
				String nameOfItem = board.getNameOfItem(actualX+1, actualY);
				if (nameOfItem.indexOf("GoldOreMineral") >= 0) {
					GoldOreMineral mineral = (GoldOreMineral) board.getObjectAt(actualX+1, actualY);
					actualMiner.crushingGoldOre(mineral);
					board.eraseObjectAt(actualX+1, actualY);
				}
				
			}
			
			if (!board.validPosition(actualX, actualY-1)) {
				String nameOfItem = board.getNameOfItem(actualX, actualY-1);
				if (nameOfItem.indexOf("GoldOreMineral") >= 0) {
					GoldOreMineral mineral = (GoldOreMineral) board.getObjectAt(actualX, actualY-1);
					actualMiner.crushingGoldOre(mineral);
					board.eraseObjectAt(actualX, actualY-1);
				}
				
			}
			
			if (!board.validPosition(actualX, actualY+1)) {
				String nameOfItem = board.getNameOfItem(actualX, actualY+1);
				if (nameOfItem.indexOf("GoldOreMineral") >= 0) {
					GoldOreMineral mineral = (GoldOreMineral) board.getObjectAt(actualX, actualY+1);
					actualMiner.crushingGoldOre(mineral);
					board.eraseObjectAt(actualX, actualY+1);
				}
				
			}
			
		}
		
	}

}
