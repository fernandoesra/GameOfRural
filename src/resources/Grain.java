package resources;

import base.Resource;

/**
 * A variety of resource named Grain. The grain is used by the Baker to make
 * Bread. The amount value is randomly set between 1 and 10.<br>
 * 
 * The icon for the Grain is 'ψ', unicode equivalent of the icon is 968.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Resource
 * @see resources.Bread
 *
 */

public class Grain extends Resource {

	/**
	 * A new grain object whit the amount value between 1 and 10.
	 */
	public Grain() {
		super("Grain", "" + (char) 968, 0);
		int random = (int) ((Math.random() * (11 - 1)) + 1);
		this.setAmount(random);
	}

}
