package resources;

import base.Resource;

/**
 * A variety of resource named "Wood planks", is icon is 's'.<br>
 * The wooded planks are used by the Carpenter to create new Furniture using the
 * createX() methods that are invoked on InteractController.<br>
 * The wood planks are obtained by the Lumberjack using the method cutTree().
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see jobs.Carpenter
 * @see jobs.Lumberjack
 * @see main.InteractController
 * @see base.Tree
 */

public class WoodPlanks extends Resource{
	
	/**
	 * Create a new WoodPlanks object.
	 * 
	 * @param amount How many planks are in the amount attribute.
	 */
	public WoodPlanks(int amount) {
		super("Wood planks", "s", amount);
	}

}
