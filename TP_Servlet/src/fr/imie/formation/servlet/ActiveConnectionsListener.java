package fr.imie.formation.servlet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ActiveConnectionsListener
 *
 */
@WebListener
public class ActiveConnectionsListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ActiveConnectionsListener() {
        
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)  { 
        ServletContext context = event.getSession().getServletContext(); 
        if (context.getAttribute("nbconnections") == null) {
            context.setAttribute("nbconnections", 0);
        }
        context.setAttribute("nbconnections", (Integer) context.getAttribute("nbconnections") + 1);
        
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  { 
        ServletContext context = event.getSession().getServletContext();
        if (context.getAttribute("nbconnections") != null) {
            context.setAttribute("nbconnections", (Integer) context.getAttribute("nbconnections") - 1);
        }
    }
	
}
