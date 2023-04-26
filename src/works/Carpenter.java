package works;

import base.Man;
import logs.ActionsLog;
import resources.BedFurniture;
import resources.ChairFurniture;
import resources.ChestFurniture;
import resources.Money;
import resources.TableFurniture;

/**
 * A specialization of Man. The Carpenter walks through the map in search of
 * Lumberjacks with WoodPlanks to create new Furniture.<br>
 * The icon for the Carpenter are 'I'.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Man
 * @see map.Board
 * @see works.Lumberjack
 * @see resources.WoodPlanks
 * @see resources.BedFurniture
 * @see resources.ChairFurniture
 * @see resources.ChestFurniture
 * @see resources.TableFurniture
 * @see logs.ActionsLog
 * @see main.InteractController
 * @see main.MoveController
 *
 */

public class Carpenter extends Man{
	
	/**
	 * Do not use
	 */
	protected Carpenter() {
		super();
	}
	
	/**
	 * Create a new Carpenter and set the icon to 'I'.<br>
	 * The Man object create a random name automatically.
	 * 
	 * @param ID    The ID for the Carpenter.
	 * @param HP    Starting life points (HP) of the Carpenter.
	 * @param money Starting Money of the Carpenter.
	 * @param mapX  Starting height position on the Board.
	 * @param mapY  Starting width position on the Board.
	 * @param speed Starting speed of the Carpenter.
	 */
	public Carpenter(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "I"
				);
	}
	
	/**
	 * This method create a new Table object and with the information of this
	 * Carpenter and the information obtained from the Lumberjack create a new log
	 * for the ActionsLog.
	 * 
	 * @param lumberjack A Lumberjack object to obtain the name.
	 * @return A new Table object.
	 */
	public TableFurniture createTable(Lumberjack lumberjack) {
		TableFurniture furnitureToReturn = new TableFurniture();
		String lumberjackName = lumberjack.getName();
		int lumberjackID = lumberjack.getID();
		ActionsLog.registerAction(this.name + "(" + this.ID + ") has received 20 wooden planks from " + 
		lumberjackName + "(" + lumberjackID + "), with which he has created a table.");
		return furnitureToReturn;
	}
	
	/**
	 * This method create a new Chair object and with the information of this
	 * Carpenter and the information obtained from the Lumberjack create a new log
	 * for the ActionsLog.
	 * 
	 * @param lumberjack A Lumberjack object to obtain the name.
	 * @return A new Chair object.
	 */
	public ChairFurniture createChair(Lumberjack lumberjack) {
		ChairFurniture furnitureToReturn = new ChairFurniture();
		String lumberjackName = lumberjack.getName();
		int lumberjackID = lumberjack.getID();
		ActionsLog.registerAction(this.name + "(" + this.ID + ") has received 10 wooden planks from " + 
				lumberjackName + "(" + lumberjackID + "), with which he has created a chair.");
		return furnitureToReturn;
	}
	
	/**
	 * This method create a new Bed object and with the information of this
	 * Carpenter and the information obtained from the Lumberjack create a new log
	 * for the ActionsLog.
	 * 
	 * @param lumberjack A Lumberjack object to obtain the name.
	 * @return A new Bed object.
	 */
	public BedFurniture createBed(Lumberjack lumberjack) {
		BedFurniture furnitureToReturn = new BedFurniture();
		String lumberjackName = lumberjack.getName();
		int lumberjackID = lumberjack.getID();
		ActionsLog.registerAction(this.name + "(" + this.ID + ") has received 20 wooden planks from " + 
				lumberjackName + "(" + lumberjackID + "), with which he has created a bed.");
		return furnitureToReturn;
	}
	
	/**
	 * This method create a new Chest object and with the information of this
	 * Carpenter and the information obtained from the Lumberjack create a new log
	 * for the ActionsLog.
	 * 
	 * @param lumberjack A Lumberjack object to obtain the name.
	 * @return A new Chest object.
	 */
	public ChestFurniture createChest(Lumberjack lumberjack) {
		ChestFurniture furnitureToReturn = new ChestFurniture();
		String lumberjackName = lumberjack.getName();
		int lumberjackID = lumberjack.getID();
		ActionsLog.registerAction(this.name + "(" + this.ID + ") has received 10 wooden planks from " + 
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
