<%@ page session="true"%>
<%@ page import="beans.*" %>

<html>
<head>
	<!--   <meta http-equiv="Refresh" content= "2; URL=paginaPrincipale"/> -->
    <title>REGISTRATION</title>
	<link type="text/css" href="../styles/default.css" rel="stylesheet"></link>
	<jsp:useBean id="database" class="beans.Database" scope="application"/>
</head>
<body>
   
   <h1>WELCOME PAGE: REGISTRATION</h1>
<% 
    String url = request.getRequestURL().toString(); 
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/"; 
%>
  	
<div>
  	<p><h5>Registration Form</h5></p>
  	<form action="../registration" method="get">
  		<input type="text" size="20" name="userName" hint="insert the username"><br>
  		<input type="password" size="20" name="password" hint="insert the your pwd"><br>
  		<!--   input type="text" size="7" name="gruppo" hint="insert the group"><br> -->
  		<input type="submit" value="Register">
  	</form>
</div>


</body>
</html>




