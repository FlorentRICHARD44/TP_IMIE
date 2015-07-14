/**
 * 
 */
package fr.imie.ihm.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import fr.imie.entities.UsagerEntity;


@Named("connecteduserbean")
@SessionScoped
/**
 * @author Florent RICHARD
 *
 */
public class ConnectedUserBean implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -3714031276758630372L;
    /** User connected.
     */
    private UsagerEntity user;
    /** Last user connected.
     */
    private UsagerEntity lastuser;
    /** Asked path URI.
     */
    private String pathURI;
    /** Logout path URI.
     */
    private String logoutPathURI;

    /**
     */
    public ConnectedUserBean() {
        super();
    }
    /**
     * @return the user
     */
    public UsagerEntity getUser() {
        return user;
    }
    /**
     * @param user the user to set
     */
    public void setUser(UsagerEntity user) {
        this.user = user;
    }
    /**
     * @return the lastuser
     */
    public UsagerEntity getLastuser() {
        return lastuser;
    }
    /**
     * @param lastuser the lastuser to set
     */
    public void setLastuser(UsagerEntity lastuser) {
        this.lastuser = lastuser;
    }
    /**
     * @return the pathURI
     */
    public String getPathURI() {
        return pathURI;
    }
    /**
     * @param pathURI the pathURI to set
     */
    public void setPathURI(String pathURI) {
        this.pathURI = pathURI;
    }
    /**
     * @return the logoutPathURI
     */
    public String getLogoutPathURI() {
        return logoutPathURI;
    }
    /**
     * @param logoutPathURI the logoutPathURI to set
     */
    public void setLogoutPathURI(String logoutPathURI) {
        this.logoutPathURI = logoutPathURI;
    }
}
