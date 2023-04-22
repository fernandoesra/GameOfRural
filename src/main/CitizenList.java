package main;

import base.Man;
import map.Board;
import resources.Money;
import utils.ObjectsList;
import works.Farmer;
import works.Butcher;
import works.Carpenter;
import works.Blackmisth;
import works.Lumberjack;
import works.Miner;
import works.Baker;
import works.Shepherd;
import works.Fishmonger;
import works.Fisherman;

/**
 * This class store a ObjectsList for the citizens that populate the map. Only
 * work with Man objects.
 * 
 * @author Fernando Tarriño del Pozo (FernandoEsra)
 * @see base.Man
 * @see resources.Money
 *
 */

public class CitizenList {
	
	// List
	public ObjectsList citizenList;
	int IDs;
	
	/**
	 * The empty constructor initialize the ObjectsList to a new empty ObjectsList
	 * and the IDs attribute to 1.<br>
	 * Because of that every time that a new citizen is created its possible to
	 * control the ids.
	 */
	public CitizenList() {
		citizenList = new ObjectsList();
		IDs = 1;
	}
	
	/**
	 * This method return the citizenList.length
	 * 
	 * @return The amount of citizens in the list.
	 */
	public int getLength() {
		int length = citizenList.getLength();
		return length;
	}
	
	/**
	 * This method read all the citizenList and add, in random valid positions, the
	 * citizens to the map.<br>
	 * <b>Important: </b>This method add <b>all</b> the citizens to the map. If only
	 * wants to add one it is necessary to use the method addLastCitizen().
	 * 
	 * @param board The map to fill.
	 */
	public void addAllCitizensToMap(Board board) {
		
		int mapX = board.getHeight();
		int mapY = board.getWidth();
		
		for (int i = 0; i < citizenList.getLength(); i++) {
			
			int tryMapX = 0;
			int tryMapY = 0;
			
			do {
				tryMapX = (int)((Math.random() * (mapX - 0)) + 0);
				tryMapY = (int)((Math.random() * (mapY - 0)) + 0);
			} while (!board.validPosition(tryMapX, tryMapY));
			
			board.addSomething(citizenList.getObjectOnIndex(i), tryMapX, tryMapY);
			Man a1 = (Man)citizenList.getObjectOnIndex(i);
			a1.setMapX(tryMapX);
			a1.setMapY(tryMapY);

		}
	}
	
	/**
	 * This method add the last citizen of the citizenList to a random valid
	 * position of the board.
	 * 
	 * @param board The map where to place the last citizen of the citizenList.
	 */
	public void addLastCitizen(Board board) {
		int mapX = board.getHeight();
		int mapY = board.getWidth();
		int tryMapX = 0;
		int tryMapY = 0;
		
		do {
			tryMapX = (int)((Math.random() * (mapX - 0)) + 0);
			tryMapY = (int)((Math.random() * (mapY - 0)) + 0);
		} while (!board.validPosition(tryMapX, tryMapY));
		
		int lastIndex = this.getLength()-1;
		
		board.addSomething(citizenList.getObjectOnIndex(lastIndex), tryMapX, tryMapY);
		Man a1 = (Man)citizenList.getObjectOnIndex(lastIndex);
		a1.setMapX(tryMapX);
		a1.setMapY(tryMapY);
	}
	
	/**
	 * Search in the citizenList for one citizen with a specifies ID.
	 * 
	 * @param ID A int to search
	 * @return If the citizen with the ID are on the list, return that citizen
	 */
	public Object searchForCitizen(int ID) {
		Object find = null;
		for (int i = 0; i < citizenList.getLength(); i++) {
			
			Man toFind = (Man) citizenList.getObjectOnIndex(i);
			
			if (toFind.getID() == ID) {
				find = toFind;
			}
		}
		return find;
	}
	
	@Override
	public String toString() {
		String respuesta = "";
		
		for (int i = 0; i < citizenList.getLength(); i++) {
			
			respuesta += "Citizen "+(i+1)+": "+ citizenList.getObjectOnIndex(i).toString() + "\n\n";
		}
		
		return respuesta;
	}
	
	/**
	 * Search for the Man.toString() of a citizen consulting for the ID.
	 * 
	 * @param ID A int to search
	 * @return If the citizen with the ID are on the list, return that
	 *         <b>citizen.toString</b>. Only work with Man objects. If the ID not
	 *         exists return an empty String.
	 */
	public String getInfoID(int ID) {
		String info = "";
		
		if ((Man)this.searchForCitizen(ID) != null) {
			Man search = (Man)this.searchForCitizen(ID);
			info = search.toString();
		}
		return info;
	}
	
