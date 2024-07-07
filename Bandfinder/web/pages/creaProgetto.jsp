<%@ page session="true"%>
<%@ page import="beans.*" %>
<%@ page import="model.*" %>

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
   
   <h1>Crea un progetto</h1>
<% 
User u = (User)session.getAttribute("user");
if(u==null || !u.getLogged()){
	
%>

<h2>Non puoi visualizzare questa pagina, non sei autenticato </h2>
<br><a href="<%=baseURL %>pages/login.jsp">Torna al login</a>
<%  	
} else {
%>


<div>
  	<form action="<%=request.getContextPath()%>/creaProgetto" method="post" enctype="multipart/form-data">
  		<label for="titolo">Titolo</label>
  		<input type="text" size="20" name="titolo" id="titolo"><br><br>
  		
  		<label for="descrizione">Descrizione</label>
  		<input type="text" size="20" name="descrizione" id="descrizione"><br><br>
  		
  		<label for="bpm">BPM</label>
  		<input type="number" size="20" name="bpm" id="bpm" min="5" max="200"><br><br>
  		
  		<fieldset>
		 <legend>Licenza</legend>
		  <% for(Licenza lic : Licenza.values()){ %>	  
		  <div>
		    <input type="radio" id="<%= lic %>" name="<%= lic %>" value="<%= lic %>"/>
		    <label for="<%= lic %>"><%= lic %></label>
		  </div>
		  <% } %>
		</fieldset>		
		
  		<label for="immagine">Immagine</label>
		<input type="file" id="immagine" name="immagine" accept="image/png, image/jpeg" hint="png, jpeg"/><br><br>

  		<br><br><input type="submit" value="Crea">
  	</form>
</div>


<%}%>
</body>
</html>




