package works;

import base.Man;
import gameResources.Money;
import logs.ActionsLog;
import minerales.MinedGold;

/*
 * FILL = ((Math.random() * (maxPercent - minPercent)) + minPercent);
 */

public class Blackmisth extends Man{
	
	public Blackmisth() {
		super();
	}

	public Blackmisth(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "H"
				);
	}
	
	/**
	 * This method takes an object of type MinedGold to "melt" it into money. It
	 * will return a total of between 100% and 200% of the original amount. It will
	 * also delete the MinedGold object.
	 * 
	 * @param gold A MinedGold object to take the amount value
	 * @return A Money object with the amount value of coins generated between the
	 *         amount of gold and the amount of gold*2
	 */
	public Money melt(MinedGold gold) {
		int minedGold = gold.getAmount();
		int amount = (int)((Math.random() * ((minedGold*2)+1 - minedGold)) + minedGold);
		Money melted = new Money(amount);
		gold = null;
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
		
		toReturn += "His job is to be a " + jobName;
		
		return toReturn;
	}

}
