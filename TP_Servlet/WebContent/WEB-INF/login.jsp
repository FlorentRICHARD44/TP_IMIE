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
        <h1>Authentification</h1>
        <section>
            <form method="post" action="login">
                <fieldset>
                    <table>
                        <tr><td><label for="login">Login (Prénom NOM)</label></td>
                            <td><input id="login" type="text" required placeholder="Entrer votre login" name="login"/></td></tr>
                        <tr><td><label for="pwd">Mot de Passe</label></td>
                            <td><input id="pwd" type="password" required placeholder="Mot de passe" name="pwd"/></td></tr>
                    </table>
                    <% String show = "";
                       if (request.getParameter("error") == null) {
                           show = " hidden";
                       } %>
                    <p class="error" <%= show %>>Erreur de login et/ou de mot de passe</p>
                    <div class="buttonline">
                        <input class="button" type="submit" value="Connexion"/>
                    </div>
                </fieldset>
            </form>
       </section>
    </body>
</html>
