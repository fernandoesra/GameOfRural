package map;

import base.Animal;
import base.FishWater;
import base.Furniture;
import base.Man;
import base.Resource;
import base.Tree;
import base.Water;
import utils.AleatoricName;

/**
 * This class store a 2 dimensional Objects array to simulate a map. Also
 * generate a random name for the town and store the height and width.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see utils.AleatoricName
 * @see base.Water
 * 
 */

public class Board {
	
	// Attributes
	/**
	 * A two-dimensional array to store the objects of the "map"
	 */
	public Object board[][];
	String name;
	int height;
	int width;
	
	// Constructor
	/**
	 * The empty constructor are used to create a new board with correct dimensions
	 * to display in the Eclipse console (28x50).
	 */
	public Board() {
		AleatoricName newName = new AleatoricName();
		this.name = newName.toString();
		newName = null;
		/*
		 * If you want to customize the town name uncomment the following line and write
		 * here the name of your town
		 */
		// this.name = "San Vicente de Alcántara";
		board = new Object[28][50];
		this.height = board.length;
		this.width = board[0].length;
	};
	
	/**
	 * This constructor create a empty map with a personalized dimensions and a new
	 * aleatoric name.
	 * 
	 * @param height Length for height
	 * @param width  Length for width
	 */
	public Board(int height, int width) {
		AleatoricName newName = new AleatoricName();
		this.name = newName.toString();
		newName = null;
		/*
		 * If you want to customize the town name uncomment the following line and write
		 * here the name of your town
		 */
		// this.name = "San Vicente de Alcántara";
		board = new Object[height][width];
		this.height = height;
		this.width = width;
	};
	
	// Get y Set
	
	/**
	 * @return The 2 dimensional map object array
	 */
	public Object[][] getBoard() {
		return board;
	}
	
	/**
	 * @return The name of the town
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return The height lenght of the array.
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @return The width lenght of the array.
	 */
	public int getWidth() {
		return width;
	}
	
	// Methods
	
	/**
	 * This method check if the provided coordinates are inside the bounds. This
	 * method its really important to prevent OOB crash.
	 * 
	 * @param newX Length for board (height). First coordinate.
	 * @param newY Length for board[] [width]. Second coordinate.
	 * @return If the coordinates are inside the bounds return <b><i>true</i></b>.
	 *         If the coordinates are OOB, return <b><i>false</i></b>.
	 */
	public boolean inBounds(int newX, int newY) {
		boolean valid = false;
		if (newX >= 0 && newX < height && newY >= 0 && newY < width) {
			valid = true;
		}
		return valid;
	}
	
	/**
	 * This method check if one position on the map have a Water object inside.
	 * 
	 * @param searchX Length for board (height). First coordinate.
	 * @param searchY Length for board[] [width]. Second coordinate.
	 * @return If the coordinates have a water object inside return
	 *         <b><i>true</i></b>. If not, return <b><i>false</i></b>.
	 */
	public boolean isWater(int searchX, int searchY) {
		boolean water = false;
		if(inBounds(searchX, searchY) && board[searchX][searchY] != null) {
			String className = board[searchX][searchY].getClass().getName();
			if (className.indexOf(".Water")>=0) {
				water = true;
			}
		}
		
		return water;
	}

	/**
	 * This method check if one position on the map are inside the limites and has
	 * nothing inside.
	 * 
	 * @param newX Length for board (height). First coordinate.
	 * @param newY Length for board[] [width]. Second coordinate.
	 * @return If the coordinates are inside the bounds and empty (null) return
	 *         <b><i>true</i></b>. If not, return <b><i>false</i></b>;
	 */
	public boolean validPosition(int newX, int newY) {
		boolean valid = false;
		if (inBounds(newX, newY) && board[newX][newY] == null && !isWater(newX,newY)) {
			valid = true;
		}
		return valid;
	}
	
