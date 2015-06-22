<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="CSS/tpservlet.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Accueil</title>
	</head>
	<body>
	    <c:set var="title" scope="request" value="Accueil" /> 
		<jsp:include page="menu.jsp" />
		<div class="main">
			<div class="path">  <!-- Chemin de la page actuelle dans le site -->
                <a href="home">Accueil</a>
            </div>
		  	<section class="nolocalmenu">
		  		<h2>Bienvenue dans le premier site JavaEE fait par Florent RICHARD</h2>
		  	</section>
	  	</div>
	   <jsp:include page="footer.jspf" />
	</body>
</html>