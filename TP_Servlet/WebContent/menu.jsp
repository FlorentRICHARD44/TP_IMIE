<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="fr.imie.formation.jdbc.data.Usager" %>
<header>
    <section id="info_connection">
	    <div class="line"><p class="data"><%= new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %></p></div>
	    <% Usager user = (Usager) session.getAttribute("userconnected"); %>
	    <div class="line"><p class="data"><%= user.getFirstName() %> <%= user.getName() %></p></div>
	    <div class="line"><form method="post" action="Logout"><input type="submit" value="Déconnexion" name="logout"/></form></div>
    </section>
</header>
<nav>
    <div class="splitter"></div><div class="menuitem"><a href="HelloWorld.jsp">Helloworld</a></div><div class="splitter"></div><div class="menuitem"><a href="UserListGetterServlet">Liste des Usagers</a></div><div class="splitter"></div>
</nav>
