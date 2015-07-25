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
		if (request.getParameterMap().size() == 0) {
		    request.setAttribute("sitelist", serv.findAllSites());
		    request.getRequestDispatcher("/WEB-INF/sites.jsp").forward(request, response);
		} else if (request.getParameter("sitelist") != null) {
		    request.setAttribute("sitelist", serv.findAllSites());
		    request.getRequestDispatcher("/WEB-INF/sites_locallist.jsp").forward(request, response);
		} else if (request.getParameter("site") != null) {
		    request.setAttribute("site", serv.findSiteById(Integer.valueOf(request.getParameter("site"))));
            request.getRequestDispatcher("/WEB-INF/sites_site.jsp").forward(request, response);
		}
	}

	/** Used to get the form when creating a new site
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getRequestDispatcher("/WEB-INF/sites_site.jsp").forward(request, response);
	}

    /** Used to Save a Site (update or create)
     * @see javax.servlet.http.HttpServlet#doPut(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        SiteEntity site = new SiteEntity();
        for (String paramvalue : URLDecoder.decode(br.readLine(), "UTF-8").split("&")) {
            if (paramvalue.split("=")[0].equals("id")) {
                if (!paramvalue.split("=")[1].equals("null")) {
                    site.setId(Integer.valueOf(paramvalue.split("=")[1]));
                }
            } else if (paramvalue.split("=")[0].equals("nom")) {
                site.setNom(paramvalue.split("=")[1]);
            }
        }
        site = serv.save(site);
        resp.setContentType("text/plain; charset=UTF-8;");
        resp.getWriter().println(site.getId().toString());
    }

    /** Delete a Site
     * @see javax.servlet.http.HttpServlet#doDelete(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        SiteEntity site = new SiteEntity();
        for (String paramvalue : URLDecoder.decode(br.readLine(), "UTF-8").split("&")) {
            if (paramvalue.split("=")[0].equals("id")) {
                site.setId(Integer.valueOf(paramvalue.split("=")[1]));
            }
        }
        serv.remove(site);
    }

}
