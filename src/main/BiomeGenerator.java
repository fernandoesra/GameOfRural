package main;

import base.Tree;
import base.Water;
import map.Board;
import resources.AcaciaTree;
import resources.AlderTree;
import resources.AspenTree;
import resources.BasswoodTree;
import resources.CedarTree;

/**
 * The methods of this object take a board and fill it with different kind of
 * objects like trees for the forest or water for the rivers.<br>
 * This object controlls the behavior of the algorithms used to generate the
 * different biomes.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see map.Board
 * @see base.Tree
 * @see base.Water
 * 
 */

public class BiomeGenerator {
	
	/**
	 * 
	 * This algorithm fill the map with differents rivers.
	 * <p>
	 * 
	 * <b>Algorithm flow:</b><br>
	 * <b>- </b>First generate a random valid coordinate just on the height of the
	 * map (x). That generate a coordinate like (random).(0) to start.<br>
	 * 
	 * <b>- </b>Then, starting at this coordinate, it will begin to fill coordinates
	 * with water objects and move the Y value (width) in 1. There is a 10% chance
	 * that a coordinate is not filled with water and remains empty.<br>
	 * 
	 * <b>- </b>Then there is a chance of 80% to fill with water the lower
	 * coordinate (x-1).(y) to create wider rivers.<br>
	 * 
	 * <b>- </b>Then there is a 20% chance to create a "border" up and a "border"
	 * down. A border is a (x-2) or (x+1) water tile. That will create more random
	 * rivers.<br>
	 * 
	 * <b>- </b>Lastly the algorithm try to change the "center" of the river. The
	 * actual center is the 'x' value. Will attempt, with a 10% probability to
	 * change up (x-1). If not, will try with a 10% probability to change down
	 * (x+1).
	 * 
	 * 
	 * @param board  The map that we want to fill with rivers
	 * @param rivers The quantity of rivers to generate
	 */
	public void createRiver(Board board, int rivers) {
		int mapLengthX = board.getHeight();
		int mapLengthY = board.getWidth();
		int MapY = 0;
		for (int i = 0; i < rivers; i++) {
			
			int riverActualX = (int)((Math.random() * (mapLengthX-1 - 0)) + 0);
			
			for (int j = 0; j < mapLengthY; j++) {
				Water fillWater = new Water();
				
				int mainRiver = (int)((Math.random() * (101 - 0)) + 0);
				if (mainRiver <= 90) {
					if (board.inBounds(riverActualX, MapY+j)) {
						board.addSomething(fillWater, riverActualX, MapY+j);
					}
				}
				
				int doubleRiver = (int)((Math.random() * (101 - 0)) + 0);
				if (doubleRiver <= 80) {
					if (board.inBounds(riverActualX-1,  MapY+j)) {
						board.addSomething(fillWater, riverActualX-1, MapY+j);
					}
				}
				
				int borderUp = (int)((Math.random() * (101 - 0)) + 0);
				if (borderUp <= 20) {
					if (board.inBounds(riverActualX-2, MapY+j)) {
						board.addSomething(fillWater, riverActualX-2, MapY+j);
					}
				}
				
				int borderDown = (int)((Math.random() * (101 - 0)) + 0);
				if (borderDown <= 20) {
					if (board.inBounds(riverActualX+1, MapY+j)) {
						board.addSomething(fillWater, riverActualX+1, MapY+j);
					}
				}
				
				int moveRiverCenterUp = (int)((Math.random() * (101 - 0)) + 0);
				if (moveRiverCenterUp <= 10) {
					if (board.inBounds(riverActualX-1, MapY+j)) {
						riverActualX -= 1;
					}
				} else {
					int moveRiverCenterDown = (int)((Math.random() * (101 - 0)) + 0);
					if (moveRiverCenterDown<=10) {
						if (board.inBounds(riverActualX+1, MapY+j)) {
							riverActualX += 1;
						}
					}
				}
			}
			
			// Generate bridges
			int totalBridges = 0;
			do {
				for (int j = 0; j < mapLengthY; j++) {

					int actualBridge = (int) ((Math.random() * (101 - 0)) + 0);
					if (actualBridge <= 5) {

						for (int k = 0; k < mapLengthX; k++) {
							if (board.inBounds(k, j)) {
								board.eraseObjectAt(k, j);
							}
						}
						totalBridges++;
					}

				}
			} while (totalBridges < 2);
			
		}
		
	}
	
