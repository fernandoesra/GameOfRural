package resources;

import base.Resource;

/**
 * The raw meat are obtained by the Butcher and the Fisherman.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see jobs.Butcher
 * @see jobs.Fisherman
 * @see base.Resource
 *
 */

public class RawMeat extends Resource{
	
	/**
	 * Create a new Raw meat object.
	 * 
	 * @param amount The amount of raw meat
	 */
	public RawMeat(int amount) {
		super("Raw meat", "", amount);
	}

}
