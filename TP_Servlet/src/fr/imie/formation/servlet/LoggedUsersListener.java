package fr.imie.formation.servlet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class LoggedUsersListener
 *
 */
@WebListener
public class LoggedUsersListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public LoggedUsersListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  {
        if (event.getName().equals("userconnected")) {
            ServletContext context = event.getSession().getServletContext(); 
            if (context.getAttribute("nbloggedusers") == null) {
                context.setAttribute("nbloggedusers", 0);
            }
            context.setAttribute("nbloggedusers", (Integer) context.getAttribute("nbloggedusers") + 1);
        }
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
        if (event.getName().equals("userconnected")) {
            ServletContext context = event.getSession().getServletContext();
            if (context.getAttribute("nbloggedusers") != null) {
                context.setAttribute("nbloggedusers", (Integer) context.getAttribute("nbloggedusers") - 1);
            }
        }
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
