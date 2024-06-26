package gui.builder.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class CheckBoxRadioButton {

	private JFrame frame;
	private int sum = 0;
	private JLabel lblResult;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JLabel lblImage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBoxRadioButton window = new CheckBoxRadioButton();
					window.frame.setLocation(2400, 250);
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
	public CheckBoxRadioButton() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("체크 박스와 라디오 버튼");
		frame.setBounds(100, 100, 418, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("사과 100원, 배 500원, 체리 1000원");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 376, 31);
		frame.getContentPane().add(lblNewLabel);
		
		lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(CheckBoxRadioButton.class.getResource("/gui/builder/images/apple.jpg")));
		lblImage.setBounds(137, 212, 127, 142);
		frame.getContentPane().add(lblImage);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("사과");
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			

			public void itemStateChanged(ItemEvent e) {
				int i = e.getStateChange();				
				if(i == ItemEvent.SELECTED) {					
					sum += 100;					
				} else {
					sum -= 100;
				}
				lblResult.setText("현재 " + sum + " 원 입니다.");
			}
		});
		chckbxNewCheckBox.setBounds(14, 51, 115, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("배");
		chckbxNewCheckBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i = e.getStateChange();				
				if(i == ItemEvent.SELECTED) {					
					sum += 500;					
				} else {
					sum -= 500;
				}
				lblResult.setText("현재 " + sum + " 원 입니다.");
			}
		});
		chckbxNewCheckBox_1.setBounds(153, 51, 115, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("체리");
		chckbxNewCheckBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int i = e.getStateChange();				
				if(i == ItemEvent.SELECTED) {					
					sum += 1000;					
				} else {
					sum -= 1000;
				}
				lblResult.setText("현재 " + sum + " 원 입니다.");
			}
		});
		chckbxNewCheckBox_2.setBounds(279, 51, 115, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		
		lblResult = new JLabel("현재 0 원 입니다.");
		lblResult.setOpaque(true);
		lblResult.setBackground(new Color(255, 255, 0));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(12, 80, 376, 31);
		frame.getContentPane().add(lblResult);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("남자");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(69, 128, 56, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(" 여자");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(138, 128, 65, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("사과");
		rdbtnNewRadioButton_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lblImage.setIcon(new ImageIcon(CheckBoxRadioButton.class.getResource("/gui/builder/images/apple.jpg")));
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setSelected(true);
		rdbtnNewRadioButton_2.setBounds(54, 171, 65, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("배");
		rdbtnNewRadioButton_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lblImage.setIcon(new ImageIcon(CheckBoxRadioButton.class.getResource("/gui/builder/images/pear.jpg")));
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(173, 171, 65, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("체리");
		rdbtnNewRadioButton_4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lblImage.setIcon(new ImageIcon(CheckBoxRadioButton.class.getResource("/gui/builder/images/cherry.jpg")));
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setBounds(292, 171, 56, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		
		
	}
}
