package info.sun.student.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import info.sun.admin.getconnection.GetConnection;

public class DeactivateSudent {
	int sk=0;
	int id ;
	
	
	public DeactivateSudent( int id) {
		super();
		this.id = id;
	}
	
	public boolean deactiveAccount() throws ClassNotFoundException, SQLException {
		this.sk=0;
		GetConnection connection = new GetConnection();
		Connection con = connection.getCon();
		try
		{
			Statement smt = con.createStatement();
			sk = smt.executeUpdate("UPDATE student SET is_active=false where student_roll='"+id+"' ");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			con.close();
		}
		if(sk>0)
			return true;
		else
			return false;
	}
}
