package model;

/**
 * The responsibility of RatController is to control its 
 * associated Rat object.
 * 
 * @author ChaTeam
 *
 */
public class RatController {
	
	private Rat rat;
	
	/**
	 * This constructor creates a new Rat object with which
	 * the controller is associated.
	 * 
	 * @param id	The id of the Rat.
	 * @param board	This parameter is passed to the constructor 
	 * 				of Rat
	 */
	public RatController(Board board, int id) {
		this.rat = new Rat(board, id);
	}

	/**
	 * Returns the Rat controlled by this controller
	 * 
	 * @return Rat controlled by this controller
	 */
	public Rat getPiece() {
		return this.rat;
	}
	
	
	/**
	 * Calls the move method of the associated Cat object with
	 * the input parameter.
	 * 
	 * @param dir	The Direction the cat should move
	 */
	public void moveRat(Direction dir) {
		rat.moveTo(dir);
	}
	
//	/**
//	 * Calls the methods of the associate Rat object.
//	 */
//	public void run() {
//  
//	}
}
