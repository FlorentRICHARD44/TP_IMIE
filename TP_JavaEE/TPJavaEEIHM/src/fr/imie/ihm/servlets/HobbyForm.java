package fr.imie.ihm.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.entities.HobbyEntity;
import fr.imie.entities.HobbyMusicEntity;
import fr.imie.entities.HobbySportEntity;
import fr.imie.entities.SiteEntity;
import fr.imie.ihm.beans.RequestHeaderBean;
import fr.imie.service.Services;

/**
 * Servlet implementation class HobbyForm
 */
@WebServlet("/hobbyview")
public class HobbyForm extends HttpServlet {
       
    /**
     * 
     */
    private static final long serialVersionUID = 7659997936070436877L;
    @EJB
    private Services serv;
    @Inject private RequestHeaderBean header;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HobbyForm() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if (request.getParameter("view") != null) {
            request.setAttribute("hobby", serv.findHobbyById(Integer.valueOf(request.getParameter("view"))));
            request.getRequestDispatcher("/WEB-INF/hobbyview.jsp").forward(request, response);
        } else if (request.getParameter("newsport") != null
                || request.getParameter("newmusic") != null) {
            HobbyEntity hobby = null;
            if (request.getParameter("newsport") != null) {
                hobby = new HobbySportEntity();
            } else if (request.getParameter("newmusic") != null) {
                hobby = new HobbyMusicEntity();
            }
            request.setAttribute("hobby", hobby);
            request.getRequestDispatcher("/WEB-INF/hobbyview.jsp").forward(request, response);
        } else if (request.getParameter("save") != null) {
            HobbyEntity hobby = null;
            if (request.getParameter("type").equals(HobbySportEntity.class.getName())) {
                hobby = new HobbySportEntity();
                if (request.getParameter("team") == null) {
                    ((HobbySportEntity) hobby).setTeam(false);
                } else {
                    ((HobbySportEntity) hobby).setTeam(true);
                }
                
            } else if (request.getParameter("type").equals(HobbyMusicEntity.class.getName())) {
                hobby = new HobbyMusicEntity();
                ((HobbyMusicEntity)hobby).setGenremusic(request.getParameter("genre"));
            }
            if (!request.getParameter("id").equals("")) {
                hobby.setId(Integer.valueOf(request.getParameter("id")));
            }
            hobby.setNom(request.getParameter("name"));
            hobby = serv.save(hobby);
            request.setAttribute("hobby", hobby);
            request.getRequestDispatcher("/WEB-INF/hobbyview.jsp").forward(request, response);
        } else if (request.getParameter("del") != null) {
            Integer id = null;
            // TODO use the same parameter to store the id whatever the url referer
            if (header.getReferer().contains(request.getRequestURI())) { // Delete from hobby view
                id = Integer.valueOf(request.getParameter("id"));
            } else if (header.getReferer().contains("hobbylist")){  // Delete from hobby list
                id = Integer.valueOf(request.getParameter("del"));
            }
            HobbyEntity hobby = serv.findHobbyById(Integer.valueOf(id));
            try {
                serv.remove(hobby);
                response.sendRedirect("hobbylist");
            } catch (EJBTransactionRolledbackException e) {
                request.setAttribute("error", "hobbyassignedtousager");
                request.setAttribute("hobby", serv.findHobbyById(id));
                if (header.getReferer().contains(request.getRequestURI())) { // Delete from hobby view
                    request.getRequestDispatcher("/WEB-INF/hobbyview.jsp").forward(request, response);
                } else if (header.getReferer().contains("hobbylist")){  // Delete from hobby list
                    request.setAttribute("hobbylist", serv.findAllHobbies());
                    request.getRequestDispatcher("/WEB-INF/hobbylist.jsp").forward(request, response);
                }
                
            }
        }
	}

}
