package gui.builder.app;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Calc {

	private JFrame frame;
	private JTextField textField;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;
	private JButton btnNewButton_11;
	private JButton btnNewButton_12;
	private JButton btnNewButton_13;
	private JButton btnNewButton_14;
	private JButton btnNewButton_15;
	private JButton btnNewButton_16;
	private JButton btnNewButton_17;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("계산기");
		frame.setBounds(100, 100, 465, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 10, 428, 51);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("DEL");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(12, 71, 63, 113);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("C");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(12, 194, 63, 106);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("-");
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(87, 71, 58, 67);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("*");
		btnNewButton_3.setBackground(Color.GRAY);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBounds(87, 148, 58, 75);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("/");
		btnNewButton_4.setBackground(Color.GRAY);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBounds(87, 233, 58, 67);
		frame.getContentPane().add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("7");
		btnNewButton_5.setBackground(Color.BLACK);
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBounds(157, 71, 63, 51);
		frame.getContentPane().add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("8");
		btnNewButton_6.setBackground(Color.BLACK);
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBounds(232, 71, 63, 51);
		frame.getContentPane().add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("9");
		btnNewButton_7.setBackground(Color.BLACK);
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBounds(307, 71, 63, 51);
		frame.getContentPane().add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("4");
		btnNewButton_8.setBackground(Color.BLACK);
		btnNewButton_8.setForeground(Color.WHITE);
		btnNewButton_8.setBounds(157, 132, 63, 51);
		frame.getContentPane().add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("5");
		btnNewButton_9.setBackground(Color.BLACK);
		btnNewButton_9.setForeground(Color.WHITE);
		btnNewButton_9.setBounds(232, 133, 63, 51);
		frame.getContentPane().add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("6");
		btnNewButton_10.setBackground(Color.BLACK);
		btnNewButton_10.setForeground(Color.WHITE);
		btnNewButton_10.setBounds(307, 133, 63, 51);
		frame.getContentPane().add(btnNewButton_10);
		
		btnNewButton_11 = new JButton("1");
		btnNewButton_11.setBackground(Color.BLACK);
		btnNewButton_11.setForeground(Color.WHITE);
		btnNewButton_11.setBounds(157, 194, 63, 51);
		frame.getContentPane().add(btnNewButton_11);
		
		btnNewButton_12 = new JButton("2");
		btnNewButton_12.setBackground(Color.BLACK);
		btnNewButton_12.setForeground(Color.WHITE);
		btnNewButton_12.setBounds(232, 194, 63, 51);
		frame.getContentPane().add(btnNewButton_12);
		
		btnNewButton_13 = new JButton("3");
		btnNewButton_13.setBackground(Color.BLACK);
		btnNewButton_13.setForeground(Color.WHITE);
		btnNewButton_13.setBounds(307, 194, 63, 51);
		frame.getContentPane().add(btnNewButton_13);
		
		btnNewButton_14 = new JButton("0");
		btnNewButton_14.setBackground(Color.BLACK);
		btnNewButton_14.setForeground(Color.WHITE);
		btnNewButton_14.setBounds(157, 249, 138, 51);
		frame.getContentPane().add(btnNewButton_14);
		
		btnNewButton_15 = new JButton(".");
		btnNewButton_15.setBackground(Color.ORANGE);
		btnNewButton_15.setForeground(Color.WHITE);
		btnNewButton_15.setBounds(307, 249, 63, 51);
		frame.getContentPane().add(btnNewButton_15);
		
		btnNewButton_16 = new JButton("+");
		btnNewButton_16.setBackground(Color.GRAY);
		btnNewButton_16.setForeground(Color.WHITE);
		btnNewButton_16.setBounds(377, 71, 63, 113);
		frame.getContentPane().add(btnNewButton_16);
		
		btnNewButton_17 = new JButton("=");
		btnNewButton_17.setBackground(Color.YELLOW);
		btnNewButton_17.setForeground(Color.WHITE);
		btnNewButton_17.setBounds(377, 194, 63, 106);
		frame.getContentPane().add(btnNewButton_17);
		
		JLabel lblNewLabel = new JLabel("김재현의 계산기");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 324, 428, 51);
		frame.getContentPane().add(lblNewLabel);
	}
}
