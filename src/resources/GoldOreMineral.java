package resources;

import base.Resource;

public class GoldOreMineral extends Resource{
	
	/**
	 * Create a new ore gold with a random amount between 1 and 10
	 */
	public GoldOreMineral() {
		// Old icon = "ø"
		super("An ore of gold", "" + (char)937 ,0);
		int random = (int)((Math.random() * (11 - 1)) + 1);
		this.setAmount(random);
	}
	
}
