package base;

/**
 * Base objet to create different types of furniture Each furniture have a name
 * and a icon
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 *
 */
public class Furniture implements Comparable<Furniture> {

	// Attributes
	String name;
	String icon;

	// Constructor
	/**
	 * Create a new Furniture object.
	 * 
	 * @param name The name of the furniture
	 * @param icon The icon for the furniture
	 */
	public Furniture(String name, String icon) {
		this.name = name;
		this.icon = icon;
	}

	// Get and Set
	/**
	 * 
	 * @return The name of the furniture.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return The icon of the furniture.
	 */
	public String getIcon() {
		return icon;
	}

	// Methods
	@Override
	public String toString() {
		return "The " + name + " have the icon " + icon;
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
	public int compareTo(Furniture obj) {
		// Compare just the name
		int compare = 0;
		compare = this.name.compareTo(obj.name);
		return compare;
	}

}
