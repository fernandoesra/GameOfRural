package main;

import base.Animal;
import base.FishWater;
import base.Man;
import base.Tree;
import jobs.Baker;
import jobs.Blacksmith;
import jobs.Butcher;
import jobs.Carpenter;
import jobs.Farmer;
import jobs.Fisherman;
import jobs.Lumberjack;
import jobs.Marshal;
import jobs.Mayor;
import jobs.Miner;
import jobs.Shepherd;
import logs.ActionsLog;
import map.Board;
import resources.BedFurniture;
import resources.ChairFurniture;
import resources.ChestFurniture;
import resources.GoldOreMineral;
import resources.Grain;
import resources.MinedGold;
import resources.TableFurniture;
import resources.WoodPlanks;

/**
 * That class controll the interactions between the map and the different Man
 * objects.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Man
 * @see base.Tree
 * @see logs.ActionsLog
 * @see map.Board
 * @see resources.BedFurniture
 * @see resources.ChairFurniture
 * @see resources.ChestFurniture
 * @see resources.GoldOreMineral
 * @see resources.MinedGold
 * @see resources.TableFurniture
 * @see resources.WoodPlanks
 * @see resources.Grain
 * @see resources.Bread
 * @see base.Animal
 * @see jobs.Blacksmith
 * @see jobs.Carpenter
 * @see jobs.Lumberjack
 * @see jobs.Miner
 * @see jobs.Baker
 * @see jobs.Fisherman
 * @see jobs.Butcher
 * @see jobs.Shepherd
 * @see jobs.Farmer
 * @see jobs.Mayor
 *
 */

