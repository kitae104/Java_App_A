package gui.builder.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DB {

	private static Connection conn = null;

	public static Connection init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn  = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java_a?serverTimezone=UTC", 
					"root", 
					"1234");
//			JOptionPane.showMessageDialog(null, "DB 연결 성공");
			System.out.println("DB 연결 성공");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}	
}
