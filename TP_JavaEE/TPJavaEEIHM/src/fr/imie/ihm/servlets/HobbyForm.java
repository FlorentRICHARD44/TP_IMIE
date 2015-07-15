package fr.imie.ihm.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.entities.HobbyEntity;
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
        } else if (request.getParameter("new") != null) {
            request.setAttribute("hobby", null);
            request.getRequestDispatcher("/WEB-INF/hobbyview.jsp").forward(request, response);
        } else if (request.getParameter("save") != null) {
            HobbyEntity hobby = new HobbyEntity();
            if (!request.getParameter("id").equals("")) {
                hobby.setId(Integer.valueOf(request.getParameter("id")));
            }
            hobby.setNom(request.getParameter("name"));
            hobby = serv.save(hobby);
            request.setAttribute("hobby", hobby);
            request.getRequestDispatcher("/WEB-INF/hobbyview.jsp").forward(request, response);
        } else if (request.getParameter("del") != null) {
            HobbyEntity hobby = new HobbyEntity();
            if (header.getReferer().contains(request.getRequestURI())) { // Delete from hobby view
                hobby.setId(Integer.valueOf(request.getParameter("id")));
            } else if (header.getReferer().contains("hobbylist")){  // Delete from hobby list
                hobby.setId(Integer.valueOf(request.getParameter("del")));
            }
            serv.remove(hobby);
            response.sendRedirect("hobbylist");
        }
	}

}
