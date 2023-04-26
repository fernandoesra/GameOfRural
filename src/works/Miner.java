package works;

import base.Man;
import logs.ActionsLog;
import resources.GoldOreMineral;
import resources.MinedGold;
import resources.Money;

/**
 * A specialization of Man. The Miner walks through the map in search of
 * GoldOreMineral objects. When found one, call the method
 * crushingGoldOre().<br>
 * The icon for the Miner are 'M'.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Man
 * @see map.Board
 * @see main.InteractController
 * @see main.MoveController
 * @see resources.GoldOreMineral
 * @see resources.MinedGold
 * @see works.Blacksmith
 * 
 */

public class Miner extends Man {

	/**
	 * Do not use
	 */
	protected Miner() {
		super();
	}

	/**
	 * Create a new Miner and set the icon to 'M'.<br>
	 * The Man object create a random name automatically.
	 * 
	 * @param ID    The ID for the Miner.
	 * @param HP    Starting life points (HP) of the Miner.
	 * @param money Starting Money of the Miner.
	 * @param mapX  Starting height position on the Board.
	 * @param mapY  Starting width position on the Board.
	 * @param speed Starting speed of the Miner.
	 */
	public Miner(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "M");
	}

	/**
	 * This method takes an object of type GoldOreMineral to "grind" it into mined
	 * gold. It will return a total of between 50% and 200% of the original amount.
	 * 
	 * @param mineral A GoldOreMineral object to take the amount value
	 * @return A MinedGold object with the amount value between the 90% and the 50%
	 *         of the amont value of the GoldOreMineral
	 */
	public MinedGold crushingGoldOre(GoldOreMineral mineral) {
		int amountOfPureGold = mineral.getAmount();
		int random = (int) ((Math.random() * ((amountOfPureGold * 3) - (amountOfPureGold*0.50)))
				+ (amountOfPureGold * 0.50));
		MinedGold groundMineral = new MinedGold(random + 1);
		ActionsLog.registerAction(this.name +"(" + this.ID + ") has mined a gold ore and has manage to "
				+ "refine a total of " + random + " gold mined.");
		addMinedGold(groundMineral.getAmount());
		return groundMineral;
	}
	
	/**
	 * This method search if it already exists a MinedGold object in the inventory
	 * to add more mined gold or if not exists to create a new object and then add
	 * the amount.
	 * 
	 * @param amount Amount of MinedGold to add to the inventory of this Miner.
	 */
	public void addMinedGold(int amount) {
		if (this.inventory.searchForName("Mined gold")) {
			MinedGold minedInInventory = (MinedGold) this.inventory.fetchForName("Mined gold");
			minedInInventory.setAmount(amount + minedInInventory.getAmount());
		} else {
			MinedGold minedToAdd = new MinedGold(amount);
			this.inventory.addToInventory(minedToAdd);
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
