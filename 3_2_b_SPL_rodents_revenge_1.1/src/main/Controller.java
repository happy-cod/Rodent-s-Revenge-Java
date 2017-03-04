package main;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class Controller extends JFrame implements Listener {

	Container mp = Container.getInstance();

	public Controller() {
		Container.addListener(this);

		this.add(mp.getGui());
//		 this.setBorder(new EmptyBorder(5, 5, 5, 5));
	      panelChanged();
//	        tools.add(message);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationByPlatform(true);

		// ensures the frame is the minimum size it needs to be
		// in order display the components within it
		this.pack();
		// ensures the minimum size is enforced.
		this.setMinimumSize(this.getSize());
		this.setVisible(true);
	}

	@Override
	public void panelChanged() {

		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.removeAll(); 
		JToolBar tools = new JToolBar();
	      
		this.add(mp.getGui()); 
		tools.setFloatable(false);
	        this.add(tools, BorderLayout.PAGE_START);
	        tools.add(new JButton(new AbstractAction("New") {
	            public void actionPerformed(ActionEvent e) {
	                Container.resetGame();
	            }
	        })); 
	        tools.addSeparator();
	        tools.add(new JButton(new AbstractAction("Exit") {
	            public void actionPerformed(ActionEvent e) {
	               System.exit(0);
	            }
	        }));
	        tools.addSeparator();
		this.revalidate();
		this.repaint();
	}

}
