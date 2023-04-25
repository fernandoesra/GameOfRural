package resources;

import base.FishWater;

/**
 * A variety of fish with the name "Silver carp".<br>
 * The fress carp have a random value of meet between 2 and 4.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.FishWater
 * @see base.Water
 * @see base.Resource
 *
 */

public class SilverCarpFish extends FishWater{
	
	/**
	 * Create a new fish with the name "Silver carp".<br>
	 * The fress carp have a random value of meet between 2 and 4.
	 * 
	 */
	public SilverCarpFish() {
		super("Silver carp", 0);
		int random = (int)((Math.random() * (5 - 2)) + 2);;
		this.setAmount(random);
	}

}
