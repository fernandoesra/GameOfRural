package base;

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
