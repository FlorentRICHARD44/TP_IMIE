/**
 * 
 */
package fr.imie.formation.servlet.reqbeans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/** Bean to store error for a view.
 * @author Florent RICHARD
 */
@Named("reqerrorbean")
@RequestScoped
public class RequestErrorBean implements Serializable {

    /** Serial Version UID.
     */
    private static final long serialVersionUID = -3438789599567519945L;
    /** Error name.
     */
    private String error;

    /**
     */
    public RequestErrorBean() {
        super();
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }
}
