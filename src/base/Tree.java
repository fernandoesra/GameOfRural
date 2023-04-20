package base;

public class Tree extends Resource{
	
	public Tree(String name) {
		super("Tree", "#",0);
		int random = (int)((Math.random() * (11 - 1)) + 1);;
		this.setAmount(random);
	}
	
}
