<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${requestheaderbean.lang }"/>
<fmt:setBundle basename="fr.imie.ihm.languages" var="propertie"/>
    
<c:set var="title" scope="page"><fmt:message key="menu.siteslist" bundle="${propertie}"/></c:set>
<t:maintemplate pagetitle="${title }" tabtitle="${title }">
	<script src="JAVASCRIPT/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
	<script src="JAVASCRIPT/jquery-ui-1.11.4/jquery-ui.js"></script>
	<script src="JAVASCRIPT/sites.js"></script>
	<div class="path">  <!-- Chemin de la page actuelle dans le site -->
    	<a href="home">Accueil</a> > <a href="sites">Gestion des sites</a>
    </div>
    <aside id="menulocal">  <!-- Menu local -->
        <h2>Gestion des Sites</h2>
        <ul>
            <li><a href="sites">Gestion des sites</a></li>
        </ul>
    </aside>
    <section>
        <ol id="listelocale" class="selectable">
        </ol>
        <div class="actionzone">
			<h1>Gestion des Sites</h1>
			<button id="new" class="button action">Ajouter un Site</button>
			<div class="sitemodel" hidden="true">
				<fieldset>
					<div class="table">
						<div class="table-row">
							<div class="table-cell"><label>Nom</label></div>
							<div class="table-cell"><input id="sitename" type="text" required placeholder="Entrer le nom du site" value=""/></div>
						</div>
					</div>
				</fieldset>
				<p class="error" hidden="true"></p>
				<button id="del" class="button action">Supprimer</button>
				<button id="save" class="button action">Enregistrer</button>
			</div>
		</div>
	</section>
</t:maintemplate>
