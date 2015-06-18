package fr.imie.formation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/UserLoginControllerServlet")
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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceData servData = new ServiceData();
		Usager filter = new Usager();
		String login = request.getParameter("login");
		Usager user = null;
        if (login.contains(" ")) {
    		filter.setName(login.split(" ")[1]);
            filter.setFirstName(login.split(" ")[0]);
            filter.setDateBirth(null);
            filter.setEmail(null);
            filter.setInscrSite(null);
            filter.setPassword(null);
            try {
                user = servData.selectFiltered(filter).get(0);
            } catch (Exception e) {
                user = null;
            }
		}
		if ((user == null) || !request.getParameter("pwd").equals(user.getPassword())) {
		    response.sendRedirect("Login?error=true");
            request.getSession().removeAttribute("userconnected");
		} else {
	        request.getSession().setAttribute("userconnected", user);
	        response.sendRedirect("UserListGetterServlet");
		}
	}
}
