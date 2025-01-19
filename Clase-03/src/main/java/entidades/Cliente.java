package entidades;

import lombok.Data;

@Data
public class Cliente {

	private Integer IdCliente;
	private String NombreCliente;
	private String DireccionCliente;
	private Integer EdadCliente;
}
