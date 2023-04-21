package works;

import base.Man;
import resources.Money;

public class Baker extends Man{
	
	public Baker() {
		super();
	}

	public Baker(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "B"
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
