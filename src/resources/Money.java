package resources;

/**
 * This item is used like a 'wallet' to store money value on is quantity
 * attribute. The main class that uses Money is Man.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Man
 * 
 */

public class Money {
	
	// Attributes
	double quantity;
	
	// Constructor
	/**
	 * Create a empty Money with 0 value for quantity.
	 */
	public Money() {
		this.quantity = 0;
	};
	
	/**
	 * Create a new Money with a personalized quantity value.
	 * @param total The value for the quantity attribute.
	 */
	public Money(double total) {
		this.quantity = total;
	}
	
	// Get and Set
	/**
	 * 
	 * @param total Change the actual quantity of the object.<br>
	 *              <b>Important: </b> This method does not add the amount on the
	 *              parameter to the current amount. Change the attribute to a new
	 *              value.
	 */
	public void setQuantity(double total) {
		this.quantity = total;
	}
	
	/**
	 * 
	 * @return The actual quantity on the Money.<br>
	 * 
	 */
	public double getQuantity() {
		return quantity;
	}
	
	// Methods
	@Override
	public String toString() {
		return "" + (Math.floor(quantity*100.0d) / 100.0d);
	}

}
