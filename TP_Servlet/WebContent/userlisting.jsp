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
            <div class="buttonline"><a class="button" id="addnewuser" href="/TP_Servlet/UserControllerServlet?user=new">Ajouter un usager</a></div>
            <table class="listing">
                <tr><th>Nom</th><th>Prénom</th><th></th></tr>
                <% Integer userNb = 1; %>
                <% for (Usager u: (List<Usager>) request.getAttribute("userlist")) { %>
                    <tr><td><%= u.getName() %></td><td><%= u.getFirstName() %></td>
                        <td><a class="action" href="/TP_Servlet/UserControllerServlet?user=<%= userNb %>">
                            <img alt="Détails" src="IMG/loupe.png"/></a>
                            <a class="action" href="/TP_Servlet/UserModifyServlet?delete=index&index=<%= userNb++ %>">
                            <img alt="Supprimer" src="IMG/delete.png"/></a></td></tr>
                <% } %>
            </table>
        </section>
    </body>
</html>
