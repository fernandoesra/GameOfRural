package resources;

import base.Resource;

/**
 * A variety of resource named "Mined gold". Obtained when one Miner use the
 * method crushingGoldOre().<br>
 * Is used for the Blacksmith on the method melt() to create Money.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see works.Miner
 * @see works.Blacksmith
 * @see resources.Money
 * @see main.InteractController
 * 
 */

public class MinedGold extends Resource{
	
	/**
	 * Create a new Mined Gold item with a specific amount.
	 * 
	 * @param amount Set the amount attribute for the new object.
	 */
	public MinedGold(int amount) {
		super("Mined gold", "NO ICON", amount);
	}
	
}
