package fr.imie.formation.servlet.listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/** Counts the number of Usager logged in the website.
 * Application Lifecycle Listener implementation class LoggedUsersListener
 */
@WebListener
public class LoggedUsersListener implements HttpSessionAttributeListener {

    /** Default constructor.
     */
    public LoggedUsersListener() {
        super();
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public final void attributeAdded(HttpSessionBindingEvent event)  {
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
    public final void attributeRemoved(HttpSessionBindingEvent event) {
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
    public final void attributeReplaced(HttpSessionBindingEvent arg0) {
         // Not used.
    }
}
