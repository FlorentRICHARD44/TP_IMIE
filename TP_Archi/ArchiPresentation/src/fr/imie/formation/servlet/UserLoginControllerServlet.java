package fr.imie.formation.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.jdbc.services.IService;
import fr.imie.formation.servlet.applibeans.OpenConnectionsBean;
import fr.imie.formation.sessionbeans.ConnectedUserBean;

/** Servlet to control the login of an usager.
 * Servlet implementation class UserLoginControllerServlet
 */
@WebServlet("/login")
public class UserLoginControllerServlet extends HttpServlet {
    /** Serial Version UID.
     */
    private static final long serialVersionUID = 5250812970723215403L;
    /** Service used.
     */
    @EJB private IService servData;
    /** Bean for user connected.
     */
    @Inject private ConnectedUserBean connecteduserbean;
    /** Bean for application logged users.
     */
    @Inject private OpenConnectionsBean openConnectionsBean;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginControllerServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected final void doGet(HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected final void doPost(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Usager filter = new Usager();
            String login = request.getParameter("login");
            Usager user = null;
            if (login.contains(" ") && login.split(" ").length > 1) {
                filter.setName(login.split(" ")[1]);
                filter.setFirstName(login.split(" ")[0]);
                user = servData.checkUsagerPassword(filter,
                                    request.getParameter("pwd"));
            }
            if (user == null) {
                request.getRequestDispatcher("/WEB-INF/login.jsp?error=true")
                                .forward(request, response);
                connecteduserbean.setUser(null);
            } else {
                connecteduserbean.setUser(user);
                openConnectionsBean.addUser();
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
