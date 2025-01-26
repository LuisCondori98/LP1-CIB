package interfaces;

import java.util.List;

import entidades.Cliente;

public interface ClienteInterface {

	public int createCliente(Cliente cliente);
	
	public List<Cliente> getClientes();
	
	public boolean updateCliente(Cliente cliente);
	
	public boolean deleteCliente(int id);
	
	public Cliente getClienteById(String id);
}
