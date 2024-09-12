<%@page import="Model.DescribeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Desc Table</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Dancing+Script&family=Raleway:wght@200&family=Roboto+Mono:ital,wght@0,100..700;1,100..700&family=Roboto:wght@100;300&display=swap"
            rel="stylesheet">
<style type="text/css">
             table{
                border-style:dashed;
                width: 400px;
                border-color: aliceblue;
                border-width: 1px;
                border-collapse: collapse;
                text-align: center;
                font-size: small;

                
            }
            body{
                margin-top: 100px;
                background-color: black;
                color: white;
                font-family: "Roboto", sans-serif;
                font-weight: 100;
                font-style: normal;
            }
            #tr1{
                border-bottom: 1px dashed white;
            }
            td ,th{
                border-left: 1px dashed white;
                font-family: "Roboto", sans-serif;
                font-weight: 100;
                /* font-style: normal; */
                padding-left:17px;
                padding-right:17px;
                padding-top: 3px;
                padding-bottom: 3px;

                /* line-height: 80%; */
                 
            }
            span ,#a1{
            	 font-family: "Roboto", sans-serif;
                font-weight: 100;
                 font-size: small;
            }
            #a1{
            	 text-decoration: none;
            	font-weight:700;
            }
            
</style>
</head>
<body>
<% Object data1=request.getAttribute("data");%>
<%   ArrayList<DescribeDTO> data2=(ArrayList<DescribeDTO>)data1;%>
<% int count=0; %>
<span> mysql> desc table;</span><br><br>
<table cellspacing="7">
	
			<tr id="tr1">
				<th>Field</th>
				<th>Type</th>
				<th>Null</th>
				<th>Key</th>
				<th>Default</th>
				<th>Extra</th>
			</tr>
			
		<% for(DescribeDTO d: data2){ %>
			<tr>
			<%count++; %>
				<td> <%=d.getFeild() %> </td>
				<td><%=d.getType() %></td>
				<td><%=d.getNull() %></td>
				<td><%=d.getKey() %></td>
				<td><%=d.getDefauString() %></td>
				<td><%=d.getExtraString()%></td>
			</tr>
	<%} %>
	

</table>
<br>
<span> <%=count%>&nbsp;&nbsp;&nbsp;rows&nbsp;&nbsp;in&nbsp;&nbsp;set;</span>
<br><br><br><br>
<a id="a1" href="second.jsp">Click here to go back</a>
</body>
</html>