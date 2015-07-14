package fr.imie.ihm.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Florent RICHARD
 *
 */
@Named("requestheaderbean")
@RequestScoped
public class RequestHeaderBean implements Serializable {

    /**
     */
    private static final long serialVersionUID = 836616137975553512L;
    /** Current request.
     */
    @Inject private HttpServletRequest request;

    /**
     */
    public RequestHeaderBean() {
        super();
    }

    /** Get the language set as first lang in the navigator.
     * @return Lang of navigator.
     */
    public String getLang() {
        return request.getLocale().getLanguage();
    }

    /** Get the name of the user agent.
     * @return user agent.
     */
    public String getUserAgent() {
        return request.getHeader("user-agent");
    }
    
    public String getReferer() {
        return request.getHeader("Referer");
    }
}
