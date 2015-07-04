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

/** Filter to get the lang defined by the navigator and apply it on all pages.
 * Servlet Filter implementation class LangFilter
 */
@WebFilter("/*")
public class LangFilter implements Filter {

    /**
     * Default constructor.
     */
    public LangFilter() {
        super();
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // Not used.
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public final void doFilter(ServletRequest request,
                               ServletResponse response,
                               FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        req.setAttribute("lang", (String) req.getLocale().getLanguage());

        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // not used.
    }
}
