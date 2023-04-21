package works;

import base.Furniture;
import base.Man;
import logs.ActionsLog;
import resources.Bed;
import resources.Chair;
import resources.Chest;
import resources.Money;
import resources.Table;

public class Carpenter extends Man{
	
	public Carpenter() {
		super();
	}

	public Carpenter(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "I"
				);
	}
	
	public Table createTable(Lumberjack lumberjack) {
		Table furnitureToReturn = new Table();
		String lumberjackName = lumberjack.getName();
		int lumberjackID = lumberjack.getID();
		ActionsLog.registerAction(this.name + "(" + this.ID + ") has received 6 wooden planks from " + 
		lumberjackName + "(" + lumberjackID + "), with which he has created a table.");
		return furnitureToReturn;
	}
	
	public Chair createChair(Lumberjack lumberjack) {
		Chair furnitureToReturn = new Chair();
		String lumberjackName = lumberjack.getName();
		int lumberjackID = lumberjack.getID();
		ActionsLog.registerAction(this.name + "(" + this.ID + ") has received 4 wooden planks from " + 
				lumberjackName + "(" + lumberjackID + "), with which he has created a chair.");
		return furnitureToReturn;
	}
	
	public Bed createBed(Lumberjack lumberjack) {
		Bed furnitureToReturn = new Bed();
		String lumberjackName = lumberjack.getName();
		int lumberjackID = lumberjack.getID();
		ActionsLog.registerAction(this.name + "(" + this.ID + ") has received 4 wooden planks from " + 
				lumberjackName + "(" + lumberjackID + "), with which he has created a bed.");
		return furnitureToReturn;
	}
	
	public Chest createChest(Lumberjack lumberjack) {
		Chest furnitureToReturn = new Chest();
		String lumberjackName = lumberjack.getName();
		int lumberjackID = lumberjack.getID();
		ActionsLog.registerAction(this.name + "(" + this.ID + ") has received 4 wooden planks from " + 
				lumberjackName + "(" + lumberjackID + "), with which he has created a chest.");
		return furnitureToReturn;
	}
	
	
	@Override
	public String toString() {
		String toReturn = super.toString();
		char jobChar[] = this.getClass().getName().toCharArray();
		String jobName = "";
		for (int i = 6; i < jobChar.length; i++) {
			jobName += jobChar[i];
		}
		
		toReturn += this.name + "'s job is to be a " + jobName;
		
		return toReturn;
	}

}
