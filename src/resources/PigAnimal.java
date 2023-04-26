package resources;

import base.Animal;

/**
 * A variety of animal named Pig. The pig is used for the Butcher to make raw
 * meat. <br>
 * The icon for the Pig is 'ξ', unicode equivalent of the icon is 958.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Animal
 * @see resources.RawMeat
 *
 */

public class PigAnimal extends Animal {

	/**
	 * Create a new pig.
	 */
	public PigAnimal() {
		super("Pig", "", "" + (char) 958 , 0);
	}

}