	/**
	 * This method generate 'x' trees and random coordinates to place them.
	 * 
	 * @param board  The map that we want to fill with trees
	 * @param amount The quantity of trees to generate
	 */
	public void createRandomTrees(Board board, int amount) {
		int mapLengthX = board.getHeight();
		int mapLengthY = board.getWidth();
		int randomMapX = 0;
		int randomMapY = 0;
		
		for (int i = 0; i < amount; i++) {
			do {
				randomMapX = (int) ((Math.random() * (mapLengthX - 0)) + 0);
				randomMapY = (int) ((Math.random() * (mapLengthY - 0)) + 0);
			} while (!board.validPosition(randomMapX, randomMapY));
			Tree toAdd = generateTree();
			board.addSomething(toAdd, randomMapX, randomMapY);
		}
	}
	
	/**
	 * This algorithm fill the map with differents forests. The generated forests
	 * will have a "circular" (rather square) shape. The trees are generated with
	 * the generateTree() method.
	 * 
	 * <p>
	 * <b>Algorithm flow:</b><br>
	 * 
	 * <b>- </b>First the algorithm create a 'virtual' square to define the limites.
	 * To do this, generate a random valid coordinates. For example (15).(15). Then
	 * generate other coordinate with the value of the generate coordinate plus the
	 * value of the (density * 1.5). For example, is the density is 2 the result is
	 * (18).(18). So the algorithm will traverse through the following
	 * positions:<br>
	 * --------------------------------------------<br>
	 * (15).(15) |(15).(16) | (15).(17) | (15).(18)<br>
	 * (16).(15) |(16).(16) | (16).(17) | (16).(18)<br>
	 * (17).(15) |(17).(16) | (17).(17) | (17).(18)<br>
	 * (18).(15) |(18).(16) | (18).(17) | (18).(18)<br>
	 * --------------------------------------------
	 * <p>
	 * <b>- </b>The start to fill the coordinates with a double 'for' bucle. If the
	 * value of the counters are 1 (so the program is on the exterior of the matrix)
	 * there is only 10% of probability to fill that coordinate with a tree.<br>
	 * 
	 * <b>- </b>If the value of the counters are 3 or less, the probability to fill
	 * its 30%.
	 * <b>- </b>For the rest of the algorimth the prbability its 75%.
	 * 
	 * @param board   The map that we want to fill with forests
	 * @param forests The ammount of forest to generate
	 * @param density How big is the forest
	 */
	public void createCircularForest(Board board, int forests, int density) {

		for (int i = 0; i < forests; i++) {
			int mapLengthX = board.getHeight();
			int mapLengthY = board.getWidth();
			int randomMapX = 0;
			int randomMapY = 0;
			int finalMapX = 0;
			int finalMapY = 0;

			do {
				randomMapX = (int) ((Math.random() * (mapLengthX - 0)) + 0);
				randomMapY = (int) ((Math.random() * (mapLengthY - 0)) + 0);
				
				finalMapX = randomMapX + (int)(density * 1.5);
				finalMapY = randomMapY + (int)(density * 1.5);
				
			} while (!board.validPosition(finalMapX, finalMapY));

			for (int x = randomMapX; x < finalMapX; x++) {
				for (int y = randomMapY; y < finalMapY; y++) {

					if (board.validPosition(x, y)) {
						int random = (int) ((Math.random() * (101 - 0)) + 0);

						if (x <= randomMapX + 1 || y <= randomMapY + 1) {
							if (random <= 10) {
								Tree toAdd = generateTree();
								board.addSomething(toAdd, x, y);
							}
						} else if (x <= randomMapX + 3  || y <= randomMapY + 3) {
							if (random <= 30) {
								Tree toAdd = generateTree();
								board.addSomething(toAdd, x, y);
							}
						} else {
							
							if (random <= 75) {
								Tree toAdd = generateTree();
								board.addSomething(toAdd, x, y);
							}
						}

					}

				}
			}

		}

	}
	
