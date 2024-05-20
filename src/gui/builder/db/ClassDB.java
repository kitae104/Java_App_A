package gui.builder.db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JList;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class ClassDB extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;
	private Connection conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassDB frame = new ClassDB();
					frame.setLocation(2800, 200);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClassDB() {
		
		conn  = DB.init();
		
		setTitle("학생 정보");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(116, 23, 219, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(359, 23, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Load Data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "SELECT * FROM student_info";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					
					setTableFromDB(rs);
					pstmt.close();
					rs.close();				
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			
		});
		btnNewButton_1.setBounds(462, 23, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(10, 94, 50, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(10, 124, 76, 15);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(10, 149, 76, 15);
		contentPane.add(lblPassword);
		
		JLabel lblAge = new JLabel("age");
		lblAge.setBounds(10, 174, 50, 15);
		contentPane.add(lblAge);
		
		JLabel lblDept = new JLabel("dept");
		lblDept.setBounds(10, 199, 50, 15);
		contentPane.add(lblDept);
		
		JLabel lblGrade = new JLabel("grade");
		lblGrade.setBounds(10, 224, 50, 15);
		contentPane.add(lblGrade);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(10, 249, 76, 23);
		contentPane.add(btnSave);
		
		JButton btnUpdata = new JButton("Update");
		btnUpdata.setBounds(10, 278, 76, 23);
		contentPane.add(btnUpdata);
		
		JButton btnDeleat = new JButton("Deleat");
		btnDeleat.setBounds(10, 311, 76, 23);
		contentPane.add(btnDeleat);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(96, 88, 100, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(96, 118, 100, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(96, 143, 100, 21);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(96, 168, 100, 21);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(96, 193, 100, 21);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(96, 218, 100, 21);
		contentPane.add(textField_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 22, 86, 23);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 55, 186, 23);
		contentPane.add(comboBox_1);
		
		textField_7 = new JTextField();
		textField_7.setBounds(100, 250, 96, 161);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(208, 54, 348, 357);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);		
		
	}
	
	private void setTableFromDB(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();
		
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		
		for (int i = 1; i <= columnCount; i++) {
			columnNames.add(metaData.getColumnClassName(i));
		}
		
		for(String name : columnNames) {
			System.out.println(name);
		}
		
	}
}
