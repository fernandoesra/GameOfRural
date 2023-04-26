package main;

import base.Animal;
import map.Board;
import resources.ChickenAnimal;
import resources.CowAnimal;
import resources.GoatAnimal;
import resources.PigAnimal;
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
	public ObjectsList animalList;
	
	/*
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
			do {
				tryMapX = (int)((Math.random() * (mapX - 0)) + 0);
				tryMapY = (int)((Math.random() * (mapY - 0)) + 0);
			} while (!board.validPosition(tryMapX, tryMapY));
			board.addSomething(animalList.getObjectOnIndex(i), tryMapX, tryMapY);
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
		
		Animal toAdd = new Animal("a", "a", "a");
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
}
