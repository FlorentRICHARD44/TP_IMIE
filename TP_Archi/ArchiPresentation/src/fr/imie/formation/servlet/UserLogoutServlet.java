package fr.imie.formation.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.formation.servlet.applibeans.OpenConnectionsBean;
import fr.imie.formation.sessionbeans.ConnectedUserBean;

/** Servlet to Control logout of an Usager.
 * Servlet implementation class UserLogoutServlet
 */
@WebServlet("/logout")
public class UserLogoutServlet extends HttpServlet {

    /** Serial Version UID.
     */
    private static final long serialVersionUID = -6192859875940250945L;
    /** Bean for user connected.
     */
    @Inject private ConnectedUserBean connecteduserbean;
    /** Bean for application logged users.
     */
    @Inject private OpenConnectionsBean openConnectionsBean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogoutServlet() {
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
        HttpSession session = request.getSession();
        session.setAttribute("logoutPathURI", request.getHeader("referer"));
        connecteduserbean.setLastuser(connecteduserbean.getUser());
        connecteduserbean.setUser(null);
        openConnectionsBean.removeUser();
        response.sendRedirect("login");
    }
}
