package base;

import map.Board;
import recursos.Moneda;
import utils.AleatoricName;
import utils.Movimiento;

public class Sujeto implements Comparable, Movimiento{
	
	// Attributes
	protected String name;
	protected int ID;
	protected int HP;
	protected Moneda money;
	protected int mapX;
	protected int mapY;
	protected int speed;
	public String icon;
	
	// Constructor
	public Sujeto() {};
	
	public Sujeto(int ID, int HP, Moneda money, int mapX, int mapY, int speed, String icon) {
		AleatoricName newName = new AleatoricName(3,20);
		this.name = newName.toString();
		this.ID = ID;
		this.HP = HP;
		this.money = money;
		this.mapX = mapX;
		this.mapY = mapY;
		this.speed = speed;
		this.icon = icon;
	}
	
	// Get and Set
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public Moneda getMoney() {
		return money;
	}

	public void setMoney(Moneda money) {
		this.money = money;
	}

	public int getMapX() {
		return mapX;
	}

	public void setMapX(int mapX) {
		this.mapX = mapX;
	}

	public int getMapY() {
		return mapY;
	}

	public void setMapY(int mapY) {
		this.mapY = mapY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	};
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	// Methods
	public String toString() {
		return name + ", con ID (" + ID + ") tiene actualmente " + HP + " puntos de vida.\n" + "Tiene " + money
				+ " turbo dolares, se mueve a una velocidad de " + speed + " casillas por segundo.\n"
				+ "Actualmente se encuentra en la posicion (" + mapX + ").(" + mapY + ") del escenario. \n"
				+ "Su icono en el mapa es: " + icon;
	};
	
	@Deprecated
	public String getInfo() {
		return name + ", con ID (" + ID + ") tiene actualmente " + HP + " puntos de vida.\n" + "Tiene " + money
				+ " turbo dolares, se mueve a una velocidad de " + speed + " casillas por segundo.\n"
				+ "Actualmente se encuentra en la posicion (" + mapX + ").(" + mapY + ") del escenario. \n"
				+ "Su icono en el mapa es: " + icon;
	}

	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		Sujeto other = (Sujeto) obj;
		if(
			other.ID == this.ID &&
			other.HP == this.HP &&
			other.speed == this.speed &&
			other.money == this.money &&
			other.mapX == this.mapX &&
			other.mapY == this.mapY &&
			other.icon == this.icon
			)
		{
			equals = true;
		}

		return equals;
	}

	@Override
	public int compareTo(Object obj) {
		
		int comparable = 0;
		Sujeto other = (Sujeto) obj;
		comparable = this.ID - other.ID;
		return comparable;
		
	}
	
	public void update(int newX, int newY) {
		this.mapX = newX;
		this.mapY = newY;
	}
	
	@Override
	public boolean up(Board board) {
		boolean movement = false;
		
		if (board.validPosition(mapX - 1, mapY)) {
			movement = true;
		}
		
		return movement;
	}

	@Override
	public boolean down(Board board) {
		boolean movement = false;

		if (board.validPosition(mapX + 1, mapY)) {
			movement = true;
		}

		return movement;
	}

	@Override
	public boolean right(Board board) {
		boolean movement = false;

		if (board.validPosition(mapX, mapY + 1)) {
			movement = true;
		}

		return movement;
	}

	@Override
	public boolean left(Board board) {
		boolean movement = false;

		if (board.validPosition(mapX, mapY - 1)) {
			movement = true;
		}

		return movement;
	}

	@Override
	public boolean toPosition(Board board, int posX, int posY) {
		boolean movement = false;

		if (board.validPosition(posX, posY)) {
			movement = true;
		}

		return movement;
	}

}
