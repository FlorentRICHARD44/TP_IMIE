<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/tpservlet.css"/>
		<title>Formulaire Usager</title>
	</head>
	<body>
		<form method="post" action="userview">
			<fieldset>
				<input type="text" hidden="true" name="id" value="${usager.id }"/>
				<div><label>Nom: </label><input type="text" name="name" value="${usager.nom }"/></div>
				<div><label>Prénom: </label><input type="text" name="firstname" value="${usager.prenom }"/></div>
				<div><label>E-mail: </label><input type="text" name="email" value="${usager.email }"/></div>
				<div><label>Nombre de connexions: </label><input type="number" disabled value="${usager.nbConnexion }"/></div>
				<div><label>Date de naissance: </label><input type="text" name="dateofbirth" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${usager.datenaissance}" />"/></div>
				<div><input type="submit" value="Enregistrer" name="save"/>
					<c:if test="${! empty usager.id }">
						<input type="submit" value="Supprimer" name="del"/>
					</c:if>
				</div>
			</fieldset>
		</form>
	</body>
</html>
