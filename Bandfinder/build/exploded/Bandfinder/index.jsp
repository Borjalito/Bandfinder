<%@ page session="true"%>

<html>
<head>
	<!--   <meta http-equiv="Refresh" content= "2; URL=paginaPrincipale"/> -->
    <title>INDEX</title>
	<link type="text/css" href="styles/default.css" rel="stylesheet"></link>
	
</head>
<body>
   
   <h1>BENVENUTO</h1>
<% 
    String url = request.getRequestURL().toString(); 
    String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/"; 
%>
  	
  	
<!-- added sections -->
  



</body>
</html>




