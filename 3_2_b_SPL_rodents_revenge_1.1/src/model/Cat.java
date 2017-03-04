package model;

/**
 * The Cat class is responsible for interacting with other Piece objects.
 * 
 * @author ChaTeam
 *
 */
public class Cat extends MovablePiece {
	
	private TrapBox trapBox;
	
	/** 
	 * This constructor calls the constructor of MovablePiece to
	 * set the reference with the board.
	 * 
	 * @param id	The id of the Cat.
	 * @param board	The Board with which the Cat should be associated.
	 */
	public Cat(Board board, int id) {
		super(board, id);
		trapBox = new TrapBox(board.getRules(), this);
		this.view = new view.CatView();
//		startTrapBox();
	}
	
	/**
	 * Starts the thread of the TrapBox of the Cat.
	 */
	public void startTrapBox() {
		if (!trapBox.getStarted()) {
			trapBox.start();	
		}	
	}
	
	/**
	 * Calls the cancel method of the trapBox attribute
	 * and creates a new TrapBox and stores the reference.
	 */
	public void releaseTrapBox() {
		trapBox.cancel();
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
		this.board.getRules().resolve(this, movBlock);
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
		return "C";
	}
}
