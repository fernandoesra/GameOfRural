package base;
/**
 * Base object to create animals
 * Each animal have a different name, type and icon
 * @author Fernando Tarriño del Pozo (FernandoEsra)
 *
 */
public class Animal implements Comparable{
	
	// Attributes
	String name;
	String type;
	String icon;
	
	// Constructor
	public Animal(String name, String type, String icon) {
		this.name = name;
		this.type = type;
		this.icon = icon;
	}
	
	// Get and Set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
