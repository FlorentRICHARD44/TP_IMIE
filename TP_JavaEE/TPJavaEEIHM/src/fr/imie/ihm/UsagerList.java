package fr.imie.ihm;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.setAttribute("name", "");
        request.setAttribute("firstname", "");
	    request.getRequestDispatcher("/WEB-INF/userlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if (request.getParameter("filter") != null) {
	        request.setAttribute("usagerlist",
	                serv.findUserByFullname(request.getParameter("name"),
	                                        request.getParameter("firstname")));
	        request.getRequestDispatcher("/WEB-INF/userlist.jsp").forward(request, response);
	    }
	    
	}

}
