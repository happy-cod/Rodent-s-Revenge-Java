package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import main.RodentsPanel;
import model.Piece;

public class BoardView {

	public static RodentsPanel draw(Piece pieces[][], int rows, int cols) {

		RodentsPanel rodentBoard;
		JButton[][] rodentBoardSquares;
		rodentBoardSquares = new JButton[rows][cols];
		int m = (rows > cols ? cols : rows);
		rodentBoard = new RodentsPanel();
		GridLayout experimentLayout = new GridLayout(0, m);
		rodentBoard.setLayout(experimentLayout);
		rodentBoard.setBorder(new CompoundBorder(new EmptyBorder(rows, cols, rows, cols), new LineBorder(Color.BLACK)));
		Color ochre = new Color(204, 119, 34);
		rodentBoard.setBackground(ochre);

		Insets buttonMargin = new Insets(0, 0, 0, 0);
		for (int ii = 0; ii < pieces.length; ii++) {
			for (int jj = 0; jj < pieces[ii].length; jj++) {
				JButton b = new JButton();
				b.setMargin(buttonMargin);
				b.setIcon(pieces[ii][jj].getView().draw());
				b.setBackground(Color.GREEN);
				rodentBoardSquares[jj][ii] = b;
			}
		}

		for (int ii = 0; ii < pieces.length; ii++) {
			for (int jj = 0; jj < pieces[ii].length; jj++) {
				rodentBoard.add(rodentBoardSquares[jj][ii]);
			}
		}
		
		return rodentBoard;
	}
}
