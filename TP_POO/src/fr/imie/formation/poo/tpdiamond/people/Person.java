package fr.imie.formation.poo.tpdiamond.people;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/** Describes a Person.
 * @author Florent RICHARD
 */
public class Person {
    /** Name of the person.
     */
    private String name;
    /** First Name of the person.
     */
    private String firstName;
    /** Date of birth.
     */
    private Date dateBirth = null;

    /** Constructor.
     */
    public Person() {
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param pName the name to set
     */
    public final void setName(final String pName) {
        this.name = pName;
    }

    /**
     * @return the firstName
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * @param pFirstName the firstName to set
     */
    public final void setFirstName(final String pFirstName) {
        this.firstName = pFirstName;
    }

    /**
     * @return the dateBirth
     */
    public final Date getDateBirth() {
        return dateBirth;
    }

    /**
     * @param pDateBirth the dateBirth to set
     */
    public final void setDateBirth(final Date pDateBirth) {
        this.dateBirth = pDateBirth;
    }

    /** Gets the age of the person.
     * @return Age in years.
     */
    public final Integer getAge() {
        long diff = (new Date()).getTime() - dateBirth.getTime();
        double year = TimeUnit.MILLISECONDS.toDays(diff) / 365.25;
        return new Integer((int) year);
    }
}
