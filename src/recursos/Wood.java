package recursos;

import base.Resource;

public class Wood extends Resource{
	
	int amount;
	
	public Wood(String name, String icon) {
		super("Wood", icon);
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
