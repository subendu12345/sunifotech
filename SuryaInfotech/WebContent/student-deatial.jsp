<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="info.sun.admin.getconnection.GetConnection"  %>
    <%@ page import="java.sql.*" %>
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
<jsp:include page="home-header.jsp"  ></jsp:include>
<table class="table table-bordered table-striped table-hover">
<thead>
<tr>
<th>Name</th>
<th>Address</th>
<th>Parent Name</th>
<th>Course Name </th>
<th>Highest Qulif.</th>
<th>Marks(%)</th>
<th>Status</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<%
GetConnection connection = new GetConnection();
Connection con = connection.getCon();
Statement smt = con.createStatement();
ResultSet rs = smt.executeQuery("SELECT * FROM STUDENT s join course_deatils cd on s.course_id=cd.id");
while(rs.next())
{
	%>
	<tr>
	<td><%=rs.getString("student_name")%></td>
	<td><%=rs.getString("student_add")%></td>
	<td><%=rs.getString("student_parent")%></td>
	<td><%=rs.getString("course_name")%></td>
	<td><%=rs.getString("student_qualyfication")%></td>
	<td><%=rs.getString("student_marks")%></td>
	<%
	int st= rs.getInt("is_active");
	if(st==0)
	{
	%>
	<td><a href="active?u=<%=rs.getInt("student_roll")%>" class="btn btn-danger" role="button">Inactive</a>
	<%
	}
	else{
		%>
		<td><a href="deactivate?u=<%=rs.getInt("student_roll")%>" class="btn btn-success" role="button">Active</a>
		<%
		
	}
	%>
	<td><a href="delete?u=<%=rs.getInt("student_roll")%>" class="btn btn-warning" role="button">Delete</a>
	<a href="student-update.jsp?u=<%=rs.getInt("student_roll")%>" class="btn btn-info" role="button">Update</a></td>
	</tr>
	
	<%	
}

%>
</tbody>
</table>
</body>
</html>