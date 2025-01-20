package interfaces;

import java.util.List;

import model.Cliente;

public interface ClienteInterface {

	public int createCliente(Cliente cliente);
	public List<Cliente> getAllClientes();
	public Cliente updateCliente(Integer id, Cliente newCliente);
	public void deleteCliente(Integer Id);
}
