package works;

import base.Man;
import logs.ActionsLog;
import resources.MinedGold;
import resources.Money;

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
	 * will return a total of between 100% and 250% of the original amount.
	 * 
	 * @param gold A MinedGold object to take the amount value
	 * @return A Money object with the amount value of coins generated between the
	 *         amount of gold and the amount of gold*2.5
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
