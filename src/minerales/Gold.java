package minerales;

import base.Recurso;

public class Gold extends Recurso{
	
	// Amount of gold from the resource
	int amount;
	
	public Gold(String name, String icon) {
		super("Mena de oro", icon);
		this.amount = (int)((Math.random() * (11 - 1)) + 1);
	}
	
	public int getAmount() {
		return amount;
	}

}
