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
	private static final long serialVersionUID = 1L;
    @EJB
    private Services serv;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsagerList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("usagerlist", serv.findAll());
	    request.getRequestDispatcher("userlist").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
