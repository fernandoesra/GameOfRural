package base;

/**
 * A common tree template to create different type of trees. Each tree have a
 * amount of "wood" randomly generate between 2 and 10.<br>
 * The icon for the tree is '╄', unicode equivalent of the icon is 9540 
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Resource
 *
 */

public class Tree extends Resource{
	
	/**
	 * Create a new tree. The only difference between one tree and another is the
	 * name and the amount of 'wood'.<br>
	 * The amount of wood are randomly generate between 2 and 10.
	 * 
	 * @param name A name for the tree. By default: <b>Tree</b>
	 */
	public Tree(String name) {
		super("Tree", "" + (char)9540 ,0);
		int random = (int)((Math.random() * (11 - 2)) + 2);;
		this.setAmount(random);
	}
	
}
