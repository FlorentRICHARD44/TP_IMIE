package fr.imie.formation.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.formation.jdbc.services.IService;
import fr.imie.formation.sessionbeans.SiteBean;

/** Controller for the Listing site view.
 * Servlet implementation class SiteListServlet
 */
@WebServlet("/sitelist")
public class SiteListServlet extends HttpServlet {
    /**
     */
    private static final long serialVersionUID = 2749772919799880950L;
    /** Service used.
     */
    @Inject private IService servData;
    /** Beans for storing sites element.
     */
    @Inject private SiteBean sitebean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteListServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        try {
            sitebean.setSitelist(servData.selectAllSites());
            sitebean.setSite(null);
            request.getRequestDispatcher("/WEB-INF/sitelisting.jsp")
                        .forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        // Not used.
    }

}
