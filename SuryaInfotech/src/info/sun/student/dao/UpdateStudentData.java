package info.sun.student.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import info.sun.admin.getconnection.GetConnection;

public class UpdateStudentData {
		int sk;
	private int id;
	private String student_name;
	private String student_add;
	private String student_parent;
	private int course_id;
	private String student_quly;
	private int student_marks;
	private String student_contact;
	
	
	
	public UpdateStudentData(int id, String student_name, String student_add, String student_parent, int course_id,
			String student_quly, int student_marks, String student_contact) {
		super();
		this.id = id;
		this.student_name = student_name;
		this.student_add = student_add;
		this.student_parent = student_parent;
		this.course_id = course_id;
		this.student_quly = student_quly;
		this.student_marks = student_marks;
		this.student_contact = student_contact;
		
	}
	public boolean updateStudent() throws ClassNotFoundException, SQLException
	{
		GetConnection obj = new GetConnection();
		Connection connection = obj.getCon();
		try
		{
			Statement smt = connection.createStatement();
			sk=smt.executeUpdate("UPDATE student SET student_name='"+student_name+"', student_add='"+student_add+"', student_parent='"+student_parent+"',"
					+ " course_id='"+course_id+"', student_qualyfication='"+student_quly+"', student_marks='"+student_marks+"', student_contact='"+student_contact+"' where student_roll='"+id+"'");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			student_name=null;
			student_add=null;
			student_contact=null;
			student_marks=0;
			student_parent=null;
			student_quly=null;
			course_id=0;
			connection.close();
		}
		if(sk>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
	
	
}
