package model;

public class MovableBlock extends MovablePiece {
	/** 
	 * This constructor calls the constructor of MovablePiece to
	 * set the reference with the board.
	 * 
	 * @param id	The id of the MovableBlock.
	 * @param board	The Board with which the MovableBlock should be associated.
	 */
	public MovableBlock(Board board, int id) {
		super(board, id);
		this.view = new view.MovableBlockView();
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
		return "M";
	}
}
