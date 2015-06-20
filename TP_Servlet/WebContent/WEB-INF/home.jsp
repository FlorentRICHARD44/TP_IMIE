<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="CSS/tpservlet.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Accueil</title>
	</head>
	<body>
	   <% request.setAttribute("title", "Accueil"); %>
		<jsp:include page="menu.jsp" />
		<div class="main">
		  	<section>
		  		<h2>Bienvenue dans le premier site JavaEE fait par Florent RICHARD</h2>
		  	</section>
	  	</div>
	</body>
</html>