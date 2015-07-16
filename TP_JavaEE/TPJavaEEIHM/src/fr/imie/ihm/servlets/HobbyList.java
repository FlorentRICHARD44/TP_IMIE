package fr.imie.ihm.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.service.Services;

/**
 * Servlet implementation class HobbyList
 */
@WebServlet("/hobbylist")
public class HobbyList extends HttpServlet {
       
    /** Serial Version UID.
     */
    private static final long serialVersionUID = -7537655438967575555L;
    @EJB
    private Services serv;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HobbyList() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("hobbylist", serv.findAllHobbies());
        request.getRequestDispatcher("/WEB-INF/hobbylist.jsp").forward(request, response);
        // TODO Ajouter lien de visualisation des usagers du loisir
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("hobbylist", serv.findHobbyByName(request.getParameter("name")));
        request.getRequestDispatcher("/WEB-INF/hobbylist.jsp").forward(request, response);
    }

}
