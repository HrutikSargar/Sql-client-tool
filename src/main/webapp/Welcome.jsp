<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
 	background:#FF82C9;
}
.main-div{
	 height:100vh;
	 width:100%;
	 display: flex;
	 align-items: center;
	 justify-content: center;
	 text-align: center;	
	 background:#F9DBEC;
}
.div-2{
	
	 height:100vh;
	 width:60%;
	 
	 display:flex;
	 align-items: center;
	 justify-content: center;	
}	
/* These are the KEY styles - you can add them directly to any object you want in your project */
.fancy-border-radius {
  border-radius: 36% 64% 30% 70% / 72% 70% 30% 28%;

  /* These are ADDITIONAL styles - add them if you want an object exactly like in the demo above */
  width: 400px;
  height: 400px;
  background: #ad5389;
  background: -webkit-linear-gradient(to right,
      #3c1053,
      #ad5389);
  background: linear-gradient(to right,
      #3c1053,
      #ad5389);
}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="main-div">
			<div class="fancy-border-radius">
			</div>	
			<div class="div-2">
				<div>
					<h1>SQL SIMULATOR</h1>
					<h1>Welcome To HomePage</h1>
					<span>Created By: Hrutik Sargar</span>
					<br><br>
					<form action="WelcomePage" method="post">
						<a href="Welcome2.html"><button type="button" class="btn btn-primary">Click Here To Continue</button></a>
					</form>
				</div>
			</div>	
	</div>
</body>
</html>