package fr.imie.formation.poo.tpdiamond.people;

import java.util.Date;

/** Describes a Person who have driving licence.
 * @author Florent RICHARD
 */
public class Driver extends Person {
    /** Number of the driving licence.
     */
    private String drivingLicenceRef;
    /** Date of obtention of driving licence.
     */
    private Date drivingLicenceDate;

    /** Constructor.
     */
    public Driver() {
    }

    /**
     * @return the drivingLicenceRef
     */
    public final String getDrivingLicenceRef() {
        return drivingLicenceRef;
    }

    /**
     * @param dDrivingLicenceRef the drivingLicenceRef to set
     */
    public final void setDrivingLicenceRef(final String dDrivingLicenceRef) {
        this.drivingLicenceRef = dDrivingLicenceRef;
    }

    /**
     * @return the drivingLicenceDate
     */
    public final Date getDrivingLicenceDate() {
        return drivingLicenceDate;
    }

    /**
     * @param dDrivingLicenceDate the drivingLicenceDate to set
     */
    public final void setDrivingLicenceDate(final Date dDrivingLicenceDate) {
        this.drivingLicenceDate = dDrivingLicenceDate;
    }

}
