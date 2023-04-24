package main;

import base.Man;
import logs.ActionsLog;
import map.Board;

/**
 * This class is used to move different Man objects inside the matrix of the Board.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @see base.Man
 * @see map.Board
 * @see logs.ActionsLog
 * @see main.CitizenList
 *
 */

public class MoveController {
	
	/**
	 * This method register the movement of one Man object on the ActionsLog.
	 * 
	 * @param citizen The citizen from whom to obtain the X and Y values for the log.
	 */
	public static void movementLog(Man citizen) {
		ActionsLog.registerAction(citizen.getName() + "(" + citizen.getID() + ") has beem moved to "
	+ citizen.getMapX() + "." + citizen.getMapY());
	}
	
	/**
	 * This method move the citizen up X times where X is the citizenSpeed value.
	 * 
	 * @param board   The map where the citizen will move.
	 * @param citizen The citizen to move.
	 */
	public static void moveOneCitizenUp(Board board, Man citizen) {
		
		int citizenSpeed = citizen.getSpeed();
		
		for (int i = 0; i < citizenSpeed; i++) {
			if (citizen.up(board)) {
				board.moveSomethingUp(citizen);
				int newX = board.searchXobject(citizen);
				int newY = board.searchYobject(citizen);
				citizen.update(newX, newY);
				
				/* If you want to record the movement of the character in the log, you must
				uncomment the following line */ 
				// movementLog(citizen);
			}
		}
	}
	
	/**
	 * This method move the citizen down X times where X is the citizenSpeed value.
	 * 
	 * @param board   The map where the citizen will move.
	 * @param citizen The citizen to move.
	 */
	public static void moveOneCitizenDown(Board board, Man citizen) {

		int citizenSpeed = citizen.getSpeed();
		
		for (int i = 0; i < citizenSpeed; i++) {
			if (citizen.down(board)) {
				board.moveSomethingDown(citizen);
				int newX = board.searchXobject(citizen);
				int newY = board.searchYobject(citizen);
				citizen.update(newX, newY);

				/*
				 * If you want to record the movement of the character in the log, you must
				 * uncomment the following line
				 */
				// movementLog(citizen);
			}
		}
	}
	
	/**
	 * This method move the citizen to the right X times where X is the citizenSpeed
	 * value.
	 * 
	 * @param board   The map where the citizen will move.
	 * @param citizen The citizen to move.
	 */
	public static void moveOneCitizenRight(Board board, Man citizen) {
		
		int citizenSpeed = citizen.getSpeed();

		for (int i = 0; i < citizenSpeed; i++) {
			if (citizen.right(board)) {
				board.moveSomethingRight(citizen);
				int newX = board.searchXobject(citizen);
				int newY = board.searchYobject(citizen);
				citizen.update(newX, newY);

				/*
				 * If you want to record the movement of the character in the log, you must
				 * uncomment the following line
				 */
				// movementLog(citizen);
			}
		}
	}
	
	/**
	 * This method move the citizen to the left X times where X is the citizenSpeed
	 * value.
	 * 
	 * @param board   The map where the citizen will move.
	 * @param citizen The citizen to move.
	 */
	public static void moveOneCitizenLeft(Board board, Man citizen) {
		
		int citizenSpeed = citizen.getSpeed();

		for (int i = 0; i < citizenSpeed; i++) {
			if (citizen.left(board)) {
				board.moveSomethingLeft(citizen);
				int newX = board.searchXobject(citizen);
				int newY = board.searchYobject(citizen);
				citizen.update(newX, newY);

				/*
				 * If you want to record the movement of the character in the log, you must
				 * uncomment the following line
				 */
				// movementLog(citizen);
			}
		}
	}
	
	/**
	 * This method read a CitizenList and, for each citizen in the list, generate
	 * one random direction (up, down, left, right) and move the citizen in that
	 * direction. If is also possible that it will not move. The percentage of
	 * each direction it of the 25%.
	 * 
	 * @param board    The map where the citizens will move.
	 * @param citizens The citizenList whit all the citizens in the map.
	 */
	public static void moveAllCitizens(Board board, CitizenList citizens) {

		int citizensTotal = citizens.citizenList.getLength();

		for (int j = 0; j < citizensTotal; j++) {
			Man actual = (Man) citizens.citizenList.getObjectOnIndex(j);

			int citizenSpeed = actual.getSpeed();
			
			for (int i = 0; i < citizenSpeed; i++) {

				int direction = (int) ((Math.random() * (5 - 1)) + 1);

				if (direction == 1 && actual.up(board)) {
					board.moveSomethingUp(actual);
					int newX = board.searchXobject(actual);
					int newY = board.searchYobject(actual);
					actual.update(newX, newY);
				}

				if (direction == 2 && actual.down(board)) {
					board.moveSomethingDown(actual);
					int newX = board.searchXobject(actual);
					int newY = board.searchYobject(actual);
					actual.update(newX, newY);
				}

				if (direction == 3 && actual.right(board)) {
					board.moveSomethingRight(actual);
					int newX = board.searchXobject(actual);
					int newY = board.searchYobject(actual);
					actual.update(newX, newY);
				}

				if (direction == 4 && actual.left(board)) {
					board.moveSomethingLeft(actual);
					int newX = board.searchXobject(actual);
					int newY = board.searchYobject(actual);
					actual.update(newX, newY);
				}

				/*
				 * If you want to record the movement of the character in the log, you must
				 * uncomment the following line
				 */
				// movementLog(actual);

			}

		}

	}

}
