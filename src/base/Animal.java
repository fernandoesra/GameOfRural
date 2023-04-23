package base;
/**
 * Base object to create animals
 * Each animal have a different name, type and icon
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 *
 */
public class Animal implements Comparable{
	
	// Attributes
	String name;
	String type;
	String icon;
	
	/**
	 * Create a new Animal object.
	 * 
	 * @param name Name of the animal
	 * @param type Type of the animal
	 * @param icon Icon for the animal
	 */
	public Animal(String name, String type, String icon) {
		this.name = name;
		this.type = type;
		this.icon = icon;
	}
	
	// Get and Set
	/**
	 * 
	 * @return The name of the animal.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return The type of the animal.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * 
	 * @return The icon of the animal.
	 */
	public String getIcon() {
		return icon;
	}
	
	// Methods
	@Override
	public String toString() {
		return "The " + name + " is a " + type + " type animal and its icon is : " + icon;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		Animal other = (Animal) obj;
		
		if (this.name.equals(other.name)) {
			equal = true;
		}
		
		return equal;
	}
	
	@Override
	public int compareTo(Object obj) {
		// Compare just the names
		int compare = 0;
		Animal other = (Animal) obj;
		compare = this.name.compareTo(other.name);
		return compare;
	}
	
	

}
