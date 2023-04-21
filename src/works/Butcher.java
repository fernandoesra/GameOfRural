package works;

import base.Man;
import resources.Money;

public class Butcher extends Man{
	
	public Butcher() {
		super();
	}

	public Butcher(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "K"
				);
	}
	
	@Override
	public String toString() {
		String toReturn = super.toString();
		char jobChar[] = this.getClass().getName().toCharArray();
		String jobName = "";
		for (int i = 6; i < jobChar.length; i++) {
			jobName += jobChar[i];
		}
		
		toReturn += this.name + "'s job is to be a " + jobName;
		
		return toReturn;
	}

}
