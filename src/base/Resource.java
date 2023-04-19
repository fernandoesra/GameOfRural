package base;

public class Resource {
	
	// Attributes
	String name;
	String icon;

	// Constructor
	public Resource(String name, String icon) {
		icon = "";
	}

	// Get and Set
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	// Methods
	@Override
	public String toString() {
		return icon;
	}

}
