package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import modelos.ClienteModel;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public ClienteServlet() {
    	
        super();
    }
    
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		
		switch(type) {
		
			case "Crear" : registrarCliente(req, res); break;
			case "Listar" : listarClientes(req, res); break;
			case "Actualizar": UpdateCliente(req, res); break;
			case "Borrar": deleteCliente(req, res); break;
			case "Info": getClienteById(req, res); break;
		}
	}

	private void listarClientes(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ClienteModel clienteModel = new ClienteModel();
		
		List<Cliente> listaClientes = clienteModel.getClientes();
		
		req.setAttribute("data", listaClientes);
		req.getRequestDispatcher("/jsp/cliente.jsp").forward(req, res);
	}

	private void registrarCliente(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String nombre = req.getParameter("nombres");
		String apellido = req.getParameter("apellidos");
		String correo = req.getParameter("correo");
		int edad = Integer.parseInt(req.getParameter("edad"));
		double salario = Double.parseDouble(req.getParameter("salario"));
		
		Cliente cliente = new Cliente();
		
		cliente.setNombres(nombre);
		cliente.setApellidos(apellido);
		cliente.setCorreo(correo);
		cliente.setEdad(edad);
		cliente.setSalario(salario);
		
		ClienteModel clienteModel = new ClienteModel();
		
		clienteModel.createCliente(cliente);
		
		req.getRequestDispatcher("/jsp/cliente.jsp").forward(req, res);
	}
	
	private void UpdateCliente(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
        String apellidos = req.getParameter("apellidos");
        String correo = req.getParameter("correo");
        int edad = Integer.parseInt(req.getParameter("edad"));
        double salario = Double.parseDouble(req.getParameter("salario"));

        Cliente cliente = new Cliente();
        
        cliente.setIdCliente(id);
        cliente.setNombres(nombre);
        cliente.setApellidos(apellidos);
        cliente.setCorreo(correo);
        cliente.setEdad(edad);
        cliente.setSalario(salario);

        ClienteModel model = new ClienteModel();
        
        boolean success = model.updateCliente(cliente);

        if (success) {
        	
        	listarClientes(req, res);
        } else {
        	
            req.setAttribute("mensaje", "No se pudo actualizar el curso");
            
            req.getRequestDispatcher("/jsp/cliente.jsp").forward(req, res);
        }
	}
	
	private void deleteCliente(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
        
		ClienteModel model = new ClienteModel();
           
          
        boolean success =  model.deleteCliente(Integer.parseInt(id));

        if (success) {
        	
        	listarClientes(req, res);
        } else {
            req.setAttribute("mensaje", "No se pudo eliminar al cliente");
            req.getRequestDispatcher("/jsp/cliente.jsp").forward(req, res);
        }
	}
	
	private void getClienteById(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
        ClienteModel model = new ClienteModel();
        
        Cliente cliente = model.getClienteById(id);

        if (cliente != null) {
        	req.setAttribute("cliente", cliente);
        	req.getRequestDispatcher("/jsp/editCliente.jsp").forward(req, res);
        } else {
        	req.setAttribute("mensaje", "No se encontró al cliente");
        	req.getRequestDispatcher("/jsp/cliente.jsp").forward(req, res);
        }
	}
}
