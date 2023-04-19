package works;

import base.Man;
import gameResources.Money;
import gameResources.Tree;
import gameResources.Wood;

public class Lumberjack extends Man{
	
	public Lumberjack() {
		super();
	}

	public Lumberjack(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "L"
				);
	}
	
	public Object cutTree(Tree tree) {
		
		int amount = tree.getAmount();
		
		Wood woodPlanks = new Wood(icon, icon);
		woodPlanks.setAmount(amount/2);
		
		return woodPlanks;
		
	}

}
