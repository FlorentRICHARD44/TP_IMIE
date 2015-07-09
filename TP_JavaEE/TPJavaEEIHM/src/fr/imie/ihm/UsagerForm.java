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
		request.setAttribute("usager", serv.findById(Integer.valueOf(request.getParameter("id"))));
		request.getRequestDispatcher("/WEB-INF/userview.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
