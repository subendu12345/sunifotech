package info.sun.student.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.ws.Response;

import info.sun.admin.getconnection.GetConnection;

public class StudentLogInSuccess {
	private int id;
	String name = "";
	private int is_acteve;
	private String password;
	
	
	
	public int getIs_acteve() {
		return is_acteve;
	}




	public void setIs_acteve(int is_acteve) {
		this.is_acteve = is_acteve;
	}




	public StudentLogInSuccess(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	
	
	
	public boolean success() throws ClassNotFoundException, SQLException {
		
		GetConnection obj = new GetConnection();
		Connection con = obj.getCon();
		try {
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery(
					"SELECT *FROM student where student_roll='" + id + "' and student_password='" + password + "'");
			if (rs.next()) {
				is_acteve = rs.getInt(10);
				{
					if (is_acteve == 0) {
						is_acteve = 0;
						return true;
					}
					if(is_acteve == 1)
					{
						is_acteve=1;
						return true;
					}
				}
				
			} else
				return false;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			id = 0;
			password = null;
		}
		return false;

	}

	public String getName(int id) throws ClassNotFoundException, SQLException {
		GetConnection obj = new GetConnection();
		Connection con = obj.getCon();
		try {
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("SELECT *FROM student where student_roll='" + id + "'");
			if (rs.next()) {
				name = rs.getString(2);
				return name;
			} else
				return name;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			id = 0;
			password = null;
		}
		return name;

	}

}
