package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import model.Direction;

public class RodentsPanel extends JPanel {

Container container = Container.getInstance();
	public void addNotify() {
		super.addNotify();
		requestFocus();
	}

	@Override
	public final Dimension getPreferredSize() {
		Dimension d = super.getPreferredSize();
		Dimension prefSize = null;
		Component c = getParent();
		if (c == null) {
			prefSize = new Dimension((int) d.getWidth(), (int) d.getHeight());
		} else if (c != null && c.getWidth() > d.getWidth() && c.getHeight() > d.getHeight()) {
			prefSize = c.getSize();
		} else {
			prefSize = d;
		}
		int w = (int) prefSize.getWidth();
		int h = (int) prefSize.getHeight();
		// the smaller of the two sizes
		int s = (w > h ? h : w);
		return new Dimension(s, s);
	}

	private static final int IFW = JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT;
	public boolean changed = false;
	  private final JLabel message = new JLabel(
	            "Chess Champ is ready to play!");
	public RodentsPanel() {
		
		
		
		
		this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0),
				"up");
		this.getActionMap().put("up", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Container.getInit().moveRat(1, Direction.DOWN);
				container.setP(drawCurrent());

			}
		});
		this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0),
				"down");
		this.getActionMap().put("down", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Container.getInit().moveRat(1, Direction.UP);
				container.setP(drawCurrent());
			}
		});
		this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0),
				"right");
		this.getActionMap().put("right", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Container.getInit().moveRat(1, Direction.RIGHT);
				container.setP(drawCurrent());
			}
		});
		this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0),
				"left");
		this.getActionMap().put("left", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Container.getInit().moveRat(1, Direction.LEFT);
				container.setP(drawCurrent());
			}
		});

		this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_I, 0),
				"upc");
		this.getActionMap().put("upc", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Container.getInit().moveCat(1, Direction.DOWN);
				container.setP(drawCurrent());
			}
		});
		this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_K, 0),
				"downc");
		this.getActionMap().put("downc", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Container.getInit().moveCat(1, Direction.UP);
				container.setP(drawCurrent());
			}
		});
		this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0),
				"rightc");
		this.getActionMap().put("rightc", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Container.getInit().moveCat(1, Direction.RIGHT);
				container.setP(drawCurrent());
			}
		});
		this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_J, 0),
				"leftc");
		this.getActionMap().put("leftc", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Container.getInit().moveCat(1, Direction.LEFT);
				container.setP(drawCurrent());
			}
		});

	}

	public RodentsPanel drawCurrent() {
		return Container.getInit().getBoard().getDraw();
	}

}
