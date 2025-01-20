package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import db.MysqlConexion;
import entidades.Subject;
import interfaces.SubjectInterface;

public class SubjectModel implements SubjectInterface {

	@Override
	public int createSubject(Subject subject) {
		
		int value = 0;
		
		Connection cn = null;
		
		PreparedStatement psm = null;
		
		try {
			
			cn = MysqlConexion.getConexion();
			
			String sql = "INSERT INTO Subject VALUES (null, ?, ?, ?, ?)";
			
			psm = cn.prepareStatement(sql);
			
			psm.setString(1, subject.getCode());
			psm.setString(2, subject.getName());
			psm.setString(3, subject.getLevel());
			psm.setString(4, subject.getTeacher());
			
			value = psm.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				
				if (psm != null)
					
					psm.close();
				if (cn != null)
					
					cn.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return value;

	}

	@Override
	public List<Subject> listSubject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSubject(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
