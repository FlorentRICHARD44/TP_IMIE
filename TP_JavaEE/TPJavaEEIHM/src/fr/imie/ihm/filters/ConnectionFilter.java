package fr.imie.ihm.filters;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.entities.UsagerEntity;
import fr.imie.ihm.beans.ConnectedUserBean;

/** Limit the access to the site via connection.
 * Servlet Filter implementation class ConnectionFilter
 */
@WebFilter("/*")
public class ConnectionFilter implements Filter {
    /** Bean for user connected.
     */
    @Inject private ConnectedUserBean connecteduserbean;
    
    /**
     * Default constructor. 
     */
    public ConnectionFilter() {
        super();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        UsagerEntity user = connecteduserbean.getUser();
        String path = req.getRequestURI();
        if ((user != null) || (path.contains("login") || (path.contains("IMG/") || path.contains("CSS/")))) {
            chain.doFilter(req, resp);
            if (user == null && connecteduserbean.getUser() != null) { // Just logged in
                if (connecteduserbean.getPathURI() != null) {
                    resp.sendRedirect(connecteduserbean.getPathURI());
                } else if (connecteduserbean.getLastuser() != null
                        && connecteduserbean.getLastuser().getId() == connecteduserbean.getUser().getId()
                        && connecteduserbean.getLogoutPathURI() != null) {
                    resp.sendRedirect(connecteduserbean.getLogoutPathURI());
                } else {
                    resp.sendRedirect("home");
                }
                connecteduserbean.setPathURI(null);
                connecteduserbean.setLogoutPathURI(null);
                connecteduserbean.setLastuser(null);
            }
        } else {
            String uri = req.getRequestURI();
            if (req.getQueryString() != null) {
                uri = uri.concat("?").concat(req.getQueryString());
            }
            connecteduserbean.setPathURI(uri);
            resp.sendRedirect("login");
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
