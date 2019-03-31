<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Diploma Course</title>
<style type="text/css">
#forimg img{
width: 100%;
}
body
{
	background-image: url("Diploma.jpg");
	background-position: center;
	background-size: cover;
}
</style>



</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			
					<%
										String url = "jdbc:mysql://localhost:3306/surya";
										String pass = "skmoon@mal3";
										String name = "root";
										Class.forName("com.mysql.jdbc.Driver");
										Connection con = DriverManager.getConnection(url, name, pass);
										Statement smt = con.createStatement();
										ResultSet rs = smt.executeQuery("select * from course_deatils where course_id = 5000001");
										while (rs.next()) {
									%>
											<div class="col-sm-4">
											<div class="panel panel-primary">
											<div class="panel-heading"><%=rs.getString("course_name") %></div>
											<div class="panel-body">
												<p>Duration:-<%=rs.getString("course_duration")%></p></div>
											<div class="panel-footer">
												<a href="student-application.jsp" class="btn btn-info"
													role="button"> Apply The Course </a>
													</div>
													
													
											</div>
										</div>
						<%
										}
										
										
									%>







			</div>


		</div>

	</div>

</body>
</html>