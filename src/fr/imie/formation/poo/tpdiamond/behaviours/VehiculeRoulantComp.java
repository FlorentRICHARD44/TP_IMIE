package fr.imie.formation.poo.tpdiamond.behaviours;

import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeRoulant;


/** Describes the behaviour of a Vehicule Roulant.
 * @author Florent RICHARD
 *
 */
public class VehiculeRoulantComp extends VehiculeComp {
    /** Vehicule used.
     */
    private IVehiculeRoulant vehicule;

    /** Constructor.
     * @param veh Vehicule used for the behaviour.
     */
    public VehiculeRoulantComp(
            final IVehiculeRoulant veh) {
        super(veh);
        this.vehicule = veh;
    }

    /** Perform the progression of a Vehicule Roulant.
     * @param vehRoul Vehicule Roulant to move.
     */
    public final void avancer(final IVehiculeRoulant vehRoul) {
        System.out.format("+1 meter on the counter for vehicule %s\n",
                          vehicule.getName());
    }
}
