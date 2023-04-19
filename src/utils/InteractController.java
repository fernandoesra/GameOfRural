package utils;

import base.Man;
import map.Board;
import minerals.GoldOreMineral;
import minerals.MinedGold;
import works.Blackmisth;
import works.Miner;

public class InteractController {
	
	public static void interactSpecific(Board board, Man genericCitizen) {
		
		String nameOfClass = genericCitizen.getClass().getName();
		
		// Miner
		if (nameOfClass.indexOf("Miner") >= 0) {
			interactMiner(board, genericCitizen);
		}

		// Blackmisth
		if (nameOfClass.indexOf("Blackmisth") >= 0) {
			interactBlackmisth(board, genericCitizen);
		}
		
		// Other
		
	}
	
	public static void interactMiner(Board board, Man genericMiner) {
		Miner actualMiner = (Miner) genericMiner;
		int actualX = actualMiner.getMapX();
		int actualY = actualMiner.getMapY();
		
		// Search for mineral at up position
		if (!board.validPosition(actualX - 1, actualY) && board.inBounds(actualX - 1, actualY)) {
			String nameOfItem = board.getNameOfItem(actualX-1, actualY);
			if (nameOfItem.indexOf("GoldOreMineral") >= 0) {
				GoldOreMineral mineral = (GoldOreMineral) board.getObjectAt(actualX-1, actualY);
				actualMiner.crushingGoldOre(mineral);
				board.eraseObjectAt(actualX-1, actualY);
			}
			
		}
		
		// Search for mineral at down position
		if (!board.validPosition(actualX + 1, actualY) && board.inBounds(actualX + 1, actualY)) {
			String nameOfItem = board.getNameOfItem(actualX+1, actualY);
			if (nameOfItem.indexOf("GoldOreMineral") >= 0) {
				GoldOreMineral mineral = (GoldOreMineral) board.getObjectAt(actualX+1, actualY);
				actualMiner.crushingGoldOre(mineral);
				board.eraseObjectAt(actualX+1, actualY);
			}
			
		}
		
		// Search for mineral at left position
		if (!board.validPosition(actualX, actualY-1) && board.inBounds(actualX, actualY - 1)) {
			String nameOfItem = board.getNameOfItem(actualX, actualY-1);
			if (nameOfItem.indexOf("GoldOreMineral") >= 0) {
				GoldOreMineral mineral = (GoldOreMineral) board.getObjectAt(actualX, actualY-1);
				actualMiner.crushingGoldOre(mineral);
				board.eraseObjectAt(actualX, actualY-1);
			}
			
		}
		
		// Search for mineral at right position
		if (!board.validPosition(actualX, actualY+1) && board.inBounds(actualX, actualY + 1)) {
			String nameOfItem = board.getNameOfItem(actualX, actualY+1);
			if (nameOfItem.indexOf("GoldOreMineral") >= 0) {
				GoldOreMineral mineral = (GoldOreMineral) board.getObjectAt(actualX, actualY+1);
				actualMiner.crushingGoldOre(mineral);
				board.eraseObjectAt(actualX, actualY+1);
			}
			
		}
	}
	
	public static void interactBlackmisth(Board board, Man genericBlackmisth) {
		Blackmisth actualBlackmisth = (Blackmisth) genericBlackmisth;
		int actualX = actualBlackmisth.getMapX();
		int actualY = actualBlackmisth.getMapY();
		
		// Search up position
		if (!board.validPosition(actualX - 1, actualY) && board.inBounds(actualX - 1, actualY)) {
			String nameOfItem = board.getNameOfItem(actualX - 1, actualY);
			if (nameOfItem.indexOf("Miner") >= 0) {
				Miner adjacentMiner = (Miner) board.getObjectAt(actualX - 1, actualY);
				
				if (adjacentMiner.inventory.searchForName("Mined gold")) {
					MinedGold actualMine = (MinedGold) adjacentMiner.inventory.fetchForName("Mined gold");
					actualBlackmisth.melt(actualMine);
					adjacentMiner.inventory.removeFromInventory(actualMine);
				}
				
			}
		}
		
		// Search down position
		if (!board.validPosition(actualX + 1, actualY) && board.inBounds(actualX + 1, actualY)) {
			String nameOfItem = board.getNameOfItem(actualX + 1, actualY);
			if (nameOfItem.indexOf("Miner") >= 0) {
				Miner adjacentMiner = (Miner) board.getObjectAt(actualX + 1, actualY);
				
				if (adjacentMiner.inventory.searchForName("Mined gold")) {
					MinedGold actualMine = (MinedGold) adjacentMiner.inventory.fetchForName("Mined gold");
					actualBlackmisth.melt(actualMine);
					adjacentMiner.inventory.removeFromInventory(actualMine);
				}
				
			}
		}

		// Search left position
		if (!board.validPosition(actualX, actualY + 1) && board.inBounds(actualX, actualY + 1)) {
			String nameOfItem = board.getNameOfItem(actualX, actualY + 1);
			if (nameOfItem.indexOf("Miner") >= 0) {
				Miner adjacentMiner = (Miner) board.getObjectAt(actualX, actualY + 1);
				
				if (adjacentMiner.inventory.searchForName("Mined gold")) {
					MinedGold actualMine = (MinedGold) adjacentMiner.inventory.fetchForName("Mined gold");
					actualBlackmisth.melt(actualMine);
					adjacentMiner.inventory.removeFromInventory(actualMine);
				}				
			}
		}

		// Search right position
		if (!board.validPosition(actualX, actualY - 1) && board.inBounds(actualX, actualY - 1)) {
			String nameOfItem = board.getNameOfItem(actualX, actualY - 1);
			if (nameOfItem.indexOf("Miner") >= 0) {
				Miner adjacentMiner = (Miner) board.getObjectAt(actualX, actualY - 1);
				
				if (adjacentMiner.inventory.searchForName("Mined gold")) {
					MinedGold actualMine = (MinedGold) adjacentMiner.inventory.fetchForName("Mined gold");
					actualBlackmisth.melt(actualMine);
					adjacentMiner.inventory.removeFromInventory(actualMine);
				}				
			}
		}

	}
	
	// Template method
	
	public static void template(Board board, Man genericMan) {
		Man actualMan = (Man) genericMan;
		int actualX = actualMan.getMapX();
		int actualY = actualMan.getMapY();
		
		// Search up position
		if (!board.validPosition(actualX - 1, actualY) && board.inBounds(actualX - 1, actualY)) {

		}
		
		// Search down position
		if (!board.validPosition(actualX + 1, actualY) && board.inBounds(actualX + 1, actualY)) {

		}

		// Search left position
		if (!board.validPosition(actualX, actualY + 1) && board.inBounds(actualX, actualY + 1)) {

		}

		// Search right position
		if (!board.validPosition(actualX, actualY - 1) && board.inBounds(actualX, actualY - 1)) {

		}

	}

}

	
