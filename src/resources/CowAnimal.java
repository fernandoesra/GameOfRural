package resources;

import base.Animal;

/**
 * A variety of animal named Cow. The cow is used for the Butcher to make raw
 * meat. <br>
 * The icon for the Cow is 'Щ', unicode equivalent of the icon is 1065.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Animal
 * @see resources.RawMeat
 *
 */

public class CowAnimal extends Animal {

	/**
	 * Create a new cow.
	 */
	public CowAnimal() {
		super("Cow", "", "" + (char) 1065 , 0);
	}

}
