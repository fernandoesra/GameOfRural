package resources;

import base.Resource;

/**
 * A variety of resource named "Fish soup". The Fish soup are one of the
 * starting items that the Fishmonger have for sale.<br>
 * 1 Fish soup cost <b>3.50 Ruralcoins.</b>
 * 
 * @author Fernando Esra
 * @see base.Resource
 * @see jobs.Fishmonger
 *
 */

public class FishSoup extends Resource {

	double price;

	/**
	 * A new Fish soup object whit the amount value defined by the construcor.
	 * 
	 * @param amount The amount of Fish soup.
	 */
	public FishSoup(int amount) {
		super("Fish soup", "", amount);
		this.price = 2.95d;
	}

	/**
	 * 
	 * @return The price of the Fish soup.
	 */
	public double getPrice() {
		return this.price;
	}

}
