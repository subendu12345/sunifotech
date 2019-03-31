package info.sun.admin.getconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	Connection connection;

	public Connection getCon() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/surya";
		String name = "root";
		String password = "skmoon@mal3";
		Class.forName("com.mysql.jdbc.Driver");

		connection = DriverManager.getConnection(url, name, password);
		return connection;

	}

}
