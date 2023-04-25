package resources;

import base.FishWater;

/**
 * A variety of fish with the name "Tilapia".<br>
 * The fress carp have a random value of meet between 3 and 8.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.FishWater
 * @see base.Water
 * @see base.Resource
 *
 */

public class TilapiaFish extends FishWater{
	
	/**
	 * Create a new fish with the name "Tilapia".<br>
	 * The fress carp have a random value of meet between 3 and 8.
	 * 
	 */
	public TilapiaFish() {
		super("Tilapia", 0);
		int random = (int)((Math.random() * (9 - 3)) + 2);;
		this.setAmount(random);
	}

}
