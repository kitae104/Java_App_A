package gui.builder.db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.builder.app.Calc;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DBLogin {

	private JFrame frmLogin;
	private JTextField tfID;
	private JLabel lblPw;
	private JPasswordField tfPW;
	private Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBLogin window = new DBLogin();
					window.frmLogin.setLocation(2800, 200);
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DBLogin() {
		initialize();
		conn = DB.init();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 249);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel.setBounds(163, 32, 57, 15);
		frmLogin.getContentPane().add(lblNewLabel);
		
		tfID = new JTextField();
		tfID.setText("1111111");
		tfID.setFont(new Font("굴림", Font.BOLD, 16));
		tfID.setBounds(209, 24, 173, 31);
		frmLogin.getContentPane().add(tfID);
		tfID.setColumns(10);
		
		lblPw = new JLabel("PW :");
		lblPw.setFont(new Font("굴림", Font.BOLD, 16));
		lblPw.setBounds(163, 82, 57, 15);
		frmLogin.getContentPane().add(lblPw);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql = "SELECT * FROM student WHERE id=? AND grade=?";					
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, tfID.getText());
					pstmt.setString(2, tfPW.getText());
										
					ResultSet rs = pstmt.executeQuery();
					 
					if(rs.next()) {
						String id = rs.getString("id");
						int pw = rs.getInt("grade");
						System.out.println(id + " : " + pw);
						
						if(id.equals(tfID.getText()) && pw == Integer.parseInt(tfPW.getText())) {
							JOptionPane.showMessageDialog(frmLogin, "사용자 이름과 패스워드가 일치합니다.");
							Calc calc = new Calc();
							calc.getFrame().setLocation(2800, 400);
							calc.getFrame().setVisible(true);
							
							//frmLogin.setVisible(false);
							
						} 
						
					} else {
						JOptionPane.showMessageDialog(frmLogin, "사용자 이름과 패스워드가 일치하지 않습니다.");
					}
					
										
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 16));
		btnNewButton.setBounds(209, 135, 173, 39);
		frmLogin.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DBLogin.class.getResource("/gui/builder/images/logo.png")));
		lblNewLabel_1.setBounds(46, 52, 90, 96);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		tfPW = new JPasswordField();
		tfPW.setFont(new Font("굴림", Font.BOLD, 16));
		tfPW.setBounds(209, 73, 173, 33);
		frmLogin.getContentPane().add(tfPW);
	}
}
