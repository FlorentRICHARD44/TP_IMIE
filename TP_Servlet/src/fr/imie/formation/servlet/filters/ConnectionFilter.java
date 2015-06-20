package fr.imie.formation.servlet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.formation.jdbc.data.Usager;

/**
 * Servlet Filter implementation class ConnectionFilter
 */
@WebFilter("/*")
public class ConnectionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ConnectionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Usager user = (Usager) req.getSession().getAttribute("userconnected");
		String path = req.getRequestURI();
		if ((user != null) || (path.contains("login") || (path.contains("IMG/") || path.contains("CSS/")))) {
		    chain.doFilter(req, resp);
		    if (user == null && req.getSession().getAttribute("userconnected") != null) { // Just logged in
		        String nextURI = (String) req.getSession().getAttribute("pathURI");
		        if (nextURI == null) {
		            resp.sendRedirect("home");
		        } else {
		            resp.sendRedirect(nextURI);
		        }
	            req.getSession().removeAttribute("pathURI");
	        }
		} else {
		    String uri = req.getRequestURI();
		    if (req.getQueryString() != null) {
		        uri = uri.concat("?").concat(req.getQueryString());
		    }
		    req.getSession().setAttribute("pathURI", uri);
            resp.sendRedirect("login");
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