	/**
	 * This algorithm fill the map with differents forests. The generated forests
	 * will have a semi-random shape but following some rules. The trees are
	 * generated with the generateTree() method.
	 * <p>
	 * <b>- </b>Starting from the generate position the algorithm start fill the
	 * map with trees. When a position its filled then generate a new position with
	 * different values. For both X and Y coordinates its possible to alterate this
	 * coordinate with 3 values (+1,0,-1) this will result in a modified coordinate
	 * like:<br>
	 * <b>Original coordinate:</b> (15.15)<br>
	 * <b>Possible coordinates:</b>
	 * (14.14),(14.15),(14.16),
	 * (15.14),(15.15),(15.16),
	 * (16.14),(16.15),(16.16).<br>
	 * <b>- </b>The algorimth continue doing this (density*2) times.
	 * 
	 * 
	 * @param board   The map that we want to fill with forests
	 * @param forests The ammount of forest to generate
	 * @param density How big is the forest
	 */
	public void createNonCircularForest(Board board, int forests, int density) {
		
		for (int i = 0; i < forests; i++) {
			
			int mapLengthX = board.getHeight();
			int mapLengthY = board.getWidth();
			int randomMapX = 0;
			int randomMapY = 0;
			
			do {
				randomMapX = (int)((Math.random() * (mapLengthX - 0)) + 0);
				randomMapY = (int)((Math.random() * (mapLengthY - 0)) + 0);
			} while (!board.validPosition(randomMapX, randomMapY));
			
			for (int j = 0; j < density*2; j++) {
				Tree toAdd = generateTree();
				board.addSomething(toAdd, randomMapX, randomMapY);
				int attempts = 0;
				do {
					int numericOperandX = (int)((Math.random() * (3 - 0)) + 0);
					int numericOperandY = (int)((Math.random() * (3 - 0)) + 0);
					
					if (numericOperandX == 0) {
						randomMapX = (int)((Math.random() * (randomMapX+1 - randomMapX)) + randomMapX);
					}
					if (numericOperandX == 1) {
						randomMapX = (int)((Math.random() * (randomMapX+2 - randomMapX)) + randomMapX);
					}
					if (numericOperandX == 2) {
						randomMapX = (int)((Math.random() * (randomMapX-1 - randomMapX)) + randomMapX);
					}
					
					if (numericOperandY == 0) {
						randomMapY = (int)((Math.random() * (randomMapY+1 - randomMapY)) + randomMapY);
					}
					if (numericOperandY == 1) {
						randomMapY = (int)((Math.random() * (randomMapY+2 - randomMapY)) + randomMapY);
					}
					if (numericOperandY == 2) {
						randomMapY = (int)((Math.random() * (randomMapY-1 - randomMapY)) + randomMapY);
					}
					attempts++;
				} while (!board.validPosition(randomMapX, randomMapY) && attempts < (density*10));
			}
			
		}
		
	}
	
	/**
	 * This method generate different type of trees. It is base on the idea that we
	 * have different trees, not just a basic Tree object. For example Acacia,
	 * Alder, Aspen, Basswood, Cedar... The only different attribute between the an
	 * tree object and another tree object its the name.
	 * 
	 * @return A Tree object of random type.
	 */
	public Tree generateTree() {
		Tree newTree = new Tree("");
		int randomTree = (int)((Math.random() * (5+1 - 1)) + 1);
		if (randomTree == 1) {
			newTree = new AcaciaTree();
		}
		if (randomTree == 2) {
			newTree = new AlderTree();
		}
		if (randomTree == 3) {
			newTree = new AspenTree();
		}
		if (randomTree == 4) {
			newTree = new BasswoodTree();
		}
		if (randomTree == 5) {
			newTree = new CedarTree();
		}
		
		return newTree;
	}

}
