package recursos;

public class Money {
	
	// Attributes
	double quantity;
	
	// Constructor
	public Money() {
	};

	public Money(double total) {
		this.quantity = total;
	}
	
	// Get and Set
	public void setQuantity(double total) {
		this.quantity = total;
	}
	
	public double getQuantity() {
		return quantity;
	}
	
	// Methods
	@Override
	public String toString() {
		return "" + (Math.floor(quantity*100.0d) / 100.0d);
	}

}
