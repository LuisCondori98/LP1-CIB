package entidades;

public class Cliente {

	private Integer IdCliente;
	private String NombreCliente;
	private String DireccionCliente;
	private Integer EdadCliente;
	
	public Cliente() {
		super();
	}

	public Cliente(Integer idCliente, String nombreCliente, String direccionCliente, Integer edadCliente) {
		IdCliente = idCliente;
		NombreCliente = nombreCliente;
		DireccionCliente = direccionCliente;
		EdadCliente = edadCliente;
	}

	public Integer getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(Integer idCliente) {
		IdCliente = idCliente;
	}

	public String getNombreCliente() {
		return NombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}

	public String getDireccionCliente() {
		return DireccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		DireccionCliente = direccionCliente;
	}

	public Integer getEdadCliente() {
		return EdadCliente;
	}

	public void setEdadCliente(Integer edadCliente) {
		EdadCliente = edadCliente;
	}

	@Override
	public String toString() {
		return "Cliente [IdCliente=" + IdCliente + ", NombreCliente=" + NombreCliente + ", DireccionCliente="
				+ DireccionCliente + ", EdadCliente=" + EdadCliente + "]";
	}
}
