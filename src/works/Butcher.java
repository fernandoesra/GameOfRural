package works;

import base.Animal;
import base.Man;
import logs.ActionsLog;
import map.Board;
import resources.Money;
import resources.RawMeat;

/**
 * A specialization of Man. The Butcher walks through the map in search of
 * animals to make Raw Meat.<br>
 * The icon for the Butcher are 'K'.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Man
 * @see map.Board
 * @see logs.ActionsLog
 * @see main.InteractController
 * @see main.MoveController
 * @see base.Animal
 * @see resources.RawMeat
 * 
 */

public class Butcher extends Man{
	
	/**
	 * Do not use
	 */
	protected Butcher() {
		super();
	}
	
	/**
	 * Create a new Butcher and set the icon to 'K'.<br>
	 * The Man object create a random name automatically.
	 * 
	 * @param ID    The ID for the Butcher.
	 * @param HP    Starting life points (HP) of the Butcher.
	 * @param money Starting Money of the Butcher.
	 * @param mapX  Starting height position on the Board.
	 * @param mapY  Starting width position on the Board.
	 * @param speed Starting speed of the Butcher.
	 */
	public Butcher(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "K");
	}
	
	/**
	 * 
	 * 
	 * @param board  A board to search for the animal and obtain the name.
	 * @param animal A animal that must be in the map.
	 * @return A new RawMeat object with a different amount value depending on the
	 *         animal.
	 */
	public RawMeat harvestAnimal(Board board, Animal animal) {
		RawMeat newMeat = new RawMeat(0);
		String nameOfAnimal = animal.getClass().getName();
		int totalMeatOnAnimal = 0;
		int fedAnimal = animal.getAmount();
		if (nameOfAnimal.indexOf("Pig") >= 0 ) {
			nameOfAnimal = "pig";
			
			int random = (int)((Math.random() * (16 - 8)) + 8);
			random += (fedAnimal*2);
			totalMeatOnAnimal = random;
		}
		if (nameOfAnimal.indexOf("Cow") >= 0 ) {
			nameOfAnimal = "cow";
			int random = (int)((Math.random() * (21- 10)) + 10);
			random += (fedAnimal*2);
			totalMeatOnAnimal = random;
		}
		if (nameOfAnimal.indexOf("Goat") >= 0 ) {
			nameOfAnimal = "goat";
			int random = (int)((Math.random() * (11- 5)) + 5);
			random += (fedAnimal*2);
			totalMeatOnAnimal = random;
		}
		if (nameOfAnimal.indexOf("Chicken") >= 0 ) {
			nameOfAnimal = "chicken";
			int random = (int)((Math.random() * (6- 2)) + 2);
			random += (fedAnimal*2);
			totalMeatOnAnimal = random;
		}
		newMeat.setAmount(totalMeatOnAnimal);
		
		ActionsLog.registerAction(this.getName() + "(" + this.getID() + ") has sent a " + nameOfAnimal + " to animal heaven"
				+ " and obtained " + totalMeatOnAnimal + " of raw meat.");
		
		this.inventory.addToInventory(newMeat);
		return newMeat;
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
