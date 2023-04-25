package base;

/**
 * This Object is create to have a base for all the fishes but the main reason
 * behind the creation of this object is to have something name "FishWater" to
 * prevent that a call to getClass()getName() plus the method indexOf(Fish)
 * trowh a true return when find a Fisherman or a Fhismonger.<br>
 * The icon for the tree is '⇞', unicode equivalent of the icon is 8670 
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Resource
 * @see base.Water
 *
 */
public class FishWater extends Resource{
	
	/**
	 * Create a new fish.
	 * 
	 * @param name   A new for the new fish.
	 * @param amount The amount of 'meat' the fish have.
	 */
	public FishWater(String name, int amount) {
		super(name, ""+(char)8670 , amount);
	}

}