public class InteractController {
	
	
	private static final int posToSearch[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	
	/**
	 * This method runs over a CitizenList object and performs a interaction for
	 * each of the citizens inside using the interactSpecific() method.
	 * 
	 * @param board       The map where the citizens move and interact.
	 * @param citizenList A list with all the citizens on the map.
	 */
	public static void interactAll(Board board, CitizenList citizenList) {
		int totalCitizens = citizenList.getLength();
		for (int i = 0; i < totalCitizens; i++) {
			Man actualCitizen = (Man) citizenList.searchForCitizen(i+1);
			interactSpecific(board, actualCitizen);
		}
	}
	
	/**
	 * This method took one 'genericCitizen' and search for his className. It then
	 * moves to the specific methods of that citizen.<br>
	 * There are two types of jobs. Harvesting and Crafting.<br>
	 * All the harvesting jobs interact always first.
	 * 
	 * @param board          The map to search for different things, such as the
	 *                       surroundings of the Man.
	 * @param genericCitizen The citizen who will perform the action.
	 */
	public static void interactSpecific(Board board, Man genericCitizen) {
		
		String nameOfClass = genericCitizen.getClass().getName();
		
		/* Harvesting works: */
		
		// Shepherd
		if (nameOfClass.indexOf("Shepherd") >= 0) {
			interactShepherd(board, genericCitizen);
		}

		// Baker
		if (nameOfClass.indexOf("Baker") >= 0) {
			interactBaker(board, genericCitizen);
		}

		// Miner
		if (nameOfClass.indexOf("Miner") >= 0) {
			interactMiner(board, genericCitizen);
		}

		// Lumberjack
		if (nameOfClass.indexOf("Lumberjack") >= 0) {
			interactLumberjackTree(board, genericCitizen);
			interactLumberjackFurniture(board, genericCitizen);
		}

		// Fisherman
		if (nameOfClass.indexOf("Fisherman") >= 0) {
			interactFisherman(board, genericCitizen);
		}
		
		// Butcher
		if (nameOfClass.indexOf("Butcher") >= 0) {
			interactButcher(board, genericCitizen);
		}			
				
		/* Crafting works: */
		
		// Blackmisth
		if (nameOfClass.indexOf("Blacksmith") >= 0) {
			interactBlacksmisth(board, genericCitizen);
		}
		
		// Carpenter
		if (nameOfClass.indexOf("Carpenter") >= 0) {
			interactCarpenter(board, genericCitizen);
		}

		// Fishmonger
		//*TODO
	
		
		/* Money related works: */
		
		// Farmer
		if (nameOfClass.indexOf("Farmer") >= 0) {
			interactFarmer(board, genericCitizen);
		}
		
		// Mayor
		if (nameOfClass.indexOf("Mayor") >= 0) {
			interactMayor(board, genericCitizen);
		}
		
		// Marshal
		if (nameOfClass.indexOf("Marshal") >= 0) {
			interactMarshal(board, genericCitizen);
		}
		
		/* Others works: */
		
	}
	
	/**
	 * This method cast the genericMan to a Marshal. Then search the up, down, left
	 * and rigth coordinates for others citizens. If a citizen is found continue the
	 * method and call for beCareful() of the Marshal.
	 * 
	 * @param board      The map to search for different things, such as the
	 *                   surroundings of the Man.
	 * @param genericMan Must be a Marshal object and exists in the board.
	 * 
	 */
	public static void interactMarshal(Board board, Man genericMan) {
		Marshal actualMan = (Marshal) genericMan;
		int actualX = actualMan.getMapX();
		int actualY = actualMan.getMapY();		
		for (int i = 0; i < posToSearch.length; i++) {
			int xToLook = actualX + posToSearch[i][0];
			int yToLook = actualY + posToSearch[i][1];
			if (!board.validPosition(xToLook, yToLook) && board.inBounds(xToLook, yToLook)) {
				if (isName("jobs", board, xToLook, yToLook)) {
					Man adjacentMan = (Man) board.getObjectAt(xToLook, yToLook);
					actualMan.beCareful(adjacentMan, board);
				}
			}
		}
	}
	
	/**
	 * This method cast the genericMan to a Mayor. Then search the up, down, left
	 * and rigth coordinates for others citizens. If a citizen is found continue the
	 * method and call for goodDay() of the Mayor.
	 * 
	 * @param board      The map to search for different things, such as the
	 *                   surroundings of the Man.
	 * @param genericMan Must be a Mayor object and exists in the board.
	 * 
	 */
	public static void interactMayor(Board board, Man genericMan) {
		Mayor actualMan = (Mayor) genericMan;
		int actualX = actualMan.getMapX();
		int actualY = actualMan.getMapY();		
		for (int i = 0; i < posToSearch.length; i++) {
			int xToLook = actualX + posToSearch[i][0];
			int yToLook = actualY + posToSearch[i][1];
			if (!board.validPosition(xToLook, yToLook) && board.inBounds(xToLook, yToLook)) {
				if (isName("jobs", board, xToLook, yToLook)) {
					Man adjacentMan = (Man) board.getObjectAt(xToLook, yToLook);
					actualMan.goodDay(adjacentMan, board);
				}
			}
		}
	}
	
	/**
	 * This method cast the genericMan to a Farmer. Then search the up, down, left
	 * and rigth coordinates for others citizens. If a citizen is found continue the
	 * method and call for sellSomething() of the Farmer.
	 * 
	 * @param board      The map to search for different things, such as the
	 *                   surroundings of the Man.
	 * @param genericMan Must be a Farmer object and exists in the board.
	 * 
	 */
	public static void interactFarmer(Board board, Man genericMan) {
		Farmer actualMan = (Farmer) genericMan;
		int actualX = actualMan.getMapX();
		int actualY = actualMan.getMapY();
		for (int i = 0; i < posToSearch.length; i++) {
			int xToLook = actualX + posToSearch[i][0];
			int yToLook = actualY + posToSearch[i][1];

			if (!board.validPosition(xToLook, yToLook) && board.inBounds(xToLook, yToLook)) {
				if (isName("jobs", board, xToLook, yToLook)) {
					Man buyer = (Man) board.getObjectAt(xToLook, yToLook);
					actualMan.sellSomething(buyer);
				}
			}
		}
	}

	/**
	 * This method cast the genericMan to a Fisherman. Then search the up, down,
	 * left and rigth coordinates for fishes. If a fish is found continue the method
	 * and call for fishing() of the Fisherman.
	 * 
	 * @param board      The map to search for different things, such as the
	 *                   surroundings of the Man.
	 * @param genericMan Must be a Fisherman object and exists in the board.
	 * 
	 */
	public static void interactFisherman(Board board, Man genericMan) {
		Fisherman actualMan = (Fisherman) genericMan;
		int actualX = actualMan.getMapX();
		int actualY = actualMan.getMapY();
		for (int i = 0; i < posToSearch.length; i++) {
			int xToLook = actualX + posToSearch[i][0];
			int yToLook = actualY + posToSearch[i][1];

			if (!board.validPosition(xToLook, yToLook) && board.inBounds(xToLook, yToLook)) {
				if (isName("FishWater", board, xToLook, yToLook)) {
					FishWater toFish = (FishWater) board.getObjectAt(xToLook, yToLook);
					actualMan.fishing(board, toFish);
				}
			}
		}
	}

	/**
	 * This method cast the genericMan to a Shepherd. Then search the up, down, left
	 * and rigth coordinates for animals. If a animal is found continue the method
	 * and call for feedAnimal() of the Shepherd.
	 * 
	 * @param board      The map to search for different things, such as the
	 *                   surroundings of the Man.
	 * @param genericMan Must be a Shepherd object and exists in the board.
	 */
	public static void interactShepherd(Board board, Man genericMan) {
		Shepherd actualMan = (Shepherd) genericMan;
		int actualX = actualMan.getMapX();
		int actualY = actualMan.getMapY();
		for (int i = 0; i < posToSearch.length; i++) {
			int xToLook = actualX + posToSearch[i][0];
			int yToLook = actualY + posToSearch[i][1];

			if (!board.validPosition(xToLook, yToLook) && board.inBounds(xToLook, yToLook)) {
				if (isName("Animal", board, xToLook, yToLook)) {
					Animal toFeed = (Animal) board.getObjectAt(xToLook, yToLook);
					actualMan.feedAnimal(board, toFeed);
				}
			}
		}
	}

	/**
	 * This method cast the genericMan to a Butcher. Then search the up, down, left
	 * and rigth coordinates for animals. If a animal is found continue the method
	 * and call for harvestAnimal() of the Butcher.
	 * 
	 * @param board      The map to search for different things, such as the
	 *                   surroundings of the Man.
	 * @param genericMan Must be a Butcher object and exists in the board.
	 * 
	 */
	public static void interactButcher(Board board, Man genericMan) {
		Butcher actualMan = (Butcher) genericMan;
		int actualX = actualMan.getMapX();
		int actualY = actualMan.getMapY();
		for (int i = 0; i < posToSearch.length; i++) {
			int xToLook = actualX + posToSearch[i][0];
			int yToLook = actualY + posToSearch[i][1];

			if (!board.validPosition(xToLook, yToLook) && board.inBounds(xToLook, yToLook)) {
				if (isName("Animal", board, xToLook, yToLook)) {
					Animal toHarvest = (Animal) board.getObjectAt(xToLook, yToLook);
					actualMan.harvestAnimal(board, toHarvest);
					board.eraseObject(toHarvest);
				}
			}
		}
	}
	
	/**
	 * This method cast the genericMan to a Baker. Then search the up, down, left
	 * and rigth coordinates for Grain. If a Grain is found continue the method
	 * calling the makeBread() method from the Baker.
	 * 
	 * @param board      The map to search for different things, such as the
	 *                   surroundings of the Man.
	 * @param genericMan Must be a Baker object and exists in the board.
	 * 
	 */
	public static void interactBaker(Board board, Man genericMan) {
		
		Baker actualBaker = (Baker) genericMan;
		int actualX = actualBaker.getMapX();
		int actualY = actualBaker.getMapY();
		for (int i = 0; i < posToSearch.length; i++) {
			int xToLook = actualX + posToSearch[i][0];
			int yToLook = actualY + posToSearch[i][1];

			if (!board.validPosition(xToLook, yToLook) && board.inBounds(xToLook, yToLook)) {
				if (isName("Grain", board, xToLook, yToLook)) {
					Grain actualGrain = (Grain) board.getObjectAt(xToLook, yToLook);
					actualBaker.makeBread(actualGrain, board);
					board.eraseObjectAt(xToLook, yToLook);
				}
			}
		}
	}
	
	/**
	 * This method cast the genericMan to a Carpenter. Then search the up, down,
	 * left and rigth coordinates for a Lumberjack. If a Lumberjack is found
	 * continue the method.
	 * <p>
	 * If a Lumberjack is found then the Carpenter take all the WoodPlanks object
	 * (if any) and calculate the amount of wood in total.<br>
	 * Then, whit that wood planks call the createFurniture() method.
	 * 
	 * @param board      The map to search for different things, such as the
	 *                   surroundings of the Man.
	 * @param genericMan Must be a Carpenter object and exists in the board.
	 */
	public static void interactCarpenter(Board board, Man genericMan) {
		
		Carpenter actualMan = (Carpenter) genericMan;
		int actualX = actualMan.getMapX();
		int actualY = actualMan.getMapY();
		for (int i = 0; i < posToSearch.length; i++) {
			int xToLook = actualX + posToSearch[i][0];
			int yToLook = actualY + posToSearch[i][1];

			if (!board.validPosition(xToLook, yToLook) && board.inBounds(xToLook, yToLook)) {
				if (isName("Lumberjack", board, xToLook, yToLook)) {
					
					Lumberjack adjacentLumberjack = (Lumberjack) board.getObjectAt(xToLook, yToLook);
					int totalOfWoodPlanks = 0;

					// Calculate the total of wooded planks on the actual Lumberjack
					do {
						if (adjacentLumberjack.inventory.searchForName("Wood planks")) {
							WoodPlanks actualPlanks = (WoodPlanks) adjacentLumberjack.inventory
									.fetchForName("Wood planks");
							totalOfWoodPlanks += actualPlanks.getAmount();
							adjacentLumberjack.inventory.removeFromInventory(actualPlanks);
						}
					} while (adjacentLumberjack.inventory.searchForName("Wood planks"));

					// Create new furniture
					totalOfWoodPlanks = createFurniture(board, totalOfWoodPlanks, actualMan, adjacentLumberjack);
				}
			}
		}
	}
	
	/**
	 * This metod scan the up, down, left and right coordinates of the Lumberjack
	 * and if find a base.Furniture object inside call the method
	 * dismantleFurniture().
	 * 
	 * @param board      The board with the map to search for furnitures in the
	 *                   surroundings of the Lumberjack.
	 * @param genericMan Must be a Lumberjack object and exists in the board.
	 */
	public static void interactLumberjackFurniture(Board board, Man genericMan) {
		Lumberjack actualMan = (Lumberjack) genericMan;
		int actualX = actualMan.getMapX();
		int actualY = actualMan.getMapY();
		for (int i = 0; i < posToSearch.length; i++) {
			int xToLook = actualX + posToSearch[i][0];
			int yToLook = actualY + posToSearch[i][1];

			if (!board.validPosition(xToLook, yToLook) && board.inBounds(xToLook, yToLook)) {
				if (isName("Furniture", board, xToLook, yToLook)) {
					actualMan.dismantleFurniture(board, xToLook, yToLook, actualMan);
				}
			}
		}
	}
	
	/**
	 * This metod scan the up, down, left and right coordinates of the Lumberjack
	 * and if find a base.Tree object inside call the Lumberjack.cutTree() method.
	 * 
	 * @param board      The board with the map to search for trees in the
	 *                   surroundings of the Lumberjack.
	 * @param genericMan Must be a Lumberjack object and exists in the board.
	 */
	public static void interactLumberjackTree(Board board, Man genericMan) {
		Lumberjack actualMan = (Lumberjack) genericMan;
		int actualX = actualMan.getMapX();
		int actualY = actualMan.getMapY();
		for (int i = 0; i < posToSearch.length; i++) {
			int xToLook = actualX + posToSearch[i][0];
			int yToLook = actualY + posToSearch[i][1];

			if (!board.validPosition(xToLook, yToLook) && board.inBounds(xToLook, yToLook)) {
				if (isName("Tree", board, xToLook, yToLook)) {
					Tree actualTree = (Tree) board.getObjectAt(xToLook, yToLook);
					
					actualMan.cutTree(actualTree);
					
					board.eraseObjectAt(xToLook, yToLook);
				}
			}
		}
	}
	
	/**
	 * This metod scan the up, down, left and right coordinates of the Miner and if
	 * find a mineral inside call the Miner.crushingMineral() method.
	 * 
	 * @param board        The board with the map to search for minerals in the
	 *                     surroundings of the Miner.
	 * @param genericMan Must be a Miner object and exists in the board.
	 */
	public static void interactMiner(Board board, Man genericMan) {
		Miner actualMan = (Miner) genericMan;
		int actualX = actualMan.getMapX();
		int actualY = actualMan.getMapY();
		for (int i = 0; i < posToSearch.length; i++) {
			int xToLook = actualX + posToSearch[i][0];
			int yToLook = actualY + posToSearch[i][1];

			if (!board.validPosition(xToLook, yToLook) && board.inBounds(xToLook, yToLook)) {
				if (isName("GoldOreMineral", board, xToLook, yToLook)) {
					GoldOreMineral mineral = (GoldOreMineral) board.getObjectAt(xToLook, yToLook);
					actualMan.crushingGoldOre(mineral);
					board.eraseObjectAt(xToLook, yToLook);
				}
			}
		}
	}
	
	/**
	 * This metod scan the up, down, left and right coordinates of the Blacksmith
	 * and if find a Miner inside search for Mined gold in the miner inventory. If
	 * the miner have mined gold then the Blacksmith took that mined gold and melts
	 * them using the Blacksmith.melt() method.
	 * 
	 * @param board             The board with the map to search for Miners in the
	 *                          surroundings of the Blacksmith.
	 * @param genericMan Must be a Blacksmith object and exists in the board.
	 */
	public static void interactBlacksmisth(Board board, Man genericMan) {
		Blacksmith actualMan = (Blacksmith) genericMan;
		int actualX = actualMan.getMapX();
		int actualY = actualMan.getMapY();
		for (int i = 0; i < posToSearch.length; i++) {
			int xToLook = actualX + posToSearch[i][0];
			int yToLook = actualY + posToSearch[i][1];

			if (!board.validPosition(xToLook, yToLook) && board.inBounds(xToLook, yToLook)) {
				if (isName(".Miner", board, xToLook, yToLook)) {
					Miner adjacentMiner = (Miner) board.getObjectAt(xToLook, yToLook);
					do {
						if (adjacentMiner.inventory.searchForName("Mined gold")) {
							MinedGold actualMine = (MinedGold) adjacentMiner.inventory.fetchForName("Mined gold");
							actualMan.melt(actualMine);
							adjacentMiner.inventory.removeFromInventory(actualMine);
						}
					} while (adjacentMiner.inventory.searchForName("Mined gold"));
				}
			}
		}
	}
	
	/**
	 * This method fill the map with random furniture. Only create furniture if have
	 * enough wood planks to create the next items:<br>
	 * <b>4 wooden planks: </b>1 chair or 1 chest<br>
	 * <b>6 wooden planks: </b>1 table or 1 bed<br>
	 * 
	 * 
	 * @param board              The map to fill with furniture.
	 * @param totalOfWoodPlanks  The total of wooden planks the adjacentLumberjack
	 *                           have.
	 * @param actualCarpenter    The carpenter doing the action.
	 * @param adjacentLumberjack Its necessary to register the adjacentLumberjack in
	 *                           case of leftover wood planks to return.
	 * @return
	 */
	public static int createFurniture(Board board, int totalOfWoodPlanks, Carpenter actualCarpenter,
			Lumberjack adjacentLumberjack) {

		do {
			// Table(6), chair (4), bed(6) and chest (4)
			int random = (int) ((Math.random() * (5 - 1)) + 1);

			if (random == 1) {
				if (totalOfWoodPlanks >= 20) {

					TableFurniture toAdd = actualCarpenter.createTable(adjacentLumberjack);
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

					totalOfWoodPlanks -= 20;

				}
			}

			if (random == 2) {
				if (totalOfWoodPlanks >= 10) {

					ChairFurniture toAdd = actualCarpenter.createChair(adjacentLumberjack);
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

					totalOfWoodPlanks -= 10;

				}
			}

			if (random == 3) {
				if (totalOfWoodPlanks >= 20) {

					BedFurniture toAdd = actualCarpenter.createBed(adjacentLumberjack);
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

					totalOfWoodPlanks -= 20;

				}
			}

			if (random == 4) {
				if (totalOfWoodPlanks >= 10) {

					ChestFurniture toAdd = actualCarpenter.createChest(adjacentLumberjack);
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

					totalOfWoodPlanks -= 10;

				}
			}

		} while (totalOfWoodPlanks > 10);

		if (totalOfWoodPlanks > 0) {
			WoodPlanks planksReturn = new WoodPlanks(totalOfWoodPlanks);
			adjacentLumberjack.inventory.addToInventory(planksReturn);
		}

		return totalOfWoodPlanks;
	}

	
	/**
	 * Search if on object have the specific name.
	 * 
	 * @param name  A name to search on the className
	 * @param board A map to fetch the name
	 * @param mapX  X position of the object
	 * @param mapY  Y position of the object
	 * @return <b>True</b> if the object have the name, <b>false</b> if not.
	 */
	public static boolean isName(String name, Board board, int mapX, int mapY) {
		boolean find = false;
		String nameOfItem = board.getNameOfItem(mapX, mapY);
		if (nameOfItem.indexOf(name) >= 0) {
			find = true;
		}
		return find;
	}

	/**
	 * This method is a template. <b>It does nothing, do not use it.</b>
	 * <p>
	 * Array used to fetch different positions:<br>
	 * <b>posToSearch[][]</b> = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	 * 
	 * @param board      The map to search for different things, such as the
	 *                   surroundings of the Man.
	 * @param genericMan Must be a base.Man object.
	 */
	public static void template(Board board, Man genericMan) {
		Man actualMan = (Man) genericMan;
		int actualX = actualMan.getMapX();
		int actualY = actualMan.getMapY();
		for (int i = 0; i < posToSearch.length; i++) {
			int xToLook = actualX + posToSearch[i][0];
			int yToLook = actualY + posToSearch[i][1];

			if (!board.validPosition(xToLook, yToLook) && board.inBounds(xToLook, yToLook)) {
				if (isName("SEARCH", board, xToLook, yToLook)) {
					
				}
			}
		}
	}

	/**
	 * This method is a template. <b>It does nothing, do not use it.</b>
	 * 
	 * @param board      The map to search for different things, such as the
	 *                   surroundings of the Man.
	 * @param genericMan Must be a base.Man object.
	 */
	@Deprecated
	public static void templateOLD(Board board, Man genericMan) {
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
