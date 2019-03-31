<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Amin-home</title>	
</head>
<%
		if(session.getAttribute("adminName") == null)
			response.sendRedirect("adminauth.jsp");
	%>
<jsp:include page="home-header.jsp"></jsp:include>

</body>
</html>