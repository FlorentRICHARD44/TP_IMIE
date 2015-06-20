<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="fr.imie.formation.jdbc.data.Usager" %>
<%@ page import="fr.imie.formation.jdbc.data.Site" %>
<%@ page import="fr.imie.formation.jdbc.services.ServiceData" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/tpservlet.css"/>
        <title>Usager</title>
    </head>
    <body>
        <% List<Site> siteList = (List<Site>) session.getAttribute("sitelist"); %>
        <% Usager user = (Usager) session.getAttribute("user"); %>
        <% if (user.getId() == null) {%>
            <h1>Nouvel Utilisateur</h1>
        <% } else { %>
            <h1>Utilisateur <%= user.getFirstName() %> <%= user.getName() %></h1>
        <% } %>
        <jsp:include page="menu.jsp" />
        <section>
            <form method="post" action="userview">
                <fieldset>
                    <table>
                        <% String strName = ""; %>
                        <% if (user.getName() != null) {%>
                            <% strName = user.getName();}%>
                        <tr><td><label for="name">Nom</label></td>
                            <td><input id="name" name="name" type="text" required value="<%= strName %>" placeholder="NOM"/></td></tr>
                        <% String strFirstName = ""; %>
                        <% if (user.getFirstName() != null) {%>
                            <% strFirstName = user.getFirstName();}%>
                        <tr><td><label for="firstname">Prénom</label></td>
                            <td><input id="firstname" name="firstname" type="text" required value="<%= strFirstName %>" placeholder="Prénom"/></td></tr>
                        <% String strDate = ""; %>
                        <% if (user.getDateBirth() != null) { %>
                            <% strDate = new SimpleDateFormat("dd/MM/yyyy").format(user.getDateBirth()); } %> 
                        <tr><td><label for="birth">Date de Naissance</label></td>
                            <td><input id="birth" name="birthdate" type="text" value="<%= strDate %>" placeholder="JJ/MM/AAAA" /></td></tr>
			            <% String strSite = "Aucun"; %>
			            <% if (user.getInscrSite() != null) { %>
			                 <% strSite = user.getInscrSite().getName();} %>
                        <% String selected = ""; %>
                        <tr><td><label for="site">Site d'inscription</label></td>
	                        <td><select id="site" name="inscrsite">
						            <% if (strSite.equals("Aucun")) { %>
						                <% selected = " selected"; } %>
			                        <option disabled <%= selected %>>Aucun</option>
		                            <% Integer sitenb = 1; %>
		                            <% for (Site s: siteList) { %>
		                                <% selected = ""; %>
						                <% if (s.getName().equals(strSite)) { %>
						                    <%selected = " selected";} %>
		                                <option<%= selected %> value="<%= sitenb++ %>"><%= s.getName() %></option>
		                            <% } %>
	                            </select></td></tr>
			            <% String strEmail = ""; %>
			            <% if (user.getEmail() != null) { %>
			                <% strEmail = user.getEmail(); } %>
                        <tr><td><label for="email">Email</label></td>
                            <td><input id="email" name="email" type="email" value="<%= strEmail %>" placeholder="xxxxxx@yyyyy.zzz"/></td></tr>
                        <tr><td><label for="nbcon">Nombre de connexions</label></td>
                            <td><input id="nbcon" name="nbcon" type="number" disabled value="<%= user.getNbConnection() %>"/></td></tr>
                    </table>
                    <div class="buttonline">
                        <% if (user.getId() != null) { // Can't delete on usager creation %>
                            <input class="button" id="deleteuser" type="submit" name="delete" value="Supprimer"/>
                        <% } %>
                        <input class="button" id="init" type="reset" value="Réinitialiser"/>
                        <input class="button" id="saveuser" type="submit" name="save" value="Enregistrer"/></div>
                </fieldset>
            </form>
        </section>
    </body>
</html>
