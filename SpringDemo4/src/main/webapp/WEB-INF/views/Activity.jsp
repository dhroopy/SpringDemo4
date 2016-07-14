<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title> Login Application </title>
</head>

<body>
<% String userid = (String) session.getAttribute("userid");%>
<% String fname = (String) session.getAttribute("Fname");%>
<% String lname = (String) session.getAttribute("Lname");%>
<% String name = (String) session.getAttribute("Name");%>
<fieldset>
<div align="center">
	<h2>Welcome <%=fname + " " + lname%></h2>
	Please select an account.
	<form name="sec" method="post" action="Txn">
		<table border=0 style="background-color: H0080FF80;">
			<tr>
				<td align="center"><input type="text" name="userid" value=<%=name%> style="width: 162px; "></td>
			</tr>
			<tr>
				<td align="center"><select name="Accttype" style="width: 162px; ">
					<option value="C">Current</option>
					<option value="S">Savings</option>
				</select></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" Value="See Activity"/></td>
			</tr>
			<tr>
				<td align="center"><div id="demo">${message}</div></td>
			</tr>
		</table>	
	</form>
</div>	
</fieldset>
</body>
</html>