package works;

import base.Man;
import base.Tree;
import logs.ActionsLog;
import map.Board;
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
		woodPlanks.setAmount((int) (amount / 1.8));
		this.addPlanks(amount);
		String completeTreeName = tree.getClass().getName();
		String treeNameWhitoutSuperclass = completeTreeName.replace("resources.", "");
		String finalTreeName = treeNameWhitoutSuperclass.replace("Tree", "");
		ActionsLog.registerAction(this.name + "(" + this.ID + ") felled an " + finalTreeName + "" + " and obtained "
				+ woodPlanks.getAmount() + " wood planks.");
		return woodPlanks;

	}
	
	/**
	 * This item took a Lumberjack and a adjacent Furniture object then dismantle
	 * the object and return wooden planks to the Lumberjack.
	 * 
	 * @param board            The board used to call the eraseObjectAt() method.
	 * @param actualX          The X position of the furniture on the board.
	 * @param actualY          The Y position of the furniture on the board.
	 * @param actualLumberjack The Lumberjack doing the action.
	 */
	public void dismantleFurniture(Board board, int actualX, int actualY, Lumberjack actualLumberjack) {

		String nameOfItem = board.getNameOfItem(actualX, actualY);

		if (nameOfItem.indexOf("Chair") >= 0) {
			board.eraseObjectAt(actualX, actualY);
			ActionsLog.registerAction(actualLumberjack.getName() + "(" + actualLumberjack.getID() + ")"
					+ " dismantle a chair" + " and obtained 10 wood planks.");
			this.addPlanks(10);
		}

		if (nameOfItem.indexOf("Chest") >= 0) {
			board.eraseObjectAt(actualX, actualY);
			ActionsLog.registerAction(actualLumberjack.getName() + "(" + actualLumberjack.getID() + ")"
					+ " dismantle a chest" + " and obtained 10 wood planks.");
			this.addPlanks(10);
		}

		if (nameOfItem.indexOf("Bed") >= 0) {
			board.eraseObjectAt(actualX, actualY);
			ActionsLog.registerAction(actualLumberjack.getName() + "(" + actualLumberjack.getID() + ")"
					+ " dismantle a bed" + " and obtained 20 wood planks.");
			this.addPlanks(20);
		}

		if (nameOfItem.indexOf("Table") >= 0) {
			board.eraseObjectAt(actualX, actualY);
			ActionsLog.registerAction(actualLumberjack.getName() + "(" + actualLumberjack.getID() + ")"
					+ " dismantle a table" + " and obtained 20 wood planks.");
			this.addPlanks(20);
		}
	}
	
	/**
	 * This method search if it already exists a WoodPlanks object in the inventory
	 * to add more wood planks or if not exists to create a new object and then add
	 * the amount.
	 * 
	 * @param amount Amount of WoodPlanks to add to the inventory of this
	 *               Lumberjack.
	 */
	public void addPlanks(int amount) {
		if (this.inventory.searchForName("Wood planks")) {
			WoodPlanks planksInInventory = (WoodPlanks) this.inventory.fetchForName("Wood planks");
			planksInInventory.setAmount(amount + planksInInventory.getAmount());

		} else {
			WoodPlanks woodPlanks = new WoodPlanks(amount);
			this.inventory.addToInventory(woodPlanks);
		}
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
