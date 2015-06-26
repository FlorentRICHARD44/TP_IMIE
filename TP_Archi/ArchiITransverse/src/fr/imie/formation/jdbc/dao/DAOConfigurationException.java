package fr.imie.formation.jdbc.dao;

/** Class used for Error during Configuration of DAO.
 * @author Florent RICHARD
 *
 */
public class DAOConfigurationException extends Exception {

    /** Serial Version UID.
     */
    private static final long serialVersionUID = -1734033839669163102L;

    /** Constructor.
     */
    public DAOConfigurationException() {
        super();
    }

    /**
     * @param arg0
     */
    public DAOConfigurationException(final String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public DAOConfigurationException(final Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public DAOConfigurationException(final String arg0, final Throwable arg1) {
        super(arg0, arg1);
    }

    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     */
    public DAOConfigurationException(final String arg0, final Throwable arg1, final boolean arg2,
            final boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }
}
