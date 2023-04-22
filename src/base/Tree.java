package base;

/**
 * A common tree template to create different type of trees. Each tree have a
 * amount of "wood" randomly generate between 2 and 10.<br>
 * The icon for the tree is '╄', unicode equivalent of the icon is 9540 
 * 
 * @author Fernando Tarriño del Pozo (FernandoEsra)
 * @see base.Resource
 *
 */

public class Tree extends Resource{
	
	public Tree(String name) {
		super("Tree", "" + (char)9540 ,0);
		int random = (int)((Math.random() * (11 - 2)) + 2);;
		this.setAmount(random);
	}
	
}
