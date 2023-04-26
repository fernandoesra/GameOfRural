package resources;

import base.Resource;

/**
 * A variety of resource named "Milk". The milk are one of the starting items
 * that the Farmer have for sale.<br>
 * 1 milk cost <b>1.02 Ruralcoins.</b>
 * 
 * @author Fernando Esra
 * @see base.Resource
 * @see jobs.Farmer
 *
 */

public class Milk extends Resource{
	
	double price;
	
	/**
	 * A new milk object whit the amount value defined by the construcor.
	 * 
	 * @param amount The amount of Milk.
	 */
	public Milk(int amount) {
		super("Milk", "", amount);
		this.price = 1.2d;
	}
	
	/**
	 * 
	 * @return The price of the milk.
	 */
	public double getPrice() {
		return this.price;
	}

}
