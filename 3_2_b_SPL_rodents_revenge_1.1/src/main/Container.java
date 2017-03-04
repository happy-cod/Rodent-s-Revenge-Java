package main;

import java.util.ArrayList;
import java.util.List;

import model.Initializer;
import model.Position;

public class Container {
	private static Container instance = null;
private static List<Listener> listeners = new ArrayList<Listener>();

	private static RodentsPanel p;
	private static Initializer init = new Initializer();

	private Container() {
		// Exists only to defeat instantiation.
		createBoard(20);
	}

	public static Container getInstance() {
		if (instance == null) {
			instance = new Container();
		}
		return instance;
	}
	
	public void setP(RodentsPanel prototype) {
		p = prototype;
		for (Listener hl : listeners)
			hl.panelChanged();
	}

	public RodentsPanel getGui() {
		return init.getBoard().getDraw();
	}

	public static Initializer getInit() {
		return init;
	}

	
	public static void addListener(Listener toAdd) {
		listeners.add(toAdd);
	}

	public static void resetGame(){
		init = new Initializer();
		createBoard(20);
		instance.getInstance().setP(new RodentsPanel());
	}
	private static void createBoard(int board_size) {

		int size = board_size;
		// Create board using parameters

		init.initBoard(size, size);

		// Put the pieces as described into the board

		for (int ii = 0; ii < size; ii++) {
			for (int jj = 0; jj < size; jj++) {
				Byte symbol = 'E';

				if ((ii > size / 4 && jj > size / 4)) {
					symbol = 'M';
				}
				if (ii == 0 || ii == size - 1 || jj == 0 || jj == size - 1) {
					symbol = 'I';
				}
				if ((ii == 5 && jj == 5)) {
					symbol = 'C';
				}
				if (ii == size / 2 && jj == size / 2) {
					symbol = 'R';
				}
				switch (symbol) {
				case 'R':
				case 'C':
				case 'M':
				case 'I':
				case 'E':
				case 'F':
					Container.getInit().addPiece(symbol, new Position(ii, jj));
					break;
				}
			}
		}

	}

}
