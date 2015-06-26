package fr.imie.formation.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.formation.jdbc.data.Site;
import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.jdbc.services.IService;

/** Servlet to control manipulation on an Usager (view, create, update, delete).
 * Servlet implementation class UserViewServlet
 */
@WebServlet("/userview")
public class UserViewServlet extends HttpServlet {
    /** Minimum length for password.
     */
    private static final int PASSWORD_MIN_LENGTH = 4;

    /** Serial Version UID.
     */
    private static final long serialVersionUID = -4654069060040888179L;
    /** Service Used.
     */
    @Inject private IService servData;
    /** Constructor.
     */
    public UserViewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected final void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        // return to the user list, because access from an URL (not an action)
        response.sendRedirect("userlist");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("unchecked")
    protected final void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usager user = null;
        try {
            // Simple view of the user
            if (request.getParameter("view") != null) {
                List<Usager> userList = (List<Usager>) session.getAttribute("userlist");
                user = userList.get(Integer.valueOf(request.getParameter("numligne")) - 1);
                session.setAttribute("user", user);
                request.getRequestDispatcher("/WEB-INF/userview.jsp").forward(request, response);
            }
            // Add a new user
            if (request.getParameter("new") != null) {
                user = new Usager();
                session.setAttribute("user", user);
                request.getRequestDispatcher("/WEB-INF/userview.jsp").forward(request, response);
            }

            // Delete selected user
            if (request.getParameter("delete") != null) {
                if (session.getAttribute("user") == null) {  // From userlist
                    List<Usager> userList = (List<Usager>) session.getAttribute("userlist");
                    user = userList.get(Integer.valueOf(request.getParameter("numligne")) - 1);
                } else { // From userview
                    user = (Usager) session.getAttribute("user");
                    session.removeAttribute("user");
                }
                servData.delete(user);
                session.removeAttribute("userlist");
                response.sendRedirect("userlist");
            }

            // Save current user
            if (request.getParameter("save") != null) {
                user = (Usager) session.getAttribute("user");
                if (user == null) { // New Usager to create
                    user = new Usager();
                } // User to modify
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
                    user.setInscrSite(((List<Site>) session.getAttribute("sitelist")).get(
                                                Integer.valueOf(request.getParameter("inscrsite")) - 1));
                }
                if (user.getId() == null) { // New Usager to create
                    user = servData.insert(user);
                } else {  // User to modify
                    servData.update(user);
                }
                session.setAttribute("user", user);
                request.getRequestDispatcher("/WEB-INF/userview.jsp").forward(request, response);
            }

            // Modification of the password.
            if (request.getParameter("modifpwd") != null) {
                user = (Usager) session.getAttribute("user");
                if (servData.checkUsagerPassword(user, request.getParameter("oldpwd")) == null) {
                    request.setAttribute("error", "old");
                } else if (!request.getParameter("newpwd").equals(request.getParameter("confnewpwd"))) {
                    request.setAttribute("error", "confnew");
                } else if (((String) request.getParameter("newpwd")).length() < PASSWORD_MIN_LENGTH) {
                    request.setAttribute("error", "newshort");
                } else { // OK, can save new password
                    servData.modifyUsagerPassword(user, request.getParameter("newpwd"));
                }
                request.getRequestDispatcher("/WEB-INF/userview.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
