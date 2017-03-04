package model;

/**
 * The Position class is responsible for storing and 
 * returning the row and column of the position it defines
 * in a grid.
 * 
 * @author ChaTeam
 *
 */
public class Position {
	private int row;
	private int column;
	
	/**
	 * The constructor stores the row and column as given in the input.
	 * 
	 * @param row		The row of the position. Indexed from 0 where 0 is
	 * 					uppermost row number.
	 * @param column	The column of the position. Indexed from 0 where 0 is
	 * 					leftmost column number. 
	 */
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	/**
	 * Returns the row stored
	 * 
	 * @return	The row number of the Position.
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * Returns the column stored.
	 * 
	 * @return The column number of the Position.
	 */
	public int getColumn() {
		return column;
	}
	
	public String toString() {
		return String.format("(%d, %d)", row, column);
	}
}
