package model;

import java.util.Random;

/**
 * The responsibility of CatController is to control its 
 * associated Cat object.
 * 
 * @author ChaTeam
 *
 */
public class CatController extends Thread {
	private Cat cat;
	private volatile Boolean canContinue = true;
	
	/**
	 * This constructor creates a new Cat object with which
	 * the controller is associated.
	 * 
	 * @param id	The id of the Cat.
	 * @param board	This parameter is passed to the constructor 
	 * 				of Cat
	 */
	public CatController(Board board, int id) {
		this.cat = new Cat(board, id);
	}

	/**
	 * Returns the Cat controlled by this controller
	 * 
	 * @return Cat controlled by this controller
	 */
	public Cat getPiece() {
		return this.cat;
	}
	
	/**
	 * Calls the move method of the associated Cat object with
	 * the input parameter.
	 * 
	 * @param dir	The Direction the cat should move
	 */
	public void moveCat(Direction dir) {
		cat.moveTo(dir);
	}
	
	/**
	 * Calls the move method of the associated Cat object with a 
	 * pseudo-random Direction.
	 */
	public void run() {
		int currentTime = Clock.getTime();
		while (canContinue) {
			try {
				Thread.sleep(1);
				if (currentTime < Clock.getTime()) {
					Random rand = new Random(System.currentTimeMillis());
					Direction[] directions = Direction.values(); 
					cat.moveTo(directions[rand.nextInt(directions.length)]);
					currentTime = Clock.getTime();
				}
			} catch (InterruptedException e) {
				canContinue = false;
			}	
		}
	}
	
	/**
	 * Stops the CatController Thread from running.
	 */
	public void cancel() {
		canContinue = false;
	}
}
