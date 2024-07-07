<%@ page session="true"%>
<%@ page import="beans.*" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<html>
<head>
<% 
    String url = request.getRequestURL().toString(); 
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/"; 
%>
    <title>TITOLO</title>
	<link type="text/css" href="<%=request.getContextPath() %>/styles/default.css" rel="stylesheet"></link>
	<jsp:useBean id="database" class="beans.Database" scope="application"/>
</head>
<body>
   
   <h1>ADMIN</h1>

<%
if(! database.getUser("admin").getLogged() ) {
%>
<h1>Non sei autenticato, non puoi visualizzare questa pagina</h1>
<%
} else { 
%>

<h1>Pagina riservata all'analisi dei log</h1>
<%
}
%>

	<br><a href="<%=baseURL %>registrazione.jsp">Torna alla registrazione</a>

</body>
</html>




