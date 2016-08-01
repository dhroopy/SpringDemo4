<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin - Pending Action</title>
</head>
<body onload="addTable();">
<% String name = (String) session.getAttribute("Name");%>
<%-- List<List<String>> Entry = request.getAttribute("entry");--%>
<fieldset>
<div align="center">
<h1> Pending Approvals </h1>
	<h2>Welcome <%=name%></h2>
	<form name="Info" method="post">
		<script>addTable();</script>
		<div id="myDynamicTable"></div>
	</form>
</div>
</fieldset>
<script>
	function addTable() {
		
	    var myTableDiv = document.getElementById("myDynamicTable");
	     
	    var table = document.createElement('TABLE');
	    table.border='1';
	    	   
	    var tableBody = document.createElement('TBODY');
	    table.appendChild(tableBody);

	    var tr = document.createElement('TR');
	    tableBody.appendChild(tr);

        var td = document.createElement('TD');
        td.width="16.66%";
       	td.appendChild(document.createTextNode("Account Holder"));
        tr.appendChild(td);
        var td = document.createElement('TD');
        td.width="16.66%";
       	td.appendChild(document.createTextNode("User ID"));
        tr.appendChild(td);
        var td = document.createElement('TD');
        td.width="16.66%";
       	td.appendChild(document.createTextNode("Account #"));
        tr.appendChild(td);
        var td = document.createElement('TD');
        td.width="16.66%";
       	td.appendChild(document.createTextNode("Account Type"));
        tr.appendChild(td);
        var td = document.createElement('TD');
        td.width="16.66%";
       	td.appendChild(document.createTextNode("Pending Approval"));
        tr.appendChild(td);

	    var k = 0;
	    var row = ${rc};
	    var m1 = "${message}";
	    var m2 = m1.length;
	    var m3 = m1.substr(1,m2-2);  //To remove "["  & "]" from the string received.
	 	var val = m3.split(",");
	    //alert (val[0]);
	    
	    for (var i=0; i<row; i++){
	       var tr = document.createElement('TR');
	       tableBody.appendChild(tr);
	      
	       for (var j=0; j<5; j++){
	           var td = document.createElement('TD');
	           td.width="16.66%";
	           //td.appendChild(document.createTextNode("Cell " + i + "," + j));
	           td.appendChild(document.createTextNode(val[k]));
	           tr.appendChild(td);
	           k++;
	       }
	    }
	    myTableDiv.appendChild(table);
	}
</script>
</body>
</html>