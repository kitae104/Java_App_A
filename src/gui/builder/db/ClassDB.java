package gui.builder.db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClassDB extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfSearch;
	private JTextField tfID;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JTextField tfAge;
	private JTextField tfDept;
	private JTextField tfGrade;
	private JTextField textField_7;
	private JTable table;
	private Connection conn = null;
	private final DefaultTableModel tableModel = new DefaultTableModel();
	private JComboBox cbCategory;
	private JComboBox cbName;
	
	
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
		
		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					String category = (String) cbCategory.getSelectedItem();
					String search = tfSearch.getText();
					String sql = "SELECT * FROM student_info where " + category + " like ?";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + search + "%");
					
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
		tfSearch.setBounds(116, 23, 219, 21);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(359, 23, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Load Data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
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
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql = "INSERT INTO student_info "
							+ "(username, password, age, dept, grade) "
							+ "VALUES(?, ?, ?, ?, ?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, tfUsername.getText());
					pstmt.setString(2, tfPassword.getText());
					pstmt.setInt(3, Integer.parseInt(tfAge.getText()));
					pstmt.setString(4, tfDept.getText());
					pstmt.setString(5, tfGrade.getText());
					
					pstmt.execute();
					
					JOptionPane.showMessageDialog(contentPane, "Data Saved");
					
					pstmt.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				refreshTable();
				fillCombo();
			}
		});
		btnSave.setBounds(10, 249, 76, 23);
		contentPane.add(btnSave);
		
		JButton btnUpdata = new JButton("Update");
		btnUpdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String sql = "UPDATE student_info "
							+ "SET username=?, password=?, age=?, dept=?, grade=?"
							+ "WHERE id=?";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, tfUsername.getText());
					pstmt.setString(2, tfPassword.getText());
					pstmt.setInt(3, Integer.parseInt(tfAge.getText()));
					pstmt.setString(4, tfDept.getText());
					pstmt.setString(5, tfGrade.getText());
					pstmt.setString(6, tfID.getText());
					pstmt.execute();
					
					JOptionPane.showMessageDialog(contentPane, "Data Updated");
					
					pstmt.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				refreshTable();
			}
		});
		btnUpdata.setBounds(10, 278, 76, 23);
		contentPane.add(btnUpdata);
		
		JButton btnDeleat = new JButton("Delete");
		btnDeleat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "DELETE FROM java_a.student_info "
							+ "WHERE id=?";
					PreparedStatement pstmt = conn.prepareStatement(sql);					
					pstmt.setString(1, tfID.getText());
					pstmt.execute();
					
					JOptionPane.showMessageDialog(contentPane, "Data Deleted");
					
					pstmt.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				refreshTable();
			}
		});
		btnDeleat.setBounds(10, 311, 76, 23);
		contentPane.add(btnDeleat);
		
		tfID = new JTextField();
		tfID.setEnabled(false);
		tfID.setColumns(10);
		tfID.setBounds(96, 88, 100, 21);
		contentPane.add(tfID);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(96, 118, 100, 21);
		contentPane.add(tfUsername);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(96, 143, 100, 21);
		contentPane.add(tfPassword);
		
		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(96, 168, 100, 21);
		contentPane.add(tfAge);
		
		tfDept = new JTextField();
		tfDept.setColumns(10);
		tfDept.setBounds(96, 193, 100, 21);
		contentPane.add(tfDept);
		
		tfGrade = new JTextField();
		tfGrade.setColumns(10);
		tfGrade.setBounds(96, 218, 100, 21);
		contentPane.add(tfGrade);
		
		cbCategory = new JComboBox();
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"id", "username", "password", "age", "dept", "grade"}));
		cbCategory.setBounds(10, 22, 86, 23);
		contentPane.add(cbCategory);
		
		cbName = new JComboBox();
		cbName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = (String) cbName.getSelectedItem();
				System.out.println("username : " + username);
			}
		});
		cbName.setBounds(10, 55, 186, 23);
		contentPane.add(cbName);
		
		textField_7 = new JTextField();
		textField_7.setBounds(100, 250, 96, 161);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(208, 54, 348, 357);
		contentPane.add(scrollPane);
		
		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					int row = table.getSelectedRow();
					String id = table.getModel().getValueAt(row, 0).toString();
					
					String sql = "SELECT * FROM student_info where id=?";					
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					
					ResultSet rs = pstmt.executeQuery();
					
					while(rs.next()) {
						tfID.setText(rs.getString("id"));
						tfUsername.setText(rs.getString("username"));
						tfPassword.setText(rs.getString("password"));
						tfAge.setText(rs.getString("age"));
						tfDept.setText(rs.getString("dept"));
						tfGrade.setText(rs.getString("grade"));
					}
					
					pstmt.close();
					rs.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(table);		
		
		refreshTable();
		fillCombo();
	}
	
	

	private void setTableFromDB(ResultSet rs) throws SQLException {
		
		ResultSetMetaData metaData = rs.getMetaData();
		
		// 컬럼 정보 
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		
		for (int i = 1; i <= columnCount; i++) {
			columnNames.add(metaData.getColumnName(i));
		}
		
		// 데이터  
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while(rs.next()) {
			Vector<Object> vec = new Vector<Object>();
			for (int i = 1; i <= columnCount; i++) {
				vec.add(rs.getObject(i));
			}
			data.add(vec);
		}
		
		tableModel.setDataVector(data, columnNames);
	}
	
	private void refreshTable() {
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
	
	private void fillCombo() {
		cbName.removeAllItems();
		
		try {
			String sql = "SELECT * FROM student_info";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cbName.addItem(rs.getString("username"));
			}			
			
			pstmt.close();
			rs.close();				
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
