<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/tpservlet.css"/>
        <title>Usager</title>
    </head>
    <body>
        <fmt:setLocale value="${lang }"/>
        <fmt:setBundle basename="fr.imie.formation.servlet.userview" var="propertie"/>
        <c:choose>
            <c:when test="${empty user }"><c:set var="title" scope="request" value="Nouvel Usager"/></c:when>
            <c:otherwise><c:set var="title" scope="request" value="Usager ${user.firstName } ${user.name }" /></c:otherwise>
        </c:choose>
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
			                        <tr><td><label for="name"><fmt:message key="usager.lastname" bundle="${propertie}"/></label></td>
			                            <td><input id="name" name="name" type="text" required value="${user.name}" placeholder="NOM"/></td></tr>
			                        <tr><td><label for="firstname"><fmt:message key="usager.firstname" bundle="${propertie}"/></label></td>
			                            <td><input id="firstname" name="firstname" type="text" required value="${user.firstName}" placeholder="Prénom"/></td></tr>
			                        <tr><td><label for="birth">Date de Naissance</label></td>
			                            <td><input id="birth" name="birthdate" type="text" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${user.dateBirth}" />" placeholder="JJ/MM/AAAA" /></td></tr>
						            <tr><td><label for="site">Site d'inscription</label></td>
				                        <td><select id="site" name="inscrsite">
									            <c:set var="selected" scope="page" value=""/>
                                                <c:if test="${empty user.inscrSite}">
                                                    <c:set var="selected" scope="page" value=" selected"/>
                                                </c:if>
						                        <option disabled <c:out value="${selected}"/>>Aucun</option>
						                        <c:forEach var="site" items="${sitelist}" varStatus="loop">
						                              <c:set var="selected" scope="page" value=""/>
						                              <c:if test="${site.name eq user.inscrSite.name }">
						                                  <c:set var="selected" scope="page" value=" selected"/>
						                              </c:if>
						                              <option <c:out value="${selected}"/> value="${loop.count}"><c:out value="${site.name}"></c:out></option>
						                        </c:forEach>
				                            </select></td></tr>
			                        <tr><td><label for="email">Email</label></td>
			                            <td><input id="email" name="email" type="email" value="${user.email}" placeholder="xxxxxx@yyyyy.zzz"/></td></tr>
			                        <tr><td><label for="nbcon">Nombre de connexions</label></td>
			                            <td><input id="nbcon" name="nbcon" type="number" disabled value="${user.nbConnection }"/></td></tr>
			                    	<tr><td colspan="2"><p class="error"><%= " " %></p></td></tr>
				                	<tr><td colspan="2"><input class="button action" id="init" type="reset" value="Réinitialiser"/><input class="button action" id="saveuser" type="submit" name="save" value="Enregistrer"/></td></tr>
			                    </table>
			                </fieldset>
			            </form>
			            <form method="post" action="userview">
			                 <c:if test="${user.id == userconnected.id}">
			                     <fieldset>
			                         <c:set var="errormsg" scope="page" value=""/>
			                         <c:choose>
			                             <c:when test="${error eq 'old' }"><c:set var="errormsg" scope="page" value="Ancien mot de passe incorrect"/></c:when>
			                             <c:when test="${error eq 'confnew' }"><c:set var="errormsg" scope="page" value="Le nouveau mot de passe et le confirmé sont différents"/></c:when>
                                         <c:when test="${error eq 'newshort' }"><c:set var="errormsg" scope="page" value="Le nouveau mot de passe est trop court"/></c:when>
                                     </c:choose>
					                <table>
				                		<caption>Modification du mot de passe</caption>
				                		<tr><td><label for="oldpwd">Ancien mot de passe</label></td>
				                			<td><input type="password" id="oldpwd" name="oldpwd" class="input" placeholder="Ancien mot de passe" required/></td></tr>
				                		<tr><td><label for="newpwd">Nouveau mot de passe</label></td>
				                			<td><input type="password" id="newpwd" name="newpwd" class="input" placeholder="Nouveau mot de passe" required/></td></tr>
				                		<tr><td><label for="confirmnewpwd">Confirmer le nouveau mot de passe</label></td>
				                			<td><input type="password" id="confirmnewpwd" name="confnewpwd" class="input" placeholder="Confirmer le nouveau mot de passe" required/></td></tr>
					                	<tr><td colspan="2"><p class="error"><c:out value="${errormsg }"></c:out> </p></td></tr>
				                		<tr><td colspan="2"><input class="button action" id="init" type="reset" value="Réinitialiser"/><input type="submit" class="action" name="modifpwd" value="Enregistrer" /></td></tr>
				               		</table>
				                </fieldset>
			                </c:if>
			            </form>
			            <form  class="bottom" method="post" action="userview">
			                 <c:if test="${!empty user.id }"><!-- Can't delete on usager creation -->
			            	    <input class="button action" id="delete" type="submit" name="delete" value="Supprimer l'usager"/>
	                        </c:if>
			            </form>
			        </div>
			    </div>
	        </section>
	    </div>
	   <jsp:include page="footer.jspf" />
    </body>
</html>
