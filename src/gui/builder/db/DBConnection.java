package gui.builder.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DBConnection {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java_a?serverTimezone=UTC", 
					"root", 
					"1234");
			
			Statement stmt = conn.createStatement();    // 쿼리를 할 수 있는 문장준비 
			
			// insert 
//			String sql = "INSERT INTO student (id, name, dept, grade) "
//					+ "VALUES('3333333', '이길동', '수학과', 2);";
			
			String input = JOptionPane.showInputDialog("id를 입력하세요."); //"4444444"
			
//			String sql = "UPDATE student "
//					+ "SET name='테스터2', dept='테스팅학과2', grade=4 "
//					+ "WHERE id='" + input + "'";
			
			String sql = "DELETE FROM student "
					+ "WHERE id='" + input + "'";
			
			System.out.println(sql);
			
			int cnt = stmt.executeUpdate(sql);
			
			// select 
			ResultSet rs = stmt.executeQuery("SELECT * FROM student");
			System.out.println("학번" + "\t" + "이름" + "\t" + "학년" + "\t" + "학과");
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String dept = rs.getString("dept");
				String grade = rs.getString("grade");
				
				System.out.println(id + "\t" + name + "\t" + grade + "\t" + dept);
				
				
			}
			
			
			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			System.err.println("해당 드라이버가 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("SQL 오류 발생.");
			e.printStackTrace();
		}
	}

}
