package fr.imie.formation.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.formation.jdbc.data.Site;
import fr.imie.formation.jdbc.services.IService;
import fr.imie.formation.sessionbeans.SiteBean;

/** Servlet to control manipulation on an Usager (view, create, update, delete).
 * Servlet implementation class UserViewServlet
 */
@WebServlet("/siteview")
public class SiteViewServlet extends HttpServlet {
    /** Bean to used site elements from session.
     */
    @Inject @Named("sitebean") private SiteBean sitebean;
    /**
     */
    private static final long serialVersionUID = 3276474025300312834L;
    /** Service Used.
     */
    @Inject private IService servData;
    /** Site displayed.
    /** Constructor.
     */
    public SiteViewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected final void doGet(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {
        // return to the user list, because access from an URL (not an action)
        response.sendRedirect("sitelist");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected final void doPost(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Simple view of the site
            if (request.getParameter("view") != null) {
                sitebean.setSite(sitebean.getSitelist().get(
                        Integer.valueOf(request.getParameter("view")) - 1));
                request.getRequestDispatcher("/WEB-INF/siteview.jsp")
                                .forward(request, response);
            }
            // Add a new site
            if (request.getParameter("new") != null) {
                sitebean.setSite(new Site());
                request.getRequestDispatcher("/WEB-INF/siteview.jsp")
                                .forward(request, response);
            }

            // Delete selected site
            if (request.getParameter("delete") != null) {
                if (sitebean.getSite() == null) {  // From sitelist
                    sitebean.setSite(sitebean.getSitelist().get(
                        Integer.valueOf(request.getParameter("delete")) - 1));
                }
                servData.delete(sitebean.getSite());
                sitebean.setSite(null);
                response.sendRedirect("sitelist");
            }

            // Save current site
            if (request.getParameter("save") != null) {
                if (sitebean.getSite() == null) { // New Site to create
                    sitebean.setSite(new Site());
                } // User to modify
                sitebean.getSite().setName(request.getParameter("name"));
                if (sitebean.getSite().getId() == null) { // New Site to create
                    sitebean.setSite(servData.insert(sitebean.getSite()));
                } else {  // User to modify
                    servData.update(sitebean.getSite());
                }
                request.getRequestDispatcher("/WEB-INF/siteview.jsp")
                                .forward(request, response);
            }

            // Delete several sites.
            if (request.getParameter("delselected") != null) {
                Map<String, String[]> reqparams = request.getParameterMap();
                // If at least one entry is selected
                if (reqparams.get("selected") != null) {
                    List<String> strListId =
                            Arrays.asList(reqparams.get("selected"));
                    Collections.reverse(strListId);
                    for (String s: strListId) {
                        servData.delete(sitebean.getSitelist().get(
                                        Integer.valueOf(s) - 1));
                    }
                }
                response.sendRedirect("sitelist");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
