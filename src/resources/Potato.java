package resources;

import base.Resource;

/**
 * A variety of resource named "Potato". The potatoes are one of the starting items
 * that the Farmer have for sale.<br>
 * 1 potato cost <b>1.46 Ruralcoins.</b>
 * 
 * @author Fernando Esra
 * @see base.Resource
 * @see jobs.Farmer
 *
 */

public class Potato extends Resource{

	double price;
	
	/**
	 * A new potatoes object whit the amount value defined by the construcor.
	 * 
	 * @param amount The amount of potatoes.
	 */
	public Potato(int amount) {
		super("Potatoes", "", amount);
		this.price = 1.46d;
	}
	
	/**
	 * 
	 * @return The price of the potatoes.
	 */
	public double getPrice() {
		return this.price;
	}

}
