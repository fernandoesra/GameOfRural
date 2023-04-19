package personas;

import base.Man;
import logs.ActionsLog;
import minerales.GoldOreMineral;
import recursos.Money;

/*
 * FILL = ((Math.random() * (maxPercent - minPercent)) + minPercent);
 */

public class Herrero extends Man{
	
	public Herrero() {
		super();
	}

	public Herrero(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "H"
				);
	}
	
	public Money melt(GoldOreMineral oro) {
		int pureGold = oro.getAmount();
		int amount = (int)((Math.random() * ((pureGold*2)+1 - pureGold)) + pureGold);
		Money melted = new Money(amount);
		oro = null;
		ActionsLog.registerAction(this.name +"(" + this.ID + ")" + " melted " + pureGold + " gold in " + melted + " ruralcoins");
		return melted;
	}

}
