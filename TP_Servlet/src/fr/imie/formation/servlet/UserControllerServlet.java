package fr.imie.formation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.formation.jdbc.data.Usager;

/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet {
       
    /**
     */
    private static final long serialVersionUID = -2424743228153264811L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
        Usager user = null;
        if (request.getParameter("user").equals("new")) {
            user = new Usager();
        } else {
            @SuppressWarnings("unchecked")
            List<Usager> userList = (List<Usager>) session.getAttribute("userlist");
            user = userList.get(Integer.valueOf(request.getParameter("user")) - 1);
        }
        request.getSession().setAttribute("user", user);
        RequestDispatcher rd = request.getRequestDispatcher("/UserViewServlet");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
