package gui.builder.components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class JTextFieldJTextArea {

	private JFrame frmMychat;
	private JTextField tfInput;
	private JTextArea ta;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTextFieldJTextArea window = new JTextFieldJTextArea();
					window.frmMychat.setLocation(2800, 150);
					window.frmMychat.setVisible(true);
					window.tfInput.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JTextFieldJTextArea() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMychat = new JFrame();
		frmMychat.setTitle("MyChat");
		frmMychat.setBounds(100, 100, 373, 521);
		frmMychat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMychat.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 10, 333, 367);
		frmMychat.getContentPane().add(scrollPane);
		
		ta = new JTextArea();		
		ta.setEditable(false);
		ta.setLineWrap(true);
		scrollPane.setViewportView(ta);
		
		tfInput = new JTextField();
		tfInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
			
		});
		tfInput.setBounds(12, 387, 247, 39);
		frmMychat.getContentPane().add(tfInput);
		tfInput.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});
		btnSend.setBounds(271, 387, 74, 39);
		frmMychat.getContentPane().add(btnSend);
		
		rdbtnNewRadioButton = new JRadioButton("남자");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(39, 446, 121, 23);
		frmMychat.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("여자");
		rdbtnNewRadioButton_1.setBounds(185, 446, 121, 23);
		frmMychat.getContentPane().add(rdbtnNewRadioButton_1);
	}
	
	private void sendMsg() {
		String msg = tfInput.getText();
		ta.append("Client : " + msg + "\n");
		tfInput.setText("");
		tfInput.requestFocus();
	}
}
