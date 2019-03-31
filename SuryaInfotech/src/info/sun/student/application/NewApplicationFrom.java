package info.sun.student.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import info.sun.admin.getconnection.GetConnection;

public class NewApplicationFrom {
	int sk;
	int roll=0;
	
	
	
	
	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	private String student_name;
	private String student_add;
	private String student_parent;
	private int course_id;
	private String student_quly;
	private int student_marks;
	private String student_contact;
	private String student_password;
	
	
	
	public NewApplicationFrom(String student_name, String student_add, String student_parent, int course_id,
			String student_quly, int student_marks, String student_contact, String student_password) {
		super();
		this.student_name = student_name;
		this.student_add = student_add;
		this.student_parent = student_parent;
		this.course_id = course_id;
		this.student_quly = student_quly;
		this.student_marks = student_marks;
		this.student_contact = student_contact;
		this.student_password = student_password;
	}
	
	public boolean saveApplication() throws SQLException, ClassNotFoundException
	{
		sk = 0;
		GetConnection obj = new GetConnection();
		Connection con = obj.getCon();
		try {
			
			/*Statement smt = con.createStatement();
			sk = smt.executeUpdate("INSERT INTO  student(student_name,student_add,student_parent,course_id,student_qualyfication,student_marks,student_contact,student_password)"
					+ "VALUES('" + student_name + "','" + student_add +"','" + student_parent + "','" + course_id + "','"+student_quly+"','" + student_marks + "','" + student_contact +"','" + student_password + "')");
			*/
//		PreparedStatement ps = con.prepareStatement("SELECT MAX(student_id)FROM student");
//		ResultSet rs = ps.executeQuery();
//		if(rs.next()) {
//			this.roll = rs.getInt(1);
//			this.roll++;
//		}
//		
			
		Random random = new Random();
		roll = 1000000+random.nextInt(89999999);
			System.out.println(roll);
		PreparedStatement p = con.prepareStatement("INSERT INTO student(student_roll,student_name,student_add,student_parent,course_id,student_qualyfication,student_marks,student_contact,student_password) VALUES(?,?,?,?,?,?,?,?,?)");
		p.setInt(1,roll);
		p.setString(2, student_name);
		p.setString(3, student_add);
		p.setString(4, student_parent);
		p.setInt(5, course_id);
		p.setString(6, student_quly);
		p.setInt(7, student_marks);
		p.setString(8, student_contact);
		p.setString(9, student_password);
		
		sk=p.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			con.close();
		}
		if (sk > 0) {
			System.out.println(roll);
			return true;
		} else {
			return false;
		}
		

		
	}
	
}
