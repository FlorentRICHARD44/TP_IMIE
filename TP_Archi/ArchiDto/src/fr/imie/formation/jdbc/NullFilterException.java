package fr.imie.formation.jdbc;

/** Exception raised when a Filter has no parameter.
 * @author Florent RICHARD
 */
public class NullFilterException extends Exception {

    /** Serial Version UID.
     */
    private static final long serialVersionUID = -5542028225087909416L;

    /**
     * 
     */
    public NullFilterException() {
        super();
    }

    /**
     * @param message
     */
    public NullFilterException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public NullFilterException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public NullFilterException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public NullFilterException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
