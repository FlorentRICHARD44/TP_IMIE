package fr.imie.formation.poo.tpdiamond.ifs;

import fr.imie.formation.poo.tpdiamond.VehiculeMarque;

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
}