	/**
	 * Search for the ID of one citizen.
	 * 
	 * @param search The Man object for witch the ID is to be obtained.
	 * @return If the citizen exists on the citizenList, return is ID. If not,
	 *         return 0.
	 */
	public int getCitizenID(Man search) {
		int ID = 0;
		for (int i = 0; i < citizenList.getLength(); i++) {
			if (citizenList.getObjectOnIndex(i) == search) {
				Man find = (Man) citizenList.getObjectOnIndex(i);
				ID = find.getID();
			}
		}
		return ID;
	}
	
	
	public void createAll(int total) {
		this.createFarmer(total);
		this.createButcher(total);
		this.createCarpenter(total);
		this.createBlackmisth(total);
		this.createLumberjack(total);
		this.createMiner(total);
		this.createBaker(total);
		this.createShepherd(total);
		this.createFishmonger(total);
		this.createFisherman(total);
	}
	
	/**
	 * This method create 'x' amount of <b>Farmers</b> and adds them to the
	 * citizenList. <b>Important: </b>This method only create the objects and add
	 * them to the citizenList, does not add them to the map. To add the citizens it
	 * is necessary to use the methods addCitizensToMap(board) or
	 * addLastCitizen(board).
	 * <p>
	 * The money of the new citizen its set in the actualMoney() method.
	 * 
	 * @param amount Hoy many <b>Farmers</b> want to create.
	 */
	public void createFarmer(int amount) {
		
		for (int i = 0; i < amount; i++) {
			Farmer newCitizen = new Farmer(IDs,30,actualMoney(),0,0,1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	/**
	 * This method create 'x' amount of <b>Butchers</b> and adds them to the
	 * citizenList. <b>Important: </b>This method only create the objects and add
	 * them to the citizenList, does not add them to the map. To add the citizens it
	 * is necessary to use the methods addCitizensToMap(board) or
	 * addLastCitizen(board).
	 * <p>
	 * The money of the new citizen its set in the actualMoney() method.
	 * 
	 * @param amount Hoy many <b>Butchers</b> want to create.
	 */
	public void createButcher(int amount) {

		for (int i = 0; i < amount; i++) {
			Butcher newCitizen = new Butcher(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	/**
	 * This method create 'x' amount of <b>Carpenters</b> and adds them to the
	 * citizenList. <b>Important: </b>This method only create the objects and add
	 * them to the citizenList, does not add them to the map. To add the citizens it
	 * is necessary to use the methods addCitizensToMap(board) or
	 * addLastCitizen(board).
	 * <p>
	 * The money of the new citizen its set in the actualMoney() method.
	 * 
	 * @param amount Hoy many <b>Carpenters</b> want to create.
	 */
	public void createCarpenter(int amount) {

		for (int i = 0; i < amount; i++) {
			Carpenter newCitizen = new Carpenter(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	/**
	 * This method create 'x' amount of <b>Blackmisths</b> and adds them to the
	 * citizenList. <b>Important: </b>This method only create the objects and add
	 * them to the citizenList, does not add them to the map. To add the citizens it
	 * is necessary to use the methods addCitizensToMap(board) or
	 * addLastCitizen(board).
	 * <p>
	 * The money of the new citizen its set in the actualMoney() method.
	 * 
	 * @param amount Hoy many <b>Blackmisths</b> want to create.
	 */
	public void createBlackmisth(int amount) {

		for (int i = 0; i < amount; i++) {
			Blackmisth newCitizen = new Blackmisth(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	/**
	 * This method create 'x' amount of <b>Lumberjacks</b> and adds them to the
	 * citizenList. <b>Important: </b>This method only create the objects and add
	 * them to the citizenList, does not add them to the map. To add the citizens it
	 * is necessary to use the methods addCitizensToMap(board) or
	 * addLastCitizen(board).
	 * <p>
	 * The money of the new citizen its set in the actualMoney() method.
	 * 
	 * @param amount Hoy many <b>Lumberjacks</b> want to create.
	 */
	public void createLumberjack(int amount) {

		for (int i = 0; i < amount; i++) {
			Lumberjack newCitizen = new Lumberjack(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	/**
	 * This method create 'x' amount of <b>Miners</b> and adds them to the
	 * citizenList. <b>Important: </b>This method only create the objects and add
	 * them to the citizenList, does not add them to the map. To add the citizens it
	 * is necessary to use the methods addCitizensToMap(board) or
	 * addLastCitizen(board).
	 * <p>
	 * The money of the new citizen its set in the actualMoney() method.
	 * 
	 * @param amount Hoy many <b>Miners</b> want to create.
	 */
	public void createMiner(int amount) {

		for (int i = 0; i < amount; i++) {
			Miner newCitizen = new Miner(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	/**
	 * This method create 'x' amount of <b>Bakers</b> and adds them to the
	 * citizenList. <b>Important: </b>This method only create the objects and add
	 * them to the citizenList, does not add them to the map. To add the citizens it
	 * is necessary to use the methods addCitizensToMap(board) or
	 * addLastCitizen(board).
	 * <p>
	 * The money of the new citizen its set in the actualMoney() method.
	 * 
	 * @param amount Hoy many <b>Bakers</b> want to create.
	 */
	public void createBaker(int amount) {

		for (int i = 0; i < amount; i++) {
			Baker newCitizen = new Baker(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	/**
	 * This method create 'x' amount of <b>Shepherds</b> and adds them to the
	 * citizenList. <b>Important: </b>This method only create the objects and add
	 * them to the citizenList, does not add them to the map. To add the citizens it
	 * is necessary to use the methods addCitizensToMap(board) or
	 * addLastCitizen(board).
	 * <p>
	 * The money of the new citizen its set in the actualMoney() method.
	 * 
	 * @param amount Hoy many <b>Shepherds</b> want to create.
	 */
	public void createShepherd(int amount) {

		for (int i = 0; i < amount; i++) {
			Shepherd newCitizen = new Shepherd(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	/**
	 * This method create 'x' amount of <b>Fishmongers</b> and adds them to the
	 * citizenList. <b>Important: </b>This method only create the objects and add
	 * them to the citizenList, does not add them to the map. To add the citizens it
	 * is necessary to use the methods addCitizensToMap(board) or
	 * addLastCitizen(board).
	 * <p>
	 * The money of the new citizen its set in the actualMoney() method.
	 * 
	 * @param amount Hoy many <b>Fishmongers</b> want to create.
	 */
	public void createFishmonger(int amount) {

		for (int i = 0; i < amount; i++) {
			Fishmonger newCitizen = new Fishmonger(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	/**
	 * This method create 'x' amount of <b>Fishermans</b> and adds them to the
	 * citizenList. <b>Important: </b>This method only create the objects and add
	 * them to the citizenList, does not add them to the map. To add the citizens it
	 * is necessary to use the methods addCitizensToMap(board) or
	 * addLastCitizen(board).
	 * <p>
	 * The money of the new citizen its set in the actualMoney() method.
	 * 
	 * @param amount Hoy many <b>Fishermans</b> want to create.
	 */
	public void createFisherman(int amount) {

		for (int i = 0; i < amount; i++) {
			Fisherman newCitizen = new Fisherman(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	/**
	 * This method is used on the createX(board) methods to determine how much money
	 * have the new citizens. There are tow methods to controll the ranges.
	 * zeroMoney() to set the amount to 0 and aleatoricMoney() to set the money
	 * between 1 and 100.
	 * 
	 * @return A new Money object with a defined amount attribute.
	 */
	public Money actualMoney() {
		// return zeroMoney();
		return aleatoricMoney();
	}
	
	/**
	 * This method is used in actualMoney() to create new citizens without money.
	 * 
	 * @return A new Money object with 0 value on the amount attribute.
	 */
	public Money zeroMoney() {
		Money zeroMoney = new Money(0);
		return zeroMoney;
	}
	
	/**
	 * This method is used in actualMoney() to create new citizens with random
	 * amount of money between 1 and 100.
	 * 
	 * @return A new Money object with a random value between 1 and 100 on the
	 *         amount attribute.
	 */
	public Money aleatoricMoney() {
		
		int minMoney = 1;			/* Change to set the min range for the random */
		int maxMoney = 100;			/* Change to set the max range for the random */
		
		double random = ((Math.random() * ((maxMoney+1) - minMoney)) + minMoney);
		Money randomMoney = new Money(random);
		return randomMoney;
	}
	
}
