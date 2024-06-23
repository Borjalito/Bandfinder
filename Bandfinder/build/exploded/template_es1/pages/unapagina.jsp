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
<% 
	String url = request.getRequestURL().toString(); 
	String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/"; 
%>
</head>

<body>

<h1>APPPPPP</h1>
<br><a href="<%=baseURL %>/index.jsp">Torna all'inizio</a>	

</body>
</html>