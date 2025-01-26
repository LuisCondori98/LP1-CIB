package interfaces;

import java.util.List;

import entidades.Subject;

public interface SubjectInterface {

	public int createSubject(Subject subject);
	public  List<Subject> listSubject();
    public boolean updateSubject(Subject subject);
    public boolean deleteSubject(int id);
}
