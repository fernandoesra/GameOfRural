package gameResources;

import base.Resource;

public class Tree extends Resource{
	
	int amount;
	
	public Tree(String name, String icon) {
		super("Tree", icon);
		amount = (int)((Math.random() * (11 - 1)) + 1);;
	}
	
	public int getAmount() {
		return amount;
	}

}