	/**
	 * This method read all the map and count the water objects inside.
	 * 
	 * @return The amount of water on the map
	 */
	public int totalWater() {
		int totalWater = 0;
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				if (this.isWater(i, j)) {
					totalWater++;
				}
			}
		}
		return totalWater;
	}
	
	/**
	 * This method search for the height position of one object inside the board.
	 * 
	 * @param toSearch Object to search in the board
	 * @return If the object exists inside the board, return the heigth index. If
	 *         not, return -1.
	 */
	public int searchXobject(Object toSearch) {
		
		int newX = -1;
		
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				
				if (board[x][y] == toSearch) {
					newX = x;
				}
				
			}
			
		}
		
		return newX;
	}
	
	/**
	 * This method search for the width position of one object inside the board.
	 * 
	 * @param toSearch Object to search in the board
	 * @return If the object exists inside the board, return the width index. If
	 *         not, return -1.
	 */
	public int searchYobject(Object toSearch) {

		int newY = -1;

		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {

				if (board[x][y] == toSearch) {
					newY = y;
				}

			}

		}

		return newY;
	}

	/**
	 * This method search for the class name of a object in (searchX.searchY)
	 * 
	 * @param searchX Height coordinate to search on the board
	 * @param searchY Width coordinate to search on the board
	 * @return If exists something inside the indicates coordinates, return the
	 *         class name.
	 */
	public String getNameOfItem(int searchX, int searchY) {
		String nameOfItem = "";
		if (!this.validPosition(searchX, searchY)) {
			nameOfItem = board[searchX][searchY].getClass().getName();
		}
		return nameOfItem;
	}
	
	/**
	 * This method return one object at (searchX.searchY) position.
	 * 
	 * @param searchX Height position to search on the map.
	 * @param searchY Width position to search on the map.
	 * @return The object at (searchX.searchY) position. If the possition is empty,
	 *         return null.
	 */
	public Object getObjectAt(int searchX, int searchY) {
		Object searched = null;
		if (!this.validPosition(searchX, searchY)) {
			searched = board[searchX][searchY];
		}
		return searched;
	}
	
	/**
	 * Set the (searchX.searchY) position to null;
	 * 
	 * @param searchX Height position of the map.
	 * @param searchY Width position of the map.
	 * @return If something is deleted at the indicated position, return
	 *         <b><i>true</i></b>, if not, return <b><i>false</i></b>.
	 */
	public boolean eraseObjectAt(int searchX, int searchY) {
		boolean erased = false;
		if (!this.validPosition(searchX, searchY)) {
			board[searchX][searchY] = null;
		}
		return erased;
	}
	
	/**
	 * This method search for a possible existence of X and Y axis of one object. If
	 * both axis exists then delete the object.
	 * 
	 * @param obj A object to search and delete from the map.
	 * @return <b><i>True</i></b> if something is deleted, if not, return
	 *         <b><i>false</i></b>.
	 */
	public boolean eraseObject(Object obj) {
		boolean erased = false;
		int existingX = this.searchXobject(obj);
		int existingY = this.searchYobject(obj);
		if (existingX >= 0 && existingY >= 0) {
			this.eraseObjectAt(existingX, existingY);
			erased = true;
		}
		return erased;
	}
	
	/**
	 * Add one object to the indicated position. Only work if the possition is
	 * valid.
	 * 
	 * @param obj  The object to add.
	 * @param mapX Height position of the map.
	 * @param mapY Width position of the map.
	 * @return If something is added at the indicated position, return
	 *         <b><i>true</i></b>, if not, return <b><i>false</i></b>.
	 */
	public boolean addSomething(Object obj, int mapX, int mapY) {
		boolean added = false;
		if (validPosition(mapX,mapY)) {
			board[mapX][mapY] = obj;
			added = true;
		}
		return added;
	}
	
	/**
	 * This method run over the array till found the indicated object. Then check if
	 * the upper position is valid, if it is, asign the object to that position and
	 * erase the object of the original position.
	 * 
	 * @param obj The object to move up.
	 * @return If something is moved return <b><i>true</i></b>, if not, return
	 *         <b><i>false</i></b>.
	 */
	public boolean moveSomethingUp(Object obj) {
		boolean movement = false;
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				if (board[x][y] == obj) {
					if (validPosition(x - 1, y)) {
						board[x - 1][y] = obj;
						board[x][y] = null;
						movement = true;
					}
				}
			}
		}
		return movement;
	}
	
	/**
	 * This method run over the array till found the indicated object. Then check if
	 * the lower position is valid, if it is, asign the object to that position and
	 * erase the object of the original position.
	 * 
	 * @param obj The object to move down.
	 * @return If something is moved return <b><i>true</i></b>, if not, return
	 *         <b><i>false</i></b>.
	 */
	public boolean moveSomethingDown(Object obj) {
		boolean movement = false;
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				if (board[x][y] == obj) {
					if (validPosition(x + 1, y)) {
						board[x + 1][y] = obj;
						board[x][y] = null;
						movement = true;
					}
				}
				if (movement) {
					break;
				}
			}
			if (movement) {
				break;
			}
		}
		return movement;
	}
	
	/**
	 * This method run over the array till found the indicated object. Then check if
	 * the right position is valid, if it is, asign the object to that position and
	 * erase the object of the original position.
	 * 
	 * @param obj The object to move to the right.
	 * @return If something is moved return <b><i>true</i></b>, if not, return
	 *         <b><i>false</i></b>.
	 */
	public boolean moveSomethingRight(Object obj) {
		boolean movement = false;
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				if (board[x][y] == obj) {
					if (validPosition(x,y + 1)) {
						board[x][y+1] = obj;
						board[x][y] = null;
						movement = true;
					}
				}
				if (movement) {
					break;
				}
			}
			if (movement) {
				break;
			}
		}
		return movement;
	}
	
	/**
	 * This method run over the array till found the indicated object. Then check if
	 * the left position is valid, if it is, asign the object to that position and
	 * erase the object of the original position.
	 * 
	 * @param obj The object to move to the left.
	 * @return If something is moved return <b><i>true</i></b>, if not, return
	 *         <b><i>false</i></b>.
	 */
	public boolean moveSomethingLeft(Object obj) {
		boolean movement = false;
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				if (board[x][y] == obj) {
					if(validPosition(x,y - 1)) {
						board[x][y-1] = obj;
						board[x][y] = null;
						movement = true;
					}
				}
			}
		}
		return movement;
	}
	
	/**
	 * This method run over the array till found the indicated object. Then check if
	 * the upper position is <b>water</b>, if it is, asign the object to that
	 * position and fill with water the original position.
	 * 
	 * @param obj The object to move up.
	 * @return If something is moved return <b><i>true</i></b>, if not, return
	 *         <b><i>false</i></b>.
	 */
	public boolean moveSomethingUpWater(Object obj) {
		boolean movement = false;
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				if (board[x][y] == obj) {
					if (isWater(x - 1, y)) {
						board[x][y] = null;
						board[x - 1][y] = obj;
						board[x][y] = new Water();
						movement = true;
					}
				}
			}
		}
		return movement;
	}
	
	/**
	 * This method run over the array till found the indicated object. Then check if
	 * the lower position is <b>water</b>, if it is, asign the object to that
	 * position and fill with water the original position.
	 * 
	 * @param obj The object to move up.
	 * @return If something is moved return <b><i>true</i></b>, if not, return
	 *         <b><i>false</i></b>.
	 */
	public boolean moveSomethingDownWater(Object obj) {
		boolean movement = false;
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				if (board[x][y] == obj) {
					if (isWater(x + 1, y)) {
						board[x][y] = null;
						board[x + 1][y] = obj;
						board[x][y] = new Water();
						movement = true;
					}
				}
				if (movement) {
					break;
				}
			}
			if (movement) {
				break;
			}
		}
		return movement;
	}
	
	/**
	 * This method run over the array till found the indicated object. Then check if
	 * the right position is <b>water</b>, if it is, asign the object to that
	 * position and fill with water the original position.
	 * 
	 * @param obj The object to move up.
	 * @return If something is moved return <b><i>true</i></b>, if not, return
	 *         <b><i>false</i></b>.
	 */
	public boolean moveSomethingRightWater(Object obj) {
		boolean movement = false;
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				if (board[x][y] == obj) {
					if (isWater(x,y + 1)) {
						board[x][y] = null;
						board[x][y+1] = obj;
						board[x][y] = new Water();
						movement = true;
					}
				}
				if (movement) {
					break;
				}
			}
			if (movement) {
				break;
			}
		}
		return movement;
	}
	
	/**
	 * This method run over the array till found the indicated object. Then check if
	 * the left position is <b>water</b>, if it is, asign the object to that
	 * position and fill with water the original position.
	 * 
	 * @param obj The object to move up.
	 * @return If something is moved return <b><i>true</i></b>, if not, return
	 *         <b><i>false</i></b>.
	 */
	public boolean moveSomethingLeftWater(Object obj) {
		boolean movement = false;
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				if (board[x][y] == obj) {
					if(isWater(x,y - 1)) {
						board[x][y] = null;
						board[x][y-1] = obj;
						board[x][y] = new Water();
						movement = true;
					}
				}
			}
		}
		return movement;
	}
	
	@Override
	public String toString() {
		
		String text = "";

		// Write the name of the town
		int midName = (int) (name.length() / 2);
		midName += 8;
		
		for (int j = 0; j < width-midName; j++) {
			text += " ";
		}
		
		text += "Town of "+this.name;
		
		text += "\n";

		// Draw the map
		for (int i = 0; i < height; i++) {

			if (i == 0) {
				text += "|";
				for (int j = 0; j < width * 2 - 1; j++) {
					text += "-";
				}
				text += "|\n";
			}

			text += "|";
			for (int j = 0; j < width; j++) {
				
				if (board[i][j] == null) {
					text += " " + "|";
				} else {
					
					// Draw the icons
					
					String superClassName = board[i][j].getClass().getSuperclass().getName();
					String className = board[i][j].getClass().getName();
					
					if (superClassName.indexOf("Man")>= 0) {
						text += ((Man)board[i][j]).getIcon()+"|";
					}
					
					if (superClassName.indexOf("Resource")>= 0) {
						text += ((Resource)board[i][j]).getIcon()+"|";
					}
					
					if (superClassName.indexOf("Tree")>= 0) {
						text += ((Tree)board[i][j]).getIcon()+"|";
					}
					
					if (superClassName.indexOf("Furniture")>= 0) {
						text += ((Furniture)board[i][j]).getIcon()+"|";
					}
					
					if (className.indexOf(".Water")>= 0) {
						text += ((Water)board[i][j]).getIcon()+"|";
					}
					
					if (superClassName.indexOf("FishWater")>= 0) {
						text += ((FishWater)board[i][j]).getIcon()+"|";
					}
					
					if (superClassName.indexOf("Animal")>= 0) {
						text += ((Animal)board[i][j]).getIcon()+"|";
					}
					
					
					// text += board[i][j].toString() + "|";
				}
				
			}
			
			text += "\n";

			if (i == height - 1) {
				text += "|";
				for (int j = 0; j < width * 2 - 1; j++) {
					text += "-";
				}
				text += "|\n";
			}

		}
		
		
		
		return text;
	}
}
