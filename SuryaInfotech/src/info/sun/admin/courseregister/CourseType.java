package info.sun.admin.courseregister;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import info.sun.admin.getconnection.GetConnection;

public class CourseType {

		int sk;
		private int id;
		private String course_name;
		
		public CourseType(int sk, int id, String course_name) {
			super();
			this.sk = sk;
			this.id = id;
			this.course_name = course_name;
		}
		
		public boolean saveCourseType() throws ClassNotFoundException, SQLException
		{
			sk = 0;
			GetConnection obj = new GetConnection();
			Connection con = obj.getCon();
			try {
			Statement smt = con.createStatement();
			sk = smt.executeUpdate("INSERT INTO "
					+ "course(id,course_name)" + "VALUES('"
					+ id + "','" + course_name + "')");
			}catch(Exception e) {
				System.out.println(e);
			}
			finally {
				con.close();
			}
			if (sk > 0) {
				return true;
			} else {
				return false;
			}
		}
			
}
