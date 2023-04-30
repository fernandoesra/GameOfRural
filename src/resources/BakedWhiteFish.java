package resources;

import base.Resource;

/**
 * A variety of resource named "Baked white fish". The Baked white fish are one
 * of the starting items that the Fishmonger have for sale.<br>
 * 1 Baked white fish cost <b>2.95 Ruralcoins.</b>
 * 
 * @author Fernando Esra
 * @see base.Resource
 * @see jobs.Fishmonger
 *
 */

public class BakedWhiteFish extends Resource {

	double price;

	/**
	 * A new Baked white fish object whit the amount value defined by the
	 * construcor.
	 * 
	 * @param amount The amount of Baked white fish.
	 */
	public BakedWhiteFish(int amount) {
		super("Baked white fish", "", amount);
		this.price = 2.95d;
	}

	/**
	 * 
	 * @return The price of the Baked white fish.
	 */
	public double getPrice() {
		return this.price;
	}

}
