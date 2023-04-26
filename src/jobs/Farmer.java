package jobs;

import base.Man;
import base.Resource;
import logs.ActionsLog;
import resources.Cheese;
import resources.Eggs;
import resources.Milk;
import resources.Money;
import resources.Potato;

/**
 * A specialization of Man. The Farmer walks through the map in search of
 * other citizens to sell his items.<br>
 * The icon for the Farmer are 'F'.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Man
 * @see map.Board
 * @see main.InteractController
 * @see main.MoveController
 * @see resources.Milk
 * @see resources.Eggs
 * @see resources.Cheese
 * @see resources.Potato
 * 
 */


public class Farmer extends Man{

	/**
	 * Do not use
	 */
	protected Farmer() {
		super();
	}

	/**
	 * Create a new Farmer and set the icon to 'F'.<br>
	 * The Man object create a random name automatically.<br>
	 * The Farmer start on the map with a random amount of eggs, cheese, milk and
	 * potatoes to sell.
	 * 
	 * @param ID    The ID for the Farmer.
	 * @param HP    Starting life points (HP) of the Farmer.
	 * @param money Starting Money of the Baker.
	 * @param mapX  Starting height position on the Board.
	 * @param mapY  Starting width position on the Board.
	 * @param speed Starting speed of the Farmer.
	 */
	public Farmer(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "F");
		int random = (int)((Math.random() * (121 - 60)) + 60);
		Eggs startingEggs = new Eggs(random);
		this.inventory.addToInventory(startingEggs);
		
		random = (int)((Math.random() * (201 - 100)) + 100);
		Cheese startingCheese = new Cheese(random);
		this.inventory.addToInventory(startingCheese);
		
		random = (int)((Math.random() * (201 - 100)) + 100);
		Milk startingMilk = new Milk(random);
		this.inventory.addToInventory(startingMilk);
		
