package gui.builder.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SimpleCalc {

	private JFrame frame;
	private JTextField tfX;
	private JTextField tfY;
	private JTextField tfResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalc window = new SimpleCalc();
					window.frame.setLocation(2900, 200);
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
	public SimpleCalc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("초간단 계산기");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" X =");
		lblNewLabel.setBounds(43, 36, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblY = new JLabel("Y =");
		lblY.setBounds(224, 36, 57, 15);
		frame.getContentPane().add(lblY);
		
		tfX = new JTextField();
		tfX.setHorizontalAlignment(SwingConstants.CENTER);
		tfX.setBounds(84, 29, 116, 30);
		frame.getContentPane().add(tfX);
		tfX.setColumns(10);
		
		tfY = new JTextField();
		tfY.setHorizontalAlignment(SwingConstants.CENTER);
		tfY.setColumns(10);
		tfY.setBounds(259, 29, 116, 30);
		frame.getContentPane().add(tfY);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc('+');
			}

			
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton.setBounds(133, 94, 49, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc('-');
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_1.setBounds(202, 94, 49, 48);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblResult = new JLabel("Result =");
		lblResult.setBounds(133, 189, 57, 15);
		frame.getContentPane().add(lblResult);
		
		tfResult = new JTextField();
		tfResult.setHorizontalAlignment(SwingConstants.CENTER);
		tfResult.setColumns(10);
		tfResult.setBounds(202, 182, 116, 30);
		frame.getContentPane().add(tfResult);
		
		JButton btnNewButton_1_1 = new JButton("C");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfX.setText("");
				tfY.setText("");
				tfResult.setText("");
			}
		});
		btnNewButton_1_1.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(281, 94, 49, 48);
		frame.getContentPane().add(btnNewButton_1_1);
	}
	
	public boolean isNumber(String strValue) {
	    return strValue != null && strValue.matches("[-+]?\\d*\\.?\\d+");
	}
	
	private void calc(char op) {
		String strX = tfX.getText();
		String strY = tfY.getText();
		
		if(!strX.equals("") && !strY.equals("")) {	
			if(isNumber(strX) && isNumber(strY)) {
				int x = Integer.parseInt(tfX.getText());	// 문자열 숫자
				int y = Integer.parseInt(tfY.getText());	// 문자열 숫자
				int result = 0;
				switch(op) {
				case '+':
					result = x + y;
					break;
				case '-':
					result = x - y;
					break;
				}
				
				tfResult.setText(result + "");	
			} else {
				JOptionPane.showMessageDialog(frame,
						"입력 값 중에 숫자가 아닌 경우가 있습니다. 확인하세요",
						"경고 창",
						JOptionPane.WARNING_MESSAGE
						);
				
			}
		} else {
			JOptionPane.showMessageDialog(frame, "비어있는 입력 값을 확인하세요");
		}
	}
}
