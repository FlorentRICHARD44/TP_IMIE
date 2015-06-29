package fr.imie.formation.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.formation.jdbc.data.Site;
import fr.imie.formation.jdbc.services.IService;

/** Servlet to control manipulation on an Usager (view, create, update, delete).
 * Servlet implementation class UserViewServlet
 */
@WebServlet("/siteview")
public class SiteViewServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 3276474025300312834L;
    /** Service Used.
     */
    @Inject private IService servData;
    /** Constructor.
     */
    public SiteViewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected final void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // return to the user list, because access from an URL (not an action)
        response.sendRedirect("sitelist");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("unchecked")
    protected final void doPost(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Site site = null;
        try {
            // Simple view of the site
            if (request.getParameter("view") != null) {
                List<Site> siteList = (List<Site>) session.getAttribute("sitelist");
                site = siteList.get(Integer.valueOf(request.getParameter("view")) - 1);
                session.setAttribute("site", site);
                request.getRequestDispatcher("/WEB-INF/siteview.jsp")
                                .forward(request, response);
            }
            // Add a new site
            if (request.getParameter("new") != null) {
                site = new Site();
                session.setAttribute("site", site);
                request.getRequestDispatcher("/WEB-INF/siteview.jsp")
                                .forward(request, response);
            }

            // Delete selected site
            if (request.getParameter("delete") != null) {
                if (session.getAttribute("site") == null) {  // From sitelist
                    List<Site> siteList = (List<Site>) session.getAttribute("sitelist");
                    site = siteList.get(Integer.valueOf(request.getParameter("delete")) - 1);
                } else { // From siteview
                    site = (Site) session.getAttribute("site");
                    session.removeAttribute("site");
                }
                servData.delete(site);
                session.removeAttribute("siteist");
                response.sendRedirect("sitelist");
            }

            // Save current site
            if (request.getParameter("save") != null) {
                site = (Site) session.getAttribute("site");
                if (site == null) { // New Site to create
                    site = new Site();
                } // User to modify
                site.setName(request.getParameter("name"));
                if (site.getId() == null) { // New Site to create
                    site = servData.insert(site);
                } else {  // User to modify
                    servData.update(site);
                }
                session.setAttribute("site", site);
                request.getRequestDispatcher("/WEB-INF/siteview.jsp")
                                .forward(request, response);
            }

            // Delete several sites.
            if (request.getParameter("delselected") != null) {
                Map<String, String[]> reqparams = request.getParameterMap();
                if (reqparams.get("selected") != null) {  // If at least one entry is selected
                    List<String> strListId =
                            Arrays.asList(reqparams.get("selected"));
                    Collections.reverse(strListId);
                    for (String s: strListId) {
                        servData.delete(((List<Site>)
                                session.getAttribute("sitelist")).get(
                                        Integer.valueOf(s) - 1));
                    }
                }
                session.removeAttribute("sitelist");
                response.sendRedirect("sitelist");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
