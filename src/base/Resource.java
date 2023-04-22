package base;

/**
 * Base object to create different type of resources like minerals, animals...
 * Each Resource have a different name and icon. If the resource needs it, its
 * possible to use the <b>amount</b> attribute.
 * 
 * @author Fernando Tarriño del Pozo (FernandoEsra)
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
	
	public String getName() {
		return this.name;
	}
	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	// Methods
	@Override
	public String toString() {
		return "Resource " + name + " has a total of " + amount + " amount.";
	}

}
