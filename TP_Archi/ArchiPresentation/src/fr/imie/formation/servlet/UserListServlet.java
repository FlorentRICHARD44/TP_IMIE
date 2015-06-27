package fr.imie.formation.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.formation.jdbc.data.Site;
import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.jdbc.services.IService;

/** Servlet Controller to generate list of Usagers.
 * Servlet implementation class UserListServlet
 */
@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {
    /** Service used.
     */
    @Inject private IService servData;
    /** Serial Version UID.
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
    protected final void doGet(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ready to compare");
        List<Usager> userList = new ArrayList<Usager>();
        List<Site> siteList = new ArrayList<Site>();
        System.out.println("compare finished");
        try {
            userList = servData.selectAllUsagers();
            siteList = servData.selectAllSites();
            HttpSession session = request.getSession();
            session.setAttribute("userlist", userList);
            session.setAttribute("sitelist", siteList);
            //session.removeAttribute("user");
            request.getRequestDispatcher("/WEB-INF/userlisting.jsp")
                            .forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected final void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Not used.
    }
}
