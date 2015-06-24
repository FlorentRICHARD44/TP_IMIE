package fr.imie.formation.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.formation.jdbc.data.Site;
import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.jdbc.services.IService;
import fr.imie.formation.transverse.Factory;

/** Servlet Controller to generate list of Usagers.
 * Servlet implementation class UserListServlet
 */
@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {
       
    /**
     * 
     */
    private static final long serialVersionUID = 2417900212257871777L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<Usager> userList = new ArrayList<Usager>();
	    List<Site> siteList = new ArrayList<Site>();
        try (IService servData = ((Factory) request.getServletContext().getAttribute("factory")).getService();) {
            userList = servData.selectAllUsagers();
            siteList = servData.selectAllSites();
            HttpSession session = request.getSession();
            session.setAttribute("userlist", userList);
            session.setAttribute("sitelist", siteList);
            //session.removeAttribute("user");
    	    request.getRequestDispatcher("/WEB-INF/userlisting.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Not used.
	}

}
