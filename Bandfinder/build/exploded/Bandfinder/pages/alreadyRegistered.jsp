<%@ page session="true"%>
<%@ page import="beans.*" %>

<html>
<head>
<% 
    String url = request.getRequestURL().toString(); 
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/"; 
%>
    <title>REGISTRAZIONE NON EFFETTUATA</title>
	<link type="text/css" href="../styles/default.css" rel="stylesheet"></link>
	<jsp:useBean id="database" class="beans.Database" scope="application"/>
</head>
<body>
   
  	<h1>Nome utente già registrato</h1>

	<br><a href="<%=baseURL %>pages/registration.jsp">prova di nuovo la registrazione</a>   
	<br><a href="<%=baseURL %>pages/login.jsp">sei tu? Vai al login </a> 

</body>
</html>




