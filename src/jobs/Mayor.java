package jobs;

import base.Man;
import logs.ActionsLog;
import map.Board;
import resources.Money;

/**
 * A specialization of Man. The Mayor walks through the map in search of other
 * citizens . When found one, call the method goodDay().<br>
 * The icon for the Mayor are 'Y'.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Man
 * @see map.Board
 * @see main.InteractController
 * @see main.MoveController
 * 
 */
public class Mayor extends Man {

	/**
	 * Do not use
	 */
	protected Mayor() {
		super();
	}

	/**
	 * Create a new Mayor and set the icon to 'Y'.<br>
	 * The Man object create a random name automatically.
	 * 
	 * @param ID    The ID for the Mayor.
	 * @param HP    Starting life points (HP) of the Mayor.
	 * @param money Starting Money of the Mayor.
	 * @param mapX  Starting height position on the Board.
	 * @param mapY  Starting width position on the Board.
	 * @param speed Starting speed of the Mayor.
	 */
	public Mayor(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "Y"
				);
	}

	/**
	 * This method write a action log saying "good day" to a adjacent citizen.
	 * 
	 * @param citizen A adjacent citizen to whom to wish a good day.
	 * @param board   A board to get the name of the city for the log.
	 */
	public void goodDay(Man citizen, Board board) {
		ActionsLog.registerAction(this.name + "(" + this.ID + ") the mayor of " + board.getName() + " wishes "
				+ citizen.getName() + "(" + citizen.getID() + ") a nice day!");
	}

	@Override
	public String toString() {
		String toReturn = super.toString();
		char jobChar[] = this.getClass().getName().toCharArray();
		String jobName = "";
		for (int i = 5; i < jobChar.length; i++) {
			jobName += jobChar[i];
		}
		
		toReturn += this.name + "'s job is to be a " + jobName;
		
		return toReturn;
	}
	
	
}
