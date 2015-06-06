package fr.imie.formation.poo.tpdiamond.ifs;

import java.util.List;

import fr.imie.formation.poo.tpdiamond.VehiculeMarque;
import fr.imie.formation.poo.tpdiamond.people.Driver;
import fr.imie.formation.poo.tpdiamond.people.Person;

/** Interface defining elements for a Vehicule.
 * @author Florent RICHARD
 */
public interface IVehicule {
    /** Put the vehicule to the casse.
     * Used when the vehicule can't be used (broken or too old).
     */
    void mettreCasse();

    /** Getter for the Name of the Vehicule.
     * @return name.
     */
    String getName();

    /** Setter for the Name of the vehicule.
     * @param name Name of the vehicule.
     */
    void setName(final String name);

    /** Getter for the Mark of the Vehicule.
     * @return mark
     */
    VehiculeMarque getMark();

    /** Setter for the Mark of the vehicule.
     * @param mark Mark of the vehicule.
     */
    void setMark(final VehiculeMarque mark);

    /** Get the Driver of the vehicule.
     * @return Driver of vehicule.
     */
    Driver getDriver();

    /** Sets the driver of the vehicule.
     * @param driver Driver of the vehicule.
     */
    void setDriver(Driver driver);

    /** Get the list of passengers.
     * @return List of passengers.
     */
    List<Person> getPassengers();

    /** Sets the list of passengers.
     * @param listPassengers List of passengers.
     */
    void setPassengers(List<Person> listPassengers);

    /** Add a passenger into the vehicule.
     * @param passenger Passenger to add.
     */
    void addPassenger(Person passenger);

    /** Remove a passenger from the vehicule.
     * @param passenger Passenger to remove.
     */
    void removePassenger(Person passenger);
}
