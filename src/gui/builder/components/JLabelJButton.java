package gui.builder.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JLabelJButton {

	private JFrame frmJlabelJbutton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLabelJButton window = new JLabelJButton();
					window.frmJlabelJbutton.setLocation(2600, 350);
					window.frmJlabelJbutton.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JLabelJButton() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJlabelJbutton = new JFrame();
		frmJlabelJbutton.setTitle("JLabel과 JButton");
		frmJlabelJbutton.setBounds(100, 100, 430, 562);
		frmJlabelJbutton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJlabelJbutton.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("자바 응용 프로그램");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 255, 0));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 390, 27);
		frmJlabelJbutton.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(""); 
		lblNewLabel_1.setIcon(new ImageIcon(JLabelJButton.class.getResource("/gui/builder/images/beauty.jpg")));
		lblNewLabel_1.setBounds(12, 47, 390, 369);
		frmJlabelJbutton.getContentPane().add(lblNewLabel_1);
		
		JButton btnCall = new JButton("전화해~");
		btnCall.setIcon(new ImageIcon(JLabelJButton.class.getResource("/gui/builder/images/normalIcon.gif")));
		btnCall.setRolloverIcon(new ImageIcon(JLabelJButton.class.getResource("/gui/builder/images/rolloverIcon.gif")));
		btnCall.setPressedIcon(new ImageIcon(JLabelJButton.class.getResource("/gui/builder/images/pressedIcon.gif")));
		
		btnCall.setBounds(113, 426, 188, 87);
		frmJlabelJbutton.getContentPane().add(btnCall);
	}
}
