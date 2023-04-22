package main;

import base.Man;
import base.Tree;
import logs.ActionsLog;
import map.Board;
import resources.Bed;
import resources.Chair;
import resources.Chest;
import resources.GoldOreMineral;
import resources.MinedGold;
import resources.Table;
import resources.WoodPlanks;
import works.Blackmisth;
import works.Carpenter;
import works.Lumberjack;
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
		
		// Lumberjack
		if (nameOfClass.indexOf("Lumberjack") >= 0) {
			interactLumberjackTree(board, genericCitizen);
			interactLumberjackFurniture(board, genericCitizen);
		}
		
		// Carpenter
		if (nameOfClass.indexOf("Carpenter") >= 0) {
			interactCarpenter(board, genericCitizen);
		}
		
		// Fisherman
		
		
		// Fishmonger
		
		
		// Farmer
		
		
		// Baker
		
		
		// Other
		
	}
	
	public static void interactCarpenter(Board board, Man genericMan) {
		Carpenter actualCarpenter = (Carpenter) genericMan;
		int actualX = actualCarpenter.getMapX();
		int actualY = actualCarpenter.getMapY();
		
		// Search up position
		if (!board.validPosition(actualX - 1, actualY) && board.inBounds(actualX - 1, actualY)) {
			String nameOfItem = board.getNameOfItem(actualX - 1, actualY);
			if (nameOfItem.indexOf("Lumberjack") >= 0) {
				
				Lumberjack adjacentLumberjack = (Lumberjack) board.getObjectAt(actualX - 1, actualY);
				int totalOfWoodPlanks = 0;
				
				// Calculate the total of wooded planks on the actual Lumberjack
				do {
					if (adjacentLumberjack.inventory.searchForName("Wood planks")) {
						WoodPlanks actualPlanks = (WoodPlanks) adjacentLumberjack.inventory.fetchForName("Wood planks");
						totalOfWoodPlanks += actualPlanks.getAmount();
						adjacentLumberjack.inventory.removeFromInventory(actualPlanks);
					}
				} while (adjacentLumberjack.inventory.searchForName("Wood planks"));
				
				// Create new furniture
				totalOfWoodPlanks = createFurniture(board, totalOfWoodPlanks, actualCarpenter, adjacentLumberjack);
			}
		}
		
		// Search down position
		if (!board.validPosition(actualX + 1, actualY) && board.inBounds(actualX + 1, actualY)) {
			String nameOfItem = board.getNameOfItem(actualX + 1, actualY);
			if (nameOfItem.indexOf("Lumberjack") >= 0) {
				
				Lumberjack adjacentLumberjack = (Lumberjack) board.getObjectAt(actualX + 1, actualY);
				int totalOfWoodPlanks = 0;
				
				// Calculate the total of wooded planks on the actual Lumberjack
				do {
					if (adjacentLumberjack.inventory.searchForName("Wood planks")) {
						WoodPlanks actualPlanks = (WoodPlanks) adjacentLumberjack.inventory.fetchForName("Wood planks");
						totalOfWoodPlanks += actualPlanks.getAmount();
						adjacentLumberjack.inventory.removeFromInventory(actualPlanks);
					}
				} while (adjacentLumberjack.inventory.searchForName("Wood planks"));
				
				// Create new furniture
				totalOfWoodPlanks = createFurniture(board, totalOfWoodPlanks, actualCarpenter, adjacentLumberjack);
			}
		}

		// Search left position
		if (!board.validPosition(actualX, actualY + 1) && board.inBounds(actualX, actualY + 1)) {
			String nameOfItem = board.getNameOfItem(actualX, actualY + 1);
			if (nameOfItem.indexOf("Lumberjack") >= 0) {
				
				Lumberjack adjacentLumberjack = (Lumberjack) board.getObjectAt(actualX, actualY + 1);
				int totalOfWoodPlanks = 0;
				
				// Calculate the total of wooded planks on the actual Lumberjack
				do {
					if (adjacentLumberjack.inventory.searchForName("Wood planks")) {
						WoodPlanks actualPlanks = (WoodPlanks) adjacentLumberjack.inventory.fetchForName("Wood planks");
						totalOfWoodPlanks += actualPlanks.getAmount();
						adjacentLumberjack.inventory.removeFromInventory(actualPlanks);
					}
				} while (adjacentLumberjack.inventory.searchForName("Wood planks"));
				
				// Create new furniture
				totalOfWoodPlanks = createFurniture(board, totalOfWoodPlanks, actualCarpenter, adjacentLumberjack);
			}
		}

		// Search right position
		if (!board.validPosition(actualX, actualY - 1) && board.inBounds(actualX, actualY - 1)) {
			String nameOfItem = board.getNameOfItem(actualX, actualY - 1);
			if (nameOfItem.indexOf("Lumberjack") >= 0) {
				
				Lumberjack adjacentLumberjack = (Lumberjack) board.getObjectAt(actualX, actualY - 1);
				int totalOfWoodPlanks = 0;
				
				// Calculate the total of wooded planks on the actual Lumberjack
				do {
					if (adjacentLumberjack.inventory.searchForName("Wood planks")) {
						WoodPlanks actualPlanks = (WoodPlanks) adjacentLumberjack.inventory.fetchForName("Wood planks");
						totalOfWoodPlanks += actualPlanks.getAmount();
						adjacentLumberjack.inventory.removeFromInventory(actualPlanks);
					}
				} while (adjacentLumberjack.inventory.searchForName("Wood planks"));
				
				// Create new furniture
				totalOfWoodPlanks = createFurniture(board, totalOfWoodPlanks, actualCarpenter, adjacentLumberjack);
			}
		}

	}
	
	public static void dismantleFurniture(Board board, int actualX, int actualY, Lumberjack actualLumberjack) {
		
		String nameOfItem = board.getNameOfItem(actualX, actualY);

		if (nameOfItem.indexOf("Chair") >= 0) {
			board.eraseObjectAt(actualX, actualY);
			ActionsLog.registerAction(actualLumberjack.getName() + "(" + actualLumberjack.getID() + ")"
					+ " dismantle a chair" + " and obtained 4 wood planks.");
			WoodPlanks woodPlanks = new WoodPlanks(4);
			actualLumberjack.inventory.addToInventory(woodPlanks);
		}

		if (nameOfItem.indexOf("Chest") >= 0) {
			board.eraseObjectAt(actualX, actualY);
			ActionsLog.registerAction(actualLumberjack.getName() + "(" + actualLumberjack.getID() + ")"
					+ " dismantle a chest" + " and obtained 4 wood planks.");
			WoodPlanks woodPlanks = new WoodPlanks(4);
			actualLumberjack.inventory.addToInventory(woodPlanks);
		}

		if (nameOfItem.indexOf("Bed") >= 0) {
			board.eraseObjectAt(actualX, actualY);
			ActionsLog.registerAction(actualLumberjack.getName() + "(" + actualLumberjack.getID() + ")"
					+ " dismantle a bed" + " and obtained 6 wood planks.");
			WoodPlanks woodPlanks = new WoodPlanks(6);
			actualLumberjack.inventory.addToInventory(woodPlanks);
		}

		if (nameOfItem.indexOf("Table") >= 0) {
			board.eraseObjectAt(actualX, actualY);
			ActionsLog.registerAction(actualLumberjack.getName() + "(" + actualLumberjack.getID() + ")"
					+ " dismantle a table" + " and obtained 6 wood planks.");
			WoodPlanks woodPlanks = new WoodPlanks(6);
			actualLumberjack.inventory.addToInventory(woodPlanks);
		}
	}
	
	public static void interactLumberjackFurniture(Board board, Man genericMan) {
		Lumberjack actualLumberjack = (Lumberjack) genericMan;
		int actualX = actualLumberjack.getMapX();
		int actualY = actualLumberjack.getMapY();
		
		// Search up position
		if (!board.validPosition(actualX - 1, actualY) && board.inBounds(actualX - 1, actualY)) {
			String nameOfSuperItem = board.getObjectAt(actualX - 1, actualY).getClass().getSuperclass().getName();
			if (nameOfSuperItem.indexOf("Furniture") >= 0) {
				dismantleFurniture(board, actualX-1,actualY,actualLumberjack);
			}
		}
		
		// Search down position
		if (!board.validPosition(actualX + 1, actualY) && board.inBounds(actualX + 1, actualY)) {
			String nameOfSuperItem = board.getObjectAt(actualX + 1, actualY).getClass().getSuperclass().getName();
			if (nameOfSuperItem.indexOf("Furniture") >= 0) {
				dismantleFurniture(board, actualX+1,actualY,actualLumberjack);
			}
		}

		// Search left position
		if (!board.validPosition(actualX, actualY + 1) && board.inBounds(actualX, actualY + 1)) {
			String nameOfSuperItem = board.getObjectAt(actualX , actualY + 1).getClass().getSuperclass().getName();
			if (nameOfSuperItem.indexOf("Furniture") >= 0) {
				dismantleFurniture(board, actualX,actualY+1,actualLumberjack);
			}
		}

		// Search right position
		if (!board.validPosition(actualX, actualY - 1) && board.inBounds(actualX, actualY - 1)) {
			String nameOfSuperItem = board.getObjectAt(actualX , actualY - 1).getClass().getSuperclass().getName();
			if (nameOfSuperItem.indexOf("Furniture") >= 0) {
				dismantleFurniture(board, actualX,actualY-1,actualLumberjack);
			}
		}

	}
	
	public static void interactLumberjackTree(Board board, Man genericMan) {
		Lumberjack actualLumberjack = (Lumberjack) genericMan;
		int actualX = actualLumberjack.getMapX();
		int actualY = actualLumberjack.getMapY();
		
		// Search up position
		if (!board.validPosition(actualX - 1, actualY) && board.inBounds(actualX - 1, actualY)) {
			String nameOfItem = board.getNameOfItem(actualX - 1, actualY);
			if (nameOfItem.indexOf("Tree")>=0) {
				Tree actualTree = (Tree) board.getObjectAt(actualX - 1, actualY);
				actualLumberjack.cutTree(actualTree);
				board.eraseObjectAt(actualX - 1 , actualY);
			}
		}
		
		// Search down position
		if (!board.validPosition(actualX + 1, actualY) && board.inBounds(actualX + 1, actualY)) {
			String nameOfItem = board.getNameOfItem(actualX + 1, actualY);
			if (nameOfItem.indexOf("Tree")>=0) {
				Tree actualTree = (Tree) board.getObjectAt(actualX + 1, actualY);
				actualLumberjack.cutTree(actualTree);
				board.eraseObjectAt(actualX + 1 , actualY);
			}
		}

		// Search left position
		if (!board.validPosition(actualX, actualY + 1) && board.inBounds(actualX, actualY + 1)) {
			String nameOfItem = board.getNameOfItem(actualX, actualY + 1);
			if (nameOfItem.indexOf("Tree")>=0) {
				Tree actualTree = (Tree) board.getObjectAt(actualX, actualY + 1);
				actualLumberjack.cutTree(actualTree);
				board.eraseObjectAt(actualX, actualY + 1);
			}
		}

		// Search right position
		if (!board.validPosition(actualX, actualY - 1) && board.inBounds(actualX, actualY - 1)) {
			String nameOfItem = board.getNameOfItem(actualX, actualY - 1);
			if (nameOfItem.indexOf("Tree")>=0) {
				Tree actualTree = (Tree) board.getObjectAt(actualX, actualY - 1);
				actualLumberjack.cutTree(actualTree);
				board.eraseObjectAt(actualX, actualY - 1);
			}
		}

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

				do {
					if (adjacentMiner.inventory.searchForName("Mined gold")) {
						MinedGold actualMine = (MinedGold) adjacentMiner.inventory.fetchForName("Mined gold");
						actualBlackmisth.melt(actualMine);
						adjacentMiner.inventory.removeFromInventory(actualMine);
					}
				} while (adjacentMiner.inventory.searchForName("Mined gold"));

			}
		}

		// Search down position
		if (!board.validPosition(actualX + 1, actualY) && board.inBounds(actualX + 1, actualY)) {
			String nameOfItem = board.getNameOfItem(actualX + 1, actualY);
			if (nameOfItem.indexOf("Miner") >= 0) {
				Miner adjacentMiner = (Miner) board.getObjectAt(actualX + 1, actualY);

				do {
					if (adjacentMiner.inventory.searchForName("Mined gold")) {
						MinedGold actualMine = (MinedGold) adjacentMiner.inventory.fetchForName("Mined gold");
						actualBlackmisth.melt(actualMine);
						adjacentMiner.inventory.removeFromInventory(actualMine);
					}
				} while (adjacentMiner.inventory.searchForName("Mined gold"));

			}
		}

		// Search left position
		if (!board.validPosition(actualX, actualY + 1) && board.inBounds(actualX, actualY + 1)) {
			String nameOfItem = board.getNameOfItem(actualX, actualY + 1);
			if (nameOfItem.indexOf("Miner") >= 0) {
				Miner adjacentMiner = (Miner) board.getObjectAt(actualX, actualY + 1);

				do {
					if (adjacentMiner.inventory.searchForName("Mined gold")) {
						MinedGold actualMine = (MinedGold) adjacentMiner.inventory.fetchForName("Mined gold");
						actualBlackmisth.melt(actualMine);
						adjacentMiner.inventory.removeFromInventory(actualMine);
					}
				} while (adjacentMiner.inventory.searchForName("Mined gold"));
			}
		}

		// Search right position
		if (!board.validPosition(actualX, actualY - 1) && board.inBounds(actualX, actualY - 1)) {
			String nameOfItem = board.getNameOfItem(actualX, actualY - 1);
			if (nameOfItem.indexOf("Miner") >= 0) {
				Miner adjacentMiner = (Miner) board.getObjectAt(actualX, actualY - 1);

				do {
					if (adjacentMiner.inventory.searchForName("Mined gold")) {
						MinedGold actualMine = (MinedGold) adjacentMiner.inventory.fetchForName("Mined gold");
						actualBlackmisth.melt(actualMine);
						adjacentMiner.inventory.removeFromInventory(actualMine);
					}
				} while (adjacentMiner.inventory.searchForName("Mined gold"));
			}
		}

	}
	
	public static int createFurniture(Board board, int totalOfWoodPlanks, Carpenter actualCarpenter,
			Lumberjack adjacentLumberjack) {
		
		do {
			// Table(6), chair (4), bed(6) and chest (4)
			int random = (int) ((Math.random() * (5 - 1)) + 1);

			if (random == 1) {
				if (totalOfWoodPlanks >= 6) {
					
					Table toAdd = actualCarpenter.createTable(adjacentLumberjack);
					int randomX = 0;
					int randomY = 0;
					int totalX = board.getHeight();
					int totalY = board.getWidth();
					do {
						randomX = (int) ((Math.random() * (totalX - 0)) + 0);
						randomY = (int) ((Math.random() * (totalY - 0)) + 0);
					} while (!board.validPosition(randomX, randomY));
					
					board.addSomething(toAdd, randomX, randomY);
					ActionsLog.registerAction("The new table is at " + randomX + "." + randomY);
					
					totalOfWoodPlanks -= 6;
					
				}
			}
			
			if (random == 2) {
				if (totalOfWoodPlanks >= 4) {
					
					Chair toAdd = actualCarpenter.createChair(adjacentLumberjack);
					int randomX = 0;
					int randomY = 0;
					int totalX = board.getHeight();
					int totalY = board.getWidth();
					do {
						randomX = (int) ((Math.random() * (totalX - 0)) + 0);
						randomY = (int) ((Math.random() * (totalY - 0)) + 0);
					} while (!board.validPosition(randomX, randomY));
					
					board.addSomething(toAdd, randomX, randomY);
					ActionsLog.registerAction("The new chair is at " + randomX + "." + randomY);
					
					totalOfWoodPlanks -= 4;
					
				}
			}
			
			if (random == 3) {
				if (totalOfWoodPlanks >= 6) {
					
					Bed toAdd = actualCarpenter.createBed(adjacentLumberjack);
					int randomX = 0;
					int randomY = 0;
					int totalX = board.getHeight();
					int totalY = board.getWidth();
					do {
						randomX = (int) ((Math.random() * (totalX - 0)) + 0);
						randomY = (int) ((Math.random() * (totalY - 0)) + 0);
					} while (!board.validPosition(randomX, randomY));
					
					board.addSomething(toAdd, randomX, randomY);
					ActionsLog.registerAction("The new bed is at " + randomX + "." + randomY);
					
					totalOfWoodPlanks -= 6;
					
				}
			}
			
			if (random == 4) {
				if (totalOfWoodPlanks >= 4) {
					
					Chest toAdd = actualCarpenter.createChest(adjacentLumberjack);
					int randomX = 0;
					int randomY = 0;
					int totalX = board.getHeight();
					int totalY = board.getWidth();
					do {
						randomX = (int) ((Math.random() * (totalX - 0)) + 0);
						randomY = (int) ((Math.random() * (totalY - 0)) + 0);
					} while (!board.validPosition(randomX, randomY));
					
					board.addSomething(toAdd, randomX, randomY);
					ActionsLog.registerAction("The new chest is at " + randomX + "." + randomY);
					
					totalOfWoodPlanks -= 4;
					
				}
			}
			
			
		} while (totalOfWoodPlanks > 4);

		if (totalOfWoodPlanks > 0) {
			WoodPlanks planksReturn = new WoodPlanks(totalOfWoodPlanks);
			adjacentLumberjack.inventory.addToInventory(planksReturn);
		}

		return totalOfWoodPlanks;
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

