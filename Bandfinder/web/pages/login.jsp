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
   
   <h1>LOGIN</h1>
<% 
User u = (User)session.getAttribute("user");
if(u!=null){
	if(u.getLogged()){
%>
<jsp:forward page="/pages/homeUtente.jsp"/>
<%  	
    	}
}
%>

<div>
  	<h2>Inserisci le credenziali utente</h2>
  	<form action="<%=request.getContextPath()%>/login" method="post">
  		<input type="text" size="20" name="userName" hint="insert the username"><br>
  		<input type="password" size="20" name="password" hint="insert the your pwd"><br>
  		<!--  <input type="text" size="7" name="gruppo" hint="insert the group"><br> -->
  		<input type="submit" value="Login">
  	</form>
</div>

</body>
</html>




