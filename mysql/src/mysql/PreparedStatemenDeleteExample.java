package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class PreparedStatemenDeleteExample {

	public static void main(String[] args) {
		Connection connection = null;
	    PreparedStatement preparedStatement  =null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3312/jdbc1","root","root");
			
			String inputSQL ="DELETE FROM user3 WHERE id=?";
			
			preparedStatement=connection.prepareStatement(inputSQL);
			
			preparedStatement.setInt(1, 10);
								 
			int numofRecAffected =preparedStatement.executeUpdate();
			
			System.out.println("numofRecAffected:" +numofRecAffected);
			
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
	}

}
