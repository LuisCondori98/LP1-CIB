package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import services.ClienteService;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public ClienteServlet() {
    	
        super();
    }
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		registrarCliente(req, res);
	}

	private void registrarCliente(HttpServletRequest req, HttpServletResponse res) {
		
		String nombre = req.getParameter("nombres");
		String direccion = req.getParameter("direccion");
		Integer edad = Integer.parseInt(req.getParameter("edad"));
		
		System.out.println(nombre + direccion + edad);
		
		Cliente cliente = new Cliente();
		
		cliente.setNombreCliente(nombre);
		cliente.setDireccionCliente(direccion);
		cliente.setEdadCliente(edad);
		
		ClienteService clienteService = new ClienteService();
		
		clienteService.createCliente(cliente);
	}
}
