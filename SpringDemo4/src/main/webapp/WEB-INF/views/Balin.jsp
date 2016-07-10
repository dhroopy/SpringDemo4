<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String userid = (String) session.getAttribute("userid");%>
<% String fname = (String) session.getAttribute("Fname");%>
<fieldset>
<div align="center">
			<form name="Info" method="post">
				<table border=0 style="background-color: H0080FF80;">
					<tr>
						<td colspan=2 align="center" style="font-weight: bold; font-size: 20pt;" align="center"> <b> Account Balance</b> </td>
					</tr>
					<tr>
						<td colspan=2></td>
					</tr>
					<%-- <tr>
						<td align="center"><input type="text" name="userid" value=<%=userid%> style="width: 162px; "></td>
					</tr> --%>
					<tr>
						<td align="center"><input type="text" name="fname" value=<%=fname%> style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><select name="Accttype" style="width: 162px; ">
  							<option value="C">Current</option>
							<option value="S">Savings</option>
						</select></td>
					</tr>
					<tr>
						<td align="center"><input type="text" name="Balance" value="${Bal}" autofocus="autofocus" style="width: 162px; "></td>
					</tr>
				</table>
			</form>
			
		</div>
</fieldset>
</body>
</html>