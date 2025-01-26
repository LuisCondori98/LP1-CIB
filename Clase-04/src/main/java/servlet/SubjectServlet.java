package servlet;

import java.io.IOException;
import java.util.List;

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
    
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		System.out.println("Entro 1");
		
		String type = req.getParameter("type");
		
		switch (type){
		
			case "Grabar": registerSubject(req, res); break;
			case "Listar": listarSubject(req, res); break;
			
			default:
				req.setAttribute("mensaje", "Ocurrio un problema");
				req.getRequestDispatcher( "subject.jsp").forward(req, res);
		}
	}
	
	private void registerSubject(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
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
	
	private void listarSubject(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		SubjectModel subjectModel = new SubjectModel();
		
		List<Subject> listSubject = subjectModel.listSubject();
		
		System.out.println(listSubject);
		
		req.setAttribute("data", listSubject);
		req.getRequestDispatcher("/jsp/Subject.jsp").forward(req, res);
	}
}
