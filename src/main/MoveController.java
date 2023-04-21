package main;

import base.Man;
import logs.ActionsLog;
import map.Board;

public class MoveController {
	
	public static void movementLog(Man citizen) {
		ActionsLog.registerAction(citizen.getName() + "(" + citizen.getID() + ") has beem moved to "
	+ citizen.getMapX() + "." + citizen.getMapY());
	}
	
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