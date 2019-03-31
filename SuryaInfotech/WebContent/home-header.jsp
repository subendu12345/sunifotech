<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Satisfy'
	rel='stylesheet' type='text/css'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</head>
<body>

<body>
	<%
		if(session.getAttribute("adminName") == null)
			response.sendRedirect("adminauth.jsp");
	%>

		<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#topNavBar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">SUN INFOTECH</a>
			</div>
			<div class="collapse navbar-collapse" id="topNavBar">
				<ul class="nav navbar-nav">

					<li class="active"><a href="#">HOME</a></li>
					<li><a href="#">Link 2</a></li>
					<li><a href="student-deatial.jsp">Student Info.</a></li>
				
					
				</ul>
					<button class="btn btn-primary navbar-btn" data-toggle="modal" data-target="#exampleModal">Add Course</button>
				<%!String name= ""; %>
				
				<%
					if(session.getAttribute("adminName")!= null)
					{
						name = session.getAttribute("adminName").toString();
						
						System.out.println("adminName  " + name);
					
						
						%>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a><span class="glyphicon glyphicon-user" aria-hidden="true"></span> <%=name %>
					</a></li>
						<li>
						<form class="form-inline ml-auto" action="logout"  method="post">
				<button class="btn btn-primary" type="submit">Logout</button>
        </form>
			
						</li>
					</ul>
					<%
					}
				%>
		
				<%
					if(session.getAttribute("teacherName")!= null)
					{
						name = session.getAttribute("teacherName").toString();
						
						System.out.println("Teacher name in jsp  " + name);
					
						
						%>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a><span class="glyphicon glyphicon-user" aria-hidden="true"></span> <%=name %>
					</a></li>
						<li>
			<form class="form-inline ml-auto" action="logout"  method="post">
				<button class="btn btn-primary" type="submit">Logout</button>
        </form>
						</li>
					</ul>
					<%
					}
				%>		
		
			</div>
		</div>
	</nav>

	<form action="courseregister" method="post">
	<div class="modal fade" id="exampleModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#topNavBar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				
			
				<div class="modal-body">
				
						<div class="row">
							<div class="col-lg-8">
								<label class="">Select Course Type</label> <select
									class="form-control" name="courseID">
									<option>Select One</option>

									<%
										String url = "jdbc:mysql://localhost:3306/surya";
										String pass = "skmoon@mal3";
										String name = "root";
										Class.forName("com.mysql.jdbc.Driver");
										Connection con = DriverManager.getConnection(url, name, pass);
										Statement smt = con.createStatement();
										ResultSet rs = smt.executeQuery("select * from course");
										while (rs.next()) {
									%>
									<option name="dep_id" id="dopt"
										value="<%=rs.getString("course_id")%>"><%=rs.getString("course_name")%></option>
									<%
										}
									%>

								</select>
							</div>
						</div>
						<br>
				
					<label>Course Name.</label>
					<input type="text" name="cname" class="form-control" required="required" placeholder="DITA,CITA"><br>
					<label>Course Duration.</label>
					<input type="text" name="duration" class="form-control" required="required" placeholder="6,month,3,month"><br>
					
    			
      </div>
				
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Save</button>
				</div>
			</div>
		</div>
	</div>
	</form>

</body>
</html>