package fr.imie.formation.sessionbeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.servlet.applibeans.OpenConnectionsBean;

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
}
