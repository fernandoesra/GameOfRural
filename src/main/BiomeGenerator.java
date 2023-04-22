package main;

import base.Tree;
import base.Water;
import map.Board;
import resources.AcaciaTree;
import resources.AlderTree;
import resources.AspenTree;
import resources.BasswoodTree;
import resources.CedarTree;

public class BiomeGenerator {
	
	public void createRiver(Board board, int rivers) {
		int mapLengthX = board.getHeight();
		int mapLengthY = board.getWidth();
		// int randomMapX = 0;
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
	
	public void createCircularForest(Board board, int forests, int density) {

		for (int i = 0; i < forests; i++) {
			int mapLengthX = board.getHeight();
			int mapLengthY = board.getWidth();
			int randomMapX = 0;
			int randomMapY = 0;

			do {
				randomMapX = (int) ((Math.random() * (mapLengthX - 0)) + 0);
				randomMapY = (int) ((Math.random() * (mapLengthY - 0)) + 0);
			} while (!board.validPosition(randomMapX, randomMapY));

			int finalMapX = randomMapX + (int)(density * 1.5);
			int finalMapY = randomMapY + (int)(density * 1.5);

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
				// resourcesList.addGenericResource(toAdd);
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
				} while (!board.validPosition(randomMapX, randomMapY) && attempts < 50);
			}
			
		}
		
	}
	
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
