package map;

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
	 * @param Length for height
	 * @param Length for width
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
			if (className.indexOf("Water")>=0) {
				water = true;
			}
		}
		
		return water;
	}

	/**
	 * This method check if one position on the map are inside the limites and has
	 * nothing inside.
	 * 
	 * @param Length for board (height). First coordinate.
	 * @param Length for board[] [width]. Second coordinate.
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
	 * 
	 * @param searchX
	 * @param searchY
	 * @return
	 */
	public String getNameOfItem(int searchX, int searchY) {
		String nameOfItem = "";
		if (!this.validPosition(searchX, searchY)) {
			nameOfItem = board[searchX][searchY].getClass().getName();
		}
		return nameOfItem;
	}
	
	public Object getObjectAt(int searchX, int searchY) {
		Object searched = null;
		if (!this.validPosition(searchX, searchY)) {
			searched = board[searchX][searchY];
		}
		return searched;
	}
	
	public boolean eraseObjectAt(int searchX, int searchY) {
		boolean erased = false;
		if (!this.validPosition(searchX, searchY)) {
			board[searchX][searchY] = null;
		}
		return erased;
	}
	
	public boolean addSomething(Object obj, int mapX, int mapY) {
		boolean added = false;
		if (validPosition(mapX,mapY)) {
			board[mapX][mapY] = obj;
			added = true;
		}
		return added;
	}
	
	public void moveSomethingUp(Object obj) {
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				
				if (board[x][y] == obj) {
					board[x-1][y] = obj;
					board[x][y] = null;
				}
				
			}
			
		}
	}
	
	public void moveSomethingDown(Object obj) {
		boolean movement = false;
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				
				if (board[x][y] == obj) {
					board[x+1][y] = obj;
					board[x][y] = null;
					movement = true;
				}
				
				if (movement) {
					break;
				}
			}
			if (movement) {
				break;
			}
			
		}
	}
	
	public void moveSomethingRight(Object obj) {
		boolean movement = false;
		
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				
				if (board[x][y] == obj) {
					board[x][y+1] = obj;
					board[x][y] = null;
					movement = true;
				}
				if (movement) {
					break;
				}
			}
			if (movement) {
				break;
			}
			
		}
	}
	
	public void moveSomethingLeft(Object obj) {
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				
				if (board[x][y] == obj) {
					board[x][y-1] = obj;
					board[x][y] = null;
				}
				
			}
			
		}
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
					
					if (className.indexOf("Water")>= 0) {
						text += ((Water)board[i][j]).getIcon()+"|";
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
