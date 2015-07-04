package fr.imie.formation.sessionbeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import fr.imie.formation.jdbc.data.Site;


/**
 * @author Florent RICHARD
 *
 */
@Named("sitebean")
@SessionScoped
public class SiteBean implements Serializable {

    /** Serial Version UID.
     */
    private static final long serialVersionUID = 1480878084123658217L;
    /** Site used.
     */
    private Site site;
    /**
     */
    public SiteBean() {
        super();
    }
    /**
     * @return the site
     */
    public Site getSite() {
        return site;
    }
    /**
     * @param site the site to set
     */
    public void setSite(Site site) {
        this.site = site;
    }
}
