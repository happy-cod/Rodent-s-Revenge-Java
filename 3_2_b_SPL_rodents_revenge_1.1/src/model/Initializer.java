package model;

import java.util.ArrayList;

import view.PrototypeIO;

/**
 * The Initializer is responsible for initializing all the 
 * various components of the game.
 * 
 * @author ChaTeam
 *
 */
public class Initializer {
	private Board board;
	private ArrayList<RatController> ratControllers = new ArrayList<>();
	private ArrayList<CatController> catControllers = new ArrayList<>();
	private CatSpawner catSpawner;
	
	public Initializer() {}
	
	public synchronized void initBoard(int rows, int cols) {
		board = new Board(rows, cols);
		board.getRules().setInitializer(this);
		this.catSpawner = new CatSpawner(this);
		this.catSpawner.start();
	}
	public Board getBoard(){
		return board;
	}
	
	public synchronized void spawnNewCat() {
		if (board.haveEmptyPiece()) {
			CatController newCatController = 
					new CatController(board, catControllers.size() + 1);
			board.putCatAtRandomEmptyPos(newCatController.getPiece());
			catControllers.add(newCatController);
			newCatController.start();
			//			PrototypeIO.printCatSpawn(newCatController.getPiece());

//			PrototypeIO.printCatSpawn(newCatController.getPiece());
		}
	}
	
	public synchronized void addPiece(Byte pieceSymbol, Position pos) {
		switch (pieceSymbol) {
			case 'R':
				RatController rc = new RatController(board, ratControllers.size() + 1);
				ratControllers.add(rc);
				board.putPieceAt(rc.getPiece(), pos);
				break;
			case 'C':
				CatController cc = new CatController(board, catControllers.size() + 1);
				catControllers.add(cc);
				board.putPieceAt(cc.getPiece(), pos);
				break;
			case 'M':
				board.putPieceAt(new MovableBlock(board, 0), pos);
				break;
			case 'I':
				board.putPieceAt(new ImmovableBlock(), pos);
				break;
			case 'E':
				board.putPieceAt(new EmptyPiece(), pos);
				break;
			case 'F':
				board.putPieceAt(new Cheese(), pos);
				break;
			default:
				return;
		}
	}
	
	public synchronized void moveRat(int id, Direction dir) {
		ratControllers.get(id - 1).moveRat(dir);
	}
	
	public synchronized void moveCat(int id, Direction dir) {
		catControllers.get(id - 1).moveCat(dir);
	}
	
	public synchronized void checkTrappedCats() {
		board.checkTrappedCats();
	}

	public synchronized void resetBoard() {
		
	}
	
	public synchronized void end() {
		catSpawner.cancel();	
		for (CatController catController : catControllers) {
			catController.getPiece().releaseTrapBox();
			catController.cancel();
		}
//		Clock.resetTime();
	}

	public synchronized void gameOver() {
		this.end();
//		PrototypeIO.printGameOver();
	}
	
	public synchronized void stopCatController(Cat deadCat) {
		for (CatController catController : catControllers) {
			if (catController.getPiece() == deadCat) {
				catController.cancel();
			}
		}
	}
}
