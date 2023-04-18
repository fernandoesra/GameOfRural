package recursos;

public class Moneda {
	
	// Attributes
	double quantity;
	
	// Constructor
	public Moneda() {
	};

	public Moneda(double total) {
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
