package works;

import base.Man;
import gameResources.Money;
import utils.ConsoleColors;

public class Farmer extends Man{

	public Farmer() {
		super();
	}

	public Farmer(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "F"				
				// ConsoleColors.GREEN_BOLD+('F')+ConsoleColors.RESET
				//ConsoleColors.GREEN_BOLD+((char)10624)+ConsoleColors.RESET
				);
	}	
	
}
