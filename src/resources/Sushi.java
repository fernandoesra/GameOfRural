package resources;

import base.Resource;

/**
 * A variety of resource named "Sushi". The sushi are one of the starting items
 * that the Fishmonger have for sale.<br>
 * 1 sushi cost <b>0.85 Ruralcoins.</b>
 * 
 * @author Fernando Esra
 * @see base.Resource
 * @see jobs.Fishmonger
 *
 */

public class Sushi extends Resource {

	double price;
	
	/**
	 * A new Sushi object whit the amount value defined by the construcor.
	 * 
	 * @param amount The amount of Sushi.
	 */
	public Sushi(int amount) {
		super("Sushi", "", amount);
		this.price = 0.85d;
	}
	
	/**
	 * 
	 * @return The price of the Sushi.
	 */
	public double getPrice() {
		return this.price;
	}

}
