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
 * Servlet implementation class UsagerList
 */
@WebServlet("/userlist")
public class UsagerList extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 1169335807621570540L;
    @EJB
    private Services serv;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsagerList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("usagerlist", serv.findAllUsagers());
		request.setAttribute("name", "");  // Default value of filter
        request.setAttribute("firstname", "");  // Default value of filter
        request.setAttribute("sitelist", serv.findAllSites());
        request.setAttribute("site", "Aucun");
	    request.getRequestDispatcher("/WEB-INF/userlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if (request.getParameter("filterFullName") != null) {
	        request.setAttribute("usagerlist",
	                serv.findUserByFullname(request.getParameter("name"),
	                                        request.getParameter("firstname")));
	        request.setAttribute("sitelist", serv.findAllSites());
	        request.setAttribute("site", "Aucun");
	        request.getRequestDispatcher("/WEB-INF/userlist.jsp").forward(request, response);
	    } else if (request.getParameter("filterSite") != null) {
	        String strId = request.getParameter("site");
	        Integer id = null;
	        SiteEntity site = null;
	        Boolean all = false;
	        if (!strId.equals("-")) {
	            try {
	                id = Integer.valueOf(strId);
                    site = serv.findSiteById(id);
	            } catch (NumberFormatException e) {
	                all = true;
	            }
	        }
	        request.setAttribute("usagerlist", serv.findUsagersBySite(site));
	        if (all) {
	            request.setAttribute("usagerlist", serv.findAllUsagers());
	        }
	        request.setAttribute("sitelist", serv.findAllSites());
            request.setAttribute("site", site);
            request.getRequestDispatcher("/WEB-INF/userlist.jsp").forward(request, response);
        }
	    
	}

}
