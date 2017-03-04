package view;

import javax.swing.ImageIcon;

public class EmptyView implements View {

	public ImageIcon draw() {
		return new ImageIcon("src\\img\\void.png");
	}

}
