package model;



/**
 * Piece is an abstract class and is the basic unit of the game. 
 * The piece has a position on the board. Pieces implements the 
 * Visitable part of the Visitor Design Pattern. They can accept 
 * different Pieces.
 * 
 * @author ChaTeam
 *
 */
public abstract class Piece {
	
	private Position pos;
	protected view.View view;
	
	/**
	 * Gives position of the Piece on the board.
	 * 
	 * @return Position of the Piece on the board
	 */
	public Position getPosition() {
		return pos;
	}

	/**
	 * Used to change the position of the Piece on the board.
	 * 
	 * @param pos	The desired position of the Piece on the board
	 */
	public void setPosition(Position pos) {
		this.pos = pos;
	}
	
	/**
	 * Gives position of the Piece on the board.
	 * 
	 * @return Position of the Piece on the board
	 */
	public view.View getView() {
		return view;
	}
	
	/**
	 * This method implements the Visitable part of the Visitor
	 * design pattern.
	 * 
	 * @param p			The MovablePiece that visits the Piece
	 * @param fromDir	The direction that the MovablePiece is 
	 * 					visiting (from the perspective of the MovablePiece
	 */
	public abstract void accept(MovablePiece p, Direction fromDir);
	
	/**
	 * This method returns the symbol of the Piece (e.g. R for rat)
	 * 
	 * @return	String representation of the symbol
	 */
	public abstract String getSymbol();
}
