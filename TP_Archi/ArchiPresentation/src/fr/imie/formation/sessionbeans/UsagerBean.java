package fr.imie.formation.sessionbeans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import fr.imie.formation.jdbc.data.Usager;

/** Bean to store usager elements for views.
 * @author Florent RICHARD
 */
@Named("usagerbean")
@SessionScoped
public class UsagerBean implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1874175541484593089L;
    /** User for usager view.
     */
    private Usager usager;
    /** List of users for view.
     */
    private List<Usager> usagerlist;
    /**
     */
    public UsagerBean() {
        super();
    }
    /**
     * @return the usager
     */
    public Usager getUser() {
        return usager;
    }
    /**
     * @param user the usager to set
     */
    public void setUser(Usager user) {
        this.usager = user;
    }
    /**
     * @return the usagerlist
     */
    public List<Usager> getUserlist() {
        return usagerlist;
    }
    /**
     * @param userlist the usagerlist to set
     */
    public void setUserlist(List<Usager> userlist) {
        this.usagerlist = userlist;
    }

}
