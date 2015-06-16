package fr.imie.formation.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.formation.jdbc.data.Utilisateur;

/**
 * Servlet implementation class UserListDisplayServlet
 */
@WebServlet("/UserListDisplayServlet")
public class UserListDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Writer out = response.getWriter();
        //response.setContentType("text/html; charset=utf-8");
        out.write("<!DOCTYPE html>");
        out.write("<html lang=\"fr\">");
        out.write("<header>");
        out.write("<style type=\"text/css\">table td, table th{border: solid 1px black;}</style>");
        out.write("<title>User List</title>");
        out.write("</header>");
        out.write("<body>");
        out.write("<h1>Liste des Utilisateurs</h1>");
        out.write("<table>");
        out.write("<tr><th>Nom</th><th>Prénom</th></tr>");
        for (Utilisateur u: (List<Utilisateur>) request.getAttribute("userlist")) {
            out.write(String.format("<tr><td>%s</td><td>%s</td></tr>", u.getName(), u.getFirstName()));
        }
        out.write("</table>");
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
