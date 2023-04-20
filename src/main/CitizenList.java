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

public class CitizenList {
	
	// List
	public ObjectsList citizenList;
	int IDs;
	
	// Constructor
	public CitizenList() {
		citizenList = new ObjectsList();
		IDs = 1;
	}
	
	// Methods
	public int getLength() {
		int length = citizenList.getLength();
		return length;
	}
	
	// Add diferent citizens
	public void addCitizensToMap(Board board) {
		
		int mapX = board.getHeight();
		int mapY = board.getWidth();
		
		for (int i = 0; i < citizenList.getLength(); i++) {
			
			int tryMapX = 0;
			int tryMapY = 0;
			
			do {
				tryMapX = (int)((Math.random() * (mapX - 0)) + 0);
				tryMapY = (int)((Math.random() * (mapY - 0)) + 0);
			} while (board.validPosition(tryMapX, tryMapY) == false);
			
			board.addSomething(citizenList.getObjectOnIndex(i), tryMapX, tryMapY);
			Man a1 = (Man)citizenList.getObjectOnIndex(i);
			a1.setMapX(tryMapX);
			a1.setMapY(tryMapY);

		}
	}
	
	/**
	 * 
	 * @param ID to search
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
	
	public String getInfoID(int ID) {
		String info = "";
		
		if ((Man)this.searchForCitizen(ID) != null) {
			Man search = (Man)this.searchForCitizen(ID);
			info = search.toString();
		}
		return info;
	}
	
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
	
	public void createFarmer(int amount) {
		
		for (int i = 0; i < amount; i++) {
			Farmer newCitizen = new Farmer(IDs,30,actualMoney(),0,0,1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	public void createButcher(int amount) {

		for (int i = 0; i < amount; i++) {
			Butcher newCitizen = new Butcher(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	public void createCarpenter(int amount) {

		for (int i = 0; i < amount; i++) {
			Carpenter newCitizen = new Carpenter(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	public void createBlackmisth(int amount) {

		for (int i = 0; i < amount; i++) {
			Money zeroMoney = new Money(0);
			Blackmisth newCitizen = new Blackmisth(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	public void createLumberjack(int amount) {

		for (int i = 0; i < amount; i++) {
			Lumberjack newCitizen = new Lumberjack(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	public void createMiner(int amount) {

		for (int i = 0; i < amount; i++) {
			Miner newCitizen = new Miner(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	public void createBaker(int amount) {

		for (int i = 0; i < amount; i++) {
			Baker newCitizen = new Baker(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	public void createShepherd(int amount) {

		for (int i = 0; i < amount; i++) {
			Shepherd newCitizen = new Shepherd(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	public void createFishmonger(int amount) {

		for (int i = 0; i < amount; i++) {
			Fishmonger newCitizen = new Fishmonger(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	public void createFisherman(int amount) {

		for (int i = 0; i < amount; i++) {
			Fisherman newCitizen = new Fisherman(IDs, 30, actualMoney(), 0, 0, 1);
			citizenList.addEnd(newCitizen);
			IDs++;
		}
	}
	
	public Money actualMoney() {
		// return zeroMoney();
		return aleatoricMoney();
	}
	
	public Money zeroMoney() {
		Money zeroMoney = new Money(0);
		return zeroMoney;
	}
	
	public Money aleatoricMoney() {
		double random = ((Math.random() * (101 - 1)) + 1);
		Money randomMoney = new Money(random);
		return randomMoney;
	}
	
}
