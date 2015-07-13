package fr.imie.ihm.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.entities.SiteEntity;
import fr.imie.service.Services;

/**
 * Servlet implementation class SiteForm
 */
@WebServlet("/siteview")
public class SiteForm extends HttpServlet {
    /**
     */
    private static final long serialVersionUID = 8598032585143310005L;
    @EJB
    private Services serv;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteForm() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if (request.getParameter("view") != null) {
            request.setAttribute("site", serv.findSiteById(Integer.valueOf(request.getParameter("view"))));
            request.getRequestDispatcher("/WEB-INF/siteview.jsp").forward(request, response);
        } else if (request.getParameter("new") != null) {
            request.setAttribute("site", null);
            request.getRequestDispatcher("/WEB-INF/siteview.jsp").forward(request, response);
        } else if (request.getParameter("save") != null) {
            SiteEntity site = new SiteEntity();
            if (!request.getParameter("id").equals("")) {
                site.setId(Integer.valueOf(request.getParameter("id")));
            }
            site.setNom(request.getParameter("name"));
            site = serv.save(site);
            request.setAttribute("site", site);
            request.getRequestDispatcher("/WEB-INF/siteview.jsp").forward(request, response);
        } else if (request.getParameter("del") != null) {
            SiteEntity site = new SiteEntity();
            if (request.getParameter("id") != null) { // Delete from site view
                site.setId(Integer.valueOf(request.getParameter("id")));
            } else {  // Delete from site list
                site.setId(Integer.valueOf(request.getParameter("del")));
            }
            serv.remove(site);
            response.sendRedirect("sitelist");
        }
	}

}
