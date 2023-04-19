package base;

public class Furniture implements Comparable {

	// Attributes
	String name;
	String icon;

	// Constructor
	public Furniture(String name, String icon) {
		this.name = name;
		this.icon = icon;
	}

	// Get and Set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	// Methods
	@Override
	public String toString() {
		return "El mueble " + name + " tiene el icono " + icon;
	}

	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		Furniture other = (Furniture) obj;

		if (this.name.equals(other.name)) {
			equal = true;
		}

		return equal;
	}

	@Override
	public int compareTo(Object obj) {
		int compare = 0;
		Furniture other = (Furniture) obj;
		compare = this.name.compareTo(other.name);
		return compare;
	}

}
