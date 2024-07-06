<%@ page session="true"%>
<%@ page import="beans.*" %>

<html>
<head>
    <title>REGISTRAZIONE COMPLETATA</title>
	<link type="text/css" href="../styles/default.css" rel="stylesheet"></link>
	<jsp:useBean id="database" class="beans.Database" scope="application"/>
</head>
<body>
   
<% 
    String url = request.getRequestURL().toString(); 
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/"; 
%>
  	

  	<h1>La registrazione è andata a buon fine</h1>

	<br><a href="<%=baseURL %>index.jsp">Torna all'inizio</a>
<!--  
	<br><a href="<%=baseURL %>pages/login.jsp">Vai al login</a>   
-->

</body>
</html>




