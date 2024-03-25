package gui.basic;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyApp {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("나의 첫번째 프레임");
		frame.setSize(300, 300);
		frame.setLocation(2600, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new FlowLayout());
		
		JButton btn = new JButton("버튼");
		frame.add(btn);
		frame.setVisible(true);
	}

}
