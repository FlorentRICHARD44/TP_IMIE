package fr.imie.formation.servlet;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.formation.jdbc.data.Site;
import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.jdbc.services.ServiceData;

/**
 * Servlet implementation class UserViewServlet
 */
@WebServlet("/UserViewServlet")
public class UserViewServlet extends HttpServlet {
       
    /**
     */
    private static final long serialVersionUID = -3127154382281252028L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try (ServiceData servData = new ServiceData();) {
    	    List<Site> siteList = servData.selectAllSites();
    	    
    	    HttpSession session = request.getSession();
            Usager user = (Usager) session.getAttribute("user");
            Writer out = response.getWriter();
            response.setContentType("text/html; charset=utf-8");
            out.write("<!DOCTYPE html>");
            out.write("<html lang=\"fr\">");
            out.write("<header>");
            out.write("<link rel=\"stylesheet\" href=\"CSS/tpservlet.css\"/>");
            out.write("<title>User View</title>");
            out.write("</header>");
            out.write("<body>");
            out.write(String.format("<h1>Utilisateur %s %s</h1>", user.getFirstName(), user.getName()));
            RequestDispatcher rd= request.getServletContext().getRequestDispatcher("/MenuViewServlet");
            rd.include(request, response);
            out.write("<form>");
            out.write("<fieldset>");
            out.write("<table>");
            String strDate = "--/--/----";
            if (user.getDateBirth() != null) {
                strDate = new SimpleDateFormat("yyyy-MM-dd").format(user.getDateBirth());
            }
            out.write(String.format("<tr><td><label for=\"name\">Nom</label></td><td><input id=\"name\" type=\"text\" required value=\"%s\" placeholder=\"NOM\"/></td></tr>", user.getName()));
            out.write(String.format("<tr><td><label for=\"firstname\">Prénom</label></td><td><input id=\"firstname\" type=\"text\" required value=\"%s\" placeholder=\"Prénom\"/></td></tr>", user.getFirstName()));
            out.write(String.format("<tr><td><label for=\"birth\">Date de Naissance</label></td><td><input id=\"birth\" type=\"date\" value=\"%s\" /></td></tr>", strDate));
            
            String strSite = "Aucun";
            if (user.getInscrSite() != null) {
                strSite = user.getInscrSite().getName();
            }
            String selected = "";
            out.write("<tr><td><label for=\"site\">Site d'inscription</label></td><td><select id=\"site\">");
            if (strSite.equals("Aucun")) {
                selected = " selected";
            }
            out.write(String.format("<option disabled%s>Aucun</option>", selected));
            for (Site s: siteList) {
                selected = "";
                if (s.getName().equals(strSite)) {
                    selected = " selected";
                }
                out.write(String.format("<option%s>%s</option>", selected, s.getName()));
            }
            out.write("</select></td></tr>");
            String strEmail = "";
            if (user.getEmail() != null) {
                strEmail = user.getEmail();
            }
            out.write(String.format("<tr><td><label for=\"email\">Email</label></td><td><input id=\"email\" type=\"email\" value=\"%s\" placeholder=\"xxxxxx@yyyyy.zzz\"/></td></tr>", strEmail));
            out.write(String.format("<tr><td><label for=\"nbcon\">Nombre de connexions</label></td><td><input id=\"nbcon\" type=\"number\" disabled value=\"%d\"/></td></tr>", user.getNbConnection()));
            out.write("</table>");
            out.write("</fieldset>");
            out.write("</body>");
            out.write("</html>");
    	} catch (Exception e) {
    	    throw new ServletException(e);
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
