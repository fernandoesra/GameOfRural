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
	
	public boolean up(Board board);
	
	public boolean down(Board board);
	
	public boolean right(Board board);
	
	public boolean left(Board board);
	
	public boolean toPosition(Board board, int posX, int posY);

}
