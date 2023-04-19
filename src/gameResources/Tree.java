package gameResources;

import base.Resource;

public class Tree extends Resource{
	
	public Tree(String name, String icon) {
		super("Tree", icon,0);
		int random = (int)((Math.random() * (11 - 1)) + 1);;
		this.setAmount(random);
	}
	
}
