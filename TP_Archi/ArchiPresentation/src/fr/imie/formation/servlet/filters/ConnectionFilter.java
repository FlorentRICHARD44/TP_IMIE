package fr.imie.formation.servlet.filters;

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
import javax.servlet.http.HttpSession;

import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.sessionbeans.ConnectedUserBean;

/** Filter to secured all the pages via login/password.
 * The elements not filtered are: login page, IMG and CSS.
 * Servlet Filter implementation class ConnectionFilter
 */
@WebFilter("/*")
public class ConnectionFilter implements Filter {

    /** Bean for user connected.
     */
    @Inject private ConnectedUserBean connecteduserbean;
    /** Default constructor.
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
    public final void doFilter(ServletRequest request,
                               ServletResponse response,
                               FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Usager user = connecteduserbean.getUser();
        String path = req.getRequestURI();
        if ((user != null) || (path.contains("login") || (path.contains("IMG/") || path.contains("CSS/")))) {
            chain.doFilter(req, resp);
            if (user == null && connecteduserbean.getUser() != null) { // Just logged in
                String nextURI = (String) session.getAttribute("pathURI");
                String lastURI = (String) session.getAttribute("logoutPathURI");
                Usager lastConnectedUser = (Usager) session.getAttribute("lastconnecteduser");
                if (nextURI != null) {
                    resp.sendRedirect(nextURI);
                } else if (lastConnectedUser != null
                        && lastConnectedUser.getId() == connecteduserbean.getUser().getId()
                        && lastURI != null) {
                    resp.sendRedirect(lastURI);
                } else {
                    resp.sendRedirect("home");
                }
                session.removeAttribute("pathURI");
                session.removeAttribute("logoutPathURI");
                session.removeAttribute("lastconnecteduser");
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
    public final void init(FilterConfig fConfig) throws ServletException {
    }

}
