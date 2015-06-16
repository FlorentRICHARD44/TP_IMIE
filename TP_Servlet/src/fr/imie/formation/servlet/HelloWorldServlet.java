package fr.imie.formation.servlet;

import java.io.IOException;
import java.io.Writer;

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

    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init()
     */
    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        super.init();

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
        out.write("<html>");
        out.write(String.format("<style type=\"text/css\">*{color:%s;}</style>", color));
        out.write("<h1>Hello the world!</h1>");
        out.write("<em>2 lignes en JavaEE</em>");
        out.write("<em>1 troisieme lignes en JavaEE</em>");
        out.write("</html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
