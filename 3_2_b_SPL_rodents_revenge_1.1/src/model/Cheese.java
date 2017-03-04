package model;

import view.CheeseView;

/**
 * The Cheese class is responsible for interacting with other Piece objects.
 * 
 * @author ChaTeam
 *
 */
public class Cheese extends Piece {

	public Cheese() {
		this.view = new CheeseView();
	}
	
	@Override
	public void accept(MovablePiece p, Direction fromDir) {		
		p.visit(this, fromDir);
	}

	@Override
	public String getSymbol() {
		return "F";
	}
}
