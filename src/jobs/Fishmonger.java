package jobs;

import base.Man;
import base.Resource;
import logs.ActionsLog;
import resources.BakedLemonGarlicSalmon;
import resources.BakedWhiteFish;
import resources.FishSoup;
import resources.Sushi;
import resources.Money;

/**
 * A specialization of Man. The Fishmonger walks through the map in search of
 * other citizens to sell his fishes.<br>
 * The icon for the Fishmonger are 'G'.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Man
 * @see map.Board
 * @see main.InteractController
 * @see main.MoveController
 * @see resources.Money
 * @see resources.BakedLemonGarlicSalmon
 * @see resources.BakedWhiteFish
 * @see resources.FishSoup
 * @see resources.Sushi
 * 
 */

public class Fishmonger extends Man {

	/**
	 * Do not use
	 */
	protected Fishmonger() {
		super();
	}

	/**
	 * Create a new Fishmonger and set the icon to 'G'.<br>
	 * The Man object create a random name automatically.<br>
	 * The Fishmonger start on the map with a random amount of sushi, Baked white
	 * fish, Baked lemon garlic salmon and Fish soup to sell.
	 * 
	 * @param ID    The ID for the Fishmonger.
	 * @param HP    Starting life points (HP) of the Fishmonger.
	 * @param money Starting Money of the Fishmonger.
	 * @param mapX  Starting height position on the Board.
	 * @param mapY  Starting width position on the Board.
	 * @param speed Starting speed of the Fishmonger.
	 */
	public Fishmonger(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "G");
		int random = (int) ((Math.random() * (301 - 200)) + 200);
		Sushi startingSushi = new Sushi(random);
		this.inventory.addToInventory(startingSushi);

		random = (int) ((Math.random() * (101 - 50)) + 50);
		BakedWhiteFish startingBakedWhiteFish = new BakedWhiteFish(random);
		this.inventory.addToInventory(startingBakedWhiteFish);

		random = (int) ((Math.random() * (101 - 80)) + 80);
		BakedLemonGarlicSalmon startingBakedLemonGarlicSalmon = new BakedLemonGarlicSalmon(random);
		this.inventory.addToInventory(startingBakedLemonGarlicSalmon);

		random = (int) ((Math.random() * (301 - 150)) + 150);
		FishSoup startingFishSoup = new FishSoup(random);
		this.inventory.addToInventory(startingFishSoup);
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

