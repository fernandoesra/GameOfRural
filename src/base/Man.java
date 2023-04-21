package base;

import main.Inventory;
import map.Board;
import resources.Money;
import utils.AleatoricName;
import utils.Movement;

public class Man implements Comparable, Movement{
	
	// Attributes
	protected String name;
	protected int ID;
	protected int HP;
	protected Money money;
	protected int mapX;
	protected int mapY;
	protected int speed;
	public String icon;
	public Inventory inventory;
	
	// Constructor
	public Man() {};
	
	public Man(int ID, int HP, Money money, int mapX, int mapY, int speed, String icon) {
		AleatoricName newName = new AleatoricName(3,10);
		this.name = newName.toString();
		this.ID = ID;
		this.HP = HP;
		this.money = money;
		this.mapX = mapX;
		this.mapY = mapY;
		this.speed = speed;
		this.icon = icon;
		this.inventory = new Inventory();
	}
	
	// Get and Set
	public String getName() {
		return this.name;
	}
	
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

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
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
		return name + ", with ID (" + ID + ") have " + HP + " life points.\n" + "Have " + money
				+ " ruralcoins, Moves " + speed + " square per turn.\n"
				+ "It is currently at (" + mapX + ").(" + mapY + ")\n"
				+ "Its icon is: " + icon + "\n" + inventory;
	};
	
	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		Man other = (Man) obj;
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
		Man other = (Man) obj;
		comparable = this.ID - other.ID;
		return comparable;
		
	}
	
	public void addMoney(Money newMoney) {
		this.money.setQuantity(this.money.getQuantity() + newMoney.getQuantity());
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
