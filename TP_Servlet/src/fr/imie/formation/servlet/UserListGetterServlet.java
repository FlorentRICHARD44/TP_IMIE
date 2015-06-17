package fr.imie.formation.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.jdbc.data.Utilisateur;
import fr.imie.formation.jdbc.services.ServiceData;

/**
 * Servlet implementation class UserListGetterServlet
 */
@WebServlet("/UserListGetterServlet")
public class UserListGetterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListGetterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<Usager> userList = new ArrayList<Usager>();
	    //      Usager u1 = new Usager();
	    //      u1.setName("RICHARD");
	    //      u1.setFirstName("Florent");
	    //      userList.add(u1);
	    //      Usager u2 = new Usager();
	    //        u2.setName("DUPONT");
	    //        u2.setFirstName("Jean");
	    //        userList.add(u2);
        ServiceData servData = new ServiceData();
        userList = servData.selectAllUsagers();
        request.setAttribute("userlist", userList);
        HttpSession session = request.getSession();
        session.setAttribute("userlist", userList);
	    RequestDispatcher rd = request.getRequestDispatcher("/UserListDisplayServlet");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