		random = (int)((Math.random() * (151 - 60)) + 60);
		Potato startingPotatoes = new Potato(random);
		this.inventory.addToInventory(startingPotatoes);
	}
	
	/**
	 * This method try to sell something to a adjacent citizen.
	 * 
	 * @param buyer Must be a adjacent Man object that perform the buy action.
	 */
	
	public void sellSomething(Man buyer) {
		int random = (int)((Math.random() * (5 - 1)) + 1);
		boolean confirmedSell = false;
		String itemToSellName = "";
		int quantityToSell = 0;
		double totalPrice = 0d;
		
		switch (random) {
		case 1:
			if (this.inventory.searchForName("Milk")) {
				itemToSellName = "Milk";
				Milk actualItem = (Milk) this.inventory.fetchForName("Milk");
				int itemAmountInInventory = actualItem.getAmount();
				quantityToSell = (int) ((Math.random() * (((itemAmountInInventory * 0.05) + 1) - 1)) + 1);
				totalPrice = quantityToSell*actualItem.getPrice();
				
				if (buyer.checkSubtractMoney(totalPrice)) {
					addToAnotherInventory(buyer, "Milk", quantityToSell);
					buyer.subtractMoney(totalPrice);
					this.money.setQuantity(totalPrice + money.getQuantity());
					confirmedSell = true;
					deleteFromInventory(quantityToSell, "Milk");
				}
			}
			break;
		case 2:
			if (this.inventory.searchForName("Eggs")) {
				itemToSellName = "Eggs";
				Eggs actualItem = (Eggs) this.inventory.fetchForName("Eggs");
				int itemAmountInInventory = actualItem.getAmount();
				quantityToSell = (int) ((Math.random() * (((itemAmountInInventory * 0.05) + 1) - 1)) + 1);
				totalPrice = quantityToSell*actualItem.getPrice();
				
				if (buyer.checkSubtractMoney(totalPrice)) {
					addToAnotherInventory(buyer, "Eggs", quantityToSell);
					buyer.subtractMoney(totalPrice);
					this.money.setQuantity(totalPrice + money.getQuantity());
					confirmedSell = true;
					deleteFromInventory(quantityToSell, "Eggs");
				}
			}
			break;
		case 3:
			if (this.inventory.searchForName("Cheese")) {
				itemToSellName = "Cheese";
				Cheese actualItem = (Cheese) this.inventory.fetchForName("Cheese");
				int itemAmountInInventory = actualItem.getAmount();
				quantityToSell = (int) ((Math.random() * (((itemAmountInInventory * 0.05) + 1) - 1)) + 1);
				totalPrice = quantityToSell*actualItem.getPrice();
				
				if (buyer.checkSubtractMoney(totalPrice)) {
					addToAnotherInventory(buyer, "Cheese", quantityToSell);
					buyer.subtractMoney(totalPrice);
					this.money.setQuantity(totalPrice + money.getQuantity());
					confirmedSell = true;
					deleteFromInventory(quantityToSell, "Cheese");
				}
			}
			break;
		case 4:
			if (this.inventory.searchForName("Potatoes")) {
				itemToSellName = "Potatoes";
				Potato actualItem = (Potato) this.inventory.fetchForName("Potatoes");
				int itemAmountInInventory = actualItem.getAmount();
				quantityToSell = (int) ((Math.random() * (((itemAmountInInventory * 0.05) + 1) - 1)) + 1);
				totalPrice = quantityToSell*actualItem.getPrice();
				
				if (buyer.checkSubtractMoney(totalPrice)) {
					addToAnotherInventory(buyer, "Potatoes", quantityToSell);
					buyer.subtractMoney(totalPrice);
					this.money.setQuantity(totalPrice + money.getQuantity());
					confirmedSell = true;
					deleteFromInventory(quantityToSell, "Potatoes");
				}
			}
			break;
		default:
			break;
		}

		if (confirmedSell == true) {
			ActionsLog.registerAction(this.name + "(" + this.ID + ") has sold " + quantityToSell + " " + itemToSellName
					+ "" + " to " + buyer.getName() + "(" + buyer.getID() + ") for a total of "
					+ (Math.floor(totalPrice * 100.0d) / 100.0d) + " ruralcoins.");
		}

	}
	
	/**
	 * This method search on the inventory of the Farmer for a specific item. If
	 * found then subtract the indicate amount for the actual amount of the
	 * item.<br>
	 * Then if the amount value of the item its 0 or less, delete the item.
	 * 
	 * @param amount The amount value to subtract.
	 * @param name   The name of the item to find.
	 */
	public void deleteFromInventory(int amount, String name) {
		if (this.inventory.searchForName(name)) {
			Resource existingResource = (Resource) this.inventory.fetchForName(name);
			existingResource.setAmount(existingResource.getAmount() - amount);
			if (existingResource.getAmount() <= 0) {
				this.inventory.removeFromInventory(existingResource);
			}
		}
	}

	/**
	 * This method search on the inventory of other Man for a item to add more
	 * amount of that item. If the item already exists, just add the amount to the
	 * existing item. If not, create a new item with the specified amount.
	 * 
	 * @param otherMan    The man to fetch for the inventory object.
	 * @param itemName    The item we are looking to increase.
	 * @param amountToAdd Amount to add of the selected item.
	 */
	public void addToAnotherInventory(Man otherMan, String itemName, int amountToAdd) {
		if (otherMan.inventory.searchForName(itemName)) {
			Resource toAdd = new Resource("","",0);
			switch (itemName) {
			case "Milk":
				toAdd = (Milk) otherMan.inventory.fetchForName(itemName);
				toAdd.setAmount(amountToAdd + toAdd.getAmount());
				break;
			case "Eggs":
				toAdd = (Eggs) otherMan.inventory.fetchForName(itemName);
				toAdd.setAmount(amountToAdd + toAdd.getAmount());
				break;
			case "Cheese":
				toAdd = (Cheese) otherMan.inventory.fetchForName(itemName);
				toAdd.setAmount(amountToAdd + toAdd.getAmount());
				break;
			case "Potatoes":
				toAdd = (Potato) otherMan.inventory.fetchForName(itemName);
				toAdd.setAmount(amountToAdd + toAdd.getAmount());
				break;
			}
		} else {
			Resource toAdd = new Resource("","",0);
			switch (itemName) {
			case "Milk":
				toAdd = new Milk(amountToAdd);
				otherMan.inventory.addToInventory(toAdd);
				break;
			case "Eggs":
				toAdd = new Eggs(amountToAdd);
				otherMan.inventory.addToInventory(toAdd);
				break;
			case "Cheese":
				toAdd = new Cheese(amountToAdd);
				otherMan.inventory.addToInventory(toAdd);
				break;
			case "Potatoes":
				toAdd = new Potato(amountToAdd);
				otherMan.inventory.addToInventory(toAdd);
				break;
			}
		}
	}

	@Override
	public String toString() {
		String toReturn = super.toString();
		char jobChar[] = this.getClass().getName().toCharArray();
		String jobName = "";
		for (int i = 5; i < jobChar.length; i++) {
			jobName += jobChar[i];
		}
		
		toReturn += this.name + "'s job is to be a " + jobName;
		
		return toReturn;
	}
}
