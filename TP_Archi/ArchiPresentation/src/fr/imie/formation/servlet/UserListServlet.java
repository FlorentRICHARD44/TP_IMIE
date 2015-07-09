package fr.imie.formation.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.formation.jdbc.services.IService;
import fr.imie.formation.sessionbeans.SiteBean;
import fr.imie.formation.sessionbeans.UsagerBean;

/** Servlet Controller to generate list of Usagers.
 * Servlet implementation class UserListServlet
 */
@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {
    /** Serial Version UID.
     */
    private static final long serialVersionUID = 2417900212257871777L;
    /** Service used.
     */
    @EJB private IService servData;
    /** Bean for usagers.
     */
    @Inject private UsagerBean usagerbean;
    /** Bean for site.
     */
    @Inject private SiteBean sitebean;

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
        try {
            usagerbean.setUserlist(servData.selectAllUsagers());
            sitebean.setSitelist(servData.selectAllSites());
            usagerbean.setUser(null);
            request.getRequestDispatcher("/WEB-INF/userlisting.jsp")
                            .forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected final void doPost(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        // Not used.
    }
}
