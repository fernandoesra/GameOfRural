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

	public Bread(int amount) {
		super("Bread", "", amount);
	}
	
}
