package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Subject;
import modelos.SubjectModel;

@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public SubjectServlet() {
    	
        super();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Entro 1");
		
		String type = request.getParameter("type");
		
		switch (type){
		
			case "Grabar": registerSubject(request, response); break;
			
			default:
				request.setAttribute("mensaje", "Ocurrio un problema");
				request.getRequestDispatcher( "subject.jsp").forward(request, response);
		}
	}
	
	private void registerSubject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String code = req.getParameter("txtCode");
		String name = req.getParameter("txtName") ;
		String level = req.getParameter("txtLevel");
		String teacher = req.getParameter("txtTeacher");
		
		System.out.println("hOLA PASO 1");
		
		Subject subject = new Subject();
		
		subject. setCode(code) ;
		subject .setName(name) ;
		subject.setLevel (level);
		subject. setTeacher(teacher);
		
		SubjectModel model = new SubjectModel();
		
		int value = model.createSubject (subject);
	
	}
}
