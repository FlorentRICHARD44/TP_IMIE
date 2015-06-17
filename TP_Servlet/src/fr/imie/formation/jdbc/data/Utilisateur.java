package fr.imie.formation.jdbc.data;


/** Class represents an Utilisateur.
 * @author Florent RICHARD
 */
public class Utilisateur {
    /** Id of utilisateur.
     */
    private Integer id;
    /** Name of utilisateur.
     */
    private String name;
    /** First name of utilisateur.
     */
    private String firstName;
    /** Login of the utilisateur.
     */
    private String login;
    /** Password of the utilisateur.
     */
    private String password;
    /** Email adress of the utilisateur.
     */
    private String email = null;
    /** Number of connections realized by the utilisateur.
     */
    private Integer nbConnection = 0;
    /** Attachment site.
     */
    private Site attachementSite;

    /** Constructor.
     */
    public Utilisateur() {
    }

    /** Return the salutation done by the utilisateur.
     * @return Salutation.
     */
    public final String pres() {
        return String.format("Bonjour, je m'appelle %s %s", firstName, name);
    }

    /** Accessor to the id.
     * @return the id
     */
    public final Integer getId() {
        return id;
    }

    /** Mutator for the id.
     * @param uId the id to set
     */
    public final void setId(final Integer uId) {
        this.id = uId;
    }

    /** Accessor to the name.
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /** Mutator for the name.
     * @param uName the name to set
     */
    public final void setName(final String uName) {
        this.name = uName;
    }

    /** Accessor to the first name.
     * @return the firstName
     */
    public final String getFirstName() {
        return firstName;
    }

    /** Mutator for the first name.
     * @param uFirstName the firstName to set
     */
    public final void setFirstName(final String uFirstName) {
        this.firstName = uFirstName;
    }

    /** Accessor to the email.
     * @return the email
     */
    public final String getEmail() {
        return email;
    }

    /** Mutator for the email.
     * @param uEmail the email to set
     */
    public final void setEmail(final String uEmail) {
        this.email = uEmail;
    }

    /** Accessor to the number of connection.
     * @return the nbConnection
     */
    public final Integer getNbConnection() {
        return nbConnection;
    }

    /** Mutator for the number of connection.
     * @param uNbConnection the nbConnection to set
     */
    public final void setNbConnection(final Integer uNbConnection) {
        this.nbConnection = uNbConnection;
    }

    /** Accessor to the attachement site.
     * @return the attachementSite
     */
    public final Site getAttachementSite() {
        return attachementSite;
    }

    /** Mutator for the attachement site.
     * @param uAttachementSite the attachementSite to set
     */
    public final void setInscrSite(final Site uAttachementSite) {
        this.attachementSite = uAttachementSite;
    }

    /**
     * @return the login
     */
    public final String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public final void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public final String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public final void setPassword(String password) {
        this.password = password;

    }
}
