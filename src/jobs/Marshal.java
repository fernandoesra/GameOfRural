package jobs;

import java.util.Iterator;

import base.Man;
import logs.ActionsLog;
import main.CitizenList;
import map.Board;
import resources.Money;

/**
 * A specialization of Man. The Marshal walks through the map in search of other
 * citizens . When found one, call the method beCareful().<br>
 * The icon for the Marshal are 'A'.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Man
 * @see map.Board
 * @see main.InteractController
 * @see main.MoveController
 * 
 */

public class Marshal extends Man{
	
	/**
	 * Do not use
	 */
	protected Marshal() {
		super();
	}

	/**
	 * Create a new Marshal and set the icon to 'A'.<br>
	 * The Man object create a random name automatically.
	 * 
	 * @param ID    The ID for the Marshal.
	 * @param HP    Starting life points (HP) of the Marshal.
	 * @param money Starting Money of the Marshal.
	 * @param mapX  Starting height position on the Board.
	 * @param mapY  Starting width position on the Board.
	 * @param speed Starting speed of the Marshal.
	 */
	public Marshal(int ID, int HP, Money money, int mapX, int mapY, int speed) {
		super(ID, HP, money, mapX, mapY, speed, "A"
				);
	}
	
	/**
	 * This method write a action log saying "be careful" to a adjacent citizen.
	 * 
	 * @param citizen An adjacent citizen to be told to be careful.
	 * @param board   A board to get the name of the city for the log.
	 * 
	 */
	public void beCareful(Man citizen, Board board) {
		ActionsLog.registerAction(this.name + "(" + this.ID +") advises " + citizen.getName() + "(" + citizen.getID() + ""
				+ ") to be careful, " + board.getName() + "'s streets are dangerous.");
	}
	
	/*
	 * TODO
	 */
	public double distributeTaxes(CitizenList citizenList) {
		double distributeToEach = 0d;
		Mayor actualMayor = (Mayor) citizenList.searchForCitizen("Mayor");
		
		double taxesTotalValue = actualMayor.getTaxes().getQuantity();
		int totalCitizens = citizenList.getLength();
		distributeToEach = taxesTotalValue / totalCitizens;
		
		for (int i = 0; i < totalCitizens; i++) {
			Man actualCitizen = (Man) citizenList.searchForCitizen(i+1);
			actualCitizen.getMoney().setQuantity(distributeToEach + actualCitizen.getMoney().getQuantity());
		}
		
		Money zeroMoney = new Money(0);
		actualMayor.setTaxes(zeroMoney);
		
		return distributeToEach;
	}

	@Override
	public String toString() {
		String toReturn = super.toString();
		char jobChar[] = this.getClass().getName().toCharArray();
		String jobName = "";
		for (int i = 5; i < jobChar.length; i++) {
			jobName += jobChar[i];
		}
		
		toReturn += this.name + "'s job is to be a " + jobName;
		
		return toReturn;
	}
	
	
}
