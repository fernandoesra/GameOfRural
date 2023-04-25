package resources;

import base.FishWater;

/**
 * A variety of fish with the name "Frass carp".<br>
 * The fress carp have a random value of meet between 2 and 6.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.FishWater
 * @see base.Water
 * @see base.Resource
 *
 */

public class GrassCarpFish extends FishWater{
	
	/**
	 * Create a new fish with the name "Frass carp".<br>
	 * The fress carp have a random value of meet between 2 and 6.
	 * 
	 */
	public GrassCarpFish() {
		super("Grass carp", 0);
		int random = (int)((Math.random() * (7 - 2)) + 2);;
		this.setAmount(random);
	}

}
