package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	public static Connection getConnection() {
		
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/ejemplo?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String pass = "luiscondori";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, user, pass);
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
	}
}
