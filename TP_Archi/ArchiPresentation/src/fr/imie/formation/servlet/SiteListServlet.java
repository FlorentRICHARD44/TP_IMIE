package fr.imie.formation.servlet;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 * Servlet implementation class SiteListServlet
 */
@WebServlet("/sitelist")
public class SiteListServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 2749772919799880950L;
    /** Service used.
     */
    @Inject private IService servData;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Site> siteList = new ArrayList<Site>();
        try {
            siteList = servData.selectAllSites();
            HttpSession session = request.getSession();
            session.setAttribute("sitelist", siteList);
            //session.removeAttribute("user");
            request.getRequestDispatcher("/WEB-INF/sitelisting.jsp")
                            .forward(request, response);
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
