package resources;

import base.Resource;

/**
 * A variety of resource named "Cheese". The cheese are one of the starting
 * items that the Farmer have for sale.<br>
 * 1 cheese cost <b>7.66 Ruralcoins.</b>
 * 
 * @author Fernando Esra
 * @see base.Resource
 * @see jobs.Farmer
 *
 */
public class Cheese extends Resource {

	double price;
	
	/**
	 * A new cheese object whit the amount value defined by the construcor.
	 * 
	 * @param amount The amount of cheese.
	 */
	public Cheese(int amount) {
		super("Cheese", "", amount);
		this.price = 7.66d;
	}
	
	/**
	 * 
	 * @return The price of the milk.
	 */
	public double getPrice() {
		return this.price;
	}

}
