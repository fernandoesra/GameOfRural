package works;

import base.Man;
import logs.ActionsLog;
import resources.MinedGold;
import resources.Money;

/**
 * A specialization of Man. The Blacksmith walks through the map in search of
 * Miners with MinedGold to melt into Money.<br>
 * The icon for the Blacksmiths are 'H'.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Man
 * @see map.Board
 * @see main.InteractController
 * @see main.MoveController
 * @see works.Miner
 * @see resources.MinedGold
 * @see resources.Money
 * 
 */

public class Blacksmith extends Man{
	
	/**
	 * Do not use
	 */
	protected Blacksmith() {
		super();
	}
	
	/**
	 * Create a new Blacksmith and set the icon to 'H'.<br>
	 * The Man object create a random name automatically.
	 * 
	 * @param ID    The ID for the Blacksmith.
	 * @param HP    Starting life points (HP) of the Blacksmith.
	 * @param money Starting Money of the Blacksmith.
	 * @param mapX  Starting height position on the Board.
	 * @param mapY  Starting width position on the Board.
	 * @param speed Starting speed of the Blacksmith.
	 */
	public Blacksmith(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "H"
				);
	}
	
	/**
	 * This method takes an object of type MinedGold to "melt" it into money. It
	 * will return a total of between 100% and 250% of the original amount.
	 * 
	 * @param gold A MinedGold object to take the amount value
	 * @return A Money object with the amount value of coins generated between the
	 *         original amount of gold and the original amount of gold*2.5
	 */
	public Money melt(MinedGold gold) {
		int minedGold = gold.getAmount();
		double amount = ((Math.random() * ((minedGold*2.6)+1 - minedGold)) + minedGold);
		Money melted = new Money(amount);
		this.addMoney(melted);
		ActionsLog.registerAction(this.name +"(" + this.ID + ")" + " melted " + minedGold + " gold in " + melted + " ruralcoins");
		return melted;
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
