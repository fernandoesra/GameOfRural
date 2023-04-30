package resources;

import base.Resource;

/**
 * A variety of resource named "Eggs". The eggs are one of the starting items
 * that the Farmer have for sale.<br>
 * 1 egg cost <b>0.33 Ruralcoins.</b>
 * 
 * @author Fernando Esra
 * @see base.Resource
 * @see jobs.Farmer
 *
 */

public class Eggs extends Resource {

	double price;
	
	/**
	 * A new eggs object whit the amount value defined by the construcor.
	 * 
	 * @param amount The amount of eggs.
	 */
	public Eggs(int amount) {
		super("Eggs", "", amount);
		this.price = 0.33d;
	}
	
	/**
	 * 
	 * @return The price of the eggs.
	 */
	public double getPrice() {
		return this.price;
	}

}
