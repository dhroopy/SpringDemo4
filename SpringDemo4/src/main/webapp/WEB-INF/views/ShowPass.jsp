<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Login Application </title>
</head>
<body>
<% String userid = (String) session.getAttribute("userid");%>
<% String pass = (String) session.getAttribute("pass");%>

<fieldset>
<div align="center">
<h2> Details </h2>
	<form name="sp" method="post" action="Login">
		Your details are as follows: - <br>
		User name : <input type="text" value="<%=userid%>" /> <br>	
		Password : <input type="text" value="<%=pass%>" /> <br>
		<input type="Submit" value="Back to Login"/>
	</form>
</div>
</fieldset>
</body>
</html> 