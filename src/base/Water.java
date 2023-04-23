package base;

/**
 * The functionality of the water object is to fill positions in the Board, so
 * that it generates "rivers" whit "collision". This is important to define
 * since the funcion board.isValid(x,y) takes into account if there is water in
 * the x.y position to determine if its valid or not.<br>
 * The icon for the water is '≈', unicode equivalent of the icon is 8776 
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see map.Board
 */

public class Water {
	
	String icon;
	
	public Water() {
		icon = ""+(char)8776;
	}
	
	public String getIcon() {
		return icon;
	}

}
