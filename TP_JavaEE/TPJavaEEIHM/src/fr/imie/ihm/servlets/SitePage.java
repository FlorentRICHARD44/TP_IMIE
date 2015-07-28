package fr.imie.ihm.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.entities.SiteEntity;
import fr.imie.service.Services;

/**
 * Servlet implementation class SitePage
 */
@WebServlet("/sites")
public class SitePage extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 5767359298611826404L;
    @EJB
    private Services serv;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SitePage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setAttribute("sitelist", serv.findAllSites());
	    request.getRequestDispatcher("/WEB-INF/sites.jsp").forward(request, response);
	}

	/** Used to get the form when creating a new site
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getRequestDispatcher("/WEB-INF/sites_site.jsp").forward(request, response);
	}
}
