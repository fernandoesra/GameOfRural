package utils;

import map.Board;

public interface Movement {
	
	public boolean up(Board board);
	
	public boolean down(Board board);
	
	public boolean right(Board board);
	
	public boolean left(Board board);
	
	public boolean toPosition(Board board, int posX, int posY);

}
