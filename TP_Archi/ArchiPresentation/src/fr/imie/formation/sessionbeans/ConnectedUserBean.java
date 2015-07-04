package fr.imie.formation.sessionbeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import fr.imie.formation.jdbc.data.Usager;

/** Bean to store the user connected in the session.
 * @author Florent RICHARD
 */
@Named("connecteduserbean")
@SessionScoped
public class ConnectedUserBean implements Serializable {

    /**
     */
    private static final long serialVersionUID = -7910938580110834568L;
    /** User connected.
     */
    private Usager user;
    /** Last user connected.
     */
    private Usager lastuser;
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
    public Usager getUser() {
        return user;
    }
    /**
     * @param user the user to set
     */
    public void setUser(Usager user) {
        this.user = user;
    }
    /**
     * @return the lastuser
     */
    public Usager getLastuser() {
        return lastuser;
    }
    /**
     * @param lastuser the lastuser to set
     */
    public void setLastuser(Usager lastuser) {
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
