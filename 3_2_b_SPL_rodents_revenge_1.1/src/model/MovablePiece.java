package model;

/**
 * MovablePiece is an abstract class that extends the Piece class to 
 * implement both the Visitor and Visitable part of the Visitor Design
 * Pattern, so that they can move on the board.
 * 
 * @author ChaTeam
 *
 */
public abstract class MovablePiece extends Piece {
	private int id;
	protected Board board;
	
	/**
	 * This constructor sets the association between the MovablePiece
	 * and the board.
	 * 
	 * @param id	The id of the MovablePiece
	 * @param board	The board with which the MovablePiece should be 
	 * associated
	 */
	public MovablePiece(Board board, int id) {
		this.board = board;
		this.id = id;
	}
	
	/**
	 * This method is used to move the MovablePiece in a certain 
	 * direction.
	 * 
	 * @param dir	The direction the MovablePiece should move 
	 * 				from the perspective of the MovablePiece
	 */
	public abstract void moveTo(Direction dir);
	
	/**
	 * This method calls the relevant resolve method of the Rules
	 * class to cause the correct behavior of the visit between the 
	 * MovablePiece and the Rat.
	 * 
	 * @param rat		The Rat that the MovablePiece visits 
	 * @param fromDir	The direction of the Rat from the perspective
	 * 					of the MovablePiece
	 */
	public abstract void visit(Rat rat, Direction fromDir);
	
	/**
	 * This method calls the relevant resolve method of the Rules
	 * class to cause the correct behavior of the visit between the 
	 * MovablePiece and the Cat.
	 * 
	 * @param cat		The Cat that the MovablePiece visits 
	 * @param fromDir	The direction of the Cat from the perspective
	 * 					of the MovablePiece
	 */
	public abstract void visit(Cat cat, Direction fromDir);
	
	/**
	 * This method calls the relevant resolve method of the Rules
	 * class to cause the correct behavior of the visit between the 
	 * MovablePiece and the MovableBlock.
	 * 
	 * @param movBlock	The MovableBlock that the MovablePiece visits 
	 * @param fromDir	The direction of the MovableBlock from the perspective
	 * 					of the MovablePiece
	 */
	public abstract void visit(MovableBlock movBlock, Direction fromDir);
	
	/**
	 * This method calls the relevant resolve method of the Rules
	 * class to cause the correct behavior of the visit between the 
	 * MovablePiece and the ImmovableBlock.
	 * 
	 * @param immoBlock	The ImmovableBlock that the MovablePiece visits 
	 * @param fromDir	The direction of the ImmovableBlock from the perspective
	 * 					of the MovablePiece
	 */
	public abstract void visit(ImmovableBlock immoBlock, Direction fromDir);
	
	/**
	 * This method calls the relevant resolve method of the Rules
	 * class to cause the correct behavior of the visit between the 
	 * MovablePiece and the EmptyPiece.
	 * 
	 * @param empty		The EmptyPiece that the MovablePiece visits 
	 * @param fromDir	The direction of the EmptyPiece from the perspective
	 * 					of the MovablePiece
	 */
	public abstract void visit(EmptyPiece empty, Direction fromDir);
	
	/**
	 * This method calls the relevant resolve method of the Rules
	 * class to cause the correct behavior of the visit between the 
	 * MovablePiece and the Cheese.
	 * 
	 * @param cheese	The Cheese that the MovablePiece visits 
	 * @param fromDir	The direction of the Cheese from the perspective
	 * 					of the MovablePiece
	 */
	public abstract void visit(Cheese cheese, Direction fromDir);
	
	/**
	 * This method returns the id of the MovablePiece.
	 * 
	 * @return	id of of the MovablePiece
	 */
	public int getId() {
		return id;
	}
}
