package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import entidades.Cliente;
import interfaces.ClienteInterface;

public class ClienteModel implements ClienteInterface {
	
	@Override
	public int createCliente(Cliente cliente) {
		
		int value = 0;
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		try {
			
			con = MySqlConnection.getConnection();
			
			String query = "INSERT INTO Cliente VALUES(null, ?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, cliente.getApellidos());
			ps.setString(2, cliente.getNombres());
			ps.setString(3, cliente.getCorreo());
			ps.setInt(4, cliente.getEdad());
			ps.setDouble(5, cliente.getSalario());
			
			value = ps.executeUpdate();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				
				if (ps != null)
					
					ps.close();
				if (con != null)
					
					con.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return value;
	}

	@Override
	public List<Cliente> getClientes() {
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			
			con = MySqlConnection.getConnection();
			
			String query = "SELECT * FROM Cliente";
			
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Cliente cliente = new Cliente();
				
				cliente.setIdCliente(rs.getInt("IdCliente"));
				cliente.setNombres(rs.getString("Nombres"));
				cliente.setApellidos(rs.getString("Apellidos"));
				cliente.setCorreo(rs.getString("Correo"));
				cliente.setEdad(rs.getInt("Edad"));
				cliente.setSalario(rs.getDouble("Salario"));
				
				listaClientes.add(cliente);
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				
				if (ps != null)
					
					ps.close();
				if (con != null)
					
					con.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return listaClientes;
	}

	@Override
	public boolean updateCliente(Cliente cliente) {
		
		boolean success = false;
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			
			con = MySqlConnection.getConnection();
			
			String query = "UPDATE Cliente SET Nombres = ?, Apellidos = ?, Correo = ?, Edad = ?, Salario = ? WHERE IdCliente = ?";
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, cliente.getNombres());
			ps.setString(2, cliente.getApellidos());
			ps.setString(3, cliente.getCorreo());
			ps.setInt(4, cliente.getEdad());
			ps.setDouble(5, cliente.getSalario());
			ps.setInt(6, cliente.getIdCliente());
			
			success = ps.executeUpdate() > 0;
			
		} catch(Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				
				if (ps != null)
					
					ps.close();
				if (con != null)
					
					con.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return success;
	}
	
	@Override
	public boolean deleteCliente(int id) {
		
		boolean success = false;
		
        Connection con = null;
        
        PreparedStatement ps = null;
        
        try {
        	
            con = MySqlConnection.getConnection();
            
            String sql = "DELETE FROM Cliente WHERE IdCliente = ?";
            
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            success = ps.executeUpdate() > 0;
        } catch (Exception e) {
        	
            e.printStackTrace();
        } finally {
        	
            try {
            	
                if (ps != null) ps.close();
                
                if (con != null) con.close();
            } catch (Exception e) {
            	
                e.printStackTrace();
            }
        }
        return success;
	}

	@Override
	public Cliente getClienteById(String id) {
		
		Cliente cliente = null;
		
        Connection con = null;
        
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        
        try {
            con = MySqlConnection.getConnection();
            
            String sql = "SELECT * FROM Cliente WHERE IdCliente = ?";
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
            	
            	cliente = new Cliente();
            	cliente.setIdCliente(rs.getInt("IdCliente"));
            	cliente.setNombres(rs.getString("Nombres"));
            	cliente.setApellidos(rs.getString("Apellidos"));
            	cliente.setCorreo(rs.getString("Correo"));
            	cliente.setEdad(rs.getInt("Edad"));
            	cliente.setSalario(rs.getDouble("Salario"));
            }
        } catch (Exception e) {
        	
            e.printStackTrace();
        } finally {
        	
            try {
            	
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
            	
                e.printStackTrace();
            }
        }
        return cliente;
	}

}
