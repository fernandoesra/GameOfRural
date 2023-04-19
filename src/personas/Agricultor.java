package personas;

import base.Man;
import recursos.Money;
import utils.ConsoleColors;

public class Agricultor extends Man{

	public Agricultor() {
		super();
	}

	public Agricultor(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "A"				
				// ConsoleColors.GREEN_BOLD+('A')+ConsoleColors.RESET
				//ConsoleColors.GREEN_BOLD+((char)10624)+ConsoleColors.RESET
				);
	}	
	
}
