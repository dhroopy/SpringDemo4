<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin - Pending Action</title>
</head>
<body>
<%-- List<List<String>> Entry = request.getAttribute("entry");--%>
<fieldset>
<div align="center">
			<form name="Info" method="post">
				<table border=1 style="background-color: H0080FF80;">
					<tr>
						<td colspan=5 align="center" style="font-weight: bold; font-size: 20pt;" align="center"> <b> Pending Approvals </b> </td>
					</tr>
					<tr>
						<td align="center" width="16.66%">Account Holder</td>
						<td align="center" width="16.66%">User ID</td>
						<td align="center" width="16.66%">Account #</td>
						<td align="center" width="16.66%">Account Type</td>
						<!-- <td align="center" width="16.66%">Lock / Unlock</td> -->
						<td align="center" width="16.66%">Approve New</td>
					</tr>
					<tr>
						<td colspan=5 align="center"><div id="demo">${message}</div></td>
					</tr>
				</table>
			</form>
			
		</div>
</fieldset>
</body>
</html>