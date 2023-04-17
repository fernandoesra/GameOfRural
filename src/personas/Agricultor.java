package personas;

import base.Sujeto;
import recursos.Moneda;
import utils.ConsoleColors;

public class Agricultor extends Sujeto{

	public Agricultor() {
		super();
	}

	public Agricultor(int ID, int HP, Moneda money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "A"				
				// ConsoleColors.GREEN_BOLD+('A')+ConsoleColors.RESET
				//ConsoleColors.GREEN_BOLD+((char)10624)+ConsoleColors.RESET
				);
	}	
	
}
