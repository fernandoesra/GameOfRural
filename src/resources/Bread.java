package resources;

import base.Resource;

/**
 * A variety of resource named Bread. The Bread is created by the Baker using
 * Grain.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Resource
 * @see resources.Grain
 *
 */

public class Bread extends Resource{
	
	/**
	 * A new Bread object whit the amount value defined by the construcor.
	 * 
	 * @param amount The amount of Bread.
	 */
	public Bread(int amount) {
		super("Bread", "", amount);
	}
	
}
