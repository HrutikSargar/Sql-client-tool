<%@page import="Model.DescribeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Data</title>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	  <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
  
  <style type="text/css">
   *{
	  margin: 0;
	  padding: 0;
	  
	  box-sizing: border-box;
	}
	body{
		/* background-color: #FEDDE3; */
		height:100vh;
		width:100%;
		
		
	}
	.insertDiv{
		height: 15vh;
		width:100%;
		
		/* background-color: #FEDDE3; */
		
		text-align: center;
		 display: flex;
		align-items: center;
		justify-content: center;
	}
   .container1{
	  	display: flex;
		 justify-content: center; 
		 
		width:100%;
		height:90vh;
		/* background-color: #FEE8E8; */
		
		
   }
   table{
   		border: 2px solid black;
   		 background-color: #DBD8EA; 
   		margin-top:70px; 
   		border-radius: 4px;	
   }
   thead{
   		background-color: #DDD8F8;	
   }
   
   th{
   		border-bottom: 1px solid black;
   		border-right: 1px solid black;
   		
   		padding-left:10px;
   		padding-right:10px;
   }	
   
  </style>
</head>
<body>
	<div class="insertDiv">
		 <h1>INSERT DATA PAGE</h1>
	</div>
	
<% Object o1= request.getAttribute("data");
ArrayList<DescribeDTO>d1=(ArrayList<DescribeDTO>)o1;
%>
<div class="container1">
<form method="post" action="pushData">
  <!-- <h2>Insert Data</h2> -->
  <table class="table table-striped">
    <thead>
      <tr>
     	 <% for(DescribeDTO a:d1){ %>
       		 <th> <%= a.getFeild()  %><br> Default:<%= a.getDefauString()%></th>
    	 <%} %> 
    	 
      </tr>
    </thead>
    <tbody>
	       		<%--  METHOD IS WORKING BUT IT IS HECTIK TO DO 
	    		
	    		<tr>
		    		<% for(int a=0;a<d1.size();a++){ %>
		    			<td><input type="text" placeholder="Enter text" name="value2" ></td>
		    		<%} %>
	    		</tr>
	    		<tr>
		    		<% for(int a=0;a<d1.size();a++){ %>
		    			<td><input type="text" placeholder="Enter text" name="value3" ></td>
		    		<%} %>
	    		</tr>
	    		<tr>
		    		<% for(int a=0;a<d1.size();a++){ %>
		    			<td><input type="text" placeholder="Enter text" name="value4" ></td>
		    		<%} %>
	    		</tr>
	    		<tr>
		    		<% for(int a=0;a<d1.size();a++){ %>
		    			<td><input type="text" placeholder="Enter text" name="value5" ></td>
		    		<%} %>
	    		</tr> 
	    			 --%>
	   			  <tr>
		    		<% for(int a=0;a<d1.size();a++){ %>
		    			<td><input type="text" placeholder="Enter text" name="value1" ></td>
		    		<%} %>
	    		</tr>
	    		
	    	
    </tbody>
  </table>
   <input type="submit" class="btn btn-outline-primary" name="insert" value="InsertDataTODb"></input>
  <!-- <input type="submit" class="btn btn-outline-primary" name="insert" value="InsertDataToList"></input> -->
</div>
</form>
 <!-- <script type="text/javascript" src="./insertData.js"></script>  -->
</body>
</html>



