<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Login Application</title>
</head>

<body>
<% String userid = (String) session.getAttribute("userid");
	if (userid == null) { userid = ""; } %>

	<fieldset>
		<div align="center">
			<form name="Info" method="post">
				<table border=0 style="background-color: H0080FF80;">
					<tr>
						<td colspan=2 align="center" style="font-weight: bold; font-size: 20pt;" align="center"> <b> Login Form</b> </td>
					</tr>
					<tr>
						<td colspan=2></td>
					</tr>
					<tr>
						<td align="center"><input type="text" name="userid" placeholder="Username" value='<%=userid%>' autofocus="autofocus" style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><input type="password" name="pass" placeholder="Password" value='<%--=password--%>' style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><input type="button" value="Sign In" onclick="return validation();" style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><a href='SecQ'> Forgot Password?</a> </td>
					</tr>
					<tr>
						<td align="center"><a href='Reg'> Create Account!</a> </td>
					</tr>
					<tr>
						<td align="center"><div id="demo">${message}</div></td>
					</tr>
				</table>
			</form>
		</div>

	</fieldset>
	
	<script>
		function validation() {
			var userid = document.Info.userid.value;
			var pass = document.Info.pass.value;
			
			if (userid=="") {
		    		alert("Please enter the User name.")
		    		document.Info.userid.focus();
		    		return false;
		     	}

		    if (pass=="") {
		     		alert("Please enter the password.")
		     		document.Info.pass.focus();
		     	    return false;
		     	}
		     	    
		  	document.Info.action=("Index");
			document.Info.submit();
			return true;
		}
	</script>
 
</body>
</html>