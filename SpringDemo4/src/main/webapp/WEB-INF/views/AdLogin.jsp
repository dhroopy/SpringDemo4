<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Admin Login</title>
</head>

<body>
	<fieldset>
		<div align="center">
			<form name="Info" method="post">
				<table border=0 style="background-color: H0080FF80;">
					<tr>
						<td colspan=2 align="center" style="font-weight: bold; font-size: 20pt;" align="center"> <b>Admin Login Form</b> </td>
					</tr>
					<tr>
						<td colspan=2></td>
					</tr>
					<tr>
						<td align="center"><input type="text" name="userid" placeholder="Username" autofocus="autofocus" style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><input type="password" name="pass" placeholder="Password" style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><input type="button" value="Sign In" onclick="return validation();" style="width: 162px; "></td>
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
		     	    
		    document.Info.action=("Adws");
			document.Info.submit();
			return true;
		}
	</script>
</body>
</html>