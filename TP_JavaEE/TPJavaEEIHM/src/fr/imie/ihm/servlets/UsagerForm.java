package fr.imie.ihm.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.entities.HobbyEntity;
import fr.imie.entities.UsagerEntity;
import fr.imie.ihm.beans.RequestHeaderBean;
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
    @Inject private RequestHeaderBean header;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsagerForm() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if (request.getParameter("view") != null) {
	        UsagerEntity usager = serv.findUsagerById(Integer.valueOf(request.getParameter("view")));
	        request.setAttribute("usager", usager);
	        request.setAttribute("sitelist", serv.findAllSites());
	        List<HobbyEntity> hobbies = serv.findAllHobbies();
	        hobbies.removeAll(usager.getHobbies());
	        request.setAttribute("availablehobbies",hobbies);
	        request.getRequestDispatcher("/WEB-INF/userview.jsp").forward(request, response);
	    } else if (request.getParameter("new") != null) {
		    request.setAttribute("usager", null);
		    request.setAttribute("sitelist", serv.findAllSites());
            request.setAttribute("availablehobbies", serv.findAllHobbies());
		    request.getRequestDispatcher("/WEB-INF/userview.jsp").forward(request, response);
		} else if (request.getParameter("save") != null 
		        || request.getParameter("addhobby") != null
		        || request.getParameter("delhobby") != null) {
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
		    user.setPassword(serv.findUsagerById(user.getId()).getPassword());
		    user.setHobbies(serv.findUsagerById(user.getId()).getHobbies());
		    if (request.getParameter("addhobby") != null) {
		        user.addHobby(serv.findHobbyById(Integer.valueOf(request.getParameter("newhobby"))));
		    } else if (request.getParameter("delhobby") != null) {
		        user.removeHobby(serv.findHobbyById(Integer.valueOf(request.getParameter("delhobby"))));
		    }
		    user = serv.save(user);
            request.setAttribute("usager", user);
            request.setAttribute("sitelist", serv.findAllSites());;
            List<HobbyEntity> hobbies = serv.findAllHobbies();
            hobbies.removeAll(user.getHobbies());
            request.setAttribute("availablehobbies",hobbies);
            request.getRequestDispatcher("/WEB-INF/userview.jsp").forward(request, response);
		} else if (request.getParameter("del") != null) {
		    UsagerEntity user = new UsagerEntity();
            // TODO use the same parameter to store the id whatever the url referer
		    if (header.getReferer().contains(request.getRequestURI())) { // Delete from usager view
		        user.setId(Integer.valueOf(request.getParameter("id")));
		    } else if (header.getReferer().contains("userlist")) {  // Delete from usager list
                user.setId(Integer.valueOf(request.getParameter("del")));
		    }
		    serv.remove(user);
		    response.sendRedirect("userlist");
		}
	}
}
