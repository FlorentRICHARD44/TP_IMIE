package fr.imie.formation.jdbc.dto;

import java.util.Date;

/** Represents an Usager.
 * @author Florent RICHARD
 */
public class DtoUsager {
    /** Id of usager.
     */
    private Integer id;
    /** Name of usager.
     */
    private String name;
    /** First name of usager.
     */
    private String firstName;
    /** Date of Birth of the usager.
     */
    private Date dateBirth = null;
    /** Email adress of the usager.
     */
    private String email = null;
    /** Number of connections realized by the usager.
     */
    private Integer nbConnection = 0;

    /** Constructor.
     */
    public DtoUsager() {
    }

    /**
     * @return the id
     */
    public final Integer getId() {
        return id;
    }

    /**
     * @param uId the id to set
     */
    public final void setId(final Integer uId) {
        this.id = uId;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param uName the name to set
     */
    public final void setName(final String uName) {
        this.name = uName;
    }

    /**
     * @return the firstName
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * @param uFirstName the firstName to set
     */
    public final void setFirstName(final String uFirstName) {
        this.firstName = uFirstName;
    }

    /**
     * @return the dateBirth
     */
    public final Date getDateBirth() {
        return dateBirth;
    }

    /**
     * @param uDateBirth the dateBirth to set
     */
    public final void setDateBirth(final Date uDateBirth) {
        this.dateBirth = uDateBirth;
    }

    /**
     * @return the email
     */
    public final String getEmail() {
        return email;
    }

    /**
     * @param uEmail the email to set
     */
    public final void setEmail(final String uEmail) {
        this.email = uEmail;
    }

    /**
     * @return the nbConnection
     */
    public final Integer getNbConnection() {
        return nbConnection;
    }

    /**
     * @param uNbConnection the nbConnection to set
     */
    public final void setNbConnection(final Integer uNbConnection) {
        this.nbConnection = uNbConnection;
    }
}
