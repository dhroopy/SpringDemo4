<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Registration</title>
</head>
<body>
<fieldset>
<div align="center">
			<form name="Info" method="post">
				<table border=0 style="background-color: H0080FF80;">
					<tr>
						<td colspan=2 align="center" style="font-weight: bold; font-size: 20pt;" align="center"> <b> Account Registry</b> </td>
					</tr>
					<tr>
						<td colspan=2></td>
					</tr>
					<tr>
						<td align="center"><input type="text" name="userid" placeholder="Username" autofocus="autofocus" style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><input type="text" name="dob" placeholder="Date of Birth - YYYY-MM-DD" autofocus="autofocus" style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><input type="text" name="fname" placeholder="First Name" autofocus="autofocus" style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><input type="text" name="lname" placeholder="Last Name" autofocus="autofocus" style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><input type="text" name="mmname" placeholder="Mother's Maiden Name" autofocus="autofocus" style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><input type="password" name="pass" placeholder="Password" autofocus="autofocus" style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><input type="password" name="pass2" placeholder="Reenter password" autofocus="autofocus" style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><input type="text" name="email" placeholder="Email" autofocus="autofocus" style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><input type="text" name="ssn" placeholder="SSN" autofocus="autofocus" style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><input type="text" name="add" placeholder="Address" autofocus="autofocus" style="width: 162px; "></td>
					</tr>
					<tr>
						<td align="center"><select name="sex" style="width: 162px; ">
  							<option value="M">Male</option>
							<option value="F">Female</option>
						</select></td>
					</tr>
					<tr>
						<td align="center"><select name="accttype" style="width: 162px; ">
  							<option value="C">Current</option>
							<option value="S">Savings</option>
						</select></td>
					</tr>
					<tr>
						<td align="center"><input type="button" value="Create Account" onclick="return validation();" style="width: 162px; "></td>
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
			var userid 	= document.Info.userid.value;
			var pass 	= document.Info.pass.value;
			var pass2 	= document.Info.pass2.value;
			var dob 	= document.Info.dob.value;
			var fname 	= document.Info.fname.value;
			var lname 	= document.Info.lname.value;
			var mmname	= document.Info.mmname.value;
			var email 	= document.Info.email.value;
			var ssn		= document.Info.ssn.value;
			var add		= document.Info.add.value;
			
			if (userid=="") {
		    		alert("Please enter the User name.")
		    		document.Info.userid.focus();
		    		return false;
		     	}

			if (dob=="") {
	    		alert("Please enter the Date of Birth.")
	    		document.Info.dob.focus();
	    		return false;
	     	}

			if (fname=="") {
	    		alert("Please enter the First name.")
	    		document.Info.fname.focus();
	    		return false;
	     	}


			if (lname=="") {
	    		alert("Please enter the Last name.")
	    		document.Info.lname.focus();
	    		return false;
	     	}

			if (mmname=="") {
	    		alert("Please enter the Mother's maiden name.")
	    		document.Info.mmname.focus();
	    		return false;
	     	}


			if (pass=="") {
		     	alert("Please enter the password.")
		     	document.Info.pass.focus();
		     	return false;
		     }

			if (pass2=="") {
	     		alert("Please re-enter the password.")
	     		document.Info.pass2.focus();
	     	    return false;
	     	}
		
			//Check for both pass match
		
			if (email=="") {
	     		alert("Please enter the email")
	     		document.Info.email.focus();
	     	    return false;
	     	}
		     	    
			//Check for valid email.

			if (ssn=="") {
	     		alert("Please enter the SSN")
	     		document.Info.ssn.focus();
	     	    return false;
	     	}
		     	    
			if (add=="") {
	     		alert("Please enter the Address")
	     		document.Info.add.focus();
	     	    return false;
	     	}

            document.Info.action=("RegComp");
			document.Info.submit();
			return true;
		}
	</script>
</body>
</html>