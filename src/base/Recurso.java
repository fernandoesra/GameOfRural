package base;

public class Recurso {
	
	// Attributes
	String name;
	String icon;

	// Constructor
	public Recurso(String name, String icon) {
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
