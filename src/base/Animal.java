package base;
/**
 * Base object to create animals
 * Each animal have a different name, type and icon
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 *
 */
public class Animal implements Comparable<Animal>{
	
	// Attributes
	String name;
	String type;
	String icon;
	int amount;
	
	/**
	 * Create a new Animal object.
	 * 
	 * @param name Name of the animal
	 * @param type Type of the animal
	 * @param icon Icon for the animal
	 */
	public Animal(String name, String type, String icon, int amount) {
		this.name = name;
		this.type = type;
		this.icon = icon;
		this.amount = amount;
	}
	
	// Get and Set
	
	/**
	 * 
	 * @return The amount value of the animal
	 */
	public int getAmount() {
		return this.amount;
	}
	
	/**
	 * 
	 * @param amount Change the amount to the entered value.
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
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
	public int compareTo(Animal obj) {
		// Compare just the names
		int compare = 0;
		compare = this.name.compareTo(obj.name);
		return compare;
	}
	
	

}
