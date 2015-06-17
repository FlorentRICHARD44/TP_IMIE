/**
 * 
 */
package fr.imie.formation.jdbc.dao;

/** Class used for Error during Configuration of DAO.
 * @author Florent RICHARD
 *
 */
public class DAOConfigurationException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -1734033839669163102L;

    /**
     * 
     */
    public DAOConfigurationException() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public DAOConfigurationException(String arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public DAOConfigurationException(Throwable arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     * @param arg1
     */
    public DAOConfigurationException(String arg0, Throwable arg1) {
        super(arg0, arg1);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     */
    public DAOConfigurationException(String arg0, Throwable arg1, boolean arg2,
            boolean arg3) {
        super(arg0, arg1, arg2, arg3);
        // TODO Auto-generated constructor stub
    }

}
