package works;

import base.Man;
import base.Tree;
import logs.ActionsLog;
import resources.Money;
import resources.WoodPlanks;

/**
 * A specialization of Man. The Lumberjack walks through the map in search of
 * tree objects. When found one, call the method cutTree().<br>
 * The icon for the Lumberjack are 'L'.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Man
 * @see map.Board
 * @see main.InteractController
 * @see main.MoveController
 * @see base.Tree
 * @see resources.WoodPlanks
 * @see works.Carpenter
 *
 */

public class Lumberjack extends Man{
	
	/**
	 * Do not use
	 */
	protected Lumberjack() {
		super();
	}

	/**
	 * Create a new Lumberjack and set the icon to 'L'.<br>
	 * The Man object create a random name automatically.
	 * 
	 * @param ID    The ID for the Lumberjack.
	 * @param HP    Starting life points (HP) of the Lumberjack.
	 * @param money Starting Money of the Lumberjack.
	 * @param mapX  Starting height position on the Board.
	 * @param mapY  Starting width position on the Board.
	 * @param speed Starting speed of the Lumberjack.
	 */
	public Lumberjack(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "L"
				);
	}
	
	/**
	 * This method read the amount value for one tree and then create a new
	 * WoodPlanks object with the amount value equals to (tree.amount/1.8).<br>
	 * For example if the original tree have a 180 in the amount value then it will
	 * be created a WoodPlanks object with 100 on the amount value.<br>
	 * Also the method take the name of the tree and generate a new line for the
	 * action log showing the type of the tree and the amount of wooded planks
	 * generated.
	 * 
	 * @param tree A tree that exits on the board.
	 * @return A new WoodPlanks object.
	 */
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
		
		toReturn += this.name + "'s job is to be a " + jobName;
		
		return toReturn;
	}

}
