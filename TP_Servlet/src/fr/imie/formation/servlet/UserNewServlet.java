package fr.imie.formation.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.formation.jdbc.data.Site;
import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.jdbc.services.ServiceData;

/**
 * Servlet implementation class UserNewServlet
 */
@WebServlet("/UserNewServlet")
public class UserNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("savenew") != null) {
            ServiceData servData = new ServiceData();
		    Usager user = new Usager();
		    user.setName(request.getParameter("name"));
            user.setFirstName(request.getParameter("firstname"));
            if (request.getParameter("email") != null) {
                user.setEmail(request.getParameter("email"));
            }
            if (request.getParameter("birthdate") != null) {
                try {
                    user.setDateBirth(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("birthdate")));
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (request.getParameter("inscrsite") != null) {
                user.setInscrSite(((List<Site>) request.getSession().getAttribute("sitelist")).get(Integer.valueOf(request.getParameter("inscrsite"))));
            }
            servData.insert(user);
		}

        response.sendRedirect("/TP_Servlet/UserViewServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
