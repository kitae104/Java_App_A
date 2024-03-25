package gui.basic;

import javax.swing.JFrame;

public class MyFrame extends JFrame{

	public MyFrame() {
		this.setTitle("내 프레임");
		this.setSize(300, 300);
		setLocation(2600, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
