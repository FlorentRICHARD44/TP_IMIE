package fr.imie.formation.servlet.listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class VisitorsListener
 *
 */
@WebListener
public class VisitorsListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public VisitorsListener() {
        
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)  { 
        ServletContext context = event.getSession().getServletContext(); 
        if (context.getAttribute("nbvisitors") == null) {
            context.setAttribute("nbvisitors", 0);
        }
        context.setAttribute("nbvisitors", (Integer) context.getAttribute("nbvisitors") + 1);
        
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  { 
        ServletContext context = event.getSession().getServletContext();
        if (context.getAttribute("nbvisitors") != null) {
            context.setAttribute("nbvisitors", (Integer) context.getAttribute("nbvisitors") - 1);
        }
    }
	
}
