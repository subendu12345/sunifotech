<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminAuth</title>

<style type="text/css">
.formdiv{
padding-left: 40%;
padding-right: 20%;
}
.title{
	background-color: hsl(147, 50%, 47%);
	color: hsl(0, 60%, 50%);
	text-align: center;
	
}
td {
  height: 50px;
  vertical-align: bottom;
}
.inputc{
height: 23px;
}

.lablec{
color: hsl(240, 100%, 50%);
}
</style>
</head>
<body>
<br>
<br>
<br>
<br>
<div class="formdiv">
<form action="adminauth" method="post">
<table>
<tr><th class="title"><p>Welcome To Admin Authentication</p></th>
</tr>
<tr><td>
	<label class="lablec">Enter Your User Name</label>&nbsp;&nbsp;
	<input type="text" class="inputc" name="adminName" required="required" placeholder="Enter Your User name"/>
	
</td></tr>
<tr><td>
	<label class="lablec">Enter Your Password</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="password" name="adminPass" class="inputc" required="required" placeholder="Enter Your Password"/>
	<input type="submit" value="Submit"  />
</td></tr>
</table>
</form>

</div>
</body>
</html>