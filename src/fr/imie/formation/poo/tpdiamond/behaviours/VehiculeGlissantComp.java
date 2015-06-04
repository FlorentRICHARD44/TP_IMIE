package fr.imie.formation.poo.tpdiamond.behaviours;

import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeGlissant;

/** Describes the behaviour of a Vehicule Glissant.
 * @author Florent RICHARD
 */
public class VehiculeGlissantComp extends VehiculeComp {
    /** Realize the progression of a vehicule glissant.
     * @param veh Vehicule for which to realize the progression.
     */
    public final void avancer(final IVehiculeGlissant veh) {
        System.out.println("+1 metre en glissant");
    }
}
