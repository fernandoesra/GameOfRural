package recursos;

public class Moneda {
	
	// Attributes
	double total;
	
	// Constructor
	public Moneda() {
	};

	public Moneda(double total) {
		this.total = total;
	}
	
	// Get and Set
	public void setTotal(double total) {
		this.total = total;
	}
	
	public double getTotal() {
		return total;
	}
	
	// Methods
	@Override
	public String toString() {
		return "" + (Math.floor(total*100.0d) / 100.0d);
	}

}
