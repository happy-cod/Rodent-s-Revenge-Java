package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				RodentsPanel cg = new RodentsPanel();
				Container mp = Container.getInstance();
				mp.setP(cg);
				Controller f = new Controller();
				// Ensures JVM closes after frame(s) closed and
				// all non-daemon threads are finished

			}
		};
		// Swing GUIs should be created and updated on the EDT
		SwingUtilities.invokeLater(r);
	}

}
