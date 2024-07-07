<%@ page session="true"%>
<%@ page import="beans.*" %>

<html>
<head>
<% 
    String url = request.getRequestURL().toString(); 
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/"; 
%>
	<!--   <meta http-equiv="Refresh" content= "2; URL=paginaPrincipale"/> -->
    <title>LOGIN</title>
	<link type="text/css" href="../styles/default.css" rel="stylesheet"></link>
	<jsp:useBean id="database" class="beans.Database" scope="application"/>
</head>
<body>
   
   <h1>HOME UTENTE</h1>
<% 
User u = (User)session.getAttribute("user");
if(u==null || !u.getLogged()){
	
%>

<h2>Non puoi visualizzare questa pagina, non sei autenticato </h2>
<br><a href="<%=baseURL %>pages/login.jsp">Torna al login</a>
<%  	
} else {
%>

<br><a href="<%=baseURL %>pages/homeCreatore.jsp">Home Creatore</a>
<br><a href="<%=baseURL %>pages/homeCandidato.jsp">Home Candidato</a>
<br><a href="<%=baseURL %>pages/mioProfilo.jsp">Mio profilo (lavori in corso...)</a>
<br><a href="<%=baseURL %>pages/ricercaProfili.jsp">Ricerca profili</a>
<br><a href="<%=baseURL %>pages/creaProgetto.jsp">Crea progetto</a>
<br><a href="<%=baseURL %>pages/ricercaProgetti.jsp">Ricerca progetti (lavori in corso...)</a>
<br><a href="<%=baseURL %>pages/esploraFeed.jsp">Apri il feed</a>


<h2>QUA UN TASTO ESCI?</h2>
<%}%>
</body>
</html>




