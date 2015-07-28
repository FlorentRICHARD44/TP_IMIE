<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="JAVASCRIPT/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
		<script src="JAVASCRIPT/jquery-ui-1.11.4/jquery-ui.js"></script>
		<script src="JAVASCRIPT/home.js"></script>
        <link rel="stylesheet" href="CSS/tprest.css"/>
        <link rel="shortcut icon" href="IMG/favicon.ico" type="image/x-icon"/>
		<link rel="icon" href="IMG/favicon.ico" type="image/x-icon"/>	
		<title>Appli SIRH - WEB</title>
	</head>
<body>
	<h1> HOME PAGE - youpi!!!!!!!</h1>
	<div class="employee-selection table">
		<div class="table-row">
			<div class="table-cell"><label>ID</label></div>
			<div class="table-cell"><input id="user" type="text" placeholder="Identifiant"/></div>
			<div class="table-cell"><button class="button action" id="login">Valider</button></div>
		</div>
		<div class="table-row">
			<div class="table-cell"></div>
			<div class="table-cell">
				<p class="error"></p>
			</div>
		</div>
	</div>
	<div class="employee-data" hidden="true">
		<h3></h3>
		<div class="table>">
			<div class="table-row">
				<div class="table-cell"><label>Nom</label></div>
				<div class="table-cell"><input type="text" id="name"/></div>
			</div>
			<div class="table-row">
				<div class="table-cell"><label>Prénom</label></div>
				<div class="table-cell"><input type="text" id="firstname"/></div>
			</div>
			<div class="table-row">
				<div class="table-cell"><label>Matricule</label></div>
				<div class="table-cell"><input type="text" id="matricule"/></div>
			</div>
			<div class="table-row">
				<div class="table-cell"></div>
				<div class="table-cell">
					<button id="see-projects" class="button action">Voir les projets</button>
					<button id="close-projects" class="button action" hidden="true">Masquer les projets</button>
					<ul id="project-list"></ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
