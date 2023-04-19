package minerales;

import base.Resource;

public class GoldOreMineral extends Resource{
	
	// Amount of gold from the resource
	int amount;
	
	public GoldOreMineral(String name, String icon) {
		super("Gold ore", icon);
		this.amount = (int)((Math.random() * (11 - 1)) + 1);
	}
	
	public int getAmount() {
		return amount;
	}

}
