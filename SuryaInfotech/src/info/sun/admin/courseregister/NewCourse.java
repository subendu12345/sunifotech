package info.sun.admin.courseregister;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import info.sun.admin.getconnection.GetConnection;

public class NewCourse {
	int sk;
	
	private String course_name;
	private int course_id;
	private String course_duration;

	public NewCourse( int course_id,String course_name, String course_duration) {
		super();
		this.course_name = course_name;
		this.course_id = course_id;
		this.course_duration = course_duration;
	}

	public boolean saveCourseDetails() throws SQLException, ClassNotFoundException {
		sk = 0;
		GetConnection obj = new GetConnection();
		Connection con = obj.getCon();
		try {
			Statement smt = con.createStatement();
			sk = smt.executeUpdate("INSERT INTO course_deatils(course_name,course_id,course_duration)"
					+ "VALUES('" + course_name + "','" + course_id + "','" + course_duration + "')");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			con.close();
		}
		if (sk > 0) {
			return true;
		} else {
			return false;
		}
	}

}
