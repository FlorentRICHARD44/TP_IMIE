package fr.imie.ihm.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.entities.UsagerEntity;
import fr.imie.ihm.beans.ConnectedUserBean;
import fr.imie.ihm.beans.OpenConnectionsBean;
import fr.imie.service.Services;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
       
    /**
     * 
     */
    private static final long serialVersionUID = 3609598623591123781L;
    
    @EJB Services serv;
    /** Bean for user connected.
     */
    @Inject private ConnectedUserBean connecteduserbean;
    /** Bean for application logged users.
     */
    @Inject private OpenConnectionsBean openConnectionsBean;
    

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsagerEntity filter = new UsagerEntity();
            String login = request.getParameter("login");
            UsagerEntity user = null;
            if (login.contains(" ") && login.split(" ").length > 1) {
                filter.setNom(login.split(" ")[1]);
                filter.setPrenom(login.split(" ")[0]);
                user = serv.checkUsagerPassword(filter,
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
