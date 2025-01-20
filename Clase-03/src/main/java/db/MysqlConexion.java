package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConexion {

	public static Connection getConexion() {
		
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/dbsistema?useSSL=false&serverTimezone=UTC";
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

	public static void closeConexion(Connection con) {
		
		try {
			
			con.close();
		} catch(SQLException e) {
			
			System.out.println("Problemas al cerrar 1a conexion*");
		}
	}

}
