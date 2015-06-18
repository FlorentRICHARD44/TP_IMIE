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
 * Servlet implementation class UserListDisplayServlet
 */
@WebServlet("/UserListDisplayServlet")
public class UserListDisplayServlet extends HttpServlet {
       
    /**
     * 
     */
    private static final long serialVersionUID = 285827893122301426L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Writer out = response.getWriter();
        response.setContentType("text/html; charset=utf-8");
        out.write("<!DOCTYPE html>");
        out.write("<html lang=\"fr\">");
        out.write("<header>");
        out.write("<link rel=\"stylesheet\" href=\"CSS/tpservlet.css\"/>");
        out.write("<title>User List</title>");
        out.write("</header>");
        out.write("<body>");
        out.write("<h1>Liste des Utilisateurs</h1>");
        RequestDispatcher rd= request.getServletContext().getRequestDispatcher("/MenuViewServlet");
        rd.include(request, response);
        out.write("<section><table class=\"listing\">");
        out.write("<div class=\"buttonline\"><a class=\"button\" id=\"addnewuser\" href=\"/TP_Servlet/UserControllerServlet?user=new\">Ajouter un usager</a></div>");
        out.write("<tr><th>Nom</th><th>Prénom</th><th></th></tr>");
        Integer userNb = 1;
        for (Usager u: (List<Usager>) request.getAttribute("userlist")) {
            out.write(String.format("<tr><td>%s</td><td>%s</td><td><a class=\"action\" href=\"/TP_Servlet/UserControllerServlet?user=%d\"><img alt=\"Détails\" src=\"IMG/loupe.jpeg\"/></a><a class=\"action\" href=\"/TP_Servlet/UserDeleteServlet?user=%d\"><img alt=\"Supprimer\" src=\"IMG/delete.jpeg\"/></a></td></tr>", u.getName(), u.getFirstName(), userNb, userNb++));
        }
        out.write("</table></section>");
        out.write("</body>");
        out.write("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
