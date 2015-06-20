<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="fr.imie.formation.jdbc.data.Usager" %>
<%! SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy"); %> <%-- Déclaration d'un objet de portée application --%>
<header>
	<% Usager user = (Usager) session.getAttribute("userconnected"); %>
	<section id="info_connection">
		<div class="line">
			<p class="data"><%= simpleDateFormat.format(new Date()) %></p>
		</div>
		<div class="line">
			<p class="data"><%= user.getFirstName() %> <%= user.getName() %></p>
		</div>
		<div class="line">
			<p class="data"><%= application.getAttribute("nbvisitors") %> visiteur(s), dont <%= application.getAttribute("nbloggedusers") %> connecté(s)</p>
		</div>
		<div class="line">
			<form method="post" action="logout" >
				<input type="submit" value="Déconnexion" name="logout" />
			</form>
		</div>
	</section>
</header>
<nav>
	<div class="splitter"></div>
	<div class="menuitem">
		<a href="home">Accueil</a>
	</div>
	<div class="splitter"></div>
	<div class="menuitem">
		<a href="HelloWorld.jsp">Helloworld</a>
	</div>
	<div class="splitter"></div>
	<div class="menuitem">
		<a href="UserListGetterServlet">Liste des Usagers</a>
	</div>
	<div class="splitter"></div>
</nav>
