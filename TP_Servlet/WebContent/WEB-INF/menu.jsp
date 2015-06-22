<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<header>
	<jsp:useBean id="userconnected" scope="session" class="fr.imie.formation.jdbc.data.Usager" />
	<img alt="Logo Cyberbase" src="/TP_Servlet/IMG/Logo_Cyberbase.gif">
	<c:set var="now" value="<%=new java.util.Date()%>" />  
	<h1><c:out value="${title }"/></h1>
	<section id="info_connection">
		<div class="line"><p class="data"><fmt:formatDate pattern="dd/MM/yyyy" value="${now}" /></p></div>
		<div class="line"><p class="data"><c:out value="${userconnected.firstName}"/> <c:out value="${userconnected.name}"/></p></div>
		<div class="line"><p class="data"><c:out value="${nbvisitors}"/> visiteur(s), dont <c:out value="${nbloggedusers}"/> connecté(s)</p></div>
	</section>
</header>
<nav><div class="menu"><div class="menuitem"><a href="home">Accueil</a></div><div class="menuitem"><a href="helloworld">Helloworld</a></div><div class="menuitem"><a href="userlist">Liste des Usagers</a></div></div>
	<form method="post" action="logout" ><input type="submit" value="Déconnexion" name="logout" /></form>
</nav>
