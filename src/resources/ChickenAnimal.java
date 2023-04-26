package resources;

import base.Animal;

/**
 * A variety of animal named Chicken. The chicken is used for the Butcher to
 * make raw meat. <br>
 * The icon for the Chicken is 'ϡ', unicode equivalent of the icon is 993.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Animal
 * @see resources.RawMeat
 *
 */

public class ChickenAnimal extends Animal {

	/**
	 * Create a new cow.
	 */
	public ChickenAnimal() {
		super("Chicken", "", "" + (char) 993 , 0);
	}

}
