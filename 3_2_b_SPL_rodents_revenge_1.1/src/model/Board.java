package model;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import main.RodentsPanel;
import view.BoardView;
import view.PrototypeIO;

/**
 * The Board is responsible for maintaining the spatial layout of 
 * the game and resolving conflicts between Pieces through the Rules 
 * class. Ton maintaining the spatial layout of the game board, the 
 * Board has references to all the Pieces and can move pieces.
 * 
 * @author ChaTeam
 *
 */
public class Board {
	private view.BoardView boardView;
	private int rows;
	private int cols;
	
	private Piece[][] cells;
	private Rules rules;
	
	private ArrayList<Cat> cats;
	private ArrayList<EmptyPiece> emptyPieces;
	
	/** 
	 * The constructor for the Board creates a two-dimensional array
	 * of Pieces of size rows by cols. It also creates and stores a 
	 * reference to the Rules object.
	 * 
	 * @param rows	The number of rows the board should have
	 * @param cols	The number of columns the board should have
	 */
	public Board(int rows, int cols) {
		boardView = new BoardView();
		this.rows = rows;
		this.cols = cols;
		this.cells = new Piece[rows][cols];
		this.rules = new Rules(this);

		this.cats = new ArrayList<Cat>();
		this.emptyPieces = new ArrayList<EmptyPiece>();
	}
	
	public RodentsPanel getDraw(){
		return BoardView.draw(cells, rows, cols);
	}
	/** 
	 * Returns a reference to the Rules object of the Board.
	 * 
	 * @return Reference to the Rules object of the Board
	 */
	public Rules getRules() {
		return this.rules;
	}
	
	/**
	 * Puts the input piece at the given position. This method does not check
	 * for any conflicts. If there was previous EmptyPiece at that position 
	 * then it is removed from the emptyPieces list. If the input Piece is an
	 * EmptyPiece it is added to the emptyPieces list.
	 * 
	 * @param piece	The Piece to be moved.
	 * @param pos	The desired Position of the Piece to be moved.
	 */
	public synchronized void putPieceAt(Piece piece, Position pos) {
		// Checking to see if the previous Piece at this position was an Empty Piece
		Piece previousPiece = this.cells[pos.getRow()][pos.getColumn()];
		if (previousPiece != null) {
			if (previousPiece.getClass() == EmptyPiece.class) {
				emptyPieces.remove(previousPiece);
			}
			if (previousPiece.getClass() == Cat.class) {
				cats.remove(previousPiece);
			}
		}
		
		// Adding the input Piece to the emptyPieces list if it is an EmptyPiece
		if (piece.getClass() == EmptyPiece.class) {
			emptyPieces.add((EmptyPiece)piece);
		}
		
		// Adding the input Piece to the cats list if it is a Cat
		if (piece.getClass() == Cat.class) {
			cats.add((Cat)piece);
		}
		
		this.cells[pos.getRow()][pos.getColumn()] = piece;
		piece.setPosition(pos);
	}
		
	/**
	 * Places the input Cat parameter on a empty position (cell of an 
	 * EmptyPiece). If the PrototypeProgram is set to deterministic
	 * then the Cat is placed on the first empty cell in the emptyPieces
	 * array, otherwise it is placed in a random empty cell.
	 * 
	 * @param cat	The Cat to be placed in an empty position on the Board.
	 */
	public synchronized void putCatAtRandomEmptyPos(Cat cat) {
//		if (PrototypeProgram.isDeterministic()) {
//			this.putPieceAt(cat, emptyPieces.get(0).getPosition());
//		} else {
			Random rand = new Random(0);
			int index = rand.nextInt(emptyPieces.size());
			EmptyPiece randomEmptyPiece = emptyPieces.get(index);
			this.putPieceAt(cat, randomEmptyPiece.getPosition());
//		}	
	}
	
	/**
	 * Returns the piece adjacent to the cell defined by the Position 
	 * parameter in the given direction
	 * 
	 * @param pos	The Position of the Piece for which you want the
	 * 				adjacent piece
	 * @param dir	The direction of the edge with which the desired 
	 * 				Piece is adjacent with the cell defined by the pos 
	 * 				parameter
	 * @return		The adjacent Piece in the specified Direction. Returns
	 * 				an ImmovableBlock in the case that the Position and
	 * 				given Direction are invalid. 
	 */
	public synchronized Piece getAdjacentPiece(Position pos, Direction dir) {
		int dir_row = 0, dir_col = 0;
		switch (dir) {
			case UP:
				dir_row = 1;
				break;
			case DOWN:
				dir_row = -1;
				break;
			case LEFT:
				dir_col = -1;
				break;
			case RIGHT:
				dir_col = 1;
				break;
			case UPPER_LEFT:
				dir_col = -1;
				dir_row = 1;
				break;
			case UPPER_RIGHT:
				dir_col = 1;
				dir_row = 1;
				break;
			case LOWER_LEFT:
				dir_col = -1;
				dir_row = -1;
				break;
			case LOWER_RIGHT:
				dir_col = 1;
				dir_row = -1;
				break;
		}
		int adjacentCellRow = pos.getRow() + dir_row;
		int adjacentCellColumn = pos.getColumn() + dir_col;
		
		if (adjacentCellRow >= 0 && adjacentCellColumn >= 0 
				&& adjacentCellRow < rows && adjacentCellColumn < cols) {
			return cells[adjacentCellRow][adjacentCellColumn];
		}
		return new ImmovableBlock();
	}
	
	/**
	 * Switches the position of two input Pieces on the board
	 * 
	 * @param p1	The first Piece.
	 * @param p2	The second Piece.
	 */
	// switch the two pieces on the board
	public synchronized void switchPieces(Piece p1, Piece p2) {
		PrototypeIO.printSwitch(p1, p2);
		
		Position pos1 = p1.getPosition();
		Position pos2 = p2.getPosition();
		
		this.putPieceAt(p1, pos2);
		this.putPieceAt(p2, pos1);
	}
	
	/**
	 * Checks to see if any of the Cats on the Board are trapped and
	 * updates the state of each Cat's TrapBox.
	 * 
	 */
	public synchronized void checkTrappedCats() {
		for (Cat cat : cats) {
			if (this.isTrapped(cat)) {
				cat.startTrapBox();
			} else {
				cat.releaseTrapBox();
			}
		}
	}
	
	/**
	 * Checks if the input Cat parameter is trapped by checking to see 
	 * if any adjacent piece of the Cat is an EmptyPiece, Cheese, or a
	 * Rat.
	 * 
	 * @return True if the input Cat parameter is trapped
	 */
	private synchronized boolean isTrapped(Cat cat) {
		for (Direction dir : Direction.values()) {
			Piece p = this.getAdjacentPiece(cat.getPosition(), dir);
			if (p.getClass() == EmptyPiece.class || 
					p.getClass() == Cheese.class ||
					p.getClass() == Rat.class) {
				return false;
			}
		}
		return true;
	}
	
	public synchronized boolean haveEmptyPiece() {
		return (emptyPieces.size() > 0);
	}
}
