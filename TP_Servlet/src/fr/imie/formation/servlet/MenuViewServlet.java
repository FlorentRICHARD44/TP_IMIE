package fr.imie.formation.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuViewServlet
 */
@WebServlet("/MenuViewServlet")
public class MenuViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Writer out = response.getWriter();
        response.setContentType("text/html; charset=utf-8");
        out.write("<nav>");
        out.write("<div class=\"menuitem\"><a href=\"/TP_Servlet/HelloWorldServlet\">Helloworld</a></div>");
        out.write("<div class=\"menuitem\"><a href=\"/TP_Servlet/UserListGetterServlet\">Liste des Usagers</a></div>");
        out.write("</nav>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
