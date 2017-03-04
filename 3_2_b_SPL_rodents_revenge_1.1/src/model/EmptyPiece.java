package model;

/**
 * The EmptyPiece class is responsible for interacting with other Piece objects.
 *
 * @author ChaTeam
 *
 */
public class EmptyPiece extends Piece {

	public EmptyPiece() {
		this.view = new view.EmptyView();
	}
	
	@Override
	public void accept(MovablePiece p, Direction fromDir) {
		p.visit(this, fromDir);
	}

	@Override
	public String getSymbol() {
		return "E";
	}
}
