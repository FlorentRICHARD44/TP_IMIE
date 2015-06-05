package fr.imie.formation.poo.tpdiamond.behaviours;

import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeGlissant;

/** Describes the behaviour of a Vehicule Glissant.
 * @author Florent RICHARD
 */
public class VehiculeGlissantComp extends VehiculeComp {
    /** Vehicule used.
     */
    private IVehiculeGlissant vehicule;

    /** Constructor.
     * @param veh Vehicule used for the behaviour.
     */
    public VehiculeGlissantComp(final IVehiculeGlissant veh) {
        super(veh);
        this.vehicule = veh;
    }

    /** Realize the progression of a vehicule glissant.
     * @param veh Vehicule for which to realize the progression.
     */
    public final void avancer(final IVehiculeGlissant veh) {
        System.out.format("+1 metre en glissant pour %s\n", vehicule.getName());
    }
}
