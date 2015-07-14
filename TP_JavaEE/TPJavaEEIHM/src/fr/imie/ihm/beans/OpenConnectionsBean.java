/**
 * 
 */
package fr.imie.ihm.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("openconnectionsbean")
/**
 * @author Florent RICHARD
 *
 */
public class OpenConnectionsBean {
    /** Logged users.
     */
    private Integer loggedUsers = 0;
    /** Visitors.
     */
    private Integer visitors = 0;

    /**
     */
    public OpenConnectionsBean() {
        super();
    }

    /** Count one user logged less.
     */
    public void removeUser() {
        loggedUsers--;
    }

    /** Count one user logged more.
     */
    public void addUser() {
        loggedUsers++;
    }

    /** Count one user logged less.
     */
    public void removeVisitor() {
        visitors--;
    }

    /** Count one user logged more.
     */
    public void addVisitor() {
        visitors++;
    }

    /** Return the number of logged users in the site.
     * @return number of logged users.
     */
    public Integer getLoggedUsers() {
        return loggedUsers;
    }

    /** Return the number of visitors in the site.
     * @return Number of visitors.
     */
    public Integer getVisitors() {
        return visitors;
    }
}
