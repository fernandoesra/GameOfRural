package utils;

import map.Board;

/**
 * This interface forces implementers to write the methods of the different
 * movement actions on a board. For an example, see the <b>base.Man</b> class.
 * 
 * @author Fernando Tarriño del Pozo (FernandoEsra)
 * @see base.Man
 */
public interface Movement {
	
	/**
	 * Check if its possible to move the object up.
	 * 
	 * @param board A Board object for the map
	 * @return <b><i>true</i></b> If its possible to move the object,
	 *         <b><i>false</i></b> if not
	 */
	public boolean up(Board board);
	
	/**
	 * Check if its possible to move the object down.
	 * 
	 * @param board A Board object for the map
	 * @return <b><i>true</i></b> If its possible to move the object,
	 *         <b><i>false</i></b> if not
	 */
	public boolean down(Board board);
	
	/**
	 * Check if its possible to move the object to the right.
	 * 
	 * @param board A Board object for the map
	 * @return <b><i>true</i></b> If its possible to move the object,
	 *         <b><i>false</i></b> if not
	 */
	public boolean right(Board board);
	
	/**
	 * Check if its possible to move the object to the left.
	 * 
	 * @param board A Board object for the map
	 * @return <b><i>true</i></b> If its possible to move the object,
	 *         <b><i>false</i></b> if not
	 */
	public boolean left(Board board);
	
	/**
	 * Check if its possible to move the object to (posX).(posY).
	 * 
	 * @param board A Board object for the map
	 * @param posX A coordinate value for the X of the bidimensional array
	 * @param posY A coordinate value for the Y of the bidimensional array
	 * @return <b><i>true</i></b> If its possible to move the object,
	 *         <b><i>false</i></b> if not
	 */
	public boolean toPosition(Board board, int posX, int posY);

}
