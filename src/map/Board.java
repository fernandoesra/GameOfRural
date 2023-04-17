package map;

import base.Sujeto;
import utils.AleatoricName;

public class Board {
	
	// Attributes
	public Object board[][];
	String name;
	int height;
	int width;
	
	// Constructor
	/**
	 * The empty constructor are used to create a new board with correct dimensions
	 * to display in the Eclipse console.
	 */
	public Board() {
		AleatoricName newName = new AleatoricName();
		this.name = newName.toString();
		newName = null;
		board = new Object[28][50];
		this.height = board.length;
		this.width = board[0].length;
	};
	
	/**
	 * 
	 * @param Length for height
	 * @param Length for width
	 */
	public Board(int height, int width) {
		AleatoricName newName = new AleatoricName();
		this.name = newName.toString();
		newName = null;
		board = new Object[height][width];
		this.height = height;
		this.width = width;
	};
	
	// Get y Set
	
	public Object[][] getBoard() {
		return board;
	}

	public void setBoard(Object[][] board) {
		this.board = board;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	// Methods
	
	/**
	 * 
	 * @param Length for board (height). First coordinate.
	 * @param Length for board[] [width]. Second coordinate.
	 * @return If the coordinates are inside the bounds return true. If the
	 *         coordinates are OOB, return false.
	 */
	public boolean inBounds(int newX, int newY) {
		boolean valid = false;
		if (newX >= 0 && newX < height && newY >= 0 && newY < width) {
			valid = true;
		}
		return valid;
	}
	
	/**
	 * 
	 * @param Length for board (height). First coordinate.
	 * @param Length for board[] [width]. Second coordinate.
	 * @return If the coordinates are inside the bounds and empty (null) return
	 *         true. If not, return false;
	 */
	public boolean validPosition(int newX, int newY) {
		boolean valid = false;
		if (inBounds(newX, newY) && board[newX][newY] == null) {
			valid = true;
		}
		return valid;
	}

	/**
	 * 
	 * @param Object to search in the board
	 * @return If the object exists, return the heigth index. If not, return -1.
	 */
	public int searchXobject(Object obj) {
		
		int newX = -1;
		
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				
				if (board[x][y] == obj) {
					newX = x;
				}
				
			}
			
		}
		
		return newX;
	}
	
	/**
	 * 
	 * @param Object to search in the board
	 * @return If the object exists, return the width index. If not, return -1. 
	 */
	public int searchYobject(Object obj) {

		int newY = -1;

		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {

				if (board[x][y] == obj) {
					newY = y;
				}

			}

		}

		return newY;
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
					if (superClassName.indexOf("Sujeto")>= 0) {
						text += ((Sujeto)board[i][j]).getIcon()+"|";
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
