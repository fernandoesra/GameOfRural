package main;

import base.Animal;
import base.FishWater;
import map.Board;
import resources.ChickenAnimal;
import resources.CowAnimal;
import resources.GoatAnimal;
import resources.GrassCarpFishWater;
import resources.PigAnimal;
import resources.SilverCarpFishWater;
import resources.TilapiaFishWater;
import utils.ObjectsList;

/**
 * This class create a ObjectList named animalList to store Animals Objects.<br>
 * The class have methods to add new animals to the list and to fill a Board
 * object with the animals.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Animal
 * @see resources.PigAnimal
 * @see resources.CowAnimal
 * @see resources.GoatAnimal
 * @see resources.ChickenAnimal
 *
 */

public class AnimalList {
	
	// Attribute
	/**
	 * A ObjectsList where save the differents animals.
	 */
	public ObjectsList animalList;
	
	/**
	 * Create a new empy AnimalList.
	 */
	public AnimalList() {
		animalList = new ObjectsList();
	}
	
	/**
	 * This method read all the animalList list and fill one map using the animals
	 * inside on random valid positions.
	 * 
	 * @param board The map to fill with animals.
	 */
	public void addAnimalsToBoard(Board board) {
		int mapX = board.getHeight();
		int mapY = board.getWidth();

		for (int i = 0; i < animalList.getLength(); i++) {

			int tryMapX = 0;
			int tryMapY = 0;

			String nameOfresource = animalList.getObjectOnIndex(i).getClass().getSuperclass().getName();

			if (nameOfresource.indexOf("FishWater") >= 0) {
				do {
					tryMapX = (int) ((Math.random() * (mapX - 0)) + 0);
					tryMapY = (int) ((Math.random() * (mapY - 0)) + 0);
				} while (!board.isWater(tryMapX, tryMapY));
				board.eraseObjectAt(tryMapX, tryMapY);
				board.addSomething(animalList.getObjectOnIndex(i), tryMapX, tryMapY);
				
			} else {
				
				do {
					tryMapX = (int) ((Math.random() * (mapX - 0)) + 0);
					tryMapY = (int) ((Math.random() * (mapY - 0)) + 0);
				} while (!board.validPosition(tryMapX, tryMapY));
				board.addSomething(animalList.getObjectOnIndex(i), tryMapX, tryMapY);
			}
		}
	}
	
	/**
	 * Create 'x' new Animals and add its to the animalList.
	 * 
	 * @param quantity The amount of animals to create.
	 */
	public void createAnimals(int quantity) {
		for (int i = 0; i < quantity; i++) {
			animalList.addEnd(randomAnimal());
		}
	}

	/**
	 * This method create and return a random Animal (Pig, Goat, Cow or Chicken)
	 * 
	 * @return A new Animal object.
	 */
	public Animal randomAnimal() {
		
		Animal toAdd = new Animal("a", "a", "a", 0);
		int random = (int) ((Math.random() * (5 - 1)) + 1);

		switch (random) {
		case 1:
			toAdd = new PigAnimal();
			break;
		case 2:
			toAdd = new GoatAnimal();
			break;
		case 3:
			toAdd = new CowAnimal();
			break;
		case 4:
			toAdd = new ChickenAnimal();
			break;
		}
		return toAdd;
	}
	
	/**
	 * This method created 'x' differents fishes objects and adds them to the end of
	 * the animalList.
	 * 
	 * @param amount How much fishes to create.
	 */
	public void addFish(int amount) {
		for (int i = 0; i < amount; i++) {
			FishWater fishToAdd = randomFish();
			animalList.addEnd(fishToAdd);
		}
	}
	
	/**
	 * This method generate a new random fish between the different existing types
	 * of fish.
	 * 
	 * @return Return a new fish object.
	 */
	public FishWater randomFish() {
		FishWater fishToReturn = new FishWater("test",1);
		int random = (int)((Math.random() * (4 - 1)) + 1);
		switch (random) {
		case 1:
			fishToReturn = new GrassCarpFishWater();
			break;
		case 2:
			fishToReturn = new SilverCarpFishWater();
			break;
		case 3:
			fishToReturn = new TilapiaFishWater();
			break;
		default:
			break;
		}
		return fishToReturn;
	}

	/**
	 * This method will read all the animals on this list and generate a 10%
	 * probability to move one of echa his animals in one random direction.<br>
	 * Also controll if the animal is a fish to move only through the water.
	 * 
	 * @param board A board to move the animals of this animalList.
	 */
	public void moveAllAnimals(Board board) {
		for (int i = 0; i < animalList.getLength(); i++) {
			int random = (int)((Math.random() * (11 - 1)) + 1);
			
			String nameOfresource = animalList.getObjectOnIndex(i).getClass().getSuperclass().getName();

			if (nameOfresource.indexOf("FishWater") < 0) {
				switch (random) {
				case 1:
					board.moveSomethingUp(animalList.getObjectOnIndex(i));
					break;
				case 2:
					board.moveSomethingDown(animalList.getObjectOnIndex(i));
					break;
				case 3:
					board.moveSomethingLeft(animalList.getObjectOnIndex(i));
					break;
				case 4:
					board.moveSomethingRight(animalList.getObjectOnIndex(i));
					break;
				default:
					break;
				}
			} else {
				switch (random) {
				case 1:
					board.moveSomethingUpWater(animalList.getObjectOnIndex(i));
					break;
				case 2:
					board.moveSomethingDownWater(animalList.getObjectOnIndex(i));
					break;
				case 3:
					board.moveSomethingLeftWater(animalList.getObjectOnIndex(i));
					break;
				case 4:
					board.moveSomethingRightWater(animalList.getObjectOnIndex(i));
					break;
				default:
					break;
				}
			}
		}
	}
}