	/**
	 * This method try to sell something to a adjacent citizen.
	 * 
	 * @param buyer Must be a adjacent Man object that perform the buy action.
	 */
	public void sellSomething(Man buyer) {
		int random = (int) ((Math.random() * (5 - 1)) + 1);
		boolean confirmedSell = false;
		String itemToSellName = "";
		int quantityToSell = 0;
		double totalPrice = 0d;

		switch (random) {
		case 1:
			if (this.inventory.searchForName("Sushi")) {
				itemToSellName = "Sushi";
				Sushi actualItem = (Sushi) this.inventory.fetchForName("Sushi");
				int itemAmountInInventory = actualItem.getAmount();
				quantityToSell = (int) ((Math.random() * (((itemAmountInInventory * 0.05) + 1) - 1)) + 1);
				totalPrice = quantityToSell * actualItem.getPrice();

				if (buyer.checkSubtractMoney(totalPrice)) {
					addToAnotherInventory(buyer, "Sushi", quantityToSell);
					buyer.subtractMoney(totalPrice);
					this.money.setQuantity(totalPrice + money.getQuantity());
					confirmedSell = true;
					deleteFromInventory(quantityToSell, "Sushi");
				}
			}
			break;
		case 2:
			if (this.inventory.searchForName("Baked white fish")) {
				itemToSellName = "Baked white fish";
				BakedWhiteFish actualItem = (BakedWhiteFish) this.inventory.fetchForName("Baked white fish");
				int itemAmountInInventory = actualItem.getAmount();
				quantityToSell = (int) ((Math.random() * (((itemAmountInInventory * 0.05) + 1) - 1)) + 1);
				totalPrice = quantityToSell * actualItem.getPrice();

				if (buyer.checkSubtractMoney(totalPrice)) {
					addToAnotherInventory(buyer, "Baked white fish", quantityToSell);
					buyer.subtractMoney(totalPrice);
					this.money.setQuantity(totalPrice + money.getQuantity());
					confirmedSell = true;
					deleteFromInventory(quantityToSell, "Baked white fish");
				}
			}
			break;
		case 3:
			if (this.inventory.searchForName("Baked lemon garlic salmon")) {
				itemToSellName = "Baked lemon garlic salmon";
				BakedLemonGarlicSalmon actualItem = (BakedLemonGarlicSalmon) this.inventory
						.fetchForName("Baked lemon garlic salmon");
				int itemAmountInInventory = actualItem.getAmount();
				quantityToSell = (int) ((Math.random() * (((itemAmountInInventory * 0.05) + 1) - 1)) + 1);
				totalPrice = quantityToSell * actualItem.getPrice();

				if (buyer.checkSubtractMoney(totalPrice)) {
					addToAnotherInventory(buyer, "Baked lemon garlic salmon", quantityToSell);
					buyer.subtractMoney(totalPrice);
					this.money.setQuantity(totalPrice + money.getQuantity());
					confirmedSell = true;
					deleteFromInventory(quantityToSell, "Baked lemon garlic salmon");
				}
			}
			break;
		case 4:
			if (this.inventory.searchForName("Fish soup")) {
				itemToSellName = "Fish soup";
				FishSoup actualItem = (FishSoup) this.inventory.fetchForName("Fish soup");
				int itemAmountInInventory = actualItem.getAmount();
				quantityToSell = (int) ((Math.random() * (((itemAmountInInventory * 0.05) + 1) - 1)) + 1);
				totalPrice = quantityToSell * actualItem.getPrice();

				if (buyer.checkSubtractMoney(totalPrice)) {
					addToAnotherInventory(buyer, "Fish soup", quantityToSell);
					buyer.subtractMoney(totalPrice);
					this.money.setQuantity(totalPrice + money.getQuantity());
					confirmedSell = true;
					deleteFromInventory(quantityToSell, "Fish soup");
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
	 * This method search on the inventory of the Fishmonger for a specific item. If
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
			Resource toAdd = new Resource("", "", 0);
			switch (itemName) {
			case "Sushi":
				toAdd = (Sushi) otherMan.inventory.fetchForName(itemName);
				toAdd.setAmount(amountToAdd + toAdd.getAmount());
				break;
			case "Baked white fish":
				toAdd = (BakedWhiteFish) otherMan.inventory.fetchForName(itemName);
				toAdd.setAmount(amountToAdd + toAdd.getAmount());
				break;
			case "Baked lemon garlic salmon":
				toAdd = (BakedLemonGarlicSalmon) otherMan.inventory.fetchForName(itemName);
				toAdd.setAmount(amountToAdd + toAdd.getAmount());
				break;
			case "Fish soup":
				toAdd = (FishSoup) otherMan.inventory.fetchForName(itemName);
				toAdd.setAmount(amountToAdd + toAdd.getAmount());
				break;
			default:
				break;
			}
		} else {
			Resource toAdd = new Resource("", "", 0);
			switch (itemName) {
			case "Sushi":
				toAdd = new Sushi(amountToAdd);
				otherMan.inventory.addToInventory(toAdd);
				break;
			case "Baked white fish":
				toAdd = new BakedWhiteFish(amountToAdd);
				otherMan.inventory.addToInventory(toAdd);
				break;
			case "Baked lemon garlic salmon":
				toAdd = new BakedLemonGarlicSalmon(amountToAdd);
				otherMan.inventory.addToInventory(toAdd);
				break;
			case "Fish soup":
				toAdd = new FishSoup(amountToAdd);
				otherMan.inventory.addToInventory(toAdd);
				break;
			default:
				break;
			}
		}
	}

}
