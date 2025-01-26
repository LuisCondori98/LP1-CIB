package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	public static Connection getConnection() {
		
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/BD_EMPRESA?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String password = "luiscondori";

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, user, password);
			
			System.out.println("Conexion exitosa");
		} catch (ClassNotFoundException e) {
			
			System.out.println("Drive no encontrado");
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			System.out.println("Error de conexion");
			
			e.printStackTrace();

		}
		return connection;
	}
	
	public void closeConnection(Connection con) {
		
		try {
			
			con.close();
		} catch(SQLException e) {
			
			System.out.println("Problemas al cerrar 1a conexion*");
		}
	}
}
