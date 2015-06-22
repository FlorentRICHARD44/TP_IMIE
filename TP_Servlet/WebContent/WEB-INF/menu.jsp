<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%! SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy"); %> <%-- Déclaration d'un objet de portée application --%>
<header>
	<jsp:useBean id="userconnected" scope="session" class="fr.imie.formation.jdbc.data.Usager" />
	<img alt="Logo Cyberbase" src="/TP_Servlet/IMG/Logo_Cyberbase.gif">
	<h1><%= (String) request.getAttribute("title") %></h1>
	<section id="info_connection">
		<div class="line"><p class="data"><%= simpleDateFormat.format(new Date()) %></p></div>
		<div class="line"><p class="data">${userconnected.firstName} ${userconnected.name}</p></div>
		<div class="line"><p class="data"><%= application.getAttribute("nbvisitors") %> visiteur(s), dont <%= application.getAttribute("nbloggedusers") %> connecté(s)</p></div>
	</section>
</header>
<nav><div class="menu"><div class="menuitem"><a href="home">Accueil</a></div><div class="menuitem"><a href="helloworld">Helloworld</a></div><div class="menuitem"><a href="userlist">Liste des Usagers</a></div></div>
	<form method="post" action="logout" ><input type="submit" value="Déconnexion" name="logout" /></form>
</nav>
