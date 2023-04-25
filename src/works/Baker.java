package works;

import base.Man;
import logs.ActionsLog;
import map.Board;
import resources.Bread;
import resources.Grain;
import resources.Money;

/**
 * A specialization of Man. The Baker walks through the map in search of
 * Grain to make Bread.<br>
 * The icon for the Blacksmiths are 'B'.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Man
 * @see map.Board
 * @see main.InteractController
 * @see main.MoveController
 * @see resources.Grain
 * @see resources.Bread
 * 
 */

public class Baker extends Man{
	
	/**
	 * Do not use
	 */
	protected Baker() {
		super();
	}

	/**
	 * Create a new Baker and set the icon to 'B'.<br>
	 * The Man object create a random name automatically.
	 * 
	 * @param ID    The ID for the Baker.
	 * @param HP    Starting life points (HP) of the Baker.
	 * @param money Starting Money of the Baker.
	 * @param mapX  Starting height position on the Board.
	 * @param mapY  Starting width position on the Board.
	 * @param speed Starting speed of the Baker.
	 */
	public Baker(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "B"
				);
	}
	
	/**
	 * This method took a Grain object to read the amount value and then return a
	 * bew Bread object with the amount value equals to (grain amount / 2 +1).
	 * 
	 * @param grain A Grain object to read the amount value.
	 * @param board A board object to get the position of the grain for the
	 *              ActionsLog event.
	 * @return A new Bread object.
	 */
	public Bread makeBread(Grain grain, Board board) {
		int grainX = board.searchXobject(grain);
		int grainY = board.searchYobject(grain);
		
		int grainQuantity = grain.getAmount();
		Bread newBread = new Bread((grainQuantity/2) + 1);
		this.inventory.addToInventory(newBread);
		
		ActionsLog.registerAction(this.name + "(" + this.getID() +") made " + newBread.getAmount() + " breads "
				+ "whit the grain at (" + grainX + "." + grainY + ")");
		
		return newBread;
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
