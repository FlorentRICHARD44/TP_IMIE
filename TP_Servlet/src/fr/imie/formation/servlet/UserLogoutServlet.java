package fr.imie.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** Servlet to Control logout of an Usager.
 * Servlet implementation class UserLogoutServlet
 */
@WebServlet("/logout")
public class UserLogoutServlet extends HttpServlet {
       
    /**
     * 
     */
    private static final long serialVersionUID = -6192859875940250945L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogoutServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Not used.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    session.setAttribute("logoutPathURI", request.getHeader("referer"));
	    session.setAttribute("lastconnecteduser", session.getAttribute("userconnected"));
	    session.removeAttribute("userconnected");
	    response.sendRedirect("login");
	}
}
