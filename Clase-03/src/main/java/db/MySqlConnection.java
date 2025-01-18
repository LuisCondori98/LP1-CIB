package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	public static Connection getConnection() {
		
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/ejemplo?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String pass = "luiscondori";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, pass);
			
			System.out.println("Conexion establecida con la base de datos");
			
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeConnection(Connection con) {
		
		try {
			
			con.close();
		} catch(SQLException e) {
			
			System.out.println("Problemas para cerrar la conexion");
		}
	}
}