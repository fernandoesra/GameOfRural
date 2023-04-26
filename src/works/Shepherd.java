package works;

import base.Animal;
import base.Man;
import logs.ActionsLog;
import map.Board;
import resources.Money;

/**
 * A specialization of Man. The Shepherd walks through the map in search of
 * Animals to feed.
 * The icon for the Shepherd are 'S'.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Man
 * @see map.Board
 * @see main.InteractController
 * @see main.MoveController
 * @see base.Animal
 * 
 */

public class Shepherd extends Man{
	
	/**
	 * Do not use
	 */
	protected Shepherd() {
		super();
	}

	/**
	 * Create a new Shepherd and set the icon to 'S'.<br>
	 * The Man object create a random name automatically.
	 * 
	 * @param ID    The ID for the Shepherd.
	 * @param HP    Starting life points (HP) of the Shepherd.
	 * @param money Starting Money of the Shepherd.
	 * @param mapX  Starting height position on the Board.
	 * @param mapY  Starting width position on the Board.
	 * @param speed Starting speed of the Shepherd.
	 */
	public Shepherd(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "S"
				);
	}
	
	/**
	 * The sheperd feed the animal with a random value of grain between 1 and 10.
	 * 
	 * @param board        A board to search for the coordinates of the animal.
	 * @param actualAnimal The animal to feed.
	 */
	public void feedAnimal(Board board, Animal actualAnimal) {
		int mapX = board.searchXobject(actualAnimal);
		int mapY = board.searchYobject(actualAnimal);
		int feedAmount = (int) ((Math.random() * (11 - 1)) + 1);
		int totalToFeed = actualAnimal.getAmount() + feedAmount;
		actualAnimal.setAmount(totalToFeed);
		String animalName = actualAnimal.getName();

		ActionsLog.registerAction(this.name + "(" + this.getID() + ") has fed the " + animalName + "" + " in (" + mapX
				+ "." + mapY + ") with " + feedAmount + " of grain.");
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
