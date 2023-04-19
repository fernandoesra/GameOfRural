package works;

import base.Man;
import gameResources.Money;
import minerales.GoldOreMineral;
import minerales.MinedGold;

public class Miner extends Man {

	public Miner() {
		super();
	}

	public Miner(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "M");
	}

	/**
	 * This method takes an object of type GoldOreMineral to "grind" it into mined
	 * gold. It will return a total of between 90% and 50% of the original amount.
	 * 
	 * @param mineral A GoldOreMineral object to take the amount value
	 * @return A MinedGold object with the amount value between the 90% and the 50%
	 *         of the amont value of the GoldOreMineral
	 */
	public MinedGold crushingGoldOre(GoldOreMineral mineral) {
		int amountOfPureGold = mineral.getAmount();
		int random = (int) ((Math.random() * ((amountOfPureGold * 0.90) - (amountOfPureGold * 0.50)))
				+ (amountOfPureGold * 0.50));
		MinedGold groundMineral = new MinedGold(random);
		return groundMineral;
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
