<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Liste des Usagers</title>
	</head>
	<body>
		<form method="post" action="userlist">
			<table>
					<tr><th>Nom</th><th>Prénom</th><th></th></tr>
		            <tr><td><input type="text" name="name" value="${name }"/></td><td><input type="text" name="firstname" value="${firstname }"/></td><td><input type="submit" value="Filtrer" name="filter"/></tr>
		            <c:forEach var="user" items="${usagerlist}" varStatus="loop">
		                <tr><td><c:out value="${user.nom}"/></td><td><c:out value="${user.prenom}"/></td>
		                    <td><a href="userview?id=${user.id}">Voir en détails</a>
		                    </td></tr>
		            </c:forEach>
				
			</table>
		</form>
	</body>
</html>
