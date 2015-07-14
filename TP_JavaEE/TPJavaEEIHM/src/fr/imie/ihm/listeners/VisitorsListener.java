package fr.imie.ihm.listeners;

import javax.inject.Inject;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.imie.ihm.beans.ConnectedUserBean;
import fr.imie.ihm.beans.OpenConnectionsBean;

/** Listener to count the number of visitors (actives sessions).
 * Application Lifecycle Listener implementation class VisitorsListener
 *
 */
@WebListener
public class VisitorsListener implements HttpSessionListener {


    /** Bean for visitors.
     */
    @Inject private OpenConnectionsBean openconnectionsbean;
    /** Bean for connected user.
     */
    @Inject private ConnectedUserBean connectedUserBean;

    /** Default constructor.
     */
    public VisitorsListener() {
        super();
    }

    /**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public final void sessionCreated(HttpSessionEvent event) {
        openconnectionsbean.addVisitor();
    }

    /**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public final void sessionDestroyed(HttpSessionEvent event) {
        if (connectedUserBean.getUser() != null) {
            connectedUserBean.setUser(null);
            openconnectionsbean.removeUser();
        }
        openconnectionsbean.removeVisitor();
    }
}
