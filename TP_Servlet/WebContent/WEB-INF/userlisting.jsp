<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/tpservlet.css"/>
        <title>Liste des Utilisateurs</title>
    </head>
    <body>
	    <c:set var="title" scope="request" value="Liste des Usagers" />   
        <jsp:include page="menu.jsp" />
        <div class="main">
        	<div class="path">  <!-- Chemin de la page actuelle dans le site -->
                <a href="home">Accueil</a> > <a href="userlist"> Liste Usagers</a>
            </div>
            <aside id="menulocal">  <!-- Menu local -->
                <h2>Base Usagers</h2>
                <ul>
                    <li><a href="userlist">Liste des Usagers</a></li>
                    <li><form method="post" action="userview"><input class="localmenu" type="submit" name="new" value="Ajouter un Usager"/></form></li>
                </ul>
            </aside>
            
	        <section>
	            <table class="listing">
	                <tr><th>Nom</th><th>Prénom</th><th></th></tr>
	                <c:forEach var="user" items="${userlist}" varStatus="loop">
	                    <tr><td><c:out value="${user.name}"/></td><td><c:out value="${user.firstName}"/></td>
	                        <td><form method="post" action="userview">
	                        		<input type="hidden" name="numligne" value="${loop.count}"/>
	                        		<input type="submit" class="btn view" name="view" /><input type="submit" class="btn del" name="delete"/>
	                        	</form>
	                        </td></tr>
	                </c:forEach>
	            </table>
	        </section>
	    </div>
	   <jsp:include page="footer.jspf" />
    </body>
</html>
