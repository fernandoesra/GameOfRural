package resources;

import base.Resource;

/**
 * A variety of resource named "Baked lemon garlic salmon". The Baked lemon
 * garlic salmon are one of the starting items that the Fishmonger have for
 * sale.<br>
 * 1 Baked lemon garlic salmon cost <b>4.85 Ruralcoins.</b>
 * 
 * @author Fernando Esra
 * @see base.Resource
 * @see jobs.Fishmonger
 *
 */

public class BakedLemonGarlicSalmon extends Resource {

	double price;

	/**
	 * A new Baked lemon garlic salmon object whit the amount value defined by the
	 * construcor.
	 * 
	 * @param amount The amount of Baked lemon garlic salmon.
	 */
	public BakedLemonGarlicSalmon(int amount) {
		super("Baked lemon garlic salmon", "", amount);
		this.price = 4.85d;
	}

	/**
	 * 
	 * @return The price of the Baked lemon garlic salmon.
	 */
	public double getPrice() {
		return this.price;
	}

}
