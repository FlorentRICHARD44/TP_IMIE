package fr.imie.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.jdbc.services.ServiceData;

/**
 * Servlet implementation class UserLoginControllerServlet
 */
@WebServlet("/login")
public class UserLoginControllerServlet extends HttpServlet {
       
    /**
     * 
     */
    private static final long serialVersionUID = 5250812970723215403L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (ServiceData servData = new ServiceData();) {
    		Usager filter = new Usager();
    		String login = request.getParameter("login");
    		Usager user = null;
            if (login.contains(" ") && login.split(" ").length > 1) {
                filter.setName(login.split(" ")[1]);
                filter.setFirstName(login.split(" ")[0]);
                user = servData.checkUsagerPassword(filter, request.getParameter("pwd"));
         	}
    		if (user == null) {
    		    request.getRequestDispatcher("/WEB-INF/login.jsp?error=true").forward(request, response);
                request.getSession().removeAttribute("userconnected");
    		} else {
    	        request.getSession().setAttribute("userconnected", user);
    	    }
		} catch (Exception e) {
		    throw new ServletException(e);
		} 
	}
}
