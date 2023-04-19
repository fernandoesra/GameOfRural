package works;

import base.Man;
import gameResources.Money;

public class Carpenter extends Man{
	
	public Carpenter() {
		super();
	}

	public Carpenter(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "I"
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
		
		toReturn += "His job is to be a " + jobName;
		
		return toReturn;
	}

}
