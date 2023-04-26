package works;

import base.FishWater;
import base.Man;
import base.Water;
import logs.ActionsLog;
import map.Board;
import resources.Money;
import resources.RawMeat;

/**
  * A specialization of Man. The Fisherman walks through the map in search of
 * fishes to make raw meat.<br>
 * The icon for the Fisherman are 'J'.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Man
 * @see map.Board
 * @see base.FishWater
 * @see resources.RawMeat
 * 
 */

public class Fisherman extends Man{
	
	/**
	 * Do not use
	 */
	protected Fisherman() {
		super();
	}

	/**
	 * Create a new Fisherman and set the icon to 'F'.<br>
	 * The Man object create a random name automatically.
	 * 
	 * @param ID    The ID for the Fisherman.
	 * @param HP    Starting life points (HP) of the Fisherman.
	 * @param money Starting Money of the Fisherman.
	 * @param mapX  Starting height position on the Board.
	 * @param mapY  Starting width position on the Board.
	 * @param speed Starting speed of the Fisherman.
	 */
	public Fisherman(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "J"
				);
	}
	
	/**
	 * This method took a FishWater object and read his amount value. Then create a
	 * new RawMeat object with a 60% plus 1 amount value of the original value from
	 * the fish.<br>
	 * Also delete the FishWater object and fill the empty space with water.
	 * 
	 * @param board     A board to fetch the coordinates of the fish and refill with
	 *                  water.
	 * @param freshFish One fish that must be on the map.
	 * @return A new RawMeat object with.
	 */
	public RawMeat fishing(Board board, FishWater freshFish) {
		int amountMeatOnFish = freshFish.getAmount();
		RawMeat newRawMeat = new RawMeat(0);
		newRawMeat.setAmount(((int) ((amountMeatOnFish) * 0.6) + 1));
		this.addRawMeat(newRawMeat.getAmount());
		
		int mapX = board.searchXobject(freshFish);
		int mapY = board.searchYobject(freshFish);
		
		String fishName = freshFish.getName();
		board.eraseObject(freshFish);
		
		Water newWater = new Water();
		board.addSomething(newWater, mapX, mapY);
		
		ActionsLog.registerAction(this.name + "(" + this.getID() + ") has fished a " + fishName + " and obtained "
				+ newRawMeat.getAmount() + " raw meat.");

		return newRawMeat;
	}
	
	/**
	 * This method search if it already exists a RawMeat object in the inventory
	 * to add more wood planks or if not exists to create a new object and then add
	 * the amount.
	 * 
	 * @param amount Amount of RawMeat to add to the inventory of this
	 *               Fisherman.
	 */
	public void addRawMeat(int amount) {
		if (this.inventory.searchForName("Raw meat")) {
			RawMeat meatInInventory = (RawMeat) this.inventory.fetchForName("Raw meat");
			meatInInventory.setAmount(amount + meatInInventory.getAmount());
		} else {
			RawMeat meatToAdd = new RawMeat(amount);
			this.inventory.addToInventory(meatToAdd);
		}
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
