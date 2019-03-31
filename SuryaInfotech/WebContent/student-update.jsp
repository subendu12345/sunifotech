<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="info.sun.admin.getconnection.GetConnection"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Stusent</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Satisfy'
	rel='stylesheet' type='text/css'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style type="text/css">
.dropbtn {
	background-color: transparent;
	color: white;
	padding: 16px;
	font-size: 14px;
	border: none;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: white;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #181068;
}

.dropdown:hover .dropdown-content {
	display: block;
	color: white;
}

.dropdown:hover .dropbtn {
	background-color: transparent;
}

#ui {
	background-color: #333;
	padding: 35px;
	margin-top: 50px;
	border-radius: 6px;
}

#ui label {
	color: #fff;
}

#ui form {
	margin-left: 60px;
}

#ui button {
	margin-left: 200px;
}

body {
	background-image: url("registration.jpg");
}
</style>

</head>



<body>
<jsp:include page="home-header.jsp"></jsp:include>
	

	<div class="container">
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">

				<div id="ui">

					<form action="updateStudent" class="form-group"
						method="post">

						<%
					String url = "jdbc:mysql://localhost:3306/surya";
					String pass = "skmoon@mal3";
					String name = "root";
					int id = Integer.parseInt(request.getParameter("u"));	
					System.out.println("This the student-update jsp page id = "+id);
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, name, pass);
					Statement smt = con.createStatement();
					ResultSet rs = smt.executeQuery("SELECT * FROM STUDENT s join course_deatils cd on s.course_id=cd.id where student_roll ='"+id +"' ");
					while (rs.next())
					{
					%>

						<div class="row">
							<div class="col-lg-8">
								<label class="">Enter Your Name</label> <input type="text"
									placeholder="name" value="<%=rs.getString(2) %>" name="studentname" class="form-control">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-lg-8">
								<label class="">Enter Your Address</label> <input type="text"
									placeholder="name" value="<%=rs.getString(3) %>" name="address" class="form-control">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-lg-8">
								<label class="">Enter Your Father Name.</label> <input
									type="text" value="<%=rs.getString(4) %>" placeholder="father name" name="fatherName"
									class="form-control">
							</div>

						</div>
						<br>
						<div class="row">
							<div class="col-lg-8">
								<label class="">Select Course</label> <select
									class="form-control" name="course_id">
									<option value="<%=rs.getInt(5) %>"><%=rs.getString("course_name") %></option>
									<%
					
										Statement sm = con.createStatement();
										ResultSet r = sm.executeQuery("SELECT * FROM course_deatils");
										while(r.next())
										{
											%>
											<option value="<%=r.getInt(1) %>"><%=r.getString(2) %></option>
											<%
										}
									%>



								</select>
							</div>
						</div>
						<br>

						<div class="row">
							<div class="col-lg-8">
								<label class="">Select Highest Qualification</label> <select
									class="form-control" name="cualifi">
									<option value="<%=rs.getString(6) %>" ><%=rs.getString(6) %></option>
									<option value="X">X</option>
									<option value="XII">XII</option>
									<option value="other">other</option>
								</select>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-lg-8">
								<label class="">Enter Marks (%)</label> <input type="text"
								 value="<%=rs.getString(7) %>"	placeholder="ex-100%" name="marks" class="form-control">
							</div>

						</div>


						<br>

						<div class="row">
							<div class="col-lg-8">
								<label class="">Enter Contact Info</label> <input type="text"
								  value="<%=rs.getString(8) %>"	placeholder="email,phone number" name="contact"
									class="form-control">
							</div>
						</div>
						<br>
						<input type="hidden" value="<%=rs.getInt(1) %>" name="studentId">
						<%
							}
					%>
						<br>
						<button type="submit" class="btn btn-success">Submit</button>

					</form>

				</div>
			</div>
			<div class="col-lg-3"></div>
		</div>


	</div>

</body>
</html>