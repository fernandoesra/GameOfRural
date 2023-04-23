package base;

/**
 * Base object to create different type of resources like minerals, animals...
 * Each Resource have a different name and icon. If the resource needs it, its
 * possible to use the <b>amount</b> attribute.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 *
 */

public class Resource {
	
	// Attributes
	String name;
	String icon;
	int amount;

	// Constructor
	public Resource(String name, String icon, int amount) {
		this.name = name;
		this.icon = icon;
		this.amount = amount;
	}

	// Get and Set
	/**
	 * 
	 * @return The name of the resource.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @return The icon of the resource.
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * 
	 * @return The ammount attribute of the resource.
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * 
	 * @param amount Change the actual amount of the attribute.<br>
	 *               <b>Important: </b> This method does not add the amount on the
	 *               parameter to the current amount. Change the attribute to a new
	 *               value.
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	// Methods
	@Override
	public String toString() {
		return "Resource " + name + " has a total of " + amount + " amount.";
	}

}
