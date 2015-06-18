package fr.imie.formation.servlet;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.formation.jdbc.data.Usager;

/**
 * Servlet implementation class MenuViewServlet
 */
@WebServlet("/MenuViewServlet")
public class MenuViewServlet extends HttpServlet {
       
    /**
     * 
     */
    private static final long serialVersionUID = -3646621314880086294L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Usager user = (Usager) request.getSession().getAttribute("userconnected");
	    Writer out = response.getWriter();
        response.setContentType("text/html; charset=utf-8");
        out.write("<header>");
        out.write("<section id=\"info_connection\">");
        out.write(String.format("<div class=\"line\"><p class=\"data\">%s</p></div>", new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
        out.write(String.format("<div class=\"line\"><p class=\"data\">%s %s</p></div>", user.getFirstName(), user.getName()));
        out.write("<div class=\"line\"><form method=\"post\" action=\"Logout\"><input type=\"submit\" value=\"Déconnexion\" name=\"logout\"/></form></div>");
        out.write("</section></header>");
        out.write("<nav>\n");
        out.write("<div class=\"splitter\"></div>");
        out.write("<div class=\"menuitem\"><a href=\"/TP_Servlet/HelloWorldServlet\">Helloworld</a></div>");
        out.write("<div class=\"splitter\"></div>");
        out.write("<div class=\"menuitem\"><a href=\"/TP_Servlet/UserListGetterServlet\">Liste des Usagers</a></div>");
        out.write("<div class=\"splitter\"></div>");
        out.write("</nav>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
