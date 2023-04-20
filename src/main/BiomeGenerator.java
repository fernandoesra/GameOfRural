package main;

import base.Tree;
import map.Board;
import resources.AcaciaTree;
import resources.AlderTree;
import resources.AspenTree;
import resources.BasswoodTree;
import resources.CedarTree;

public class BiomeGenerator {
	
	public void createForest(Board board, ResourcesList resourcesList, int forests, int density) {
		
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
				resourcesList.addGenericResource(toAdd);
				int attempts = 0;
				do {
					int numericOperandX = (int)((Math.random() * (3 - 0)) + 0);
					int numericOperandY = (int)((Math.random() * (3 - 0)) + 0);
					
					if (numericOperandX == 0) {
						randomMapX = (int)((Math.random() * (randomMapX - randomMapX)) + randomMapX);
					}
					if (numericOperandX == 1) {
						randomMapX = (int)((Math.random() * (randomMapX+1 - randomMapX)) + randomMapX);
					}
					if (numericOperandX == 2) {
						randomMapX = (int)((Math.random() * (randomMapX-1 - randomMapX)) + randomMapX);
					}
					
					if (numericOperandY == 0) {
						randomMapY = (int)((Math.random() * (randomMapY - randomMapY)) + randomMapY);
					}
					if (numericOperandY == 1) {
						randomMapY = (int)((Math.random() * (randomMapY+1 - randomMapY)) + randomMapY);
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
