package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import interfaces.ClienteInterface;
import model.Cliente;

public class ClienteService implements ClienteInterface {
	
	private MySqlConnection mySqlConnection; 

	@Override
	public int createCliente(Cliente cliente) {
		
		int i = 0;
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			
			con = mySqlConnection.getConnection();
			
			String query = "INSERT INTO Clientes(NombreCliente, DireccionCliente, EdadCliente) VALUES(?, ?, ?)";
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, cliente.getNombreCliente());
			ps.setString(2, cliente.getDireccionCliente());
			ps.setInt(3, cliente.getEdadCliente());
			
			i = ps.executeUpdate();
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public List<Cliente> getAllClientes() {
		
		List<Cliente> clientes = new ArrayList<>();
		
		String query = "SELECT * FROM Clientes";
		
		try {
			
			Connection conn = mySqlConnection.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Cliente cliente = new Cliente();
				
				cliente.setIdCliente(rs.getInt("IdCliente"));
				cliente.setNombreCliente(rs.getString("NombreCliente"));
				cliente.setDireccionCliente(rs.getString("DireccionCliente"));
				cliente.setEdadCliente(rs.getInt("EdadCliente"));
				
				clientes.add(cliente);
			}
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return clientes;
	}

	@Override
	public Cliente updateCliente(Integer id, Cliente newCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCliente(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
