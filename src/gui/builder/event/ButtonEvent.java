package gui.builder.event;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class ButtonEvent {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonEvent window = new ButtonEvent();
					
					window.frame.setLocation(2600, 250);
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
	public ButtonEvent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("버튼 이벤트 처리");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAction = new JButton("Action");
		btnAction.setBackground(SystemColor.activeCaption);
		btnAction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAction.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAction.setBackground(new Color(255, 255, 0));
			}
		});
		btnAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = btnAction.getText();
				
				if(str.equals("Action")) {
					btnAction.setText("엑션");					
				} else {
					btnAction.setText("Action");			
				}
				
			}
		});
		btnAction.setFont(new Font("굴림", Font.BOLD, 20));
		btnAction.setBounds(129, 46, 163, 103);
		frame.getContentPane().add(btnAction);
	}

}
