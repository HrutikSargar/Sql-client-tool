<%@page import="Model.TableDTO"%>
<%@page import="Model.DatabaseDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

<style type="text/css">
		#a1{
			color:white;
			text-decoration:none;
		}
		#div1{
			position: sticky;
			display:flex;
			backdrop-filter: blur(200px);
	 		filter: blur();
			background: white;
			border-radius:5px;
			height:60px;
			width:100%;
		}
		#div2{
			 width:25%;
			 height:60px;
			/* flex: 1; */
			 
			 text-align:center;
			 background-color: #ffcc00;  
			 display:flex;
			 justify-content: center;
	  		
			 align-items:center; 
	 		 filter: blur();
	 		 box-shadow: 0 3rem 5rem rgba(0, 0, 0, 0.25);
		}
		#div3{
			width:80%;
			height:60px;
			
			text-align:center;
			
			border-radius:9px;
  		    background-color: #FFFF92; /* Example color */
  			 
 		 	filter: blur();
 		 	box-shadow: 0 3rem 5rem rgba(0, 0, 0, 0.25);
		}
		#div3 form{
			width:80%;
			height:60px;
			display:flex;
			align-items:center;
			justify-content:space-around;
		}
		button{
			width:150px;
		}
			
        /* MIDDLE PART CSS  */
       .main-1{
	       	width:100%;
	       	height:90vh;
	       	background-color: red;
	       	
       	 	display:flex;
			align-items:center;
			justify-content:space-between;
       }
       .mainDiv1{
       		width:20%;
       		height:90vh;
       		background-color: #FFFF92;	
       	}
       	.mainDiv1 h4{
       		text-align: center;
       	}
       .mainDiv2{
       		width:100%;
       		height:90vh;
       		
			
			display: flex;
			align-items: center;
			justify-content: center;
			font-family: "Montserrat", sans-serif;
			/* background-color: red;  */
       }
        
       
        .tableCreated1{
	       		width:50%;
	       		height:40vh;
	       		background-color: green;
	       		border-radius: 8px;
	       		
	       		 display: flex;
				align-items: center;
				justify-content: center;
			
				font-family: "Montserrat", sans-serif;
				 background-color: rgba(255, 255, 255, 0.35);
				  backdrop-filter: blur(200px);
				  filter: blur();
				  box-shadow: 0 3rem 5rem rgba(0, 0, 0, 0.25); 
       		
       }
        .tableCreated2{
       		 	width:50%;
				height:40vh;
				border-radius: 8px;
				
				
				border-radius: 4px solid black; 
				font-family: "Montserrat", sans-serif;
				
				 display: flex;
				align-items: center;
				justify-content: center; 
				
				
       }
       .tableCreated3{
       		 width:50%;
				height:40vh;
				
				border-radius: 8px;
				
				background-color: #CDC8DD;
				border-radius: 4px solid black; 
				
				 display: flex;
				align-items: center;
				 justify-content: space-evenly;  
			
       } 
       #btn1,#btn2,#btn3{
       	background-color: transparent;
       	color: black;
       }
       #btn1:hover ,#btn2:hover ,#btn3:hover {
		background-color: #FEE8E8;
		color: black;
		}
       .mainDiv3{
       		width:100%;
       		height:100vh;
       		background-color: white;
       		display: flex;
       		align-content: center;
       		justify-content: space-evenly;
       }
       .M-div3-1{
       		border: 2px solid black;
       		height: 100vh;
       		width:25%;
       		
       }
       .M-div3-1:hover{
       background-color:green;
       		cursor: pointer;
       }
       .mainDiv4{
       		width:100%;
       		height:100vh;
       		background-color: red;
       }
</style>
</head>
<body>
<div id="div1">
	<div id="div2">
		<marquee behavior="alternate" scrollamount="10"> Table Created Successfully</marquee>
		<!-- <span >Table Created Successfully </span> -->
	</div>
	<div id="div3">
		<form action="DescTable" method="post">
			
			<input class="btn btn-secondary" type="submit"  name="btnOne" value="showDatabases" >	
			<input class="btn btn-secondary" type="submit"  name="btnOne" value="DeleteTable" >	
			<a href="#mainDiv4"><input class="btn btn-secondary" type="button"   value="InsertData" ></a>
	</div>
</div>
		<div class="mainDiv2">
		<!-- TABLE CREATED SUCCESSFULLY PAGE WINDOW -->
			<main class="tableCreated1">
				 <div class="tableCreated2">
					<h5>TABLE CREATED SUCCESSFULLY</h5>
				</div>
				<div class="tableCreated3">
					<input id="btn1"class="btn btn-secondary" type="submit"  name="btnOne" value="InsertData" >	
					<input id="btn2" class="btn btn-secondary" type="submit"  name="btnOne" value="DescTable" >
					<input id="btn3" class="btn btn-secondary" type="submit"  name="btnOne" value="DeleteTable" >	
						<!-- <span>Click here to insert Data</span> -->
				</div> 
			</main>
		</div>
		 <div class="mainDiv3">
		 	<div class="M-div3-1" id="M-div3-1i">
		 	</div>
		 	<div class="M-div3-1" id="M-div3-2i">
		 	</div>
		 	<div class="M-div3-1" id="M-div3-3i">
		 	</div>
		 	<div class="M-div3-1" id="M-div3-4i">
		 	</div>
		 	<!-- <div class="M-div3-1" id="M-div3-5i">
		 	</div> -->
		 	
		</div>
		<!-- <div class="mainDiv4" id="mainDiv4">
		</div> -->
		</form>	
</main> 
</body>
</html>