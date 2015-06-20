<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="fr.imie.formation.jdbc.data.Usager" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/tpservlet.css"/>
        <title>Liste des Utilisateurs</title>
    </head>
    <body>
        <h1>Liste des Utilisateurs</h1>
        <jsp:include page="menu.jsp" />
        <section>
            <div class="buttonline"><form method="post" action="userview"><input class="button" type="submit" name="new" value="Ajouter un Usager"/></form></div>
            <table class="listing">
                <tr><th>Nom</th><th>Prénom</th><th></th></tr>
                <% Integer userNb = 1; %>
                <% for (Usager u: (List<Usager>) session.getAttribute("userlist")) { %>
                    <tr><td><%= u.getName() %></td><td><%= u.getFirstName() %></td>
                        <td><form method="post" action="userview">
                        		<input type="hidden" name="numligne" value="<%= userNb++ %>"/>
                        		<input type="submit" class="btn view" name="view" />
                            	<input type="submit" class="btn del" name="delete"/>
                        	</form>
                        </td></tr>
                <% } %>
            </table>
        </section>
    </body>
</html>
