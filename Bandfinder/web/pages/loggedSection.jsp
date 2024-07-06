<%@ page session="true"%>
<%@ page import="beans.*" %>

<html>
<head>
<% 
    String url = request.getRequestURL().toString(); 
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/"; 
%>
    <title>TITOLO</title>
    <script type="text/javascript" src="<%=request.getContextPath() %>/scripts/utils.js"></script>
	<link type="text/css" href="<%=request.getContextPath() %>/styles/default.css" rel="stylesheet"></link>
	<jsp:useBean id="database" class="beans.Database" scope="application"/>
</head>
<body>
<%
User u = (User)session.getAttribute("user");
boolean logged=false;
if(u!=null ){
	logged=u.getLogged();	
}
if(!logged){
%>
<h1>Non sei autenticato, non puoi visualizzare questa pagina</h1>
<%
} else {
   
%>

   <h1>LOGGED</h1>
  	
  	<h1>Pagina acceduta in seguito ad autenticazione</h1>

    
<%} %>
<br><a href="<%=baseURL %>logout">Log out</a>
<br><a href="<%=baseURL %>index.jsp">Torna all'inizio</a>

</body>
</html>




