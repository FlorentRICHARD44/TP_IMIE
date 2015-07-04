package fr.imie.formation.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.jdbc.services.IService;
import fr.imie.formation.sessionbeans.SiteBean;
import fr.imie.formation.sessionbeans.UsagerBean;

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
    /** Bean for usager.
     */
    @Inject private UsagerBean usagerbean;
    /** Bean for site.
     */
    @Inject private SiteBean sitebean;
    /** Constructor.
     */
    public UserViewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected final void doGet(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {
        // return to the user list, because access from an URL (not an action)
        response.sendRedirect("userlist");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected final void doPost(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Simple view of the user
            if (request.getParameter("view") != null) {
                usagerbean.setUser(usagerbean.getUserlist().get(
                        Integer.valueOf(request.getParameter("view")) - 1));
                request.getRequestDispatcher("/WEB-INF/userview.jsp")
                                .forward(request, response);
            }
            // Add a new user
            if (request.getParameter("new") != null) {
                usagerbean.setUser(new Usager());
                request.getRequestDispatcher("/WEB-INF/userview.jsp")
                                .forward(request, response);
            }

            // Delete selected user
            if (request.getParameter("delete") != null) {
                if (usagerbean.getUser() == null) {  // From userlist
                    usagerbean.setUser(usagerbean.getUserlist().get(
                        Integer.valueOf(request.getParameter("delete")) - 1));
                }
                servData.delete(usagerbean.getUser());
                response.sendRedirect("userlist");
            }

            // Save current user
            if (request.getParameter("save") != null) {
                Usager user = usagerbean.getUser();
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
                        user.setDateBirth(new SimpleDateFormat("dd/MM/yyyy")
                                    .parse(request.getParameter("birthdate")));
                    } catch (ParseException e) {
                        user.setDateBirth(null);
                    }
                }
                if (request.getParameter("inscrsite") != null) {
                    user.setInscrSite(sitebean.getSitelist().get(
                            Integer.valueOf(
                                    request.getParameter("inscrsite")) - 1));
                }
                if (user.getId() == null) { // New Usager to create
                    user = servData.insert(user);
                } else {  // User to modify
                    servData.update(user);
                }
                usagerbean.setUser(user);
                request.getRequestDispatcher("/WEB-INF/userview.jsp")
                                .forward(request, response);
            }

            // Modification of the password.
            if (request.getParameter("modifpwd") != null) {
                if (servData.checkUsagerPassword(usagerbean.getUser(),
                                request.getParameter("oldpwd")) == null) {
                    request.setAttribute("error", "old");
                } else if (!request.getParameter("newpwd").equals(
                            request.getParameter("confnewpwd"))) {
                    request.setAttribute("error", "confnew");
                } else if (((String) request.getParameter("newpwd")).length()
                                < PASSWORD_MIN_LENGTH) {
                    request.setAttribute("error", "newshort");
                } else { // OK, can save new password
                    servData.modifyUsagerPassword(usagerbean.getUser(),
                                        request.getParameter("newpwd"));
                }
                request.getRequestDispatcher("/WEB-INF/userview.jsp")
                                .forward(request, response);
            }

            // Delete several usagers.
            if (request.getParameter("delselected") != null) {
                Map<String, String[]> reqparams = request.getParameterMap();
                // If at least one entry is selected
                if (reqparams.get("selected") != null) {
                    List<String> strListId =
                            Arrays.asList(reqparams.get("selected"));
                    Collections.reverse(strListId);
                    for (String s: strListId) {
                        servData.delete(usagerbean.getUserlist().get(
                                        Integer.valueOf(s) - 1));
                    }
                }
                response.sendRedirect("userlist");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
