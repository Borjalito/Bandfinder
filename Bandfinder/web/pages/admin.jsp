<%@ page session="true"%>
<%@ page import="beans.*" %>

<html>
<head>
    <title>TITOLO</title>
	<link type="text/css" href="../styles/default.css" rel="stylesheet"></link>
	<jsp:useBean id="database" class="beans.Database" scope="application"/>
</head>
<body>
   
   <h1>ADMIN</h1>
<% 
    String url = request.getRequestURL().toString(); 
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/"; 
%>
  	
<div>
  	<h5>Admin Form</h5>
  	<form action="../admin" method="get">
  		<input type="text" size="20" name="userName" hint="insert the username"><br>
  		<input type="password" size="20" name="password" hint="insert the your pwd"><br>
  		<input type="submit" value="Entra">
  	</form>
</div>

<br><a href="<%=baseURL %>index.jsp">Torna all'inizio</a>

</body>
</html>




