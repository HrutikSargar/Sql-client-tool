<%@page import="Model.DatabaseDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
plz add functionality to see available DB.
<% 
/*DID DOWNCASTING BELOW*/
Object o1  =request.getAttribute("DBdata"); 
ArrayList<DatabaseDTO> list =(ArrayList<DatabaseDTO>) o1;
%>
	<ul>
		<% for(DatabaseDTO d: list){ %>
		
			<li><%=d.getDbName() %></li>
			
			<%} %>
	</ul>
	
	<button> <a href="index1.html">Create Table</a> </button>
	<button> <a href="CreateDatabase.html">Create DB</a> </button>
	
</body>
</html>