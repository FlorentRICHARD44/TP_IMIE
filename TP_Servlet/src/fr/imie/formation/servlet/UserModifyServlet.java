package fr.imie.formation.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.formation.jdbc.data.Site;
import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.jdbc.services.ServiceData;

/**
 * Servlet implementation class UserModifyServlet
 */
@WebServlet("/UserModifyServlet")
public class UserModifyServlet extends HttpServlet {
       
    /**
     * 
     */
    private static final long serialVersionUID = -2374434696632053831L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    if (request.getParameter("save") != null) {
		    Usager user = (Usager) request.getSession().getAttribute("user");
		    if (user == null) { // New Usager to create
                user = new Usager();
		    } // User to modify
            try (ServiceData servData = new ServiceData();) {
    		    user.setName(request.getParameter("name"));
                user.setFirstName(request.getParameter("firstname"));
                if (request.getParameter("email") != null) {
                    user.setEmail(request.getParameter("email"));
                }
                if (request.getParameter("birthdate") != null) {
                    try {
                        user.setDateBirth(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("birthdate")));
                    } catch (ParseException e) {
                        user.setDateBirth(null);
                    }
                }
                if (request.getParameter("inscrsite") != null) {
                    user.setInscrSite(((List<Site>) request.getSession().getAttribute("sitelist")).get(Integer.valueOf(request.getParameter("inscrsite"))));
                }
                if (user.getId() == null) { // New Usager to create
                    user = servData.insert(user);
                } else {  // User to modify
                    servData.update(user);
                }
                request.getSession().setAttribute("user", user);
            } catch(Exception e) {
                throw new ServletException(e);
            }
		} else if (request.getParameter("delete") != null) {
		    Usager user = (Usager) request.getSession().getAttribute("user");
		    if (request.getParameter("delete").equals("index")) {  // Delete from list view
		        user = ((List<Usager>) request.getSession().getAttribute("userlist")).get(Integer.valueOf(request.getParameter("index")) - 1);
		    } else {  // Delete from user view
    		    user = (Usager) request.getSession().getAttribute("user");
    	    }
	        try (ServiceData servData = new ServiceData();) {
	            servData.delete(user);
	            RequestDispatcher rd = request.getRequestDispatcher("/UserListGetterServlet");
	            rd.forward(request, response);
	        } catch (Exception e) {
	            throw new ServletException(e);
	        }
		}
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
