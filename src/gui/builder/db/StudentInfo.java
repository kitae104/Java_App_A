package gui.builder.db;



import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class StudentInfo extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private final DefaultTableModel tableModel = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					StudentInfo frame = new StudentInfo();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	private JTextField tfUserName;
	private JTextField tfPassword;
	private JTextField tfAge;
	private JTextField tfDept;
	private JTextField tfGrade;
	private JComboBox cbName;
	private JTextField tfId;
	private DefaultListModel<String> model;
	private JList<String> list;
	private JTextField tfSearch;
	private JComboBox<String> cbCategory;

	/**
	 * Create the frame.
	 */
	public StudentInfo()
	{
		setTitle("학생 정보 ");

		//connection = DbConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnLoadTable = new JButton("Load Data");
		btnLoadTable.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				refreshTable();
			}
			
		});
		btnLoadTable.setBounds(549, 22, 140, 23);
		contentPane.add(btnLoadTable);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 64, 434, 392);
		contentPane.add(scrollPane);

		table = new JTable(tableModel);
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {			    	
					
					int row = table.getSelectedRow();	// 테이블에서 선택한 행의 위치 
					String id = table.getModel().getValueAt(row, 0).toString();	// 선택한 행의 0번째 있는 정보 추출 
					
					String sql = "SELECT * FROM studentinfo WHERE id = ?" ;
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, id);
										
					ResultSet rs = pstmt.executeQuery();

					while(rs.next())
					{
						tfId.setText(rs.getString("id"));
						tfUserName.setText(rs.getString("username"));
						tfPassword.setText(rs.getString("password"));
						tfAge.setText(rs.getString("age"));
						tfDept.setText(rs.getString("dept"));
						tfGrade.setText(rs.getString("grade"));
					}			
					
					pstmt.close();
					rs.close();	
	
				} 
			    catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(23, 134, 68, 15);
		contentPane.add(lblNewLabel);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(106, 131, 137, 21);
		contentPane.add(tfUserName);
		tfUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(23, 162, 68, 15);
		contentPane.add(lblPassword);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(106, 159, 137, 21);
		contentPane.add(tfPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("age");
		lblNewLabel_1_1.setBounds(23, 190, 68, 15);
		contentPane.add(lblNewLabel_1_1);
		
		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(106, 187, 137, 21);
		contentPane.add(tfAge);
		
		JLabel lblNewLabel_1_2 = new JLabel("dept");
		lblNewLabel_1_2.setBounds(23, 218, 68, 15);
		contentPane.add(lblNewLabel_1_2);
		
		tfDept = new JTextField();
		tfDept.setColumns(10);
		tfDept.setBounds(106, 215, 137, 21);
		contentPane.add(tfDept);
		
		JLabel lblNewLabel_1_3 = new JLabel("grade");
		lblNewLabel_1_3.setToolTipText("g");
		lblNewLabel_1_3.setBounds(23, 246, 68, 15);
		contentPane.add(lblNewLabel_1_3);
		
		tfGrade = new JTextField();
		tfGrade.setColumns(10);
		tfGrade.setBounds(106, 243, 137, 21);
		contentPane.add(tfGrade);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String sql = "INSERT INTO studentinfo (username, password, age, dept, grade) VALUES (?,?,?,?,?)";
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, tfUserName.getText());
					pstmt.setString(2, tfPassword.getText());
					pstmt.setInt(3, Integer.parseInt(tfAge.getText()));
					pstmt.setString(4, tfDept.getText());
					pstmt.setString(5, tfGrade.getText());
					
					pstmt.execute();
					
					JOptionPane.showMessageDialog(null, "Data Saved");
					
					pstmt.close();		

				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
				
				refreshTable();
			}
		});
		btnNewButton.setBounds(12, 274, 79, 23);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String id = JOptionPane.showInputDialog(this, "번호 선택");
					String sql = "UPDATE studentinfo SET username = ?, password = ?, age = ?, dept = ?, grade = ? WHERE id = ?" ;
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, tfUserName.getText());
					pstmt.setString(2, tfPassword.getText());					
					pstmt.setInt(3, Integer.parseInt(tfAge.getText()));
					pstmt.setString(4, tfDept.getText());
					pstmt.setString(5, tfGrade.getText());
					pstmt.setString(6, id);
										
					pstmt.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
					pstmt.close();

				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
				refreshTable();
			}
		});
		btnUpdate.setBounds(12, 307, 79, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
				    	int action = JOptionPane.showConfirmDialog(null, "정말 삭제할까요?", "삭제하기", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    	if(action == JOptionPane.YES_OPTION) {
						String id = tfId.getText();
				    	String sql = "DELETE FROM studentinfo WHERE id = ?" ;
						PreparedStatement pstmt = connection.prepareStatement(sql);
						pstmt.setString(1, id);
											
						pstmt.execute();
						
						JOptionPane.showMessageDialog(null, "Data Deleted");
						
						pstmt.close();
			    	}
	
				} 
			    catch (Exception e2)
				{
					e2.printStackTrace();
				}
			    
			    refreshTable();				// 테이블 갱신 
			    fillComboBox();				// 콤보박스 정보 갱신
				loadList();  				// 리스트 정보 갱신 
			    
			}
		});
		btnDelete.setBounds(12, 340, 79, 23);
		contentPane.add(btnDelete);
		
		cbName = new JComboBox();
		cbName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {			    	
					String username = (String) cbName.getSelectedItem();
					String sql = "SELECT * FROM studentinfo WHERE username = ?" ;
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, username);
										
					ResultSet rs = pstmt.executeQuery();

					while(rs.next())
					{
						tfId.setText(rs.getString("id"));
						tfUserName.setText(rs.getString("username"));
						tfPassword.setText(rs.getString("password"));
						tfAge.setText(rs.getString("age"));
						tfDept.setText(rs.getString("dept"));
						tfGrade.setText(rs.getString("grade"));
					}			
					
					pstmt.close();
					rs.close();	
	
				} 
			    catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		cbName.setFont(new Font("굴림", Font.BOLD, 16));
		cbName.setBounds(23, 60, 220, 23);
		contentPane.add(cbName);
		
		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setBounds(23, 106, 50, 15);
		contentPane.add(lblNewLabel_1);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(106, 103, 137, 21);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		list = new JList<>();
		list.setBounds(106, 274, 137, 182);
		contentPane.add(list);
		
		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {			    	
					String category = (String) cbCategory.getSelectedItem();
					String search = tfSearch.getText();
					String sql = "SELECT * FROM studentinfo WHERE " + category + " like ?" ; // (주의!!) MySQL과 Oracle이 사용법이 다름 
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, "%" + search + "%");
										
					ResultSet rs = pstmt.executeQuery();

					setTablefromDB(rs);
					
					pstmt.close();
					rs.close();	
	
				} 
			    catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		tfSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		tfSearch.setBounds(172, 23, 262, 21);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBounds(446, 22, 91, 23);
		contentPane.add(btnNewButton_1);
		
		cbCategory = new JComboBox();
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"id", "username", "password", "age", "dept", "grade"}));
		cbCategory.setBounds(23, 22, 137, 23);
		contentPane.add(cbCategory);
		
		refreshTable();				// 테이블 정보 갱신
		fillComboBox();				// 콤보박스 정보 갱신
		loadList();  				// 리스트 정보 갱신 
	}

	//====================================================
	// DB의 resultset을 이용하여 테이블 설정하기
	//====================================================
	private void setTablefromDB(ResultSet rs) throws SQLException
	{
		ResultSetMetaData metaData = rs.getMetaData();

		// Names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int i = 1; i <= columnCount; i++)
		{
			columnNames.add(metaData.getColumnName(i));
		}

		// Data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next())
		{
			Vector<Object> vector = new Vector<Object>();
			for (int i = 1; i <= columnCount; i++)
			{
				vector.add(rs.getObject(i));
			}
			data.add(vector);
		}

		tableModel.setDataVector(data, columnNames);
	}
	
	//====================================================
	// 테이블 갱신하기
	//====================================================
	private void refreshTable()
	{
		try
		{
			String sql = "SELECT * From studentinfo";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			// 데이터를 이용하여 테이블 설정하기
			setTablefromDB(rs);
			pstmt.close();
			rs.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//====================================================
	// 콤보 박스 채우기 
	//====================================================
	public void fillComboBox() 
	{
		try
		{
			cbName.removeAllItems();
			String sql = "SELECT * FROM studentinfo";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next())
			{
				cbName.addItem(rs.getString("username"));
			}			
			
			pstmt.close();
			rs.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//====================================================
	// 리스트 채우기 
	//====================================================
	public void loadList()
	{
		try
		{
			String sql = "SELECT * FROM studentinfo";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();			
			model = new DefaultListModel<>();
			
			while(rs.next())
			{
				model.addElement(rs.getString("username"));
			}			
			
			list.setModel(model);
			
			pstmt.close();
			rs.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}