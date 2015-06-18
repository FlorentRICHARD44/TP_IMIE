package fr.imie.formation.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.formation.jdbc.data.Usager;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/Login")
public class UserLoginServlet extends HttpServlet {
       
    /**
     * 
     */
    private static final long serialVersionUID = 1250465419296394104L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Writer out = response.getWriter();
        response.setContentType("text/html; charset=utf-8");
        out.write("<!DOCTYPE html>");
        out.write("<html lang=\"fr\">");
        out.write("<header>");
        out.write("<link rel=\"stylesheet\" href=\"CSS/tpservlet.css\"/>");
        out.write("<title>Login</title>");
        out.write("</header>");
        out.write("<body>");
        out.write("<h1>Authentification</h1>");
        out.write("<section><form method=\"post\" action=\"/TP_Servlet/UserLoginControllerServlet\"><fieldset><table>");
        out.write("<tr><td><label for=\"login\">Login (Prénom NOM)</label></td><td><input id=\"login\" type=\"text\" required placeholder=\"Entrer votre login\" name=\"login\"/></td></tr>");
        out.write("<tr><td><label for=\"pwd\">Mot de Passe</label></td><td><input id=\"pwd\" type=\"password\" required placeholder=\"Mot de passe\" name=\"pwd\"/></td></tr>");
        String show = "";
        if (request.getParameter("error") == null) {
            show = " hidden";
        }
        out.write(String.format("<tr><td colspan=\"2\"><p class=\"error\"%s>Erreur de login et/ou de mot de passe</p></tr>", show));
        out.write("</table><div class=\"buttonline\">");
        out.write("<input class=\"button\" type=\"submit\" value=\"Connexion\"/></div>");
        out.write("</fieldset></form></section>");
        out.write("</body>");
        out.write("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	}

}
