<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/tpservlet.css"/>
        <title>Authentification</title>
    </head>
    <body>
    	<header>
            <img alt="Logo Cyberbase" src="/TP_Servlet/IMG/Logo_Cyberbase.gif">
        </header>
        <nav>
            <h1>Authentification</h1>
        </nav>
        <div class="main">
            <form class="login" method="post" action="login">
                <fieldset>
                    <div class="formline"><label for="login">Login</label><input id="login" class="input" type="text" required placeholder="Entrer votre login" name="login"/></div>
                    <div class="formline"><label for="pwd">Mot de Passe</label><input id="pwd" class="input" type="password" required placeholder="Mot de passe" name="pwd"/></div>
                    <div class="formline centered"><input class="action" type="submit" value="Connexion"/></div>
                	<% String show = "";
                       if (request.getParameter("error") == null) {
                           show = " hidden";
                       } %>
                    <div class="formline"><p class="error" <%= show %>>Erreur de login et/ou de mot de passe</p></div>
                </fieldset>
            </form>
        </div>
	   <jsp:include page="footer.jspf" />
    </body>
</html>
