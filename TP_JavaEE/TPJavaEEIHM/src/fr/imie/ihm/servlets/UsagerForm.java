package fr.imie.ihm.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.entities.UsagerEntity;
import fr.imie.service.Services;

/**
 * Servlet implementation class UsagerForm
 */
@WebServlet("/userview")
public class UsagerForm extends HttpServlet {
       
    /**
     * 
     */
    private static final long serialVersionUID = -7973303656865987885L;
    @EJB
    private Services serv;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsagerForm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// not used
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if (request.getParameter("view") != null) {
	        request.setAttribute("usager", serv.findUsagerById(Integer.valueOf(request.getParameter("view"))));
	        request.setAttribute("sitelist", serv.findAllSites());
	        request.getRequestDispatcher("/WEB-INF/userview.jsp").forward(request, response);
	    } else if (request.getParameter("new") != null) {
		    request.setAttribute("usager", null);
		    request.setAttribute("sitelist", serv.findAllSites());
		    request.getRequestDispatcher("/WEB-INF/userview.jsp").forward(request, response);
		} else if (request.getParameter("save") != null) {
		    UsagerEntity user = new UsagerEntity();
		    if (!request.getParameter("id").equals("")) {
		        user.setId(Integer.valueOf(request.getParameter("id")));
		    }
		    user.setNom(request.getParameter("name"));
		    user.setPrenom(request.getParameter("firstname"));
		    try {
                user.setDatenaissance(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dateofbirth")));
            } catch (ParseException e) {
                user.setDatenaissance(null);
            }
		    if (request.getParameter("email").equals("")) {
		        user.setEmail(null);
		    } else  {
		        user.setEmail(request.getParameter("email"));
		    }
		    if (request.getParameter("nbconnexion").equals("")) {
		        user.setNbConnexion(0);
		    } else {
		        user.setNbConnexion(Integer.valueOf(request.getParameter("nbconnexion")));
		    }
		    if (request.getParameter("site") == null) {
		        user.setSite(null);
		    } else {
		        user.setSite(serv.findSiteById(Integer.valueOf(request.getParameter("site"))));
		    }
		    user.setPassword(request.getParameter("password"));
		    user = serv.save(user);
            request.setAttribute("usager", user);
            request.setAttribute("sitelist", serv.findAllSites());
            request.getRequestDispatcher("/WEB-INF/userview.jsp").forward(request, response);
		} else if (request.getParameter("del") != null) {
		    UsagerEntity user = new UsagerEntity();
		    if (request.getParameter("id") != null) { // Delete from usager view
		        user.setId(Integer.valueOf(request.getParameter("id")));
		    } else {  // Delete from usager list
                user.setId(Integer.valueOf(request.getParameter("del")));
		    }
		    serv.remove(user);
		    response.sendRedirect("userlist");
		}
	}

}
