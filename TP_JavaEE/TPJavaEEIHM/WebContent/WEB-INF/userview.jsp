<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Formulaire Usager</title>
	</head>
	<body>
		<form method="post" action="userview">
			<fieldset>
				<div><label>Nom: </label><input type="text" value="${usager.nom }"/></div>
				<div><label>Prénom: </label><input type="text" value="${usager.prenom }"/></div>
				<div><label>E-mail: </label><input type="text" value="${usager.email }"/></div>
				<div><label>Nombre de connexions: </label><input type="number" value="${usager.nbConnexion }"/></div>
				<div><label>Date de naissance: </label><input type="text" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${usager.datenaissance}" />"/></div>
			</fieldset>
		</form>
	</body>
</html>
