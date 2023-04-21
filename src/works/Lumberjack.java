package works;

import base.Man;
import base.Tree;
import logs.ActionsLog;
import resources.Money;
import resources.WoodPlanks;

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
		WoodPlanks woodPlanks = new WoodPlanks(0);
		woodPlanks.setAmount((int)(amount/1.8));
		inventory.addToInventory(woodPlanks);
		String completeTreeName = tree.getClass().getName();
		String treeNameWhitoutSuperclass = completeTreeName.replace("resources.", "");
		String finalTreeName = treeNameWhitoutSuperclass.replace("Tree", "");
		ActionsLog.registerAction(this.name + "(" + this.ID + ") felled an " + finalTreeName + ""
				+ " and obtained " + woodPlanks.getAmount() + " wood planks.");
		return woodPlanks;
		
	}
	
	@Override
	public String toString() {
		String toReturn = super.toString();
		char jobChar[] = this.getClass().getName().toCharArray();
		String jobName = "";
		for (int i = 6; i < jobChar.length; i++) {
			jobName += jobChar[i];
		}
		
		toReturn += "His job is to be a " + jobName;
		
		return toReturn;
	}

}
