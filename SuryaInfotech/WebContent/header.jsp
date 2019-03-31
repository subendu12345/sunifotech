<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #181068;}

.dropdown:hover .dropdown-content 
{
display: block;
color: white;
									
}

.dropdown:hover .dropbtn {background-color: transparent;}
</style>

</head>
<body>
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
					<li><a href="#">ABOUT US</a></li>
					<li>
					<div class="dropdown">
						  <button class="dropbtn">CROUSE</button>
						  <div class="dropdown-content">
						    <a href="diploma-course.jsp">DIPLOMA CROUSE</a>
						    <a href="#">CERTIFICATE COURSE</a>
						    <a href="#">Link 3</a>
						  </div>
						</div>
					
					</li>
					
				</ul>
					<button class="btn btn-primary navbar-btn" data-toggle="modal" data-target="#exampleModal">Login</button>
				<%!String name= ""; %>
				
				<%
					if(session.getAttribute("studentname")!= null)
					{
						name = session.getAttribute("studentname").toString();
						
						System.out.println("studentname  " + name);
					
						
						%>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a><span class="glyphicon glyphicon-user" aria-hidden="true"></span> <%=name %>
					</a></li>
						<li>
			<form class="form-inline ml-auto" action="Stdlogout"  method="post">
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


<form action="studentlogin" method="post">
	<div class="modal fade" id="exampleModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#topNavBar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<h5 class="modal-title" id="exampleModalLabel">Login Form</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				
			
				<div class="modal-body">
				
							<div class="row">
							<div class="col-lg-8">	
					<label>Enter Your User ID.</label>
					<input type="text" name="u_ID" class="form-control" required="required" >
					
					<label>Enter Your Password</label>
					<input type="password" name="pass" class="form-control" required="required" ><br>
					</div>
    			</div>
      
				
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Login</button>
				</div>
			</div>
		</div>
	</div>
	</div>
	</form>

</body>
</html>