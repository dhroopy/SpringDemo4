<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title> Login Application </title>
</head>

<body>
<% String userid = (String) session.getAttribute("userid");%>

<fieldset>
<div align="center">
	<h2>Password Retrieval</h2>

	<form name="sec" method="post">
		<table border=0 style="background-color: H0080FF80;">
			<tr>
				<td align="center"><input type="text" name="userid" value=<%=userid%> placeholder="Username"></td>
			</tr>
			<tr>
				<td align="center"><input type="text" name="mmname" placeholder="Mother's Maiden Name"></td>
			</tr>
			<tr>
				<td align="center"><input type="button" Value="Submit" onclick="return validation();"/></td>
			</tr>
		</table>	
	</form>
</div>	
</fieldset>
<script>
		function validation() {
			var userid = document.sec.uid.value;
			var mothersname = document.sec.mmname.value;

			if (userid=="") {
		    		alert("Please enter the User name.")
		    		document.Info.userid.focus();
		    		return false;
		     	}

			if (mothersname=="") {
		    		alert("Please enter the Mother's name.")
		    		document.sec.mmname.focus();
		    		return false;
		     	}
		     	    
		    document.sec.action=("ShowPass");
			document.sec.submit();
			return true;
		}
</script>		
</body>
</html>