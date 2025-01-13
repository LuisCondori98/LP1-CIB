package servelet;

import java.io.Console;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServelet")
public class LoginServelet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public LoginServelet() {
    	
        super();
    }
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//res.getWriter().append("Served at: ").append(req.getContextPath());
		res.setContentType("html");
		
		String correo = req.getParameter("email");
        String contraseña = req.getParameter("password");
		
		System.out.println("Correo: " + correo + "\nContraseña: " + contraseña);
		
		res.getWriter().println("<h1>" + correo + "</h1>");
		res.sendRedirect("/Clase-02/jsp/index.jsp");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doPut(req, res);
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doDelete(req, res);
	}
}
