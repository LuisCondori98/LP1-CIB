package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
		
		List<Subject> listaSubject = new ArrayList<Subject>();
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			
			con = MysqlConexion.getConexion();
			
			String query = "SELECT * FROM Subject";
			
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Subject subject = new Subject();
				
				subject.setId(rs.getString("idSubject"));
				subject.setCode(rs.getString("code"));
				subject.setName(rs.getString("name"));
				subject.setLevel(rs.getString("level"));
				subject.setTeacher(rs.getString("teacher"));
				
				listaSubject.add(subject);
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				
				if (ps != null)
					
					ps.close();
				if (con != null)
					
					con.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return listaSubject;
	}

	@Override
	public boolean updateSubject(Subject subject) {
	
		boolean success = false;
		
		Connection con = null;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			
			con = MysqlConexion.getConexion();
			
			String query = "UPDATE Subject SET code = ?, name = ?, level = ?, teacher = ? WHERE idSubject = ?";
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, subject.getCode());
			ps.setString(1, subject.getName());
			ps.setString(1, subject.getLevel());
			ps.setString(1, subject.getTeacher());
			ps.setString(1, subject.getId());
			
			success = ps.executeUpdate() > 0;
			
		} catch(Exception e) {
			
			
		} finally {
			
			try {
				
				if (ps != null)
					
					ps.close();
				if (con != null)
					
					con.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return success;
	}

	@Override
	public boolean deleteSubject(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
