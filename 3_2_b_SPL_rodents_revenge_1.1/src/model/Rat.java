package model;

/**
 * The Rat class is responsible for interacting with other Piece objects.
 * 
 * @author ChaTeam
 *
 */
public class Rat extends MovablePiece {
	/**
	 * This constructor calls the constructor of MovablePiece to
	 * set the reference with the board.
	 * 
	 * @param id	The id of the Rat.
	 * @param board	The Board with which the Rat should be associated.
	 */
	public Rat(Board board, int id) {
		super(board, id);
		this.view = new view.RatView();
	}

	@Override
	public void moveTo(Direction dir) {
		Piece p = this.board.getAdjacentPiece(this.getPosition(), dir);
		p.accept(this, dir);
	}	
	
	@Override
	public void accept(MovablePiece p, Direction fromDir) {
		p.visit(this, fromDir);
	}

	@Override
	public void visit(Rat rat, Direction fromDir) {
		this.board.getRules().resolve(this,rat);
	}

	@Override
	public void visit(Cat cat, Direction fromDir) {
		this.board.getRules().resolve(this,cat);
	}

	@Override
	public void visit(MovableBlock movBlock, Direction fromDir) {
		this.board.getRules().resolve(this, movBlock, fromDir);
	}

	@Override
	public void visit(ImmovableBlock immoBlock, Direction fromDir) {
		this.board.getRules().resolve(this, immoBlock);
	}

	@Override
	public void visit(EmptyPiece empty, Direction fromDir) {
		this.board.getRules().resolve(this, empty);
	}

	@Override
	public void visit(Cheese cheese, Direction fromDir) {
		this.board.getRules().resolve(this, cheese);
	}

	@Override
	public String getSymbol() {
		return "R";
	}
}
