package fr.imie.formation.poo.tpdiamond.behaviours;

import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeRoulant;


/** Describes the behaviour of a Vehicule Roulant.
 * @author Florent RICHARD
 *
 */
public class VehiculeRoulantComp extends VehiculeComp {
    /** Perform the progression of a Vehicule Roulant.
     * @param vehRoul Vehicule Roulant to move.
     */
    public final void avancer(final IVehiculeRoulant vehRoul) {
        System.out.println("+1 meter on the counter");
    }
}
