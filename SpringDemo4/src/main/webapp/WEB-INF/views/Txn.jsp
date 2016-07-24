<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<div align="center">
			<form name="Info" method="post">
				<table border=1 style="background-color: H0080FF80;">
					<tr>
						<td colspan=5 align="center" style="font-weight: bold; font-size: 20pt;" align="center"> <b> Transaction Summary</b> </td>
					</tr>
					<tr>
						<td align="center" width="20%">Account #</td>
						<td align="center" width="20%">Type</td>
						<td align="center" width="20%">Amount</td>
						<td align="center" width="20%">Balance</td>
						<td align="center" width="20%">Date & Time</td>
					</tr>
				    <tr>
						<td align="center" colspan=5><div id="demo">${message}</div></td>
					</tr>				
				    <tr>
						<td align="center" colspan=5><div id="demo">${message1}</div></td>
					</tr>				
				</table>
<!-- 				<table id="myTableData"  border="1">
				    <tr>
				        <td><b>Account #</b></td>
				        <td><b>Type</b></td>
				        <td><b>Amount</b></td>
				        <td><b>Balance</b></td>
				        <td><b>Date & Time</b></td>
				    </tr>
	
				</table>
 -->			</form>
			
		</div>
</fieldset>

<Script>
function addTable() {
     
    var myTableDiv = document.getElementById("myDynamicTable");
     
    var table = document.createElement('TABLE');
    table.border='1';
   
    var tableBody = document.createElement('TBODY');
    table.appendChild(tableBody);
     
    for (var i=0; i<3; i++){
       var tr = document.createElement('TR');
       tableBody.appendChild(tr);
      
       for (var j=0; j<5; j++){
           var td = document.createElement('TD');
           //td.width='75';
           td.appendChild(document.createTextNode("our data here"));
           tr.appendChild(td);
       }
    }
    myTableDiv.appendChild(table);
   
}
</Script>
</body>
</html>