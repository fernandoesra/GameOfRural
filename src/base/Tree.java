package base;

public class Tree extends Resource{
	
	public Tree(String name) {
		super("Tree", "#",0);
		int random = (int)((Math.random() * (11 - 2)) + 2);;
		this.setAmount(random);
	}
	
}
