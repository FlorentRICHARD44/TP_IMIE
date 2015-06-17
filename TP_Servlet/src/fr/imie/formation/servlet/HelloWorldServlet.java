package fr.imie.formation.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(
        urlPatterns = "/HelloWorldServlet",
        initParams = @WebInitParam(
                name="color", value = "red"
                )
        )


public class HelloWorldServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 4185717569807071863L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Writer out = response.getWriter();
        // Get Init value of color
        String color = getInitParameter("color");
        // Get value specified in parameter if defined in the GET
        if (request.getParameter("color") != null) {
            color = request.getParameter("color");
        }
        out.write("<!DOCTYPE html>");
        out.write("<html lang=\"en\">");
        out.write("<header>");
        out.write("<meta charset=\"utf-8\">");
        out.write("<link rel=\"stylesheet\" href=\"CSS/tpservlet.css\"/>");
        out.write(String.format("<style type=\"text/css\">h1, em{color:%s;}</style>", color));
        out.write("<title>HelloWorld</title>");
        out.write("</header>");
        out.write("<body>");
        out.write("<h1>HELLO THE WORLD!</h1>");
        RequestDispatcher rd= request.getServletContext().getRequestDispatcher("/MenuViewServlet");
        rd.include(request, response);
        out.write("<em>2 lignes en JavaEE</em><br/>");
        out.write("<em>1 troisieme lignes en JavaEE</em><br/>");
        out.write(String.format("<a href=\"%s\" style=\"color:%s\">Same page in normal color</a><br/>", request.getRequestURI(), getInitParameter("color")));
        out.write(String.format("<a href=\"%s?color=black\" style=\"color:black\">Same page in black</a><br/>", request.getRequestURI()));
        out.write(String.format("<a href=\"%s?color=grey\" style=\"color:grey\">Same page in grey</a><br/>", request.getRequestURI()));
        out.write(String.format("<a href=\"%s?color=magenta\" style=\"color:magenta\">Same page in magenta</a><br/>", request.getRequestURI()));
        out.write(String.format("<a href=\"%s?color=yellow\" style=\"color:yellow\">Same page in yellow</a><br/>", request.getRequestURI()));
        out.write(String.format("<a href=\"%s?color=green\" style=\"color:green\">Same page in green</a><br/>", request.getRequestURI()));
        out.write(String.format("<a href=\"%s?color=%%231C325B\" style=\"color:#1C325B \">Same page in cyberbase blue</a><br/>", request.getRequestURI()));
        out.write(String.format("<form method=\"get\" action=\"%s\"><label for=\"colortext\">Entrer la couleur</label><input type=\"text\" id=\"colortext\" name=\"color\"/><input type=\"submit\"/></form>", request.getRequestURI()));
        out.write("<hr/>");
        out.write("<h2>Affichage des usagers en Forward</h2>");
        out.write("<a href=\"/TP_Servlet/UserListGetterServlet\">Affichage des utilisateurs en forward</a>");
        out.write("</body>");
        out.write("</html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
}
