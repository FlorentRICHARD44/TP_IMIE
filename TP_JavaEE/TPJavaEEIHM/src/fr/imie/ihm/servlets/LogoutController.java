package fr.imie.ihm.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.ihm.beans.ConnectedUserBean;
import fr.imie.ihm.beans.OpenConnectionsBean;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	/**
     * 
     */
    private static final long serialVersionUID = 2474434105529424351L;
    /** Bean for user connected.
     */
    @Inject private ConnectedUserBean connecteduserbean;
    /** Bean for application logged users.
     */
    @Inject private OpenConnectionsBean openConnectionsBean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected final void doGet(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {
        // Not used.
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected final void doPost(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        connecteduserbean.setLogoutPathURI(request.getHeader("referer"));
        connecteduserbean.setLastuser(connecteduserbean.getUser());
        connecteduserbean.setUser(null);
        openConnectionsBean.removeUser();
        response.sendRedirect("login");
    }
}
