package fr.imie.formation.jdbc.dto;

import java.util.Date;

/** Represents an Usager stored in DAO.
 * @author Florent RICHARD
 */
public class DtoUsager {
    /** Id of usager.
     */
    private Integer id = null;
    /** Name of usager.
     */
    private String name = null;
    /** First name of usager.
     */
    private String firstName = null;
    /** Date of Birth of the usager.
     */
    private Date dateBirth = null;
    /** Email adress of the usager.
     */
    private String email = null;
    /** Number of connections realized by the usager.
     */
    private Integer nbConnection = null;
    /** Inscription site.
     */
    private DtoSite inscrSite = null;
    /** Password.
     */
    private String password = null;

    /** Constructor.
     */
    public DtoUsager() {
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

    /** Accessor to the date of birth.
     * @return the dateBirth
     */
    public final Date getDateBirth() {
        return dateBirth;
    }

    /** Mutator for the date of birth.
     * @param uDateBirth the dateBirth to set
     */
    public final void setDateBirth(final Date uDateBirth) {
        this.dateBirth = uDateBirth;
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

    /** Accessor to the inscription site.
     * @return the inscrSite
     */
    public final DtoSite getInscrSite() {
        return inscrSite;
    }

    /** Mutator for the inscription site.
     * @param uInscrSite the inscrSite to set
     */
    public final void setInscrSite(final DtoSite uInscrSite) {
        this.inscrSite = uInscrSite;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
