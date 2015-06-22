<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="fr.imie.formation.jdbc.data.Site" %>
<%@ page import="fr.imie.formation.jdbc.data.Usager" %>
<%@ page import="fr.imie.formation.jdbc.services.ServiceData" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/tpservlet.css"/>
        <title>Usager</title>
    </head>
    <body>
        <% List<Site> siteList = (List<Site>) session.getAttribute("sitelist");
            Usager user = (Usager) session.getAttribute("user");        
         	if (user.getId() == null) {
	   			request.setAttribute("title", "Nouvel Usager");
        	} else {
	   			request.setAttribute("title", String.format("Usager %s %s", user.getFirstName(), user.getName()));
        	} %>
        <jsp:include page="menu.jsp" />
        <div class="main">
	   		<div class="path">  <!-- Chemin de la page actuelle dans le site -->
                <a href="home">Accueil</a> > <a href="userlist">Liste Usagers</a> > <a href="userview">Vue Usager</a>
            </div>
            <aside id="menulocal">  <!-- Menu local -->
                <h2>Base Usagers</h2>
                <ul>
                    <li><a href="userlist">Liste des Usagers</a></li>
                    <li><form method="post" action="userview"><input class="localmenu" type="submit" name="new" value="Ajouter un Usager"/></form></li>
                </ul>
            </aside>
	        <section>
	        	<ul id="listelocale">
                    <li> </li>
                    <li> </li>
                </ul>
	        	<div class="actionzone">
                    <h1>Gestion usager</h1>
                    <form method="post" action="userview"><input id="new" class="action" type="submit" name="new" value="Ajouter un Usager"/></form>
                	
                	
                	<div class="displayzone">
			            <form method="post" action="userview">
			                <fieldset>
			                    <table>
			                    	<caption>Modification des informations usager</caption>
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
			                    	<tr><td colspan="2"><p class="error"><%= " " %></p></td></tr>
				                	<tr><td colspan="2"><input class="button action" id="init" type="reset" value="Réinitialiser"/><input class="button action" id="saveuser" type="submit" name="save" value="Enregistrer"/></td></tr>
			                    </table>
			                </fieldset>
			            </form>
			            <form method="post" action="userview">
			                <% if (user.getId() == ((Usager) session.getAttribute("userconnected")).getId()) {%>
				                <fieldset>
				                	<% String errorMsg = " ";
				                	   if (request.getAttribute("error") != null) {
				                           if (request.getAttribute("error").equals("old")) {
				                               errorMsg = "Ancien mot de passe incorrect";
				                           } else if (request.getAttribute("error").equals("confnew")) {
				                               errorMsg = "Le nouveau mot de passe et le confirmé sont différents";
				                           } else if (request.getAttribute("error").equals("newshort")) {
				                               errorMsg = "Le nouveau mot de passe est trop court";
				                           }
				                       } %>
					                <table>
				                		<caption>Modification du mot de passe</caption>
				                		<tr><td><label for="oldpwd">Ancien mot de passe</label></td>
				                			<td><input type="password" id="oldpwd" name="oldpwd" class="input" placeholder="Ancien mot de passe" required/></td></tr>
				                		<tr><td><label for="newpwd">Nouveau mot de passe</label></td>
				                			<td><input type="password" id="newpwd" name="newpwd" class="input" placeholder="Nouveau mot de passe" required/></td></tr>
				                		<tr><td><label for="confirmnewpwd">Confirmer le nouveau mot de passe</label></td>
				                			<td><input type="password" id="confirmnewpwd" name="confnewpwd" class="input" placeholder="Confirmer le nouveau mot de passe" required/></td></tr>
					                	<tr><td colspan="2"><p class="error"><%= errorMsg %></p></td></tr>
				                		<tr><td colspan="2"><input class="button action" id="init" type="reset" value="Réinitialiser"/><input type="submit" class="action" name="modifpwd" value="Enregistrer" /></td></tr>
				               		</table>
				                </fieldset>
			                <% } %>
			            </form>
			            <form  class="bottom" method="post" action="userview">
			            	<% if (user.getId() != null) { // Can't delete on usager creation %>
	                            <input class="button action" id="delete" type="submit" name="delete" value="Supprimer l'usager"/>
	                        <% } %>
			            </form>
			        </div>
			    </div>
	        </section>
	    </div>
	   <jsp:include page="footer.jspf" />
    </body>
</html>
