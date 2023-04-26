package resources;

import base.Animal;

/**
 * A variety of animal named Goat. The goat is used for the Butcher to make raw
 * meat. <br>
 * The icon for the Goat is 'ϼ', unicode equivalent of the icon is 1020.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Animal
 * @see resources.RawMeat
 *
 */

public class GoatAnimal extends Animal {

	/**
	 * Create a new goat.
	 */
	public GoatAnimal() {
		super("Goat", "", "" + (char) 1020 , 0);
	}

}
