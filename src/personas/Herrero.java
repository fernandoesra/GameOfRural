package personas;

import base.Sujeto;
import logs.ActionsLog;
import minerales.Gold;
import recursos.Moneda;

/*
 * FILL = ((Math.random() * (maxPercent - minPercent)) + minPercent);
 */

public class Herrero extends Sujeto{
	
	public Herrero() {
		super();
	}

	public Herrero(int ID, int HP, Moneda money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "H"
				);
	}
	
	public Moneda melt(Gold oro) {
		int pureGold = oro.getAmount();
		int amount = (int)((Math.random() * ((pureGold*2)+1 - pureGold)) + pureGold);
		Moneda melted = new Moneda(amount);
		oro = null;
		ActionsLog.registerAction(this.name +"(" + this.ID + ")" + " melted " + pureGold + " gold in " + melted + " ruralcoins");
		return melted;
	}

}
