<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beans.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ordine</title>
</head>

<body>
<% 
	String url = request.getRequestURL().toString(); 
	String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/"; 
%>

<% 
//USER: admin | PASSWORD: password
if(request.getParameter("user")==null || !request.getParameter("user").equals("admin") || !request.getParameter("pass").equals("password")){
%>
	<h1>Inserisci le credenziali di accesso</h1>
	<form action="">
		<input type="text" name="user">
		<input type="password" name="pass">
		<input type="submit" value="Entra!"> 
	</form>
	<br><a href="<%=baseURL %>/index.jsp">Torna all'inizio</a>

<%
}//chiude if(credenziali errate)
else if(request.getParameter("user").equals("admin") && request.getParameter("pass").equals("password")) {
%>			
	<h1>Sei dentro alla pagina dell'admin</h1>
	<br><a href="<%=baseURL %>/index.jsp">Torna all'inizio</a>	

<% }//chiude else (credenziali giuste) %>


</body>
</html>